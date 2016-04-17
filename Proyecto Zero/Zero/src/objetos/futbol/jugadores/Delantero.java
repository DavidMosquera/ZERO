package objetos.futbol.jugadores;

import java.io.Serializable;
import java.util.ArrayList;

//EDITABLE, AUN NO SABEMOS DONDE ESTÁN LOS MOTORES DEL ROBOT.
public class Delantero extends Futbolista implements Serializable{
	 private int golesMarcados;
	 private int dorsal; // Número de la camiseta
	 public Delantero(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas, 
			 int golesMarcados, int dorsal){
		super(nombre,posicion,listaJugadas); //Invocamos al constructor de la superclase
		this.golesMarcados=golesMarcados;
		this.dorsal=dorsal;
	 }
	 public String toString(){ //Invocamos el ToString de la superclase para ahorrar código
		 return super.toString()+ " con el dorsal " +this.dorsal+" Ha marcado "
				 + this.golesMarcados;
	 }
	 public int getGolesMarcados(){
		 return this.golesMarcados;
	 }
}
