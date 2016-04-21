package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;//mirar descripcion en Adelantar
import objetos.futbol.menuconsola.UsuarioUsuario;

public class Retroceder extends jugadaPrimitiva implements Serializable{
	public Retroceder(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		
	}
	public void ejecutar(){
		first_T();
		UsuarioUsuario.Cancha1.Memoria_taco=Motor.A.getTachoCount();
		
		Motor.A.backward();//izquierdo
		Motor.B.backward();//derecho
		//los dos motores hacia atrÃ¡s
	}
	public void parar(){ //DeltaNegativo ?
		  UsuarioUsuario.Cancha1.Delta_taco=-((Motor.A.getTachoCount())/360)-((UsuarioUsuario.Cancha1.Memoria_taco)/360);
		  UsuarioUsuario.Cancha1.calcularPosicionJugador();
		  UsuarioUsuario.Cancha1.Localizacion_Robot();
		  Motor.A.stop();
		  Motor.B.stop();
		  //para los motores
		 }
		}