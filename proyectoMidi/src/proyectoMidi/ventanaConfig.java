package proyectoMidi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ventanaConfig extends MIDI implements ActionListener{
	
	Form ventanaConfig = new Form(false);
	int cantidadDeEntradas = dispo.size();
	Color color=new Color(255,0,0);
	public ventanaConfig  ()  throws IOException {
		ventanaConfig.setVisible(false);
	}
	
	public void iniciar() {
		ventanaConfig.setVisible(true);
		ventanaConfig.lista(3, 100, 150, 150);
		for(int i=0;i<cantidadDeEntradas;i++) {
		ventanaConfig.modelLista.add(i, dispo.get(i));
		}
		ventanaConfig.boton("Aceptar", 1, 200, 100, 100, 100);
ventanaConfig.boton[0].addActionListener(this);
		
	}
	public void seleccionDeInput() throws IOException {
		int numerin=ventanaConfig.lista.getSelectedIndex();
		if (numerin!=-1) {
		System.out.println(numerin);
		for(int i=0;i<cantidadDeEntradas;i++) {
			cerrarMidi(i);
		}
		abrirMidi(numerin);
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
try {
	seleccionDeInput();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}		
	}
}
