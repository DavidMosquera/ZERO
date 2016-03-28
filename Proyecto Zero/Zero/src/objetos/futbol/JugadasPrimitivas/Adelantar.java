import lejos.nxt.*;//no sabemos especificamente que vamos a importar pero en este caso los motores

package objetos.futbol.JugadasPrimitivas;

class Adelantar extends jugadaPrimitiva {
	public Adelantar(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);//supomenos que así se pone la velocidad con respespecto a la potencia
	}
	public void ejecutar(){
		Motor.A.forward();//izquierdo=A
		Motor.B.forward();//derecho=B
		
		//los dos motores hacia adelante
	}
	public void parar(){
		Motor.A.stop();
		Motor.B.stop();
		//detiene los motores
		
	}
}
