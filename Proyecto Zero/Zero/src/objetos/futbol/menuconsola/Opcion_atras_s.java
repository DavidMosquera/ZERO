package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.Retroceder;

//atras
public class Opcion_atras_s extends OpcionDeMenu {
	private Retroceder Retrocede = new Retroceder(1080, "Retroceder");

	public void ejecutar() {
		Retrocede.ejecutar();
	}

	public void parar() {
		Retrocede.parar();
	}
}
