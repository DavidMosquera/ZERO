package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.GirarDerecha;

//girar derecha
public class Opcion_girar_derecha_d extends OpcionDeMenu {
	private GirarDerecha J = new GirarDerecha(1080, "Girar a la Derecha");

	public void ejecutar() {
		J.ejecutar();
	}

	public void parar() {
		J.parar();
	}
}
