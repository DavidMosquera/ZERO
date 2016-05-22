package objetos.futbol.UI;

import javax.swing.*;

import objetos.futbol.JugadasPrimitivas.Adelantar;
import objetos.futbol.JugadasPrimitivas.GirarDerecha;
import objetos.futbol.JugadasPrimitivas.GirarIzquierda;
import objetos.futbol.JugadasPrimitivas.Patear;
import objetos.futbol.JugadasPrimitivas.Retroceder;
import objetos.futbol.JugadasPrimitivas.jugadaPrimitiva;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.menuconsola.MenuDeConsola;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class IntAdmin extends JFrame {
	static AgJc r1;
	static AgJdr r2;
	static ConJdr r3;
	static ConJugadas_Jdr r4;
	static QuitarJug r5; 
	static Container A;
	static JComboBox opc;
	private JPanel p1;

	static JPanel p2r = new JPanel(new BorderLayout());
	private JLabel Relleno;
	private JLabel Selecc;

	public IntAdmin() {
		super("Admin_Z.E.R.O");
		A = this.getContentPane();
		A.setLayout(new BorderLayout(15, 15));
		p1 = new JPanel(new FlowLayout());
		p1.add(Relleno = new JLabel("                "));
		p1.add(Selecc = new JLabel("Seleccione una opción: "));
		p1.add(opc = new JComboBox());
		opc.addItem("...");
		opc.addItem("Crear Jugada Compleja");
		opc.addItem("Crear Jugador");
		opc.addItem("Consultar Lista Jugadores");
		opc.addItem("Consultar Jugadas de un jugador");

		opc.addItem("Quitar/Añadir jugada compleja de un jugador");
		opc.addItemListener(new OyenteOpc());
		A.add(p1, BorderLayout.NORTH);
		A.add(p2r, BorderLayout.CENTER);
		setSize(800, 600);
		setVisible(false);
		setLocationRelativeTo(null);
		setFocusable(true);
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  try {
					
					InterfazUsuarioGeneral.Omeguita.Guardar();
					InterfazUsuarioGeneral.Omeguita.lanzarMenu();
					InterfazUsuarioGeneral.EdicionV=new SeleccionJ();
					InterfazUsuarioGeneral.EdicionV.revalidate();
					InterfazUsuarioGeneral.EdicionV.repaint();
				} catch (IOException e1) {
				}
			  }
			});
		requestFocus();
	}
}

class Requerimiento extends JPanel {
	JPanel Rqu = new JPanel(new GridLayout(1, 1));
}

class AgJc extends Requerimiento {
	static JPanel Cont = new JPanel(new GridLayout(1, 1));
	JTextField nombre;
	JTextField fecha;
	JTextField autor;
	JComboBox tipo;
	JPanel p1 = new JPanel(new FlowLayout());
	static JComboBox Primitivas;
	JTextField explicacion;
	JLabel nombrel = new JLabel("Nombre de la jugada: ");
	JLabel primitivasl = new JLabel("Seleccione jugadas primitivas: ");
	JLabel fechal = new JLabel("Fecha de creación: ");
	JLabel autorl = new JLabel("Autor de la jugada: ");
	JLabel tipol = new JLabel("Seleccione el tipo de jugada: ");
	JLabel expliacionl = new JLabel("Explicación: de la jugada compleja: ");
	JLabel Relleno = new JLabel("            ");
	Button Crear = new Button("Crear Jugada");
	Container T;

