/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLASES.funcionario;
import CLASES.observacion;
import PERSISTENCIA.CPrincipal;
import java.awt.Font;

import java.util.Iterator;
import javax.persistence.FetchType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.cfg.AnnotationBinder;

/**
 *
 * @author franc
 */
public class listobs extends javax.swing.JInternalFrame {

    /**
     * Creates new form listobs
     */
    JLabel label = new JLabel();
    public static funcionario funcio = null;
    public static boolean activo = false;

    public listobs() {
        initComponents();
        activo = true;
        cargartabla();
    }

    public void cargartabla() {
        DefaultTableModel md1 = (DefaultTableModel) mdl1.getModel();
        md1.setRowCount(0);
        Iterator<observacion> it = funcio.getObservaciones().iterator();
        while (it.hasNext()) {
            observacion next = it.next();
            //      if (next.isEliminado() != true) {
            //Object[] fila = new Object[5];
            Object[] fila = new Object[3];
            fila[0] = next;
            fila[1] = next.getGravedad();
            fila[2] = next.getFechaobservacion();
            md1.addRow(fila);
            //fila[3] = next.getTelefonos();
            //fila[4] = next.getRepartidores();

            //  }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mdl1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Lista de Observaciones");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Modificar");

        mdl1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mdl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Motivo", "Tipo", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        activo = false;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void mdl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl1MouseClicked
        observacion prod = (observacion) mdl1.getValueAt(mdl1.getSelectedRow(), 0);
        if (evt.getClickCount() == 2) {
            label.setText("<html>Nombre Funcionario Observado: " + prod.getFuncionariobservado().getNombre() + "<br>"
                    + "Motivo: " + prod.getDescripcion() + "<br>"
                    + "Tipo: " + prod.getGravedad() + "<br>"
                    + "Fecha: " + prod.getFechaobservacion() + "<br>");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "Producto", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_mdl1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        observacion observacion = (observacion) mdl1.getValueAt(mdl1.getSelectedRow(), 0);
        CPrincipal.getInstance().delete(observacion);
        CPrincipal.getInstance().refresh(funcio);
        cargartabla();
         JOptionPane.showMessageDialog(null, "Observacion eliminada correctamente", "Obseravacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mdl1;
    // End of variables declaration//GEN-END:variables
}
