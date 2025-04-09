import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

public class Keyboard2 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int segundos = 0;
    private int minutos = 0;
    private JLabel lblTiempo;
    private Timer timer = new Timer();
    private boolean pausar = true;
    JButton btnPausar = new JButton("Pausar");
    private Player player;
    private ArrayList<Player> obstaculos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	
	public int x,y;
	
	PaintPanel panel_1 = new PaintPanel();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try {
					Keyboard2 frame = new Keyboard2();
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
	public Keyboard2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 430);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		player =new Player(350, 150, 30, 30,Color.GREEN);
		obstaculos.add(new Player(250, 50, 230, 30, Color.RED));
        obstaculos.add(new Player(250, 250, 230, 30, Color.RED));
        obstaculos.add(new Player(50, 50, 30, 200, Color.RED));
        obstaculos.add(new Player(650, 50, 30, 200, Color.RED));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		lblTiempo = new JLabel("00:00");
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTiempo.setBounds(150, 350, 100, 45);  
        panel.add(lblTiempo, BorderLayout.SOUTH);
 
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
         
        
		
		
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setFocusable(true);
		panel_1.setLayout(null);
		panel_1.addKeyListener(this); 
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("REINICIAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        player.x=350;
		        player.y=150;
		        panel_1.repaint();	
		        panel_1.requestFocus();
		        reiniciarTemporizador();
		        }
		});
	}
	
	class PaintPanel extends JPanel {
        public PaintPanel() {
            this.setBackground(Color.black);
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            
            g.setColor(player.c);
            g.fillRect(player.x, player.y, player.w, player.h);
            
            for (Player obs : obstaculos) {
                g.setColor(obs.c);
                g.fillRect(obs.x, obs.y, obs.w, obs.h);
            }
    
            
        }
        
	}
	
	class Player {
		int x,y,w,h;
		Color c;
		
		public Player(int x,int y, int w, int h,Color c) {
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
			this.c=c;
			
		}
		 public boolean colisionaCon(Player otro) {
		        return this.x < otro.x + otro.w &&
		               this.x + this.w > otro.x &&
		               this.y < otro.y + otro.h &&
		               this.y + this.h > otro.y;
		    }
		
	}

	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
	    int nuevaX = player.x;
	    int nuevaY = player.y;
	    int paso = 10;

	    int code = e.getKeyCode();
	    if (code == KeyEvent.VK_D) {
	        nuevaX += paso;
	    } else if (code == KeyEvent.VK_A) {
	        nuevaX -= paso;
	    } else if (code == KeyEvent.VK_S) {
	        nuevaY += paso;
	    } else if (code == KeyEvent.VK_W) {
	        nuevaY -= paso;
	    }

	    Player temporal = new Player(nuevaX, nuevaY, player.w, player.h, player.c);

	    boolean hayColision = false;
	    
	    for (Player pared : obstaculos) {
	        if (temporal.colisionaCon(pared)) {
	            hayColision = true;
	            break;
	        }
	    }

	    if (!hayColision) {
	        player.x = nuevaX;
	        player.y = nuevaY;
	    }
        if (player.x >= panel_1.getWidth()) {
            player.x = -player.w;  
        } else if (player.x + player.w <= 0) {
            player.x = panel_1.getWidth();  
        }
        if (player.y >= panel_1.getHeight()) {
            player.y = -player.h;  
        } else if (player.y + player.h <= 0) {
            player.y = panel_1.getHeight();  
        }
        
        panel_1.repaint();
        
        System.out.println("x = " + player.x + ", y = " + player.y);
		
	}
	
	public void reiniciarTemporizador() {
        segundos = 0;
        minutos = 0;
        lblTiempo.setText("00:00");
    }

	@Override
	public void keyReleased(KeyEvent e) {}
	
	

}

 