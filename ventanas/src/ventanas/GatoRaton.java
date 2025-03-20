package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GatoRaton extends JFrame {
	boolean turno = true;
	int contador = 0;
	int contadorr = 0;
	JButton btnNewButton = new JButton("");
	JButton btnNewButton_1 = new JButton("");
	JButton btnNewButton_2 = new JButton("");
	JButton btnNewButton_3 = new JButton("");
	JButton btnNewButton_4 = new JButton("");
	JButton btnNewButton_5 = new JButton("");
	JButton btnNewButton_6 = new JButton("");
	JButton btnNewButton_7 = new JButton("");
	JButton btnNewButton_8 = new JButton("");
	
	private JPanel panelPrincipal;
    private JPanel panelContador;
    private JPanel contentPane;
    private int contadorJ1 = 0;
    private int contadorJ2 = 0;
    private int resp;




	private static final long serialVersionUID = 1L;
	public JLabel lblNewLabel = new JLabel("JUGADOR X:0        ");
	public JLabel lblJugador = new JLabel("       JUGADOR O:0  ");
	public JLabel lblContador = new JLabel("JUGADAS: 0  ");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GatoRaton frame = new GatoRaton();
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
	
	public GatoRaton() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 600);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setLayout(null);
        setContentPane(panel1);
        JButton botonIS = new JButton("Jugar 1vs1");
        botonIS.setBounds(130, 330, 220, 37);
        
        panel1.add(botonIS);
        botonIS.addActionListener(e -> gatoRaton());
        
        JButton botonIS2 = new JButton("Jugar 1vs CPU");
        botonIS2.setBounds(130, 230, 220, 37);
        
        panel1.add(botonIS2);
	}
	
	public void gatoRaton() {
		
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 500, 600);

	        ImageIcon img1 = new  ImageIcon("C:\\Users\\ianka\\OneDrive\\Documentos\\GitHub\\ventanas\\ventanas\\src\\gato (2).png");
	        ImageIcon img2 = new  ImageIcon("C:\\Users\\ianka\\OneDrive\\Documentos\\GitHub\\ventanas\\ventanas\\src\\raton.png");

			
			panelPrincipal = new JPanel();
	        panelPrincipal.setLayout(new BorderLayout());
	        setContentPane(panelPrincipal);
	        

	        panelContador = new JPanel();
	        panelContador.setBackground(new Color(255, 128, 192));
	        lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
	        
	        panelContador.add(lblNewLabel);
	        lblContador.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
	        panelContador.add(lblContador);
	        panelPrincipal.add(panelContador, BorderLayout.NORTH);
	        lblJugador.setFont(new Font("Segoe UI Emoji", Font.BOLD, 17));
	        
	        panelContador.add(lblJugador);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.setBackground(new Color(255, 128, 192));
	        contentPane.setLayout(new GridLayout(3, 3, 5, 5)); 
	        panelPrincipal.add(contentPane, BorderLayout.CENTER);
			
			
			contentPane.add(btnNewButton);
			
			btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            
	            	if(turno) {
	            		btnNewButton.setText("X");
	            		turno = false;
	            		btnNewButton.setIcon(img1);
	            		btnNewButton.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton.setText("O");
	            		turno = true;
	            		btnNewButton.setIcon(img2);
	            		btnNewButton.setDisabledIcon(img2);
	            	}
	            	btnNewButton.setEnabled(false);
	            	verificar();
	            	contador++;
	            	}
	            }
	        );
			
			contentPane.add(btnNewButton_3);
			
			btnNewButton_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_3.setText("X");
	            		btnNewButton_3.setIcon(img1);
	            		turno = false;
	            		btnNewButton_3.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_3.setText("O");
	            		turno = true;
	            		btnNewButton_3.setIcon(img2);
	            		btnNewButton_3.setDisabledIcon(img2);
	            	}
	            	btnNewButton_3.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			
			contentPane.add(btnNewButton_2);
			
			btnNewButton_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	
	            	if(turno) {
	            		btnNewButton_2.setText("X");
	            		turno = false;
	            		btnNewButton_2.setIcon(img1);
	            		btnNewButton_2.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_2.setText("O");
	            		turno = true;
	            		btnNewButton_2.setIcon(img2);
	            		btnNewButton_2.setDisabledIcon(img2);
	            	}
	            	btnNewButton_2.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			contentPane.add(btnNewButton_6);
			
			btnNewButton_6.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_6.setText("X");
	            		turno = false;
	            		btnNewButton_6.setIcon(img1);
	            		btnNewButton_6.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_6.setText("O");
	            		turno = true;
	            		btnNewButton_6.setIcon(img2);
	            		btnNewButton_6.setDisabledIcon(img2);
	            	}
	            	btnNewButton_6.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			contentPane.add(btnNewButton_4);
			
			btnNewButton_4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_4.setText("X");
	            		turno = false;
	            		btnNewButton_4.setIcon(img1);
	            		btnNewButton_4.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_4.setText("O");
	            		turno = true;
	            		btnNewButton_4.setIcon(img2);
	            		btnNewButton_4.setDisabledIcon(img2);
	            	}
	            	btnNewButton_4.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			contentPane.add(btnNewButton_1);
			
			btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	
	            	if(turno) {
	            		btnNewButton_1.setText("X");
	            		turno = false;
	            		btnNewButton_1.setIcon(img1);
	            		btnNewButton_1.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_1.setText("O");
	            		turno = true;
	            		btnNewButton_1.setIcon(img2);
	            		btnNewButton_1.setDisabledIcon(img2);
	            	}
	            	btnNewButton_1.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			contentPane.add(btnNewButton_5);
			
			btnNewButton_5.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_5.setText("X");
	            		turno = false;
	            		btnNewButton_5.setIcon(img1);
	            		btnNewButton_5.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_5.setText("O");
	            		turno = true;
	            		btnNewButton_5.setIcon(img2);
	            		btnNewButton_5.setDisabledIcon(img2);
	            	}
	            	btnNewButton_5.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			
			contentPane.add(btnNewButton_7);
			
			btnNewButton_7.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_7.setText("X");
	            		turno = false;
	            		btnNewButton_7.setIcon(img1);
	            		btnNewButton_7.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_7.setText("O");
	            		turno = true;
	            		btnNewButton_7.setIcon(img2);
	            		btnNewButton_7.setDisabledIcon(img2);
	            	}
	            	btnNewButton_7.setEnabled(false);
	            	verificar();
	            	contador++;
	                }
	            
	            }
	        );
			
			contentPane.add(btnNewButton_8);
			
			btnNewButton_8.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent accion) {
	            	if(turno) {
	            		btnNewButton_8.setText("X");
	            		turno = false;
	            		btnNewButton_8.setIcon(img1);
	            		btnNewButton_8.setDisabledIcon(img1);
	            	}
	            	else if(!turno) {
	            		btnNewButton_8.setText("O");
	            		turno = true;
	            		btnNewButton_8.setIcon(img2);
	            		btnNewButton_8.setDisabledIcon(img2);
	            	}
	            	
	            	verificar();
	            	contador++;
	                }
	            }
	        );
			repaint();
			revalidate();

	} 	
	
	
	private void ganador() {
		int resp = 0;
		if(turno) {
			resp = JOptionPane.showConfirmDialog(null, "El ganador es el O. Desea volver a jugar?",
		            "ñiñiñi", JOptionPane.YES_NO_OPTION,
		            JOptionPane.INFORMATION_MESSAGE);
			contadorJ1++;
			contador++;
			lblJugador.setText("JUGADOR O: " + contadorJ1);
			repaint();
			revalidate();
		}
		else
		{
			resp = JOptionPane.showConfirmDialog(null, "El ganador es la X. Desea volver a jugar?",
		            "ñiñiñi", JOptionPane.YES_NO_OPTION,
		            JOptionPane.INFORMATION_MESSAGE);
			contadorJ2++;
			lblNewLabel.setText("JUGADOR X: " + contadorJ2);
			contador++;
			repaint();
			revalidate();

		}
		
		contadorr++;
		lblContador.setText("Jugadas:"+contadorr);
		
		if(resp==0) {
			reiniciarJ();
		}
		else
			System.exit(0); ;
		
		
	}
	private void reiniciarJ () {
		btnNewButton.setText("");
		btnNewButton_1.setText("");
		btnNewButton_2.setText("");
		btnNewButton_3.setText("");
		btnNewButton_4.setText("");
		btnNewButton_5.setText("");
		btnNewButton_6.setText("");
		btnNewButton_7.setText("");
		btnNewButton_8.setText("");
		
		btnNewButton.setEnabled(true);
		btnNewButton_1.setEnabled(true);
		btnNewButton_2.setEnabled(true);
		btnNewButton_3.setEnabled(true);
		btnNewButton_4.setEnabled(true);
		btnNewButton_5.setEnabled(true);
		btnNewButton_6.setEnabled(true);
		btnNewButton_7.setEnabled(true);
		btnNewButton_8.setEnabled(true);
		
		btnNewButton.setIcon(null);
		btnNewButton_1.setIcon(null);
		btnNewButton_2.setIcon(null);
		btnNewButton_3.setIcon(null);
		btnNewButton_4.setIcon(null);
		btnNewButton_5.setIcon(null);
		btnNewButton_6.setIcon(null);
		btnNewButton_7.setIcon(null);
		btnNewButton_8.setIcon(null);

		
		repaint();
		revalidate();
		contador = 0;
		
	}
	
	
        
	
	private void verificar () {
		
		if(contador == 9) {
			JOptionPane.showMessageDialog(null, "El ganador es ninguno putos tontos",
	                "Ganador", JOptionPane.INFORMATION_MESSAGE);
			contador++;
		}
		else if(btnNewButton.getText().equals(btnNewButton_3.getText()) && btnNewButton_3.getText().equals(btnNewButton_2.getText()) && !btnNewButton.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton_6.getText().equals(btnNewButton_4.getText()) && btnNewButton_4.getText().equals(btnNewButton_1.getText()) && !btnNewButton_6.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton_5.getText().equals(btnNewButton_7.getText()) && btnNewButton_7.getText().equals(btnNewButton_8.getText()) && !btnNewButton_5.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton.getText().equals(btnNewButton_6.getText()) && btnNewButton_6.getText().equals(btnNewButton_5.getText()) && !btnNewButton.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton_3.getText().equals(btnNewButton_4.getText()) && btnNewButton_4.getText().equals(btnNewButton_7.getText()) && !btnNewButton_3.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton_2.getText().equals(btnNewButton_1.getText()) && btnNewButton_1.getText().equals(btnNewButton_8.getText()) && !btnNewButton_2.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton.getText().equals(btnNewButton_4.getText()) && btnNewButton_4.getText().equals(btnNewButton_8.getText()) && !btnNewButton.getText().equals("")) {
			ganador();
		}
		else if(btnNewButton_2.getText().equals(btnNewButton_4.getText()) && btnNewButton_4.getText().equals(btnNewButton_5.getText()) && !btnNewButton_2.getText().equals("")) {
			ganador();
			}
		
		
	}
	
	 }
