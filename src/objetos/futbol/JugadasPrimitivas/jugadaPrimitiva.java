package objetos.futbol.JugadasPrimitivas;

import lejos.nxt.Motor;
import objetos.futbol.jugadores.JugadaCompleja;

public abstract class jugadaPrimitiva extends Jugada {
	String nombre; //revisar si se hacen public o default
	int potencia;
	protected boolean first_t=false;
	static double Delta_Taco; //Delta del tacómetro, lo utilizamos en cada clase para 
   	                      //encontrar las componentes de X y Y en la cancha
	protected void first_T(){
		if(this.first_t==false){
			Motor.A.setSpeed(potencia);
			Motor.B.setSpeed(potencia);
			this.first_t=true;
		}
	}
	public abstract void ejecutar();
	public abstract void parar();
	public String getInformacion(){
		String s="Jugada: "+nombre+" Potencia: "+potencia;
		return s;
	}
}
