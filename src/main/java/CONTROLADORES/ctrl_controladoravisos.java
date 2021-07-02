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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public class ctrl_controladoravisos {

    public void avisarcarnevencido(List<funcionario> funciolist) {
        main.funcionariosconcarnetporvencer.clear();
        main.funcionariosconcarnetvencido.clear();
        Date hoy = new Date(System.currentTimeMillis());
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.add(Calendar.DAY_OF_YEAR, 10);
        Date fin = calendario.getTime();
        //    Date paradiff=new Date();
        //   dt1.format(hoy);
        System.out.println(hoy);
        Iterator<funcionario> it = funciolist.iterator();
        while (it.hasNext()) {
            funcionario p = it.next();
            Iterator<carnets> it2 = p.getCarnetsdelfuncionario().iterator();
            while (it2.hasNext()) {
                carnets x = it2.next();
 //fecha de hoy antes de fehca de vencimiento y despues de hoy
                if(x.getFechavencimiento().after(new Date()) && x.getFechavencimiento().before(fin)){
                    main.funcionariosconcarnetporvencer.add(x);
                }else if(x.getFechavencimiento().before(new Date())){
                     main.funcionariosconcarnetvencido.add(x);
                }
                //    paraconvetir=x.getFechavencimiento();
                //     String fechaxd=dt2.format(paraconvetir);
                //    paradiff=dt2.parse(fechaxd);
                //  int days = Days.daysBetween(hoy, x.getFechavencimiento()).getDays();
                //long diffInMillies = Math.abs(x.getFechavencimiento().getTime()- hoy.getTime() );
                //  System.out.println(x.getFechavencimiento());
                //   long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);    
                /*  if(diff<=10 && diff>0){
                   main.funcionariosconcarnetporvencer.add(x);
                }else if(diff<=0){
                    main.funcionariosconcarnetvencido.add(x);
                }*/
            }
            if (!main.funcionariosconcarnetvencido.isEmpty()) {
                funcionariosvencidos.cargartablavencidos();
            }
            if (!main.funcionariosconcarnetporvencer.isEmpty()) {
                funcionariosvencidos.cargartablaporvencer();
            }

        }

//    public void cargartabla() {
//        DefaultTableModel md1 = (DefaultTableModel) jTable1.getModel();
//        md1.setRowCount(0);
//        Iterator<producto> it = productosSinStock.iterator();
//        while (it.hasNext()) {
//            producto next = it.next();
//            Object[] fila = new Object[1];
//            fila[0] = next;
//            md1.addRow(fila);
//        }
//        //jTable1.setModel(md1);
//    }
    }
}
