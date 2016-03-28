package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*; //Mirar descripción en Adelantar

class GirarDerecha extends jugadaPrimitiva {
	public GirarDerecha (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Motor.A.forward();//izquierdo
		Motor.B.backward();//derecho
		//motorA hacia adelante y motorB hacia atrás
	}
	public void parar(){
		Motor.A.stop();
		Motor.B.stop();
		//Para los motores
	}
}
