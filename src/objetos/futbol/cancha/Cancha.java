package objetos.futbol.cancha;
import objetos.futbol.UI.*;
import java.io.Serializable;
import java.lang.Math;//para poder usar seno y coseno
import lejos.nxt.*;
import objetos.futbol.menuconsola.UsuarioUsuario;

public class Cancha implements Serializable {
	// se está trabajando en milímetros
	private final int largo = 1830;
	private final int ancho = 1220;

	private static String Grafico[][] = new String[13][19]; // Cancha que
															// muestra la
															// posicion del
															// robot.
	private String Memoria_Grafico = " ";
	private int Memoria_XGrafico = 0;
	private int Memoria_YGrafico = 0;
	private int X = 0;
	private int Y = 0;

	public double Memoria_angulo; // Calculamos para allar el angulo actual.
	public double Angulo_actual=0; // Calculamos para las posiciones tanto en X
									// como en Y.
	public int Delta_taco; // Calculamos en cada cambio de jugada.
	public int Memoria_taco; // Calculamos para allar el cambio actual del
								// tacometro.

	public boolean Fuera_de_posicion = false;
	public double PosicionRobot_x=0;
	public double PosicionRobot_y=0;
	private int DireccionRobot;// no se sabe si entero, double o String

	private static short Largo_llantas = 200; // Medida entre las llantas,
												// tomada por los extremos.
	private static short Diametro_rueda = 56; // Diametro de la rueda.
	private static double constante_angulo = ((Math.PI * Diametro_rueda) / Largo_llantas); // Formula:((360*Diametros_ruedas)/Largo_llantas)*/

	public Cancha() {

		//Motor.A.resetTachoCount();
		//Motor.B.resetTachoCount();
		//Motor.C.resetTachoCount();

		// Resetea los tacÃ³metros, pone los valores en 0. (Constructor)
	}

	public void IniciarRobot() {
		PosicionRobot_x = 0;
		PosicionRobot_y = 0;
		DireccionRobot = 0;
		Memoria_taco = 0;
		Memoria_angulo = 0;
		Angulo_actual=0;
		Fuera_de_posicion = false;
		Motor.A.resetTachoCount(); // Motor Derecho reinicia el tacÃ³metro
		Motor.B.resetTachoCount(); // Motor Izquierdo reinicia el tacÃ³metro
		// Reinicia los valores de los atributos.
	}

	public boolean calcularPosicionJugador() {
		
		
		//PosicionRobot_y = this.calcular_y();// actualizar los atributos con
		//PosicionRobot_x = this.calcular_x();// las funciones calcular X y Y
											// respectivamente.
		if (PosicionRobot_x <= 915) {// En UsuarioUsuario identificamos si se
										// necesita cambiar a portero/delantero
			return false; // Retorna falso cuando esta en la posici�n antes de
							// la mitad de la cancha
		} else {
			return true; // Retorna true cuando esta en la posici�n despues de
							// la mitad de la cancha
		}
	}

	public double calcular_x() {
		// operaciones geomÃ©tricas con coseno
		double m = Diametro_rueda * Math.PI * (InterfazUsuarioGeneral.cancha1.Delta_taco);
		
		return (((Math.cos(Math.toRadians( Angulo_actual))) * (m))) + PosicionRobot_x;
		/*
		 * m=DiametroLlantas*Pi*cambio_Tacometro xf= ((cos(angulo))*(m))
		 * +x0(posicoin anterior en x)
		 */
	}

	public double calcular_yR() {
		// operaciones geométricas con seno
		double m = Diametro_rueda * Math.PI * (InterfazUsuarioGeneral.cancha1.Delta_taco);
		return  PosicionRobot_y+(((Math.sin(Angulo_actual)) * (m)));
		/*
		 * m=DiametroLlantas*Pi*cambio_Tacometro yf= ((sen(angulo))*(m))
		 * +x0(posicoin anterior en y)
		 */
	}
	public double calcular_xR() {
		// operaciones geomÃ©tricas con coseno
		double m = Diametro_rueda * Math.PI * (InterfazUsuarioGeneral.cancha1.Delta_taco);
		return  PosicionRobot_x+(((Math.cos(Angulo_actual)) * (m)));
		/*
		 * m=DiametroLlantas*Pi*cambio_Tacometro xf= ((cos(angulo))*(m))
		 * +x0(posicoin anterior en x)
		 */
	}

