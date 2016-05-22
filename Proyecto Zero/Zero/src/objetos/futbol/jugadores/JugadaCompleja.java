package objetos.futbol.jugadores;
import java.io.Serializable;
import java.util.ArrayList;

import lejos.util.Delay;
import objetos.futbol.JugadasPrimitivas.*;
import objetos.futbol.menuconsola.UsuarioAdmin;

public abstract class JugadaCompleja extends Jugada implements Serializable{
	String nombreJugada;//revisar bien encapsulamiento-No se debe cambiar luego de establecer
	String fechaCreacion; //dia-mes-año -----No se debe cambiar luego de establecer
	String Explicacion;
    public ArrayList <jugadaPrimitiva> listaJugadasP;
	String Autor; //Tenemos que revisar donde lo creamos -----No se debe cambiar luego de establecer

	public JugadaCompleja(String NomJug, String FechCrea, String Aut, ArrayList<jugadaPrimitiva> List, String Expli){
		this.nombreJugada = NomJug;
		this.fechaCreacion = FechCrea;
		this.Autor = Aut;
		this.listaJugadasP = List;
		this.Explicacion = Expli;
	}
	public JugadaCompleja(String nuller){
		ArrayList g = new ArrayList<jugadaPrimitiva>(0);
		this.nombreJugada=nuller;
		this.fechaCreacion="0";
		this.Autor=" ";
		this.listaJugadasP=g;
		this.Explicacion=" ";
		
	}
	public String toString(){
		return "Jugada " +this.nombreJugada ;
	}
	public String getNombre(){
		return this.nombreJugada ;
	}
	
	public boolean equals (JugadaCompleja JC){
		if (JC.listaJugadasP.size()==this.listaJugadasP.size()){
			if (this.listaJugadasP.equals(JC.listaJugadasP)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
	}
	public void ejecutar(){
		for (int i=0;i<this.listaJugadasP.size();i++){
			this.listaJugadasP.get(i).ejecutar();
			Delay.msDelay(1500);
			this.listaJugadasP.get(i).parar();
		}
	} // en las 3 subclases dice en el texto que antes de ejecutar se tiene que calcular la posicion del robot y que no 
	
	public abstract void parar();
	public String getInformacion(){
		return Explicacion;
	}
	
}
