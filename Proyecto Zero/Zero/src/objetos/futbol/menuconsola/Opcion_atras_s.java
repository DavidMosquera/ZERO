package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Retroceder;

//atras
public class Opcion_atras_s extends OpcionDeMenu {
	private Retroceder Retrocede = new Retroceder(1080, "Retroceder");

	public void ejecutar() {
		J.ejecutar();
	}

	public void parar() {
		J.parar();
	}
}
