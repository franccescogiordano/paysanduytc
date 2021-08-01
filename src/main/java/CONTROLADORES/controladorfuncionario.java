/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import CLASES.cargo;
import CLASES.carnets;
import CLASES.funcionario;
import CLASES.horarios;
import GUI.addfuncionario;
import GUI.cargarrenovacion;
import  GUI.main;
import PERSISTENCIA.CPrincipal;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class controladorfuncionario {
     EntityManager em = CPrincipal.getInstance().getEntity();
 public List<cargo> cargarcargos(){
     
        List<cargo> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM cargo", cargo.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    
}
 public static funcionario findfuncionario(String nombreapellido){
    if(nombreapellido.contains(" ")){
     String nombre;
     String apellido;
     String[] datos = nombreapellido.split(" ");
     nombre=datos[0];
     apellido=datos[1];
     Iterator<funcionario> it= main.funcionarios.iterator();
     while (it.hasNext()) {
         funcionario next =  it.next();
         if(next.getApellido().equals(apellido) && next.getNombre().equals(nombre)){
             return next;
         }else{
              
         }
         
     }
    }
     return null;
 }


  public List<funcionario> cargarfuncionarios(){
     
        List<funcionario> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM funcionario", funcionario.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    
}
    public List<carnets> cargarcarnets(){
     
        List<carnets> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM carnets ORDER BY DATE(fechavencimiento) ASC", carnets.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    
}
  
  public List<horarios> CargarHorarios(){
     
        List<horarios> lista = null;
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM horarios", horarios.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return lista;
    
}
  public void CargarCBoxCargos(){
        //DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        DefaultComboBoxModel mdl = (DefaultComboBoxModel) addfuncionario.jComboBoxCargo.getModel();
        mdl.removeAllElements();
        mdl.addElement("---Seleccionar Cargo---");
        if (main.cargos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Cargos registrados, registre al menos uno para poder registrar", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<cargo> it = main.cargos.iterator();
            while (it.hasNext()) {
                mdl.addElement(it.next());
            }
        }
        //AddProducto.tipocbox.setModel(mdl);
    }
  public void CargarCBoxFuncios(JComboBox combobox){
        //DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        DefaultComboBoxModel mdl = (DefaultComboBoxModel) combobox.getModel();
        mdl.removeAllElements();
        mdl.addElement("---Escoje---");
        if (main.cargos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Funcionarios registrados, registre al menos uno para poder registrar", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<funcionario> it = main.funcionarios.iterator();
            while (it.hasNext()) {
                funcionario next=it.next();
                mdl.addElement(next+" "+next.getApellido());
            }
        }
        //AddProducto.tipocbox.setModel(mdl);
    }
  public void CargarCBoxCargos2(){
        //DefaultComboBoxModel mdl = new DefaultComboBoxModel();
        DefaultComboBoxModel mdl = (DefaultComboBoxModel) cargarrenovacion.jComboBox1.getModel();
        mdl.removeAllElements();
        mdl.addElement("---Seleccionar Cargo---");
        if (main.cargos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay Cargos registrados, registre al menos uno para poder registrar", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            Iterator<cargo> it = main.cargos.iterator();
            while (it.hasNext()) {
                mdl.addElement(it.next());
            }
        }
        //AddProducto.tipocbox.setModel(mdl);
    }
}
