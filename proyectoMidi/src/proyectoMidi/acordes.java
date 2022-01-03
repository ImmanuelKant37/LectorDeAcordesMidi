package proyectoMidi;

import java.util.ArrayList;
import java.util.Collections;

public class acordes extends VistaPiano{
	
	public Boolean Unisono=false, SegundaMenor=false, SegundaMayor=false,
			TerceraMenor=false, TerceraMayor=false, Cuarta=false, QuintaDisminuida=false, 
			Quinta=false, SextaMenor=false, SextaMayor=false, SeptimaMenor=false, SeptimaMayor=false;

	public String bajo;

	public acordes() {
}
	public String Nota="";
	public String Nota(int nota) {
		try {
		Nota=nombreTeclasPresionadas[notasEncontradas.get(nota)];
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return Nota;
	}


public void notaOfNotaOn() {
	String acorde = "";


	if (condicionalPulsada == 144) {
	
		nPulsadas[cantidadNotasPulsadas]=numeroDeNota;
		notasEncontradas.add(numeroDeNota);////NOTAS ENCONTRADAS VALORES
		Collections.sort(notasEncontradas);
	
		cantidadNotasPulsadas++;
		for (int ite = 0; ite < 12; ite++) {
			verificarNotas(ite);
			devuelveNotasON();
		}
		System.out.println("Valores de la lista: ");
		for(int i=0; i<cantidadNotasPulsadas; i++) {
			System.out.print(notasEncontradas.get(i)+" ");

		System.out.print("nombre: "+ nombreTeclasPresionadas[notasEncontradas.get(i)]+" ");
		System.out.println("i: "+i);
		}
		if(cantidadNotasPulsadas ==2) {
			int numero=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(1));
			distanciasEncontradas[0]=Distancias[numero];
			System.out.println("Dos Notas: "+notasEncontradas.get(0)+" ");
			System.out.println(notasEncontradas.get(1));
			System.out.println(Distancias[numero]);
			System.out.println("Resta de primer distancia: "+numero);
			bajo=nombreTeclasPresionadas[notasEncontradas.get(0)];
		}
		System.out.println();
		form.label[1].setText("");
		form.label[0].setText("");
		
		
		if (cantidadNotasPulsadas >= 3) {
			Collections.sort(notasEncontradas);
			int numero2=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(1));
			int numero=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(2));
		
			distanciasEncontradas[0]=Distancias[numero];
			distanciasEncontradas[1]=Distancias[numero2];
			bajo=nombreTeclasPresionadas[notasEncontradas.get(0)];
			System.out.println("Dos Notas: "+notasEncontradas.get(1)+" ");
			System.out.println(notasEncontradas.get(2)+" ");
			System.out.println(distanciasEncontradas[0]+" "+distanciasEncontradas[1]+" ");

			form.label[0].setText("");
			form.label[0].setText(esMayor());
		
		form.label[1].setText("");
	
		lblAcordeDim.setText("");
		
		lblAcordeDim.setText(esDisminuido());
		form.label[1].setText(esMenor()); 
		}
		
		if (cantidadNotasPulsadas == 4) {
			Collections.sort(notasEncontradas);
			int numero1=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(1));
			int numero2=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(2));
		
			int numero3=Math.abs(notasEncontradas.get(0)-notasEncontradas.get(3));

			distanciasEncontradas[0]=Distancias[numero1];
			distanciasEncontradas[1]=Distancias[numero2];
		distanciasEncontradas[2]=Distancias[numero3];
		bajo=nombreTeclasPresionadas[notasEncontradas.get(0)];
		System.out.println("Dos Notas: "+notasEncontradas.get(1)+" ");
		System.out.println(notasEncontradas.get(2)+" ");
		System.out.println(distanciasEncontradas[0]+" "+distanciasEncontradas[1]+" "+distanciasEncontradas[2]+" ");

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
			form.label[0].setText(esMayor());
			form.label[1].setText("");
			form.label[0].setText("");
		}
		System.out.println("FORMASTE:" + Acorde);
		System.out.println(" Teclas presionadas: " + cantidadNotasPulsadas);

	}

	if (condicionalPulsada == 128) {
		Collections.sort(notasEncontradas);
		cantidadNotasPulsadas--;
		distanciasEncontradas[cantidadNotasPulsadas]="";
		nSoltada = numeroDeNota;
		notasEncontradas.remove(cantidadNotasPulsadas);
	
	
		for(int ite=0; ite<12;ite++) {
		verificarNotaSuelta(ite);
		devuelveNotaOFF();
		}
		form.label[1].setText("");
		form.label[0].setText("");
		lblAcordeDim.setText(esDisminuido());
		form.label[0].setText(esMayor());
		form.label[1].setText(esMenor());
	
	
	
		if (cantidadNotasPulsadas < 3) {
			form.label[1].setText("");
			form.label[0].setText("");
			
		}

		if (cantidadNotasPulsadas >= 4) {
	
			form.label[1].setText(esMayorSeptima());
		
			form.label[0].setText(esMenorSeptima());
		}
			
		System.out.println(" Teclas presionadas: " + cantidadNotasPulsadas);
	}

}

public void resetDistancias() {
	Unisono=false; 
			SegundaMenor=false;
			SegundaMayor=false;
			TerceraMenor=false;
			TerceraMayor=false;
			Cuarta=false;
			QuintaDisminuida=false;
			Quinta=false;
			SextaMenor=false;
			SextaMayor=false;
			SeptimaMenor=false; 
			SeptimaMayor=false;

	
}
public Boolean Unisono() {
	Unisono=false;
		
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[0]){ 
			Unisono=true;
		}}

	
