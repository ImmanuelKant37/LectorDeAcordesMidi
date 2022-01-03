package proyectoMidi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Eventos  implements ActionListener, MouseListener {
private int a=0;
private int b=0;
private int c=0;
ventanaConfig VC= new ventanaConfig();

public Eventos (int a)  throws IOException {
	
	this.a=a;
	}
public void setearConfig() {
	
}
public Eventos (int a, int b)  throws IOException {
	this.b=b;
}
public Eventos (int c,int a, int b)  throws IOException {
	this.c=c;
}
public void actionPerformed(ActionEvent Event) {
	System.out.println(a);
	System.out.println(b);
	System.out.println(c);
}
@Override
public void mouseClicked(MouseEvent e) {
VC.iniciar();
}
@Override
public void mousePressed(MouseEvent e) {

	
}
@Override
public void mouseReleased(MouseEvent e) {
	
}
@Override
public void mouseEntered(MouseEvent e) {
	
}
@Override
public void mouseExited(MouseEvent e) {

}
}
                                                                                                                                   