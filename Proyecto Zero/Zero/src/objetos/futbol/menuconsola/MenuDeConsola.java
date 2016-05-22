package objetos.futbol.menuconsola;

import java.io.EOFException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import objetos.futbol.JugadasPrimitivas.Adelantar;
import objetos.futbol.JugadasPrimitivas.Jugada;
import objetos.futbol.JugadasPrimitivas.Retroceder;
import objetos.futbol.JugadasPrimitivas.jugadaPrimitiva;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.UI.*;
public class MenuDeConsola implements Serializable {

	
    public static ArrayList<UsuarioAdmin> lista_usuariosAdmin = new ArrayList <UsuarioAdmin>();
	public static ArrayList<UsuarioUsuario> lista_usuariosUsuarios = new ArrayList <UsuarioUsuario>();
	
	public static ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	public static ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	private String first_usuario;
	private String first_contrasena;
	private byte memoria = -1;

	private byte rol;
	private transient Scanner scanner = new Scanner(System.in); // Para leer la opción
														// seleccionada

	public void lanzarMenu() throws IOException{
		int i=0;
		if (lista_arqueros.size()==0){
			
		
		try {
			ObjectInputStream LectorObj = new ObjectInputStream(new FileInputStream("Estado_Sistema.dat"));
			Object Aux;
			do {
				Aux = (Object) LectorObj.readObject();
				if (Aux instanceof Arquero) {
					lista_arqueros.add((Arquero) Aux);
				} else if (Aux instanceof Delantero) {
					lista_delanteros.add((Delantero) Aux);
				} else if (Aux instanceof UsuarioUsuario) {
					lista_usuariosUsuarios.add((UsuarioUsuario) Aux);
				} else if (Aux instanceof UsuarioAdmin) {
					lista_usuariosAdmin.add((UsuarioAdmin) Aux);
				}else if (Aux instanceof JugadaCompleja) {
					Futbolista.listaTotalJugadas.add((JugadaCompleja) Aux);
				}
			} while (Aux != null);
			LectorObj.close();
		} catch (EOFException e) {
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		}


		//setLista_arqueros();
		//Futbolista.listaTotalJugadas.add(lista_delanteros.get(0).listaJugadas.get(0));
		
		
		// primero se le pregunta al usuario si es jugador o admin
		/*while (true) {
			
			
			System.out.println(OyenteIn.ScannerP);
		
			OyenteIn.Respuesta();
			System.out.println("nepe"+OyenteIn.ScannerP);
			
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
				break;
			}
			else{
				first_contrasena=scanner.next();
				UsuarioUsuario usuario= new UsuarioUsuario(first_usuario,first_contrasena);
				usuario.ejecutar();
				break;
			}	
		}*/

	}
	
	


	public  void Guardar() throws IOException{
		int i;
		ObjectOutputStream SaverObjetos = new ObjectOutputStream(new FileOutputStream("Estado_Sistema.dat"));
		if (lista_arqueros.isEmpty() == false) {
			for (i = 0; i < lista_arqueros.size(); i++) {
				SaverObjetos.writeObject(lista_arqueros.get(i));
			}
		}
		if (lista_delanteros.isEmpty() == false) {
			for (i = 0; i < lista_delanteros.size(); i++) {
				SaverObjetos.writeObject(lista_delanteros.get(i));
			}
		}
		if (lista_usuariosUsuarios.isEmpty() == false) {
			for (i = 0; i < lista_usuariosUsuarios.size(); i++) {
				SaverObjetos.writeObject(lista_usuariosUsuarios.get(i));
			}
		}
		if (lista_usuariosAdmin.isEmpty() == false) {
			for (i = 0; i < lista_usuariosAdmin.size(); i++) {
				SaverObjetos.writeObject(lista_usuariosAdmin.get(i));
			}
		}
		if (Futbolista.listaTotalJugadas.isEmpty() == false) {
			for (i = 0; i < Futbolista.listaTotalJugadas.size(); i++) {
				SaverObjetos.writeObject(Futbolista.listaTotalJugadas.get(i));
			}
		}
		SaverObjetos.close();

		
	}
}