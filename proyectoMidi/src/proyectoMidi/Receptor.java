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

	public Receptor() throws IOException {	
	
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
