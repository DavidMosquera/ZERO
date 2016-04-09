package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*; //Mirar descripciÃ³n en Adelantar
import objetos.futbol.menuconsola.UsuarioUsuario;

public class GirarDerecha extends jugadaPrimitiva {
	public GirarDerecha (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
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
