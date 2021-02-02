/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arsw.threads;

/**
 *
 * @author David Coronado
 */
public class Monitor {
    private RegistroLlegada regl;
    
    public Monitor(RegistroLlegada reg){
        this.regl=reg;
    }
    
    public synchronized void registrarLlegada(String nameGalgo){
	int ubicacion=regl.getUltimaPosicionAlcanzada();
	regl.setUltimaPosicionAlcanzada(ubicacion+1);
	System.out.println("El galgo "+nameGalgo+" llego en la posicion "+ubicacion);
	if (ubicacion==1){
            regl.setGanador(nameGalgo);
        }       
    
    }
    
}
