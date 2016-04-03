package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;//no sabemos especificamente que vamos a importar pero en este caso los motores
import objetos.futbol.cancha.Cancha; // IMPORTANTE: Despues de la propuesta de maÃ±ana del MenÃº, determinaremos donde poner 
//y donde calcular la posiciÃ³n del jugador, por lo que veo serÃ¡ mÃ¡s sencillo despÃºes de plantear lo que tengo en mente.

public class Adelantar extends jugadaPrimitiva {
	
	public Adelantar(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);//supomenos que asÃ­ se pone la velocidad con respespecto a la potencia
	}
	public void ejecutar(){
		Cancha.Memoria_taco=Motor.A.getTachoCount();
		Motor.A.forward();//Derecho=A
		Motor.B.forward();//Izquierdo=B
		//los dos motores hacia adelante
	}
	public void parar(){
		Cancha.Delta_taco=Motor.A.getTachoCount()-Cancha.Memoria_taco;
		Cancha.Fuera_de_posicion=Cancha.calcularPosicionJugador();
		Cancha.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop(); //Metodo que detiene el movimiento del robot
		
	}
}
