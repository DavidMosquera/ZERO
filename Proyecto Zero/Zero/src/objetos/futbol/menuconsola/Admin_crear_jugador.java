package objetos.futbol.menuconsola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
//COMPLETAR!!

import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;

public class Admin_crear_jugador extends OpcionDeMenu implements Serializable{
	private String posicion;
	private String nombre;
	private int dorsal; 
	private transient Scanner scanner = new Scanner(System.in); 
	void ejecutar(){
		ArrayList<JugadaCompleja> JC= new ArrayList<JugadaCompleja>();
		arq_o_del();
		selecciona_nombre();
		elegir_dorso();
		elegir_jugadas_complejas(JC);
		System.out.println("crear el jugarodor con nombre "+nombre+" con dorso "+dorsal+" y jugadas complejas");
		System.out.println("(1)si"+"\n"+"(2)no");
		String cambiar=scanner.next();
		if (cambiar.compareTo("1")==0){
			if(posicion.compareTo("Delantero")==0){

				MenuDeConsola.lista_delanteros.add(new Delantero(nombre,posicion,JC,0,dorsal));
			}
			else if(posicion.compareTo("Arquero")==0){
				MenuDeConsola.lista_arqueros.add(new Arquero(nombre,posicion,JC,0,(byte)dorsal));
			}
		}
		else{}

		
	}
	void parar(){
		
	}
	//metodo para elegir las jugadas complejas
	private void elegir_jugadas_complejas(ArrayList Jc){
		System.out.println("elegir jugadas complejas");
		for (int i =0;i<3;i++){
			for(int j=0;j<Futbolista.listaTotalJugadas.size();j++){
				System.out.println("("+j+") "+Futbolista.listaTotalJugadas.get(j));
			}
			while(true){
				try{	
					int z=scanner.nextInt();
					Jc.add((JugadaCompleja)Futbolista.listaTotalJugadas.get(z));
					System.out.println("ingreso "+Jc.get(i));
					break;
				}
				catch(Exception e){
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}
			}
			System.out.println("llevas "+(i+1)+" jugadas");
			System.out.println("deseas seguir?");
			System.out.println("(1) salir "+"\n"+"o cualquier letra para seguir");
			try{
				int x= scanner.nextInt();
				if(x==1){
					System.out.println("saliste con "+Jc.size()+" jugadas");
					break;
				}
				else{
					System.out.println("elegiste segir");
				}
			}
			catch(Exception e){
				System.out.println("elegiste seguir");
			}
			
			
			
			
		}
	}
	//para confirmar si el admin quiere elegir ese jugador
/*	private void confirmacion(){
		System.out.println("crear el jugarodor con nombre "+nombre+" con dorso "+dorsal+"y jugadas complejas");
		System.out.println("(1)si"+"\n"+"(2)no");
		String cambiar=scanner.next();
		if (cambiar.compareTo("1")==0){
			if(posicion.compareTo("Delantero")==0){
				

				MenuDeConsola.lista_delanteros.add(new Delantero(nombre,posicion,JC,0,dorsal));
			}
			else if(posicion.compareTo("Arquero")==0){

				MenuDeConsola.lista_arqueros.add(new Arquero(nombre,posicion,JC,0,(byte)dorsal));
			}
		}
		else{}
		
	} */
	//para selecionar la posicion del jugador 
	private void arq_o_del(){
		String pos;
		while (true){
			System.out.println("\n"+"Elija la posicion");
			System.out.println("(1) Delantero");
			System.out.println("(2) Arquero");
			System.out.println("(t) salir");
			pos = scanner.next();
			if(pos.compareTo("1")==0){
				this.posicion="Delantero";
				return;
			}
			else if(pos.compareTo("2")==0){
				this.posicion="Arquero";
				return;
			}
			else if(pos.compareTo("t")==0){
				return;
			}
			else {
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}
	}
	private void selecciona_nombre(){
		System.out.println("\n"+"Ingresar nombre del jugador:");
		scanner.nextLine();
		nombre=scanner.nextLine();
		System.out.println("\n"+"el jugador se llama:"+"\n"+nombre);
			
	}
	private void elegir_dorso(){
		System.out.println("\n"+"Ingresar el dorso del jugador");
		while(true){
			try{
				dorsal=scanner.nextInt();
				break;
			}
			catch(Exception e){
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				scanner.nextLine();
			}
			
		}
	}
	
}
