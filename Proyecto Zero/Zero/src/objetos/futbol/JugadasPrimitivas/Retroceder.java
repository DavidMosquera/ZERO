package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;//mirar descripcion en Adelantar

class Retroceder extends jugadaPrimitiva {
	public Retroceder(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Motor.A.backward();//izquierdo
		Motor.B.backward();//derecho
		//los dos motores hacia atrás
	}
	public void parar(){
		Motor.A.stop();
		Motor.B.stop();
		//para los motores
	}
}
