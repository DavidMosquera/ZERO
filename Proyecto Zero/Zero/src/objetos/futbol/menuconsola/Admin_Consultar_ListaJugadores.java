package objetos.futbol.menuconsola;

import java.util.Scanner;

public class Admin_Consultar_ListaJugadores extends OpcionDeMenu{
	private String esperar;
	Scanner scanner =new Scanner(System.in); 
	int a;
	int b;
	void ejecutar(){
		a=MenuDeConsola.lista_delanteros.size();
		b=MenuDeConsola.lista_arqueros.size();
		imprimir_jugadores();
		System.out.println("Presione cualquier tecla para volver al menú");
		esperar = scanner.next();
		
	}
	void parar(){
		
	}
	void imprimir_jugadores(){
		System.out.println("Delanteros:");
		int a=MenuDeConsola.lista_delanteros.size();
		int b=MenuDeConsola.lista_arqueros.size();
		for (int i=0;i<a;i++){
			System.out.println(i+". "+MenuDeConsola.lista_delanteros.get(i).getNombre());
		}
		System.out.println();
		System.out.println("Arqueros:");
		for(int i=a;i<a+b;i++){
			System.out.println(i+". "+MenuDeConsola.lista_arqueros.get(i-a).getNombre());
		}
	}
}
