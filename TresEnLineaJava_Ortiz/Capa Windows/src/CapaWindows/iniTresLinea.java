/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaWindows;

import CapaNegocio.GestorTresEnLinea;
import java.rmi.activation.Activator;
import CapaNegocio.*;
import java.awt.Color;
import java.awt.Component;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle.Control;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Labs-DECC
 */
public class iniTresLinea extends Thread {

    InGestor gesTresEnLinea;
    frmTresEnLinea obj;

    @Override
    public void run() {
        try {

            //gesTresEnLinea = (CapaNegocio.GestorTresEnLinea)Activator.GetObject(typeof(CapaNegocio.GestorTresEnLinea), "tcp://localhost:9946/GRServer");
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry();
            // Looking up the registry for the remote object
            gesTresEnLinea = (InGestor) registry.lookup("ServerTresEnLinea");
            obj = new frmTresEnLinea(gesTresEnLinea);
            System.out.println(gesTresEnLinea.toString());

            dibujaMatriz(gesTresEnLinea.getMatrizTresEnLinea());
            obj.show();
            System.out.println("Sucrito: " + gesTresEnLinea.getNumsuscritos());
            System.out.println("Entrando al try catch !!!!");
            int j;

            j = gesTresEnLinea.esTresEnLinea();
            if (j == 0) {
                obj.lblMensaje.setForeground(Color.red);
                obj.lblMensaje.setText("Gana 0");
            } else if (j == 1) {
                obj.lblMensaje.setForeground(Color.red);
                obj.lblMensaje.setText("Gana X");
            } else if (j == -1) {
                if (gesTresEnLinea.getJugador() == 1) {

                    obj.lblMensaje.setText("Juegan las 0");
                } else {
                    obj.lblMensaje.setText("Juegan las X");

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(iniTresLinea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dibujaMatriz(int[][] matriz) {
        //Control.CheckForIllegalCrossThreadCalls = false;
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == -1) {
                    obj.labels.get(cont).setText(" ");
                } else if (matriz[i][j] == 0) {
                    obj.labels.get(cont).setText("O");
                } else if (matriz[i][j] == 1) {
                    obj.labels.get(cont).setText("X");
                }
                cont++;
            }

        }
        obj.lbl00.setText(obj.labels.get(0).getText());
        obj.lbl01.setText(obj.labels.get(1).getText());
        obj.lbl02.setText(obj.labels.get(2).getText());
        obj.lbl10.setText(obj.labels.get(3).getText());
        obj.lbl10.setText(obj.labels.get(4).getText());
        obj.lbl12.setText(obj.labels.get(5).getText());
        obj.lbl20.setText(obj.labels.get(6).getText());
        obj.lbl21.setText(obj.labels.get(7).getText());
        obj.lbl22.setText(obj.labels.get(8).getText());

    }

}
