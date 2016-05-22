package objetos.futbol.menuconsola;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import objetos.futbol.jugadores.Futbolista;

public class Opcion_parar_partido_p extends OpcionDeMenu {
	public void ejecutar()  throws IOException{
		int i;
		ObjectOutputStream SaverObjetos = new ObjectOutputStream(new FileOutputStream("Estado_Sistema.dat"));
		if (MenuDeConsola.lista_arqueros.isEmpty() == false) {
			for (i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
				SaverObjetos.writeObject(MenuDeConsola.lista_arqueros.get(i));
			}
		}
		if (MenuDeConsola.lista_delanteros.isEmpty() == false) {
			for (i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
				SaverObjetos.writeObject(MenuDeConsola.lista_delanteros.get(i));
			}
		}
		if (MenuDeConsola.lista_usuariosUsuarios.isEmpty() == false) {
			for (i = 0; i < MenuDeConsola.lista_usuariosUsuarios.size(); i++) {
				SaverObjetos.writeObject(MenuDeConsola.lista_usuariosUsuarios.get(i));
			}
		}
		if (MenuDeConsola.lista_usuariosAdmin.isEmpty() == false) {
			for (i = 0; i < MenuDeConsola.lista_usuariosAdmin.size(); i++) {
				SaverObjetos.writeObject(MenuDeConsola.lista_usuariosAdmin.get(i));
			}
		}
		if (Futbolista.listaTotalJugadas.isEmpty() == false) {
			for (i = 0; i < Futbolista.listaTotalJugadas.size(); i++) {
				SaverObjetos.writeObject(Futbolista.listaTotalJugadas.get(i));
			}
		}
		SaverObjetos.close();
	}
	public void parar(){
		
	}
}
