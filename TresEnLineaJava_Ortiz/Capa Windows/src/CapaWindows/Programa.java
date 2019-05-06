/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaWindows;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Labs-DECC
 */
public class Programa  {
    public static void main(String[] args) {
        iniTresLinea obj=new iniTresLinea();
        obj.run();
    }   
}

