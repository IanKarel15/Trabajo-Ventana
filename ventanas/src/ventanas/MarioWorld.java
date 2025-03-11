package ventanas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MarioWorld extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color color1 = Color.decode("#7cbccb"); // Azul verdoso
        Color color2 = Color.decode("#6b74b3"); // Azul violeta
        Color color3 = Color.decode("#bc8c34"); // Marrón dorado
        Color color4 = Color.decode("#0464bc"); // Azul fuerte
        Color color5 = Color.decode("#d4d4c4"); // Beige claro
        Color color6 = Color.decode("#2c3c24"); // Verde oscuro
        Color color7 = Color.decode("#343c44"); // Gris azulado oscuro
        Color color8 = Color.decode("#a1a7a9"); // Gris medio
        Color color9 = Color.decode("#a8c3d7"); // Azul celeste
        Color color10 = Color.decode("#79acde"); // Azul cielo
        Color color11 = Color.decode("#668daa"); // Verde grisáceo
        Color color12 = Color.decode("#d4ac74"); // Marrón claro
        
        g.setColor(color4); 
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        
        //Dibujar montañas
        
        g.setColor(color8); 
        g.fillRoundRect(220, 200, 200, 60, 70, 100);
        g.setColor(Color.WHITE); 
        g.fillRoundRect(220, 195, 200, 60, 70, 100);
  
        g.setColor(color10); 
        g.fillRoundRect(80,160,180,500,300,200);
        g.setColor(color9); 
        g.fillRoundRect(70,160,180,500,300,200);
        g.setColor(Color.WHITE);
        g.fillOval(120, 200, 30, 45);
        g.fillOval(190, 270, 30, 45);
        
        g.setColor(color10); 
        g.fillRoundRect(550,160,180,500,300,200);
        g.setColor(color9); 
        g.fillRoundRect(540,160,180,500,300,200);
        g.setColor(Color.WHITE);
        g.fillOval(590, 200, 30, 45);
        g.fillOval(660, 270, 30, 45);
        
        g.setColor(color8); 
        g.fillRoundRect(830, 130, 200, 60, 70, 100);
        g.setColor(Color.WHITE); 
        g.fillRoundRect(830, 125, 200, 60, 70, 100);
        
        g.setColor(color10); 
        g.fillRoundRect(740,80,180,500,300,200);
        g.setColor(color9); 
        g.fillRoundRect(730,80,180,500,300,200);
        g.setColor(Color.WHITE);
        g.fillOval(780, 120, 30, 45);
        g.fillOval(850, 190, 30, 45);
        
        //nubes
        g.setColor(color8); 
        g.fillRoundRect(50, 100, 170, 60, 70, 100);
        g.setColor(Color.WHITE); 
        g.fillRoundRect(50, 95, 170, 60, 70, 100);


        g.setColor(color8); 
        g.fillRoundRect(400, 50, 200, 60, 70, 100);
        g.setColor(Color.WHITE); 
        g.fillRoundRect(400, 45, 200, 60, 70, 100);

        g.setColor(color8); 
        g.fillRoundRect(550, 200, 200, 60, 70, 100);
        g.setColor(Color.WHITE); 
        g.fillRoundRect(550, 195, 200, 60, 70, 100);


        //mas montanas
        
        g.setColor(color11); 
        g.fillRoundRect(100,380,210,500,300,200);
        g.setColor(color10); 
        g.fillRoundRect(85,380,210,500,300,200);
        g.setColor(color9);
        g.fillOval(150, 410, 30, 45);
        g.fillOval(230, 470, 30, 45);
        
        g.setColor(color11); 
        g.fillRoundRect(565,380,210,500,300,200);
        g.setColor(color10); 
        g.fillRoundRect(550,380,210,500,300,200);
        g.setColor(color9);
        g.fillOval(615, 410, 30, 45);
        g.fillOval(700, 470, 30, 45);
        
        g.setColor(color11); 
        g.fillRoundRect(790,220,210,500,300,200);
        g.setColor(color10); 
        g.fillRoundRect(775,220,210,500,300,200);
        g.setColor(color9);
        g.fillOval(830, 270, 30, 45);
        g.fillOval(920, 380, 30, 45);
        
        dibujarCuadrados1(g,880, 500, 70, 70,color8);
        dibujarCuadrados1(g,880, 426, 70, 70,color8);  
        dibujarCuadrados1(g,880, 352, 70, 70,color8);
        
        dibujarCuadrados1(g,955, 352, 70, 70,Color.yellow);
        dibujarCuadrados1(g,1030, 352, 70, 70,Color.yellow);
        
        //tubo
        
        dibujarCuadrados1(g,645, 450, 125, 150,Color.BLUE);
        dibujarCuadrados1(g,620, 385, 175, 70,Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillRect(660, 385, 12, 70); 
        g.fillRect(680, 458, 17, 150); 
        
        dibujarCuadrados1(g,1005, 500, 105, 120,Color.BLUE);
        dibujarCuadrados1(g,985, 455, 125, 60,Color.BLUE);
        g.setColor(Color.WHITE);
        g.fillRect(1020, 455, 12, 60); 
        g.fillRect(1040, 518, 17, 120);
        
        BufferedImage image;
		try {
			
			image = ImageIO.read(new File("planta.png"));
			
			g.drawImage(image, 
					640,
					254,
					140,
					130, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		BufferedImage image3;
		try {
			
			image3 = ImageIO.read(new File("mario.png"));
			
			g.drawImage(image3, 
					400,
					470,
					90,
					105, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}     
		
		BufferedImage image4;
		try {
			
			image4 = ImageIO.read(new File("hola.png"));
			
			g.drawImage(image4, 
					955, 352,
					71,
					71, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}     
		BufferedImage image5;
		try {
			
			image4 = ImageIO.read(new File("hola.png"));
			
			g.drawImage(image4, 
					1030, 352,
					71,
					71, null);
		}catch (IOException e) {
			
			e.printStackTrace();
		}     
        

        //tierra y pasto
        g.setColor(color12); 
        g.fillRect(0, 600, getWidth(), 100);
        g.setColor(Color.black);
		g.fillRect(0, 572, getWidth(), 31);
        g.setColor(new Color(34, 139, 34)); 
        g.fillRect(0, 575, getWidth(), 25);
        
   
    }
    
    private void dibujarCuadrados1(Graphics g, int x, int y,int ancho,int largo,Color color) { 
    	
        g.setColor(Color.BLACK);
        g.fillRoundRect(x-3, y-3, ancho+6, largo+6, 25, 25); 
        g.setColor(color);
        g.fillRoundRect(x, y, ancho, largo, 20, 20); 
        
        }
    
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mario World");
        MarioWorld panel = new MarioWorld();
        
        ventana.add(panel);
        ventana.setSize(1100, 700);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}