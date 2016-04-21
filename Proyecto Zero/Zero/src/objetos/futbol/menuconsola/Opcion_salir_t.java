package objetos.futbol.menuconsola;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import objetos.futbol.jugadores.JugadaCompleja;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;

public class Opcion_salir_t extends OpcionDeMenu{
	private Delantero delantero;
	private Arquero arquero;
	private ArrayList<JugadaCompleja> Jug_Com_Imprimir = new ArrayList<JugadaCompleja>();
	private ArrayList<Integer> Jug_Com_Imprimir_Num = new ArrayList<Integer>();
	Opcion_salir_t(Delantero Del, Arquero Arq){
		this.arquero = Arq;
		this.delantero = Del;
		for (int i=0;i<this.arquero.listaJugadas.size();i++){
			if (Jug_Com_Imprimir.contains(this.arquero.listaJugadas.get(i))==false){
				Jug_Com_Imprimir.add(this.arquero.listaJugadas.get(i));
				Jug_Com_Imprimir_Num.add(0);
			}
		}
        for (int i=0;i<this.delantero.listaJugadas.size();i++){
        	if (Jug_Com_Imprimir.contains(this.delantero.listaJugadas.get(i))==false){
				Jug_Com_Imprimir.add(this.delantero.listaJugadas.get(i));
				Jug_Com_Imprimir_Num.add(0);
			}
		}
	}
	
	void ejecutar() throws IOException{
		int a = UsuarioUsuario.goles_a_favor;
		int b = UsuarioUsuario.goles_en_contra;
		System.out.println("el resultado es :");
		System.out.println("a favor "+ a+" - "+b+" en contra");
		//comprueba si gano, erdio o empato
		if(a==b){
			System.out.println("empate");
		}
		else if(a>b){
			System.out.println("ganaste!!!");
		}
		else{
			System.out.println("perdiste... se veía venir Manqui");
		}
		BufferedReader LectorTxt = new BufferedReader(new FileReader("Temporal.txt"));
		String Aux1;
		String Aux2;
		String Aux3;
		
		do {

			Aux1 = LectorTxt.readLine();
			Aux2 = LectorTxt.readLine();
			Aux3 = LectorTxt.readLine();
			for(int i=0;i<Jug_Com_Imprimir.size();i++){
				if (Aux1.compareTo(Jug_Com_Imprimir.get(i).getNombre())==0){
					Jug_Com_Imprimir_Num.set(i, (Jug_Com_Imprimir_Num.get(i)+1));
				}
			}
			if (Aux1 == null) {
				break;
			}
		} while (true);
		LectorTxt.close();
		for (int i=0;i<Jug_Com_Imprimir.size();i++){
			System.out.println(Jug_Com_Imprimir.get(i) + " se realizó: " + Jug_Com_Imprimir_Num.get(i) + " veces.");
		}
		UsuarioUsuario.Cancha1.IniciarRobot();
	}
	void parar(){
		
	}
}
