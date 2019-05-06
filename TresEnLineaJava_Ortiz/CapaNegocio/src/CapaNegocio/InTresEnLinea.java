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
 * @author Oscar Fierro <omfierro@espe.edu.ec>
 */
public interface InTresEnLinea extends Serializable,Remote{
    void Actualiza() throws RemoteException;
    
}
