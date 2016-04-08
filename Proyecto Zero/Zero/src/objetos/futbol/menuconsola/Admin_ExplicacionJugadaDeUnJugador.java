package objetos.futbol.menuconsola;

public class Admin_ExplicacionJugadaDeUnJugador extends Admin_ConsultarListaJugadasDeUnJugador{
	void ejecutar(){
		a=MenuDeConsola.lista_delanteros.size();
		b=MenuDeConsola.lista_arqueros.size();
		int jugador =mostrar_jugadas_complejas();
		String elegir=scanner.next();
		//while(true){
			
		//}
		elegir_jugada_compleja(elegir,jugador);
	}
	//terminar, esta muy complejo :( 
	//pero tu puedes, yo se que si
	//falta retringir la entrada de elegir, 
	void elegir_jugada_compleja(String opc,int opc_1){
		if(opc_1==9999){
			
		}
		else if(opc_1<a){
			for(int i=0;i<3;i++){
				if(opc.compareTo(Integer.toString(i))==0){
					MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.get(i).getExplicacion();
				}
			}
		}
		else{
			for(int i=0;i<3;i++){
				if(opc.compareTo(Integer.toString(i))==0){
					MenuDeConsola.lista_arqueros.get(opc_1-a).listaJugadas.get(i).getExplicacion();
				}
			}
		}
	}
	
}
