package objetos.futbol.menuconsola;
//URGENTE!
//saber como sacar la descripcion de la jugada compleja

class Admin_ConsultarListaJugadasDeUnJugador extends Admin_ConsultarInfo{
	String elegir;
	void Ejecutar(){
		mostrar_jugadas_complejas();
		System.out.println("Presione cualquier tecla para volver");
		elegir=scanner.next();
	}
	//muestra las jugadas complejas de un jugador
	int mostrar_jugadas_complejas(){
		a=MenuDeConsola.lista_delanteros.size();
		b=MenuDeConsola.lista_arqueros.size();
		
		opc_1=elegir_opcion();
		
		if(opc_1==9999){
			
		}
		else{
			if(opc_1<a){
				for(int i=0;i<MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.size();i++){
					System.out.println("("+i+")"+MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.get(i).toString());
				}
			}
			else{
				for(int i=0;i<MenuDeConsola.lista_arqueros.get(opc_1-a).listaJugadas.size();i++){
					System.out.println("("+i+")"+MenuDeConsola.lista_delanteros.get(opc_1-a).listaJugadas.get(i).toString());
				}
			}
		
		}
		return opc_1;
	}
}
