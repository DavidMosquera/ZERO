package objetos.futbol.menuconsola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import objetos.futbol.JugadasPrimitivas.*;
import objetos.futbol.jugadores.*;

public class Admin_Crear_JugadaCompleja extends OpcionDeMenu implements Serializable{
	private String opc;
	private String estilo;
	private transient Scanner scanner = new Scanner(System.in);
	private ArrayList<jugadaPrimitiva> Jp;
	private String nombre;
	private String expli;
	private UsuarioAdmin autor;
	
	Admin_Crear_JugadaCompleja(UsuarioAdmin a){
		autor=a;
	}
	public void ejecutar(){
		Jp = new ArrayList<jugadaPrimitiva>();
		ofen_defen_tiro();
		seleccionar_jugada_primitiva(Jp);
		crear_explicacion();
		selecciona_nombre();
		confirmacion(Jp);
	}
	 public void parar(){
		 
	 }
	 //da la opcion al usuario de elegir cual va a ser el tipo de jugada compleja
	 void ofen_defen_tiro(){
		 String opc;
		 while (true){
			System.out.println("\n"+"Ingresar el estilo de tiro");
			System.out.println("(1) Ofensiva");
			System.out.println("(2) Defensiva");
			System.out.println("(3) Tirolibre");
			opc=scanner.next();
			if(opc.compareTo("1")==0){
				estilo = "Ofensiva";
				return;
			}
			else if(opc.compareTo("2")==0){
				estilo= "Defensiva";
				return;
			}
			
			else if(opc.compareTo("3")==0){
				estilo="TiroLibre";
				return;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		 }
	 }
	 //le permite al usuario elegir las juagas primitivas que componen la jugada compleja
	 void seleccionar_jugada_primitiva(ArrayList<jugadaPrimitiva> Jugadas){
		 int x;
		// System.out.println("elija el numero de pasos a ejecutar");
		 while(true){
			 try{
				 System.out.println("elija el numero de pasos a ejecutar");
				 x=scanner.nextInt();
				 break;
			 }
			 catch(Exception e){
				 System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO ");
				 scanner.nextLine();
			 }
		 }
		 
		 for(int i=0;i<x;i++){
			 System.out.println("\n"+"(1) Adelantar");
			 System.out.println("(2) Retroceder");
			 System.out.println("(3) Derecha");
			 System.out.println("(4) Izquierda");
			 System.out.println("(5) Patear");
			 while(true){
				 try{
					 int y=scanner.nextInt();
					 if(y==1){
						 Jugadas.add(new Adelantar((int)1000,"Adelante"));
						 break;
					 }
					 else if(y==2){
						 Jugadas.add(new Retroceder((int)1000,"Retoceder"));
						 break;
					 }
					 else if(y==3){
						 Jugadas.add(new GirarDerecha((int)1000,"Derecha"));
						 break;
					 }
					 else if(y==4){
						 Jugadas.add(new GirarIzquierda((int)1000,"Izquierda"));
						 break;
					 }
					 else if(y==5){
						 Jugadas.add(new Patear((int)400,"Patear"));
						 break;
					 }
					 else{
						 System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO "); 
					 }
				 }
				 catch(Exception e){
					 System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO ");
					 scanner.nextLine();

				 }
			 }
		 }
		 
	 }
	 //le pide al usuario la explicacion de la ugada compleja
	void crear_explicacion(){
		 System.out.println("\n"+"ingresar explicacion de la jugada:");
		 scanner.nextLine();
		 expli=scanner.nextLine();
		 System.out.println("\n"+"la juagada tiene esta explicaion:"+"\n"+expli);
	 }
	//se le pide a el usuario el nombre de la jugada Compleja
	void selecciona_nombre(){
		System.out.println("\n"+"ingresar nombre de la jugada:");
		nombre=scanner.nextLine();
		System.out.println("\n"+"la juagada tiene esta explicaion:"+"\n"+nombre);
			
	}
	void confirmacion(ArrayList<jugadaPrimitiva> listaJ){
		System.out.println("\n"+"Quiere crear la jugada con:");
		System.out.println("nombre "+nombre+"\n"+"y con :"+Jp.size()+" jugadas primitivas?");
		System.out.println("(1) si"+"\n"+"(2) no");
		int x;
		while(true){
			 try{
				 System.out.println("elija la opcion");
				 x=scanner.nextInt();
				 if(x==1){
					 Date fecha= new Date();
					 String fe= (String)fecha.toString();
					 if(estilo.compareTo("Ofensiva")==0){
						 Delantero.listaTotalJugadas.add(new JugadaComplejaOfensiva(nombre,fe," ",listaJ,expli));
					 }
					 else if(estilo.compareTo("Defensiva")==0){
						 Delantero.listaTotalJugadas.add(new JugadaComplejaDefensiva(nombre,fe," ",listaJ,expli));
					 }
					 else if(estilo.compareTo("TiroLibre")==0){
						 Delantero.listaTotalJugadas.add(new JugadaComplejaTiroLibre(nombre,fe," ",listaJ,expli));
					 }
					 break;
				 }
				 else if(x==2){
					 break;
				 }
				 else{
					System.out.println("ERROR NUMERO INGRESADO NO VALIDO "); 
				 }
			 }
			 catch(Exception e){
				 System.out.println("ERROR NUMERO INGRESADO NO VALIDO ");
				 scanner.nextLine();
			 }
		}
	}	
}
