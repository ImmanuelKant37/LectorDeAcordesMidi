package proyectoMidi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VistaPiano extends vistas {
	public VistaPiano  () throws IOException{
		
		resizeImagen("src/img/Piano.jpg","src/img/piano.jpg",1000,1000);
	}
	{
	
		
		form.menu("Archivo", 3);
		try {
			form.menuItem[0].addMouseListener(new Eventos(3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		form.boton("Cerrar conexion Midi", 1, 0, 0, 200, 25);
	
		form.label("", 100, 730, 0, 200, 200);
		
		resetStringNombres();
		posicionesNotasPiano();
	
	
		form.label[0].setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[1].setFont(new Font("Serif", Font.PLAIN, 40));
		lblAcordeDim.setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[0].setText("+");
		form.label[1].setText("-");
		lblAcordeDim.setText("DIM");
		nombreNota.setBounds(670,0,100,100);
		nombreNota.setText("Nota extra: ");
		form.add(lblAcordeDim);
		form.add(nombreNota);
		form.label[0].setBounds(700, 100, 300, 100);
		lblAcordeDim.setBounds(700,200,500,200);
		form.label[1].setBounds(700, 300, 500, 200);
	}
	
	public void posicionesNotasPiano() {
		
		///OCTAVA 4
		form.label[53].setBounds(10, 200, 50, 200);// FA
		
		form.label[54].setBounds(30, 0, 50, 200);// FA#
		form.label[54].setForeground(Color.WHITE);// FA# Color

		form.label[55].setBounds(55, 200, 50, 200);// SOL

		form.label[56].setBounds(80, 0, 50, 200);// SOL#
		form.label[56].setForeground(Color.WHITE);// SOL# Color

		form.label[57].setBounds(110, 200, 50, 200);// LA
		
		form.label[58].setBounds(140, 0, 50, 200);// LA#
		form.label[58].setForeground(Color.WHITE);// LA# Color

		form.label[59].setBounds(165, 200, 50, 200);// SI
		
		///OCTAVA 5
		
		form.label[60].setBounds(215, 200, 50, 200);// DO
		
		form.label[61].setBounds(240, 0, 50, 200);// DO#
		form.label[61].setForeground(Color.WHITE);// DO# Color

		form.label[62].setBounds(270, 200, 50, 200);// RE
		
		form.label[63].setBounds(295, 0, 50, 200);// RE#
		form.label[63].setForeground(Color.WHITE);// RE# Color

		form.label[64].setBounds(320, 200, 50, 200);// MI
		
		form.label[65].setBounds(375, 200, 50, 200);// FA
		
		form.label[66].setBounds(400, 0, 50, 200);// FA#
		form.label[66].setForeground(Color.WHITE);// FA# Color

		form.label[67].setBounds(425, 200, 50, 200);// SOL

		form.label[68].setBounds(460, 0, 50, 200);// SOL#
		form.label[68].setForeground(Color.WHITE);// SOL# Color

		form.label[69].setBounds(475, 200, 50, 200);// LA
		
		form.label[70].setBounds(510, 0, 50, 200);// LA#
		form.label[70].setForeground(Color.WHITE);// LA# Color

		form.label[71].setBounds(525, 200, 50, 200);// SI

	}
	
	public void resetStringNombres() {
		for (int i = 0; i < 150; i++) {
			nombreTeclasPresionadas[i] = "";
		}
		for (int i = 0; i < 150; i++) {
			valorTeclaPresionada[i] = 0;
		}
	}
	public void resizeImagen(String imagePathToRead, String imagePathToWrite, int resizeWidth, int resizeHeight)
			throws IOException {
		{

			File fileToRead = new File(imagePathToRead);
			BufferedImage bufferedImageInput = ImageIO.read(fileToRead);

			BufferedImage bufferedImageOutput = new BufferedImage(resizeWidth, resizeHeight,
					bufferedImageInput.getType());

			Graphics2D g2d = bufferedImageOutput.createGraphics();
			g2d.drawImage(bufferedImageInput, 0, 0, resizeWidth, resizeHeight, null);
			g2d.dispose();

			String formatName = imagePathToWrite.substring(imagePathToWrite.lastIndexOf(".") + 1);

			ImageIO.write(bufferedImageOutput, formatName, new File(imagePathToWrite));
		}
	}

}
