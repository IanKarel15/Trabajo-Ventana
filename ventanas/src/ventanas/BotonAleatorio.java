package ventanas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotonAleatorio extends JFrame {

	
	public BotonAleatorio() {
    	
    	//configurcion de JFrame 
        setSize(500, 600);
        setTitle("X");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonAleatorio();
	}
	
	private void botonAleatorio() {
		
		JPanel panel = new JPanel();
		JButton boton1 = new JButton("Click me");
		setContentPane(panel);
		panel.setLayout(null);
		panel.add(boton1);
		boton1.setBounds(190, 250, 100, 30);
		
		boton1.addActionListener(new ActionListener() {
	        
	        public void actionPerformed(ActionEvent accion) {
	        	
	        	int [] arreglo = new int [4];
	        	
	        	Random random = new Random();
	        	arreglo[0] = random.nextInt(500);
	        	arreglo[1] = random.nextInt(600);
	        	arreglo[2] = random.nextInt(50);
	        	arreglo[3] = random.nextInt(40);

	        	JButton botonA = new JButton ("hola");		        	
	        	botonA.setBounds(arreglo[0],arreglo[1],arreglo[2]+50,arreglo[3]+10);
	        	Color colorA =onDraw();
	        	botonA.setBackground(colorA);
	        	panel.add(botonA);
	                
	        	panel.repaint();
	        	panel.revalidate();
	        	
	        	botonA.addActionListener(new ActionListener() {
	    	        
	    	        public void actionPerformed(ActionEvent accion) {
	    	        	
	    	        	Random random = new Random();
	    	        	double hola = random.nextInt(1000000000);
	    	       
	    	        	JOptionPane.showMessageDialog(null, hola);   
	    	        	
	    	        	
	    	        	
	    	        	
	    	            }});
	        	
	        	panel.repaint();
	        	panel.revalidate();
	        	
	            }});
		}
	
	public Color onDraw() {
		
	    Random r = new Random();
	    Color randomColor = new Color( r.nextInt(256), r.nextInt(256), r.nextInt(256) );
	    return randomColor;
	}
	
	
	public static void main(String[] args) {
        
	BotonAleatorio ventana = new BotonAleatorio();
   	 ventana.setVisible(true);
   }
}
