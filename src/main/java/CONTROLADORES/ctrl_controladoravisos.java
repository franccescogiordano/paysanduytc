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
    public  void avisarcarnevencido(List <funcionario> funciolist){
        Date hoy= new Date();
        Iterator<funcionario> it = funciolist.iterator();
        while (it.hasNext()) {
            funcionario p = it.next();
           Iterator<carnets> it2 = p.getCarnetsdelfuncionario().iterator();
        while (it2.hasNext()) {
            carnets x = it2.next();
           
          //  if((x.getFechavencimiento()-hoy)==0) {
                //     if(x.getFechavencimiento())
              long diffInMillies = Math.abs(hoy.getTime() - x.getFechavencimiento().getTime());  
             long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);    
                if(diff<=10 || diff>0){
                   main.funcionariosconcarnetporvencer.add(x);
                }else if(diff<=0){
                    main.funcionariosconcarnetvencido.add(x);
                }
                
                
          //  } else {
            }
            if(!main.funcionariosconcarnetporvencer.isEmpty()){
                funcionariosvencidos.cargartablavencidos();
            }
            if(!main.funcionariosconcarnetporvencer.isEmpty()){
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
