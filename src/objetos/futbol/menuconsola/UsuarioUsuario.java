package objetos.futbol.menuconsola;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTCommandConnector;
import lejos.pc.comm.NXTConnector;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;

public class UsuarioUsuario extends Usuario  {
	public static Cancha Cancha1 = new Cancha();
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	private Scanner scanner = new Scanner(System.in);
	private String usuario_nombre;
	private String usuario_contrasena;
	private boolean arquero_delantero = false; // FALSE = ARQUERO TRUE =
												// DELANTERO
	long tiempo_inicial;
	private String memoria = "0";
	static int goles_a_favor,goles_en_contra;//son estaticas para no tener que cabiarlas
	PrintStream EscritorTemporal;
	

	static Delantero delantero;
	static Arquero arquero;
	// no se si la opcion 7 es suficiente para salir

	UsuarioUsuario(String usuario_nombre, String usuario_contrasena) {
		this.usuario_nombre = usuario_nombre;
		this.usuario_contrasena = usuario_contrasena;
	}

	void ejecutar() throws IOException {
		EscritorTemporal = new PrintStream(new FileOutputStream("Temporal.txt"));
		//Cancha1.llenarGrafico();
		PrintStream EscritorTemporal = new PrintStream(new FileOutputStream("Temporal.txt"));
		NXTConnector conn = new NXTConnector();
		/*
		 * if (!conn.connectTo("NXT_5", NXTComm.LCP)){ System.err.println(
		 * "Conexion Fallida"); System.exit(1); }
		 */
		//UsuarioUsuario.Cancha1.IniciarRobot();
		//System.out.println("Conectado: " + conn.connectTo());
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm()));
		boolean confirmacion = true;
		UsuarioUsuario.Cancha1.llenarGrafico();
		
		//while (confirmacion) {
			// elegir los jugadores
			while (confirmacion) {
				confirmacion = elegir_arquero();// true si elige jugador, false
												// si le da atras
				if (confirmacion) {
					confirmacion = elegir_delantero();
					if (confirmacion) {
						break;
					} else {
						confirmacion = true;
					}
				}
			}
			Lista_opc();
			
			tiempo_inicial= System.currentTimeMillis();
			while (true) {
				
				
				BaseOpciones();
				if(memoria.compareTo("p")==0||memoria.compareTo("t")==0){
					break;
				}
				if(Cancha1.Fuera_de_posicion==true){
					inicializarR();
				}
				// Comenzamos contando el tiempo apartir de aquí
				
			}
		//}
		//Lista_opc();

		
		EscritorTemporal.close();
	}

	//
	void inicializarR() {
		while (true) {
			try {
				System.out.println("(1) Inicializar Robot");
				int x = scanner.nextInt();
				if (x == 1) {
					Cancha1.IniciarRobot();
					break;
				} else {
					System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO7");
				}
			} catch (Exception e) {
				System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO8");
				scanner.nextLine();
			}
		}
	}

	void BaseOpciones() throws IOException {
		do {
			Cancha1.Localizacion_Robot();
			String_cancha();
			String n = scanner.next();
			detener_accion(memoria);
			memoria = n;
			if (n.compareTo("p")==0){
				break;
			}
			if (Cancha1.Fuera_de_posicion == true)
				break;
			else {
				if (Cancha1.calcularPosicionJugador() == false && arquero_delantero == false) {
					String_cancha();
					int i;
					for (i = 0; i < arquero.listaJugadas.size(); i++) {
						System.out.println("(" + i + ") " + arquero.listaJugadas.get(i));
					}
					while (true) {
						memoria = opcion(n, arquero_delantero);
						if (memoria == " ") {
							n = scanner.next();
						} else {
							break;
						}

					}

				} else if (Cancha1.calcularPosicionJugador() == true && arquero_delantero == true) {
					String_cancha();
					int i;
					for (i = 0; i < delantero.listaJugadas.size(); i++) {
						System.out.println("(" + i + ") " + delantero.listaJugadas.get(i));
					}
					while (true) {
						memoria = opcion(n, arquero_delantero);
						if (memoria == " ") {
							n = scanner.next();
						} else {
							break;
						}

					}

				} else if (Cancha1.calcularPosicionJugador() == false && arquero_delantero == true) {
					while (true) {
						System.out.println("(1) Cambiar a portero");
						String g = scanner.next();
						if (g.compareTo("1") == 0) {
							arquero_delantero = false;
							break;
						} else if (arquero_delantero == true) {
							System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO1");
						}
					}
				} else {
					while (true) {
						System.out.println("(1) Cambiar a delantero");
						String g = scanner.next();
						if (g.compareTo("1") == 0) {
							arquero_delantero = true;
							break;
						} else if (arquero_delantero == false) {
							System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO2");
						}
					}
				}
			}

		} while (Cancha1.Fuera_de_posicion == false && (memoria.compareTo("p")!=0||memoria.compareTo("t")!=0));

	}

	private String opcion(String opc_numero, boolean arquero_o_delantero) throws IOException{

		// Condicional para identificar la
		// opciÃƒÂ³n ingresado// Por el usuario
		if (opc_numero.compareTo("w") == 0) { // Ejecuta opcion w
			// (adelante)
			Opciones.get(0).ejecutar();
			return "w";
		} else if (opc_numero.compareTo("s") == 0) { // Ejecuta opcion s
														// (retroceder)
			Opciones.get(1).ejecutar();
			return "s";
		} else if (opc_numero.compareTo("a") == 0) { // Ejecuta opcion d (Girar
														// Izquierda)
			Opciones.get(2).ejecutar();
			return "a";
		} else if (opc_numero.compareTo("d") == 0) { // Ejecuta opcion a (Girar
														// Derecha)
			Opciones.get(3).ejecutar();
			return "d";

		} else if (opc_numero.compareTo("q") == 0) { // Ejecuta opcion q
														// (Patear)
			Opciones.get(4).ejecutar();
			return "q";
		} else if (opc_numero.compareTo("e") == 0) { // Ejecuta opcion e
														// (Frenar)
			Opciones.get(5).ejecutar();
			return "e";
		}else if(opc_numero.compareTo("g")==0){		// ejecuta opcione g
													// (gol a favor)
			Opciones.get(6).ejecutar();
			delantero.setGolesMarcados(1);
			return "g";
		}else if(opc_numero.compareTo("f")==0){		//ejecuta opcion f
			tiempo_inicial= System.currentTimeMillis()-tiempo_inicial;//(gol en contra)
			arquero.setTiempoSinGoles(0);
			Opciones.get(7).ejecutar();
			
			return "f";
		}
		else if (opc_numero.compareTo("p") == 0) { // Ejecuta opcion p
													// (Parar Partido)
            Opciones.get(8).ejecutar();
            return "p";
        }
		else if(opc_numero.compareTo("i")==0){//Ejecuta Opcion i 
											  // (Inicializa el partido)
			Opciones.get(10).ejecutar();
			return opc_numero;
		}
		else if (opc_numero.compareTo("t") == 0) {
			arquero.setTiempoSinGoles(System.currentTimeMillis()-tiempo_inicial+arquero.getTiempoSinGoles());
			Opciones.get(9).ejecutar();
			return "t";								// Ejecuta opcion t (Salir)
													// todavÃƒÂ­a falta agregar esa opcion de menÃƒÂº salir
		} else if (opc_numero.compareTo("1") == 0 || opc_numero.compareTo("2") == 0 || opc_numero.compareTo("3") == 0) {
			if (arquero_o_delantero == false) {
				arquero.listaJugadas.get(Integer.valueOf(opc_numero) - 1).ejecutar();
				EscritorTemporal.println(arquero.listaJugadas.get(Integer.valueOf(opc_numero) - 1).getNombre());
				EscritorTemporal.println(Cancha1.getPosicionRobot_x());
				EscritorTemporal.println(Cancha1.getPosicionRobot_y());
				return opc_numero;
				// opciones jugadas complejas del DELANTERO
			} else {
				delantero.listaJugadas.get(Integer.valueOf(opc_numero) - 1).ejecutar();
				EscritorTemporal.println(delantero.listaJugadas.get(Integer.valueOf(opc_numero) - 1).getNombre());
				EscritorTemporal.println(Cancha1.getPosicionRobot_x());
				EscritorTemporal.println(Cancha1.getPosicionRobot_y());
				return opc_numero;
				// opciones jugadas complejas del ARQUERO
			}
		} else {
			System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO3");
			return " ";
		}
	}

	private void detener_accion(String m) {
		if (m.compareTo("w") == 0) { // Ejecuta el mÃƒÂ©todo parar de Adelantar
			Opciones.get(0).parar();
		} else if (m.compareTo("s") == 0) { // Ejecuta el mÃƒÂ©todo parar de
											// Retroceder
			Opciones.get(1).parar();
		} else if (m.compareTo("a") == 0) { // Ejecutar el mÃƒÂ©todo parar de
											// Girar
											// Izquierda
			Opciones.get(2).parar();
		} else if (m.compareTo("d") == 0) { // Ejecutar el mÃƒÂ©todo parar de
											// Girar
											// Derecha
			Opciones.get(3).parar();
		} else if (m.compareTo("q") == 0) { // Ejetcua el mÃƒÂ©todo parar de
											// Patear
			Opciones.get(4).parar();
		} else { // No se realiza nada

		}
	}

	void Lista_opc() {
		// Conectar
		this.Opciones.add(new Opcion_adelante_w()); // Adelantar-(0)
		this.Opciones.add(new Opcion_atras_s()); // Retroceder-(1)
		this.Opciones.add(new Opcion_girar_izquierda_a()); // GiroIzquierda-(2)
		this.Opciones.add(new Opcion_girar_derecha_d()); // GiroDerecha-(3)
		this.Opciones.add(new Opcion_patear_q()); // Patear-(4)
		this.Opciones.add(new Opcion_parar_e()); // Frenar-(5)
		this.Opciones.add(new Opcion_gol_aliado_g()); //Gol aliado (6)
		this.Opciones.add(new Opcion_gol_enemigo_f()); //gol en contra (7)
		this.Opciones.add(new Opcion_parar_partido_p());// Parar Partido - (8)
		this.Opciones.add(new Opcion_salir_t());//  Sino funciona quitamos constructor y ponemos variable estaticas
		this.Opciones.add(new Opcion_Inicializar_robot_i());// 
		System.out.println("Aqui");
		// falta agreagar la opcion salir, la de las jugadas complejas
	}

	public void anadirOpcion(OpcionDeMenu r) {
		Opciones.add(r);
	}

	// imprime las opciones del jugador
	private void imprimir_opciones_jugador(boolean arquero_o_delantero) {
		if (arquero_o_delantero) {
			String_cancha();
			for (int i = 0; i < delantero.listaJugadas.size(); i++) {
				System.out.println("(" + i + ")" + delantero.listaJugadas.get(i).toString());
				// duda en este metodo
			}
		} else {
			String_cancha();
			for (int i = 0; i < arquero.listaJugadas.size(); i++) {
				System.out.println("(" + i + ")" + arquero.listaJugadas.get(i).toString());
				// duda en este metodo
			}
		}
	}

	private void String_cancha() {
		System.out.println( // Falta la implementaciÃƒÂ³n de las Jugadas
							// complejas y las otras opciones.
				"Opciones:" + "\n"
				        + "-----------------------------------------------------------------------------"
						+ "\n" + "| " + Cancha1.imprimir_fila_Grafico(0) + "| " + "   (W) Adelante"
						+ "\n" + "| " + Cancha1.imprimir_fila_Grafico(1) + "| " + "   (S) Retroceder"
						+ "\n" + "| " + Cancha1.imprimir_fila_Grafico(2) + "| "
						+ "   (A) Girar Izquierda" + "\n" + "| " + Cancha1.imprimir_fila_Grafico(3)
						+ "| " + "   (D) Girar Derecha" + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(4) + "| " + "   (Q) Patear" + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(5) + "| " + "   (E) Frenar" + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(6) + "| " + "   (G) Gol aliado" + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(7) + "| " + "   (F) Gol en contra" + "\n"
						+ "| " + Cancha1.imprimir_fila_Grafico(8) + "| " + "   (P) Parar partido"
						+ "\n" + "| " + Cancha1.imprimir_fila_Grafico(9) + "| " + "   (T) Salir" + "\n"
						+ "| " + Cancha1.imprimir_fila_Grafico(10) + "| " + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(11) + "| " + "\n" + "| "
						+ Cancha1.imprimir_fila_Grafico(12) + "| " + "\n"
						+ "-----------------------------------------------------------------------------");

	}

	// este metodo imprime el menÃƒÂº de bienvenida y pregunta el rol
	private byte admin_o_usuario() {
		while (true) {
			System.out.println("Bienvenido, porfavor ejila su rol:" + "\n" + "(1) Usuario" + "\n" + "(2) Administrador"
					+ "\n" + "(3) Salir");
			String numero = scanner.next();
			if (numero.compareTo("1") == 0) {
				return 1;
			} else if (numero.compareTo("2") == 0) {
				return 2;
			} else if (numero.compareTo("3") == 0) {
				return 3;
			} else {
				System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO4");
			}
		}
	}

	// muestra las opciones de delantero y ejile el que el jugador indicÃƒÂ³
    boolean elegir_delantero() {
		int contador = 0;
		boolean comparar_accion = true;
		System.out.println("\n" + "Elije tu delantero:");
		while (comparar_accion) {
			for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
				System.out.println("(" + (i + 1) + ")" + " " + MenuDeConsola.lista_delanteros.get(i).getNombre());
			}
			System.out.println("(" + (MenuDeConsola.lista_arqueros.size() + 1) + ")" + " AtrÃƒÂ¡s");
			String accion = scanner.next();
			for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
				contador = i + 1;
				if (accion.compareTo(String.valueOf(contador)) == 0) {
					this.delantero = MenuDeConsola.lista_delanteros.get(i);
					comparar_accion = false;
					return true;
				}
			}
			if (accion.compareTo(String.valueOf(MenuDeConsola.lista_arqueros.size() + 1)) == 0) {
				return false;
			}

			if (comparar_accion == true) {
				System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO5");
			}

		}
		return true;

	}

	// muestra las opciones de arqueros y asigna el que ususario a indicado
	boolean elegir_arquero() {
		int contador = 0;
		boolean comparar_accion = true;
		System.out.println("\n" + "Elije tu arquero:");
		while (comparar_accion) {
			for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
				System.out.println("(" + (i + 1) + ")" + " " + MenuDeConsola.lista_arqueros.get(i).getNombre());
			}
			System.out.println("(" + (MenuDeConsola.lista_arqueros.size() + 1) + ")" + " AtrÃƒÂ¡s");
			String accion = scanner.next();
			for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
				contador = i + 1;
				if (accion.compareTo(String.valueOf(contador)) == 0) {
					this.arquero = MenuDeConsola.lista_arqueros.get(i);
					comparar_accion = false;
					return true;
				}
			}
			if (accion.compareTo(String.valueOf(MenuDeConsola.lista_arqueros.size() + 1)) == 0) {
				return false;
			}
			if (comparar_accion == true) {
				System.out.println("ERROR NUMERO INGRESADO NO VÃƒï¿½LIDO6");
			}

		}
		return true;

	}

	private void guardar_texto() throws IOException {
		BufferedReader LectorTxt = new BufferedReader(new FileReader("Temporal.txt"));
		PrintStream EscritorFin = new PrintStream(new FileOutputStream("Resultados.txt"));
		String Aux1;
		String Aux2;
		String Aux3;
		EscritorFin.println("El Delantero " + this.delantero.getNombre() + " anotÃ³ "
				+ this.delantero.getGolesMarcados() + "goles.");
		EscritorFin.println("El Arquero " + this.arquero.getNombre() + " lleva " + (this.arquero.getTiempoSinGoles()/1000)
				+ " segundos sin que le anoten.");
		EscritorFin.println("Se realizaron las siguientes jugadas: ");
		do {

			Aux1 = LectorTxt.readLine();
			Aux2 = LectorTxt.readLine();
			Aux3 = LectorTxt.readLine();
			if (Aux1 == null) {
				break;
			}
			EscritorFin.println("La Jugada " + Aux1 + " se realizo en (" + Aux2 + "," + Aux3 + ")");

		} while (true);
		EscritorFin.close();
		LectorTxt.close();
	}
}
