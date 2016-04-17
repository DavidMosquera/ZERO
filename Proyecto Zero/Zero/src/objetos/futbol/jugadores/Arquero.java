package objetos.futbol.jugadores;

import java.io.Serializable;
import java.util.ArrayList;

//EDITABLE, AUN NO SABEMOS DONDE ESTÁN LOS MOTORES DEL ROBOT.
public class Arquero extends Futbolista implements Serializable{
	private int TiempoSinGoles;
	private byte dorsal;
	public Arquero(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas, 
			 int TiempoSinGoles, byte dorsal){
		super(nombre,posicion,listaJugadas); //Invocamos al constructor de la superclase
		this.TiempoSinGoles=TiempoSinGoles;
		this.dorsal=dorsal;
	}
	public String getInformacion(){
		return super.toString()+" con el dorsal"+ this.dorsal +" Tiempo sin Goles "+
	this.TiempoSinGoles; //no se sobre escribe el metodo ToString de la superClase
	}
	public int getTiempoSinGoles(){
		return this.TiempoSinGoles;
	}

}

