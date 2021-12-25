package proyectoMidi;

import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;

public class MIDI  {
	static String listaDispositivos[] = new String[10] ;
	public MIDI() {	
		System.out.println("MIDI Abierto");
	}


	static ArrayList<String> dispo = new ArrayList<String>();
	public static void getDispositivos() {

		MidiDevice.Info[] dispositivos = MidiSystem.getMidiDeviceInfo();
		for (MidiDevice.Info info : dispositivos) {

			try {
				dispo.add(info.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	public static void mostrarDispositivo(int numero) {
		getDispositivos();

	System.out.println(dispo.get(numero).toString());
		
	}
	public static String[] Dispositivos() {

		getDispositivos();
	
		for (int i = 0; i < dispo.size(); i++) {
			listaDispositivos[i] = dispo.get(i);
			
		}
		return listaDispositivos;
	
		
	}
	public void abrirMidi(int numeroDispo) {
		MidiDevice.Info[] dispositivos = MidiSystem.getMidiDeviceInfo();
		try {
			MidiDevice dispMidi = MidiSystem.getMidiDevice(dispositivos[numeroDispo]);
			dispMidi.open();
		
			Transmitter controlador = dispMidi.getTransmitter();
			Receiver receptor = new Receptor();

			
			controlador.setReceiver(receptor);
	System.out.println("Abrir Midi OK");
		
		} catch (Exception e) {
			System.out.println("Error en linea Abrir Midi");
		
		}
		
	}
	public void cerrarMidi(int numeroDispo) {

		MidiDevice.Info[] dispositivos = MidiSystem.getMidiDeviceInfo();
		try {
			MidiDevice dispMidi = MidiSystem.getMidiDevice(dispositivos[numeroDispo]);
			dispMidi.close();
			System.out.println(dispMidi.getDeviceInfo()+"Cerrado");
		} catch (MidiUnavailableException e) {
			System.out.println(e);
		
		}
}
	}
