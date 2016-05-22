package objetos.futbol.UI;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import objetos.futbol.UI.*;
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTCommandConnector;
import lejos.pc.comm.NXTConnector;
import objetos.futbol.cancha.*;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
public class OyenteAcciones  implements ActionListener  { // Clase oyente de las acciones, ejecutamos, paramos, calculamos posición.
	String r, rec="";
    public static NXTConnector conn;

	
	public void actionPerformed(ActionEvent act) {
		
		if(conn!=null){
		r = (String)act.getActionCommand();
		
		if (rec.compareTo("Adelantar")==0){
			InterfazUsuarioGeneral.Opciones.get(0).parar();
			InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
			InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		}
		else if (rec.compareTo("Retroceder")==0){
			InterfazUsuarioGeneral.Opciones.get(1).parar();
			InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
			InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		}
		else if (rec.compareTo("Girar Izq.")==0){
			InterfazUsuarioGeneral.Opciones.get(2).parar();
			InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
			InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		}
		else if (rec.compareTo("Girar Der.")==0){
			InterfazUsuarioGeneral.Opciones.get(3).parar();
			InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
			InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		}
		else if (rec.compareTo("Patear")==0){
			InterfazUsuarioGeneral.Opciones.get(4).parar();
			InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
			InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		}
		else {
			
		}
		
		try{
			if (InterfazUsuarioGeneral.cancha1.PosicionRobot_x<0||InterfazUsuarioGeneral.cancha1.PosicionRobot_x>1830||InterfazUsuarioGeneral.cancha1.PosicionRobot_y>1240||InterfazUsuarioGeneral.cancha1.PosicionRobot_y<0){
				throw new FueraDeCanchaException();
			}
		    else if(InterfazUsuarioGeneral.cancha1.PosicionRobot_x>915&&(InterfazUsuarioGeneral.Seleccionado instanceof Arquero)==true){
		    	
		    	throw new CambioDeJugadorException();
		    }
		    else if ((InterfazUsuarioGeneral.cancha1.PosicionRobot_x<915)&&((InterfazUsuarioGeneral.Seleccionado instanceof Delantero)==true)){
		    	throw new CambioDeJugadorException();
		    }
		}catch(FueraDeCanchaException e){
			DialogoPosicion dlg = new DialogoPosicion(new JFrame(), "Fuera de la cancha", "Reinicie la posicion","fuera_cancha");
		}catch(CambioDeJugadorException e){
			DialogoPosicion dlg = new DialogoPosicion(new JFrame(), "Fuera de lugar", "Cambiar el jugador","lugar");
		}
		
		if (r.compareTo("Adelantar")==0){
			try {
				InterfazUsuarioGeneral.Opciones.get(0).ejecutar();
				InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
				InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
				InterfazUsuarioGeneral.Nomb.add("Adelantar");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (r.compareTo("Retroceder")==0){
			try {
				InterfazUsuarioGeneral.Opciones.get(1).ejecutar();
				InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
				InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
				InterfazUsuarioGeneral.Nomb.add("Retroceder");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (r.compareTo("Girar Izq.")==0){
			try {
				InterfazUsuarioGeneral.Opciones.get(2).ejecutar();
				InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
				InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
				InterfazUsuarioGeneral.Nomb.add("Girar Izq.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (r.compareTo("Girar Der.")==0){
			try {
				InterfazUsuarioGeneral.Opciones.get(3).ejecutar();
				InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
				InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
				InterfazUsuarioGeneral.Nomb.add("Girar Der.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (r.compareTo("Patear")==0){
			try {
				InterfazUsuarioGeneral.Opciones.get(4).ejecutar();
				InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
				InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
				InterfazUsuarioGeneral.Nomb.add("Patear");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Pene");
			for(int i =0;i<InterfazUsuarioGeneral.Seleccionado.listaJugadas.size();i++){
				if(r.compareTo(InterfazUsuarioGeneral.Seleccionado.listaJugadas.get(i).getNombre())==0){
					System.out.println(InterfazUsuarioGeneral.Seleccionado.listaJugadas.size());
					(InterfazUsuarioGeneral.Seleccionado.listaJugadas.get(i)).ejecutar();
					System.out.println(InterfazUsuarioGeneral.Seleccionado.listaJugadas.get(i).listaJugadasP.size());
					System.out.println(InterfazUsuarioGeneral.Seleccionado.listaJugadas.get(i));
					InterfazUsuarioGeneral.Xlist.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
					InterfazUsuarioGeneral.YList.add(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
					InterfazUsuarioGeneral.Nomb.add(InterfazUsuarioGeneral.Seleccionado.listaJugadas.get(i).getNombre());
					break;
				}
			}
		}
		double AnguloGrafico = (int)InterfazUsuarioGeneral.cancha1.Angulo_actual;
		if(AnguloGrafico>0){
			AnguloGrafico= (AnguloGrafico%360);
		}
		else{
			AnguloGrafico= -(AnguloGrafico%360);
		}
		InterfazUsuarioGeneral.pcan.setX1(InterfazUsuarioGeneral.cancha1.PosicionRobot_x);
		InterfazUsuarioGeneral.pcan.setY1(InterfazUsuarioGeneral.cancha1.PosicionRobot_y);
		InterfazUsuarioGeneral.xm.setText("X: "+Math.round(InterfazUsuarioGeneral.cancha1.PosicionRobot_x));
		InterfazUsuarioGeneral.ym.setText("Y: "+Math.round(InterfazUsuarioGeneral.cancha1.PosicionRobot_y));
		InterfazUsuarioGeneral.Ang.setText("\u0398"+" : "+Math.round(AnguloGrafico));
		InterfazUsuarioGeneral.C.revalidate();
		InterfazUsuarioGeneral.C.repaint();
		rec = r;
		InterfazUsuarioGeneral.pcan.repaint();
		}
		
	}
	
}
