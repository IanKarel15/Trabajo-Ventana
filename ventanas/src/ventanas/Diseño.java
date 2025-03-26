package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;


public class Diseño extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton [][] botones = new JButton[4][4];
	private int filaVacia , columnaVacia;
	private int [] a = new int [16];
	private JPanel panel_1 = new JPanel();
    private int segundos = 0;
    private int minutos = 0;
    private JLabel lblTiempo;
    private Timer timer = new Timer();
    private boolean pausar = true;
    JButton btnPausar = new JButton("Pausar");
	
	
	
	private int [][]tablero =  new int[4][4];

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
	
	

    
	
	public void arreglos() {
		int num = 1;
		reordenar();
		
		
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (num <= 15) {
                	int aux = a[num++];
                	tablero[fila][columna] = aux++;
                	
                	botones[fila][columna] = new JButton(String.valueOf(aux-1));
                } else {
                    tablero[fila][columna] = 0; 
                    filaVacia = fila;
                    columnaVacia = columna;
                    botones[fila][columna] = new JButton("");
                }
                botones[fila][columna].setFont(new Font("Arial", Font.BOLD, 24));
                panel_1.add(botones[fila][columna]);
                botones[fila][columna].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent accion) {
                        moverBoton((JButton) accion.getSource());
                    }
                });
                
            }
            
        }
	}
	public Diseño() {
		
		//diseño del juego
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 380);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));
		
       
        
		
		arreglos();
		
		
		
		
		
        
        
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBackground(new Color(128, 255, 0));
		btnReiniciar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel_2.add(btnReiniciar);
		btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	panel_1.removeAll();
                
                
                arreglos();
                
                
                reiniciarTemporizador();
                

                
                
                panel_1.revalidate();
                panel_1.repaint();               
            }
        });
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(255, 0, 0));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel_2.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		
		btnPausar.setBackground(Color.YELLOW);
		btnPausar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panel_2.add(btnPausar);
		btnPausar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        pausarTemporizador();
		    }
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 255));
		panel.add(panel_3, BorderLayout.SOUTH);
		
		lblTiempo = new JLabel("00:00");
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTiempo.setBounds(150, 350, 100, 45);  
        panel_3.add(lblTiempo, BorderLayout.SOUTH);
        
                
            
        
		TimerTask task = new TimerTask() {
            @Override
            public void run() {
                
            	if (pausar) { 
                    segundos++;
                    if (segundos == 60) {
                        segundos = 0;
                        minutos++;
                    }
                }

                
                String tiempo = String.format("%02d:%02d", minutos, segundos);
                lblTiempo.setText(tiempo);
                repaint();
                
            }
        };

        
        timer.scheduleAtFixedRate(task, 1000, 1000);
         
        }        
        
        
	public void reiniciarTemporizador() {
        segundos = 0;
        minutos = 0;
        lblTiempo.setText("00:00");
    }
	
	public void pausarTemporizador() {
        
        if (pausar) {
        	btnPausar.setText("Reanudar");
            pausar = false;
        } else {
        	btnPausar.setText("Pausar");
            pausar = true;
        }
    }
        

        
	
	
	private void moverBoton(JButton boton1) {
		
        int filaBoton = -1, columnaBoton = -1;
        int aux;

        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                if (botones[fila][columna] == boton1) {
                    filaBoton = fila;
                    columnaBoton = columna;
                    break;
                }
            }
        }
        
        if (filaBoton > 0 && botones[filaBoton - 1][columnaBoton].getText().equals("")) {
            
            botones[filaBoton - 1][columnaBoton].setText(boton1.getText());
            boton1.setText("");
            
            tablero[filaBoton-1][columnaBoton] = tablero[filaBoton][columnaBoton];
            tablero[filaBoton][columnaBoton] = 0;
            
        } 
        else if (filaBoton < 3 && botones[filaBoton + 1][columnaBoton].getText().equals("")) {
            
            botones[filaBoton + 1][columnaBoton].setText(boton1.getText());
            boton1.setText("");
            
            tablero[filaBoton+1][columnaBoton] = tablero[filaBoton][columnaBoton];
            tablero[filaBoton][columnaBoton] = 0;
        } 
        else if (columnaBoton > 0 && botones[filaBoton][columnaBoton - 1].getText().equals("")) {
            
            botones[filaBoton][columnaBoton - 1].setText(boton1.getText());
            boton1.setText("");
            
            tablero[filaBoton][columnaBoton-1] = tablero[filaBoton][columnaBoton];
            tablero[filaBoton][columnaBoton] = 0;
        } 
        else if (columnaBoton < 3 && botones[filaBoton][columnaBoton + 1].getText().equals("")) {
          
            botones[filaBoton][columnaBoton + 1].setText(boton1.getText());
            boton1.setText("");
            
            tablero[filaBoton][columnaBoton+1] = tablero[filaBoton][columnaBoton];
            tablero[filaBoton][columnaBoton] = 0;
        }
        if(verificarVictoria()) {
        	 JOptionPane.showMessageDialog(this, "¡Felicidades, has ganado!");
        }
        imprimirTablero();
	
    }
	
	private void reordenar() {
		int j = 1;
		Random r1 = new Random();
		
		while(j<=15) {
			int n = r1.nextInt(15)+1;
			if (!Busqueda(a, n, j)) {
                a[j] = n;
                j++;
		}
			
			
		}
		}
		public  boolean Busqueda(int[] A, int n, int i) {
	        int j;
	        for (j = 0; j < i; j++) {
	            if (n == A[j]) {
	                return true;
	            }
	        }
	        return false;
	    }	
	
	private void imprimirTablero() {
	    System.out.println("Estado actual del tablero:");
	    for (int i = 0; i < 4; i++) {
	        for (int j = 0; j < 4; j++) {
	            
	                System.out.printf("%2d ", tablero[i][j]); 
	            
	        }
	        System.out.println(); 
	    }
	    System.out.println();
	}
	
	private boolean verificarVictoria() {
	    int[][] tableroObjetivo = {
	        { 1, 2, 3, 4 },
	        { 5, 6, 7, 8 },
	        { 9, 10, 11, 12 },
	        { 13, 14, 15, 0 } 
	    };

	    
	    for (int fila = 0; fila < 4; fila++) {
	        for (int columna = 0; columna < 4; columna++) {
	            if (tablero[fila][columna] != tableroObjetivo[fila][columna]) {
	                return false; 
	            }
	        }
	    }
	    return true; 
	}
}
