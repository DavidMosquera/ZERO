package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;
import lejos.util.Delay; 

public class Patear extends jugadaPrimitiva implements Serializable{
	public Patear (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		
	}
	public void ejecutar(){ // Ejecuta Patear, se devuelve en 1 segundo.
		Motor.C.setSpeed(potencia);
		Motor.C.rotateTo(-70);
        Motor.C.rotateTo(70);
		
	}
	public void parar(){
		Motor.C.stop();
		
		/*se puede detener en cualquier momento y se debe devovlver 
		a el punto inicial*/
		
	}
	public String toString(){
		return this.nombre;
	}
}
