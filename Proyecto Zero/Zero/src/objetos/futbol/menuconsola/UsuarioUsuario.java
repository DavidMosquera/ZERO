package objetos.futbol.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;

import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTCommandConnector;
import lejos.pc.comm.NXTConnector;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;


public class UsuarioUsuario extends Usuario{
	public  static Cancha Cancha1 = new Cancha();
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	private Scanner scanner = new Scanner(System.in);
	private String usuario_nombre;
	private String usuario_contrasena;
	
	private Delantero delantero;
	private Arquero arquero;
	// no se si la opcion 7 es suficiente para salir
	
	
	UsuarioUsuario(String usuario_nombre,String usuario_contrasena){
		this.usuario_nombre=usuario_nombre;
		this.usuario_contrasena=usuario_contrasena;
	}
	
	void ejecutar() {
		Cancha1.llenarGrafico();
		NXTConnector conn = new NXTConnector();
		/*if (!conn.connectTo("NXT_5", NXTComm.LCP)){
			System.err.println("Conexion Fallida");
			System.exit(1);
		}*/
		UsuarioUsuario.Cancha1.IniciarRobot();
		System.out.println("Conectado: " + conn.connectTo());
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm()));
		
		Lista_opc();
		
		boolean confirmacion = true;
		while (confirmacion) {
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
			boolean  arquero_delantero=false; //FALSE = ARQUERO    TRUE = DELANTERO
			String memoria = "0";
			while (confirmacion) {
				//confirma si el jugador se encuentra en una posicion adecuada, he imprime su respectivo menÃº puede
				//haber problemas despuÃ©s con esta parte REVISAR
				//si no esta en posicoin adecuada le pide que cambie de jugaros
			
				//desde aca partir
				if(Cancha1.Fuera_de_posicion==false){
					
				//partir 2
				//menu diferente para arquero y delantero
				//si esta dentro de la cancha pero con jugador no permitido que cambie
					if(Cancha1.calcularPosicionJugador()==false&&arquero_delantero==false){
					
						imprimir_opciones_jugador(false);//cambiar a opciones de menu arquero
						
						String action2 = scanner.next();
						detener_accion(memoria);
						opcion(action2,false);//
						memoria = action2;
					}
					else if(Cancha1.calcularPosicionJugador()==true&&arquero_delantero==true){
						imprimir_opciones_jugador(true);//cambiar a opciones de menu arquero
						
						String action2 = scanner.next();
						detener_accion(memoria);
						opcion(action2,true);
						memoria = action2;
						
					}
					else{
						
					//partir3
						if(Cancha1.calcularPosicionJugador()==false){
							System.out.println("Posicion incorrecta porfavor cambie de jugador a portero");
							System.out.println("(1) cambiar a portero");
							String basura = scanner.next();
							while(true){
								if(basura.compareTo("1")==0){
									arquero_delantero=false;
									break;
								}
								else{
									System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
									basura= scanner.next();
								}
							}
							
						}
						else{
							System.out.println("Posicion incorrecta porfavor cambie de jugador a delantero");
							System.out.println("(1) cambiar a delantero");
							String basura = scanner.next();
							while(true){
								if(basura.compareTo("1")==0){
									arquero_delantero=true;
									break;
								}
								else{
									System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
									basura= scanner.next();
								}
							}
						}
					}
				}
				//si el jugador se encuentra en posicion por fuera de la perimitida que se reinicien los contadores
				//partir 4
				else{
					System.out.println("Jugador fuera de la cancha");
					System.out.println("(1) reiniciar posicion");
					String basura= scanner.next();
					while(true){
						if(basura.compareTo("1")==0){
							Cancha1.IniciarRobot(); //poner este metodo estatico check :)
							break;
						}
						else{
							System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
							basura= scanner.next();
						}
					}
				}
				
			}
		}
	}
		private void opcion(String opc_numero,boolean arquero_o_delantero) {
			
			// Condicional para identificar la
			// opciÃ³n ingresado// Por el usuario
			if (opc_numero.compareTo("w") == 0) { // Ejecuta opcion w
										// (adelante)
				Opciones.get(0).ejecutar();
			} else if (opc_numero.compareTo("s") == 0) { // Ejecuta opcion s
															// (retroceder)
				Opciones.get(1).ejecutar();
			} else if (opc_numero.compareTo("a") == 0) { // Ejecuta opcion d (Girar
															// Izquierda)
				Opciones.get(2).ejecutar();
			} else if (opc_numero.compareTo("d") == 0) { // Ejecuta opcion a (Girar
															// Derecha)
				Opciones.get(3).ejecutar();
			} else if (opc_numero.compareTo("q") == 0) { // Ejecuta opcion q
															// (Patear)
				Opciones.get(4).ejecutar();
			} else if (opc_numero.compareTo("e") == 0) { // Ejecuta opcion e
															// (Frenar)
				Opciones.get(5).ejecutar();
			} else if (opc_numero.compareTo("t") == 0) {
				Opciones.get(6).ejecutar();// Ejecuta opcion t (Salir)
	//todavÃ­a falta agregar esa opcion de menÃº salir
			}
			else if(opc_numero.compareTo("1") == 0||opc_numero.compareTo("2") == 0||opc_numero.compareTo("3") == 0){
					if(arquero_o_delantero){
						//opciones jugadas complejas del DELANTERO
					}
					else{
						//opciones jugadas complejas del ARQUERO
					}
			}
			else {
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}

		private void detener_accion(String m) {
			if (m.compareTo("w") == 0) { // Ejecuta el mÃ©todo parar de Adelantar
				Opciones.get(0).parar();
			} else if (m.compareTo("s") == 0) { // Ejecuta el mÃ©todo parar de
												// Retroceder
				Opciones.get(1).parar();
			} else if (m.compareTo("a") == 0) { // Ejecutar el mÃ©todo parar de Girar
												// Izquierda
				Opciones.get(2).parar();
			} else if (m.compareTo("d") == 0) { // Ejecutar el mÃ©todo parar de Girar
												// Derecha
				Opciones.get(3).parar();
			} else if (m.compareTo("q") == 0) { // Ejetcua el mÃ©todo parar de Patear
				Opciones.get(4).parar();
			} else { // No se realiza nada

			}
		}

		private void Lista_opc() {
			// Conectar
			this.Opciones.add(new Opcion_adelante_w()); // Adelantar
			this.Opciones.add(new Opcion_atras_s()); // Retroceder
			this.Opciones.add(new Opcion_girar_izquierda_a()); // GiroIzquierda
			this.Opciones.add(new Opcion_girar_derecha_d()); // GiroDerecha
			this.Opciones.add(new Opcion_patear_q()); // Patear
			this.Opciones.add(new Opcion_parar_e()); // Frenar
	//falta agreagar la opcion salir, la de las jugadas complejas 
		}

		public void anadirOpcion(OpcionDeMenu r) {
			Opciones.add(r);
		}

		// imprime las opciones del jugador
		private void imprimir_opciones_jugador(boolean arquero_o_delantero) {
			if(arquero_o_delantero){
				String_cancha();
				for(int i=0;i<delantero.listaJugadas.size();i++){
					System.out.println("("+i+")"+delantero.listaJugadas.get(i).toString());
					//duda en este metodo 
				}
			}
			else{
				String_cancha();
				for(int i=0;i<arquero.listaJugadas.size();i++){
					System.out.println("("+i+")"+arquero.listaJugadas.get(i).toString());
					//duda en este metodo 
				}		
			}
		}
		private void String_cancha(){
			System.out.println(               //Falta la implementaciÃ³n de las Jugadas complejas y las otras opciones.
					"Opciones:"+		
					"\n"+"Â¶â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•¦â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�Â¶"+ 
		            "\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(0)+ "   â•‘ "+ "   (W) Adelante" +
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(1)+ "   â•‘ "+ "   (S) Retroceder"+
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(2)+ "   â•‘ "+ "   (A) Girar Izquierda"+
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(3)+ "   â•‘ "+ "   (D) Girar Derecha"+
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(4)+ "   â•‘ "+ "   (Q) Patear"+
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(5)+ "   â•‘ "+ "   (E) Frenar"+          
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(6)+ "   â•‘ "+ "   (T) Salir"+
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(7)+ "   â•‘ "+        
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(8)+ "   â•‘ "+                          
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(9)+ "   â•‘ "+                          
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(10)+"   â•‘ "+                           
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(11)+"   â•‘ "+                          
					"\n"+"â•‘ "+Cancha1.imprimir_fila_Grafico(12)+"   â•‘ "+                           
					"\n"+"Â¶â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•©â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�Â¶ ");
		
		}

		// este metodo imprime el menÃº de bienvenida y pregunta el rol
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
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}
			}
		}

		// muestra las opciones de delantero y ejile el que el jugador indicÃ³
		private boolean elegir_delantero() {
			int contador = 0;
			boolean comparar_accion = true;
			System.out.println("\n" + "Elije tu delantero:");
			while (comparar_accion) {
				for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
					System.out.println("(" + (i + 1) + ")" + " " + MenuDeConsola.lista_delanteros.get(i).getNombre());
				}
				System.out.println("(" + (MenuDeConsola.lista_arqueros.size() + 1) + ")" + " AtrÃ¡s");
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
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}

			}
			return true;

		}

		// muestra las opciones de arqueros y asigna el que ususario a indicado
		private boolean elegir_arquero() {
			int contador = 0;
			boolean comparar_accion = true;
			System.out.println("\n" + "Elije tu arquero:");
			while (comparar_accion) {
				for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
					System.out.println("(" + (i + 1) + ")" + " " + MenuDeConsola.lista_arqueros.get(i).getNombre());
				}
				System.out.println("(" + (MenuDeConsola.lista_arqueros.size() + 1) + ")" + " AtrÃ¡s");
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
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}

			}
			return true;

		}
}
