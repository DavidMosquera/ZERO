package objetos.futbol.jugadores;

import java.io.Serializable;
import java.util.ArrayList;

import lejos.nxt.Motor;
import objetos.futbol.JugadasPrimitivas.jugadaPrimitiva;
import objetos.futbol.menuconsola.UsuarioAdmin;

public class JugadaComplejaDefensiva extends JugadaCompleja implements Serializable{
	int i;
	public JugadaComplejaDefensiva(String NomJug, String FechCrea, UsuarioAdmin Aut, ArrayList<jugadaPrimitiva> List, String Expli){
		super(NomJug,FechCrea,Aut, List,Expli);
	}
	public void ejecutar(){
		for (i=0;i<this.listaJugadasP.size();i++){
			this.listaJugadasP.get(i).ejecutar();
		}
	}
        public void parar(){
        	Motor.A.stop();
		Motor.B.stop();
		Motor.C.stop(); //Aca tendriamos que hacer que el brazo vuelva a la posicion inicial, ya que puede parase mientras lo levanta
	}
        public String IdentificarJugada(){
	        return "Jugada Defensiva";
	    }

}
