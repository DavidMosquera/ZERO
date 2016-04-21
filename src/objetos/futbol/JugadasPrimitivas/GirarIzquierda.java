package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;
import objetos.futbol.menuconsola.UsuarioUsuario;

public class GirarIzquierda extends jugadaPrimitiva implements Serializable{
	public GirarIzquierda (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
	}
	public void ejecutar(){
		first_T();
		UsuarioUsuario.Cancha1.Memoria_taco=Motor.B.getTachoCount();
		UsuarioUsuario.Cancha1.Memoria_angulo=UsuarioUsuario.Cancha1.Angulo_actual;
		Motor.A.forward();//Derecho
		Motor.B.backward();//Izquierdo
		//motorA hacia atras y motorB hacia adelante
	}
	public void parar(){
		UsuarioUsuario.Cancha1.Angulo_actual=UsuarioUsuario.Cancha1.calcular_dir_izquierda();
		UsuarioUsuario.Cancha1.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop();
		//parar ambos motores	
	}
}

