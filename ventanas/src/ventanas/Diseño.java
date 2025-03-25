package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Diseño extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diseño frame = new Diseño();
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
	public Diseño() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 352);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));
		
		
		
		JButton [][] botones = new JButton[4][4];
        int contador =1;
        
        for( int fila = 0 ; fila < 4; fila++ )
        {
           
            for( int columna = 0 ; columna < 4; columna++ )
            {
                
                botones[fila][columna] = new JButton( );
                panel_1.add( botones[fila][columna] );
                if (fila == 3 && columna == 3) {
                    botones[fila][columna].setText("");
                } else {
                    botones[fila][columna].setText(String.valueOf(contador)); 
                    contador++; 
                }
            }
         }
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBackground(new Color(128, 255, 0));
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel_2.add(btnReiniciar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel_2.add(btnSalir);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 255));
		panel.add(panel_3, BorderLayout.SOUTH);
	}

}
