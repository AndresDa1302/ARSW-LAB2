package edu.eci.arsw.primefinder;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread ptf2=new PrimeFinderThread(10000001, 20000000);
                PrimeFinderThread ptf3=new PrimeFinderThread(20000001, 30000000);
                
		pft.start();
		
		
	}
	
}
