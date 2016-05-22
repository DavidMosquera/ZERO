package objetos.futbol.UI;
import javax.swing.*;
import objetos.futbol.UI.*;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;

import lejos.pc.comm.NXTConnector;

import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import objetos.futbol.menuconsola.*;

public class InterfazUsuarioGeneral extends JFrame {
	
	static ArrayList<OpcionDeMenu> Opciones = new ArrayList<OpcionDeMenu>();
	
	static Container C; //Contenedor principal de la ventana del usuario General
	
	public static Cancha cancha1=new Cancha();
	public static NXTConnector conn; 
	
	static MenuDeConsola Omeguita = new MenuDeConsola();
	
	static ArrayList<String> Nomb = new ArrayList<String>();
	static ArrayList<Double> Xlist = new ArrayList<Double>();
	static ArrayList<Double> YList = new ArrayList<Double>();
	
	
	static Arquero arquero;
	static Delantero delantero;
	static SeleccionJ EdicionV;
	static IntAdmin Admin1;
	static Futbolista Seleccionado;
	static String Usuario;
	static String Contra;
	
	private JPanel p1; // Panel ubicado en WEST del pSup, Contiene Acciones e icono del jugador seleccionado
	private static JPanel p1a;// Panel auxiliar A del panel 1, contiene las acciones del jugador
	private static JPanel p1b;// Panel auxiliar B del panel 1, contiene el ícono del jugador
	private JPanel p2; // Panel ubicado en EAST del pSup, Contiene Historia y la Posición X Y
	static JPanel p2a;// Panel auxiliar A del panel 2, contiene la Historia de jugadas 
	static JPanel p2b;// Panel auxiliar B del panel 2, contiene la posicion X Y
	private JPanel p3; // Panel ubicado en SOUTH del contenedor, Contiene un campo de texto para ingresar datos, el boton enviar y el area de impresión
	private JPanel p4; // Panel ubicado en NORTH del contenedor, Contiene la JMenuBar donde encontramos las opciones Archivo, Edición, Ayuda.
	static CanchaDibujo pcan=new CanchaDibujo(); ; //Panel ubicado en CENTER de pSup, Contiene la gráfica de la cancha donde se actualiza la posición.
	private JPanel pSup; //Panel que contiene el panel de la cancha, la historia, acciones, posición he imagen, Ubicado en el centro del contenedor.
	
	private JMenuBar opcionesbarra; // JMenuBar que contiene Las opciones Archivo, Edicion, Ayuda;
	
	static JTextField in; // JTextField que comunica al usuario con los datos solicitados
	public static  JTextArea inprint; // JTextArea donde se imprime las solicitudes del programa al usuario
	public static  JTextField recuerdo; // JTextField Recuerdo de acciones pasadas
	
	static JList<String> HistorialL;
	
	private Button enviar;
	
	static OyenteAcciones EventoA = new OyenteAcciones();
	
	//Etiquetas del programa
	private static JLabel Acciones;
	private static JLabel imaJugador;
	static JLabel Historia;
	private JLabel Posicion;
	private static JLabel Jugador_Uso;
	private static JLabel NombreJ;
	
	static JLabel xm;
    static JLabel ym;
    static JLabel Ang;
	
	
	static java.net.URL iconojugador;
	
	private JMenu Archivo;
	private JMenu Edicion;
	private JMenu Ayuda;
	private JMenuItem ListaJuga;
	private JMenuItem ReiniSe;
	private JMenuItem Conectar;
	private JMenuItem TerminarP;
	
	
	private static Button Adelantar;
	private static Button Retroceder;
	private static Button Patear;
	private static Button GirarI;
	private static Button GirarD;
	private static Button Parar;
	
	ArrayList<String> nombreJ = new ArrayList <String>();	
	ArrayList<Integer> xJ = new ArrayList <Integer>();	
	ArrayList<Integer> yJ = new ArrayList <Integer>();
	ArrayList<Integer> indiceJ = new ArrayList <Integer>();	
	
