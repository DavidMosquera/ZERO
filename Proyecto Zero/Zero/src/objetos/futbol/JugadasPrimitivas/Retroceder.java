package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;//mirar descripcion en Adelantar
import objetos.futbol.cancha.Cancha;

public class Retroceder extends jugadaPrimitiva {
	public Retroceder(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Cancha.Memoria_taco=Motor.A.getTachoCount(); //Guardamos El Tacometro
		
		Motor.A.backward();//izquierdo
		Motor.B.backward();//derecho
		//los dos motores hacia atrÃ¡s
	}
	public void parar(){
		Cancha.Delta_taco=-Motor.A.getTachoCount()+Cancha.Memoria_taco; //Encontramos el delta
		Cancha.Fuera_de_posicion=Cancha.calcularPosicionJugador(); //Aplicamos la formula para las posiciones
		Motor.A.stop();
		Motor.B.stop();
		//para los motores
	}
}
