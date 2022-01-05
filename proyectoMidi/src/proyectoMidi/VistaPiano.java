package proyectoMidi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class VistaPiano extends vistas implements ActionListener{
	String[] rutas = new String[100];
	File file = new File("src/config/");
	File[] archivos = new File[100];
	String ruta = this.getClass().getClassLoader().getResource("").getPath();
	JScrollPane Scroll = new JScrollPane();
	
	JButton Aceptar = new JButton("Aceptar");
	JButton Nuevo = new JButton("Nuevo");
	JButton Eliminar = new JButton("Eliminar");
	public DefaultListModel<String> listaPresets = new DefaultListModel<String>();
	JList directorios = new JList(listaPresets);

	int[] pX = new int[100];
	int[] pY = new int[100];
	public String insActual="";

	public VistaPiano() throws IOException {
		archivo();		
	}
	public void archivo() {
		
		Aceptar.setBounds(700, 600, 80, 30);
		Nuevo.setBounds(800,600, 80, 30);
		Eliminar.setBounds(900,600, 80, 30);
		
		Scroll.setViewportView(directorios);
		Scroll = new JScrollPane(directorios);

		archivos = file.listFiles();
		int cantidad = file.list().length;
		
		System.out.println(cantidad);
		for (int i = 0; i < cantidad; i++) {
			rutas[i] = archivos[i].getName();
			listaPresets.add(i , rutas[i]);
			System.out.println(rutas[i]);
		}
		

		Scroll.setBounds(0, 0, 0, 0);
		directorios.setBounds(700, 400, 300, 200);
		Aceptar.addActionListener(this);
		form.add(Nuevo);
		form.add(Eliminar);
		form.add(Aceptar);	
		form.add(Scroll);
		form.add(directorios);
	}
	public void posicionesINICIAL() {
		
		for (int i = 0; i < 100; i++) {
			pX[i] = 865;
			pY[i] = 0;
		}

	}

	public void editarArchivos() throws IOException {
	int index= directorios.getSelectedIndex();
	
	BufferedWriter writer= new BufferedWriter(new FileWriter(archivos[index]));
	BufferedReader lector = new BufferedReader(new FileReader(archivos[index]));

if(lector.readLine()==null) {
		for (int i = 0; i < pX.length; i++) {
		String numero= Integer.toString(pX[i])+"\n";
		System.out.println(numero);
	
			writer.write(numero);
		
		}
		for (int i = 0; i < pY.length; i++) {
			String numero= Integer.toString(pY[i])+"\n";
			writer.write(numero);
		}
}
if(directorios.getSelectedIndex()!=-1) {
	insActual= listaPresets.get(directorios.getSelectedIndex());
	form.setTitle(insActual);
	}

	writer.close();
lector.close();
	}
	public void leerPosiciones(){
		try {
			int[] posx= new int[100];
			int[] posy= new int[100];
			int index= directorios.getSelectedIndex();
			BufferedReader lector = new BufferedReader(new FileReader(archivos[index]));
			
		if (index==1) {
			for (int i = 0; i <100; i++) {
				posx[i]=Integer.parseInt(lector.readLine());
				
			}
			for (int i = 0; i <100; i++) {
				posy[i]=Integer.parseInt(lector.readLine());	
				System.out.println(posy[i]);
				}
			for (int i = 0; i < 100; i++) {
				int numerin=posx[i];
				pX[i]=numerin;
			
		}
			for (int i = 0; i < 100; i++) {
				int numerin=posy[i];
				pY[i]=numerin;

			}
			}
		posicionesNotasPiano();
		}
		catch(IOException e) {
			System.out.print(e.getMessage());
		}
		}
	public void posiciones() throws IOException {
		
		if(directorios.getSelectedIndex()!=-1) {
			insActual= listaPresets.get(directorios.getSelectedIndex());
			System.out.println(insActual);
			form.setTitle(insActual);
			}
		
		// POSICIONES NOTA X
	
	}

	{

		form.menu("Archivo", 3);
		try {
			form.menuItem[0].addMouseListener(new Eventos(3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posicionesINICIAL();
		posiciones();
		form.label("", 100, pX[0], pY[0], 100, 100);

		resetStringNombres();
		posicionesNotasPiano();

		form.label[0].setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[1].setFont(new Font("Serif", Font.PLAIN, 40));
		lblAcordeDim.setFont(new Font("Serif", Font.PLAIN, 40));
		form.label[0].setText("+");
		form.label[1].setText("-");
		lblAcordeDim.setText("DIM");
		nombreNota.setBounds(800,0,100,100);
		nombreNota.setText("Nota extra: ");
		form.add(lblAcordeDim);
		form.add(nombreNota);
		form.label[0].setBounds(450, 400, 500, 200);
		lblAcordeDim.setBounds(250,  400,500,200);
		form.label[1].setBounds(50, 400, 500, 200);
		form.imagen("src/img/Piano.jpg",-190,0, 1000,400);
		try {
			System.out.println("Resize verificado");
		resizeImagen("src/img/Piano.jpg","src/img/piano.jpg",600,800);
		}
		catch(Exception e) {
			 System.out.println(e.getMessage());
			 System.out.println("Error en resize");
		}
	}
	
	public void posicionesNotasPiano() {
		
		///OCTAVA 4
	
		for (int i = 0; i <24; i++) {
			form.label[48+i].setBounds(pX[48+i],pY[48+i],50,200);
		}
		form.label[49].setForeground(Color.WHITE);// DO# Color
		form.label[51].setForeground(Color.WHITE);// RE# Color
		form.label[54].setForeground(Color.WHITE);// FA# Color
		form.label[56].setForeground(Color.WHITE);// SOL# Color
		form.label[61].setForeground(Color.WHITE);// DO# Color
		form.label[58].setForeground(Color.WHITE);// LA# Color
		form.label[66].setForeground(Color.WHITE);// FA# Color
		form.label[63].setForeground(Color.WHITE);// RE# Color
		form.label[68].setForeground(Color.WHITE);// SOL# Color
		form.label[70].setForeground(Color.WHITE);// LA# Color
	

	}
	
	public void resetStringNombres() {
		for (int i = 0; i < 150; i++) {
			nombreTeclasPresionadas[i] = "";
		}
		for (int i = 0; i < 150; i++) {
			valorTeclaPresionada[i] = 0;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		leerPosiciones();
		
	}
	

	


}
