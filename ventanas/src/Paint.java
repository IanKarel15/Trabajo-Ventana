import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;

public class Paint extends JFrame implements MouseListener, MouseMotionListener {
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private PaintPanel panelDibujo;
    private ArrayList<Point> puntos = new ArrayList<>();
    private List<List<Point>> listaDePuntos = new ArrayList<>();
    private Color colorActual = Color.BLACK;
    private ArrayList<Color> coloresArray = new ArrayList<>();
    private ArrayList<Integer> grosores = new ArrayList<>();
    int valor;
    int grosorActual;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Paint frame = new Paint();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Paint() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 727);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 22, 966, 103);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblHerramientas = new JLabel("FORMAS");
        lblHerramientas.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas.setBounds(57, 0, 184, 31);
        panel.add(lblHerramientas);
        
        JButton btnTriangulo = new JButton("");
        btnTriangulo.setBounds(84, 34, 50, 50);
        panel.add(btnTriangulo);

        Image imgTriangulo = new ImageIcon("variante-de-contorno-de-triangulo.png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnTriangulo.setIcon(new ImageIcon(imgTriangulo));
        btnTriangulo.setBorderPainted(false); 
        btnTriangulo.setFocusPainted(false);  
        btnTriangulo.setContentAreaFilled(false);

        btnTriangulo.setHorizontalAlignment(SwingConstants.CENTER);
        btnTriangulo.setVerticalAlignment(SwingConstants.CENTER);


        JButton btnLinea = new JButton("");
        btnLinea.setBounds(144, 34, 50, 50);
        panel.add(btnLinea);
        btnLinea.setBorderPainted(false); 
        btnLinea.setFocusPainted(false);  
        btnLinea.setContentAreaFilled(false);

        Image imgLinea = new ImageIcon("linea-diagonal (1).png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnLinea.setIcon(new ImageIcon(imgLinea));

        btnLinea.setHorizontalAlignment(SwingConstants.CENTER);
        btnLinea.setVerticalAlignment(SwingConstants.CENTER);


        JButton btnCirculo = new JButton("");
        btnCirculo.setBounds(24, 34, 50, 50);
        panel.add(btnCirculo);
        btnCirculo.setBorderPainted(false); 
        btnCirculo.setFocusPainted(false);  
        btnCirculo.setContentAreaFilled(false);
        

        Image imgCirculo = new ImageIcon("registro.png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnCirculo.setIcon(new ImageIcon(imgCirculo));

        btnCirculo.setHorizontalAlignment(SwingConstants.CENTER);
        btnCirculo.setVerticalAlignment(SwingConstants.CENTER);


        JButton btnCuadrado = new JButton("");
        btnCuadrado.setBounds(204, 34, 50, 50);
        panel.add(btnCuadrado);
        btnCuadrado.setBorderPainted(false); 
        btnCuadrado.setFocusPainted(false);  
        btnCuadrado.setContentAreaFilled(false);

        Image imgCuadrado = new ImageIcon("cuadrado (2).png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnCuadrado.setIcon(new ImageIcon(imgCuadrado));

        btnCuadrado.setHorizontalAlignment(SwingConstants.CENTER);
        btnCuadrado.setVerticalAlignment(SwingConstants.CENTER);
        
        JButton btnNewButton_4 = new JButton("Lapiz");
        btnNewButton_4.setBackground(new Color(255, 255, 255));
        btnNewButton_4.setBounds(390, 32, 85, 21);
        btnNewButton_4.setFocusPainted(false);  

        panel.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cambiarColor(Color.BLACK);
		    }
		});
        
        JButton btnNewButton_4_1 = new JButton("Borrador");
        btnNewButton_4_1.setBackground(new Color(255, 255, 255));
        btnNewButton_4_1.setBounds(390, 63, 85, 21);
        btnNewButton_4_1.setFocusPainted(false);  

        panel.add(btnNewButton_4_1);
        btnNewButton_4_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cambiarColor(Color.WHITE);
		    }
		});
        
        JSlider slider = new JSlider(0, 30, 2);
        slider.setBackground(new Color(255, 255, 255));
        slider.setBounds(500, 42, 175, 26);
        panel.add(slider);
        
        slider.addChangeListener(new ChangeListener() {  
            public void stateChanged(ChangeEvent e) {  
                int valor = ((JSlider) e.getSource()).getValue();  
                cambiarGrosor(valor);
                
            }  
        }); 
        
        

        JLabel lblColores = new JLabel("COLORES");
        lblColores.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblColores.setHorizontalAlignment(SwingConstants.CENTER);
        lblColores.setBounds(738, 0, 184, 31);
        panel.add(lblColores);

        JPanel panelColores = new JPanel(new GridLayout(3, 3, 7, 5));
        panelColores.setBackground(new Color(255, 255, 255));
        panelColores.setBorder(UIManager.getBorder("Button.border"));
        panelColores.setBounds(710, 30, 235, 62);
        panel.add(panelColores);
        
        JButton btnNewButton_4_2 = new JButton("Limpiar");
        btnNewButton_4_2.setBackground(new Color(255, 255, 255));
        btnNewButton_4_2.setBounds(288, 32, 85, 21);
        btnNewButton_4_2.setFocusPainted(false);  
        panel.add(btnNewButton_4_2);
        btnNewButton_4_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        puntos.clear();;
		        listaDePuntos.clear();;
		        coloresArray.clear();
		        grosores.clear();;
		        repaint();
		    }
		});
        
        JButton btnNewButton_4_2_1 = new JButton("Atras");
        btnNewButton_4_2_1.setBackground(new Color(255, 255, 255));
        btnNewButton_4_2_1.setBounds(288, 63, 85, 21);
        btnNewButton_4_2_1.setFocusPainted(false);  

        panel.add(btnNewButton_4_2_1);
        btnNewButton_4_2_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        int i = listaDePuntos.size() - 1;
	            listaDePuntos.remove(i);
	            coloresArray.remove(i);
	            grosores.remove(i);
		        repaint();
		    }
		});
        
        JLabel lblHerramientas_1 = new JLabel("HERRAMIENTAS");
        lblHerramientas_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas_1.setBounds(291, 0, 184, 31);
        panel.add(lblHerramientas_1);
        
        JLabel lblHerramientas_1_1 = new JLabel("GROSOR");
        lblHerramientas_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas_1_1.setBounds(491, 0, 184, 31);
        panel.add(lblHerramientas_1_1);
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setLayout(null);
        panel_1_2.setBackground(Color.LIGHT_GRAY);
        panel_1_2.setBounds(270, 7, 2, 90);
        panel.add(panel_1_2);
        
        JPanel panel_1_2_1 = new JPanel();
        panel_1_2_1.setLayout(null);
        panel_1_2_1.setBackground(Color.LIGHT_GRAY);
        panel_1_2_1.setBounds(490, 7, 2, 90);
        panel.add(panel_1_2_1);
        
        JPanel panel_1_2_2 = new JPanel();
        panel_1_2_2.setLayout(null);
        panel_1_2_2.setBackground(Color.LIGHT_GRAY);
        panel_1_2_2.setBounds(685, 7, 2, 90);
        panel.add(panel_1_2_2);

        Color[] colores = {Color.WHITE, Color.BLACK, Color.GRAY, Color.BLUE, Color.RED,
                Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK};   
        
        for (Color color : colores) {
            JButton btnColor = new JButton();
            btnColor.setFocusPainted(false);  

            btnColor.setBackground(color);
            btnColor.addActionListener(new ActionListener() {
    		    public void actionPerformed(ActionEvent e) {
    		        cambiarColor(color);
    		    }
    		});
            
            panelColores.add(btnColor);
        }

        panelDibujo = new PaintPanel();
        panelDibujo.setBounds(14, 140, 960, 535);
        contentPane.add(panelDibujo);
        panelDibujo.addMouseListener(this);
        panelDibujo.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	panelDibujo.repaint();
    	puntos.add(e.getPoint());
        
    }
    private void cambiarGrosor(int G) {
    	grosorActual =G;
 
    }
    
    private void cambiarColor(Color nuevoColor) {
        colorActual = nuevoColor;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        listaDePuntos.add(new ArrayList<>(puntos));
        puntos.clear();
        coloresArray.add(colorActual);
        grosores.add(grosorActual);
        panelDibujo.repaint();
    }

    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    class PaintPanel extends JPanel {
        public PaintPanel() {
            this.setBackground(Color.white);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            
            
            for (int i = 0; i < listaDePuntos.size(); i++) {
            	g2.setStroke(new BasicStroke(grosores.get(i)));
            	g2.setColor(coloresArray.get(i));
                dibujarTrazo(g2, listaDePuntos.get(i));
                
            }
            g2.setColor(colorActual); 
        	BasicStroke grosor = new BasicStroke(grosorActual);
            g2.setStroke(grosor);
            dibujarTrazo(g2, puntos);
            
            
        }

        private void dibujarTrazo(Graphics2D g2, List<Point> trazo) {
        	 
        	for (int i = 1; i < trazo.size(); i++) {
        		
                Point p1 = trazo.get(i - 1);
                Point p2 = trazo.get(i);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
}


