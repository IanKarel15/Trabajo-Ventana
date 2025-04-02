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
    private ArrayList<Figura> figuras = new ArrayList<>();
    int valor,tipo;
    int grosorActual;
    boolean xd;
    private Point puntoInicio,puntoFinal;
    private boolean rellenar =false;

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
        setBounds(100, 100, 1125, 727);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 22, 1091, 103);
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

        Image imgTriangulo = new ImageIcon("triangulo (4).png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnTriangulo.setIcon(new ImageIcon(imgTriangulo));
        btnTriangulo.setBorderPainted(false); 
        btnTriangulo.setFocusPainted(false);  
        btnTriangulo.setContentAreaFilled(false);

        btnTriangulo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        tipo = 2;
		        xd = true;
		        
		    }
		});


        JButton btnLinea = new JButton("");
        btnLinea.setBounds(144, 34, 50, 50);
        panel.add(btnLinea);
        btnLinea.setBorderPainted(false); 
        btnLinea.setFocusPainted(false);  
        btnLinea.setContentAreaFilled(false);

        Image imgLinea = new ImageIcon("linea-diagonal (1).png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnLinea.setIcon(new ImageIcon(imgLinea));

        btnLinea.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	tipo = 3;
		    	xd = true;
		        
		    }
		});


        JButton btnCirculo = new JButton("");
        btnCirculo.setBounds(24, 34, 50, 50);
        panel.add(btnCirculo);
        btnCirculo.setBorderPainted(false); 
        btnCirculo.setFocusPainted(false);  
        btnCirculo.setContentAreaFilled(false);
        

        Image imgCirculo = new ImageIcon("registro.png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnCirculo.setIcon(new ImageIcon(imgCirculo));
        btnCirculo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	tipo = 1;
		    	xd = true;
		    	
		        
		    }
		});
        


        JButton btnCuadrado = new JButton("");
        btnCuadrado.setBounds(204, 34, 50, 50);
        panel.add(btnCuadrado);
        btnCuadrado.setBorderPainted(false); 
        btnCuadrado.setFocusPainted(false);  
        btnCuadrado.setContentAreaFilled(false);

        Image imgCuadrado = new ImageIcon("cuadrado (2).png").getImage()
            .getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        btnCuadrado.setIcon(new ImageIcon(imgCuadrado));
        btnCuadrado.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	tipo = 4;
		        xd = true;
		        
		    }
		});
        
        JButton btnNewButton_4 = new JButton("Lapiz");
        btnNewButton_4.setBackground(new Color(255, 255, 255));
        btnNewButton_4.setBounds(480, 34, 85, 21);
        btnNewButton_4.setFocusPainted(false);  

        panel.add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cambiarColor(Color.BLACK);
		        xd = false;
		        tipo =0;
		    }
		});
        
        JButton btnNewButton_4_1 = new JButton("Borrador");
        btnNewButton_4_1.setBackground(new Color(255, 255, 255));
        btnNewButton_4_1.setBounds(480, 63, 85, 21);
        btnNewButton_4_1.setFocusPainted(false);  

        panel.add(btnNewButton_4_1);
        btnNewButton_4_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cambiarColor(Color.WHITE);
		        xd  = false;
		    }
		});
        
        JSlider slider = new JSlider(0, 40, 2);
        slider.setBackground(new Color(255, 255, 255));
        slider.setBounds(611, 48, 175, 26);
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
        lblColores.setBounds(881, 0, 184, 31);
        panel.add(lblColores);

        JPanel panelColores = new JPanel(new GridLayout(3, 3, 7, 5));
        panelColores.setBackground(new Color(255, 255, 255));
        panelColores.setBorder(UIManager.getBorder("Button.border"));
        panelColores.setBounds(830, 31, 235, 62);
        panel.add(panelColores);
        
        JButton btnNewButton_4_2 = new JButton("Limpiar");
        btnNewButton_4_2.setBackground(new Color(255, 255, 255));
        btnNewButton_4_2.setBounds(385, 34, 85, 21);
        btnNewButton_4_2.setFocusPainted(false);  
        panel.add(btnNewButton_4_2);
        btnNewButton_4_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	puntos.clear();
		        listaDePuntos.clear();
		        coloresArray.clear();
		        grosores.clear();
		        figuras.clear();
		        repaint();
		        
		    }
		});
        
        JButton btnNewButton_4_2_1 = new JButton("Atras");
        btnNewButton_4_2_1.setBackground(new Color(255, 255, 255));
        btnNewButton_4_2_1.setBounds(385, 63, 85, 21);
        btnNewButton_4_2_1.setFocusPainted(false);  

        panel.add(btnNewButton_4_2_1);
        btnNewButton_4_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!xd) {
                    if (!listaDePuntos.isEmpty()) {
                        int i = listaDePuntos.size() - 1;
                        listaDePuntos.remove(i);
                        coloresArray.remove(i);
                        grosores.remove(i);
                        repaint();
                    }
                } else {
                    if (!figuras.isEmpty()) {
                        int i = figuras.size() - 1;
                        figuras.remove(i);
                        repaint();
                    }
                }
            }
        });
        
        JLabel lblHerramientas_1 = new JLabel("HERRAMIENTAS");
        lblHerramientas_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas_1.setBounds(381, 0, 184, 31);
        panel.add(lblHerramientas_1);
        
        JLabel lblHerramientas_1_1 = new JLabel("GROSOR");
        lblHerramientas_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHerramientas_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHerramientas_1_1.setBounds(602, 0, 184, 31);
        panel.add(lblHerramientas_1_1);
        
        JPanel panel_1_2 = new JPanel();
        panel_1_2.setLayout(null);
        panel_1_2.setBackground(Color.LIGHT_GRAY);
        panel_1_2.setBounds(373, 7, 2, 90);
        panel.add(panel_1_2);
        
        JPanel panel_1_2_1 = new JPanel();
        panel_1_2_1.setLayout(null);
        panel_1_2_1.setBackground(Color.LIGHT_GRAY);
        panel_1_2_1.setBounds(589, 7, 2, 90);
        panel.add(panel_1_2_1);
        
        JPanel panel_1_2_2 = new JPanel();
        panel_1_2_2.setLayout(null);
        panel_1_2_2.setBackground(Color.LIGHT_GRAY);
        panel_1_2_2.setBounds(808, 7, 2, 90);
        panel.add(panel_1_2_2);
        
        JButton btnNewButton_4_2_2 = new JButton("Rellenar");
        btnNewButton_4_2_2.setFocusPainted(false);
        btnNewButton_4_2_2.setBackground(Color.WHITE);
        btnNewButton_4_2_2.setBounds(277, 41, 86, 21);
        panel.add(btnNewButton_4_2_2);
        btnNewButton_4_2_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cambiarRellenar();
		    }
		});

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
        panelDibujo.setBounds(14, 140, 1085, 535);
        contentPane.add(panelDibujo);
        panelDibujo.addMouseListener(this);
        panelDibujo.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	if(!xd) {
    		panelDibujo.repaint();
        	puntos.add(e.getPoint());
    	}
        
    }
    private void cambiarGrosor(int G) {
    	grosorActual =G;
 
    }
    
    private void cambiarColor(Color nuevoColor) {
        colorActual = nuevoColor;
    }
    private void cambiarRellenar() {
        rellenar = !rellenar;
        repaint();
        
        
    }
    
    

    @Override
    public void mouseReleased(MouseEvent e) {
        if(tipo == 3 ) {
        	
        	puntoFinal = e.getPoint();
        	figuras.add(new Figura(puntoInicio.x, puntoInicio.y, puntoFinal.x, puntoFinal.y, tipo,colorActual,grosorActual,rellenar));
        	
        }
        else
        {
        	listaDePuntos.add(new ArrayList<>(puntos));
            puntos.clear();
            coloresArray.add(colorActual);
            grosores.add(grosorActual);
        }
        panelDibujo.repaint();
    }

    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {
        if (xd) {
            if (tipo == 2) {
                FiguraTriangulo ft = new FiguraTriangulo(e.getX(), e.getY(), 80, 80, tipo,colorActual,grosorActual,rellenar);
                figuras.add(ft);
            } else if (tipo != 3) { 
                Figura f = new Figura(e.getX(), e.getY(), 80, 80, tipo,colorActual,grosorActual,rellenar);
                figuras.add(f);
            }
        }
    }
    @Override public void mousePressed(MouseEvent e) {
    	puntoInicio = e.getPoint();
    }
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
        	for (Figura f : figuras) { 
        		g2.setStroke(new BasicStroke(f.grosor));
            	g2.setColor(f.color);
            	
        		if(f.tipo == 1) {
        			if(f.rellenar)
        				g2.fillOval(f.x, f.y, f.ancho, f.alto);
        			else
        				g2.drawOval(f.x, f.y, f.ancho, f.alto);
        		}
        			
        		if(f.tipo == 2) {
        			
        			if(f.rellenar) {
	        			if (f instanceof FiguraTriangulo) {
	                        FiguraTriangulo ft = (FiguraTriangulo) f;
	                        g2.fillPolygon(ft.vx1, ft.vy1, 3);
	                        
	                    }
	        		}
	        		else {
	        			if (f instanceof FiguraTriangulo) {
	                        FiguraTriangulo ft = (FiguraTriangulo) f;
	                        g2.drawPolygon(ft.vx1, ft.vy1, 3);
	                        
	                    }
	        		}
                    
        		}
        		
        		
        			
        		if	(f.tipo == 3) {
        			
        			g2.drawLine(f.x, f.y, f.ancho, f.alto);
        			
        		}
        		if(f.tipo==4) {
        			if(f.rellenar)
        				g2.fillRect(f.x, f.y, f.ancho, f.alto);
        			else
        				g2.drawRect(f.x, f.y, f.ancho, f.alto);
        		}
        		
               
            }
        	panelDibujo.repaint();        	
        	
        	
        }
    }
    
    class Figura {
    	
    	int x,y,ancho,alto,tipo,grosor;
    	Color color;
    	boolean rellenar;
    	
    	
    	public Figura (int x,int y, int ancho,int alto,int tipo,Color color,int grosor,Boolean rellenar) {
    		this.x = x;
    		this.y = y;
    		this.ancho = ancho;
    		this.alto = alto;
    		this.tipo = tipo;
    		this.color=color;
    		this.grosor=grosor;
    		this.rellenar= rellenar;
    		
    		
    	}
    }
    
    class FiguraTriangulo extends Figura {

    	int [] vx1 ;
        int [] vy1 ;
        
		public FiguraTriangulo(int x, int y, int ancho, int alto, int tipo,Color color,int grosor,boolean rellenar) {
			super(x, y, ancho, alto, tipo,color,grosor,rellenar);
			this.vx1 = new int[]{x, x - 80, x + ancho};
	        this.vy1 = new int[]{y, y+alto, y + alto};
		}
    	
    }
}



