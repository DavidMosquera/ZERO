package objetos.futbol.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;


public class MenuDeConsola {

	// atributos:
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	private ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	private ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	private String accion;
	private byte memoria = -1;

	private byte rol;
	private Scanner scanner = new Scanner(System.in); // Para leer la opción
														// seleccionada
	private Delantero delantero;
	private Arquero arquero;


	public void lanzarMenu() {
		setLista_arqueros();
		setLista_delanteros();
		// primero se le pregunta al usuario si es jugador o admin
		while (true) {
			rol = admin_o_usuario();// 1 si es usuario, 2 si es admin, 3 para
									// salir
			if (rol == 1) {
				lanzar_usuario();
			} 
			else if (rol == 2) {
				while (true) {
					// aquí van las opciones del administrador
				}
			}
			else {
				break;
			}
		}

	}
	
	
	
	
	//metodo interno de el lanzar_menú para usuario 
	private void lanzar_usuario(){
		boolean confirmacion = true;
		while (confirmacion) {
			// se cambia la ubicación para que solo el usuario se
			// conecte al
			// robot
			NXTConnector conn = new NXTConnector();
			System.out.println("Conectado: " + conn.connectTo());
			NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm()));

			// elegir los jugadores
			while(confirmacion){
				confirmacion = elegir_arquero();//true si elige jugador, false si le da atras
				if(confirmacion){
					confirmacion=elegir_delantero();
					if(confirmacion){
						break;
					}
					else{
						confirmacion=true;
					}
					}
				}
			
			while (confirmacion) {
				String memoria = "0";
				imprimir_opciones_jugador();// imprime el menú con las
											// opciones
											// de el jugador
				String acccion = scanner.next();// lo cambie para no
												// confundirnos con opc
												// o
												// opcion
				/*
				 * se usa un String para que no nos salte error i
				 * ingresamos un String por eroor, solo un aviso por
				 * consola
				 */

				detener_accion(memoria);
				opcion(accion);
				memoria = acccion;
			}
		}
	}
	
	
	

	// no se si la opcion 7 es suficiente para salir
	private void opcion(String opc_numero) {
		 // Condicional para identificar la
		// opción ingresado// Por el usuario
		if (opc_numero.compareTo("w") == 0) { // Ejecuta opcion w
														// (adelante)
			Opciones.get(1).ejecutar();
		} else if (opc_numero.compareTo("s") == 0) { // Ejecuta opcion s
														// (retroceder)
			Opciones.get(2).ejecutar();
		} else if (opc_numero.compareTo("a") == 0) { // Ejecuta opcion d (Girar
														// Izquierda)
			Opciones.get(3).ejecutar();
		} else if (opc_numero.compareTo("d") == 0) { // Ejecuta opcion a (Girar
														// Derecha)
			Opciones.get(4).ejecutar();
		} else if (opc_numero.compareTo("q") == 0) { // Ejecuta opcion q
														// (Patear)
			Opciones.get(5).ejecutar();
		} else if (opc_numero.compareTo("e") == 0) { // Ejecuta opcion e
														// (Frenar)
			Opciones.get(6).ejecutar();
		} else if (opc_numero.compareTo("t") == 0) { // Ejecuta opcion t (Salir)
		} else {
			System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
		}
	}

	private void detener_accion(String m) {
		if (m.compareTo("w") == 0) { // Ejecuta el método parar de Adelantar
			Opciones.get(1).parar();
		} else if (m.compareTo("s") == 0) { // Ejecuta el método parar de
											// Retroceder
			Opciones.get(2).parar();
		} else if (m.compareTo("a") == 0) { // Ejecutar el método parar de Girar
											// Izquierda
			Opciones.get(3).parar();
		} else if (m.compareTo("d") == 0) { // Ejecutar el método parar de Girar
											// Derecha
			Opciones.get(4).parar();
		} else if (m.compareTo("q") == 0) { // Ejetcua el método parar de Patear
			Opciones.get(5).parar();
		} else { // No se realiza nada

		}
	}

	private void Lista_opc(ArrayList<OpcionDeMenu> lista) {
		// Conectar
		lista.add(new Opcion_adelante_w()); // Adelantar
		lista.add(new Opcion_atras_s()); // Retroceder
		lista.add(new Opcion_girar_izquierda_a()); // GiroIzquierda
		lista.add(new Opcion_girar_derecha_d()); // GiroDerecha
		lista.add(new Opcion_patear_q()); // Patear
		lista.add(new Opcion_parar_e()); // Frenar
	}

	public void anadirOpcion(OpcionDeMenu r) {
		Opciones.add(r);
	}

	// imprime las opciones del jugador
	private void imprimir_opciones_jugador() {
		System.out.println("Opciones: " + "\n" + "(w) Adelante " + "\n" + "(s) Retroceder "
				+ "\n" + "(a) Girar a la Izquierda " + "\n" + "(d) Girar a la Derecha " + "\n" + "(q) Patear " + "\n"
				+ "(e) Frenar" + "\n" + "(t) Salir");
	}

	// este metodo imprime el menú de bienvenida y pregunta el rol
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
				System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
			}
		}
	}

	// muestra las opciones de delantero y ejile el que el jugador indicó
	private boolean elegir_delantero() {
		int contador = 0;
		boolean comparar_accion = true;
		System.out.println("\n"+"Elije tu delantero:");
		while (comparar_accion) {
			for (int i = 0; i < lista_delanteros.size(); i++) {
				System.out.println("(" + (i + 1) + ")" + " " + lista_delanteros.get(i).getNombre());
			}
			System.out.println("(" + (lista_arqueros.size()+1) + ")" + " Atrás");
			String accion = scanner.next();
			for (int i = 0; i < lista_delanteros.size(); i++) {
				contador = i + 1;
				if (accion.compareTo(String.valueOf(contador)) == 0) {
					this.delantero = lista_delanteros.get(i);
					comparar_accion = false;
					return true;
				}
			}
			if(accion.compareTo(String.valueOf(lista_arqueros.size()+1))==0){
				return false;
			}
			
			if (comparar_accion == true) {
				System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
			}

		}
		return true;

	}

	// muestra las opciones de arqueros y asigna el que ususario a indicado
	private boolean elegir_arquero() {
		int contador = 0;
		boolean comparar_accion = true;
		System.out.println("\n"+"Elije tu arquero:");
		while (comparar_accion) {
			for (int i = 0; i < lista_arqueros.size(); i++) {
				System.out.println("(" + (i + 1) + ")" + " " + lista_arqueros.get(i).getNombre());
			}
			System.out.println("(" + (lista_arqueros.size()+1) + ")" + " Atrás");
			String accion = scanner.next();
			for (int i = 0; i < lista_arqueros.size(); i++) {
				contador = i + 1;
				if (accion.compareTo(String.valueOf(contador)) == 0) {
					this.arquero = lista_arqueros.get(i);
					comparar_accion = false;
					return true;
				}
			}
			if(accion.compareTo(String.valueOf(lista_arqueros.size()+1))==0){
				return false;
			}
			if (comparar_accion == true) {
				System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
			}

		}
		return true;

	}
	private void setLista_arqueros(){
		Arquero Monato= new Arquero("Monato","arquero",new ArrayList<JugadaCompleja>(),00,(byte)5);
		this.lista_arqueros.add(Monato);
	}
	private void setLista_delanteros(){
		Delantero Monatomate= new Delantero("Monatomate","Delantero",new ArrayList<JugadaCompleja>(),00,5);
		this.lista_delanteros.add(Monatomate);
	}
}
