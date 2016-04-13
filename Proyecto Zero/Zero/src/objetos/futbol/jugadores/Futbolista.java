package objetos.futbol.jugadores;

import java.io.Serializable;
import java.util.ArrayList;

import objetos.futbol.JugadasPrimitivas.Jugada;

//IMPORTANTE:
//EDITABLE, AUN NO SABEMOS DONDE ESTÃ�N LOS MOTORES DEL ROBOT.
//TODAS LAS MEDIDAS SE ENCUENTRAN EN mm (milÃ­metros)
public class Futbolista implements Serializable {
	//Ponemos los motores como atributos de cada futbolista para dar informaciÃ³n a los
	// otros mÃ©todos. D#11
	private String nombre;
	private final String posicion;
	public ArrayList<JugadaCompleja> listaJugadas;
	public static ArrayList<Jugada> listaTotalJugadas= new ArrayList<Jugada>(); //lista de todas las jugadas complejas
	
	public Futbolista(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas){
		this.nombre=nombre;
		this.posicion=posicion;
		this.listaJugadas=listaJugadas;// Â¿Podemos poner directamente la lista o 
		                               // crear una nueva D#7?
	}
	public String toString(){
		return "El futbolista " +this.nombre + "juega de " + this.posicion;
	}
	public boolean equals (Futbolista f){
		if (this.nombre.compareTo(f.nombre)==0&&this.posicion.compareTo(f.posicion)==0){
			return true;
		}
		else{
			return false;
		}
		//Duda, Â¿se tiene que comparar tambiÃ©n las jugadas que tienen cada jugador?
	}
	public  boolean jugarConLasManos(){ // si el metodo es abstracto, debemos poner una	                               // clase abstracta, Â¿cÃ³mo lo solucionamos?
		if (this.posicion.compareTo("Portero")==0){
			return true;
		}
		else{
			return false;
		}
	}
	// Suponemos el uso de mÃ©todos para accesar a las variables
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public String getPosicion(){
		return this.posicion;
		//pusimos el this para que quede mas bonito y nos evitamos errores
	}
}
