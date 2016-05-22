package objetos.futbol.menuconsola;

import java.io.Serializable;

public class Admin_ConsultarInfo extends Admin_Consultar_ListaJugadores implements Serializable{
	//para devolver al menu se usarÃ¡ (t) como opciÃ³n
	int opc_1;
	String opc;
	//duda con este punto
	//CUAL ES LA INFORMACION A MOSTRA?-R
	public void ejecutar(){
		a=MenuDeConsola.lista_delanteros.size();
		b=MenuDeConsola.lista_arqueros.size();
		opc_1= elegir_opcion();
		if(opc_1==9999){
			
		}
		else{
			if((opc_1<a) && (opc_1>=0)){
				System.out.println(MenuDeConsola.lista_delanteros.get(opc_1));
			}
			else{
				System.out.println(MenuDeConsola.lista_arqueros.get(opc_1-a));
			}
		}
	}
	int elegir_opcion(){
		while(true){
			imprimir_jugadores();
			System.out.println("(t) para volver al menu");
			opc=scanner.next();
			for(int i=0;i<a+b;i++){
				if(opc.compareTo(Integer.toString(i))==0){
					return i;
				}
			}
			if(opc.compareTo("t")==0||opc.compareTo("T")==0){
				return 9999;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
			}
		}
	}
	
}
