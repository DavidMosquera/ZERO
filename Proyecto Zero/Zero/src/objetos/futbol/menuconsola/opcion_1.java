package objetos.futbol.menuconsola;
import objetos.futbol.JugadasPrimitivas.Adelantar;
//adelante
public class opcion_1 extends OpcionDeMenu{
	private Adelantar J = new Adelantar(1080,"Adelantar");
	public void ejecutar(){
		J.ejecutar();
	}
	public void parar(){
		J.parar();
	}
}

