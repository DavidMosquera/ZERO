package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Adelantar;

//adelante
public class Opcion_adelante_w extends OpcionDeMenu {
	private Adelantar Adelanta = new Adelantar(1080, "Adelantar");

	public void ejecutar() {
		J.ejecutar();
	}

	public void parar() {
		J.parar();
	}
}