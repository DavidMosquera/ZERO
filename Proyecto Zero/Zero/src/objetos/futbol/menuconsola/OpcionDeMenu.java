package objetos.futbol.menuconsola; //Super clase de tipo OPCION DE MENU ABSTRACTA

import java.io.IOException;

abstract class OpcionDeMenu {
	abstract void ejecutar() throws IOException;
	abstract void parar();
}
