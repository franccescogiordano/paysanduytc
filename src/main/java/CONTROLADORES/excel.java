/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import CLASES.funcionario;
import CLASES.horarios;
import GUI.controlarllegastarde;
import GUI.main;
import GUI.tabladehorarios;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author franc
 */
public class excel {

    Cell celda;
    Workbook wb;
    HSSFWorkbook wbxls;
    controladorfuncionario CF = new controladorfuncionario();

    public String procesarexcel(File archivo) {
        DefaultTableModel md2 = (DefaultTableModel) controlarllegastarde.jTable1.getModel();
        md2.setRowCount(0);
        try {

            String stringtemporal, stringtempora2 = "", stringtemporal3 = "";
            Date horasdate;
            Date horasdate2;
            String dia = "";
            String horainicio;
            String horafin = "";
            Date x = new Date();

            if (archivo.getName().endsWith("xlsx")) {
                wb = WorkbookFactory.create(new FileInputStream(archivo));
                Sheet hoja = wb.getSheetAt(0);
                int limite = hoja.getPhysicalNumberOfRows();
                for (int i = 1; i < limite; i++) {

                    celda = hoja.getRow(i).getCell(1);
                    String nombre = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(3);
                    String fecha = celda.getStringCellValue();
                    // System.out.println(" " + nombre + " " + fecha);
                    funcionario funcio;
                    funcio = controladorfuncionario.findfuncionario(nombre);
                    Calendar calendar = Calendar.getInstance();

                    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    SimpleDateFormat formatoDelTexto2;

                    try {

                        x = formatoDelTexto.parse(fecha);
                        calendar.setTime(x);

                    } catch (ParseException ex) {

                        ex.printStackTrace();

                    }
                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                    switch (dayOfWeek) {
                        case 1:
                            dia = "Domingo";
                            break;
                        case 2:
                            dia = "Lunes";
                            break;

                        case 3:
                            dia = "Martes";
                            break;
                        case 4:
                            dia = "Miercoles";
                            break;
                        case 5:
                            dia = "Jueves";
                            break;
                        case 6:
                            dia = "Viernes";
                            break;
                        case 7:
                            dia = "Sabado";
                            break;
                        default:
                    }
                    Iterator<horarios> it = funcio.getHorariosdelfuncionario().iterator();
                    while (it.hasNext()) {
                        long diferencia;
                        horarios next = it.next();
                        if (next.getDia().equals(dia)) {
                            horainicio = next.getHoracomienzo();
                            horafin = next.getHorafin();
                            //verificar llegada tarde
                            formatoDelTexto = new SimpleDateFormat("HH:mm");
                            formatoDelTexto2 = new SimpleDateFormat("HH");
                            horasdate = formatoDelTexto2.parse(horainicio); //HORA DEL FUNCIONARIO
                            stringtemporal3 = formatoDelTexto.format(horasdate);
                            horasdate = formatoDelTexto.parse(stringtemporal3);
                            SimpleDateFormat ParaSaberLaHoraInicio = new SimpleDateFormat("HH");

                            stringtempora2 = ParaSaberLaHoraInicio.format(x);
                            stringtemporal = formatoDelTexto.format(x);
                            stringtemporal3 = ParaSaberLaHoraInicio.format(horasdate);
                            horasdate2 = formatoDelTexto.parse(stringtemporal);
                            diferencia = horasdate2.getTime() - horasdate.getTime();
                            long Difenminutos2;
                            if (stringtemporal3.equals(stringtempora2)) {
                                Difenminutos2 = diferencia / (60 * 1000);
                                if (Difenminutos2 > 0) {
                                    Object[] fila = new Object[3];
                                    fila[0] = nombre;
                                    fila[1] = cambiarformatofecha(x);
                                    fila[2] = Difenminutos2 + " minutos";
                                    md2.addRow(fila);
//    System.out.println("DIFERENCIA DE LLEGADA DE La hora:" + stringtemporal3 + "es de" + Difenminutos2 + "minutos");
                                }
                            }
                        }
                    }
                }
            } else {
                HSSFCell celdax;
                wbxls = new HSSFWorkbook(new FileInputStream(archivo));
                HSSFSheet hoja = wbxls.getSheetAt(0);
                int limite = hoja.getPhysicalNumberOfRows();
                for (int i = 1; i < limite; i++) {

                    celdax = hoja.getRow(i).getCell(1);
                    String nombre = celdax.getStringCellValue();
                    celdax = hoja.getRow(i).getCell(3);
                    String fecha = celdax.getStringCellValue();
                    System.out.println(" " + nombre + " " + fecha);

                }

            }
        } catch (Exception e) {
            return null;
        }
        return "buenardo";

    }

    public String procesarexcel2(File archivo) {
        DefaultTableModel md2 = (DefaultTableModel) tabladehorarios.TablaDatos.getModel();
        md2.setRowCount(0);
        try {

            String lunes;
            String martes = "";
            String jueves = "";
            String miercoles = "";
            String viernes = "";
            String sabado = "";
            String domingo = "";
            String ocuplunes = "";
            String ocupmartes = "";
            String ocupmiercoles = "";
            String ocupjueves = "";
            String ocupviernes = "";
            String ocupsabado = "";
            String ocupdomingo = "";

            if (archivo.getName().endsWith("xlsx")) {
                wb = WorkbookFactory.create(new FileInputStream(archivo));
                Sheet hoja = wb.getSheetAt(0);
                int limite = hoja.getPhysicalNumberOfRows();
                for (int i = 2; i < limite; i++) {

                    celda = hoja.getRow(i).getCell(0);
                    String nombre = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(1);
                    lunes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(2);
                    ocuplunes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(3);
                    martes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(4);
                    ocupmartes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(5);
                    miercoles = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(6);
                    ocupmiercoles = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(7);
                    jueves = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(8);
                    ocupjueves = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(9);
                    viernes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(10);
                    ocupviernes = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(11);
                    sabado = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(12);
                    ocupsabado = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(13);
                    domingo = celda.getStringCellValue();
                    celda = hoja.getRow(i).getCell(14);
                    ocupdomingo = celda.getStringCellValue();
                    Object[] fila = new Object[15];
                    fila[0] = nombre;
                    fila[1] = lunes;
                    fila[2] = ocuplunes;
                    fila[3] = martes;
                    fila[4] = ocupmartes;
                    fila[5] = miercoles;
                    fila[6] = ocupmiercoles;
                    fila[7] = jueves;
                    fila[8] = ocupjueves;
                    fila[9] = viernes;
                    fila[10] = ocupviernes;
                    fila[11] = sabado;
                    fila[12] = ocupsabado;
                    fila[13] = domingo;
                    fila[14] = ocupdomingo;
                    md2.addRow(fila);
                }

            } else {
                HSSFCell celdax;
                wbxls = new HSSFWorkbook(new FileInputStream(archivo));
                HSSFSheet hoja = wbxls.getSheetAt(0);
                int limite = hoja.getPhysicalNumberOfRows();
                for (int i = 1; i < limite; i++) {

                    celdax = hoja.getRow(i).getCell(1);
                    String nombre = celdax.getStringCellValue();
                    celdax = hoja.getRow(i).getCell(3);
                    String fecha = celdax.getStringCellValue();
                    System.out.println(" " + nombre + " " + fecha);

                }

            }
        } catch (Exception e) {
            return null;
        }
        return "buenardo";

    }

    public String cambiarformatofecha(Date x) {
        SimpleDateFormat porlasdudas = new SimpleDateFormat("'El' EEEE dd 'de' MM 'del' yyyy");
        return porlasdudas.format(x);
    }
}