	public double calcular_y() {
		// operaciones geométricas con seno
		double m = Diametro_rueda * Math.PI * (InterfazUsuarioGeneral.cancha1.Delta_taco);
		return ((((Math.sin(Math.toRadians(Angulo_actual )) * (m)))) + PosicionRobot_y);
		/*
		 * m=DiametroLlantas*Pi*cambio_Tacometro yf= ((sen(angulo))*(m))
		 * +x0(posicoin anterior en y)
		 */
	
	}
	public double calcular_dir_derecha() {
		// fórmulas
		System.out.println("Derecha");
		System.out.println(Motor.A.getTachoCount());
		System.out.println(Motor.B.getTachoCount());
		
		return (Motor.A.getTachoCount()*(0.08511979823))+  Memoria_angulo;
		
		//return ((constante_angulo * (((Motor.A.getTachoCount()) / 360) + (Memoria_taco / 360))/1.1) + Memoria_angulo);
		
		// (constante_angulo*cambio_Tacometro)+ angulo0(angulo anterior)(es + si
		// se gira a la izquierdo)

	}

	public double calcular_dir_izquierda() {
		// fórmulas
		System.out.println("Izquierda");
		System.out.println(Motor.A.getTachoCount());
		System.out.println(Motor.B.getTachoCount());
		
		return -(Motor.B.getTachoCount()*(0.08511979823)) +  Memoria_angulo;
		
		//return (-(constante_angulo * ((Motor.B.getTachoCount() / 360) + (Memoria_taco) / 360)/1.1) + Memoria_angulo);
		// (constante_angulo*cambio_Tacometro)- angulo0(angulo anterior)(es - si
		// se gira a la derecha)
	}

	// get para los valores de la posición en la cancha (ADMIN).
	public void llenarGrafico() { // LLenamos el gráfico mostrado en el Menu
		int i, j;
		for (i = 0; i < 19; i++) {
			for (j = 0; j < 13; j++) {
				Grafico[j][i] = "  *";
			}
		}
		for (j = 0; j < 13; j++) {
			Grafico[j][9] = "  |";
		}
		for (j = 5; j <= 7; j++) {
			Grafico[j][0] = "  �";
			Grafico[j][18] = "  �";
		}
		// this.Localizacion_Robot();
	}

	public String imprimir_fila_Grafico(int a) { // Metodo para imprimir el
													// gráfico
		int i;
		String r = " ";
		for (i = 0; i < 19; i++) {
			r = r + Grafico[a][i];
		}
		return r;
	}

	public void Localizacion_Robot() { // Metodo para cambiar la localizacion
										// del robot
		String n = " *"; // Utilizamos varios metodos, parar ir remplazando
		System.out.println(PosicionRobot_x+" PENE "+PosicionRobot_y);
		if (PosicionRobot_x/100 <= largo && PosicionRobot_y/100 <= ancho && PosicionRobot_x >=
				0 && PosicionRobot_y >= 0) {
			System.out.println("LLEGAMOS A LA POSICION PARA ACTUALIZARLO");
			Memoria_XGrafico = X; // entre valores de la matriz de Strings
			Memoria_YGrafico = Y;
			System.out.println(Angulo_actual);
			int AnguloGrafico = (int) Math.toDegrees(Angulo_actual);
			if(AnguloGrafico>0){
				AnguloGrafico= (AnguloGrafico%360);
			}
			else{
				AnguloGrafico= -(AnguloGrafico%360);
			}
			
			System.out.println(AnguloGrafico);
			Grafico[Memoria_XGrafico][Memoria_YGrafico] = Memoria_Grafico;
			Y = (int) ((((PosicionRobot_x)) / 100)); // Filas
			X = (int) (12-((PosicionRobot_y)) / 100); // Columnas
			Memoria_Grafico = Grafico[X][Y];
			if (AnguloGrafico < 0){
					AnguloGrafico = 360+AnguloGrafico;
			}
			if (AnguloGrafico >= 0) {
				n = String.valueOf(AnguloGrafico);
				if ((AnguloGrafico / 100) <= 0.09) {
					n = "" + n;
				} else if (((AnguloGrafico) / 100) <= 0.9) {
					n = "" + n;
				} else {
				}
			} else {
			}
			Grafico[X][Y] = n;
		} else {
			UsuarioUsuario.Cancha1.Fuera_de_posicion = true; // Retorna cuando
																// se sale de la
																// cancha true

		}
	}

	public double getPosicionRobot_x() {
		return PosicionRobot_x;
	}

	public double getPosicionRobot_y() {
		return PosicionRobot_y;
	}

	public int getDireccionRobot() {
		return DireccionRobot;
	}

}