/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLASES.carnets;
import CLASES.funcionario;
import CONTROLADORES.ctrl_controladoravisos;
import static GUI.administrarfuncionarios.funcio;
import static GUI.administrarfuncionarios.mdl1;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franc
 */
public class funcionariosvencidos extends javax.swing.JInternalFrame {
  ctrl_controladoravisos ctrlavisos = new ctrl_controladoravisos();
    /**
     * Creates new form funcionariosvencidos
     */
    public static carnets carnet;
    
    public static boolean activo = false;
    public funcionariosvencidos() {
        initComponents();
        activo=true;
        desactivarbotones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mdl1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        mdl2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(28, 28, 28));
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("10 dias o menos para vencimiento");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("VENCIDOS!");

        mdl1.setBackground(new java.awt.Color(28, 28, 28));
        mdl1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mdl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "obj", "Nombre", "Apellido", "Carnet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mdl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mdl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mdl1);
        if (mdl1.getColumnModel().getColumnCount() > 0) {
            mdl1.getColumnModel().getColumn(0).setMinWidth(0);
            mdl1.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        mdl2.setBackground(new java.awt.Color(28, 28, 28));
        mdl2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mdl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "obj", "Nombre", "Apellido", "Carnet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mdl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mdl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mdl2);
        if (mdl2.getColumnModel().getColumnCount() > 0) {
            mdl2.getColumnModel().getColumn(0).setMinWidth(0);
            mdl2.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Renovar Carnet Selecionado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 255, 204));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/actualizar-pagina.png"))); // NOI18N
        jButton2.setText("Actualizar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void desactivarbotones(){
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
    }
       public void activarbotones(){
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }
    private void mdl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl1MouseClicked

carnet = (carnets) mdl1.getValueAt(mdl1.getSelectedRow(), 0);
activarbotones();
    }//GEN-LAST:event_mdl1MouseClicked

    private void mdl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl2MouseClicked
carnet = (carnets) mdl2.getValueAt(mdl2.getSelectedRow(), 0);
activarbotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_mdl2MouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        activo=false;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   renovarcarnet.carnefuncionario= carnet;
        if (renovarcarnet.activo == false) {
            renovarcarnet AU = new renovarcarnet();           
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);
            
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
ctrlavisos.avisarcarnevencido(main.funcionarios);
desactivarbotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

public static void cargartablavencidos() {
        DefaultTableModel md1 = (DefaultTableModel) mdl2.getModel();
        md1.setRowCount(0);
        Iterator<carnets> it = main.funcionariosconcarnetvencido.iterator();
        while (it.hasNext()) {
            carnets next = it.next();
      //      if (next.isEliminado() != true) {
                //Object[] fila = new Object[5];
                Object[] fila = new Object[4];
                fila[0] = next;
                fila[1] = next.getFuncionariodueniodelcarne();
                fila[2] = next.getFuncionariodueniodelcarne().getApellido();
                fila[3] = next.getTipocarnet();
                md1.addRow(fila);
                //fila[3] = next.getTelefonos();
                //fila[4] = next.getRepartidores();
                
          //  }
        }
    }
public static void cargartablaporvencer() {
        DefaultTableModel md2 = (DefaultTableModel) mdl1.getModel();
        md2.setRowCount(0);
        Iterator<carnets> it = main.funcionariosconcarnetporvencer.iterator();
        while (it.hasNext()) {
            carnets next = it.next();
      //      if (next.isEliminado() != true) {
                //Object[] fila = new Object[5];
                Object[] fila = new Object[4];
                fila[0] = next;
                fila[1] = next.getFuncionariodueniodelcarne();
                fila[2] = next.getFuncionariodueniodelcarne().getApellido();
                fila[3] = next.getTipocarnet();
                md2.addRow(fila);
                //fila[3] = next.getTelefonos();
                //fila[4] = next.getRepartidores();
                
          //  }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable mdl1;
    public static javax.swing.JTable mdl2;
    // End of variables declaration//GEN-END:variables
}
