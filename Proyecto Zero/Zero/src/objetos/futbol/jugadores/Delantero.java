package objetos.futbol.jugadores;
//EDITABLE, AUN NO SABEMOS DONDE ESTÁN LOS MOTORES DEL ROBOT.
public class Delantero extends Futbolista {
	 private short golesMarcados;
	 private byte dorsal; // Número de la camiseta
	 public Delantero(String nombre, String posicion, JugadaCompleja[] listaJugadas, 
			 short golesMarcados, byte dorsal){
		super(nombre,posicion,listaJugadas); //Invocamos al constructor de la superclase
		this.golesMarcados=golesMarcados;
		this.dorsal=dorsal;
	 }
	 public String toString(){ //Invocamos el ToString de la superclase para ahorrar código
		 return super.toString()+ " con el dorsal " +this.dorsal+" Ha marcado "
				 + this.golesMarcados;
	 }
}