	public InterfazUsuarioGeneral() throws IOException{
		
		super ("Football_Z.E.R.O");
		
		OyenteAcciones.conn = new NXTConnector();
		Omeguita.lanzarMenu();
		 
		
		xm = new JLabel ("X: "+Math.round(cancha1.PosicionRobot_x));
	    ym = new JLabel ("Y: "+Math.round(cancha1.PosicionRobot_y));
	    Ang = new JLabel("\u0398"+" : "+Math.round(cancha1.Angulo_actual));
		
		
		Acciones = new JLabel("Acciones");
		C=this.getContentPane(); // Obtenemos el contenedor principal
	    C.setLayout(new BorderLayout()); // Establecemos el Layout del contenedor
	    JPanel panelAuxiliar = new JPanel(new GridLayout(2,1));
	    
	    this.Opciones.add(new Opcion_adelante_w()); // Adelantar-(0)
		this.Opciones.add(new Opcion_atras_s()); // Retroceder-(1)
		this.Opciones.add(new Opcion_girar_izquierda_a()); // GiroIzquierda-(2)
		this.Opciones.add(new Opcion_girar_derecha_d()); // GiroDerecha-(3)
		this.Opciones.add(new Opcion_patear_q()); // Patear-(4)
		this.Opciones.add(new Opcion_parar_e()); // Frenar-(5)
	    
		Xlist.add((double)1241);
		YList.add((double)123);
		Xlist.add((double)546);
		YList.add((double)844);
		
		
		
	    pSup = new JPanel (new BorderLayout(10,10));
	   
	    p1a = new JPanel(new GridLayout(10,1));
	    p1b = new JPanel(new GridLayout(3,1));
	    p1  = new JPanel(new GridLayout(2,1,10,10));
	    
	    p2a = new JPanel(new BorderLayout(10,10));
	    p2b = new JPanel(new GridLayout(6,1));
	    p2  = new JPanel(new GridLayout(2,1,10,10));
	    
	    p3  = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
	    
	    JPanel p4  = new JPanel(new FlowLayout());
	    JPanel p42  = new JPanel(new FlowLayout());
	    JPanel p41  = new JPanel(new FlowLayout());
	   
	    
	    enviar = new Button("Enviar");
	    iconojugador = getClass().getClassLoader().getResource("imagenes/inicial.jpg");
	    Acciones = new JLabel("      Acciones");
	    imaJugador = new JLabel(new ImageIcon(iconojugador));
	    Historia = new JLabel("               Historia");
	    Posicion = new JLabel("   Posición   ");
	    Jugador_Uso = new JLabel("   Jugador_Uso   ");
	    NombreJ = new JLabel ("                   ");
	    
	    JLabel Relleno = new JLabel ("               ");
	    
	    in = new JTextField (74);
	    inprint = new JTextArea(3,60);
	    recuerdo= new JTextField(79);
	    recuerdo.setEditable(false);
	    recuerdo.setBackground(Color.LIGHT_GRAY);
	    
	    JScrollPane scroll = new JScrollPane(inprint); 
	    inprint.setPreferredSize(new Dimension (3,999999999));
	    scroll.setViewportView(inprint);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    inprint.setLineWrap(true);
	    inprint.setWrapStyleWord(true);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    
	    Adelantar = new Button("Adelantar");
	    Retroceder = new Button("Retroceder");
	    GirarI = new Button("Girar Izq.");
	    GirarD = new Button("Girar Der.");
	    Patear = new Button("Patear");
	    Parar = new Button ("Parar");
	    Archivo = new JMenu ("Archivo");
	    Edicion = new JMenu ("Edición");
	    Ayuda = new JMenu ("Ayuda");
	    
	    opcionesbarra = new JMenuBar();
	    
	    
	    
	    
	    opcionesbarra.add(Archivo);
	    opcionesbarra.add(Edicion);
	    opcionesbarra.add(Ayuda);
	    
	    Edicion.add(ListaJuga = new JMenuItem("Seleccionar Jugadores"));
	    Edicion.add(ReiniSe = new JMenuItem("Reiniciar Sesion"));
	    Archivo.add(Conectar = new JMenuItem("Conectar con NXT "));
	    TerminarP = new JMenuItem("Terminar partido");
	    Archivo.add(TerminarP);
	    
	    
	   
	    HistorialL = new JList<String>();
	    HistorialL.setBackground(Color.LIGHT_GRAY);
	    HistorialL.setSize(50,50);
	    HistorialL.setMaximumSize(new Dimension(80,80));
	    HistorialL.setPreferredSize(new Dimension (140,80));
	    HistorialL.addListSelectionListener(new OyenteHistorial());
	    
	    
	    JScrollPane Historial = new JScrollPane(HistorialL);
	    Historial.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    Historial.setMaximumSize(new Dimension(80,80));
	    Historial.setPreferredSize(new Dimension (140,80));
	    
	   
	    p1a.setBackground(Color.LIGHT_GRAY);
	    p1a.add(Acciones);
	    
	    enviar.addActionListener(new OyenteIn());
	    
	    
	    p1b.setBackground(Color.LIGHT_GRAY);
	    p1b.add(Jugador_Uso);
	    p1b.add(imaJugador);
	    p1b.add(NombreJ);
	    
	    p1.add(p1a);
	    p1.add(p1b);
	    
	    p3.add(recuerdo);
	    p3.add(in);
	    p3.add(enviar);
	    inprint.setEditable(false);
	    panelAuxiliar.add(p3);
	    panelAuxiliar.add(scroll);
	    p2a.setBackground(Color.LIGHT_GRAY);
	    p2b.setBackground(Color.LIGHT_GRAY);
	    p2a.add(Historia,BorderLayout.NORTH);
	    p2a.add(Historial, BorderLayout.CENTER); 
	    p2b.add(Posicion);
	    p2b.add(xm);
	    p2b.add(ym);
	    p2b.add(Ang);
	    p2.add(p2a);
	    p2.add(p2b);
	    
	    
	    Conectar.addActionListener(new OyenteArchivo());
	    TerminarP.addActionListener(new OyenteArchivo());
	    ListaJuga.addActionListener(new OyenteEdicion());
	    ReiniSe.addActionListener(new OyenteEdicion());
	    InterfazUsuarioGeneral.inprint.setText(("Bienvenido"));
	    InterfazUsuarioGeneral.recuerdo.setText(("Ingrese su Usuario: "));
	    pSup.add(p2, BorderLayout.EAST);
	    pSup.add(pcan, BorderLayout.CENTER);
	    pSup.add(p1, BorderLayout.WEST);
	    C.add(pSup, BorderLayout.CENTER);
	    C.add(p4, BorderLayout.NORTH);
	    C.add(panelAuxiliar, BorderLayout.SOUTH);
	    C.add(p41, BorderLayout.WEST);
	    C.add(p42, BorderLayout.EAST);
	    EdicionV = new SeleccionJ();
	    Admin1 = new IntAdmin();
	    setJMenuBar(opcionesbarra);
	    setFocusable(true);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  try {
					Omeguita.Guardar();
				} catch (IOException e1) {
				}
			  }
			});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		requestFocus();
		setSize(900,700);
	}
	static void Acciones(){
		p1a.removeAll();
		p1a.add(Acciones);
		p1a.add(Adelantar);
		p1a.add(Retroceder);
		p1a.add(GirarI);
		p1a.add(GirarD);
		p1a.add(Patear);
		p1a.add(Parar);
		Adelantar.addActionListener(EventoA);
		Retroceder.addActionListener(EventoA);
		GirarI.addActionListener(EventoA);
		GirarD.addActionListener(EventoA);
		Patear.addActionListener(EventoA);
		Parar.addActionListener(EventoA);
		if (Seleccionado.listaJugadas!=null){
		for (int i = 0; i< Seleccionado.listaJugadas.size();i++){
			Button Compleja = new Button(Seleccionado.listaJugadas.get(i).getNombre());
			Compleja.addActionListener(EventoA);
			p1a.add(Compleja);
		}
		}
		else{
			
		}
		p1b.removeAll();
		p1b.add(Jugador_Uso);
		try{
			imaJugador.setIcon(new ImageIcon (Seleccionado.getRuta()));
		}
		catch (NullPointerException e){
			imaJugador.setIcon(new ImageIcon (iconojugador));
			
		}
		
		p1b.add(imaJugador);
		NombreJ.setText(Seleccionado.getNombre());
		p1b.add(NombreJ);
		C.validate();
		C.repaint();
	}
	
	
	
	public static void main (String arg[]) throws IOException{
		InterfazUsuarioGeneral Alpha = new InterfazUsuarioGeneral();
	}
}
