package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 * 
 * @author rlopez
 * 
 */
public class Galgo extends Thread {
	private int paso;
	private Carril carril;
        Monitor registrador;
        MonitorDogTrainer trainer;

	public Galgo(Carril carril, String name, Monitor registrador, MonitorDogTrainer trainer) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.registrador=registrador;
                this.trainer=trainer;
        }   

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {
                        trainer.validateRunDog();
			Thread.sleep(100);
			carril.setPasoOn(paso++);
			carril.displayPasos(paso);
			
			if (paso == carril.size()) {						
				carril.finish();
                                registrador.registrarLlegada(this.getName());
			}
		}
	}


	@Override
	public void run() {
		
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
