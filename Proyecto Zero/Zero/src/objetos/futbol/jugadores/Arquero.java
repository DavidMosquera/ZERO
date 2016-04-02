package objetos.futbol.jugadores;
//EDITABLE, AUN NO SABEMOS DONDE ESTÁN LOS MOTORES DEL ROBOT.
public class Arquero extends Futbolista {
	private int TiempoSinGoles;
	private byte dorsal;
	public Arquero(String nombre, String posicion, JugadaCompleja[] listaJugadas, 
			 int TiempoSinGoles, byte dorsal){
		super(nombre,posicion,listaJugadas); //Invocamos al constructor de la superclase
		this.TiempoSinGoles=TiempoSinGoles;
		this.dorsal=dorsal;
	}
	public String getInformacion(){
		return super.toString()+" con el dorsal"+ this.dorsal +" Tiempo sin Goles "+
	this.TiempoSinGoles; //no se sobre escribe el metodo ToString de la superClase
	}
	 

}
