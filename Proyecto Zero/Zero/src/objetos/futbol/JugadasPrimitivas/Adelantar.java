package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*;//no sabemos especificamente que vamos a importar pero en este caso los motores
import objetos.futbol.cancha;

class Adelantar extends jugadaPrimitiva {
	
	public Adelantar(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);//supomenos que así se pone la velocidad con respespecto a la potencia
	}
	public void ejecutar(){
		Delta_Taco=Motor.A.getTachoCount();
		Motor.A.forward();//izquierdo=A
		Motor.B.forward();//derecho=B
		
		//los dos motores hacia adelante
	}
	public void parar(){
		Motor.A.stop();
		Motor.B.stop(); // D#16 No encontramos como calcular desde las jugadas primitivas la posición 
		//X y Y en la cancha
		
	}
	public static double Delta_PrimTaco(double a){
		return Motor.A.getTachoCount()-a;
		
	}
}
