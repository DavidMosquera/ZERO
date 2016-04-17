package objetos.futbol.menuconsola;

import java.io.Serializable;

public class Admin_ExplicacionJugadaDeUnJugador extends Admin_ConsultarListaJugadasDeUnJugador implements Serializable{
	String elegir;
	void ejecutar(){
		a=MenuDeConsola.lista_delanteros.size();
		b=MenuDeConsola.lista_arqueros.size();
		System.out.println("llegamos aqui 1");
		int jugador =mostrar_jugadas_complejas();
		while(true){
			if(jugador==9999){
				break;
			}
			else if(jugador<a){
				elegir=scanner.next();
				for(int i=0;i<MenuDeConsola.lista_delanteros.get(jugador).listaJugadas.size();i++){
					if(elegir.compareTo(Integer.toString(i))==0){
						elegir_jugada_compleja(elegir, jugador);
					}
				}
				break;

			}
			else {
				elegir=scanner.next();
				for(int i=0;i<MenuDeConsola.lista_arqueros.get(jugador-a).listaJugadas.size();i++){
					if(elegir.compareTo(Integer.toString(i))==0){
						elegir_jugada_compleja(elegir, jugador);
					}
				}
				break;

			}
		}

		
	}
	//terminar, esta muy complejo :( 
	//pero tu puedes, yo se que si
	//falta retringir la entrada de elegir, 
	void elegir_jugada_compleja(String opc,int opc_1){
		if(opc_1<a){
			for(int i=0;i<3;i++){
				if(opc.compareTo(Integer.toString(i))==0){
					System.out.println(MenuDeConsola.lista_delanteros.get(opc_1).listaJugadas.get(i).getInformacion());
					System.out.println("Presione cualquier letra para continuar");
					elegir= scanner.next();
				}
			}
		}
		else{
			for(int i=0;i<3;i++){
				if(opc.compareTo(Integer.toString(i))==0){
					System.out.println(MenuDeConsola.lista_arqueros.get(opc_1-a).listaJugadas.get(i).getInformacion());
					System.out.println("Presione cualquier letra para continuar");
					elegir= scanner.next();
				}
			}
		}
	}
	
}