	public AgJc() {

		p1.setLayout(new GridLayout(15, 2));
		p1.add(nombrel);
		p1.add(nombre = new JTextField(15));
		p1.add(fechal);
		p1.add(fecha = new JTextField(15));
		p1.add(autorl);
		p1.add(autor = new JTextField(15));
		p1.add(primitivasl);
		p1.add(Primitivas = new JComboBox());
		Primitivas.addItem(new Adelantar(1080, "Adelantar"));
		Primitivas.addItem(new Retroceder(1080, "Retroceder"));
		Primitivas.addItem(new GirarDerecha(1080, "Girar Derecha"));
		Primitivas.addItem(new GirarIzquierda(1080, "Girar Izquierda"));
		Primitivas.addItem(new Patear(1080, "Patear"));
		p1.add(tipol);
		p1.add(tipo = new JComboBox());
		tipo.addItem("...");
		tipo.addItem("Defensiva");
		tipo.addItem("Ofensiva");
		tipo.addItem("Tiro Libre");
		p1.add(expliacionl);
		p1.add(explicacion = new JTextField(15));
		p1.add(Relleno);
		Crear.addActionListener(new OyenteCrearJugadaCb());
		Primitivas.addItemListener(new OyenteJugadaCB());
		JPanel aux = new JPanel(new FlowLayout());
		aux.add(Crear);
		p1.add(aux);
		Rqu.add(p1);

	}

	public void CrearN() {
		String nombre = this.nombre.getText();
		String fecha = this.fecha.getText();
		String auto = this.autor.getText();
		String expl = this.explicacion.getText();
		ArrayList<jugadaPrimitiva> Primi = new ArrayList<>();
		for(int i = 0;i<OyenteJugadaCB.Primitivas.size();i++){
			Primi.add(OyenteJugadaCB.Primitivas.get(i));
		}
		if (((String) tipo.getSelectedItem()).compareTo("Defensiva") == 0) {
			JugadaComplejaDefensiva a = new JugadaComplejaDefensiva(nombre, fecha, auto,Primi,
					expl);
			Futbolista.listaTotalJugadas.add(a);
			OyenteJugadaCB.Primitivas.clear(); 
			System.out.println("HOli" + a.listaJugadasP.size());
		} else if (((String) tipo.getSelectedItem()).compareTo("Ofensiva") == 0) {
			JugadaComplejaOfensiva a = new JugadaComplejaOfensiva(nombre, fecha, auto, Primi, expl);
			Futbolista.listaTotalJugadas.add(a);
			OyenteJugadaCB.Primitivas.clear();
		} else if (((String) tipo.getSelectedItem()).compareTo("Tiro Libre") == 0) {
			JugadaComplejaTiroLibre a = new JugadaComplejaTiroLibre(nombre, fecha, auto, Primi,
					expl);
			Futbolista.listaTotalJugadas.add(a);
			OyenteJugadaCB.Primitivas.clear();
		} else {

		}
		this.nombre.setText("");
		this.fecha.setText("");
		this.autor.setText("");
		this.explicacion.setText("");
	}
}

class OyenteOpc implements ItemListener {

	public void itemStateChanged(ItemEvent e) {
		String r = (String) e.getItem();
		if (r.compareTo("Crear Jugada Compleja") == 0) {
			IntAdmin.r1 = new AgJc();
			IntAdmin.p2r.removeAll();
			IntAdmin.p2r.add(IntAdmin.r1.Rqu);
			IntAdmin.A.revalidate();
			IntAdmin.A.repaint();
		} else if ((r.compareTo("Crear Jugador") == 0)) {
			IntAdmin.r2 = new AgJdr();
			IntAdmin.p2r.removeAll();
			IntAdmin.p2r.add(IntAdmin.r2.Rqu);
			IntAdmin.A.revalidate();
			IntAdmin.A.repaint();
		} else if ((r.compareTo("Consultar Lista Jugadores") == 0)) {
			IntAdmin.r3 = new ConJdr();
			IntAdmin.p2r.removeAll();
			IntAdmin.p2r.add(IntAdmin.r3.Rqu);
			IntAdmin.A.revalidate();
			IntAdmin.A.repaint();
		} else if ((r.compareTo("Consultar Jugadas de un jugador") == 0)) {
			IntAdmin.r4 = new ConJugadas_Jdr();
			IntAdmin.p2r.removeAll();
			IntAdmin.p2r.add(IntAdmin.r4.Rqu);
			IntAdmin.A.revalidate();
			IntAdmin.A.repaint();
		} else if ((r.compareTo("Quitar/Añadir jugada compleja de un jugador")==0)){
			IntAdmin.r5 = new QuitarJug();
			IntAdmin.p2r.removeAll();
			IntAdmin.p2r.add(IntAdmin.r5.Rqu);
			IntAdmin.A.revalidate();
			IntAdmin.A.repaint();
		}
	}

}

