/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import CLASES.carnets;
import CLASES.funcionario;
import GUI.addcargo;
import static GUI.administrarfuncionarios.getCalendar;
import GUI.funcionariosvencidos;
import GUI.main;
import static GUI.main.jDesktopPane1;
import GUI.renovarcarnet;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public class ctrl_controladoravisos {

    public Icon icono = new ImageIcon(getClass().getResource("/META-INF/check.png"));

    public void avisarcarnevencido(List<funcionario> funciolist) {
        main.funcionariosconcarnetporvencer.clear();
        main.funcionariosconcarnetvencido.clear();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.add(Calendar.DAY_OF_YEAR, 10);
        Date fin = calendario.getTime();
        //    Date paradiff=new Date();
        //   dt1.format(hoy);
        Iterator<funcionario> it = funciolist.iterator();
        while (it.hasNext()) {
            funcionario p = it.next();
            Iterator<carnets> it2 = p.getCarnetsdelfuncionario().iterator();
            if (!p.isEliminado()) {
                while (it2.hasNext()) {
                    carnets x = it2.next();

                    if (x.getFechavencimiento().after(new Date()) && x.getFechavencimiento().before(fin)) {
                        main.funcionariosconcarnetporvencer.add(x);
                        x.setEstado("PorVencer");
                    } else if (x.getFechavencimiento().before(new Date())) {
                        x.setEstado("Vencido");
                        main.funcionariosconcarnetvencido.add(x);
                    }

                }
                if (!main.funcionariosconcarnetvencido.isEmpty()) {
                    funcionariosvencidos.cargartablavencidos();
                }
                if (!main.funcionariosconcarnetporvencer.isEmpty()) {
                    funcionariosvencidos.cargartablaporvencer();
                }

            }
        }
    }

    public void avisarcumpleaños(List<funcionario> funciolist) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.add(Calendar.DAY_OF_YEAR, 10);
        Date fin = calendario.getTime();
        DefaultListModel modelo = new DefaultListModel();
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM");

        if (main.jList1Cumpleanitos.getModel().getSize() != 0) {
            /*SI TIENE TELEFONOS AGREGADOS*/
            modelo = (DefaultListModel) main.jList1Cumpleanitos.getModel();
            modelo.clear();
        }

        Iterator<funcionario> it = funciolist.iterator();
        while (it.hasNext()) {
            funcionario p = it.next();
            if (!p.isEliminado()) {
                if (p.getFechaNacimiento().after(new Date()) && p.getFechaNacimiento().before(fin)) {

                    modelo.addElement(p + " " + p.getApellido() + " Fecha cumpleaños:" + dt1.format(p.getFechaNacimiento()));
                    main.jList1Cumpleanitos.setModel(modelo);

                }
            }
        }
    }

    public void carteldeok() {
        JLabel label = new JLabel();
        label.setText("Horarios Cargados correctamente");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, null, JOptionPane.OK_OPTION, icono);
    }

    public void carteldeok2(String mensaje) {
        JLabel label = new JLabel();
        label.setText(mensaje);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null, label, null, JOptionPane.OK_OPTION, icono);
    }

    public int calcularantiguedad(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH)
                || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public void calcularycargardiasfunc() {
        Iterator<funcionario> it = main.funcionarios.iterator();
        while (it.hasNext()) {
            funcionario next = it.next();
            if (next.getUltimafechadecomprobacion() == null) {
                int diasactuales = next.getDays4year();
                int twenty = 20;
                int antiguedad = calcularantiguedad(next.getFechaIngreso(), new Date());
                if (antiguedad >= 5) {
                    twenty++;
                    if (antiguedad == 5) {
                        //nada bye
                    } else {
                        antiguedad--;
                        twenty = twenty + (antiguedad / 4);
                    }
                    next.setDays4year(diasactuales + twenty);
                }else if( antiguedad<5){
                     next.setDays4year(diasactuales + twenty);
                }

            } else {
                if ((calcularantiguedad(next.getUltimafechadecomprobacion(), new Date())) == 1) {
                    int diasactuales = next.getDays4year();
                    int twenty = 20;
                    int antiguedad = calcularantiguedad(next.getFechaIngreso(), new Date());
                    if (antiguedad >= 5) {
                        twenty++;
                        if (antiguedad == 5) {
                            //nada bye
                        } else {
                            antiguedad--;
                            twenty = twenty + (antiguedad / 4);
                        }
                        next.setDays4year(diasactuales + twenty);
                    }  else if( antiguedad<5){
                     next.setDays4year(diasactuales + twenty);
                }

                }
            }

            next.setUltimafechadecomprobacion(new Date());

        }

    }

}
