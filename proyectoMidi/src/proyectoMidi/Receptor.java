package proyectoMidi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.swing.JLabel;

public class Receptor implements Receiver {
	private static final long serialVersionUID = 1L;
	
	Form form = new Form();

	

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
	
	ArrayList <Integer> Valores = new ArrayList<>(); 
	JLabel lblAcordeDim = new JLabel();
	
	public Receptor() throws IOException {
		form.boton("Cerrar conexion Midi", 1, 0, 0, 200, 25);
		form.label("x", 14, 50, 50, 300, 300);
		resetStringNombres();
		posicionesNotasPiano();
		resizeImagen("src/img/Piano.jpg", "src/img/piano.jpg", 700, 300);
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


	
	@Override
	public void close() {}
	

	@Override
	public void send(MidiMessage message, long tiempo) {

		numeroDeNota = (int) (message.getMessage()[1] & 0xFF);
		condicionalPulsada = (int) (message.getMessage()[0] & 0xFF);

		notaOfNotaOn();

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
	
	public void notaOfNotaOn() {
		String acorde = "";
	
	
		if (condicionalPulsada == 144) {
			cantidadNotasPulsadas++;
			nPulsadas[cantidadNotasPulsadas] = numeroDeNota;
			nSoltada = numeroDeNota;
			form.label[1].setText("");
			form.label[0].setText("");
			for (int i = 0; i < 10; i++) {
				verificarNotas(i);
				devuelveNotasON(i);
			}
			
			if (cantidadNotasPulsadas == 3) {
				form.label[0].setText("");
			form.label[1].setText("");
		
			lblAcordeDim.setText("");
			form.label[0].setText(esMayor());
			lblAcordeDim.setText(esDisminuido());
			form.label[1].setText(esMenor()); 
			}
			
			if (cantidadNotasPulsadas == 4) {
				form.label[0].setText("");
				form.label[1].setText("");
				
				form.label[0].setText(esMayorSeptima());
				form.label[1].setText(esMenorSeptima());
			
				if(form.label[0].getText()==""){
				   form.label[0].setText(esMayor());
				
			}

				if(form.label[1].getText()=="") {
					lblAcordeDim.setText(esDisminuido());
				
			}
		
			}
			if (cantidadNotasPulsadas < 3) {
				form.label[1].setText("");
				form.label[0].setText("");
			}
			System.out.println("Formaste:" + acorde);
			System.out.println(" Teclas presionadas: " + cantidadNotasPulsadas);

		}

		if (condicionalPulsada == 128) {
			
			cantidadNotasPulsadas--;
			form.label[1].setText("");
			form.label[0].setText("");
			for(int i=0; i<10;i++) {
			verificarNotaSuelta(i);
			devuelveNotaOFF(i);
			}
			
			lblAcordeDim.setText(esDisminuido());
			form.label[0].setText(esMayor());
			form.label[1].setText(esMenor());
		
		
			if (cantidadNotasPulsadas == 3) {
			
				
			form.label[0].setText(esMayor());
			form.label[1].setText(esMenor());
		
			}
			if (cantidadNotasPulsadas < 3) {
				form.label[1].setText("");
				form.label[0].setText("");
				
			}

			if (cantidadNotasPulsadas >= 4) {
				form.label[0].setText("");
				form.label[1].setText("");
				form.label[1].setText(esMayorSeptima());
			
				form.label[0].setText(esMenorSeptima());
			}
				
			System.out.println(" Teclas presionadas: " + cantidadNotasPulsadas);
		}

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

//SECCION PARA VERIFICAR ACORDES COMPLETOS//
	///////////////////////////////////////////////////

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
	public String esMayor() {

		Acorde = "";
		
		//DESDE DO A MI
		for (int i = 0; i < 120; i++) {
			if (Distancia(i + 0, i + 4) == "Tercera Mayor" && Distancia(i + 0, i + 7) == "Quinta") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]] + " Mayor";
			}
			if (Distancia(i + 4, i + 7) == "Tercera Menor" && Distancia(i + 7, i + 0) == "Cuarta") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 4]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[i]] + " Mayor";
			}

			if (Distancia(i + 7, i + 0) == "Cuarta" && Distancia(i + 7, i + 4) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i+ 7]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[i]] + " Mayor";
			}
		
		}
		//DESDE FA A SOL

		return Acorde;
	}
	public String esMenor() {

		String Acorde = "";

		for (int i = 0; i < 120; i++) {
			if (Distancia(i + 0, i + 3) == "Tercera Menor" && Distancia(i + 0, i + 7) == "Quinta") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]] + " Menor";
			}
			if (Distancia(i + 7, i + 0) == "Cuarta" && Distancia(i + 7, i + 3) == "Sexta Menor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 7]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[i]] + " Menor";
			}

			if (Distancia(i + 3, i + 7) == "Tercera Mayor" && Distancia(i + 3, i + 0) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 3]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[i + 0]] + " Menor";
			}
		}

		return Acorde;

	}
	public String esDisminuido() {

		String Acorde = "";
			////////////////////////////////SIN INVERSION
		for (int i = 0; i < 120; i++) {
			if (Distancia(i + 0, i + 3) == "Tercera Menor"
			 && Distancia(i + 0, i + 6) == "Quinta Disminuida") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]]
				+ 	" Dim ";
			}
			//////////////////////////////PRIMER INVERSION
			if (Distancia(i + 3, i + 6) == "Tercera Menor" 
			 && Distancia(i + 3, i + 0) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 3]]
				+ "/" + nombreTeclasPresionadas[valorTeclaPresionada[i + 0]] 
				+	" Dim";
			}
			///////////////////////////////SEGUNDA INVERSION
			if (Distancia(i + 6, i + 0) == "Quinta Disminuida" 
			 && Distancia(i + 6, i + 3) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 6]] 
				+ "/" + nombreTeclasPresionadas[valorTeclaPresionada[i]]
				+	" Dim ";
			}

		

		}
