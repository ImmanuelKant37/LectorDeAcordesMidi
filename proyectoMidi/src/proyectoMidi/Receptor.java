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

public class Receptor extends acordes implements Receiver {
	private static final long serialVersionUID = 1L;

	ArrayList <Integer> Valores = new ArrayList<>(); 
	
	
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

	
	@Override
	public void close() {}
	

	@Override
	public void send(MidiMessage message, long tiempo) {

		numeroDeNota = (int) (message.getMessage()[1] & 0xFF);
		condicionalPulsada = (int) (message.getMessage()[0] & 0xFF);

		notaOfNotaOn();

	}

}
