package objetos.futbol.cancha;
import java.lang.Math;//para poder usar seno y coseno
import lejos.nxt.*;
import objetos.futbol.jugadores.*;
import lejos.nxt.remote.NXTCommand; // importamos la conexón bluethoot
import lejos.pc.comm.*; 

public class Cancha {
	//se está trabajando en milímetros
	static final double largo=1830;
	static final double ancho=1220;
	
	public static int Memoria_angulo; // Calculamos para allar el angulo actual.
	public static int Angulo_actual; // Calculamos para las posiciones tanto en X como en Y.
	public static double Delta_taco; // Calculamos en cada cambio de jugada.
	public static double Memoria_taco; // Calculamos para allar el cambio actual del tacometro.
	
	public static double PosicionRobot_x; // Static?
	public static double PosicionRobot_y;
	public static int DireccionRobot;//no se sabe si entero, double o String
	
	private NXTConnector conex = new NXTConnector();
	private final short Largo_llantas=0; // Necesitamos la medida entre las llantas de robot.
	private final short Diametro_rueda=0; // Necesitamos la medida del diametro de una de las ruedas.
	private final double constante_angulo=((360*Diametro_rueda)/Largo_llantas) ; //Fórmula:((360*Diametros_ruedas)/Largo_llantas)*/
	
	
	public Cancha(){
		NXTCommandConnector.setNXTCommand(new NXTCommand(conex.getNXTComm())); //Comunica con el robot
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		//Resetea los tacómetros, pone los valores en 0. (Constructor)
	}
	
	public void IniciarRobot(){
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		Motor.A.resetTachoCount(); // Motor Derecho reinicia el tacómetro
		Motor.B.resetTachoCount(); // Motor Izquierdo reinicia el tacómetro
		//Reinicia los valores de los atributos.
	}
	
	public static boolean calcularPosicionJugador(){
		//acturalizar los atributos con las funciones calcular
		//Vemos si es delantero o portero
		//si se sale return false, de lo contrario true
		//utilizar las medidas
		return true;
	}
	public double calcular_x(){
		//operaciones geométricas con coseno
		double m=Diamentro_llanta*Math.PI*(Motor.A.getTachoCount()-Memoria_taco);
		return ((Math.cos(Memoria_angulo+Angulo_actual))*(m))+ PosicionRobot_x;
		
		
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			xf= ((cos(angulo))*(m)) +x0(posicoin anterior en x)
		*/
		double x=0;
		return x;
	}
	public double calcuar_y(){
		//operaciones geometricas con seno
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			yf= ((sen(angulo))*(m)) +x0(posicoin anterior en y)
		*/
		double y=0;
		return y;
	}
	public int calcular_dir(){
		//furmulas
		//(constante_angulo*cambio_Tacometro)+ angulo0(angulo anterior)(es + si se gira a la izquierdo)
		//(constante_angulo*cambio_Tacometro)- angulo0(angulo anterior)(es - si se gira a la derecha)
		int dir=0;
		return dir;
	}
	//set (no se si quitarlos)
	public void setPosicionRobot_x(double Posicion_Robotx){
		this.PosicionRobot_x=Posicion_Robotx;
	}
	public void setPosicionRobot_y(double Posicion_Roboty){
		this.PosicionRobot_y=Posicion_Roboty;
	}
	public void setDireccionRobot(int DireccionRobot){
		this.DireccionRobot=DireccionRobot;
	}
	//get (no se si quitarlos)
	public double getPosicionRobot_x(){
		return PosicionRobot_x;
	}
	public double getPosicionRobot_y(){
		return PosicionRobot_y;
	}
	public int getDireccionRobot(){
		return DireccionRobot;
	}
	
	
	
}
