package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.List;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.Checkbox;
import java.awt.Label;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.Canvas;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txthge;
	private JTextField txtOnixprogreso;
	private JTextField txtJuanPerezLicenciao;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTable table;
	private JTextField textField;

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
		setBounds(100, 100, 520, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 506, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Factura en Java - NetBeans - ArrayList y POO");
		lblNewLabel.setBackground(new Color(0, 128, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 0, 486, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("[Sin base de datos]");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 42, 127, 13);
		panel.add(lblNewLabel_1);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBackground(new Color(255, 255, 255));
        panelCliente.setBorder(BorderFactory.createTitledBorder("Datos del Cliente"));
        panelCliente.setBounds(10, 79, 486, 114);
        contentPane.add(panelCliente);
        panelCliente.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Documento");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 27, 87, 25);
        panelCliente.add(lblNewLabel_2);
        
        txthge = new JTextField();
        txthge.setText("828hg181e");
        txthge.setBounds(93, 31, 125, 19);
        panelCliente.add(txthge);
        txthge.setColumns(10);
        
        txtOnixprogreso = new JTextField();
        txtOnixprogreso.setText("Onix,123,Progreso");
        txtOnixprogreso.setColumns(10);
        txtOnixprogreso.setBounds(93, 63, 125, 19);
        panelCliente.add(txtOnixprogreso);
        
        JLabel lblNewLabel_2_1 = new JLabel("Direccion");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2_1.setBounds(10, 59, 87, 25);
        panelCliente.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_2 = new JLabel("Nombres");
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2_2.setBounds(264, 27, 87, 25);
        panelCliente.add(lblNewLabel_2_2);
        
        JLabel lblNewLabel_2_3 = new JLabel("Telefono");
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2_3.setBounds(264, 59, 87, 25);
        panelCliente.add(lblNewLabel_2_3);
        
        txtJuanPerezLicenciao = new JTextField();
        txtJuanPerezLicenciao.setText("Juan Perez Licenciao");
        txtJuanPerezLicenciao.setColumns(10);
        txtJuanPerezLicenciao.setBounds(345, 30, 125, 19);
        panelCliente.add(txtJuanPerezLicenciao);
        
        textField_3 = new JTextField();
        textField_3.setText("123-1233-123");
        textField_3.setColumns(10);
        textField_3.setBounds(345, 59, 125, 19);
        panelCliente.add(textField_3);
        
        JPanel panelCliente_1 = new JPanel();
        panelCliente_1.setLayout(null);
        panelCliente_1.setBorder(new TitledBorder(null, "Datos de Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelCliente_1.setBackground(Color.WHITE);
        panelCliente_1.setBounds(10, 191, 486, 71);
        contentPane.add(panelCliente_1);
        
        JLabel lblNewLabel_3 = new JLabel("No. Factura ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3.setBounds(32, 30, 112, 13);
        panelCliente_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("123ih4394");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1.setBounds(129, 30, 112, 13);
        panelCliente_1.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("Fecha");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_2.setBounds(237, 30, 112, 13);
        panelCliente_1.add(lblNewLabel_3_2);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("12/03/2008");
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_1.setBounds(328, 31, 112, 13);
        panelCliente_1.add(lblNewLabel_3_1_1);
        
        JPanel panelCliente_1_1 = new JPanel();
        panelCliente_1_1.setLayout(null);
        panelCliente_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelCliente_1_1.setBackground(Color.WHITE);
        panelCliente_1_1.setBounds(10, 264, 486, 30);
        contentPane.add(panelCliente_1_1);
        
        JLabel btnAñadir = new JLabel();
        btnAñadir.setBounds(267, 5, 20, 20);
        ImageIcon icono = new ImageIcon("agregar.png");
        Image img = icono.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        btnAñadir.setIcon(new ImageIcon(img));

        JLabel btnAñadir1 = new JLabel();
        btnAñadir1.setBounds(9, 5, 20, 20);
        ImageIcon icono2 = new ImageIcon("menu-hamburguesa.png");
        Image img2 = icono2.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        btnAñadir1.setIcon(new ImageIcon(img2));

        JLabel btnAñadir2 = new JLabel();
        btnAñadir2.setBounds(360, 5, 20, 20);
        ImageIcon icono3 = new ImageIcon("cruz.png");
        Image img3 = icono3.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        btnAñadir2.setIcon(new ImageIcon(img3));

        panelCliente_1_1.add(btnAñadir);
        panelCliente_1_1.add(btnAñadir1);
        panelCliente_1_1.add(btnAñadir2);
        
        JLabel lblNewLabel_4 = new JLabel("Ver listado de facturas");
        lblNewLabel_4.setBounds(42, 10, 145, 13);
        panelCliente_1_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Añadir");
        lblNewLabel_5.setBounds(303, 10, 45, 13);
        panelCliente_1_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_5_1 = new JLabel("Eliminar");
        lblNewLabel_5_1.setBounds(394, 10, 58, 13);
        panelCliente_1_1.add(lblNewLabel_5_1);

        String[] columnNames = {"Producto", "Cantidad", "Precio", "Total"};
        
        Object[][] data = {
                {"Agua", "12", "15.00", 180},
                {"Cereal", "21", "99.99", 2099.79},
                {"Leche", "10", "25.00", 250},
                {"Pan", "5", "30.00", 150},
                {"Queso", "3", "80.00", 240},
                {"Jabón", "7", "20.00", 140},
                {"Shampoo", "4", "50.00", 200},
                {"Arroz", "8", "35.00", 280},
                {"Frijoles", "6", "40.00", 240},
                {"Galletas", "9", "25.00", 225},
                {"Café", "2", "100.00", 200},
                {"Azúcar", "5", "30.00", 150},
                {"Sal", "4", "20.00", 80},
                {"Aceite", "3", "50.00", 150},
                {"Pasta", "7", "18.00", 126},
                {"Harina", "6", "22.00", 132}
            };
        
        
        JButton btnFinalizar = new JButton("Limpiar");
        btnFinalizar.setBackground(new Color(255, 255, 255));
        btnFinalizar.setBounds(373, 516, 111, 30);
        contentPane.add(btnFinalizar);
        table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 304, 486, 71);
        contentPane.add(scrollPane);
        
        JButton btnFinalizar_1 = new JButton("Finalizar factura");
        btnFinalizar_1.setBackground(new Color(255, 255, 255));
        btnFinalizar_1.setBounds(238, 516, 128, 30);
        contentPane.add(btnFinalizar_1);
        
        JLabel lblNewLabel_3_1_2 = new JLabel("Subtotal");
        lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_2.setBounds(23, 405, 112, 13);
        contentPane.add(lblNewLabel_3_1_2);
        
        JLabel lblNewLabel_3_1_3 = new JLabel("% de descuento");
        lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_3.setBounds(23, 432, 112, 13);
        contentPane.add(lblNewLabel_3_1_3);
        
        JLabel lblNewLabel_3_1_3_1 = new JLabel("IVA 19%");
        lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_3_1.setBounds(23, 460, 112, 13);
        contentPane.add(lblNewLabel_3_1_3_1);
        
        JLabel lblNewLabel_3_1_3_2 = new JLabel("Total factura");
        lblNewLabel_3_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_3_2.setBounds(23, 490, 112, 13);
        contentPane.add(lblNewLabel_3_1_3_2);
        
        JLabel lblNewLabel_3_3 = new JLabel("1299.99");
        lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_3.setBounds(140, 405, 112, 13);
        contentPane.add(lblNewLabel_3_3);
        
        JLabel lblNewLabel_3_4 = new JLabel("129.00");
        lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_4.setBounds(140, 460, 112, 13);
        contentPane.add(lblNewLabel_3_4);
        
        JLabel lblNewLabel_3_5 = new JLabel("1429.99");
        lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_5.setBounds(140, 491, 112, 13);
        contentPane.add(lblNewLabel_3_5);
        
        textField = new JTextField();
        textField.setText("50");
        textField.setBounds(140, 430, 67, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBackground(Color.WHITE);
        chckbxNewCheckBox.setBounds(222, 429, 23, 21);
        contentPane.add(chckbxNewCheckBox);
        
        JLabel lblNewLabel_3_1_3_2_1 = new JLabel("Valor descontado:");
        lblNewLabel_3_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_3_1_3_2_1.setBounds(255, 432, 112, 13);
        contentPane.add(lblNewLabel_3_1_3_2_1);
        
        JLabel lblNewLabel_3_3_2 = new JLabel("650.99");
        lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_3_2.setBounds(370, 432, 112, 13);
        contentPane.add(lblNewLabel_3_3_2);
        
        JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(0, 128, 255));
		panel2.setBounds(0, 575, 516, 86);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
	}
}
