package proyectoMidi;


import java.io.IOException;

import javax.sound.midi.MidiMessage;

import javax.sound.midi.Receiver;


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
