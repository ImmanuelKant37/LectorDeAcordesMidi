package proyectoMidi;

import java.io.IOException;

public class ventanaPrincipal{
	MIDI midi = new MIDI();
	public ventanaPrincipal() {
MIDI.mostrarDispositivo(5);
midi.abrirMidi(5);
	}
	
	public static void main(String[] args) {
	
		ventanaPrincipal v = new ventanaPrincipal();
		
		//////////////VARIACION 1

	}

}
