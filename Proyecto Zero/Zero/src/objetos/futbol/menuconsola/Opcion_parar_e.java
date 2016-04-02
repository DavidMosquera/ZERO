package objetos.futbol.menuconsola;

import lejos.nxt.Motor;

//parar
public class Opcion_parar_e extends OpcionDeMenu {
	public void ejecutar() {
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
	}
}
