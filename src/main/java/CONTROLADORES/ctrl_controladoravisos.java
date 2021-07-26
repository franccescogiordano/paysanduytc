/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import CLASES.carnets;
import CLASES.funcionario;
import GUI.addcargo;
import GUI.funcionariosvencidos;
import GUI.main;
import static GUI.main.jDesktopPane1;
import GUI.renovarcarnet;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
}
