package objetos.futbol.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OyenteIn implements ActionListener{
    static boolean UsuarioC = false ; 
    static boolean ContraC = false ; 
	public void actionPerformed(ActionEvent ev) {
		InterfazUsuarioGeneral.inprint.setText(InterfazUsuarioGeneral.inprint.getText()+"\n"+InterfazUsuarioGeneral.in.getText());
		
		if (UsuarioC==false&&InterfazUsuarioGeneral.in.getText().compareTo("")!=0){
			InterfazUsuarioGeneral.recuerdo.setText(("Ingrese su Contraseña: "));
			InterfazUsuarioGeneral.Usuario=InterfazUsuarioGeneral.in.getText();
			UsuarioC=true;
		}
		else if (ContraC==false&&InterfazUsuarioGeneral.in.getText().compareTo("")!=0){
			InterfazUsuarioGeneral.Contra=InterfazUsuarioGeneral.in.getText();
			if (InterfazUsuarioGeneral.Usuario.compareTo("Admin")==0&&InterfazUsuarioGeneral.Contra.compareTo("Admin")==0){
				InterfazUsuarioGeneral.Admin1.setVisible(true);
				UsuarioC=false;
				ContraC=false;
				InterfazUsuarioGeneral.recuerdo.setText(("Ingrese su Usuario: "));
			}
			else{
				ContraC=true;
				InterfazUsuarioGeneral.recuerdo.setText(("Elija Jugadores en Edicion/Elejir Jugadores"));
			}
		}
		
		InterfazUsuarioGeneral.in.setText("");
		InterfazUsuarioGeneral.C.revalidate();
		InterfazUsuarioGeneral.C.repaint();
	}
}
