package objetos.futbol.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OyenteEdicion implements ActionListener {

	String r;
	public void actionPerformed(ActionEvent act) {
		r = (String)act.getActionCommand();
		if (r.compareTo("Seleccionar Jugadores")==0){
			InterfazUsuarioGeneral.EdicionV.setVisible(true);
			InterfazUsuarioGeneral.EdicionV.setLocationRelativeTo(null);
		}
		else{
			OyenteIn.UsuarioC=false;
			OyenteIn.ContraC=false;
			InterfazUsuarioGeneral.recuerdo.setText(("Ingrese Usuario: "));
		}
	}
	

}
