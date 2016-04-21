package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Patear;

//Patear
class Opcion_patear_q extends OpcionDeMenu {
	private Patear Pateo = new Patear(400, "Patear");

	void ejecutar() {
		Pateo.ejecutar();
	}

	void parar() {
		Pateo.parar();
	}

}
