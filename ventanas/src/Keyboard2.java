import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Keyboard2 extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int segundos = 0;
    private int minutos = 0;
    private JLabel lblTiempo;
    private Timer timer = new Timer();
    private boolean pausar = true;
    private Player player,meta;
    private ArrayList<Player> obstaculos = new ArrayList<>();
    private String direccionActual = "";
    private Timer movimientoTimer;
    private PaintPanel panel_1 = new PaintPanel();
    ImageIcon imgJugador = new ImageIcon("transbordador-espacial.png");
    ImageIcon imgPared = new ImageIcon("asteroide.png");
    ImageIcon imgMeta = new ImageIcon("agujero-negro.png");

    int[][] mapa1 = {
		    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    {1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
		    {1,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,1},
		    {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,1},
		    {1,0,1,1,1,1,1,0,1,1,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,0,1},
		    {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
		    {1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1},
		    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1},
		    {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		    {1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1},
		    {1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
		    {1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    
		};
	
	int[][] mapa2= {
		    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		    {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		    {1,1,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
		    {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
		    {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		    {1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1},
		    {1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
		    {1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1},
		    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
		    {1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1},
		    {1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1},
		    {1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1},
		    {1,1,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1},
		    {1,0,0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
		    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Keyboard2 frame = new Keyboard2();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Keyboard2() {
        JPanel inicio = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 0, 763, 908);
        setResizable(false);
        setContentPane(inicio);
        inicio.setLayout(null);
        inicio.setBackground(Color.black);


        JLabel lblNewLabel = new JLabel("LABERINTO ESPACIAL");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(180, 200,686, 55);
		inicio.add(lblNewLabel);

        JButton btnMapa1 = new JButton("Mapa 1");
        btnMapa1.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnMapa1.setBounds(250, 330, 250, 50);
        inicio.add(btnMapa1);
       
        btnMapa1.setFocusPainted(false);  
        
        btnMapa1.addActionListener(e -> juego(1));

        JButton btnMapa2 = new JButton("Mapa 2");
        btnMapa2.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnMapa2.setBounds(250, 400, 250, 50);
        inicio.add(btnMapa2);
        btnMapa2.setFocusPainted(false);  
        btnMapa2.addActionListener(e -> juego(2));
    }

    public void juego(int numMapa) {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        revalidate();
        repaint();
        contentPane.setLayout(new BorderLayout(0, 0));

        player = new Player(50, 50, 21, 21, Color.GREEN);
		meta = new Player(670, 670, 26, 26, Color.white);
		
        int anchoCelda = 26;
        int altoCelda = 26;
        obstaculos.clear();

        if (numMapa==1) {
			for (int fila = 0; fila < mapa1.length; fila++) {
			    for (int col = 0; col < mapa1[0].length; col++) {
			        if (mapa1[fila][col] == 1) {
			            int x = col * anchoCelda;
			            int y = fila * altoCelda;
			            obstaculos.add(new Player(x+20, y+20, anchoCelda, altoCelda, Color.RED));
			        }
			    }
			}
		}
		else
			for (int fila = 0; fila < mapa2.length; fila++) {
			    for (int col = 0; col < mapa2[0].length; col++) {
			        if (mapa2[fila][col] == 1) {
			            int x = col * anchoCelda;
			            int y = fila * altoCelda;
			            obstaculos.add(new Player(x+20, y+20, anchoCelda, altoCelda, Color.RED));
			        }
			    }
			}

		revalidate();
		repaint();
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.black);
        contentPane.add(panel, BorderLayout.NORTH);
        lblTiempo = new JLabel("00:00");
        lblTiempo.setFont(new Font("Arial", Font.BOLD, 30));
        lblTiempo.setForeground(Color.WHITE);
        
        panel.add(lblTiempo);

        timer.scheduleAtFixedRate(new TimerTask() {
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
        }, 1000, 1000);

        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setFocusable(true);
        panel_1.setLayout(null);
        panel_1.addKeyListener(this);
        panel_1.requestFocusInWindow();
        

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);

        JButton btnReiniciar = new JButton("REINICIAR");
        btnReiniciar.setFont(new Font("Arial", Font.BOLD, 24));
       
        panel_2.setBackground(Color.black);
        panel_2.add(btnReiniciar);
        btnReiniciar.addActionListener(e -> {
            player.x = 50;
            player.y = 50;
            panel_1.repaint();
            direccionActual = "";
            reiniciarTemporizador();
            panel_1.requestFocus();
        });

        SClip.reproducirSonido("ruidoFondo.wav");

        movimientoTimer = new Timer();
        movimientoTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                moverJugador();
            }
        }, 0, 10);
    }

    private void moverJugador() {
        int nuevaX = player.x;
        int nuevaY = player.y;
        int paso = 1;

        switch (direccionActual) {
            case "DERECHA": nuevaX += paso; break;
            case "IZQUIERDA": nuevaX -= paso; break;
            case "ABAJO": nuevaY += paso; break;
            case "ARRIBA": nuevaY -= paso; break;
            default: return;
        }

        Player temporal = new Player(nuevaX, nuevaY, player.w, player.h, player.c);
        boolean hayColision = false;

        for (Player obs : obstaculos) {
            if (temporal.colisionaCon(obs)) {
                hayColision = true;
                break;
            }
        }
        if (temporal.colisionaCon(meta)) {
			SClip.reproducirSonido("hola.wav");
			
			timer.cancel(); 
			movimientoTimer.cancel(); 
		    JOptionPane.showMessageDialog(null, "Has llegado a la meta");
			}

        if (!hayColision) {
            player.x = nuevaX;
            player.y = nuevaY;
        }

        
        if (player.x >= panel_1.getWidth()) player.x = -player.w;
        else if (player.x + player.w <= 0) player.x = panel_1.getWidth();

        if (player.y >= panel_1.getHeight()) player.y = -player.h;
        else if (player.y + player.h <= 0) player.y = panel_1.getHeight();

        panel_1.repaint();
    }

    private void reiniciarTemporizador() {
        segundos = 0;
        minutos = 0;
    }

    class PaintPanel extends JPanel {
        public PaintPanel() {
            setBackground(Color.black);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(player.c);
            g.drawImage(imgJugador.getImage(), player.x, player.y, player.w, player.h,null);
            
            g.setColor(meta.c);
            g.drawImage(imgMeta.getImage(), meta.x, meta.y, meta.w, meta.h,null);
            
            for (Player obs : obstaculos) {
                g.setColor(obs.c);
                g.drawImage(imgPared.getImage(), obs.x, obs.y, obs.w, obs.h,null);
            }
        }
    }

    class Player {
        int x, y, w, h;
        Color c;

        public Player(int x, int y, int w, int h, Color c) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.c = c;
        }

        public boolean colisionaCon(Player otro) {
            return this.x < otro.x + otro.w &&
                   this.x + this.w > otro.x &&
                   this.y < otro.y + otro.h &&
                   this.y + this.h > otro.y;
        }

        
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_D) direccionActual = "DERECHA";
        else if (code == KeyEvent.VK_A) direccionActual = "IZQUIERDA";
        else if (code == KeyEvent.VK_W) direccionActual = "ARRIBA";
        else if (code == KeyEvent.VK_S) direccionActual = "ABAJO";
    }
    @Override public void keyReleased(KeyEvent e) {}
    public class SClip {

        public static void reproducirSonido(String rutaSonido) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(rutaSonido));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start(); 

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("Error al reproducir sonido: " + e.getMessage());
            }
        }
    }

}



 