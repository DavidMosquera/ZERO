package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;
import objetos.futbol.cancha.Cancha;

public class GirarIzquierda extends jugadaPrimitiva {
	public GirarIzquierda (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Cancha.Memoria_taco=Motor.A.getTachoCount();
		Cancha.Memoria_angulo=Cancha.Angulo_actual;
		Motor.A.forward();//Derecho
		Motor.B.backward();//Izquierdo
		//motorA hacia atras y motorB hacia adelante
	}
	public void parar(){
		Cancha.Angulo_actual=Cancha.calcular_dir_izquierda();
		Motor.A.stop();
		Motor.B.stop();
		//parar ambos motores	
	}
}

