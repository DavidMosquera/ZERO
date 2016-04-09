package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;//mirar descripcion en Adelantar
import objetos.futbol.menuconsola.UsuarioUsuario;

public class Retroceder extends jugadaPrimitiva {
	public Retroceder(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		UsuarioUsuario.Cancha1.Memoria_taco=Motor.A.getTachoCount();
		
		Motor.A.backward();//izquierdo
		Motor.B.backward();//derecho
		//los dos motores hacia atrÃ¡s
	}
	public void parar(){
		UsuarioUsuario.Cancha1.Delta_taco=-Motor.A.getTachoCount()+UsuarioUsuario.Cancha1.Memoria_taco;
		UsuarioUsuario.Cancha1.Fuera_de_posicion=UsuarioUsuario.Cancha1.calcularPosicionJugador();
		UsuarioUsuario.Cancha1.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop();
		//para los motores
	}
}
