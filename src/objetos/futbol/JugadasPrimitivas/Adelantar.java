package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;//no sabemos especificamente que vamos a importar pero en este caso los motores
import objetos.futbol.UI.InterfazUsuarioGeneral;
import objetos.futbol.menuconsola.UsuarioUsuario;// IMPORTANTE: Despues de la propuesta de maÃ±ana del MenÃº, determinaremos donde poner 
//y donde calcular la posiciÃ³n del jugador, por lo que veo serÃ¡ mÃ¡s sencillo despÃºes de plantear lo que tengo en mente.

public class Adelantar extends jugadaPrimitiva implements Serializable{
	public Adelantar(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
	}
	public void ejecutar(){
		first_T();
		InterfazUsuarioGeneral.cancha1.Memoria_taco=Motor.A.getTachoCount();
		Motor.A.forward();//Derecho=A
		Motor.B.forward();//Izquierdo=B
		//los dos motores hacia adelante
	}
	public void parar(){
		  InterfazUsuarioGeneral.cancha1.Delta_taco=((Motor.A.getTachoCount())/360)-((InterfazUsuarioGeneral.cancha1.Memoria_taco)/360);
		  InterfazUsuarioGeneral.cancha1.PosicionRobot_x=InterfazUsuarioGeneral.cancha1.calcular_x();
		  InterfazUsuarioGeneral.cancha1.PosicionRobot_y=InterfazUsuarioGeneral.cancha1.calcular_y();
		  //UsuarioUsuario.Cancha1.Localizacion_Robot();
		  Motor.A.stop();
		  Motor.B.stop(); //Metodo que detiene el movimiento del robot
		  
		 }
	public String toString(){
		return this.nombre;
	}
}
