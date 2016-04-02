package objetos.futbol.jugadores;
//IMPORTANTE:
//EDITABLE, AUN NO SABEMOS DONDE ESTÁN LOS MOTORES DEL ROBOT.
//TODAS LAS MEDIDAS SE ENCUENTRAN EN mm (milímetros)
public class Futbolista {
	//Ponemos los motores como atributos de cada futbolista para dar información a los
	// otros métodos. D#11
	private String nombre;
	private final String posicion;
	public JugadaCompleja[] listaJugadas;
	public static JugadaCompleja[] listaTotalJugadas; //lista de todas las jugadas complejas
	
	public Futbolista(String nombre, String posicion, JugadaCompleja[] listaJugadas){
		this.nombre=nombre;
		this.posicion=posicion;
		this.listaJugadas=listaJugadas;// ¿Podemos poner directamente la lista o 
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
		//Duda, ¿se tiene que comparar también las jugadas que tienen cada jugador?
	}
	public  boolean jugarConLasManos(){ // si el metodo es abstracto, debemos poner una	                               // clase abstracta, ¿cómo lo solucionamos?
		if (this.posicion.compareTo("Portero")==0){
			return true;
		}
		else{
			return false;
		}
	}
	// Suponemos el uso de métodos para accesar a las variables
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