System.out.println(Acorde);
		return Acorde;

	}
	public String esMayorSeptima() {

		String Acorde = "";
		
		//MAYOR SEPTIMA SIN INVERTIR
		for (int i = 0; i < 120; i++) {
			if (Distancia(i + 0, i + 4) == "Tercera Mayor" 
					&& Distancia(i + 0, i + 7) == "Quinta"
						&& Distancia(i + 0, i + 10) == "Septima Menor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 0]] + "Mayor" + "7";
			}
		}
	
		//MAYOR SEPTIMA PRIMER INVERSION
		////////////////////////////////////
		for (int i = 0; i < 120; i++) {
			if (Distancia(i , i + 3) == "Tercera Menor" 
					&& Distancia(i , i + 6) == "Quinta Disminuida"
						&& Distancia(i , i + 8) == "Sexta Menor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]]+"/"+nombreTeclasPresionadas[valorTeclaPresionada[i+8]]+ "Mayor" + "7";
			}
		}
		
		
		/////////////////////MAYOR SEPTIMA SEGUNDA INVERSION/////////////////////////////
		for (int i = 0; i < 120; i++) {
			if (Distancia(i , i + 3) == "Tercera Menor" 
					&& Distancia(i , i+5) == "Cuarta"
						&& Distancia(i , i +9) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]]+"/"+nombreTeclasPresionadas[valorTeclaPresionada[i+5]]+ "Mayor" + "7";
				}
		}
		
		
		/////////////////MAYOR SEPTIMA TERCER INVERSION///////////////////////////////
		/////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < 120; i++) {
			if (Distancia(i, i +2) == "Segunda Mayor" 
					&& Distancia(i , i+6) == "Quinta Disminuida"
						&& Distancia(i , i +9) == "Sexta Mayor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i]]+"/"+nombreTeclasPresionadas[valorTeclaPresionada[i+2]]+ "Mayor" + "7";
				}
		}
		
	
	
		return Acorde;

	}
	public String esMenorSeptima() {

		String Acorde = "";
		for (int i = 0; i < 120; i++) {
			if (Distancia(i + 0, i + 3) == "Tercera Menor" && Distancia(i + 0, i + 7) == "Quinta"
					&& Distancia(i + 0, i + 10) == "Septima Menor") {
				Acorde = nombreTeclasPresionadas[valorTeclaPresionada[i + 0]] + "Menor" + "7";
			}
		
		
		}
		return Acorde;
	}
}
