package objetos.futbol.menuconsola;

import java.io.Serializable;
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;

public class UsuarioAdmin extends Usuario implements Serializable{
	
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	private transient Scanner scanner = new Scanner(System.in);
	
	private String admin_nombre;
	private String admin_contrasena;
	private String opcion_ingresada;
	//constructor
	UsuarioAdmin(String admin_nombre,String admin_contrasena){
		this.admin_nombre=admin_nombre;
		this.admin_contrasena=admin_contrasena;
	}
	
	//ejecuta el probgrama
	void ejecutar(){
		llenar_Opciones();
		boolean salir;
		do{
			lanzar_menu_admin();
			opcion_ingresada= scanner.next();
			salir=opcion(opcion_ingresada);//aquÃ±i sa va si es true o false
		}while(salir);
		
	}
	//imprime las opciones del admin
	void lanzar_menu_admin(){
		System.out.println("Bienvenido seÃ±or Admin:");
		System.out.println("(1) Crear Jugador"+"\n"+"(2) Crear Jugada Compleja"+"\n"+"(3) Consultar estadÃ­sticas"+"\n"+
				"(4) Consultar lista de jugadores"+"\n"+"(5) Consultar info sobre juagadores"+"\n"+
				"(6) Consultar jugadas de un jugador"+"\n"+"(7) Consultar jugada especifica de un jugador"+
				"\n"+"(8) Consultar jugadas disponibles para un jugador"+"\n"+"(t) Salir");
	}
	//implementar en UsusarioUsuario
	//URGENTE!!!
	private boolean opcion(String opc){
		for(int i=0;i<9;i++){
			if(opc.compareTo("t")==0){
				return false;
			}
			else if(opc.compareTo(Integer.toString(i+1))==0){
				Opciones.get(i).ejecutar();
				return true;
			}
			
		
		}
		System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
		return true;
	}
	//llena el array con las opciones de Menu de admin
	private void llenar_Opciones(){
		Opciones.add(new Admin_crear_jugador()); 					// opcion (1) crear jugador
		Opciones.add(new Admin_Crear_JugadaCompleja());				// opcion (2) crear jugada compleja
		Opciones.add(new Admin_ConsultarEstadis());					// opcion (3) consultar estadisticas
		Opciones.add(new Admin_Consultar_ListaJugadores());			// opcion (4) consultar lista jugadores
		Opciones.add(new Admin_ConsultarInfo());					// opcion (5) consultar info jugadores
		Opciones.add(new Admin_ConsultarListaJugadasDeUnJugador());	// opcion (6) consultar info jugada especifica
		Opciones.add(new Admin_ExplicacionJugadaDeUnJugador());		// opcion (7) explicion jugada compleja
		
		
	}
	
	
}