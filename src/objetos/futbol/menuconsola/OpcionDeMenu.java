package objetos.futbol.menuconsola; //Super clase de tipo OPCION DE MENU ABSTRACTA

import java.io.IOException;

public abstract class OpcionDeMenu {
	public abstract void ejecutar() throws IOException;
	public abstract void parar();
}
