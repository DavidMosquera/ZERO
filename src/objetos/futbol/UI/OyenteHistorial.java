package objetos.futbol.UI;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

public class OyenteHistorial implements ListSelectionListener{

	public void valueChanged(ListSelectionEvent ev) {
		String r =  InterfazUsuarioGeneral.HistorialL.getSelectedValue();
		int index = InterfazUsuarioGeneral.HistorialL.getSelectedIndex();
		InterfazUsuarioGeneral.inprint.setText("La jugada: "+r+" se realiz� en la posici�n: ("+ InterfazUsuarioGeneral.Xlist.get(index)+" , "+InterfazUsuarioGeneral.YList.get(index)+").");
		InterfazUsuarioGeneral.C.revalidate();
		InterfazUsuarioGeneral.C.repaint();
	}
	

}
