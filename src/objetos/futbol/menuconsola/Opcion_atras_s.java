package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Retroceder;

//atras
class Opcion_atras_s extends OpcionDeMenu {
	private Retroceder Retrocede = new Retroceder(1080, "Retroceder");

	void ejecutar() {
		Retrocede.ejecutar();
	}

	void parar() {
		Retrocede.parar();
	}
}
