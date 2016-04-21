package objetos.futbol.menuconsola;

public class Opcion_gol_aliado_g extends OpcionDeMenu{
	void ejecutar(){
		System.out.println("MITISTE GOL APA!!!!"+"\n");
		UsuarioUsuario.goles_a_favor++;
		System.out.println("goles a favor "+UsuarioUsuario.goles_a_favor);
		System.out.println("goles en contra "+UsuarioUsuario.goles_en_contra);
	}
	void parar(){
		
	}
}
