package objetos.futbol.menuconsola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;

public class MenuDeConsola {

	// atributos:
	
	static ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	static ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	private String first_usuario;
	private String first_contrasena;
	private byte memoria = -1;

	private byte rol;
	private Scanner scanner = new Scanner(System.in); // Para leer la opción
														// seleccionada

	public void lanzarMenu() throws IOException{
		NXTConnector conn = new NXTConnector();
		/*if (!conn.connectTo("NXT_5", NXTComm.LCP)){
			System.err.println("Conexion Fallida");
			System.exit(1);
		}*/
		UsuarioUsuario.Cancha1.IniciarRobot();
		System.out.println("Conectado: " + conn.connectTo());
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm()));
		//Arias hace esta parte de setLista_arqueros(); y delanteros
		setLista_arqueros();
		setLista_delanteros();
		
		
		// primero se le pregunta al usuario si es jugador o admin
		while (true) {
			System.out.println("Bienvenido "+"\n"+"Ingrese su Usuario:");
			first_usuario=scanner.next();
			System.out.println("Ingrese su contraseña:");
			if(first_usuario.compareTo("usuario")==0){
				while(true){
					first_contrasena=scanner.next();
					if(first_contrasena.compareTo("camilo")==0){
						//usuario y contraseña correctos
						//ejecuta el UsuarioAdmin
						UsuarioAdmin usuario_admin= new UsuarioAdmin(first_usuario,first_contrasena);
						usuario_admin.ejecutar();
						break;
					}
				}
			}
			else{
				first_contrasena=scanner.next();
				UsuarioUsuario usuario= new UsuarioUsuario(first_usuario,first_contrasena);
				usuario.ejecutar();
			}
		conn.close();	
		}

	}

	// metodo interno de el lanzar_menú para usuario
	//URGENTE
	
	

	//Desde acá se setean los arqueros y los delanteros default 
	//falta poner las jugadas complejas, pero se supone que debe ser igual
	//empecemos con los casos prueba 

	private void setLista_arqueros() {
		
		Arquero Monato = new Arquero("Monato", "arquero", new ArrayList<JugadaCompleja>(), 00, (byte) 5);
		
		this.lista_arqueros.add(Monato);
	}

	private void setLista_delanteros() {
		Delantero Monatomate = new Delantero("Monatomate", "Delantero", new ArrayList<JugadaCompleja>(), 00, 5);
		this.lista_delanteros.add(Monatomate);
	}
}
