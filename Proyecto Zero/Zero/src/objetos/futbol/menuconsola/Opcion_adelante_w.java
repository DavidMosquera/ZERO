package objetos.futbol.menuconsola;

import lejos.nxt.Motor;
import objetos.futbol.JugadasPrimitivas.Adelantar;

//adelante
class Opcion_adelante_w extends OpcionDeMenu {
	private Adelantar Adelanto = new Adelantar(1080, "Adelantar");
	
	void ejecutar() {
		Adelanto.ejecutar();
	}

	void parar() {
		Adelanto.parar();
	}
}
