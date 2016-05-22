package objetos.futbol.menuconsola;

import java.io.Serializable;

//URGENTE!
//saber como sacar la descripcion de la jugada compleja

class Admin_ConsultarListaJugadasDeUnJugador extends Admin_ConsultarInfo implements Serializable{
	String elegir;
	public void ejecutar(){
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
				if(MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.size()==0){
					System.out.println("No hay jugadas complejas");
					return 9999;
				}

				for(int i=0;i<MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.size();i++){
					System.out.println("("+i+")"+MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.get(i));
				}
			}
			else{
				if(MenuDeConsola.lista_arqueros.get(opc_1-a).listaJugadas.size()==0){
					System.out.println("No hay jugadas complejas");
					return 9999;
				}

				for(int i=0;i<MenuDeConsola.lista_arqueros.get(opc_1-a).listaJugadas.size();i++){
					System.out.println("("+i+")"+MenuDeConsola.lista_delanteros.get(opc_1-a).listaJugadas.get(i));
				}
			}
		
		}
		return opc_1;
	}
}
