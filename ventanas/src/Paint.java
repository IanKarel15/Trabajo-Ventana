import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint frame = new Paint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Paint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 481);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 22, 195, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COLORES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 206, 184, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		panel_2.setBounds(10, 239, 174, 151);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 3, 7, 5));
		
		JButton btnBlanco = new JButton();
        btnBlanco.setBackground(Color.WHITE);
        panel_2.add(btnBlanco);

        JButton btnNegro = new JButton();
        btnNegro.setBackground(Color.BLACK);
        panel_2.add(btnNegro);

        JButton btnGris = new JButton();
        btnGris.setBackground(Color.GRAY);
        panel_2.add(btnGris);

        JButton btnAzul = new JButton();
        btnAzul.setBackground(Color.BLUE);
        panel_2.add(btnAzul);

        JButton btnRojo = new JButton();
        btnRojo.setForeground(new Color(0, 64, 0));
        btnRojo.setBackground(Color.RED);
        panel_2.add(btnRojo);

        JButton btnVerde = new JButton();
        btnVerde.setBackground(Color.GREEN);
        panel_2.add(btnVerde);

        JButton btnAmarillo = new JButton();
        btnAmarillo.setBackground(Color.YELLOW);
        panel_2.add(btnAmarillo);

        JButton btnNaranja = new JButton();
        btnNaranja.setBackground(Color.ORANGE);
        panel_2.add(btnNaranja);

        JButton btnRosa = new JButton();
        btnRosa.setBackground(Color.PINK);
        panel_2.add(btnRosa);
        
        JLabel lblHerramientas = new JLabel("HERRAMIENTAS");
        lblHerramientas.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas.setBounds(0, 0, 184, 31);
        panel.add(lblHerramientas);
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(45, 28, 50, 50);
        panel.add(btnNewButton);
        
        ImageIcon icono = new ImageIcon("triangulo.png");
        Image img = icono.getImage();
        btnNewButton.setIcon(new ImageIcon(img));
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBounds(105, 28, 50, 50);
        panel.add(btnNewButton_1);
        
        ImageIcon icono2 = new ImageIcon("menos-linea-recta-horizontal.png");
        Image img2 = icono2.getImage();
        btnNewButton_1.setIcon(new ImageIcon(img2));
  
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setBounds(45, 88, 50, 50);
        panel.add(btnNewButton_2);
        ImageIcon icono3 = new ImageIcon("circulo.png");
        Image img3 = icono3.getImage();
        btnNewButton_2.setIcon(new ImageIcon(img3));
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBounds(105, 88, 50, 50);
        panel.add(btnNewButton_3);
        ImageIcon icono4 = new ImageIcon("cuadrado (1).png");
        Image img4 = icono4.getImage();
        btnNewButton_3.setIcon(new ImageIcon(img4));
        
        JButton btnNewButton_4 = new JButton("Lapiz");
        btnNewButton_4.setBounds(10, 148, 85, 21);
        panel.add(btnNewButton_4);
        
        JButton btnNewButton_4_1 = new JButton("Borrador");
        btnNewButton_4_1.setBounds(99, 148, 85, 21);
        panel.add(btnNewButton_4_1);
        
        JSlider slider = new JSlider();
        slider.setBounds(10, 179, 175, 26);
        panel.add(slider);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(231, 22, 534, 400);
		contentPane.add(panel_1);
	}
}
