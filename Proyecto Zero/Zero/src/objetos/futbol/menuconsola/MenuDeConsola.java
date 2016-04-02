package objetos.futbol.menuconsola;
import java.util.ArrayList;
import java.util.Scanner;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
public class MenuDeConsola {

	//atributos:
	private ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	private ArrayList<Arquero> lista_arqueros = new ArrayList<Arquero>();
	private ArrayList<Delantero> lista_delanteros = new ArrayList<Delantero>();
	private String accion;
	private byte memoria=-1;
   
	private boolean rol;
	private Scanner scanner = new Scanner(System.in); // Para leer la opción seleccionada
	private Delantero delantero;
	private Arquero arquero;
	
	public MenuDeConsola() throws FileNotFoundException {
		
	} 
	File Jugadas = new File ("Jugadas.txt");
	FileOutputStream Archivo = new FileOutputStream(Jugadas);
	PrintStream doc = new PrintStream(Archivo);
	
	
	public void lanzarMenu(){
		//primero se le pregunta al usuario si es jugador o admin 
		rol= admin_o_usuario();//false si es admin, true si es usuario
		if(rol==true){
			//se cambia la ubicación para que solo el usuario se conecte al robot 
			NXTConnector conn = new NXTConnector();
			System.out.println("Conectado: "+ conn.connectTo());
			NXTCommandConnector.setNXTCommand(new NXTCommand(conn.getNXTComm())); 
			
			//elegir los jugadores
			elegir_arquero();
			elegir_delantero();
			while(true){
				String memoria ="0";
				imprimir_opciones_jugador();//imprime el menú con las opciones de el jugador
				String acccion = scanner.next();//lo cambie para no confundirnos con opc o opcion
				/*se usa un String para que no nos salte error i ingresamos un String por eroor, solo un 
				aviso por consola*/
				
				detener_accion(memoria);
				opcion(accion);
				memoria=acccion;
			}
		}
		else{
			while(true){
				//aquí van las opciones del administrador
			}
		}
	}
	//no se si la opcion 7 es suficiente para salir
	private void opcion(String opc_numero){
		if (opc_numero.compareTo("0")==0){ // Condicional para identificar la opción ingresada
			Opciones.get(0).ejecutar(); // Por el usuario
		}
		else if (opc_numero.compareTo("w")==0){ //Ejecuta opcion w (adelante)
			Opciones.get(1).ejecutar(); 	
		}
		else if (opc_numero.compareTo("s")==0){ //Ejecuta opcion s (retroceder)
			Opciones.get(2).ejecutar(); 
		}
		else if (opc_numero.compareTo("a")==0){ //Ejecuta opcion d (Girar Izquierda)
			Opciones.get(3).ejecutar(); 
		}
		else if (opc_numero.compareTo("d")==0){ //Ejecuta opcion a (Girar Derecha)
			Opciones.get(4).ejecutar(); 
		}
		else if (opc_numero.compareTo("q")==0){ //Ejecuta opcion q (Patear)
			Opciones.get(5).ejecutar(); 
		}
		else if (opc_numero.compareTo("e")==0){ //Ejecuta opcion e (Frenar)
			Opciones.get(6).ejecutar(); 	
		}
		else if (opc_numero.compareTo("t")==0){ //Ejecuta opcion t (Salir)
		}
		else{
			System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
		}
	}
	private void detener_accion (String m){
		if (m.compareTo("w")==0){          //Ejecuta el método parar de Adelantar
			Opciones.get(1).parar();
		}
		else if (m.compareTo("s")==0){    //Ejecuta el método parar de Retroceder
			Opciones.get(2).parar();
		}
		else if (m.compareTo("a")==0){   //Ejecutar el método parar de Girar Izquierda
			Opciones.get(3).parar();
		}
		else if (m.compareTo("d")==0){   //Ejecutar el método parar de Girar Derecha
			Opciones.get(4).parar();
		}
		else if (m.compareTo("q")==0){   //Ejetcua el método parar de Patear
			Opciones.get(5).parar();
		}
		else{ // No se realiza nada
			
		}
	}
	private void Lista_opc(ArrayList<OpcionDeMenu> lista){
		                                            //Conectar
		lista.add(new Opcion_adelante_w());		    //Adelantar
		lista.add(new Opcion_atras_s()); 		    // Retroceder
		lista.add(new Opcion_girar_izquierda_a()); 	// GiroIzquierda
		lista.add(new Opcion_girar_derecha_d()); 	// GiroDerecha
		lista.add(new Opcion_patear_q());      		// Patear
		lista.add(new Opcion_parar_e());      		// Frenar	
	}
	public void anadirOpcion(OpcionDeMenu r){
		Opciones.add(r);
	}
	//imprime las opciones del jugador 
	private void imprimir_opciones_jugador(){
		System.out.println("Opciones: "+"\n"+"(0) Conectar "+"\n"+"(1) Adelante "+ 
			"\n"+"(2) Retroceder "+"\n"+"(3) Girar a la Izquierda "+"\n"+ 
			"(4) Girar a la Derecha "+"\n"+"(5) Patear "+"\n"+"(6) Frenar"+"\n"+
			"(7) Salir");
	}
	//este metodo imprime el menú de bienvenida y pregunta el rol
	private boolean admin_o_usuario(){
	       	while(true){
	       		System.out.println("Bienvenido, porfavor ejila su rol:"+"/n"+"(1) Usuario"+"(2) Administrador");
	       		String numero= scanner.next();
	        	if(numero.compareTo("1")==0){
	        		return true;
	    		}
	        	else if(numero.compareTo("2")==0){
	        		return false;
	        			}
        		else{
        			System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
        		}
        	}
        }
        //muestra las opciones de delantero y ejile el que el jugador indicó
        private void elegir_delantero(){
        	int contador=0;
        	boolean comparar_accion=true;
        	System.out.println("Elije tu delantero:");
        	while(comparar_accion){
        		for(int i =0;i<lista_delanteros.size();i++){
        			System.out.println("("+(i+1)+")"+" "+lista_delanteros.get(i).getNombre());
        		}
        		String accion = scanner.next();
        		for(int i=0;i<lista_delanteros.size();i++){
        			contador=i+1;
        			if(accion.compareTo(String.valueOf(contador))==0){
        				this.delantero=lista_delanteros.get(i);
        				comparar_accion=false;
        			}
        		}
        		if(comparar_accion==true){
        			System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
        		}
        
        	}
        	
        }
        //muestra las opciones de arqueros y asigna el que ususario a indicado
        private void elegir_arquero(){
        	int contador=0;
        	boolean comparar_accion=true;
        	System.out.println("Elije tu arquero:");
        	while(comparar_accion){
        		for(int i =0;i<lista_arqueros.size();i++){
        			System.out.println("("+(i+1)+")"+" "+lista_arqueros.get(i).getNombre());
        		}
        		String accion = scanner.next();
        		for(int i=0;i<lista_arqueros.size();i++){
        			contador=i+1;
        			if(accion.compareTo(String.valueOf(contador))==0){
        				this.arquero= lista_arqueros.get(i);
        				comparar_accion=false;
        			}
        		}
        		if(comparar_accion==true){
        			System.out.println("ERROR NUMERO INGRESADO NO VÁLIDO");
        		}
        
        	}
        	
        }
}

