package objetos.futbol.JugadasPrimitivas;
import lejos.nxt.*; //Mirar descripciÃ³n en Adelantar
import objetos.futbol.cancha.*;

public class GirarDerecha extends jugadaPrimitiva {
	public GirarDerecha (int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		Motor.A.setSpeed(potencia);
		Motor.B.setSpeed(potencia);
	}
	public void ejecutar(){
		Cancha.Memoria_taco=Motor.A.getTachoCount();
		Cancha.Memoria_angulo=Cancha.Angulo_actual;
		Motor.A.backward();//Derecho
		Motor.B.forward();//Izquierdo
		//motorA hacia adelante y motorB hacia atrÃ¡s
	}
	public void parar(){
		Cancha.Angulo_actual=Cancha.calcular_dir_derecha();
		Cancha.Localizacion_Robot();
		Motor.A.stop();
		Motor.B.stop();
		//Para los motores
	}
}
