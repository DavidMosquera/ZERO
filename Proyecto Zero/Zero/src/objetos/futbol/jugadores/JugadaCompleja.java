package objetos.futbol.jugadores;
import java.util.*;
import objetos.futbol.JugadasPrimitivas.*;

public abstract class JugadaCompleja {
	String nombreJugada;//revisar bien encapsulamiento-No se debe cambiar luego de establecer
	String fechaCreacion; //dia-mes-año -----No se debe cambiar luego de establecer
	String Explicacion;
    ArrayList <jugadaPrimitiva> listaJugadasP;
	UsuarioAdministrador Autor; //Tenemos que revisar donde lo creamos -----No se debe cambiar luego de establecer

	public JugadaCompleja(String NomJug, String FechCrea, UsuarioAdministrador Aut, ArrayList<jugadaPrimitiva> List, String Expli){
		this.nombreJugada = NomJug;
		this.fechaCreacion = FechCrea;
		this.Autor = Aut;
		this.listaJugadasP = List;
		this.Explicacion = Expli;
	}
	
	public String toString(){
		return "Jugada " +this.nombreJugada ;
	}
	
	public boolean equals (JugadaCompleja JC){
		if (JC.listaJugadasP.size()==this.listaJugadasP.size()){
			if (this.listaJugadasP.equals(JC.listaJugadasP)){
				return true;
			}
		}
		else{
			return false;
		}
		
	}
	public abstract String IdentificarJugada();
	public abstract void ejecutar(); // en las 3 subclases dice en el texto que antes de ejecutar se tiene que calcular la posicion del robot y que no 
	//infirnja las normas y luego ejecutar la jugada
	public abstract void parar();
	
}
