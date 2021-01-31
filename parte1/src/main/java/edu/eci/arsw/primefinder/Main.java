package edu.eci.arsw.primefinder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
                PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000);
                PrimeFinderThread pft3=new PrimeFinderThread(20000000, 30000000);	
                pft.start();
                pft2.start();
                pft3.start();
            
            try {
                pft.join();
                pft2.join();
                pft3.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }



	
                System.out.println(Runtime.getRuntime().availableProcessors());
		
	}
	
}
