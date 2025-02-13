package ventanas;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	public Ventana() {
		
		setSize(500, 500);
        setTitle("Ventana");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args) {
		Ventana v1 = new Ventana();
		
		v1.setVisible(true);
		
	}
}