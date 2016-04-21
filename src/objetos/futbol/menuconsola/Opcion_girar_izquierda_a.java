package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.GirarIzquierda;

//giro izquierda
class Opcion_girar_izquierda_a extends OpcionDeMenu {
	private GirarIzquierda Giros_Izquierda = new GirarIzquierda(360, "Girar a la Izquierda");

	void ejecutar() {
		Giros_Izquierda.ejecutar();
	}

	void parar() {
		Giros_Izquierda.parar();
	}
}
