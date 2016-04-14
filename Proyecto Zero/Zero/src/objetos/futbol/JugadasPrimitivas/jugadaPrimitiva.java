package objetos.futbol.JugadasPrimitivas;

import objetos.futbol.jugadores.JugadaCompleja;

public abstract class jugadaPrimitiva extends Jugada {
	String nombre; //revisar si se hacen public o default
	int potencia;
	static double Delta_Taco; //Delta del tacómetro, lo utilizamos en cada clase para 
	                      //encontrar las componentes de X y Y en la cancha
	public abstract void ejecutar();
	public abstract void parar();
	public String getInformacion(){
		String s="Jugada: "+nombre+" Potencia: "+potencia;
		return s;
	}
}
