package objetos.futbol.menuconsola;
import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*; 
public class MenuDeConsola {
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	public void anadirOpcion(OpcionDeMenu r){
		Opciones.add(r);
	}
	public void lanzarMenu(){
		NXTConnector conn = new NXTConnector();
		byte numero, memoria=-1;
		Scanner Opc = new Scanner(System.in); // Para leer la opción seleccionada
		opcion_0 Num0 = new opcion_0();  // Conectar
		opcion_1 Num1 = new opcion_1();  // Adelante
		opcion_2 Num2 = new opcion_2();  // Retroceder
		opcion_3 Num3 = new opcion_3();  // GiroIzquierda
		opcion_4 Num4 = new opcion_4();  // GiroDerecha
		opcion_5 Num5 = new opcion_5();  // Patear
		opcion_6 Num6 = new opcion_6();  // Frenar
		Opciones.add(Num0);
		Opciones.add(Num1);
		Opciones.add(Num2); 
		Opciones.add(Num3); 
		Opciones.add(Num4); 
		Opciones.add(Num5); 
		Opciones.add(Num6);
		System.out.println("Conectado: "+ conn.connectTo());
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm())); 
		while(true){
			System.out.println("Opciones: "+"\n"+"(0) Conectar "+"\n"+"(1) Adelante "+ 
					"\n"+"(2) Retroceder "+"\n"+"(3) Girar a la Izquierda "+"\n"+ 
					"(4) Girar a la Derecha "+"\n"+"(5) Patear "+"\n"+"(6) Frenar"+"\n"+
					"(7) Salir");
			numero = Opc.nextByte();
			if (memoria ==1){ //Ejecuta el método parar de Adelantar
				Num1.parar();
			}
			else if (memoria ==2){ //Ejecuta el método parar de Retroceder
				Num2.parar();
			}
			else if (memoria ==3){ //Ejecuta el método parar de Girar Izquierda
				Num3.parar();
			}
			else if (memoria ==4){ //Ejecuta el método parar de Girar Derecha
				Num4.parar();
			}
			else if (memoria ==5){ //Ejecuta el método parar de Patear
				Num5.parar();	
			}
			else{ //No realiza nada
			}
			if (numero==0){ // Condicional para identificar la opción ingresada
				Num0.ejecutar(); // Por el usuario
			}
			else if (numero ==1){ //Ejecuta opcion # 1 (adelante)
				Num1.ejecutar();	
			}
			else if (numero ==2){ //Ejecuta opcion # 2 (retroceder)
				Num2.ejecutar();
			}
			else if (numero ==3){ //Ejecuta opcion # 3 (Girar Izquierda)
				Num3.ejecutar();
			}
			else if (numero ==4){ //Ejecuta opcion # 4 (Girar Derecha)
				Num4.ejecutar();
			}
			else if (numero ==5){ //Ejecuta opcion # 5 (Patear)
				Num5.ejecutar();
			}
			else if (numero ==6){ //Ejecuta opcion # 6 (Frenar)
				Num6.ejecutar();	
			}
			else if (numero ==7){ //Ejecuta opcion # 7 (Salir)
				break;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
			}
			memoria = numero;	
		}	
	}
}
