package edu.eci.arsw.primefinder;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
                Monitor cerradura=new Monitor();
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000,cerradura);
                PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000,cerradura);
                PrimeFinderThread pft3=new PrimeFinderThread(20000000, 30000000,cerradura);
                MyThread mm = new MyThread(cerradura);                    
                mm.start();
                
                pft.start();
                pft2.start();
                pft3.start();
                mm.join();
                String user;
                Scanner myObj = new Scanner(System.in);
                user=myObj.nextLine();
                if(user.length()==0){
                    cerradura.nofiticar();
                }
               
                

		
	}
	
}
