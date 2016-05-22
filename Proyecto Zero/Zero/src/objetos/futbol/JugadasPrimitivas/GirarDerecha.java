package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*; //Mirar descripciÃ³n en Adelantar
import objetos.futbol.UI.InterfazUsuarioGeneral;
import objetos.futbol.menuconsola.UsuarioUsuario;

public class GirarDerecha extends jugadaPrimitiva implements Serializable{
	public GirarDerecha (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
	}
	public void ejecutar(){
		first_T();
		InterfazUsuarioGeneral.cancha1.Memoria_taco=Motor.A.getTachoCount();
		InterfazUsuarioGeneral.cancha1.Memoria_angulo=InterfazUsuarioGeneral.cancha1.Angulo_actual;
		Motor.A.backward();//Derecho
		Motor.B.forward();//Izquierdo
		//motorA hacia adelante y motorB hacia atrÃ¡s
	}
	public void parar(){
		InterfazUsuarioGeneral.cancha1.Angulo_actual=InterfazUsuarioGeneral.cancha1.calcular_dir_derecha();
		//UsuarioUsuario.Cancha1.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop();
		//Para los motores
	}
	public String toString(){
		return this.nombre;
	}
}
