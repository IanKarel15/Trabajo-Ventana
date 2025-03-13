package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//claves
	private String correoB = "Iankarel@gmail.com";
	private String contraseñaB = "12345";
  
    public Ventana() {
    	
    	//configurcion de JFrame 
        setSize(500, 600);
        setTitle("X");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelLogin();
        //cambiar icono de la ventana
        ImageIcon icono = new ImageIcon("Logo.jpg"); 
        setIconImage(icono.getImage());
        
        //crear JMenu bar
        JMenuBar barraOpciones = new JMenuBar();
        barraOpciones.setSize(400, 20);
        
        //opciones a la vista
        JMenu opcCuenta = new JMenu("Cuenta");
        JMenu opcUsuarios = new JMenu("Usuarios");
        JMenu opcAyuda = new JMenu("Ayuda");
        
        //crear Items de la opc 1 y añadirlos
        JMenuItem itemLogin = new JMenuItem("Login");
        JMenuItem itemRegistro = new JMenuItem("Registro");
        JMenuItem itemRecuperarC = new JMenuItem("Recuperar cuenta");
        
        opcCuenta.add(itemLogin);
        opcCuenta.add(itemRegistro);
        opcCuenta.add(itemRecuperarC);
        
      //crear Items de la opc 2 y añadirlos
        JMenuItem itemAlta = new JMenuItem("Alta");
        JMenuItem itemBaja = new JMenuItem("Baja");
        JMenuItem itemConsultar = new JMenuItem("Consultar");
        
        opcUsuarios.add(itemAlta);
        opcUsuarios.add(itemBaja);
        opcUsuarios.add(itemConsultar);
        
      //crear Items de la opc 3 y añadirlos
        JMenuItem itemCrearUsuario = new JMenuItem("¿Cómo crear un usuario?");
        JMenuItem itemAccederSist = new JMenuItem("¿Cómo acceder al sistema?");
        JMenuItem itemOlvidarContr = new JMenuItem("¿Qué pasa si olvidé mi contraseña?");
        
        opcAyuda.add(itemCrearUsuario);
        opcAyuda.add(itemAccederSist);
        opcAyuda.add(itemOlvidarContr);
        
        //añadir opciones a la barra principal
        barraOpciones.add(opcCuenta);
        barraOpciones.add(opcUsuarios);
        barraOpciones.add(opcAyuda);
        
        //añadirle acciones a los Items
        itemLogin.addActionListener(e -> panelLogin());
        itemRegistro.addActionListener(e -> panelRegistro());
        itemRecuperarC.addActionListener(e -> panelRecuperarC());
        
        itemAlta.addActionListener(e -> panelAlta());
        itemBaja.addActionListener(e -> panelBaja());
        itemConsultar.addActionListener(e -> panelConsultar());
        
        itemCrearUsuario.addActionListener(e -> panelCrearUsuario());
        itemAccederSist.addActionListener(e -> panelAccederSis());
        itemOlvidarContr.addActionListener(e -> panelOlvidarContraseña());
        
        //añadir el Jmenu a la ventana
        setJMenuBar(barraOpciones);

    }

    private void panelLogin() {
    	
    	//crear panel
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.white);
        panelLogin.setLayout(null);
        setContentPane(panelLogin);

        // Etiqueta de título
        JLabel titulo = new JLabel("Iniciar sesión");
        titulo.setBounds(145, 60, 250, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 35));
        panelLogin.add(titulo);

        // label de correo
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 160, 100, 25);
        panelLogin.add(lblCorreo);
        
        // Campo de correo
        JTextField campoCorreo = new JTextField();
        campoCorreo.setBounds(150, 160, 250, 25);
        campoCorreo.setToolTipText("Ingrese su correo");
        panelLogin.add(campoCorreo);

        // label de contraseña
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(50, 210, 100, 25);
        panelLogin.add(lblContrasena);

        // Campo de contraseña
        JPasswordField campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 210, 250, 25);
        campoContrasena.setEchoChar('*');
        campoContrasena.setToolTipText("Ingrese su contraseña");
        panelLogin.add(campoContrasena);

        // CheckBox de recordar contraseña
        JCheckBox chkRecordarContrasena = new JCheckBox("Recordar contraseña");
        chkRecordarContrasena.setBounds(170, 270, 150, 25);
        chkRecordarContrasena.setBackground(Color.WHITE);
        panelLogin.add(chkRecordarContrasena);

        // Boton de inicio de sesion
        JButton botonIS = new JButton("Iniciar sesión");
        botonIS.setBounds(180, 320, 120, 30);
        botonIS.setBackground(Color.green);
        botonIS.setForeground(Color.black);
        panelLogin.add(botonIS);
        
        //crear label de alerta
        JLabel alerta = new JLabel("");
        panelLogin.add(alerta);
        
        
        //Añadir accion al boton
        botonIS.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent accion) {
            String correo = campoCorreo.getText();
            String contraseña = new String(campoContrasena.getPassword());
            
            alerta.setForeground(Color.RED);

            if (correo.isEmpty() && contraseña.isEmpty() ) {
            
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            	alerta.setBounds(140, 360, 250, 25);
                alerta.setText("Por favor, complete todos los campos");
                return;
            
            }
            if (correo.isEmpty() ) {
                
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            	alerta.setBounds(148, 360, 250, 25);
                alerta.setText("Por favor, complete el correo");
                return;
                
            }
            if(contraseña.isEmpty()){
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            	alerta.setBounds(144, 360, 250, 25);
                alerta.setText("Por favor, complete la contraseña");
                return;
                
            }   
            if (correo.equals(correoB) && contraseña.equals(contraseñaB)) {
            	
            	panelCuenta();
            	
            }

            else {
            	campoCorreo.setBorder(BorderFactory.createLineBorder(Color.red,2));
            	campoContrasena.setBorder(BorderFactory.createLineBorder(Color.red,2));
            	alerta.setBounds(150, 360, 250, 25);
                alerta.setText("Correo o contraseña incorrectos");
                return;
                
            }
            }});  
        
        //cambiar alerta
        alerta.setText("");
        
        //boton crear cuenta
        JButton botonCrearCuenta = new JButton("¿No tiene una cuenta? Cree una");
        botonCrearCuenta.setBounds(130, 400, 220, 30);
        botonCrearCuenta.setForeground(Color.BLUE);
        panelLogin.add(botonCrearCuenta);
        
        //añadir Accion al boton
        botonCrearCuenta.addActionListener(e -> panelRegistro());
        
        //Etiqueta de olvido su contrasaeña
        JLabel lblOlvidoContraseña = new JLabel("¿Olvido su contraseña?");
        lblOlvidoContraseña.setBounds(270, 235, 150, 20);
        lblOlvidoContraseña.setFont(new Font("Arial", Font.BOLD, 10));
        lblOlvidoContraseña.setForeground(Color.blue);
        panelLogin.add(lblOlvidoContraseña);
        
        //pintar panel
        revalidate();
        repaint();
        
    }
    
    private void panelRegistro() {
    	
    	//crear panel registro
        JPanel panelRegistro = new JPanel ();
        panelRegistro.setBackground(Color.WHITE);
        panelRegistro.setLayout(null);
        setContentPane(panelRegistro);
        
        //etiqueta de error
        JLabel error = new JLabel();
        error.setForeground(Color.RED);
        panelRegistro.add(error);
        
        //label de crear cuenta
        JLabel lblCrearC = new JLabel ("Crear cuenta");
        lblCrearC.setBounds(136, 20, 250, 40);
        lblCrearC.setFont(new Font("Arial", Font.BOLD, 35));
        panelRegistro.add(lblCrearC);

        //label de nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 100, 25);
        panelRegistro.add(lblNombre);
        
        //campo para el nombre
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(130, 100, 250, 25);
        campoNombre.setToolTipText("Ingrese su nombre");
        panelRegistro.add(campoNombre);
        
        //label para la descripcion
        JLabel lblBio = new JLabel("Descripcion:");
        lblBio.setBounds(50, 150, 100, 25);
        panelRegistro.add(lblBio);
        
        //campo para la descripcion
        JTextArea campoDes = new JTextArea();
        campoDes.setBounds(130, 150, 250, 90);
        campoDes.setToolTipText("Ingrese su descripcion");
        campoDes.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panelRegistro.add(campoDes);
        
        //label lista de ubicaciones
        JLabel lblUbi = new JLabel("Ubicacion:");
        lblUbi.setBounds(50, 320, 100, 25);
        panelRegistro.add(lblUbi);
        
        //lista de ubicaciones
        String [] ubicaciones ={"Camino real","Progreso", "Pueblo nuevo"};
        JComboBox listaDes = new JComboBox(ubicaciones);
        listaDes.setBounds(130, 320, 250, 25);
        panelRegistro.add(listaDes);
        
        //label de sexo
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 270, 100, 25);
        panelRegistro.add(lblSexo);
        
        //crearRadioButtons del sexo
        
        //Rboton mujer
        JRadioButton btnMujer = new JRadioButton("Mujer",false);
        btnMujer.setBounds(130, 270, 70, 25);
        btnMujer.setOpaque(false);
        panelRegistro.add(btnMujer);
        
        //Rboton hombre
        JRadioButton btnHombre = new JRadioButton("Hombre",false);
        btnHombre.setBounds(210, 270, 70, 25);
        btnHombre.setOpaque(false);
        panelRegistro.add(btnHombre);
        
        //Rboton mucho 
        JRadioButton RBoton3 = new JRadioButton("Mucho xfa",false);
        RBoton3.setBounds(290, 270, 100, 25);
        RBoton3.setOpaque(false);
        panelRegistro.add(RBoton3);
        
        //Crear grupo de botones
        ButtonGroup botonesSexo = new ButtonGroup();
        botonesSexo.add(btnMujer);
        botonesSexo.add(btnHombre);
        botonesSexo.add(RBoton3);
        
        //label de TyC
        JLabel lblTyC = new JLabel("Acepta los terminos y condiciones");
        lblTyC.setBounds(140, 370, 250, 25);
        panelRegistro.add(lblTyC);
        
        //crearRadioButtonsDeTyC 
        
        //Rboton aceptar
        JRadioButton btnAceptar = new JRadioButton("Acepto los terminos",false);
        btnAceptar.setBounds(70, 410, 150, 25);
        btnAceptar.setOpaque(false);
        panelRegistro.add(btnAceptar);
        
        //Rboton no aceptar
        JRadioButton btnNoAceptar = new JRadioButton("No acepto los terminos",false);
        btnNoAceptar.setBounds(240, 410, 170, 25);
        btnNoAceptar.setOpaque(false);
        panelRegistro.add(btnNoAceptar);
        
        //Crear grupo de botones 
        ButtonGroup botonesTyC = new ButtonGroup();
        botonesTyC.add(btnAceptar);
        botonesTyC.add(btnNoAceptar);
        
        //Boton crear cuenta
        JButton botonCrearCuenta = new JButton("Crear cuenta");
        botonCrearCuenta.setBounds(140, 460, 200, 30);
        botonCrearCuenta.setForeground(Color.BLUE);
        panelRegistro.add(botonCrearCuenta);
        
        //añadirle una accion
        botonCrearCuenta.addActionListener(new ActionListener() {
        
        	@Override
        	public void actionPerformed(ActionEvent e) {

        	    String nombre = campoNombre.getText();
        	    String des = campoDes.getText();

        	    if (nombre.isEmpty() && des.isEmpty()) {
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        error.setText("Rellena los datos");
        	        error.setBounds(185, 500, 200, 20);
        	        return;
        	    } else if (nombre.isEmpty() && !des.isEmpty()) {
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        error.setText("Rellena el nombre");
        	        error.setBounds(185, 500, 200, 20);
        	        return;
        	    } else if (des.isEmpty() && !nombre.isEmpty()) {
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        error.setText("Rellena la descripcion");
        	        error.setBounds(175, 500, 200, 20);
        	        return;
        	    } else if (!des.isEmpty() && !nombre.isEmpty()) {
        	        campoDes.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	        campoNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        	    }
        	    
        	    if (!btnMujer.isSelected() && !btnHombre.isSelected() && !RBoton3.isSelected()) {
        	        error.setText("Escoge tu sexo");
        	        error.setBounds(180, 500, 200, 20);
        	        return;
        	    }

        	    if (!btnNoAceptar.isSelected() && !btnAceptar.isSelected()) {
        	        error.setText("Acepta los términos y condiciones");
        	        error.setBounds(130, 500, 200, 20);
        	        return;
        	    }
        	    
        	    panelCuenta();
        	}});
        
      //cambiar alerta
       error.setText("");
  
       //pintar panel
        revalidate();
        repaint(); 
    }
    
    private void panelRecuperarC() {
    	
    	//crear panel
        JPanel panelRecuperarC = new JPanel ();
        panelRecuperarC.setBackground(Color.white);
        panelRecuperarC.setLayout(null);
        setContentPane(panelRecuperarC);
        
        //label de entrada
        JLabel etiquetaRC = new JLabel ("Recuperar cuenta");
        etiquetaRC.setBounds(70, 240, 350, 40);
        etiquetaRC.setFont(new Font("Arial", Font.BOLD, 30));
        panelRecuperarC.add(etiquetaRC); 
        
        //pintar panel
        revalidate();
        repaint();   
    }
    
    private void panelAlta() {
    	
    	//crear panel
        JPanel panelAlta = new JPanel ();
        panelAlta.setBackground(Color.white);
        panelAlta.setLayout(null);
        setContentPane(panelAlta);
        
        //label de entrada
        JLabel etiquetaAlta = new JLabel ("Dar cuenta de alta");
        etiquetaAlta.setBounds(70, 240, 350, 40);
        etiquetaAlta.setFont(new Font("Arial", Font.BOLD, 30));
        panelAlta.add(etiquetaAlta); 
        
        //pintar panel
        revalidate();
        repaint();   
    }  
    
    private void panelBaja() {
    	
    	//crear panel
        JPanel panelBaja = new JPanel ();
        panelBaja.setBackground(Color.white);
        panelBaja.setLayout(null);
        setContentPane(panelBaja);
        
        //label de entrada
        JLabel etiquetaBaja = new JLabel ("Dar cuenta de baja");
        etiquetaBaja.setBounds(70, 240, 350, 40);
        etiquetaBaja.setFont(new Font("Arial", Font.BOLD, 30));
        panelBaja.add(etiquetaBaja); 
        
        //pintar panel
        revalidate();
        repaint();   
    }  
    
    private void panelConsultar() {
    	
    	//crear panel
    	JPanel panelConsultar = new JPanel ();
    	panelConsultar.setBackground(Color.LIGHT_GRAY);
    	panelConsultar.setLayout(null);
     	setContentPane(panelConsultar);
     	
     	//Label usuarios
     	JLabel usuarios = new JLabel ("Usuarios");
     	usuarios.setBounds(170, 30, 150, 40);
     	panelConsultar.add(usuarios);
     	usuarios.setFont(new Font("Arial", Font.BOLD, 30));
     	
     	//Label  total usuarios
     	JLabel totalUsuarios = new JLabel ("Total de usuarios");
     	totalUsuarios.setBounds(20, 80, 200, 40);
     	panelConsultar.add(totalUsuarios);
     	totalUsuarios.setBackground(Color.BLACK);
     	totalUsuarios.setForeground(Color.WHITE);
     	totalUsuarios.setFont(new Font("Arial", Font.BOLD, 20));
     	
     	//Label numero d usuarios
     	JLabel numUsuarios = new JLabel ("100");
     	numUsuarios.setBounds(60, 120, 150, 40);
     	panelConsultar.add(numUsuarios);
     	numUsuarios.setBackground(Color.BLACK);
     	numUsuarios.setForeground(Color.WHITE);
     	numUsuarios.setFont(new Font("Arial", Font.BOLD, 30));
     	
     	//arreglo de string para las columnas
     	String[] columnNames = {"First Name",
                 "Last Name",
                 "Sport",
                 "# of Years",
                 "Vegetarian"};
     	
     	//arreglo para los datos
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
            		"Knitting", 94, false}
     		};
     	
     	//crear JTable y scrollPane
     	JTable table = new JTable(data, columnNames);
     	JScrollPane scrollPane = new JScrollPane(table);
     	table.setFillsViewportHeight(true);
     	scrollPane.setBounds(30, 280, 430, 200);
     	panelConsultar.add(scrollPane);
     	
     	//repintar
     	revalidate();
     	repaint();    
    }  
    
    private void panelCrearUsuario() {
    	
    	//crear panel
        JPanel panelCrearUsuario = new JPanel ();
        panelCrearUsuario.setBackground(Color.white);
        panelCrearUsuario.setLayout(null);
        setContentPane(panelCrearUsuario);
        
        //label de entrada
        JLabel etiquetaCrearU = new JLabel ("¿Cómo crear un usuario?");
        etiquetaCrearU.setBounds(70, 240, 350, 40);
        etiquetaCrearU.setFont(new Font("Arial", Font.BOLD, 30));
        panelCrearUsuario.add(etiquetaCrearU); 
        
        //pintar panel
        revalidate();
        repaint();   
    }  
    
    private void panelAccederSis() {
    	
    	//crear panel
        JPanel panelAccederSis = new JPanel ();
        panelAccederSis.setBackground(Color.white);
        panelAccederSis.setLayout(null);
        setContentPane(panelAccederSis);
        
        //label de entrada
        JLabel etiquetaAccederSis = new JLabel ("¿Cómo acceder al sistema?");
        etiquetaAccederSis.setBounds(70, 240, 350, 40);
        etiquetaAccederSis.setFont(new Font("Arial", Font.BOLD, 30));
        panelAccederSis.add(etiquetaAccederSis); 
        
        //pintar panel
        revalidate();
        repaint();   
    }  
    
    private void panelOlvidarContraseña() {
    	
    	//crear panel
        JPanel panelOlvidarContraseña = new JPanel ();
        panelOlvidarContraseña.setBackground(Color.white);
        panelOlvidarContraseña.setLayout(null);
        setContentPane(panelOlvidarContraseña);
        
        //label de entrada
        JLabel etiquetaOlvidarC = new JLabel ("¿Qué pasa si olvidé mi contraseña?");
        etiquetaOlvidarC.setBounds(70, 240, 350, 40);
        etiquetaOlvidarC.setFont(new Font("Arial", Font.BOLD, 30));
        panelOlvidarContraseña.add(etiquetaOlvidarC); 
        
        //pintar panel
        revalidate();
        repaint();   
    }  
    
    private void panelCuenta() {
    	
    	//crear panel
        JPanel panelCuenta = new JPanel ();
        panelCuenta.setBackground(Color.white);
        panelCuenta.setLayout(null);
        setContentPane(panelCuenta);
        
        //label de bienvenida
        JLabel etiquetaC = new JLabel ("Bienvenido a tu cuenta ");
        etiquetaC.setBounds(70, 240, 350, 40);
        etiquetaC.setFont(new Font("Arial", Font.BOLD, 30));
        panelCuenta.add(etiquetaC); 
        
        //pintar panel
        revalidate();
        repaint();   
    }

    public static void main(String[] args) {
        
    	 Ventana ventana = new Ventana();
    	 ventana.setVisible(true);
    }
}