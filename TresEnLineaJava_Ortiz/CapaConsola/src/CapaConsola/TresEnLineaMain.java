/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaConsola;

import java.beans.*;
import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import CapaNegocio.*;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Mela
 */
public class TresEnLineaMain extends UnicastRemoteObject implements InTresEnLinea, Remote {

    public InGestor gesTresEnLinea;

    public InGestor getGesTresEnLinea() {
        return gesTresEnLinea;
    }

    public void setGesTresEnLinea(InGestor gesTresEnLinea) {
        this.gesTresEnLinea = gesTresEnLinea;
    }

    @Override
    public void Actualiza() {

        iniTresLinea thLeft = new iniTresLinea();
        thLeft.start();

    }

    public TresEnLineaMain() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry();
        gesTresEnLinea = (InGestor) registry.lookup("ServerTresEnLinea");
        gesTresEnLinea.suscribir(this);
        int j;
        System.out.println("Sucrito: " + gesTresEnLinea.getNumsuscritos());
        j = gesTresEnLinea.jugar(-1, -1);

//            }catch(Exception e){
//                System.out.println(e);
//            }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {

        new TresEnLineaMain();

    }

}
