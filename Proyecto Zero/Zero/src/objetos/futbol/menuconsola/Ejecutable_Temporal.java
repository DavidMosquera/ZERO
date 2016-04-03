package objetos.futbol.menuconsola;
import java.io.FileNotFoundException;
import objetos.futbol.cancha.Cancha;
public class Ejecutable_Temporal {
	public static void main (String[]args) throws FileNotFoundException{
		Cancha.llenarGrafico();
		MenuDeConsola Alpha = new MenuDeConsola();
		Cancha Cancha1 = new Cancha ();
		Alpha.lanzarMenu();
		
	}
}
