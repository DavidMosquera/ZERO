package objetos.futbol.menuconsola;
import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*; 
public class MenuDeConsola {
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	public void lanzarMenu(){
		NXTConnector conn = new NXTConnector();
		byte numero, memoria=-1;
		Scanner scanner = new Scanner(System.in); // Para leer la opción seleccionada
		
		Lista_opc(Opciones);//Agrega las opciones a la lista
		
		System.out.println("Conectado: "+ conn.connectTo());
		NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm())); 
		while(true){
			String memoria ="0";
			System.out.println("Opciones: "+"\n"+"(0) Conectar "+"\n"+"(1) Adelante "+ 
					"\n"+"(2) Retroceder "+"\n"+"(3) Girar a la Izquierda "+"\n"+ 
					"(4) Girar a la Derecha "+"\n"+"(5) Patear "+"\n"+"(6) Frenar"+"\n"+
					"(7) Salir");
			String numero = scanner.next();//lo cambie para no confundirnos con opc o opcion
			/*se usa un String para que no nos salte error i ingresamos un String por eroor, solo un 
			aviso por consola*/
			
			detener_accion(memoria);
			opcion(numero);
			memoria=numero;
			
			
			
		}
		private void opcion(String opc_numero){
			if (opc_numero.compareTo("0")==0){ // Condicional para identificar la opción ingresada
				Num0.ejecutar(); // Por el usuario
			}
			else if (opc_numero.compareTo("1")==0){ //Ejecuta opcion # 1 (adelante)
				Num1.ejecutar();	
			}
			else if (opc_numero.compareTo("2")==0){ //Ejecuta opcion # 2 (retroceder)
				Num2.ejecutar();
			}
			else if (opc_numero.compareTo("3")==0){ //Ejecuta opcion # 3 (Girar Izquierda)
				Num3.ejecutar();
			}
			else if (opc_numero.compareTo("4")==0){ //Ejecuta opcion # 4 (Girar Derecha)
				Num4.ejecutar();
			}
			else if (opc_numero.compareTo("5")==0){ //Ejecuta opcion # 5 (Patear)
				Num5.ejecutar();
			}
			else if (opc_numero.compareTo("6")==0){ //Ejecuta opcion # 6 (Frenar)
				Num6.ejecutar();	
			}
			else if (opc_numero.compareTo("7")==0){ //Ejecuta opcion # 7 (Salir)
				break;
			}
			else{
				System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
			}
			memoria = numero;
		}
		private void detener_accion (String m){
			if (m.compareTo("1")==0)){          //Ejecuta el método parar de Adelantar
				Opciones[1].parar();
			}
			else if (m.compareTo("2")==0)){    //Ejecuta el método parar de Retroceder
				Opciones[2].parar();
			}
			else if (m.compareTo("3")==0)){   //Ejecutar el método parar de Girar Izquierda
				Opciones[3].parar();
			}
			else if (m.compareTo("4")==0)){   //Ejecutar el método parar de Girar Derecha
				Opciones[4].parar();
			}
			else if (m.compareTo("5")==0)){   //Ejetcua el método parar de Patear
				Opciones[5].parar();
			}
			else{ // No se realiza nada
				
			}
		}
		private void Lista_opc(ArrayList<OpcionDeMenu> lista){
			lista.add(new opcion_0());	//Conectar
			lista.add(new opcion_1());	//Adelantar
			lista.add(new opcion_2()); 	// Retroceder
			lista.add(new opcion_3()); 	// GiroIzquierda
			lista.add(new opcion_4()); 	// GiroDerecha
			lista.add(new opcion_5());      // Patear
			lista.add(new opcion_6());      // Frenar
			lista.add(new opcion_7());	// Salir
		}
		public void anadirOpcion(OpcionDeMenu r){
		Opciones.add(r);
	        }
	}
}
