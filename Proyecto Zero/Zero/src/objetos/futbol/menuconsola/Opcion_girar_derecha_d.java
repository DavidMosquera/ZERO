package objetos.futbol.menuconsola;

import objetos.futbol.JugadasPrimitivas.GirarDerecha;

//girar derecha
public class Opcion_girar_derecha_d extends OpcionDeMenu {
	private GirarDerecha Giros_Derecha = new GirarDerecha(360, "Girar a la Derecha");

	public void ejecutar() {
		Giros_Derecha.ejecutar();
	}

	public void parar() {
		Giros_Derecha.parar();
	}
}
