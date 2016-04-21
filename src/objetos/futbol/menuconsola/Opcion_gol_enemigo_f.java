package objetos.futbol.menuconsola;

public class Opcion_gol_enemigo_f extends OpcionDeMenu{
	void ejecutar(){
		System.out.println("te metieron gol :| .... Manco"+"\n");
		UsuarioUsuario.goles_en_contra++;
		System.out.println("goles a favor "+UsuarioUsuario.goles_a_favor);
		System.out.println("goles en contra "+UsuarioUsuario.goles_en_contra);
	}
	void parar(){
		
	}
}
