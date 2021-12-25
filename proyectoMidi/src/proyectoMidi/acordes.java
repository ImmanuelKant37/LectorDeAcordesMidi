package proyectoMidi;

public class acordes extends VistaPiano{
public acordes() {}
public void notaOfNotaOn() {
	String acorde = "";


	if (condicionalPulsada == 144) {
		cantidadNotasPulsadas++;
		nPulsadas[cantidadNotasPulsadas] = numeroDeNota;
		nSoltada = numeroDeNota;
		form.label[1].setText("");
		form.label[0].setText("");
		for (int ite = 0; ite < 10; ite++) {
			verificarNotas(ite);
			devuelveNotasON(ite);
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
		for(int ite=0; ite<10;ite++) {
		verificarNotaSuelta(ite);
		devuelveNotaOFF(ite);
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
int st=0;
public String esMayor() {

	Acorde = "";
	
	//DESDE DO A MI
	for (st = 0; st < 120; st++) {
		if (Distancia(st + 0, st + 4) == "Tercera Mayor" 
		 && Distancia(st + 0, st + 7) == "Quinta") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]] + " Mayor";
		}
		

		if (Distancia(st + 0, st + 5) == "Cuarta"
		 && Distancia(st + 0, st + 9) == "Sexta Mayor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]] + "/" 
	      + nombreTeclasPresionadas[valorTeclaPresionada[st+5]] + " Mayor";
		}
		if (Distancia(st + 0, st + 3) == "Tercera Menor" 
		 && Distancia(st + 0, st + 8) == "Sexta Menor") {
					Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]] + "/"
						   + nombreTeclasPresionadas[valorTeclaPresionada[st+8]]   + " Mayor";
				}
	}
	//DESDE FA A SOL

	return Acorde;
}
public String esMenor() {

	String Acorde = "";

	for (st = 0; st < 120; st++) {
		if (Distancia(st + 0, st + 3) == "Tercera Menor"
		 && Distancia(st + 0, st + 7) == "Quinta") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]] + " Menor";
		}
		if (Distancia(st + 7, st + 0) == "Cuarta"
		 && Distancia(st + 7, st + 3) == "Sexta Menor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st + 7]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[st]] + " Menor";
		}

		if (Distancia(st + 3, st + 7) == "Tercera Mayor"
		 && Distancia(st + 3, st + 0) == "Sexta Mayor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st + 3]] + "/" + nombreTeclasPresionadas[valorTeclaPresionada[st + 0]] + " Menor";
		}
	}

	return Acorde;

}
public String esDisminuido() {

	String Acorde = "";
		////////////////////////////////SIN INVERSION
	for (st = 0; st < 120; st++) {
		if (Distancia(st + 0, st + 3) == "Tercera Menor"
		 && Distancia(st + 0, st + 6) == "Quinta Disminuida") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]]
			+ 	" Dim ";
		}
		//////////////////////////////PRIMER INVERSION
		if (Distancia(st + 3, st + 6) == "Tercera Menor" 
		 && Distancia(st + 3, st + 0) == "Sexta Mayor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st+3]]
			+ "/" + nombreTeclasPresionadas[valorTeclaPresionada[st+0]] 
			+ "Dim";
		}
		///////////////////////////////SEGUNDA INVERSION
		if (Distancia(st + 6, st + 0) == "Quinta Disminuida" 
		 && Distancia(st + 6, st + 3) == "Sexta Mayor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st+6]] 
			+ "/" + nombreTeclasPresionadas[valorTeclaPresionada[st]]
			+ "Dim ";
		}

	

	}
System.out.println(Acorde);
	return Acorde;

}
public String esMayorSeptima() {

	String Acorde = "";
	
	//MAYOR SEPTIMA SIN INVERTIR
	for (st = 0; st < 120; st++) {
		if (Distancia(st + 0, st + 4) == "Tercera Mayor" 
				&& Distancia(st + 0, st + 7) == "Quinta"
					&& Distancia(st + 0, st + 10) == "Septima Menor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st + 0]] + "Mayor" + "7";
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
	for (st = 0; st < 120; st++) {
		if (Distancia(st + 0, st + 3) == "Tercera Menor" 
				&& Distancia(st + 0, st + 7) == "Quinta"
				&& Distancia(st + 0, st + 10) == "Septima Menor") {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st + 0]] + "Menor" + "7";
		}
	
	
	}
	return Acorde;
}
}
