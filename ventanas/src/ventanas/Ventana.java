package ventanas;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

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
    private String correoB = "2";
    private String contraseñaB = "1";

    public Ventana() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(1000, 600);
        setTitle("Iniciar sesion");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent accion) {
        String correo = campoCorreo.getText();
        String contraseña = new String(campoContrasena.getPassword());

        if (correo.isEmpty() || contraseña.isEmpty()) {
        	etiqueta2.setBounds(140, 360, 250, 25);
            etiqueta2.setText("Por favor, complete todos los campos");
            etiqueta2.setForeground(Color.RED);
        } else if (correo.equals(correoB) && contraseña.equals(contraseñaB) ){
        	etiqueta2.setBounds(170, 360, 250, 25);
            etiqueta2.setText("Inicio de sesion exitoso");
            etiqueta2.setForeground(Color.GREEN);
            botonIS.addActionListener(e -> panelMenu());
            
        }
        else {
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
        
        JLabel imagen = new JLabel (new ImageIcon ("Logo.jpg"));
        imagen.setBounds(470,30, 500, 500);
        panel.add(imagen);
        
        JLabel fondo = new JLabel();
        fondo.setBounds(450, 0, 600, 600);
        fondo.setBackground(Color.BLACK);
        fondo.setOpaque(true);
        panel.add(fondo);
        

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
        
        /*//Boton calculadora 
        
        JButton botonCal = new JButton("Calculadora");
        botonCal.setBounds(140, 460,200, 30);
        panel.add(botonCal);
        botonCal.addActionListener(e -> panelCalculadora());*/
        
        // Etiqueta de mensaje
        etiqueta2 = new JLabel("");
        panel.add(etiqueta2);
        
        setContentPane(panel);
        revalidate();
        repaint();
        
    }
    
    private void panelRegistro() {
    	
        registro = new JPanel ();
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
        
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(130, 100, 250, 25);
        campoNombre.setToolTipText("Ingrese su nombre");
        registro.add(campoNombre);
        
        JLabel lblBio = new JLabel("Descripcion:");
        lblBio.setBounds(50, 150, 100, 25);
        registro.add(lblBio);
        
        JTextArea campoDes = new JTextArea();
        campoDes.setBounds(130, 150, 250, 90);
        campoDes.setToolTipText("Ingrese su descripcion");
        campoDes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        campoDes.setToolTipText("Ingrese su descripción");
        registro.add(campoDes);
        
        //label lista desplegable
        
        JLabel lblUbi = new JLabel("Ubicacion:");
        lblUbi.setBounds(50, 320, 100, 25);
        registro.add(lblUbi);
        
        //lista desplegable
        String [] ubicaciones ={"Camino real","Progreso", "Pueblo nuevo"};
        JComboBox listaDes = new JComboBox(ubicaciones);
        listaDes.setBounds(130, 320, 250, 25);
        registro.add(listaDes);
        
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
        botonCrearCuenta1.addActionListener(e -> panelCuenta());
        
        
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
    
    //panel calculadora
    
    /*private void panelCalculadora() {
    	
        JPanel calculadora = new JPanel();
        calculadora.setBackground(Color.BLACK);
        calculadora.setLayout(null);
        setContentPane(calculadora);

        // Pantalla de la calculadora
        JTextField pantalla = new JTextField("0");
        pantalla.setBounds(30, 30, 425, 70);
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 29));
        calculadora.add(pantalla);

        // Botón de "CE"
        JButton botonCE = new JButton("CE");
        botonCE.setBounds(30, 115, 95, 65);
        botonCE.setFont(new Font("Arial", Font.BOLD, 18));
        botonCE.setBackground(Color.LIGHT_GRAY);
        calculadora.add(botonCE);
        
        JPanel espacioVacio = new JPanel();
        espacioVacio.setBounds(140, 115, 315, 65);
        espacioVacio.setBackground(Color.GRAY);
        calculadora.add(espacioVacio);
        
        
        String[][] botones = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
            };

            int x = 30, y = 195;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    JButton boton = new JButton(botones[i][j]);
                    boton.setBounds(x, y, 95, 65);
                    boton.setFont(new Font("Arial", Font.BOLD, 20));
                    boton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
                    if ("/*-+=.".contains(botones[i][j])) {
                        boton.setBackground(new Color(255, 140, 0));
                        boton.setForeground(Color.WHITE);
                    }
                    calculadora.add(boton);
                    x += 110;
                }
                x = 30;
                y += 75;
            }

        // Botón para regresar
        JButton botonBack = new JButton("Salir");
        botonBack.setBounds(30, 510, 80, 30);
        botonBack.setForeground(Color.RED);
        botonBack.addActionListener(e -> inicializarComponentes());
        calculadora.add(botonBack);

        setContentPane(calculadora);
        revalidate();
        repaint();
    }*/
    
    public void panelMenu () {
    	
    	JPanel menu = new JPanel ();
    	menu.setBackground(Color.BLUE);
    	menu.setLayout(null);
    	setContentPane(menu);
    	
    	JLabel usuarios = new JLabel ("Twitter");
    	usuarios.setBounds(170, 30, 150, 40);
    	usuarios.setFont(new Font("Helvetica", Font.BOLD, 45));
    	usuarios.setForeground(Color.WHITE);
    	menu.add(usuarios);
    	
    	
    	JLabel totalUsuarios = new JLabel ("Total de usuarios");
    	totalUsuarios.setBounds(30, 110, 200, 30);
    	menu.add(totalUsuarios);
    	totalUsuarios.setHorizontalAlignment(JTextField.CENTER);
    	totalUsuarios.setOpaque(true);
    	totalUsuarios.setBackground(Color.BLACK);
    	totalUsuarios.setForeground(Color.WHITE);
    	totalUsuarios.setFont(new Font("Arial", Font.BOLD, 20));
    	
    	JLabel numUsuarios = new JLabel ("100");
    	numUsuarios.setBounds(30, 140, 200, 40);
    	menu.add(numUsuarios);
    	numUsuarios.setHorizontalAlignment(JTextField.CENTER);
    	numUsuarios.setBackground(Color.BLACK);
    	numUsuarios.setOpaque(true);
    	numUsuarios.setForeground(Color.WHITE);
    	numUsuarios.setFont(new Font("Arial", Font.BOLD, 30));
    	
    	JButton exportar = new JButton("Exportar");
    	exportar.setBounds(230, 240, 100, 25);
    	menu.add(exportar);
    	
    	JButton importar = new JButton("Importar");
    	importar.setBounds(340, 240, 100, 25);
    	menu.add(importar);
    	
    	String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
    	
    	Object[][] data = {
    		    {"Kathy", "Smith",
    		     "Snowboarding", 19, false},
    		    {"John", "Doe",
    		     "Rowing", 88, true},
    		    {"Sue", "Black",
    		     "Knitting", 94, false},
    		    {"Jane", "White",
    		     "Speed reading",20, true},
    		    {"Joe", "Brown",
    		     "Pool", 30, false},
    		    {"Kathy", "Smith",
        		"Snowboarding", 19, false},
        		{"John", "Doe",
        		 "Rowing", 88, true},
        		{"Sue", "Black",
        		"Knitting", 94, false},
        		{"Jane", "White",
        		"Speed reading",20, true},
        		{"Joe", "Brown",
        		 "Pool", 30, false},
        		{"Sue", "Black",
       		     "Knitting", 94, false},
       		    {"Jane", "White",
       		     "Speed reading",20, true},
       		    {"Joe", "Brown",
       		     "Pool", 30, false},
       		    {"Kathy", "Smith",
           		"Snowboarding", 19, false},
           		{"John", "Doe",
           		 "Rowing", 88, true},
           		{"Sue", "Black",
           		"Knitting", 94, false},
           		{"Jane", "White",
        		"Speed reading",20, true},
        		{"Joe", "Brown",
        		 "Pool", 30, false},
        		{"Sue", "Black",
       		     "Knitting", 94, false},
       		    {"Jane", "White",
       		     "Speed reading",20, true},
       		    {"Joe", "Brown",
       		     "Pool", 30, false},
       		    {"Kathy", "Smith",
           		"Snowboarding", 19, false},
           		{"John", "Doe",
           		 "Rowing", 88, true},
           		{"Sue", "Black",
           		"Knitting", 94, false}
    		};
    	
    	JTable table = new JTable(data, columnNames);
    	JScrollPane scrollPane = new JScrollPane(table);
    	table.setFillsViewportHeight(true);
    	scrollPane.setBounds(30, 300, 430, 200);
    	menu.add(scrollPane);
    	setContentPane(menu);
        revalidate();
        repaint(); 
        
    	}


    public static void main(String[] args) {
        Ventana v1 = new Ventana();
        v1.setVisible(true);
    }
}