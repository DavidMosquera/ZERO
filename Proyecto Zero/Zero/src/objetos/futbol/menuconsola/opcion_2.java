package objetos.futbol.menuconsola;
import objetos.futbol.JugadasPrimitivas.Retroceder;
//atras
public class opcion_2 extends OpcionDeMenu{
	private Retroceder J = new Retroceder (1080, "Retroceder");
	public void ejecutar(){
		J.ejecutar();
	}
	public void parar(){
		J.parar();
	}
}
