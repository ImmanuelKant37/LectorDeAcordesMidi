package proyectoMidi;

import java.io.IOException;

public class ventanaPrincipal{
	
	MIDI midi = new MIDI();
	public ventanaPrincipal() {
MIDI.mostrarDispositivo(5);
try {
	midi.abrirMidi(5);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
	public static void main(String[] args) throws IOException {
	
		ventanaPrincipal v = new ventanaPrincipal();
		vistaJuego juego= new vistaJuego(true);
		//////////////VARIACION 1

	}

}
