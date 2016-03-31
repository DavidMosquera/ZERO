package objetos.futbol.menuconsola;
import lejos.nxt.Motor;
//parar
public class opcion_6 extends OpcionDeMenu {
	public void ejecutar(){
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();	
	}
}
