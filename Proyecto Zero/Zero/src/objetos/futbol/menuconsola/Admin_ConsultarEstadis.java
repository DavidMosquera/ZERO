package objetos.futbol.menuconsola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

public class Admin_ConsultarEstadis extends OpcionDeMenu implements Serializable{
	void ejecutar() throws IOException{
		BufferedReader LectorTxt = new BufferedReader(new FileReader("Temporal.txt"));
		String Aux1;
		Aux1=LectorTxt.readLine();
		Aux1=LectorTxt.readLine();
		Aux1=LectorTxt.readLine();
		do{
			Aux1=LectorTxt.readLine();
			System.out.println(Aux1);
		}while(Aux1!=null);
		LectorTxt.close();
	}
	void parar(){
		
	}
}
