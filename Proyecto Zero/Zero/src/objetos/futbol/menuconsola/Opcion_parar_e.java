package objetos.futbol.menuconsola;

import lejos.nxt.Motor;

//parar
class Opcion_parar_e extends OpcionDeMenu {
	void ejecutar() {
		Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop();
	}
	void parar(){
		
	}
}
