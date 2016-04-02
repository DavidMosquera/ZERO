package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.GirarIzquierda;

//giro izquierda
public class Opcion_girar_izquierda_a extends OpcionDeMenu {
	private GirarIzquierda Giros_Izquierda = new GirarIzquierda(1080, "Girar a la Izquierda");

	public void ejecutar() {
		Giros_Izquierda.ejecutar();
	}

	public void parar() {
		Giros_Izquierda.parar();
	}
}
