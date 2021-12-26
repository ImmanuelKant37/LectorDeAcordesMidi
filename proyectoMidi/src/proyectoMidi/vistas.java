package proyectoMidi;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class vistas{
	Form form = new Form();
	JLabel lblAcordeDim = new JLabel();
	public vistas(){
		Valores.add(valorDo);
		Valores.add(valorReb);
		Valores.add(valorRe);
		Valores.add(valorMib);
		Valores.add(valorMi);
		Valores.add(valorFa);
		Valores.add(valorSolb);
		Valores.add(valorSol);
		Valores.add(valorLab);
		Valores.add(valorLa);
		Valores.add(valorSib);
		Valores.add(valorSi);
		
	}
	

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
	
	ArrayList <int[]> Valores = new ArrayList<int[]>();
	////////////NOTAS ORDENADAS POR OCTAVA!!!///////////////////////////
	////////////////////////////////////////////////////////////////////
	int valorDo[] = new int[] {12, 12, 24, 36, 48, 60, 72, 84, 96, 118 };
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
	

	String nombreTeclasPresionadas[] = new String[150];
	
	String nNotaSostenido[] = new String[] { "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" };
	String nNotaBemol[] = new String[] { "Do", "Reb", "Re", "Mib", "Mi", "Fa", "Solb", "Sol", "Lab", "La", "Sib", "Si" };
	

	int nPulsadas[] = new int[12];
	int numeroDeNota;
	int condicionalPulsada = 0;

	int cantidadNotasPulsadas = 0;
	int nSoltada = 0;
	
	int valorTeclaPresionada[] = new int[150];
	int numeroDeOctava[] = 		 new int[150];


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

	
	public void verificarNotas(int octava) {
		
		for(int i=0;i<10;i++) {
			if (numeroDeNota == Valores.get(octava)[i]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaBemol[octava];
				valorTeclaPresionada[numeroDeNota] = Valores.get(octava)[i];
				numeroDeOctava[numeroDeNota] =i;
				
				System.out.println("VALOR GET OCTAVA: "+Valores.get(octava)[i]);
				System.out.println("NOMBRE TECLA PRESIONADA: "+ nombreTeclasPresionadas[numeroDeNota]+" ");
				System.out.println("VALOR TECLA PRESIONADA: " +valorTeclaPresionada[numeroDeNota]+" ");
				System.out.println("NUMERO DE OCTAVA: " +numeroDeOctava[numeroDeNota]);
			}
		}
	}

	public void verificarNotaSuelta(int octava) {

		for(int i=0;i<10;i++) {
			if (numeroDeNota == Valores.get(octava)[i]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = 0;
				numeroDeOctava[numeroDeNota] =0;
				
				System.out.println("VALOR GET OCTAVA: "+Valores.get(octava)[i]);
				System.out.println("NOMBRE TECLA PRESIONADA: "+ nombreTeclasPresionadas[numeroDeNota]+" ");
				System.out.println("VALOR TECLA PRESIONADA: " +valorTeclaPresionada[numeroDeNota]+" ");
				System.out.println("NUMERO DE OCTAVA: " +numeroDeOctava[numeroDeNota]);
			}
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
