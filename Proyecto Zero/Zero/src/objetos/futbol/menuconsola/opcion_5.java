package objetos.futbol.menuconsola;
import objetos.futbol.JugadasPrimitivas.Patear;
//Patear
public class opcion_5 extends OpcionDeMenu {
	private Patear J = new Patear(1080, "Patear");
	public void ejecutar(){
		J.ejecutar();
	}
	public void parar(){
		J.parar();
	}

}
