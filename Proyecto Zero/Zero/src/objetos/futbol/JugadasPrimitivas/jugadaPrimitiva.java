package objetos.futbol.JugadasPrimitivas;
abstract class jugadaPrimitiva {
	String nombre; //revisar si se hacen public o default
	int potencia;
	public abstract void ejecutar();
	public abstract void parar();
	public String getInformacion(){
		String s="Jugada: "+nombre+" Potencia: "+potencia;
		return s;
	}
}