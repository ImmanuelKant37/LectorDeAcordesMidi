package proyectoMidi;

public class acordes extends VistaPiano{
private int st=0;
private String bajo=nombreTeclasPresionadas[valorTeclaPresionada[st]];
private String tonicaEn(int semitono,int nota) {
	
	String tonica=nombreTeclasPresionadas[valorTeclaPresionada[semitono+nota]] ;
	 return tonica;
}
public acordes() {}
public void notaOfNotaOn() {
	String acorde = "";


	if (condicionalPulsada == 144) {
		cantidadNotasPulsadas++;
		nPulsadas[cantidadNotasPulsadas] = numeroDeNota;
		nSoltada = numeroDeNota;
		form.label[1].setText("");
		form.label[0].setText("");
		for (int ite = 0; ite < 12; ite++) {
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


public Boolean segundaMayor() {
	
			boolean es=false;
			for(int i=0;i<9;i++ ) {
			if(Distancia(st + 0, valorRe[i]) == "Segunda Mayor"){
				es=true;
			}
		}
		return es;
		} 
public Boolean terceraMenor() {
	
			boolean es=false;
			for(int i=0;i<9;i++ ) {
			if(Distancia(st + 0, valorMib[i]) == "Tercera Menor"){
				es=true;
			}
		}
		return es;
		} 
public Boolean terceraMayor() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorMi[i]) == "Tercera Mayor"){
		es=true;
	}
}
return es;
} 
public Boolean cuarta() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorFa[i]) == "Cuarta"){
		es=true;
	}
}
return es;
}
public Boolean quintaDisminuida() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorSolb[i]) == "Quinta Disminuida"){
		es=true;
	}
}
return es;
} 
public Boolean quinta() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorSol[i]) == "Quinta"){
		es=true;
	}
}
return es;
} 
public Boolean sextaMenor() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorLab[i]) == "Sexta Menor"){
		es=true;
	}
}
return es;
}
public Boolean sextaMayor() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorLa[i]) == "Sexta Mayor"){
		es=true;
	}
}
return es;
}
public Boolean septimaMenor() {
	boolean es=false;
	for(int i=0;i<9;i++ ) {
	if(Distancia(st + 0, valorSib[i]) == "Septima Menor"){
		es=true;
	}
}
return es;
}

public String esMayor() {

	String Acorde = "";

	for (st = 0; st < 120; st++) {
		if (terceraMayor() && quinta()) {
			Acorde = nombreTeclasPresionadas[valorTeclaPresionada[st]];
			System.out.println(Acorde);
		}
		if (terceraMenor() && sextaMenor() ) {
							Acorde = bajo + "/"
								   + tonicaEn(st,8)+ " Mayor";
							System.out.println(Acorde);
		}
		if (cuarta() && sextaMayor()) {
							Acorde = bajo + "/" 
								   +tonicaEn(st,5) + " Mayor";
		}
	}

	return Acorde;
}
public String esMenor() {

	String Acorde = "";

	for (st = 0; st < 120; st++) {
		if (terceraMenor()
		 && quinta()) {
			Acorde = bajo + " Menor";
		}
		if (cuarta()
		 && sextaMenor()) {
			Acorde = bajo + "/" + tonicaEn(st,5) + " Menor";
		}

		if (terceraMayor() && sextaMayor()) {
			Acorde = bajo + "/" +tonicaEn(st,9) + " Menor";
		}
	}

	return Acorde;

}
public String esDisminuido() {

	String Acorde = "";
		////////////////////////////////SIN INVERSION
	for (st = 0; st < 120; st++) {
		if (terceraMenor()
		 && quintaDisminuida()) {
			Acorde = bajo
			+ 	" Dim ";
		}
		//////////////////////////////PRIMER INVERSION
		if (terceraMenor() && sextaMayor()) {
			Acorde = bajo+ "/" +tonicaEn(st,9)  + "Dim";
		}
		///////////////////////////////SEGUNDA INVERSION
		if (quintaDisminuida() 
		 &&sextaMayor()) {
			Acorde =bajo + "/"+ tonicaEn(st,6)	+ "Dim ";
		}

	

	}
System.out.println(Acorde);
	return Acorde;

}
public String esMayorSeptima() {

	String Acorde = "";
	//MAYOR SEPTIMA SIN INVERTIR
	for (st = 0; st < 120; st++) {
		if (terceraMayor()
				&& quinta()
					&& septimaMenor()) {
			Acorde = bajo + "Mayor" + "7";
		}
	}
	///////////////////////MAYOR SEPTIMA PRIMER INVERSION

	for ( st = 0; st < 120; st++) {
		if (terceraMenor()
				&& quintaDisminuida()
					&& sextaMenor()) {
			Acorde = bajo +"/"+tonicaEn(st,8)+ "Mayor" + "7";
		}
	}
	/////////////////////MAYOR SEPTIMA SEGUNDA INVERSION//
	for (st = 0; st < 120; st++) {
		if (terceraMenor()
				&& cuarta()
					&& sextaMayor()) {
			Acorde = bajo+"/"+tonicaEn(st,5)+ "Mayor" + "7";
			}
	}
	/////////////////MAYOR SEPTIMA TERCER INVERSION/////
	for (st = 0; st < 120; st++) {
		if (segundaMayor() 
				&& quintaDisminuida()
					&& sextaMayor()) {
			Acorde = bajo+"/"+tonicaEn(st,2)+ "Mayor" + "7";
			}
	}
	return Acorde;
}
public String esMenorSeptima() {
	String Acorde = "";
	for (st = 0; st < 120; st++) {
		if (terceraMenor()
				&& quinta()
				&& septimaMenor()) {
			Acorde = bajo + "Menor" + "7";
		}
	}
	return Acorde;
}
}