class OyenteJugadaCB implements ItemListener {

	static ArrayList<jugadaPrimitiva> Primitivas = new ArrayList<jugadaPrimitiva>();

	public void itemStateChanged(ItemEvent e) {
		Primitivas.add((jugadaPrimitiva) AgJc.Primitivas.getSelectedItem());
		System.out.println(((jugadaPrimitiva) AgJc.Primitivas.getSelectedItem()).getInformacion());
		System.out.println(Primitivas.size());
	}
}

class OyenteCrearJugadaCb implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		IntAdmin.r1.CrearN();
		IntAdmin.r1.revalidate();
		IntAdmin.r1.repaint();
	}
}

class AgJdr extends Requerimiento {
	static JPanel Cont = new JPanel(new GridLayout(1, 1));
	JTextField nombre;
	JTextField dorsal;
	JComboBox posicion;
	JPanel p1 = new JPanel(new FlowLayout());
	static JComboBox Jcomp1;
	static JComboBox Jcomp2;
	static JComboBox Jcomp3;
	static ArrayList<JugadaCompleja> Complejas;
	JTextField explicacion;
	JLabel nombrel = new JLabel("Nombre del jugador: ");
	JLabel comp1 = new JLabel("Seleccione la jugada 1: ");
	JLabel comp2 = new JLabel("Seleccione la jugada 2: ");
	JLabel comp3 = new JLabel("Seleccione la jugada 3: ");
	JLabel dorso = new JLabel("Dorso del jugador: ");
	JLabel posicion1 = new JLabel("Elija la posición: ");
	JLabel Relleno = new JLabel("            ");
	Button Crear = new Button("Crear Jugador");
	Container T;

	public AgJdr() {

		p1.setLayout(new GridLayout(15, 2));
		p1.add(nombrel);
		p1.add(nombre = new JTextField(15));
		p1.add(dorso);
		p1.add(dorsal = new JTextField(15));
		p1.add(posicion1);
		p1.add(posicion = new JComboBox());
		posicion.addItem("...");
		posicion.addItem("Arquero");
		posicion.addItem("Delantero");
		p1.add(comp1);
		p1.add(Jcomp1 = new JComboBox());
		p1.add(comp2);
		p1.add(Jcomp2 = new JComboBox());
		p1.add(comp3);
		p1.add(Jcomp3 = new JComboBox());

		for (int i = 0; i < Futbolista.listaTotalJugadas.size(); i++) {
			Jcomp1.addItem(Futbolista.listaTotalJugadas.get(i));
			Jcomp2.addItem(Futbolista.listaTotalJugadas.get(i));
			Jcomp3.addItem(Futbolista.listaTotalJugadas.get(i));
		}
		p1.add(Relleno);
		JPanel aux = new JPanel(new FlowLayout());
		aux.add(Crear);
		p1.add(aux);
		Crear.addActionListener(new OyenteCrearJugador());
		Rqu.add(p1);

	}

