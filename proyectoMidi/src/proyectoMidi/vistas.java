package proyectoMidi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class vistas{
	Form form = new Form();
	public vistas(){
	
	}
	
	JLabel lblAcordeDim = new JLabel();
	////////////MODIFICADOR DE IMAGEN DEL INSTRUMENTO////////////////////
	///////////////////////////////////////////////////////////////////
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
	//////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////

	////////////NOTAS ORDENADAS POR OCTAVA!!!///////////////////////////
	////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	int valorDo[] = new int[] { 0, 12, 24, 36, 48, 60, 72, 84, 96, 118 };
	int valorReb[] = new int[] { 1, 13, 25, 37, 49, 61, 73, 85, 97, 119 };
	int valorRe[] = new int[] { 2, 14, 26, 38, 50, 62, 74, 86, 98, 120 };
	int valorMib[] = new int[] { 3, 15, 27, 39, 51, 63, 75, 87, 99, 121 };
	int valorMi[] = new int[] { 4, 16, 28, 40, 52, 64, 76, 88, 100, 122 };
	int valorFa[] = new int[] { 5, 17, 29, 41, 53, 65, 77, 89, 101, 123 };
	int valorSolb[] = new int[] { 6, 18, 30, 42, 54, 66, 78, 90, 102, 124 };
	int valorSol[] = new int[] { 7, 19, 31, 43, 55, 67, 79, 91, 103, 125 };
	int valorLab[] = new int[] { 8, 20, 32, 44, 56, 68, 80, 92, 104, 126 };
	int valorLa[] = new int[] { 9, 21, 33, 45, 57, 69, 81, 93, 105, 127 };
	int valorSib[] = new int[] { 10, 22, 34, 46, 58, 70, 82, 94, 106, 128 };
	int valorSi[] = new int[] { 11, 23, 35, 47, 59, 71, 83, 95, 107, 129 };
	
	////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	
	String Acorde = "";
	String acordeFormado = "Acorde";
	
	String teclasPresionadas[] = new String[14];
	String nombreTeclasPresionadas[] = new String[130];
	
	String nNotaSostenido[] = new String[] { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
	String nNotaBemol[] = new String[] { "Do", "Reb", "Re", "Mib", "Mi", "Fa", "Solb", "Sol", "Lab", "La", "Sib", "Si" };
	

	int nPulsadas[] = new int[12];
	int numeroDeNota;
	int condicionalPulsada = 0;

	int cantidadNotasPulsadas = 0;
	int nSoltada = 0;
	
	int valorTeclaPresionada[] = new int[130];
	int numeroDeOctava[] = 		 new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };




	public String Distancia(int nota1, int nota2) {
		String distancia = "";
		
		for(int i=0; i<10; i++) {
			if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorDo[i]) {
				distancia = "Octava";
			}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorReb[i]) {
			distancia = "Segunda Menor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorRe[i]) {
			distancia = "Segunda Mayor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorMib[i]) {
			distancia = "Tercera Menor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorMi[i]) {
			distancia = "Tercera Mayor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorFa[i]) {
			distancia = "Cuarta";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorSolb[i]) {
			distancia = "Quinta Disminuida";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorSol[i]) {
			distancia = "Quinta";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorLab[i]) {
			distancia = "Sexta Menor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorLa[i]) {
			distancia = "Sexta Mayor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorSib[i]) {
			distancia = "Septima Menor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorSi[i]) {
			distancia = "Septima Mayor";
		}
		if (valorTeclaPresionada[nota2] - valorTeclaPresionada[nota1] == valorDo[i]) {
			distancia = "Octava";
		}
		}

		return distancia;

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

	public void verificarNotas(int octava) {
		
			if (numeroDeNota == valorDo[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[0];
				valorTeclaPresionada[numeroDeNota] = valorDo[octava];
				numeroDeOctava[0] = octava;
				
				System.out.println("Do verificado");
			}

			if (numeroDeNota == valorReb[octava]) {
				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[1];
				valorTeclaPresionada[numeroDeNota] = valorReb[octava];
				numeroDeOctava[1] = octava;
			}

			if (numeroDeNota == valorRe[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[2];
				valorTeclaPresionada[numeroDeNota] = valorRe[octava];
				numeroDeOctava[2] = octava;
			}

			if (numeroDeNota == valorMib[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[3];
				valorTeclaPresionada[numeroDeNota] = valorMib[octava];
				numeroDeOctava[3] = octava;
			}

			if (numeroDeNota == valorMi[octava]) {
				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[4];
				valorTeclaPresionada[numeroDeNota] = valorMi[octava];
				numeroDeOctava[4] = octava;
			}

			if (numeroDeNota == valorFa[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[5];
				valorTeclaPresionada[numeroDeNota] = valorFa[octava];
				numeroDeOctava[5] = octava;
			}

			if (numeroDeNota == valorSolb[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[6];
				valorTeclaPresionada[numeroDeNota] = valorSolb[octava];
				numeroDeOctava[6] = octava;
			}

			if (numeroDeNota == valorSol[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[7];
				valorTeclaPresionada[numeroDeNota] = valorSol[octava];
				numeroDeOctava[7] = octava;
			}

			if (numeroDeNota == valorLab[octava]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaSostenido[8];
				valorTeclaPresionada[numeroDeNota] = valorLab[octava];
				numeroDeOctava[8] = octava;
			}

			if (numeroDeNota == valorLa[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = nNotaSostenido[9];
				valorTeclaPresionada[numeroDeNota] = valorLa[octava];
				numeroDeOctava[9] = octava;
			}

			if (numeroDeNota == valorSib[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = nNotaSostenido[10];
				valorTeclaPresionada[numeroDeNota] = valorSib[octava];
				numeroDeOctava[10] = octava;
			}

			if (numeroDeNota == valorSi[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = nNotaSostenido[11];
				valorTeclaPresionada[numeroDeNota] = valorSi[octava];
				numeroDeOctava[11] = octava;
			}

		}

	public void verificarNotaSuelta(int octava) {
		
			if (numeroDeNota == valorDo[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[0] = 0;
			}

			if (numeroDeNota == valorReb[octava]) {

				
				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[1] = 0;
			}

			if (numeroDeNota == valorRe[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[2] = 0;
			}

			if (numeroDeNota == valorMib[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[3] = 0;
			}

			if (numeroDeNota == valorMi[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[4] = 0;
			}

			if (numeroDeNota == valorFa[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[5] = 0;
			}

			if (numeroDeNota == valorSolb[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] =-200; 
				numeroDeOctava[6] = 0;
			}

			if (numeroDeNota == valorSol[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[7] = 0;
			}

			if (numeroDeNota == valorLab[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[8] = 0;
			}

			if (numeroDeNota == valorLa[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[9] = 0;
			}

			if (numeroDeNota == valorSib[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[10] = 0;
			}

			if (numeroDeNota == valorSi[octava]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = -200;
				numeroDeOctava[11] = 0;
			}

		}
	
	public void devuelveNotasON(int octava) {
		int oct= 12*octava;
		
		
		for (int j = 0; j < 12; j++) {
			if (nombreTeclasPresionadas[oct+j] != "") {
			
				form.label[j + 2].setText(nombreTeclasPresionadas[oct+j] + " " +octava + " ");
			
			}
			
		}
	
		 ;
	}

	public void devuelveNotaOFF(int octava) {
		int oct= 12*octava;

		for (int j = 0; j < 12; j++) {
			if (nombreTeclasPresionadas[oct+j] == "") {
			
				form.label[j + 2].setText(nombreTeclasPresionadas[oct+j] + " " );
				
			}

		}
	

	}
}
