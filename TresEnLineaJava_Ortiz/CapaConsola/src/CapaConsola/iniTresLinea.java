/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConsola;

import CapaNegocio.GestorTresEnLinea;
import CapaNegocio.InGestor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import CapaNegocio.InTresEnLinea;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mela
 */
public class iniTresLinea extends Thread {

    public InGestor gesTresEnLinea;

    @Override

    public void run() {
        try {
            int j;

            // Getting the registry
            Registry registry = LocateRegistry.getRegistry();
            // Looking up the registry for the remote object
            gesTresEnLinea = (InGestor) registry.lookup("ServerTresEnLinea");
            dibujaMatriz(gesTresEnLinea.getMatrizTresEnLinea());
            
            j = gesTresEnLinea.esTresEnLinea();
            System.out.println(gesTresEnLinea.getJugador() + "jugador");
            if (j == 0) {

                System.out.println("Gana 0");

            } else if (j == 1) {

                System.out.println("Gana X");

            } else if (j == -1) {
                System.out.println(gesTresEnLinea.getJugador());
                if (gesTresEnLinea.getJugador() == 1) {
                    int f, c, x;
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Fila: ");
                    f = Integer.parseInt(sc.next());
                    System.out.println("Columna: ");
                    c = Integer.parseInt(sc.next());

                    try {
                        x = gesTresEnLinea.jugar(f, c);
                    } catch (RemoteException ex) {
                        Logger.getLogger(iniTresLinea.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Jugando X..");

                }

            }

        } catch (Exception ex) {
            Logger.getLogger(iniTresLinea.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    static void dibujaMatriz(int[][] matriz) {
        String fila = "";
        String division = " -| -| -|";
        //Console.Clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == -1) {
                    fila = fila + "  |";
                } else if (matriz[i][j] == 0) {
                    fila = fila + "0 |";
                } else if (matriz[i][j] == 1) {
                    fila = fila + "X |";
                }
            }

            System.out.println(fila);
            System.out.println(division);
            fila = "";
        }
        System.out.println("");

    }

}
