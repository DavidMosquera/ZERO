package objetos.futbol.cancha;
import java.io.Serializable;
import java.lang.Math;//para poder usar seno y coseno
import lejos.nxt.*;
import objetos.futbol.menuconsola.UsuarioUsuario;

public class Cancha implements Serializable{
	//se estÃ¡ trabajando en milÃ­metros
	protected final int largo=1830;
	protected final int ancho=1220;
	
	private static String Grafico[][] = new String [13][19]; //Cancha que muestra la posicion del robot.
	private String Memoria_Grafico=" ";
	private int Memoria_XGrafico=0;
	private int Memoria_YGrafico=0;
	private int X=0;
	private int Y=0;
	
	public double Memoria_angulo; // Calculamos para allar el angulo actual.
	public double Angulo_actual; // Calculamos para las posiciones tanto en X como en Y.
	public int Delta_taco; // Calculamos en cada cambio de jugada.
	public int Memoria_taco; // Calculamos para allar el cambio actual del tacometro.
	
	public boolean Fuera_de_posicion=false;
	private double PosicionRobot_x;
	private double PosicionRobot_y;
	private int DireccionRobot;//no se sabe si entero, double o String
	
	private static short Largo_llantas=135; // Medida entre las llantas, tomada por los extremos.
	private static short Diametro_rueda=56; // Diametro de la rueda.
	private static double constante_angulo=((Math.PI*Diametro_rueda)/Largo_llantas) ; //Formula:((360*Diametros_ruedas)/Largo_llantas)*/
	
	
	public Cancha(){
		
		Motor.A.resetTachoCount();
		Motor.B.resetTachoCount();
		Motor.C.resetTachoCount();
		
		
		//Resetea los tacÃƒÂ³metros, pone los valores en 0. (Constructor)
	}
	
	public void IniciarRobot(){
		PosicionRobot_x=0;
		PosicionRobot_y=0;
		DireccionRobot=0;
		Memoria_taco=0;
		Memoria_angulo=0;
		Fuera_de_posicion=false;
		Motor.A.resetTachoCount(); // Motor Derecho reinicia el tacÃƒÂ³metro
		Motor.B.resetTachoCount(); // Motor Izquierdo reinicia el tacÃƒÂ³metro
		//Reinicia los valores de los atributos.
	}
	
	public boolean calcularPosicionJugador(){
		PosicionRobot_y=this.calcular_y();//actualizar los atributos con 
		PosicionRobot_x=this.calcular_x();//las funciones calcular X y Y respectivamente.
		if (PosicionRobot_x<=915){//En UsuarioUsuario identificamos si se necesita cambiar a portero/delantero
			return false; //Retorna falso cuando esta en la posición antes de la mitad de la cancha
		}
		else {
			return true; //Retorna true cuando esta en la posición despues de la mitad de la cancha
		}
	}
	public double calcular_x(){
		//operaciones geomÃƒÂ©tricas con coseno
		double m=Diametro_rueda*Math.PI*(UsuarioUsuario.Cancha1.Delta_taco);
		return (((Math.cos(Memoria_angulo+Angulo_actual))*(m)))+ PosicionRobot_x;
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			xf= ((cos(angulo))*(m)) +x0(posicoin anterior en x)
		*/
	}
	public double calcular_y(){
		//operaciones geomÃ©tricas con seno
		double m=Diametro_rueda*Math.PI*(UsuarioUsuario.Cancha1.Delta_taco);
		return (((Math.sin(Memoria_angulo+Angulo_actual))*(m)))+ PosicionRobot_y;
		/*
			m=DiametroLlantas*Pi*cambio_Tacometro
			yf= ((sen(angulo))*(m)) +x0(posicoin anterior en y)
		*/
	}
	public double calcular_dir_derecha(){
		//fÃ³rmulas
		return(-(constante_angulo*(((Motor.A.getTachoCount())/360)-(Memoria_taco/360)))+Memoria_angulo);
		//(constante_angulo*cambio_Tacometro)+ angulo0(angulo anterior)(es + si se gira a la izquierdo)
		
	}
	public double calcular_dir_izquierda(){
		//fÃ³rmulas
		return(constante_angulo*((Motor.A.getTachoCount()/360)-(Memoria_taco)/360)+Memoria_angulo);
		//(constante_angulo*cambio_Tacometro)- angulo0(angulo anterior)(es - si se gira a la derecha)
	}
	//get para los valores de la posiciÃ³n en la cancha (ADMIN).
	public void llenarGrafico(){ // LLenamos el grÃ¡fico mostrado en el Menu
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
			Grafico[j][0]="  Â°";
			Grafico[j][18]="  Â°";
		}	
		//this.Localizacion_Robot();
	}
	public String imprimir_fila_Grafico(int a){ //Metodo para imprimir el grÃ¡fico
		int i;
		String r=" ";
		for (i=0;i<19;i++){
			r=r+Grafico[a][i];
		}
		return r;
	}
	
	public void Localizacion_Robot(){     //Metodo para cambiar la localizacion del robot
		String n=" *";                    // Utilizamos varios metodos, parar ir remplazando
		if(PosicionRobot_x<=1830&&PosicionRobot_y<=1220){
	    Memoria_XGrafico=X;               // entre valores de la matriz de Strings
	    Memoria_YGrafico=Y;
	    int AnguloGrafico= (int) Math.toDegrees(Angulo_actual);
		Grafico[Memoria_XGrafico][Memoria_YGrafico]=Memoria_Grafico;
		Y=(int)((12-((PosicionRobot_x))/100)); //Filas
		X=(int)(((PosicionRobot_y))/100); //Columnas
		Memoria_Grafico=Grafico[X][Y];
		if (AnguloGrafico>=360){
			AnguloGrafico=AnguloGrafico-(AnguloGrafico%360)*360;
		}
		else if(AnguloGrafico<0){
			if (AnguloGrafico<=-360){
				int  mod = ((-1)*AnguloGrafico)%360;
				AnguloGrafico= 360+(AnguloGrafico+(360*mod));
			}
			else{
				AnguloGrafico=360+AnguloGrafico;
			}
		}
		if (AnguloGrafico>=0){
			n = String.valueOf(AnguloGrafico);
			if((AnguloGrafico/100)<=0.09){
				n="00"+n;
			}
			else if (((AnguloGrafico)/100)<=0.9){
				n="0"+n;	
			}
			else{
			}
		}
		else{
		}
		Grafico[X][Y]=n;
		}
		else{
			UsuarioUsuario.Cancha1.Fuera_de_posicion=true; // Retorna cuando se sale de la cancha true	
		}
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
