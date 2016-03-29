package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;

class Patear extends jugadaPrimitiva {
	public Patear (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.C.setSpeed(potencia);
	}
	public void ejecutar(){
		Motor.C.forward();
		// D#14 Delay?
		/*podría ser un while con un condicional de temporizador donde pregunte
		si se ingresa algo por teclado para parar el motor :) */
		//avanza chuta y sa devuelva a la posicion inicial		
	}
	public void parar(){
		Motor.C.stop();
		/*se puede detener en cualquier momento y se debe devovlver 
		a el punto inicial*/
		
	}
}
