/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLASES.funcionario;
import CLASES.horarios;
import static GUI.administrarfuncionarios.mdl1;
import PERSISTENCIA.CPrincipal;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author franc
 */
public class asignarhorarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form asignarhorarios
     */
      public static boolean activo = false;
       public static funcionario funcionariohorario=null;
       public static  horarios horario= new horarios();
    public asignarhorarios() {
        initComponents();
        activo=true;
        cargartabla();
        cargartablaHORARIOSFUNCIONARIO();
        //jLabel3.setText(funcionariohorario.getNombre());
        
      
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        md1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablehorariosfuncio = new javax.swing.JTable();
        jLabel3Funcionario = new javax.swing.JLabel();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jButton1.setText("Asignar Horario al Funcionario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Quitar Horario del Funcionario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("HORARIOS");

        jLabel2.setText("HORARIOS DEL FUNCIONARIO");

        md1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dia", "Hora Inicio", "Hora Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        md1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                md1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(md1);

        jTablehorariosfuncio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dia", "Hora Inicio", "Hora Fin"
            }
        ));
        jScrollPane3.setViewportView(jTablehorariosfuncio);

        jLabel3Funcionario.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3Funcionario)
                .addGap(90, 90, 90))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(446, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3Funcionario))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargartabla() {
        DefaultTableModel md1 = (DefaultTableModel) asignarhorarios.md1.getModel();
        md1.setRowCount(0);
        Iterator<horarios> it = main.Horarios.iterator();
        while (it.hasNext()) {
            horarios next = it.next();
      //      if (next.isEliminado() != true) {
                //Object[] fila = new Object[5];
                Object[] fila = new Object[3];
                fila[0] = next;
                fila[1] = next.getHoracomienzo();
                fila[2] = next.getHorafin();
                md1.addRow(fila);
                //fila[3] = next.getTelefonos();
                //fila[4] = next.getRepartidores();
                
          //  }
        }
    }
public void cargartablaHORARIOSFUNCIONARIO() {
        DefaultTableModel md1 = (DefaultTableModel) asignarhorarios.jTablehorariosfuncio.getModel();
        md1.setRowCount(0);
        Iterator<horarios> it = funcionariohorario.getHorariosdelfuncionario().iterator();
        while (it.hasNext()) {
            horarios next = it.next();
      //      if (next.isEliminado() != true) {
                //Object[] fila = new Object[5];
                Object[] fila = new Object[3];
                fila[0] = next;
                fila[1] = next.getHoracomienzo();
                fila[2] = next.getHorafin();
                md1.addRow(fila);
                //fila[3] = next.getTelefonos();
                //fila[4] = next.getRepartidores();
                
          //  }
        }
    }
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        activo=false;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void md1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_md1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_md1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    horario = (horarios) md1.getValueAt(md1.getSelectedRow(), 0);
    funcionariohorario.getHorariosdelfuncionario().add(horario);
    CPrincipal.getInstance().merge(funcionariohorario);
    cargartablaHORARIOSFUNCIONARIO();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       horario = (horarios) jTablehorariosfuncio.getValueAt(jTablehorariosfuncio.getSelectedRow(), 0);   
        Iterator<horarios> it = funcionariohorario.getHorariosdelfuncionario().iterator();
        while (it.hasNext()) {
            horarios next = it.next();
            if (next.getId() == horario.getId()) {
                CPrincipal.getInstance().delete(next);
           }
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3Funcionario;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable jTablehorariosfuncio;
    public static javax.swing.JTable md1;
    // End of variables declaration//GEN-END:variables
}