	public void CrearJugador() {
		String nombre = this.nombre.getText();
		String Dorso = this.dorsal.getText();
		String Posicion;
		ArrayList<JugadaCompleja> Complejas = new ArrayList<>();

		if (((JugadaCompleja) Jcomp1.getSelectedItem()).toString().compareTo("...") != 0) {
			Complejas.add((JugadaCompleja) Jcomp1.getSelectedItem());

		}
		if (((JugadaCompleja) Jcomp2.getSelectedItem()).toString().compareTo("...") != 0) {
			Complejas.add((JugadaCompleja) Jcomp2.getSelectedItem());
		}
		if (((JugadaCompleja) Jcomp3.getSelectedItem()).toString().compareTo("...") != 0) {
			Complejas.add((JugadaCompleja) Jcomp3.getSelectedItem());
		}

		if (((String) posicion.getSelectedItem()).compareTo("Arquero") == 0) {
			ArrayList<JugadaCompleja> Comp = new ArrayList<>();
			for (int i = 0; i < Complejas.size(); i++) {
				Comp.add(Complejas.get(i));
			}
			Arquero a = new Arquero(nombre, "Arquero", Comp, Dorso);

			MenuDeConsola.lista_arqueros.add(a);
			Complejas.clear();

		} else if (((String) posicion.getSelectedItem()).compareTo("Delantero") == 0) {
			ArrayList<JugadaCompleja> Comp = new ArrayList<>();
			for (int i = 0; i < Complejas.size(); i++) {

				Comp.add(Complejas.get(i));
			}

			Delantero a = new Delantero(nombre, "Delantero", Comp, Dorso);
			MenuDeConsola.lista_delanteros.add(a);
			Complejas.clear();
		} else {

		}
		dorsal.setText("");
		this.nombre.setText("");

	}
}

class OyenteCrearJugador implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		IntAdmin.r2.CrearJugador();
		IntAdmin.r2.revalidate();
		IntAdmin.r2.repaint();

	}
}

class ConJdr extends Requerimiento {
	static JPanel Cont = new JPanel(new GridLayout(1, 1));

	JPanel p1 = new JPanel(new FlowLayout());
	JList L1;
	Container T;
	String[] Lis = new String[MenuDeConsola.lista_arqueros.size() + MenuDeConsola.lista_delanteros.size()];

	public ConJdr() {
		for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
			Lis[i] = MenuDeConsola.lista_arqueros.get(i).toString();
		}
		for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
			Lis[i + MenuDeConsola.lista_arqueros.size()] = MenuDeConsola.lista_delanteros.get(i).toString();
		}
		L1 = new JList(Lis);
		p1.add(L1);
		Rqu.add(p1);
	}
}

class ConJugadas_Jdr extends Requerimiento {
	static JPanel Cont = new JPanel(new GridLayout(1, 1));

	JPanel p1 = new JPanel(new GridLayout(3, 2));
	JComboBox jugada;
	Container T;
	JLabel jugadores = new JLabel("Lista de jugadores");
	JLabel jugadas_complejas = new JLabel("Jugadas Complejas");
	Button Consultar = new Button("Consultar");
	JTextArea area = new JTextArea(60, 3);

	public ConJugadas_Jdr() {
		jugada = new JComboBox();
		jugada.addItem("...");
		for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
			jugada.addItem((Futbolista) MenuDeConsola.lista_arqueros.get(i));
		}
		for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
			jugada.addItem((Futbolista) MenuDeConsola.lista_delanteros.get(i));
		}
		JPanel paux = new JPanel(new FlowLayout());
		JPanel aux1 = new JPanel(new FlowLayout());
		JPanel aux2 = new JPanel(new FlowLayout());
		JScrollPane scroll = new JScrollPane(area);
		scroll.setPreferredSize(new Dimension(500, 100));
		area.setLineWrap(true);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aux1.add(jugadores);
		aux1.add(jugada);
		aux2.add(jugadas_complejas);
		aux2.add(scroll);

		JLabel Relleno = new JLabel("");

		paux.add(Relleno);
		paux.add(Consultar);

		Consultar.addActionListener(new OyenteConsultarJugada());
		p1.add(aux1);
		p1.add(aux2);
		p1.add(paux);
		Rqu.add(p1);
	}

	void imprimirjugadas() {
		if (jugada.getSelectedItem().toString().compareTo("...") != 0) {
			Futbolista asd = (Futbolista) jugada.getSelectedItem();
			area.setText(" ");
			for (int i = 0; i < ((Futbolista) jugada.getSelectedItem()).listaJugadas.size(); i++) {
				String a = (((Futbolista) jugada.getSelectedItem()).listaJugadas.get(i).getNombre());
				String b = (((Futbolista) jugada.getSelectedItem()).listaJugadas.get(i).getInformacion());
				area.setText(area.getText() + " " + a);
				area.setText(area.getText() + " " + b);
			}
		}

	}
}

