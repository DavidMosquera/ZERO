package objetos.futbol.menuconsola;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*; 
// Conectarse al rob�t
public class opcion_0 extends OpcionDeMenu {
	public void ejecutar(){
		NXTConnector conn = new NXTConnector();
		conn.connectTo();
	}

}
