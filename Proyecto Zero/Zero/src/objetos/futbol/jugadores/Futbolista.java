package objetos.futbol.jugadores;
//IMPORTANTE:
//EDITABLE, AUN NO SABEMOS DONDE EST�N LOS MOTORES DEL ROBOT.
//TODAS LAS MEDIDAS SE ENCUENTRAN EN mm (mil�metros)
public class Futbolista {
	//Ponemos los motores como atributos de cada futbolista para dar informaci�n a los
	// otros m�todos. D#11
	private String nombre;
	private final String posicion;
	public JugadaCompleja[] listaJugadas;
	public static JugadaCompleja[] listaTotalJugadas; //lista de todas las jugadas complejas
	
	public Futbolista(String nombre, String posicion, JugadaCompleja[] listaJugadas){
		this.nombre=nombre;
		this.posicion=posicion;
		this.listaJugadas=listaJugadas;// �Podemos poner directamente la lista o 
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
		//Duda, �se tiene que comparar tambi�n las jugadas que tienen cada jugador?
	}
	public  boolean jugarConLasManos(){ // si el metodo es abstracto, debemos poner una	                               // clase abstracta, �c�mo lo solucionamos?
		if (this.posicion.compareTo("Portero")==0){
			return true;
		}
		else{
			return false;
		}
	}
	// Suponemos el uso de m�todos para accesar a las variables
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}