class OyenteConsultarJugada implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		IntAdmin.r4.imprimirjugadas();

	}
}
class QuitarJug extends Requerimiento{
	JLabel quitar ;
	static JComboBox ListaJ;
	static JComboBox Jcomp1;
	static JComboBox Jcomp2;
	static JComboBox Jcomp3;
	
	public QuitarJug(){
		JPanel p1 = new JPanel (new GridLayout(5,1));
		JLabel Jdr = new JLabel("Elija jugador: ");
		JLabel J1 = new JLabel("Jugada 1: ");
		JLabel J2 = new JLabel("Jugada 2: ");
		JLabel J3 = new JLabel("Jugada 3: ");
		JugadaComplejaDefensiva Null = new JugadaComplejaDefensiva("...");
	    ListaJ = new JComboBox();
		ListaJ.addItem("...");
		Button Cmbiar = new Button ("Añadir/Quitar");
		for (int i = 0; i < MenuDeConsola.lista_arqueros.size(); i++) {
			ListaJ.addItem((Futbolista) MenuDeConsola.lista_arqueros.get(i));
		}
		for (int i = 0; i < MenuDeConsola.lista_delanteros.size(); i++) {
			ListaJ.addItem((Futbolista) MenuDeConsola.lista_delanteros.get(i));
		}
		Jcomp1 = new JComboBox();
		Jcomp2 = new JComboBox();
		Jcomp3 = new JComboBox();
		Jcomp2.addItem(Null);
		Jcomp3.addItem(Null);
		for (int i = 0; i < Futbolista.listaTotalJugadas.size(); i++) {
			Jcomp1.addItem(Futbolista.listaTotalJugadas.get(i));
			Jcomp2.addItem(Futbolista.listaTotalJugadas.get(i));
			Jcomp3.addItem(Futbolista.listaTotalJugadas.get(i));
		}
		JPanel aux1 = new JPanel(new FlowLayout());
		JPanel aux2 = new JPanel(new FlowLayout());
		JPanel aux3 = new JPanel(new FlowLayout());
		JPanel aux4 = new JPanel(new FlowLayout());
		JPanel aux5 = new JPanel(new FlowLayout());
		aux1.add(Jdr);
		aux1.add(ListaJ);
		aux2.add(J1);
		aux2.add(Jcomp1);
		aux3.add(J2);
		aux3.add(Jcomp2);
		aux4.add(J3);
		aux4.add(Jcomp3);
		aux5.add(Cmbiar);
		p1.add(aux1);
		p1.add(aux2);
		p1.add(aux3);
		p1.add(aux4);
		p1.add(aux5);
		Cmbiar.addActionListener(new OyenteCambiar());
		Rqu.add(p1);
	}
	public void Cambiar (){
		((Futbolista)ListaJ.getSelectedItem()).listaJugadas.clear();
		JugadaCompleja c1 =(JugadaCompleja)Jcomp1.getSelectedItem();
		JugadaCompleja c2 =(JugadaCompleja)Jcomp2.getSelectedItem();
		JugadaCompleja c3 =(JugadaCompleja)Jcomp3.getSelectedItem();
		((Futbolista)ListaJ.getSelectedItem()).listaJugadas.add(c1);
		if (c2.getNombre().compareTo("...")!=0){
			((Futbolista)ListaJ.getSelectedItem()).listaJugadas.add(c2);
		}
		if(c3.getNombre().compareTo("...")!=0){
			((Futbolista)ListaJ.getSelectedItem()).listaJugadas.add(c3);
		}
	}
}
class OyenteCambiar implements ActionListener{


	public void actionPerformed(ActionEvent e) {
		IntAdmin.r5.Cambiar();
		
	}
	
}