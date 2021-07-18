/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import CLASES.funcionario;
import CLASES.horarios;
import GUI.main;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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

        try {
            Date compararhora1;
            Date compararhora2;
            String stringtemporal, stringtempora2 = "", stringtemporal3 = "";
            Date horasdate;
            Date horasdate2;
            String dia = "";
            String horainicio;
            String horafin = "";
            Date x = new Date();
            int difereciaenminutos;
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
                            horasdate = formatoDelTexto.parse(horainicio); //HORA DEL FUNCIONARIO
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
                                    System.out.println("DIFERENCIA DE LLEGADA DE La hora:" + stringtemporal3 + "es de" + Difenminutos2 + "minutos");
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
}
