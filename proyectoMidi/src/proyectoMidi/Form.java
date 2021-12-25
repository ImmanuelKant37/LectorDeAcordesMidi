package proyectoMidi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class Form extends JFrame implements ActionListener, ItemListener, ChangeListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DefaultTableModel model;
	public JLabel label[] = new JLabel[20];
	public JTextField input[] = new JTextField[10];
	public JTextArea textArea[] = new JTextArea[10];
	public JList lista;
	public JScrollPane Scroll[] = new JScrollPane[10];
	public JComboBox comboBox[] = new JComboBox[10];
	public JCheckBox checkBox[] = new JCheckBox[10];
	public JRadioButton radioButton[] = new JRadioButton[10];
	public ButtonGroup buttonGroup[] = new ButtonGroup[10];
	public JButton boton[] = new JButton[10];
	public JMenuItem menuItem[] = new JMenuItem[10];
	public JTable miTabla;
	public ImageIcon imagen;

	// Menu superior
	JMenuBar barraMenu;
	public JMenu menu = new JMenu();
	public JLabel lbImagen = new JLabel();

	// Menu Superior

	// ------------COLORES--------------------------------------------//
	Color Azul = new Color(5, 94, 172);
	Color AzulOscuro = new Color(165, 192, 255);
	Color Rojo = new Color(230, 20, 20);
	Color Verde = new Color(20, 240, 20);
	// ------------COLORES--------------------------------------------//

	public void colorDeFondo(int rojo, int verde, int azul) {
		Container fondo = this.getContentPane();
		fondo.setBackground(new Color(rojo, verde, azul));
	}

	public Form() {
		// Barra de Menu//////////////////////
		setBounds(0, 0, 300, 300);
		setVisible(true);
		setLayout(null);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Formulario Abierto");
	}

	public void icono(String ruta) {

	}

	public void menu(String Items, int cant) {

		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		menu = new JMenu("Menu");
		barraMenu.add(menu);

		for (int j = 0; j < cant; j++) {
			String numero = " " + String.valueOf(j);
			menuItem[j] = new JMenu("item " + numero);
			menu.add(menuItem[j]);
			menuItem[j].addActionListener(this);
		}
	}

	public void titulo(String titulo) {
		setTitle(titulo);

	}

	public DefaultListModel modelLista = new DefaultListModel();

	public void lista(int x, int y, int anchoX, int altoY) {

		lista = new JList(modelLista);
		lista.setBounds(x, y, anchoX, altoY);
		add(lista);
		Scroll[1] = new JScrollPane(lista);
		Scroll[1].setBounds(x, y, anchoX, altoY);
		Scroll[1].setViewportView(lista);
		add(Scroll[1]);
	}

	public void AgregarALista(String palabra) {
		modelLista.addElement(palabra);
	}

	public void tabla(int x, int y, int anchoX, int altoY) {

		model = new DefaultTableModel(new String[] { "Item1", "Item2" }, 0);// definimos el objeto tableModel

		miTabla = new JTable(model);// creamos la instancia de la tabla

		model.addColumn("COLUMNA");
		model.addColumn("COLUMNA2");

		model.addRow(new Object[] { "Column1", "Column2" });
		model.addRow(new Object[] { "Column1", "Column2" });
		model.addRow(new Object[] { "Column1", "Column2" });
		model.addRow(new Object[] { "Column1", "Column2" });
		model.addRow(new Object[] { "Column1", "Column2" });

		miTabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		miTabla.getTableHeader().setReorderingAllowed(true);

		miTabla.setBounds(x, y, anchoX, altoY);
		miTabla.setModel(model);

		add(miTabla);

		Container container = miTabla;

		container.setLayout(new BorderLayout());
		container.add(miTabla.getTableHeader(), BorderLayout.PAGE_START);

	}

	public void boton(String palabra, int cantidad, int x, int y, int ancho, int alto) {
		for (int i = 0; i < cantidad; i++) {
			String numero = " " + String.valueOf(i);
			boton[i] = new JButton(palabra + numero);
			boton[i].setBounds(x, (y + i * 50), ancho, alto);
			add(boton[i]);
			boton[i].addActionListener(new Eventos());
		}

	}

	public void label(String palabra, int cantidad, int x, int y, int ancho, int alto) {

		for (int i = 0; i < cantidad; i++) {
			label[i] = new JLabel(palabra);
			label[i].setBounds(x, y + i * 40, ancho, alto);
			add(label[i]);

		}
	}

	public void textArea(String palabra, int cantidad, int x, int y, int ancho, int alto) {
		for (int i = 0; i < cantidad; i++) {
			textArea[i] = new JTextArea(palabra);
			Scroll[i] = new JScrollPane(textArea[i]);
			Scroll[i].setBounds(x, y, ancho, alto);
			add(Scroll[i]);
		}
	}

	public void comboBox(String palabra, int cantidad, int cantidadItems, int x, int y, int ancho, int alto) {
		int i;
		try {
			for (i = 0; i < cantidad; i++) {
				comboBox[i] = new JComboBox();
				comboBox[i].setBounds(x, y + (i * 30), ancho, alto);
				add(comboBox[i]);
				for (int j = 0; j < cantidadItems; j++) {
					String num = String.valueOf(j);
					comboBox[i].addItem(palabra + num);
					comboBox[i].addItemListener(this);
				}
			}
		} catch (Exception ex) {

		}
	}

	public void checkBox(String palabra, int cantidad, int x, int y, int ancho, int alto) {
		for (int i = 0; i < cantidad; i++) {
			String num = " " + String.valueOf(i);
			checkBox[i] = new JCheckBox(palabra + num);
			checkBox[i].setBounds(x, (y + i * 30), ancho, alto);
			checkBox[i].addChangeListener(this);
			add(checkBox[i]);

		}
	}

	public void radioButton(String palabra, int cantidad, int grupo, int x, int y, int ancho, int alto) {
		int i;

		buttonGroup[grupo] = new ButtonGroup();
		for (i = 0; i < cantidad; i++) {

			String num = " " + String.valueOf(i);

			radioButton[i] = new JRadioButton(palabra + num);
			radioButton[i].setBounds(x, (y + i * 25), ancho, alto);
			radioButton[i].addChangeListener(this);
			add(radioButton[i]);

			buttonGroup[grupo].add(radioButton[i]);
		}
	}

	public void input(String palabra, int cantidad, int x, int y, int ancho, int alto) {
		for (int i = 0; i < cantidad; i++) {
			input[i] = new JTextField(palabra);
			input[i].setBounds(x, (y + i * 30), ancho, alto);
			add(input[i]);
		}
	}

	public void imagen(String ruta, int x, int y, int anchoX, int altoY) {
		lbImagen = new JLabel(new ImageIcon(ruta));

		lbImagen.setBounds(x, y, anchoX, altoY);
		add(lbImagen);
	}


	public void actionPerformed(ActionEvent e) {

	}

	public void stateChanged(ChangeEvent e) {

	}

	public void itemStateChanged(ItemEvent e) {

	}
}
