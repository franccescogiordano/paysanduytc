/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLASES.funcionario;
import PERSISTENCIA.CPrincipal;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class administrarfuncionarios extends javax.swing.JInternalFrame {

    public static funcionario funcio = null;
    public static boolean activo = false;
    int cantidaddecarnets = 0;

    public administrarfuncionarios() {
        initComponents();
        cargartabla();
        activo = true;
        desactivartodoslosbotones();
        desactivarcarnets();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mdl1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jDateChooserCarnet = new com.toedter.calendar.JDateChooser();
        jButton1RenovarCarnet = new javax.swing.JButton();
        jDateChooserBrebet = new com.toedter.calendar.JDateChooser();
        jButton2RenovarBrebet = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4ModOtherData = new javax.swing.JButton();
        jButton5ChangeOcupation = new javax.swing.JButton();
        jButton6Times = new javax.swing.JButton();
        jButton7Observation = new javax.swing.JButton();
        jButton8ViewFails = new javax.swing.JButton();

        setClosable(true);
        setTitle("ADMINISTAR FUNCIONARIOS");
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

        mdl1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mdl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Cedula", "FechaNacimiento", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CARNETS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jDateChooserCarnet.setDateFormatString("dd-MM-yyyy");
        jDateChooserCarnet.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton1RenovarCarnet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1RenovarCarnet.setText("Renovar Carné Salud");
        jButton1RenovarCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1RenovarCarnetActionPerformed(evt);
            }
        });

        jDateChooserBrebet.setDateFormatString("dd-MM-yyyy");
        jDateChooserBrebet.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jButton2RenovarBrebet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2RenovarBrebet.setText("Renovar Brebet");
        jButton2RenovarBrebet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2RenovarBrebetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserBrebet, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jDateChooserCarnet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1RenovarCarnet)
                    .addComponent(jButton2RenovarBrebet))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jDateChooserBrebet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2RenovarBrebet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1RenovarCarnet)
                    .addComponent(jDateChooserCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("Limpiar campos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4ModOtherData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4ModOtherData.setText("Modificar Otros Datos");
        jButton4ModOtherData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ModOtherDataActionPerformed(evt);
            }
        });

        jButton5ChangeOcupation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5ChangeOcupation.setText("Cambiar Cargo");
        jButton5ChangeOcupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ChangeOcupationActionPerformed(evt);
            }
        });

        jButton6Times.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6Times.setText("Horarios");
        jButton6Times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6TimesActionPerformed(evt);
            }
        });

        jButton7Observation.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7Observation.setText("Observar");
        jButton7Observation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ObservationActionPerformed(evt);
            }
        });

        jButton8ViewFails.setText("Ver Observaciones");
        jButton8ViewFails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ViewFailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4ModOtherData)
                        .addGap(37, 37, 37)
                        .addComponent(jButton8ViewFails))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5ChangeOcupation)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6Times, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7Observation)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4ModOtherData)
                            .addComponent(jButton8ViewFails))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5ChangeOcupation)
                            .addComponent(jButton6Times)
                            .addComponent(jButton7Observation))
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void desactivarcarnets() {
        jDateChooserBrebet.setEnabled(false);
        jDateChooserCarnet.setEnabled(false);
        jButton1RenovarCarnet.setEnabled(false);
        jButton2RenovarBrebet.setEnabled(false);

    }

    public void activarbrebet() {
        jDateChooserBrebet.setEnabled(true);
        jButton2RenovarBrebet.setEnabled(true);
    }

    public void activarcarnet() {
        jDateChooserCarnet.setEnabled(true);
        jButton1RenovarCarnet.setEnabled(true);
    }
    public void activartodoslosbotones(){
        jButton4ModOtherData.setEnabled(true);
        jButton5ChangeOcupation.setEnabled(true);
        jButton6Times.setEnabled(true);
        jButton7Observation.setEnabled(true);
        jButton8ViewFails.setEnabled(true);
    }
   public void desactivartodoslosbotones(){
        jButton4ModOtherData.setEnabled(false);
        jButton5ChangeOcupation.setEnabled(false);
        jButton6Times.setEnabled(false);
        jButton7Observation.setEnabled(false);
        jButton8ViewFails.setEnabled(false);
    }
    private void mdl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mdl1MouseClicked
        vaciarcampos();
        activartodoslosbotones();
        funcio = (funcionario) mdl1.getValueAt(mdl1.getSelectedRow(), 0);

        if (evt.getClickCount() == 2) {
            JOptionPane.showMessageDialog(null,
                    "Nombre: " + funcio.getNombre() + "\n"
                    + "Apellido: " + funcio.getApellido() + "\n"
                    + "Celular: " + funcio.getCelular() + "\n"
                    + "Cedula: " + funcio.getCedula() + "\n"
                    + carnetsfuncio(funcio)
            );
        }

        cantidaddecarnets = 0;
        if (funcio != null) {
            cantidaddecarnets = funcio.getCarnetsdelfuncionario().size();

            for (int i = 0; i < cantidaddecarnets; i++) {
                if (funcio.getCarnetsdelfuncionario().get(i).getTipocarnet().equals("Carne Brebet")) {
                    activarbrebet();
                    jDateChooserBrebet.setDate(funcio.getCarnetsdelfuncionario().get(i).getFechavencimiento());
                } else {
                    activarcarnet();
                    jDateChooserCarnet.setDate(funcio.getCarnetsdelfuncionario().get(i).getFechavencimiento());
                }
            }
        }


    }//GEN-LAST:event_mdl1MouseClicked

    private void jButton2RenovarBrebetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2RenovarBrebetActionPerformed
        Date hoy = new Date();
        for (int i = 0; i < funcio.getCarnetsdelfuncionario().size(); i++) {
            if (funcio.getCarnetsdelfuncionario().get(i).getTipocarnet().equals("Carne Brebet")) {
                funcio.getCarnetsdelfuncionario().get(i).setFechaRenovacion(hoy);
                funcio.getCarnetsdelfuncionario().get(i).setFechavencimiento(jDateChooserBrebet.getDate());
                JOptionPane.showMessageDialog(null, "Fecha de Vencimiento modificada correctamente", null, JOptionPane.OK_OPTION);
            } else {

            }
        }

    }//GEN-LAST:event_jButton2RenovarBrebetActionPerformed

    private void jButton1RenovarCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1RenovarCarnetActionPerformed
        Date hoy = new Date();
        for (int i = 0; i < funcio.getCarnetsdelfuncionario().size(); i++) {
            if (funcio.getCarnetsdelfuncionario().get(i).getTipocarnet().equals("Carne de salud")) {
                funcio.getCarnetsdelfuncionario().get(i).setFechaRenovacion(hoy);
                funcio.getCarnetsdelfuncionario().get(i).setFechavencimiento(jDateChooserCarnet.getDate());
                JOptionPane.showMessageDialog(null, "Fecha de Vencimiento modificada correctamente", null, JOptionPane.OK_OPTION);
            } else {

            }
        }
    }//GEN-LAST:event_jButton1RenovarCarnetActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        activo = false;
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        vaciarcampos();
        desactivartodoslosbotones();
        desactivarcarnets();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ModOtherDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ModOtherDataActionPerformed
        addfuncionario.funcio2 = funcio;
        if (addfuncionario.activo == false) {
            addfuncionario AU = new addfuncionario();
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ModOtherDataActionPerformed

    private void jButton5ChangeOcupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ChangeOcupationActionPerformed
        cargarrenovacion.funcio3 = funcio;
        if (cargarrenovacion.activo == false) {
            cargarrenovacion AU = new cargarrenovacion();
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ChangeOcupationActionPerformed

    private void jButton6TimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6TimesActionPerformed
        asignarhorarios.funcionariohorario = funcio;
        if (asignarhorarios.activo == false) {
            asignarhorarios AU = new asignarhorarios();
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6TimesActionPerformed

    private void jButton7ObservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ObservationActionPerformed
        observarfuncionario.funcio = funcio;
        if (observarfuncionario.activo == false) {
            observarfuncionario AU = new observarfuncionario();
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ObservationActionPerformed

    private void jButton8ViewFailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ViewFailsActionPerformed
        listobs.funcio = funcio;
        if (listobs.activo == false) {
            listobs AU = new listobs();
            main.jDesktopPane1.add(AU);
            AU.setVisible(true);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ViewFailsActionPerformed
    public void cargartabla() {
        DefaultTableModel md1 = (DefaultTableModel) mdl1.getModel();
        md1.setRowCount(0);
        Iterator<funcionario> it = main.funcionarios.iterator();
        while (it.hasNext()) {
            funcionario next = it.next();
            //      if (next.isEliminado() != true) {
            //Object[] fila = new Object[5];
            Object[] fila = new Object[5];
            fila[0] = next;
            fila[1] = next.getApellido();
            fila[2] = next.getCedula();
            fila[4] = next.getCelular();
            fila[3] = next.getFechaNacimiento();
            md1.addRow(fila);
            //fila[3] = next.getTelefonos();
            //fila[4] = next.getRepartidores();

            //  }
        }
    }

    public void vaciarcampos() {
        jDateChooserBrebet.setCalendar(null);
        jDateChooserCarnet.setCalendar(null);
        funcio = null;
    }

    public String carnetsfuncio(funcionario funcio) {
        String carnets = "";
        int cantidadcarne = funcio.getCarnetsdelfuncionario().size();
        if (cantidadcarne == 0) {
            return "";
        } else {
            carnets += "Carnets Datos: \n";

            for (int i = 0; i < cantidadcarne; i++) {
                carnets += "-" + funcio.getCarnetsdelfuncionario().get(i).getTipocarnet() + " Fecha vencimiento: \n";
                carnets += funcio.getCarnetsdelfuncionario().get(i).getFechavencimiento() + "\n";
                if (funcio.getCarnetsdelfuncionario().get(i).getFechaRenovacion() == null) {

                } else {
                    carnets += "Fecha de ultima renovacion:" + funcio.getCarnetsdelfuncionario().get(i).getFechaRenovacion() + "\n";
                }

            }
            return carnets;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1RenovarCarnet;
    private javax.swing.JButton jButton2RenovarBrebet;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4ModOtherData;
    private javax.swing.JButton jButton5ChangeOcupation;
    private javax.swing.JButton jButton6Times;
    private javax.swing.JButton jButton7Observation;
    private javax.swing.JButton jButton8ViewFails;
    private com.toedter.calendar.JDateChooser jDateChooserBrebet;
    private com.toedter.calendar.JDateChooser jDateChooserCarnet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable mdl1;
    // End of variables declaration//GEN-END:variables
}
