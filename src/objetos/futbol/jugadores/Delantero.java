package objetos.futbol.jugadores;

import java.io.Serializable;
import java.util.ArrayList;

//EDITABLE, AUN NO SABEMOS DONDE ESTÃ�N LOS MOTORES DEL ROBOT.
public class Delantero extends Futbolista implements Serializable{
	 private int golesMarcados;
	 private String dorsal; // NÃºmero de la camiseta
	 public Delantero (int i){
		 super(i);
	 }
	 public Delantero(String nombre, String posicion, ArrayList<JugadaCompleja> listaJugadas, String dorsal){
		super(nombre,posicion,listaJugadas); //Invocamos al constructor de la superclase
		this.golesMarcados=0;
		this.dorsal=dorsal;
	 }
	 public String toString(){ //Invocamos el ToString de la superclase para ahorrar cÃ³digo
		 return super.toString()+ " con el dorsal " +this.dorsal+" Ha marcado "
				 + this.golesMarcados;
	 }
	 public int getGolesMarcados(){
		 return this.golesMarcados;
	 }
	 public void setGolesMarcados(int i){
		 golesMarcados+=i;
	 }
}
