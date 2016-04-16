package objetos.futbol.menuconsola;

import java.util.Scanner;

public class Admin_Crear_JugadaCompleja extends OpcionDeMenu {
	private String opc;
	private String estilo;
	private Scanner scanner = new Scanner(System.in);
	void ejecutar(){
		ofen_defen_tiro();
		seleccionar_jugada_primitiva();
		crear_explicacion();
		
	}
	 void parar(){
		 
	 }
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
	 void seleccionar_jugada_primitiva(){
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
			 
		 }
		 
	 }
	 
	void crear_explicacion(){
	 
		 String expli;
		 System.out.println("ingresar explicacion de la jugada:");
		 scanner.nextLine();
		 expli=scanner.nextLine();
		 System.out.println("\n"+"la juagada tiene esta explicaion:"+"\n"+expli);
	 }
}
