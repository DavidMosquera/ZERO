package objetos.futbol.menuconsola;

import java.util.Scanner;

public class Opcion_Inicializar_robot_i extends OpcionDeMenu{
	Scanner scanner = new Scanner(System.in);
	public void ejecutar(){
		UsuarioUsuario.Cancha1.IniciarRobot();
		System.out.println("presione cualquier letra para continuar");
		scanner.next();
	}
	public void parar(){
		
	}
}
