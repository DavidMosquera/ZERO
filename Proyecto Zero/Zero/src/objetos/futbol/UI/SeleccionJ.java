package objetos.futbol.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.menuconsola.MenuDeConsola;
public class SeleccionJ extends JFrame {
	
	private JPanel p1;
	private JPanel p2;
	
	private Container G;
	
	private JLabel Tiposdj;
	private JLabel JuArq;
	private JLabel JuDel;
	
	static ButtonGroup Delanteros;
	static ButtonGroup Arqueros;
	private JButton Aceptar;
	private OyenteJugadorSeleccDel Delo= new OyenteJugadorSeleccDel();
	private OyenteJugadorSeleccArq Arque= new OyenteJugadorSeleccArq();
	
	
	public SeleccionJ(){
		super ("Seleccionar Jugadores");
		setFocusable(true);

		G= this.getContentPane();
		G.setLayout(new BorderLayout());
		Delanteros = new ButtonGroup();
		Arqueros = new ButtonGroup();
		
		
		
		Tiposdj = new JLabel("                                                                   Tipos de jugadores");
		JuArq = new JLabel("                  Jugador Arquero");
		JuDel = new JLabel("                  Jugador Delantero");
		
		
		
		
		JPanel paux1 = new JPanel (new FlowLayout());
		JPanel paux2 = new JPanel (new FlowLayout());
		
		p1 = new JPanel(new BorderLayout());
		
		Aceptar = new JButton("Aceptar");
		
		
		p2 = new JPanel(new BorderLayout());
		JPanel p78888 = new JPanel(new GridLayout(4,1));
		JLabel Relleno = new JLabel("                  ");
		JLabel Relleno2 = new JLabel(" ");
		p78888.add(Relleno);
		p78888.add(Tiposdj);
		p78888.add(Relleno2);
		G.add(p78888, BorderLayout.NORTH);
		
		JPanel p4 = new JPanel(new FlowLayout());
		Aceptar.addActionListener(new OyenteAceptar());
		p4.add(Aceptar);
		JPanel p3 = new JPanel(new GridLayout(1,2));
		JPanel p5 = new JPanel(new BorderLayout());
		p5.add(p3,BorderLayout.CENTER);
		p5.add(new JLabel("                  "),BorderLayout.WEST);
		p5.add(new JLabel("                  "),BorderLayout.EAST);
		
		this.SetLis();
	
		p1.add(JuArq,BorderLayout.NORTH);
		
		p2.add(JuDel,BorderLayout.NORTH);
		
		p3.add(p1);
		p3.add(p2);
		G.add(p5, BorderLayout.CENTER);
		G.add(p4, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(false);
		requestFocus();
		setLocationRelativeTo(null);
		setSize(500,275);
	}
	public void SetLis(){
		
		int arq = MenuDeConsola.lista_arqueros.size();
		int del = MenuDeConsola.lista_delanteros.size();
		
		JPanel p6 = new JPanel(new GridLayout(arq,1));
		JPanel p7 = new JPanel(new GridLayout(del,1));
		
		for (int i =0;i<arq;i++){
			JRadioButton objetico = new JRadioButton(MenuDeConsola.lista_arqueros.get(i).getNombre());
			objetico.addActionListener(Arque);
			p6.add(objetico);
			Arqueros.add(objetico);
		}
		for (int i =0;i<del;i++){
			JRadioButton objetico = new JRadioButton(MenuDeConsola.lista_delanteros.get(i).getNombre());
			objetico.addActionListener(Delo);
			p7.add(objetico);
			Delanteros.add(objetico);
		}
		p1.add(p6,BorderLayout.CENTER);
		p2.add(p7,BorderLayout.CENTER);
	}
}
class OyenteAceptar implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		InterfazUsuarioGeneral.arquero= OyenteJugadorSeleccArq.arq;
		InterfazUsuarioGeneral.delantero=OyenteJugadorSeleccDel.del;
		InterfazUsuarioGeneral.EdicionV.setVisible(false);
		
		if(InterfazUsuarioGeneral.cancha1.PosicionRobot_x<915)
			InterfazUsuarioGeneral.Seleccionado=OyenteJugadorSeleccArq.arq;	
		else
			InterfazUsuarioGeneral.Seleccionado=OyenteJugadorSeleccDel.del;
		
		InterfazUsuarioGeneral.Acciones();
		InterfazUsuarioGeneral.recuerdo.setText(("Conecte el Robot para iniciar el partido en Archivo/Conectar con NXT"));
		InterfazUsuarioGeneral.C.revalidate();
		InterfazUsuarioGeneral.C.repaint();
	}	
}
class OyenteJugadorSeleccArq implements ActionListener{
	static Arquero arq;
	String r;
	int i=0;
	
	public void actionPerformed(ActionEvent e) {
		r = e.getActionCommand();
		while (true){
			if(MenuDeConsola.lista_arqueros.get(i).getNombre().compareTo(r)==0){
				arq = MenuDeConsola.lista_arqueros.get(i);
				break;
			}
			i++;
		}
		i=0;
	}
}
class OyenteJugadorSeleccDel implements ActionListener{
	static Delantero del;
	String r;
	int i=0;
	public void actionPerformed(ActionEvent e) {
		r=e.getActionCommand();
		while (true){
			if(MenuDeConsola.lista_delanteros.get(i).getNombre().compareTo(r)==0){
				del = MenuDeConsola.lista_delanteros.get(i);
				break;
			}
			i++;
		}
		i=0;
	}
}



