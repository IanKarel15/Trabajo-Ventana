package ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotonAleatorio extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

    public BotonAleatorio() {
        // Configuración del JFrame
        setSize(500, 600);
        setTitle("Botón Aleatorio");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonAleatorio();
    }

    private void botonAleatorio() {
        panel = new JPanel();
        panel.setLayout(null); 
        setContentPane(panel);

        JButton boton1 = new JButton("Click me");
        boton1.setBounds(190, 250, 100, 30);
        panel.add(boton1);

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
                agregarBotonAleatorio();
            }
        });
    }

    private void agregarBotonAleatorio() {
    	
        Random random = new Random();
        int x = random.nextInt(450); 
        int y = random.nextInt(550);
        int ancho = random.nextInt(50) + 50; 
        int largo = random.nextInt(40) + 10; 
        
        JButton botonA = new JButton("Click me");
        botonA.setBounds(x, y, ancho, largo);
        botonA.setBackground(onDraw());
        botonA.setForeground(onDraw());
        panel.add(botonA);

        panel.revalidate();
        panel.repaint();

        botonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
                int resp = JOptionPane.showConfirmDialog(null, "Desea eliminar el boton?",
                        "Eliminar boton", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                
                if (resp == JOptionPane.YES_OPTION) {
                	panel.remove((JButton) accion.getSource());
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
    }

    public Color onDraw() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    public static void main(String[] args) {
        BotonAleatorio ventana = new BotonAleatorio();
        ventana.setVisible(true);
    }
}
