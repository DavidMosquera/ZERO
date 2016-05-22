package objetos.futbol.menuconsola;

import lejos.nxt.Motor;
import objetos.futbol.JugadasPrimitivas.Adelantar;

//adelante
public class Opcion_adelante_w extends OpcionDeMenu {
	private Adelantar Adelanto = new Adelantar(1080, "Adelantar");
	
	public void ejecutar() {
		Adelanto.ejecutar();
	}

	public void parar() {
		Adelanto.parar();
	}
}
