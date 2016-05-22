package objetos.futbol.JugadasPrimitivas;
import java.io.Serializable;

import lejos.nxt.*;//mirar descripcion en Adelantar
import objetos.futbol.UI.InterfazUsuarioGeneral;
import objetos.futbol.menuconsola.UsuarioUsuario;

public class Retroceder extends jugadaPrimitiva implements Serializable{
	public Retroceder(int potencia, String nombre){
		this.potencia= potencia;
		this.nombre=nombre;
		
	}
	public void ejecutar(){
		first_T();
		InterfazUsuarioGeneral.cancha1.Memoria_taco=Motor.A.getTachoCount();
		
		Motor.A.backward();//izquierdo
		Motor.B.backward();//derecho
		//los dos motores hacia atrÃ¡s
	}
	public void parar(){ //DeltaNegativo ?
		InterfazUsuarioGeneral.cancha1.Delta_taco=((Motor.A.getTachoCount())/360)-((InterfazUsuarioGeneral.cancha1.Memoria_taco)/360);
		InterfazUsuarioGeneral.cancha1.PosicionRobot_x=InterfazUsuarioGeneral.cancha1.calcular_xR();
		InterfazUsuarioGeneral.cancha1.PosicionRobot_y=InterfazUsuarioGeneral.cancha1.calcular_yR();
		  //UsuarioUsuario.Cancha1.Localizacion_Robot();
		  Motor.A.stop();
		  Motor.B.stop();
		  //para los motores
		 }
	public String toString(){
		return this.nombre;
	}
}