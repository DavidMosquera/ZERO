package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.GirarDerecha;

//girar derecha
class Opcion_girar_derecha_d extends OpcionDeMenu {
	private GirarDerecha Giros_Derecha = new GirarDerecha(360, "Girar a la Derecha");

	void ejecutar() {
		Giros_Derecha.ejecutar();
	}

	void parar() {
		Giros_Derecha.parar();
	}
}
