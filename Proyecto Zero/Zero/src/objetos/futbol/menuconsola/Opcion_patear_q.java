package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Patear;

//Patear
public class Opcion_patear_q extends OpcionDeMenu {
	private Patear Pateo = new Patear(400, "Patear");

	public void ejecutar() {
		Pateo.ejecutar();
	}

	public void parar() {
		Pateo.parar();
	}

}
