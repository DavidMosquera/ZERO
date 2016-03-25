package objetos.futbol.cancha;
import java.lang.Math;//para poder usar seno y coseno

class Cancha {
	//se está trabajando en milímetros
	static final double largo=1830;
	static final double ancho=1220;
	
	private double PosicionRobot_x;
	private double PosicionRobot_y;
	private int DireccionRobot;//no se sabe si entero, double o String
	
	private final double constante_angulo=0; //no es 0, hay que calvularla con la formula
	/*((360*Diametros_ruedas*cambio_tacometro)/Largo_llantas)*/
	
	
	public Cancha(/*como parametro los motores o algun referente*/){
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		/*se tienen que reinicar los tacometros de los motores*/
	}
	
	public void IniciarRobot(){
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
	}
	
	public boolean calcularPosicionJugador(){//no se que pareametros pasar
		//acturalizar los atributos con las funciones calcular
		//ver si sa sale de la cancha o no
		//si se sale return false, de lo contrario true
		//utilizar las medidas
		return true;
	}
	private double calcular_x(){
		//operaciones geométricas con coseno
		double x=0;
		return x;
	}
	private double calcuar_y(){
		//operaciones geometricas con seno
		double y=0;
		return y;
	}
	private int calcular_dir(){
		//operaciones con la constante 
		int dir=0;
		return dir;
	}
	public void setPosicionRobot_x(double Posicion_Robotx){
		this.PosicionRobot_x=Posicion_Robotx;
	}
	public void setPosicionRobot_y(double Posicion_Roboty){
		this.PosicionRobot_y=Posicion_Roboty;
	}
	public void setDireccionRobot(int DireccionRobot){
		this.DireccionRobot=DireccionRobot;
	}
	
}