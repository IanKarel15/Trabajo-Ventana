package ventanas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel etiqueta;
    private JTextField campoCorreo;
    private JPasswordField campoContrasena;
    private JButton botonIS;
    private JCheckBox chkRecordarContrasena;
    private JLabel etiqueta2;
    private JLabel etiqueta3;

    public Ventana() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(500, 400);
        setTitle("Login");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent accion) {
        String correo = campoCorreo.getText();
        String contraseña = new String(campoContrasena.getPassword());

        if (correo.isEmpty() || contraseña.isEmpty()) {
        	etiqueta2.setBounds(140, 300, 250, 25);
            etiqueta2.setText("Por favor, complete todos los campos");
            etiqueta2.setForeground(Color.RED);
        } else {
        	etiqueta2.setBounds(170, 300, 250, 25);
            etiqueta2.setText("Inicio de sesion exitoso");
            etiqueta2.setForeground(Color.GREEN);
        }
    }

    private void inicializarComponentes() {
    	
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        this.getContentPane().add(panel);

        // Etiqueta de título
        etiqueta = new JLabel("Iniciar sesión");
        etiqueta.setBounds(150, 20, 250, 40);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(etiqueta);

        // Campo de correo
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 100, 100, 25);
        panel.add(lblCorreo);

        campoCorreo = new JTextField();
        campoCorreo.setBounds(150, 100, 250, 25);
        campoCorreo.setToolTipText("Ingrese su correo");
        panel.add(campoCorreo);

        // Campo de contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 150, 100, 25);
        panel.add(lblContrasena);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 150, 250, 25);
        campoContrasena.setEchoChar('*');
        campoContrasena.setToolTipText("Ingrese su contraseña");
        panel.add(campoContrasena);

        // CheckBox de recordar contraseña
        chkRecordarContrasena = new JCheckBox("Recordar contraseña");
        chkRecordarContrasena.setBounds(170, 200, 150, 25);
        panel.add(chkRecordarContrasena);

        // Boton de inicio de sesion
        botonIS = new JButton("Iniciar sesión");
        botonIS.setBounds(180, 250, 120, 30);
        panel.add(botonIS);
        botonIS.addActionListener(this);
        
        //Etiquet de olvido su contrsaeña
        etiqueta3 = new JLabel("¿Olvido su contraseña?");
        etiqueta3.setBounds(190, 175, 150, 20);
        etiqueta3.setFont(new Font("Arial", Font.BOLD, 10));
        panel.add(etiqueta3);


        // Etiqueta de mensaje
        etiqueta2 = new JLabel("");
        panel.add(etiqueta2);
    }

    public static void main(String[] args) {
        Ventana v1 = new Ventana();
        v1.setVisible(true);
    }
}