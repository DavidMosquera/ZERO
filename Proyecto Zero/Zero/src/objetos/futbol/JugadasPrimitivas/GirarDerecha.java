package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*; //Mirar descripciÃ³n en Adelantar
import objetos.futbol.menuconsola.UsuarioUsuario;

public class GirarDerecha extends jugadaPrimitiva implements Serializable{
	public GirarDerecha (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
	}
	public void ejecutar(){
		first_T();
		UsuarioUsuario.Cancha1.Memoria_taco=Motor.A.getTachoCount();
		UsuarioUsuario.Cancha1.Memoria_angulo=UsuarioUsuario.Cancha1.Angulo_actual;
		Motor.A.backward();//Derecho
		Motor.B.forward();//Izquierdo
		//motorA hacia adelante y motorB hacia atrÃ¡s
	}
	public void parar(){
		UsuarioUsuario.Cancha1.Angulo_actual=UsuarioUsuario.Cancha1.calcular_dir_derecha();
		UsuarioUsuario.Cancha1.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop();
		//Para los motores
	}
}
