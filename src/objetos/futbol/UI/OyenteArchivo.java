package objetos.futbol.UI;
import javax.swing.*;

import lejos.nxt.Motor;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommandConnector;
import lejos.pc.comm.NXTConnector;

import java.awt.event.*;
import java.awt.*;
import objetos.futbol.UI.*;
public class OyenteArchivo implements ActionListener {
    
	
	public void actionPerformed(ActionEvent e) {
		String r = (String) e.getActionCommand();
		if(r.compareTo("Conectar con NXT ")==0){
			OyenteAcciones.conn = new NXTConnector();
			if (!OyenteAcciones.conn.connectTo("NXT_2", NXTComm.LCP)){ System.err.println(
			   "Conexion Fallida"); System.exit(1); }
			NXTCommandConnector.setNXTCommand(new NXTCommand(OyenteAcciones.conn.getNXTComm()));
			InterfazUsuarioGeneral.cancha1.IniciarRobot();
			InterfazUsuarioGeneral.recuerdo.setText(("Comenzo el partido"));
		}
		else if (r.compareTo("Terminar partido")==0){
			InterfazUsuarioGeneral.p2a.removeAll();
	
			
			InterfazUsuarioGeneral.cancha1.PosicionRobot_x=0;
			InterfazUsuarioGeneral.cancha1.PosicionRobot_y=0;
			String [] NombH = new String[InterfazUsuarioGeneral.Nomb.size()] ;
			for (int i =0;i<InterfazUsuarioGeneral.Nomb.size();i++){
				NombH[i]=InterfazUsuarioGeneral.Nomb.get(i);
			}
			InterfazUsuarioGeneral.HistorialL = new JList<String>(NombH);
			InterfazUsuarioGeneral.HistorialL.setSize(50,50);
			InterfazUsuarioGeneral.HistorialL.setMaximumSize(new Dimension(80,80));
			InterfazUsuarioGeneral.HistorialL.setPreferredSize(new Dimension (140,80));
			InterfazUsuarioGeneral.HistorialL.addListSelectionListener(new OyenteHistorial());
		    
		    JScrollPane Historial = new JScrollPane(InterfazUsuarioGeneral.HistorialL);
		    Historial.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    Historial.setMaximumSize(new Dimension(80,80));
		    Historial.setPreferredSize(new Dimension (140,80));
		    
		    InterfazUsuarioGeneral.p2a.add(InterfazUsuarioGeneral.Historia, BorderLayout.NORTH);
		    InterfazUsuarioGeneral.p2a.add(Historial,BorderLayout.CENTER);
		    InterfazUsuarioGeneral.p2a.revalidate();
		    InterfazUsuarioGeneral.p2a.repaint();
		}
	}

}
