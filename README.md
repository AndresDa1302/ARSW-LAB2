
### Escuela Colombiana de Ingeniería

### Arquitecturas de Software – ARSW
## Laboratorio Programación concurrente, condiciones de carrera, esquemas de sincronización, colecciones sincronizadas y concurrentes - Caso Dogs Race

### Descripción:
Este ejercicio tiene como fin que el estudiante conozca y aplique conceptos propios de la programación concurrente.

### Parte I 
Antes de terminar la clase.

Creación, puesta en marcha y coordinación de hilos.

1.	Revise el programa “primos concurrentes” (en la carpeta parte1), dispuesto en el paquete edu.eci.arsw.primefinder. Este es un programa que calcula los números primos entre dos intervalos, distribuyendo la búsqueda de los mismos entre hilos independientes. Por ahora, tiene un único hilo de ejecución que busca los primos entre 0 y 30.000.000. Ejecútelo, abra el administrador de procesos del sistema operativo, y verifique cuantos núcleos son usados por el mismo.

	Con un hilo se puede evidenciar que hay cuatro núcleos en funcionamiento tras ejecutar el programa, pero sus usos son mas prologandos.
  
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/Iparte1.png?raw=true" alt="Sublime's custom image"/>
  </p>
  
	El tiempo de ejecución es mas prolongado.
  
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/time1.png?raw=true" alt="Sublime's custom image"/>
  </p>

2.	Modifique el programa para que, en lugar de resolver el problema con un solo hilo, lo haga con tres, donde cada uno de éstos hará la tarcera parte del problema original. Verifique nuevamente el funcionamiento, y nuevamente revise el uso de los núcleos del equipo.

	Con 3 hilos, a diferencia del punto anterior el uso de los nucleos es de un tiempo menor, pero en este intervalo de tiempo estan constantemente trabajando, con respecto a la   anterior imagen que pareciera que se dividieran el trabajo pero con un tiempo mayor.
  
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/Iparte2.png?raw=true" alt="Sublime's custom image"/>
  </p>
  
	El tiempo de ejecucíon es menos prolongado con respecto a un hilo.
  
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/time2.png?raw=true" alt="Sublime's custom image"/>
  </p>

3.	Lo que se le ha pedido es: debe modificar la aplicación de manera que cuando hayan transcurrido 5 segundos desde que se inició la ejecución, se detengan todos los hilos y   se muestre el número de primos encontrados hasta el momento. Luego, se debe esperar a que el usuario presione ENTER para reanudar la ejecución de los mismo.
  
	Para lo siguiente se crearon dos clases nuevas Monitor y Mythread las cuales permiten sincronizar los objetos instanciados de la clase PrimeFinderThread (que hereda de Thread   y calcula los números primos entre un rango determinado), en las siguientes imagenes se puede evidenciar la ejecución del programa y su correcto funcionamiento debido a las     especificaciones requeridas.
  
	Despues de trascurridos 5 segundos el programa se detiene.

<p align="center">
  <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/stop.png?raw=true" alt="Sublime's custom image"/>
</p>

	Despues  de precionar enter el programa sigue su ejecución.

<p align="center">
  <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/inicia.png?raw=true" alt="Sublime's custom image"/>
</p>



### Parte II 


Para este ejercicio se va a trabajar con un simulador de carreras de galgos (carpeta parte2), cuya representación gráfica corresponde a la siguiente figura:

![](./img/media/image1.png)

En la simulación, todos los galgos tienen la misma velocidad (a nivel de programación), por lo que el galgo ganador será aquel que (por cuestiones del azar) haya sido más beneficiado por el *scheduling* del
procesador (es decir, al que más ciclos de CPU se le haya otorgado durante la carrera). El modelo de la aplicación es el siguiente:

![](./img/media/image2.png)

Como se observa, los galgos son objetos ‘hilo’ (Thread), y el avance de los mismos es visualizado en la clase Canodromo, que es básicamente un formulario Swing. Todos los galgos (por defecto son 17 galgos corriendo en una pista de 100 metros) comparten el acceso a un objeto de tipo
RegistroLLegada. Cuando un galgo llega a la meta, accede al contador ubicado en dicho objeto (cuyo valor inicial es 1), y toma dicho valor como su posición de llegada, y luego lo incrementa en 1. El galgo que
logre tomar el ‘1’ será el ganador.

