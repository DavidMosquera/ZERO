package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;
import lejos.util.Delay; 

public class Patear extends jugadaPrimitiva implements Serializable{
	public Patear (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.C.setSpeed(potencia);
	}
	public void ejecutar(){ // Ejecuta Patear, se devuelve en 1 segundo.
		Motor.C.backward();
		Delay.msDelay(350);
		Motor.C.forward();
		Delay.msDelay(400);
		Motor.C.stop();
	}
	public void parar(){
		Motor.C.stop();
		
		/*se puede detener en cualquier momento y se debe devovlver 
		a el punto inicial*/
		
	}
}
