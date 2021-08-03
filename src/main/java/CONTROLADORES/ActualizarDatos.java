/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES;

import static GUI.main.funcionarios;

/**
 *
 * @author franc
 */
public class ActualizarDatos extends Thread{
    ctrl_controladoravisos ctrlavisos = new ctrl_controladoravisos();
     @Override
    public void run() {
        try {
            while (true) {
                
                //Aca iría el código de tu función o llamarla
                ctrlavisos.avisarcarnevencido(funcionarios);
                ctrlavisos.avisarcumpleaños(funcionarios);
                ctrlavisos.calcularycargardiasfunc();
                Thread.sleep(1000 * 60 * 60);
                
                
            }
        } catch (Exception e) {

        }
    }
}
