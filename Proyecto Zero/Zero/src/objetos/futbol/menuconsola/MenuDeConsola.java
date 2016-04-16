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

	// atributos:
	static ArrayList<Futbolista> lista_futbolistas = new ArrayList <Futbolista>();
	static ArrayList<Usuario> lista_usuarios = new ArrayList <Usuario>();
    static ArrayList<UsuarioAdmin> lista_usuariosAdmin = new ArrayList <UsuarioAdmin>();
	static ArrayList<UsuarioUsuario> lista_usuariosUsuarios = new ArrayList <UsuarioUsuario>();
	
	static ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	static ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	static ArrayList<Jugada> lista_jugadas= new ArrayList<Jugada>();
	private String first_usuario;
	private String first_contrasena;
	private byte memoria = -1;

	private byte rol;
	private transient Scanner scanner = new Scanner(System.in); // Para leer la opción
														// seleccionada

	public void lanzarMenu() throws IOException{
		int i=0;
		
		//Arias hace esta parte de setLista_arqueros(); y delanteros
		try{
			ObjectInputStream LectorObj = new ObjectInputStream(new FileInputStream("Futbolistas.dat"));
			Futbolista Aux;
			do{
				Aux=(Futbolista)LectorObj.readObject();
			    lista_futbolistas.add(Aux);
			}while(Aux!=null);
			LectorObj.close();
		}catch(EOFException e){
		}catch(ClassNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		/*try{
			ObjectInputStream LectorObj = new ObjectInputStream(new FileInputStream("Jugadas.dat"));
			Jugada Aux;
			do{
				Aux=(Jugada)LectorObj.readObject();
			    Futbolista.listaTotalJugadas.add(Aux);
			}while(Aux!=null);
			LectorObj.close();
		}catch(EOFException e){
		}catch(ClassNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}*/
		try{
			ObjectInputStream LectorObj = new ObjectInputStream(new FileInputStream("Usuarios.dat"));
			Usuario Aux;
			do{
				Aux=(Usuario)LectorObj.readObject();
			    lista_usuarios.add(Aux);
			}while(Aux!=null);
			LectorObj.close();
		}catch(EOFException e){
		}catch(ClassNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}
		try{
			ObjectInputStream LectorObj = new ObjectInputStream(new FileInputStream("Cancha.dat"));
			Cancha Aux;
			do{
				Aux=(Cancha)LectorObj.readObject();
			    UsuarioUsuario.Cancha1=Aux;
			}while(Aux!=null);
			LectorObj.close();
		}catch(EOFException e){
		}catch(ClassNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}
		for(i=0;i<lista_futbolistas.size();i++){
			if(lista_futbolistas.get(i) instanceof Arquero){
				lista_arqueros.add((Arquero)lista_futbolistas.get(i));
			}
			else{
				lista_delanteros.add((Delantero)lista_futbolistas.get(i));
			}
		}
		for(i=0;i<lista_usuarios.size();i++){
			if(lista_usuarios.get(i) instanceof UsuarioAdmin){
				lista_usuariosAdmin.add((UsuarioAdmin)lista_usuarios.get(i));
			}
			else{
				lista_usuariosUsuarios.add((UsuarioUsuario)lista_usuarios.get(i));
			}
		}


		setLista_arqueros();
		
		
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
		lista_futbolistas.add(Monato1);
		lista_futbolistas.add(Monato3);
	}

	private void setLista_delanteros() {
		Delantero Monatomate = new Delantero("Monatomate", "Delantero", new ArrayList<JugadaCompleja>(), 00, 5);
		this.lista_delanteros.add(Monatomate);
	}
	public  void Guardar() throws FileNotFoundException, IOException{
		int i;
		ObjectOutputStream SaverFutbolistas = new ObjectOutputStream(new FileOutputStream("Futbolistas.dat"));
		//ObjectOutputStream SaverJugadas = new ObjectOutputStream(new FileOutputStream("Jugadas.dat"));
		ObjectOutputStream SaverUsuarios = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
		ObjectOutputStream SaverCancha = new ObjectOutputStream(new FileOutputStream("Cancha.dat"));
		if (lista_futbolistas.isEmpty()==false){
			for(i=0;i<lista_futbolistas.size();i++){
				SaverFutbolistas.writeObject(lista_futbolistas.get(i));
			}	
		}
		/*if (Futbolista.listaTotalJugadas.isEmpty()==false){
			for(i=0;i<Futbolista.listaTotalJugadas.size();i++){
				SaverJugadas.writeObject(Futbolista.listaTotalJugadas.get(i));
			}
		}*/
		if (lista_usuarios.isEmpty()==false){
			for(i=0;i<lista_usuarios.size();i++){
				SaverUsuarios.writeObject(lista_usuarios.get(i));
			}
		}
		
		SaverFutbolistas.writeObject(UsuarioUsuario.Cancha1);
		SaverFutbolistas.close();
		//SaverJugadas.close();
		SaverUsuarios.close();
		SaverCancha.close();
		
	}
}