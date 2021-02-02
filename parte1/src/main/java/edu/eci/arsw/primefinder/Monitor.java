/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.primefinder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Coronado
 */
public class Monitor {
    boolean  value=false;

    public synchronized void  setValue(boolean value) {
        this.value = value;
    }
    public synchronized void stop(){
        if(value){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public synchronized void nofiticar(){
        value=false;
        notifyAll();
    }
    
}
