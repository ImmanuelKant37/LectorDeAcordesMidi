package proyectoMidi;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

public class VistaPiano extends vistas {
	public VistaPiano() {
		try {
			resizeImagen("src/img/Piano.jpg", "src/img/piano.jpg", 700, 300);
		} catch (IOException e) {
			System.out.println("Error en carga de imagen" + e.toString());
		}
		form.boton("Cerrar conexion Midi", 1, 0, 0, 200, 25);
		form.label("x", 14, 50, 50, 300, 300);
		resetStringNombres();
		posicionesNotasPiano();
	
		form.imagen("src/img/piano.jpg", -300, -300, 1000, 1000);
		
		form.label[0].setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[1].setFont(new Font("Serif", Font.PLAIN, 40));
		lblAcordeDim.setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[0].setText("Mayor");
		form.label[1].setText("Menor");
		lblAcordeDim.setText("DIM");
		
		form.add(lblAcordeDim);
		
		form.label[0].setBounds(700, 0, 500, 200);
		lblAcordeDim.setBounds(700,100,500,200);
		form.label[1].setBounds(700, 200, 500, 200);
	}
	
	public void posicionesNotasPiano() {


		form.label[3].setBounds(240, 0, 50, 200);// DO#
		form.label[3].setForeground(Color.WHITE);// DO# Color

		form.label[5].setBounds(295, 0, 50, 200);// RE#
		form.label[5].setForeground(Color.WHITE);// RE# Color

		form.label[8].setBounds(400, 0, 50, 200);// FA#
		form.label[8].setForeground(Color.WHITE);// FA# Color

		form.label[10].setBounds(460, 0, 50, 200);// SOL#
		form.label[10].setForeground(Color.WHITE);// SOL# Color

		form.label[12].setBounds(510, 0, 50, 200);// LA#
		form.label[12].setForeground(Color.WHITE);// LA# Color

		form.label[2].setBounds(215, 200, 50, 200);// DO
		form.label[4].setBounds(270, 200, 50, 200);// RE
		form.label[6].setBounds(320, 200, 50, 200);// MI
		form.label[7].setBounds(375, 200, 50, 200);// FA

		form.label[9].setBounds(425, 200, 50, 200);// SOL

		form.label[11].setBounds(475, 200, 50, 200);// LA

		form.label[13].setBounds(525, 200, 50, 200);// SI

	}
	
	public void resetStringNombres() {
		for (int i = 0; i < 129; i++) {
			nombreTeclasPresionadas[i] = "";
		}
		for (int i = 0; i < 129; i++) {
			valorTeclaPresionada[i] = -130;
		}
	}

}
