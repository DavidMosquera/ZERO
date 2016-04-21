package objetos.futbol.menuconsola;

import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;

public class Admin_agregar_quitar_jugada_compleja extends Admin_Consultar_ListaJugadores {

	int opcion;
	Futbolista eleccion;

	void ejecutar() {
		a = MenuDeConsola.lista_delanteros.size();
		b = MenuDeConsola.lista_arqueros.size();
		imprimir_jugadores();
		elegir_opcion();
		imprimir_jc();
		if (opcion == 1) {
			anadir();
		} else {
			quitar();
		}
	}

	void parar() {

	}
	//añade 
	void anadir() {
		if (eleccion.listaJugadas.size() == 3) {
			System.out.println("no puede añadir jugadas, primero debe eliminar alguna");
		}
		else{
			if(Delantero.listaTotalJugadas.size()==0){
				System.out.println("somos anormales");
				return;
			}
			for (int i=0;i<Delantero.listaTotalJugadas.size();i++){
				System.out.println("("+i+") "+Delantero.listaTotalJugadas.get(i));
			}
			while(true){
				try{
					opcion=scanner.nextInt();
					eleccion.listaJugadas.add((JugadaCompleja) Delantero.listaTotalJugadas.get(opcion));
					return;
				}
				catch(Exception e){
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
					scanner.nextLine();
				}
			}
		}
	}
//quita una Jc de algun jugador
	void quitar() {
		for (int i = 0; i < eleccion.listaJugadas.size(); i++) {
			System.out.println("(" + i + ")" + eleccion.listaJugadas.get(i));
		}
		if (eleccion.listaJugadas.size() > 1) {
			while (true) {
				try {
					opcion = scanner.nextInt();
					eleccion.listaJugadas.remove(opcion);
					return;
				} catch (Exception e) {
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
					scanner.nextLine();
				}
			}
		} else {
			System.out.println("No se puede eleminar, necesitas tener por lo menos dos jugadas");
		}
	}
//elige un jugador de la lista de jugadores
	void elegir_opcion() {
		while (true) {
			try {
				System.out.println("elige un jugador");
				opcion = scanner.nextInt();
				if (opcion < a) {
					eleccion = MenuDeConsola.lista_delanteros.get(opcion);
					break;
				} else if (opcion < a + b) {
					eleccion = MenuDeConsola.lista_arqueros.get(opcion - a);
					break;
				} else {
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}

			} catch (Exception e) {
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				scanner.nextLine();
			}
		}
	}
//imprime las jugadas complejas de un jugador
	void imprimir_jc() {
		for (int i = 0; i < eleccion.listaJugadas.size(); i++) {
			System.out.println(eleccion.listaJugadas.get(i));
		}
		System.out.println("(1) añadir" + "\n" + "(2) quitar");
		while (true) {
			try {
				this.opcion = scanner.nextInt();
				if (opcion == 1 || opcion == 2) {
					return;
				} else {
					System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				}
			} catch (Exception e) {
				System.out.println("ERROR NUMERO INGRESADO NO VÃ�LIDO");
				scanner.nextLine();
			}
		}
	}
}