Al iniciar la aplicación, hay un primer error evidente: los resultados (total recorrido y número del galgo ganador) son mostrados antes de que finalice la carrera como tal. Sin embargo, es posible que una vez corregido esto, haya más inconsistencias causadas por la presencia de condiciones de carrera.

Parte III

1.  Corrija la aplicación para que el aviso de resultados se muestre
    sólo cuando la ejecución de todos los hilos ‘galgo’ haya finalizado.
    Para esto tenga en cuenta:

    a.  La acción de iniciar la carrera y mostrar los resultados se realiza a partir de la línea 38 de MainCanodromo.

    b.  Puede utilizarse el método join() de la clase Thread para sincronizar el hilo que inicia la carrera, con la finalización de los hilos de los galgos.
    
    Agregamos el metodo join() para los objetos de la clase Galgo debidamente y asi el aviso de resultados se mostrara al final de que los galgos lleguen a la meta.
    
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/join().png?raw=true" alt="Sublime's custom image"/> 
  </p>
    

2.  Una vez corregido el problema inicial, corra la aplicación varias
    veces, e identifique las inconsistencias en los resultados de las
    mismas viendo el ‘ranking’ mostrado en consola (algunas veces
    podrían salir resultados válidos, pero en otros se pueden presentar
    dichas inconsistencias). A partir de esto, identifique las regiones
    críticas () del programa.
    
    Despues de ejecutar varias vecez el programa se encontraron las siguientes inconcistencias:
    Hay algunos valores incorrectos como que estan repetidos los números de llegada o  pueda que la llegada de determinado galgo no sea la correcta.
    <p align="center">
      <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/regionCritica.png?raw=true" alt="Sublime's custom image"/> 
    </p>
    
     El siguiente valor no es correcto ya que el número total de galgos es 17. 
    
   
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/unknown.png?raw=true" alt="Sublime's custom image"/> 
  </p>
  
     La siguente imagen es un fragmento del codigo de la clase Galgo, donde se encuentran las regiones critica.
   
  <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/regioncritica2.png?raw=true" alt="Sublime's custom image"/> 
    </p>

3.  Utilice un mecanismo de sincronización para garantizar que a dichas
    regiones críticas sólo acceda un hilo a la vez. Verifique los
    resultados.
    
    Aplicamos exclusión mutua utilizando el mecanismo de sincronización, para lograr esto se creó la clase Monitor que sincronizara la llegada de los galgos y se permita           registrar correctamente.
    
    Luego de varios intentos se puede ver que no hay errores en datos.
    <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/exclucion mutua2.png?raw=true" alt="Sublime's custom image"/> 
    </p>
    
    <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/exclucion mutua.png?raw=true" alt="Sublime's custom image"/> 
    </p>
   
   
   
    
    

4.  Implemente las funcionalidades de pausa y continuar. Con estas,
    cuando se haga clic en ‘Stop’, todos los hilos de los galgos
    deberían dormirse, y cuando se haga clic en ‘Continue’ los mismos
    deberían despertarse y continuar con la carrera. Diseñe una solución que permita hacer esto utilizando los mecanismos de sincronización con las primitivas de los Locks         provistos por el lenguaje (wait y notifyAll).
    
    Para lograr que el juego se pause y continue se crea un clase MonitorDogTrainer que permitira detener los Threads galgos al momento de que se precione Stop o que continuen     si es el caso utilizando el mecanismo de sincronización con los metodos wai() y nofityAll().
    
    <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/pausa.png?raw=true" alt="Sublime's custom image"/> 
    </p>
     <p align="center">
    <img src="https://github.com/AndresDa1302/ARSW-LAB2/blob/master/img/media/start.png?raw=true" alt="Sublime's custom image"/> 
    </p>
    

### Integrantes
David Leonardo Coronado

Andres Felipe Davila

