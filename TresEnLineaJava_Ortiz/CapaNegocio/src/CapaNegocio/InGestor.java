/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mela
 */
public interface InGestor extends Remote,Serializable{
    void suscribir(InTresEnLinea obsTresL) throws RemoteException;
     public int jugar(int x, int y) throws RemoteException;
     public int getNumsuscritos()  throws RemoteException;
      public int esTresEnLinea()  throws RemoteException;
       public int[][] getMatrizTresEnLinea() throws RemoteException;
       public int esTresLinea(int[][] matriz) throws RemoteException;
         public int getJugador() throws RemoteException;
}
