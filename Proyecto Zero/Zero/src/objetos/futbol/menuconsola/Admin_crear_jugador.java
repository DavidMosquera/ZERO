package objetos.futbol.menuconsola;

import java.util.ArrayList;
import java.util.Scanner;
//COMPLETAR!!

import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;

public class Admin_crear_jugador extends OpcionDeMenu{
	private String posicion;
	private String nombre;
	private int dorsal;
	private ArrayList<JugadaCompleja> JC= new ArrayList<JugadaCompleja>();
	private Scanner scanner = new Scanner(System.in); 
	private boolean paso_1=true,paso_2=true,paso_3=true,paso_4=true;
	void ejecutar(){
		arq_del();
		System.out.println("ingrese el nombre");
		nombre=scanner.next();
		System.out.println("eligió "+nombre);
		System.out.println("elegir dorso");
		dorsal = scanner.nextInt();
		System.out.println("elegir jugadas complejas");
		for (int i =0;i<3;i++){
			for(int j=0;j<Futbolista.listaTotalJugadas.size();j++){
				System.out.println("("+j+") "+Futbolista.listaTotalJugadas.get(j));
			}
			
			int z=scanner.nextInt();
			JC.add((JugadaCompleja)Futbolista.listaTotalJugadas.get(z));
			System.out.println("ingreso "+JC.get(i));
			
			
		}
		System.out.println("crear el jugarodor con nombre "+nombre+" con dorso "+dorsal+"y jugadas complejas");
		System.out.println("(1)si"+"\n"+"(2)no");
		String cambiar=scanner.next();
		if (cambiar.compareTo("1")==0){
			if(posicion.compareTo("Delantero")==0){
				
				MenuDeConsola.lista_futbolistas.add(new Delantero(nombre,posicion,JC,0,dorsal));
				MenuDeConsola.lista_delanteros.add(new Delantero(nombre,posicion,JC,0,dorsal));
			}
			else if(posicion.compareTo("Arquero")==0){
				MenuDeConsola.lista_futbolistas.add(new Arquero(nombre,posicion,JC,0,(byte)dorsal));
				MenuDeConsola.lista_arqueros.add(new Arquero(nombre,posicion,JC,0,(byte)dorsal));
			}
		}
		else{}
		
		/*do{
			arq_del();
			while(paso_2){
				elegir_nombre();
				System.out.println(nombre);
				while(paso_3){
					elegir_dorso();
					
				}
			}
			
		}while(paso_1);*/

		
	}
	void parar(){
		
	}
	
	
	private void elegir_dorso(){
		int nom;
		while(true){
			System.out.println("\n"+"Elija un dorso");
			nom = scanner.nextInt();
			System.out.println("su "+ this.posicion+" se llamará "+ nom);
			System.out.println("(1) correcto");
			System.out.println("(2) elegir otra vez");
			System.out.println("(t) salir");
			String opc= scanner.next();
			if(opc.compareTo("1")==0){
				this.dorsal=nom;
				return;
			}
			else if(opc.compareTo("2")==0){
				
			}
			else if(opc.compareTo("t")==0){
				paso_4=false;
				paso_3=false;
				return;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}
	}
	
	
	private void elegir_nombre(){
		String nom;
		while(true){
			System.out.println("\n"+"Elija un nombre");
			nom = scanner.nextLine();
			System.out.println("su "+ this.posicion+" se llamará "+ nom);
			System.out.println("(1) correcto");
			System.out.println("(2) elegir otra vez");
			System.out.println("(t) salir");
			String opc= scanner.next();
			if(opc.compareTo("1")==0){
				this.nombre=nom;
				return;
			}
			else if(opc.compareTo("2")==0){
				
			}
			else if(opc.compareTo("t")==0){
				paso_3=false;
				paso_2=false;
				return;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}
	}
	private void arq_del(){
		String pos;
		while (true){
			System.out.println("\n"+"Elija la posicion");
			System.out.println("(1) Delantero");
			System.out.println("(2) Arquero");
			System.out.println("(t) salir");
			pos = scanner.next();
			if(pos.compareTo("1")==0){
				this.posicion="Delantero";
				paso_2=true;
				return;
			}
			else if(pos.compareTo("2")==0){
				this.posicion="Arquero";
				paso_2=true;
				return;
			}
			else if(pos.compareTo("t")==0){
				paso_1=false;
				paso_2=false;
				return;
			}
			else {
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}
	}
	
}
