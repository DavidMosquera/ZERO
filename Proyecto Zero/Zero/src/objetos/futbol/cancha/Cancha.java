package objetos.futbol.cancha;
import java.lang.Math;//para poder usar seno y coseno
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand; // importamos la conexÃ³n bluethoot
import lejos.pc.comm.*;

public class Cancha {
	//se está trabajando en milímetros
	static final int largo=1830;
	static final int ancho=1220;
	public static String Grafico[][] = new String [13][19]; //Cancha que muestra la posicion del robot.
	
	public static double Memoria_angulo; // Calculamos para allar el angulo actual.
	public static double Angulo_actual; // Calculamos para las posiciones tanto en X como en Y.
	public static int Delta_taco; // Calculamos en cada cambio de jugada.
	public static int Memoria_taco; // Calculamos para allar el cambio actual del tacometro.
	
	public static boolean Fuera_de_posicion=false;
	public static double PosicionRobot_x; // Static?
	public static double PosicionRobot_y;
	public static int DireccionRobot;//no se sabe si entero, double o String
	
	private NXTConnector conex = new NXTConnector();
	private static short Largo_llantas=135; // Medida entre las llantas, tomada por los extremos.
	private static short Diametro_rueda=56; // Diametro de la rueda.
	private static int constante_angulo=((360*Diametro_rueda)/Largo_llantas) ; //Formula:((360*Diametros_ruedas)/Largo_llantas)*/
	
	
	public Cancha(){
		NXTCommandConnector.setNXTCommand(new NXTCommand(conex.getNXTComm())); //Comunica con el robot
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		Memoria_taco=0;
		Memoria_angulo=0;
		
		//Resetea los tacÃ³metros, pone los valores en 0. (Constructor)
	}
	
	public void IniciarRobot(){
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		Motor.A.resetTachoCount(); // Motor Derecho reinicia el tacÃ³metro
		Motor.B.resetTachoCount(); // Motor Izquierdo reinicia el tacÃ³metro
		//Reinicia los valores de los atributos.
	}
	
	public static boolean calcularPosicionJugador(){
		PosicionRobot_y=Cancha.calcular_y();//actualizar los atributos con 
		PosicionRobot_x=Cancha.calcular_x();//las funciones calcular X y Y respectivamente.
		//FALTA: VER SI ES DELANTERO O PORTERO Y RETORNAR TRUE OR FALSE
		//utilizar las medidas
		return true;
	}
	public static double calcular_x(){
		//operaciones geomÃ©tricas con coseno
		double m=Diametro_rueda*Math.PI*(Motor.A.getTachoCount()-Memoria_taco);
		return ((Math.cos(Memoria_angulo+Angulo_actual))*(m))+ PosicionRobot_x;
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			xf= ((cos(angulo))*(m)) +x0(posicoin anterior en x)
		*/
	}
	public static double calcular_y(){
		//operaciones geométricas con seno
		double m=Diametro_rueda*Math.PI*(Motor.A.getTachoCount()-Memoria_taco);
		return ((Math.sin(Memoria_angulo+Angulo_actual))*(m))+ PosicionRobot_y;
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			yf= ((sen(angulo))*(m)) +x0(posicoin anterior en y)
		*/
	}
	public static double calcular_dir_derecha(){
		//fórmulas
		return(constante_angulo*(Motor.A.getTachoCount()-Memoria_taco)-Memoria_angulo);
		//(constante_angulo*cambio_Tacometro)+ angulo0(angulo anterior)(es + si se gira a la izquierdo)
		
	}
	public static double calcular_dir_izquierda(){
		//fórmulas
		return(constante_angulo*(Motor.A.getTachoCount()-Memoria_taco)+Memoria_angulo);
		//(constante_angulo*cambio_Tacometro)- angulo0(angulo anterior)(es - si se gira a la derecha)
	}
	//get para los valores de la posición en la cancha (ADMIN).
	public static void llenarGrafico(){ // LLenamos el gráfico mostrado en el Menu
		int i,j;
		for(i=0;i<19;i++){
			for (j=0; j<13;j++){
				Grafico[j][i]="  *";
			}
		}
		for (j=0;j<13;j++){
			Grafico[j][9]= "  |";
		}
		for (j=5;j<=7;j++){
			Grafico[j][0]="  °";
			Grafico[j][18]="  °";
		}	
		Grafico[12][0]="000";
	}
	public static String imprimir_fila_Grafico(int a){ //Metodo para imprimir el gráfico
		int i;
		String r=" ";
		for (i=0;i<19;i++){
			r=r+Grafico[a][i];
		}
		return r;
	}
	public static void Localizacion_Robot(){
		
	}
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
