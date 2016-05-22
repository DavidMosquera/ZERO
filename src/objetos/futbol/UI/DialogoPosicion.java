package objetos.futbol.UI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lejos.nxt.Motor;

import java.awt.*;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Futbolista;

public class DialogoPosicion extends JDialog implements ActionListener{
	
	String tipo_acc;
	Container general;
	DialogoPosicion(JFrame padre, String tittle, String mensaje, String tipo_accion){
		super(padre,tittle, true); 
		
		tipo_acc= tipo_accion;
		
		general = getContentPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.add(new JLabel(mensaje+", presione Aceptar                   "));
		JPanel Superior = new JPanel (new FlowLayout(10));
		
		JButton aceptar = new JButton("Aceptar");
		java.net.URL iconoPop = getClass().getClassLoader().getResource("imagenes/FueraDeCancha.jpg");
		aceptar.addActionListener(this);
		JPanel p4 = new JPanel(new FlowLayout());
		JLabel relleno = new JLabel ("           ");
		
		JLabel imgaen = new JLabel (new ImageIcon(iconoPop));
		Superior.add(imgaen);
		p4.add(panel_1);
		p4.add(aceptar);
		Superior.add(p4);
		general.add(Superior, BorderLayout.SOUTH);
		
		
		setSize(450,200);
		setVisible(true);
		//this.setUndecorated(true);
		this.setResizable(false);
		padre.setResizable(false);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String r = e.getActionCommand();
		if(tipo_acc.compareTo("lugar")==0&& r.compareTo("Aceptar")==0){
			//compara que tipo de jugador tiene y lo cambia por el otro
			if(InterfazUsuarioGeneral.Seleccionado instanceof Arquero){
				InterfazUsuarioGeneral.Seleccionado = InterfazUsuarioGeneral.delantero;
				InterfazUsuarioGeneral.Acciones();
			}
			else{
				InterfazUsuarioGeneral.Seleccionado = InterfazUsuarioGeneral.arquero;
				InterfazUsuarioGeneral.Acciones();
			}
		}
		else if(tipo_acc.compareTo("fuera_cancha")==0&& r.compareTo("Aceptar")==0){
			//inicializa el robot y cambia a arquero
			InterfazUsuarioGeneral.Seleccionado = InterfazUsuarioGeneral.arquero;
			Motor.A.resetTachoCount();
			Motor.B.resetTachoCount();
			InterfazUsuarioGeneral.cancha1.IniciarRobot();
		}
		setVisible(false);
	}

}
