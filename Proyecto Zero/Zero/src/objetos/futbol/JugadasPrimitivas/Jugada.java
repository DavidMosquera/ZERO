package objetos.futbol.JugadasPrimitivas;

import java.io.Serializable;

import objetos.futbol.jugadores.JugadaCompleja;

abstract public class Jugada implements Serializable{
	protected abstract void ejecutar();
	protected abstract void parar();
	protected abstract String getInformacion();
	public boolean equals(JugadaCompleja JC){
		return false;
	}
}
