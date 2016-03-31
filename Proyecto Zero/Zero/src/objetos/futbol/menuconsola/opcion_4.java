package objetos.futbol.menuconsola;
import objetos.futbol.JugadasPrimitivas.GirarDerecha;
//girar derecha
public class opcion_4 extends OpcionDeMenu {
	private GirarDerecha J = new GirarDerecha(1080, "Girar a la Derecha");
	public void ejecutar(){
		J.ejecutar();
	}
	public void parar(){
		J.parar();
	}
}
