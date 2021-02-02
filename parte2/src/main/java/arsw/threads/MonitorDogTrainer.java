/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Coronado
 */
public class MonitorDogTrainer {
    boolean value=true;

    public synchronized void stopRunDog() {
        this.value = false;
    }
    public synchronized void validateRunDog(){
            if(!value){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MonitorDogTrainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public synchronized void allRun(){
        value=true;
        notifyAll();
    
    }
}
