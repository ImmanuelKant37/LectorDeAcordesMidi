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
	JLabel nombreNota = new JLabel();
	ArrayList<Integer> notasEncontradas= new ArrayList<Integer>();

public String distanciasEncontradas[]= new String[13];
	public vistas(){
		

		Valores.add(valorDo);//0
		Valores.add(valorReb);
		Valores.add(valorRe);
		Valores.add(valorMib);
		Valores.add(valorMi);//4
		Valores.add(valorFa);
		Valores.add(valorSolb);
		Valores.add(valorSol);//7
		Valores.add(valorLab);
		Valores.add(valorLa);
		Valores.add(valorSib);//10
		Valores.add(valorSi);
		Valores.add(valorDo);//12
		asignaDistancias();
	}
	////////////MODIFICADOR DE IMAGEN DEL INSTRUMENTO////////////////////
	///////////////////////////////////////////////////////////////////
	
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
	
	/////////////////////////SON 12 x 10 EN TOTAL!!!///////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
public int resultadoDeDistancias=0;
	String Acorde = "";
	String acordeFormado = "Acorde";
	
	String nNotaSostenido[] = new String[] 
	{ "Do", "Do#", "Re", "Re#", "Mi", "Fa", "Fa#", "Sol", "Sol#", "La", "La#", "Si" }; //i<12 Cantidad
	
	
	String nNotaBemol[] = new String[] 
    { "Do", "Reb", "Re", "Mib", "Mi", "Fa", "Solb", "Sol", "Lab", "La", "Sib", "Si" };//i<12 Cantidad
	int NotaOnOFF=3;

	int nPulsadas[] = new int[12];
	int numeroDeNota=0;
	int condicionalPulsada = 0;

	int cantidadNotasPulsadas = 0;
	int nSoltada = 0;
	
	int valorTeclaPresionada[] = new int[150];
	int numeroDeOctava[] = new int[150];
	
	String nombreTeclasPresionadas[] = new String[150];
	String [] Distancias=new String[100];
	public void asignaDistancias() {
		
			for(int i=0; i<8;i++) {
				int j=12*i;
		Distancias[0+j]="Tonica";
		Distancias[1+j]="Segunda Menor";
		Distancias[2+j]="Segunda Mayor";
		Distancias[3+j]="Tercera Menor";
		Distancias[4+j]="Tercera Mayor";
		Distancias[5+j]="Cuarta";
		Distancias[6+j]="Quinta Disminuida";
		Distancias[7+j]="Quinta";
		Distancias[8+j]="Sexta Menor";
		Distancias[9+j]="Sexta Mayor";
		Distancias[10+j]="Septima Menor";
		Distancias[11+j]="Septima Mayor";
	}
	}

	public String Distancia(int nota) {
		String distancia = "";	
		distancia=distanciasEncontradas[nota];	
		return distancia;
		}

	public void verificarNotas(int octava) {
		
		for(int i=0;i<10;i++) {
			if (numeroDeNota == Valores.get(octava)[i]) {

				nombreTeclasPresionadas[numeroDeNota] =  nNotaBemol[octava];
				valorTeclaPresionada[numeroDeNota] = Valores.get(octava)[i];
				numeroDeOctava[numeroDeNota] =i;
				
				System.out.print("NOMBRE TECLA PRESIONADA: "+ nombreTeclasPresionadas[numeroDeNota]
															+" "+numeroDeOctava[numeroDeNota]+" ");
				System.out.print("VALOR TECLA PRESIONADA: " +valorTeclaPresionada[numeroDeNota]+" ");

			}
		}
	}

	public void verificarNotaSuelta(int octava) {

		for(int i=0;i<10;i++) {
			if (numeroDeNota == Valores.get(octava)[i]) {

				nombreTeclasPresionadas[numeroDeNota] = "";
				valorTeclaPresionada[numeroDeNota] = 0;
				numeroDeOctava[numeroDeNota] = 0;
				}
		}
	}


	public void devuelveNotasON() {
		for (NotaOnOFF= 3; NotaOnOFF < 100; NotaOnOFF++) {
			if (nombreTeclasPresionadas[NotaOnOFF] != "") {
				form.label[NotaOnOFF].setText(nombreTeclasPresionadas[NotaOnOFF]);
	}
}
}

	public void devuelveNotaOFF() {
	
		for ( NotaOnOFF= 3; NotaOnOFF < 100; NotaOnOFF++) {
			if (valorTeclaPresionada[NotaOnOFF] == 0) {
				form.label[NotaOnOFF].setText("");
			}
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
