package ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CasaMario extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //cielo xd
        g.setColor(new Color(162, 240, 255)); 
        g.fillRect(0, 0, getWidth(), getHeight());
        
        //colores
        //color salmon 
        g.setColor(new Color(249, 196, 194));
        //color azul
        g.setColor(new Color(57, 133, 250 ));
        //color cafe
        g.setColor(new Color(249, 147, 62));
        
        //arbol
        g.setColor(Color.black);
        g.fillOval(17,477,95,105);
        g.fillOval(57,477,96,105);
        g.fillOval(37,427,96,105);
        g.setColor(Color.green);
        g.fillOval(20,480,90,100); 
        g.fillOval(60,480,90,100);
        g.fillOval(40,430,90,100);
        
        //cuadrados
 
        dibujarCuadrados(g,250,360,160,210,new Color(57, 133, 250 ),false);
        g.setColor(Color.BLACK);
        g.fillRect(410, 405, 20, 150);
        tornillos(g,260,370);
        tornillos(g,380,370);
        tornillos(g,380,520);
        dibujarCuadrados(g,180, 410, 160, 170,Color.PINK,false);
        g.setColor(Color.BLACK);
        g.fillRect(340, 455, 20, 105);
        tornillos(g,190,420);
        tornillos(g,310,420);
        tornillos(g,190,520);
        tornillos(g,310,520);
        dibujarCuadrados(g,920, 380, 180, 190,Color.green,false);
        tornillos(g,930,390);
        tornillos(g,930,520);  
        dibujarCuadrados(g,150, 50, 70, 70,new Color(249, 147, 62),true); 
        dibujarCuadrados(g,224, 50, 70, 70,new Color(249, 147, 62),true);
        dibujarCuadrados(g,100, 210, 70, 70,new Color(249, 147, 62),true);
        dibujarCuadrados(g,950, 210, 70, 70,new Color(249, 147, 62),true);
        
        //tubo
        
        BufferedImage image2;
		try {
			
			image2 = ImageIO.read(new File("tubo.png"));
			
			g.drawImage(image2, 
					640,
					380,
					190,
					175, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
        //piso
		
        g.setColor(new Color(249, 147, 62));
        g.fillRect(0, 550, getWidth(), getHeight());
        g.setColor(new Color(154, 96, 51));
        g.fillRect(0, 580, getWidth(), getHeight());
        g.setColor(new Color(126, 58, 1 )); 
        for (int i = 0; i <= 120; i += 30) {
            g.fillRect(0, 580 + i, 1100, 3);
        }
        for (int i = 0; i <= 1100; i += 30) {
            g.fillRect(0+i, 580, 3, 130);
        }
        
        //imagenes
        
        BufferedImage image;
		try {
			
			image = ImageIO.read(new File("planta.png"));
			
			g.drawImage(image, 
					655,
					230,
					160,
					150, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		BufferedImage image3;
		try {
			
			image3 = ImageIO.read(new File("mario.png"));
			
			g.drawImage(image3, 
					500,
					440,
					110,
					115, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}     
    }
    
    private void dibujarCuadrados(Graphics g, int x, int y,int ancho,int largo,Color color, Boolean xd) { 
    	
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-3, y-3, ancho+6, largo+6, 7, 7); 
        g.setColor(color);
        g.fillRoundRect(x, y, ancho, largo, 7, 7); 
        
        if (xd) { 
            for (int i = 0; i < 4; i++) { 
                int offsetX = (i % 2 == 0) ? x + 5 : x + ancho - 15; 
                int offsetY = (i < 2) ? y + 5 : y + largo - 15; 
                g.setColor(Color.BLACK);
                g.fillRect(offsetX+2, offsetY+2, 5, 5); 
            }
        }
	        
   
    }
    
    private void tornillos(Graphics g, int x, int y) {
    	
    	g.setColor(Color.GRAY);
    	g.fillRect(x+3, y+3, 15, 15);
    	g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g; 
        g2.setStroke(new BasicStroke(3)); 
        g2.fillRect(x, y + 3, 3, 15);
        g2.fillRect(x + 3, y, 15, 3);
        g2.fillRect(x + 18, y + 3, 3, 15);
        g2.fillRect(x + 3, y + 18, 15, 3);
        g2.drawLine(x+17, y+3, x+3, y + 17);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Casa de Mario");
        CasaMario panel = new CasaMario();
        
        ventana.add(panel);
        ventana.setSize(1100, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}