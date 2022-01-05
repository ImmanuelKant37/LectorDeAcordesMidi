package proyectoMidi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;

public class vistaJuego implements ActionListener {
	String[] n= new String[] {"Do","Si","Sib","La","Lab","Sol","Solb","Fa","Mi","Mib","Re","Reb",
			"Do","Si","La#","La","Sol#","Sol","Fa#","Fa","Mi","Re#","Re","Do#","Do","Do"};
	public int cantidadDeNotas=20;
Form ventana= new Form(false);
JButton inicio = new JButton("Iniciar");
JLabel Llegada= new JLabel("Llegada");
JLabel Tocar= new JLabel("Tocar");
JLabel Salida= new JLabel("Salida");
ArrayList<Nota> listaNotas= new ArrayList<Nota>();

public vistaJuego(boolean iniciar) {
	
	ventana.setVisible(iniciar);
	inicio.setBounds(0,0,100,30);
	inicio.addActionListener(this);

	Llegada.setBounds(200,100,100,100);
	Tocar.setBounds(450,100,100,100);
	Salida.setBounds(700,100,100,100);
	ventana.add(Salida);
	ventana.add(Tocar);
	ventana.add(inicio);
	ventana.add(Llegada);
}
public void listarNotas() {
	agregarNegras(4);
	agregarCorcheas(8);
	agregarBlanca(2);
	Collections.shuffle(listaNotas);
	for(int i=0;i<listaNotas.size();i++) {
		
	listaNotas.get(i).start();
	}
}
public void agregarCorcheas(int cantidad) {

	for (int i = 1; i < cantidad+1; i++) {

		int posX = 0;
		double notaR = Math.random() * 26;
		double tiempoR = 5;
		double alt = Math.random() * 26;
		Nota not = new Nota(n[(int) notaR], posX, (int) tiempoR, (int) notaR, i*10 );
		not.setColor(150, 0, 0);
		listaNotas.add(not);
		
	}

}
public void agregarBlanca(int cantidad) {

	for (int i = 1; i < cantidad+1; i++) {

		int posX = 0;
		double notaR = Math.random() * 26;
		double tiempoR = 5;
		double alt = Math.random() * 26;
		Nota not = new Nota(n[(int) notaR], posX, (int) tiempoR, (int) notaR, i*20 );
		not.setColor(0, 150, 0);
		listaNotas.add(not);
		
	}

}
public void agregarNegras(int cantidad) {

	for (int i = 1; i < cantidad+1; i++) {

		int posX = 0;
		double notaR = Math.random() * 26;
		double tiempoR = 5;
		double alt = Math.random() * 26;
		Nota not = new Nota(n[(int) notaR], posX, (int) tiempoR, (int) notaR, i*15);
		not.setColor(0, 0, 130);
		listaNotas.add(not);
	
	}

}
class Nota extends Thread  {
	
	String nombre="";

	int duracion=0;
	int altura=0;
	int posInicialX=700;
	int x;
	int id= (int) Math.random()*100;
	int r=0,g=0,b=0;
	public Nota(String nombre,int posX,int d,int altura, int x){
		this.x=x;
		this.altura=altura;
		this.nombre=nombre;
		this.duracion=d;
		this.posInicialX-=posX;
	}
	public void setColor(int r,int g, int b) {
		this.r=r;
		this.g=g;
		this.b=b;
	}
	public void Mover() {
		
		JLabel X = new JLabel(nombre);
		int alt=altura*15;
		int posInicialY=200;
		int notaX=posInicialX;
		int notaY=posInicialY;
		ventana.add(X);
		try {
			sleep(x*150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		X.setForeground(new Color(r,g,b));
		Color verde=new Color(0,150,0);
		Color naranja=new Color(250,100,0);
		
		for(int i=0;i<500;i++) {
			
			X.setBounds(notaX-i,notaY+alt,100,100);
		
			if (i>=230&&i<250) {
				X.setForeground(verde);
			}
			if(i>250) {
				X.setForeground(naranja);
				
			}
			
			esperar();
		}
		X.setVisible(false);
	}
	public void esperar() {
		try {
			sleep(duracion*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
	
			Mover();
			
		
	}

}

@Override
public void actionPerformed(ActionEvent e) {
	try {
listarNotas();
	}
	catch(Exception a) {
		System.out.println(a);
	}
System.out.println("Accion iniciada");
	
}

}

