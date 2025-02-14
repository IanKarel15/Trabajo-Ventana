package ventanas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame {

    private JPanel panel;
    private JLabel etiqueta;

    public Ventana() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(500, 500);
        setTitle("Ventana");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null); 
        this.getContentPane().add(panel);

        etiqueta = new JLabel("1er Etiqueta");
        etiqueta.setBounds(140, 50, 200, 50);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 35));

        panel.add(etiqueta);
    }

    public static void main(String[] args) {
        
    	Ventana v1 = new Ventana();
        v1.setVisible(true);
        
    }
}
