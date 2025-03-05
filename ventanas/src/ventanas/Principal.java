package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.List;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.Checkbox;
import java.awt.Label;
import javax.swing.border.LineBorder;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(0, 33, 655, 460);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel_2.setBackground(new Color(128, 255, 255));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Datos generales");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 5, 103, 23);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombres:");
		lblNewLabel_1_1.setBounds(10, 33, 91, 23);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos:");
		lblNewLabel_1_2.setBounds(10, 60, 91, 23);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_3.setBounds(10, 93, 91, 23);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sexo");
		lblNewLabel_1_4.setBounds(10, 118, 91, 23);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nacionalidad");
		lblNewLabel_1_5.setBounds(10, 147, 91, 23);
		panel_2.add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setBounds(106, 35, 147, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 62, 147, 19);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 95, 96, 19);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mujer");
		rdbtnNewRadioButton.setBackground(new Color(128, 255, 255));
		rdbtnNewRadioButton.setBounds(107, 119, 85, 21);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(new Color(128, 255, 255));
		rdbtnHombre.setBounds(191, 119, 103, 21);
		panel_2.add(rdbtnHombre);
		
		ButtonGroup botonesSexo = new ButtonGroup();
        botonesSexo.add(rdbtnHombre);
        botonesSexo.add(rdbtnNewRadioButton);
				
        String [] nacionalidad ={"Mexicana","Peruana", "PuertoRiqueña"};
		JComboBox comboBox = new JComboBox(nacionalidad);
		comboBox.setToolTipText("hola");
		comboBox.setBounds(106, 148, 147, 21);
		panel_2.add(comboBox);
		
		JButton button = new JButton("New button");
		button.setBounds(111, 148, 85, 21);
		panel_2.add(button);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel.setBackground(new Color(255, 128, 128));
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_7 = new JLabel("Perfil de usuario:");
		lblNewLabel_1_7.setBounds(10, 10, 117, 15);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_1_7);
		
		Checkbox checkbox = new Checkbox("Mostrar foto ");
		checkbox.setBounds(37, 160, 90, 21);
		panel.add(checkbox);
		
		Checkbox checkbox_1 = new Checkbox("Mostrar id");
		checkbox_1.setBounds(160, 160, 90, 21);
		panel.add(checkbox_1);
		
		Label label = new Label("Foto");
		label.setEnabled(false);
		label.setAlignment(Label.CENTER);
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(87, 44, 100, 110);
		panel.add(label);
		ImageIcon icono = new ImageIcon("user.png"); 
        setIconImage(icono.getImage());
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel_3.setBackground(new Color(255, 128, 128));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("Datos opcionales");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(10, 10, 123, 23);
		panel_3.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_2 = new JLabel("Preferencias");
		lblNewLabel_2.setBounds(174, 43, 77, 13);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Descripcion");
		lblNewLabel_2_1.setBounds(49, 43, 84, 13);
		panel_3.add(lblNewLabel_2_1);
		
		TextArea textArea = new TextArea();
		textArea.setText("Yo soy pedro \r\npicapiedras \r\ny me gusta\r\nfumar piedra");
		textArea.setBounds(25, 76, 108, 75);
		panel_3.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText("Me gustan las \r\nmentirosas y \r\nmanipuladoras");
		textArea_1.setBounds(154, 76, 108, 75);
		panel_3.add(textArea_1);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		panel_4.setBackground(new Color(128, 255, 255));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(114, 99, 85, 21);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nuevo");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(114, 57, 85, 21);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setBounds(114, 144, 85, 21);
		panel_4.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Menu");
		lblNewLabel_1_6_1.setBounds(10, 10, 91, 23);
		panel_4.add(lblNewLabel_1_6_1);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Registro de Usuarios");
		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 21));
		lblNewLabel.setBounds(10, 2, 186, 28);
		contentPane.add(lblNewLabel);
		revalidate();
	}
}
