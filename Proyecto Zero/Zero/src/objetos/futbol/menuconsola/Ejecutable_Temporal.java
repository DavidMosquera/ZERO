package objetos.futbol.menuconsola;
import java.io.FileNotFoundException;
import java.io.IOException;

import objetos.futbol.cancha.Cancha;
public class Ejecutable_Temporal {
	public static void main (String[]args) throws IOException{
		
		Cancha.llenarGrafico();
		MenuDeConsola Alpha = new MenuDeConsola();
		Alpha.lanzarMenu();
		
	}
}
