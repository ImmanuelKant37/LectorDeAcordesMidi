package proyectoMidi;

public class acordes extends vistas{
public acordes() {}
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
