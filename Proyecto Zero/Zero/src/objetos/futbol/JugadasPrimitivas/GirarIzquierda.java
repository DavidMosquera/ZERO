package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;

class GirarIzquierda extends jugadaPrimitiva {
	public GirarIzquierda (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Motor.A.backward();//izquierdo
		Motor.B.forward();//derecho
		//motorA hacia atras y motorB hacia adelante
	}
	public void parar(){
		Motor.A.stop();
		Motor.B.stop();
		//parar ambos motores	
	}
}

