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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Keyboard2 extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 783, 434);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		
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
		        x=0;
		        y=0;
		        panel_1.repaint();	
		        panel_1.requestFocus();
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
            
            
            g.setColor(Color.GREEN);
            g.fillRect(x+350, y+150, 30, 30);
            
        }
        
	}

	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		 int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            x += 10;
        } else if (code == KeyEvent.VK_A) {
            x -= 10;
        } else if (code == KeyEvent.VK_S) {
            y += 10;
        } else if (code == KeyEvent.VK_W) {
            y -= 10;
        }
        if (y>=190) {
        	y= -170;
        }
        else if (y<=-170) {
        	y= 190;
        }
        if (x >= 400) {
            x = -360;
        } else if (x <= -360) {
            x = 400;
        }
        
        panel_1.repaint();
        
        System.out.println("x = " + x + ", y = " + y);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
