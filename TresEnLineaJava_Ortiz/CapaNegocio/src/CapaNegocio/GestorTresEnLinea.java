/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaEntidades.TresEnLinea;
import java.beans.*;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public class GestorTresEnLinea extends UnicastRemoteObject implements Serializable,InGestor {

    private static GestorTresEnLinea gesTresEnLinea;
    private static TresEnLinea objTresEnLinea = new TresEnLinea();
    private static ArrayList<InTresEnLinea> obsTresEnLinea;
    private static int jugador;

  
    public GestorTresEnLinea()throws RemoteException {

    }
    private void NotificaCambio() {
        obsTresEnLinea.forEach((objTL) -> {
            try {
                objTL.Actualiza();
            } catch (RemoteException ex) {
                Logger.getLogger(GestorTresEnLinea.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void suscribir(InTresEnLinea obsTresL)  {
        if (obsTresEnLinea == null) {
            obsTresEnLinea = new ArrayList<>();
        }
        obsTresEnLinea.add(obsTresL);
    }

    public int getNumsuscritos() {
        return obsTresEnLinea.size();
    }

    //Patron singleton
    public  static GestorTresEnLinea getGestor() throws RemoteException {
        if (gesTresEnLinea == null) {
            gesTresEnLinea = new GestorTresEnLinea();
        }

        return gesTresEnLinea;
    }

    public int getJugador() {
        return jugador;
    }

    public int jugar(int x, int y) {
        if (objTresEnLinea.asignaDatos(x, y, jugador)) {
           
            if (jugador == 1) {
                jugador = 0;
            } else {
                jugador = 1;
            }
        }

        // SE Notifica que existe un cambio
        NotificaCambio();
        return 1;

    }

    public int esTresEnLinea() {
        if (this.esTresLinea(objTresEnLinea.getDatos()) == 1) {
            return 1;
        }
        if (this.esTresLinea(objTresEnLinea.getDatos()) == 0) {
            return 0;
        }
        return -1;
    }

    public int[][] getMatrizTresEnLinea() {

        return objTresEnLinea.getDatos();
    }

    public int esTresLinea(int[][] matriz) {

        for (int i = 0; i < 3; i++) {
            //Verifica filas
            if ((matriz[i][0] == matriz[i][1]) && (matriz[i][0] == matriz[i][2]) && matriz[i][0] != -1) {
                if (matriz[i][0] == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            //Verifica coumnas
            if ((matriz[0][i] == matriz[1][i]) && (matriz[0][i] == matriz[2][i]) && matriz[0][i] != -1) {
                if (matriz[0][i] == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        //Verifica diagonales
        if ((matriz[0][0] == matriz[1][1]) && (matriz[0][0] == matriz[2][2]) && matriz[0][0] != -1) {
            if (matriz[0][0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        if ((matriz[0][2] == matriz[1][1]) && (matriz[0][2] == matriz[2][0]) && matriz[2][0] != -1) {
            if (matriz[0][2] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        return -1;
    }

 
    

}
