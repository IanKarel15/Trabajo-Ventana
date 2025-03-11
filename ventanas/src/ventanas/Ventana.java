package ventanas;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;





public class Ventana extends JFrame implements ActionListener {

	 private JPanel panel;
     private JPanel registro;
     private JLabel etiqueta;
     private JTextField campoCorreo;
     private JPasswordField campoContrasena;
     private JButton botonIS,botonCrearCuenta;
     private JCheckBox chkRecordarContrasena;
     private JLabel etiqueta2;
     private JLabel etiqueta3;
     private String correoB = "Iankarel@gmail.com";
     private String contraseñaB = "12345";
     private JTextField campoNombre;
     private JTextArea campoDes;
     
     
  
    public Ventana() {
    	
    	
        configurarVentana();
       
        
    }
    
    

    private void configurarVentana() {
    	
        setSize(500, 600);
        setTitle("Iniciar sesion");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
        ImageIcon icono = new ImageIcon("Logo.jpg"); 
        setIconImage(icono.getImage());

    }
    
    
    
    

    
    public void actionPerformed(ActionEvent accion) {
        String correo = campoCorreo.getText();
        String contraseña = new String(campoContrasena.getPassword());

        if (correo.isEmpty() && contraseña.isEmpty() ) {
        
        	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        	etiqueta2.setBounds(140, 360, 250, 25);
            etiqueta2.setText("Por favor, complete todos los campos");
            etiqueta2.setForeground(Color.RED);
        }
        if (correo.isEmpty() ) {
            
        	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        	etiqueta2.setBounds(140, 360, 250, 25);
            etiqueta2.setText("Por favor, complete todos los campos");
            etiqueta2.setForeground(Color.RED);
        }
        else if(contraseña.isEmpty()){
        	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
        	etiqueta2.setBounds(140, 360, 250, 25);
            etiqueta2.setText("Por favor, complete todos los campos");
            etiqueta2.setForeground(Color.RED);
        }   
        else if (correo.equals(correoB) && contraseña.equals(contraseñaB)) {
        	
        	panelCuenta();
        }

        else {
        	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.green,2));
        	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.green,2));
        	etiqueta2.setBounds(150, 360, 250, 25);
            etiqueta2.setText("Correo o contraseña incorrectos");
            etiqueta2.setForeground(Color.RED);
        }
    }
    
    

    private void inicializarComponentes() {
    	
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        setLocationRelativeTo(null);
        this.getContentPane().add(panel);

        // Etiqueta de título
        etiqueta = new JLabel("Iniciar sesión");
        etiqueta.setBounds(150, 60, 250, 40);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(etiqueta);

        // Campo de correo
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 160, 100, 25);
        panel.add(lblCorreo);

        campoCorreo = new JTextField();
        campoCorreo.setBounds(150, 160, 250, 25);
        campoCorreo.setToolTipText("Ingrese su correo");
        panel.add(campoCorreo);

        // Campo de contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 210, 100, 25);
        panel.add(lblContrasena);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 210, 250, 25);
        campoContrasena.setEchoChar('*');
        campoContrasena.setToolTipText("Ingrese su contraseña");
        panel.add(campoContrasena);

        // CheckBox de recordar contraseña
        chkRecordarContrasena = new JCheckBox("Recordar contraseña");
        chkRecordarContrasena.setBounds(170, 270, 150, 25);
        chkRecordarContrasena.setBackground(Color.WHITE);
        panel.add(chkRecordarContrasena);

        // Boton de inicio de sesion
        botonIS = new JButton("Iniciar sesión");
        botonIS.setBounds(180, 320, 120, 30);
        botonIS.setBackground(Color.green);
        botonIS.setForeground(Color.black);
        panel.add(botonIS);
        botonIS.addActionListener(this);
        
        //boton crear cuenta
        JButton botonCrearCuenta = new JButton("¿No tiene una cuenta? Cree una");
        botonCrearCuenta.setBounds(130, 400, 220, 30);
        botonCrearCuenta.setForeground(Color.BLUE);
        panel.add(botonCrearCuenta);

        botonCrearCuenta.addActionListener(e -> panelRegistro());
        
        //Etiquet de olvido su contrsaeña
        etiqueta3 = new JLabel("¿Olvido su contraseña?");
        etiqueta3.setBounds(270, 235, 150, 20);
        etiqueta3.setFont(new Font("Arial", Font.BOLD, 10));
        etiqueta3.setForeground(Color.BLUE);
        panel.add(etiqueta3);
        
        
        // Etiqueta de mensaje
        etiqueta2 = new JLabel("");
        panel.add(etiqueta2);
        
        setContentPane(panel);
        revalidate();
        repaint();
        
    }
    
    public void panelRegistro() {
    	
        Container registro = new JPanel ();
        registro.setBackground(Color.WHITE);
        registro.setLayout(null);
        setContentPane(registro);
        
        //boton back
        JButton botonBack = new JButton("Atras");
        botonBack.setBounds(20, 20, 70, 25);
        botonBack.setForeground(Color.RED);
        registro.add(botonBack);
        botonBack.addActionListener(e -> inicializarComponentes());
        
        
        JLabel etiquetaCC = new JLabel ("Crear cuenta");
        etiquetaCC.setBounds(140, 20, 250, 40);
        etiquetaCC.setFont(new Font("Arial", Font.BOLD, 30));
        registro.add(etiquetaCC);

        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 100, 25);
        registro.add(lblNombre);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(130, 100, 250, 25);
        campoNombre.setToolTipText("Ingrese su nombre");
        registro.add(campoNombre);
        
        JLabel lblBio = new JLabel("Descripcion:");
        lblBio.setBounds(50, 150, 100, 25);
        registro.add(lblBio);
        
        campoDes = new JTextArea();
        campoDes.setBounds(130, 150, 250, 90);
        campoDes.setToolTipText("Ingrese su descripcion");
        campoDes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoDes.setToolTipText("Ingrese su descripción");
        registro.add(campoDes);
        
        //label lista desplegable
        
        JLabel lblUbi = new JLabel("Ubicacion:");
        lblUbi.setBounds(50, 320, 100, 25);
        registro.add(lblUbi);
        
        
        //label de Preferencias
        
        JLabel lblPre = new JLabel("Sexo:");
        lblPre.setBounds(50, 270, 100, 25);
        registro.add(lblPre);
        
        //crearRadioButtons
        
        JRadioButton RBoton1 = new JRadioButton("Mujer",false);
        RBoton1.setBounds(130, 270, 70, 25);
        RBoton1.setOpaque(false);
        registro.add(RBoton1);
        
        
        JRadioButton RBoton2 = new JRadioButton("Hombre",false);
        RBoton2.setBounds(210, 270, 70, 25);
        RBoton2.setOpaque(false);
        registro.add(RBoton2);
        
        
        JRadioButton RBoton3 = new JRadioButton("Terreneitor",false);
        RBoton3.setBounds(290, 270, 100, 25);
        RBoton3.setOpaque(false);
        registro.add(RBoton3);
        
        
        //Crear grupo de botones
        
        ButtonGroup botonesSexo = new ButtonGroup();
        botonesSexo.add(RBoton1);
        botonesSexo.add(RBoton2);
        botonesSexo.add(RBoton3);
        
        //label de TyC
        
        JLabel lblTyC = new JLabel("Acepta los terminos y condiciones");
        lblTyC.setBounds(140, 370, 250, 25);
        registro.add(lblTyC);
        
        
        //crearRadioButtonsDeTyC
        
        JRadioButton RBoton4 = new JRadioButton("Acepto los terminos",false);
        RBoton4.setBounds(70, 410, 150, 25);
        RBoton4.setOpaque(false);
        registro.add(RBoton4);
        
        
        JRadioButton RBoton5 = new JRadioButton("No acepto los terminos",false);
        RBoton5.setBounds(240, 410, 170, 25);
        RBoton5.setOpaque(false);
        registro.add(RBoton5);
        
        
        //Crear grupo de botones
        
        ButtonGroup botonesTyC = new ButtonGroup();
        botonesTyC.add(RBoton4);
        botonesTyC.add(RBoton5);
        
        //Boton crear cuenta
        
        JButton botonCrearCuenta1 = new JButton("Crear cuenta");
        botonCrearCuenta1.setBounds(140, 460, 200, 30);
        botonCrearCuenta1.setForeground(Color.BLUE);
        registro.add(botonCrearCuenta1);
        
     
        setContentPane(registro);
        revalidate();
        repaint();
        
        
    }
    
    
    
    private void panelCuenta() {
    	
        JPanel cuenta = new JPanel ();
        cuenta.setBackground(Color.CYAN);
        cuenta.setLayout(null);
        setContentPane(cuenta);
        
        //boton back
        JButton botonBack1 = new JButton("Salir");
        botonBack1.setBounds(20, 20, 70, 25);
        botonBack1.setForeground(Color.RED);
        cuenta.add(botonBack1);
        botonBack1.addActionListener(e -> inicializarComponentes());
        
        
        JLabel etiquetaC = new JLabel ("Bienvenido a Onlyfans ");
        etiquetaC.setBounds(75, 240, 350, 40);
        etiquetaC.setFont(new Font("Arial", Font.BOLD, 30));
        cuenta.add(etiquetaC);

        setContentPane(cuenta);
        revalidate();
        repaint();   
    }

    public static void main(String[] args) {
        
    	 Ventana v1 = new Ventana();
    	 v1.setVisible(true);
    }

	
}