return Unisono;
}

public Boolean SegundaMenor() {
	
	SegundaMenor=false;
	for(int i= 0; i<distanciasEncontradas.length;i++) {
	if(Distancia(i) == Distancias[1]){ 
		SegundaMenor=true;
	}}

		
	
return SegundaMenor;
}

public Boolean SegundaMayor() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[2]){ 
			SegundaMayor=true;
			}
			
		}

return SegundaMayor;
}

public Boolean TerceraMenor() {
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[3]){ 
			TerceraMenor=true;
		}
	
	}
return TerceraMenor;
}

public Boolean TerceraMayor() {
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[4]){ 
			TerceraMayor=true;
		}
	}

return TerceraMayor;
}

public Boolean Cuarta() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[5]){ 
			Cuarta=true;
		}
		
	}


return Cuarta;
}

public Boolean QuintaDisminuida() {
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[6]){ 
			QuintaDisminuida=true;
		}
	
	}
return QuintaDisminuida;
}

public Boolean Quinta() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[7]){ 
			Quinta=true;
		}
		
	}

return Quinta;
}


public Boolean SextaMenor() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[8]){ 
			SextaMenor=true;
		}
		
	}
return SextaMenor;
}

public Boolean SextaMayor() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[9]){ 
			SextaMayor=true;
		}
		
	}

return SextaMayor;
}

public Boolean SeptimaMenor() {
	
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[10]){ 
			SeptimaMenor=true;
		}
	}

return SeptimaMenor;
}

public Boolean SeptimaMayor() {
	for(int i= 0; i<distanciasEncontradas.length;i++) {
		if(Distancia(i) == Distancias[11]){ 
			SeptimaMayor=true;
		}
	}
return SeptimaMayor;
}
	
	

public String esMayor() {
resetDistancias();
	String Acorde = "";
	if(TerceraMayor()&&Quinta()||TerceraMayor()&&Quinta()&&Unisono()) {	
		Acorde=bajo+" Mayor";
		System.out.println("Acorde de: "+bajo+" Mayor");
	}
	if(TerceraMenor()&&SextaMenor()) {	
		Acorde=bajo+"/"+Nota(2)+" Mayor";
		System.out.println("Acorde de: "+bajo+"/"+Nota(2)+" Mayor");
	}
	if(Cuarta()&&SextaMayor()) {	
		Acorde=bajo+"/"+Nota(1)+" Mayor";
		System.out.println("Acorde de: "+bajo+"/"+Nota(1)+" Mayor");
	}
	return Acorde;
}
			
public String esMenor() {
	resetDistancias();
	String Acorde = "";

	
		if (TerceraMenor() && Quinta()) {
			Acorde = bajo + " Menor";
			System.out.println("Acorde de: "+bajo+" Menor");
		}
		//Primer Inversion
		if (TerceraMayor() && SextaMayor()) {
			Acorde = bajo + "/" +Nota(2) + " Menor";
		}
		//Segunda Inversion
		if (Cuarta() && SextaMenor()) {
			Acorde = bajo + "/" + Nota(1) + " Menor";
		}

	return Acorde;
}
public String esDisminuido() { 
	resetDistancias();
	Acorde = "";
	
		////////////////////////////////SIN INVERSION
		if (TerceraMenor() && QuintaDisminuida()) {
			Acorde = bajo+ " Dim ";
			System.out.println("Estoy en disminuida");
		}
		//////////////////////////////PRIMER INVERSION
		if (TerceraMenor() && SextaMayor()) {
			Acorde = bajo+ "/" +Nota(1)  + "Dim";
		}
		///////////////////////////////SEGUNDA INVERSION
		if (QuintaDisminuida() &&SextaMayor()) {
			Acorde =bajo + "/"+ Nota(2)	+ "Dim ";
		}
		
System.out.println(Acorde);
	return Acorde;

}
public String esMayorSeptima() {
	resetDistancias();
	String Acorde = "";
	//MAYOR SEPTIMA SIN INVERTIR
		if (TerceraMayor() && Quinta() && SeptimaMenor()) {
			Acorde = bajo + "Mayor" + "7";
	}
	///////////////////////MAYOR SEPTIMA PRIMER INVERSION

	
		if (TerceraMenor() && QuintaDisminuida() && SextaMenor()) {
			Acorde = bajo +"/"+Nota(1)+ "Mayor" + "7";
		}
	
	/////////////////////MAYOR SEPTIMA SEGUNDA INVERSION//
		if (TerceraMenor() && Cuarta() && SextaMayor()) {
			Acorde = bajo+"/"+Nota(2)+ "Mayor" + "7";
			}
	
	/////////////////MAYOR SEPTIMA TERCER INVERSION/////
	
		if (SegundaMayor() && QuintaDisminuida()&& SextaMayor()) {
			Acorde = bajo+"/"+Nota(3)+ "Mayor" + "7";
			}
		
	return Acorde;
}
public String esMenorSeptima() {
	resetDistancias();
	String Acorde = "";
	
		if (TerceraMenor() && Quinta() && SeptimaMenor()) {
			Acorde = bajo + "Menor" + "7";
	}
	return Acorde;
}
}
