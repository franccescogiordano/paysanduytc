/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author franc
 */
public class CambiarColorCeldas extends DefaultTableCellRenderer{
       Color verde=new Color(130, 224, 170 );
   Color rojo=new Color(241, 148, 138);
   Color amarillo=new Color(247, 220, 111);
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int col){
        super.getTableCellRendererComponent(table, value, selected, hasFocus, row, col);
        if(table.getValueAt(row, 3).toString().equals("Vigente")){
            setBackground(verde);
            setForeground(Color.BLACK);
        }else if(table.getValueAt(row, 3).toString().equals("Vencido")){
            setBackground(rojo);
            setForeground(Color.BLACK);
        }else{
            setBackground(amarillo);
            setForeground(Color.BLACK);
        }
         if(table.isRowSelected(row)){
          setBackground(Color.BLUE);
    
       }else{
          
         }
        return this;
    }
  
}
