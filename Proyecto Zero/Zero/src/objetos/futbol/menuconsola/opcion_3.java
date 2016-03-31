package objetos.futbol.menuconsola;
import objetos.futbol.JugadasPrimitivas.GirarIzquierda;
//giro izquierda
public class opcion_3 extends OpcionDeMenu {
	private GirarIzquierda J = new GirarIzquierda(1080,"Girar a la Izquierda");
	public void ejecutar(){
		J.ejecutar();	
	}
	public void parar(){
		J.parar();
	}
}
