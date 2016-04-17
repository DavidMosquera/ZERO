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

public class MenuDeConsola implements Serializable {

	
    static ArrayList<UsuarioAdmin> lista_usuariosAdmin = new ArrayList <UsuarioAdmin>();
	static ArrayList<UsuarioUsuario> lista_usuariosUsuarios = new ArrayList <UsuarioUsuario>();
	
	static ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	static ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	private String first_usuario;
	private String first_contrasena;
	private byte memoria = -1;

	private byte rol;
	private transient Scanner scanner = new Scanner(System.in); // Para leer la opción
														// seleccionada

	public void lanzarMenu() throws IOException{
		int i=0;
		
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


		//setLista_arqueros();
		
		
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
				break;
			}
			else{
				first_contrasena=scanner.next();
				UsuarioUsuario usuario= new UsuarioUsuario(first_usuario,first_contrasena);
				usuario.ejecutar();
			}	
		}

	}

	// metodo interno de el lanzar_menú para usuario
	//URGENTE
	
	

	//Desde acá se setean los arqueros y los delanteros default 
	//falta poner las jugadas complejas, pero se supone que debe ser igual
	//empecemos con los casos prueba 

	private void setLista_arqueros() {
		UsuarioAdmin Yop = new UsuarioAdmin("holi","holi");
		ArrayList <jugadaPrimitiva> Orden = new ArrayList<jugadaPrimitiva>();
		JugadaComplejaDefensiva Jugadita = new JugadaComplejaDefensiva("Jugadita-prueba","hoy",Yop,Orden,"Esta jugada es para probar lo de camilo");
		ArrayList <JugadaCompleja> Jugada = new ArrayList<JugadaCompleja>();
		Jugada.add(Jugadita);
		Arquero Monato = new Arquero("Monato", "arquero", new ArrayList<JugadaCompleja>(), 00, (byte)5);
		Arquero Monato1 = new Arquero("Monato1", "arquero", Jugada, 00, (byte) 5);
		Delantero Monato2 = new Delantero("Monato2", "arquero", new ArrayList<JugadaCompleja>(), 00,  5);
		Delantero Monato3 = new Delantero("Monato3", "arquero", Jugada, 00,  5);
		Monato1.listaTotalJugadas.add(Jugadita);
		lista_arqueros.add(Monato1);
		lista_delanteros.add(Monato3);     
	}

	private void setLista_delanteros() {
		Delantero Monatomate = new Delantero("Monatomate", "Delantero", new ArrayList<JugadaCompleja>(), 00, 5);
		this.lista_delanteros.add(Monatomate);
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