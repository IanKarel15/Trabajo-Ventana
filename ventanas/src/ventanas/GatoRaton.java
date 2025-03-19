package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GatoRaton extends JFrame {
	boolean turno = true;
	JButton btnNewButton = new JButton("");
	JButton btnNewButton_1 = new JButton("");
	JButton btnNewButton_2 = new JButton("");
	JButton btnNewButton_3 = new JButton("");
	JButton btnNewButton_4 = new JButton("");
	JButton btnNewButton_5 = new JButton("");
	JButton btnNewButton_6 = new JButton("");
	JButton btnNewButton_7 = new JButton("");
	JButton btnNewButton_8 = new JButton("");


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 3, 0));
		
		contentPane.add(btnNewButton);
		
		contentPane.add(btnNewButton_3);
		
		contentPane.add(btnNewButton_2);
		
		contentPane.add(btnNewButton_6);
		
		contentPane.add(btnNewButton_4);
		
		contentPane.add(btnNewButton_1);
		
		contentPane.add(btnNewButton_5);
		
		contentPane.add(btnNewButton_7);
		
		contentPane.add(btnNewButton_8);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            
            	if(turno) {
            		btnNewButton.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton.setText("O");
            		turno = true;
            	}
            	btnNewButton.setEnabled(false);
            	verificar();
            	}
            }
        );
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	
            	if(turno) {
            		btnNewButton_1.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_1.setText("O");
            		turno = true;
            	}
            	btnNewButton_1.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	
            	if(turno) {
            		btnNewButton_2.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_2.setText("O");
            		turno = true;
            	}
            	btnNewButton_2.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_3.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_3.setText("O");
            		turno = true;
            	}
            	btnNewButton_3.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_4.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_4.setText("O");
            		turno = true;
            	}
            	btnNewButton_4.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_5.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_5.setText("O");
            		turno = true;
            	}
            	btnNewButton_5.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_6.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_6.setText("O");
            		turno = true;
            	}
            	btnNewButton_6.setEnabled(false);
            	verificar();
                }
            }
        );
		
		btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_7.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_7.setText("O");
            		turno = true;
            	}
            	btnNewButton_7.setEnabled(false);
            	verificar();
                }
            
            }
        );
		
		btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent accion) {
            	if(turno) {
            		btnNewButton_8.setText("X");
            		turno = false;
            	}
            	else if(!turno) {
            		btnNewButton_8.setText("O");
            		turno = true;
            	}
            	btnNewButton_8.setEnabled(false);
            	verificar();
                }
            }
        );

	} 	
	
	private void verificar () {
		
		if(btnNewButton.getText().equals(btnNewButton_3) && btnNewButton_3.getText().equals(btnNewButton_2) && !btnNewButton.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton_6.getText().equals(btnNewButton_4) && btnNewButton_4.getText().equals(btnNewButton_1) && !btnNewButton_6.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton_5.getText().equals(btnNewButton_7) && btnNewButton_7.getText().equals(btnNewButton_8) && !btnNewButton_5.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton.getText().equals(btnNewButton_6) && btnNewButton_6.getText().equals(btnNewButton_5) && !btnNewButton.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton_3.getText().equals(btnNewButton_4) && btnNewButton_4.getText().equals(btnNewButton_7) && !btnNewButton_3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton_2.getText().equals(btnNewButton_1) && btnNewButton_1.getText().equals(btnNewButton_8) && !btnNewButton_2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton.getText().equals(btnNewButton_4) && btnNewButton_4.getText().equals(btnNewButton_8) && !btnNewButton.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(btnNewButton_2.getText().equals(btnNewButton_4) && btnNewButton_4.getText().equals(btnNewButton_5) && !btnNewButton_2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mensaje de información",
	                "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	
	 }
