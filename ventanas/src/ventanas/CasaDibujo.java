package ventanas;

import javax.swing.*;
import java.awt.*;

public class CasaDibujo extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //cielo xd
        g.setColor(new Color(50, 180, 255)); 
        g.fillRect(0, 0, getWidth(), getHeight());

        //tierra y pasto
        g.setColor(new Color(139, 69, 19)); 
        g.fillRect(0, 300, getWidth(), 200);
        g.setColor(new Color(34, 139, 34)); 
        g.fillRect(0, 300, getWidth(), 25);
    
        //pa pintar las cercas
        g.setColor(new Color(139, 69, 19));
        g.fillRect(0, 225, 800, 40);
        g.setColor(new Color(255, 180, 50));
        for (int i = 0; i < getWidth(); i += 50) {
            int[] x = {i, i + 20, i + 40};
            int[] y = {200, 160, 200};
            g.fillPolygon(x, y, 3); //pico d las cercas
            g.fillRect(i, 200, 40, 100); //tabla d las cercas
        }
    
        //pintar casa y sus lineas
        g.setColor(new Color(255, 220, 120)); 
        g.fillRect(150, 150, 300, 150);
        g.setColor(new Color(200, 160, 80)); 
        for (int i = 0; i <= 120; i += 30) {
            g.fillRect(150, 150 + i, 300, 5);
        }
          
        //luis miguel
        g.setColor(Color.YELLOW);
        g.fillOval(40,20, 70, 70);
        
        //humo d chimnea
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(360,20 , 60, 70);
        g.fillOval(371,0 , 40, 50);
 
        //nubes xd
        g.setColor(Color.white);
        g.fillOval(455,20 , 60, 55);
        g.fillOval(500,20 , 60, 55);
        g.fillOval(540,23 , 60, 50);
        
        g.fillOval(620,20 , 60, 55);
        g.fillOval(665,20 , 60, 55);
        g.fillOval(710,23 , 60, 50);
        
        //techito
        g.setColor(new Color(200, 30, 30));
        int[] xTecho = {130, 300, 470};
        int[] yTecho = {150, 50, 150};
        g.fillPolygon(xTecho, yTecho, 3);
       
        //pa la puerta y ventana
        g.setColor(new Color(100, 100, 100));
        g.fillRect(370, 70, 40, 60);
        g.setColor(new Color(80, 80, 80));
        g.fillRect(360, 70, 60, 20);

        //puerta
        g.setColor(new Color(150, 100, 50));
        g.fillRect(190, 200, 80, 100);
        g.setColor(new Color(139, 69, 19));
        g.fillRect(205, 210, 20, 40);
        g.fillRect(235, 210, 20, 40);
        g.fillRect(205, 257, 50, 35);
        g.setColor(Color.WHITE);
        g.fillOval(260, 250, 7, 7); 
   
        //vemtana
        g.setColor(new Color(200, 30, 30));
        g.fillRect(320, 180, 80, 60);
        g.setColor(Color.WHITE);
        g.fillRect(325, 185, 30, 25);
        g.fillRect(365, 185, 30, 25);
        g.fillRect(325, 215, 30, 25);
        g.fillRect(365, 215, 30, 25);
        
        //decoracion ventna
        g.setColor(new Color(80, 80, 80));
        g.fillRect(315, 240, 90, 10);
        
        dibujarFlor(g, 100, 295);
        dibujarFlor(g, 180, 290);
        dibujarFlor(g, 260, 295);
        dibujarFlor(g, 400, 290);
        dibujarFlor(g, 550, 295);
        dibujarFlor(g, 670, 290);
        
        dibujarAve(g,600,100);
        dibujarAve(g,650,125);
        dibujarAve(g,550,125);
    }

    private void dibujarFlor(Graphics g, int x, int y) {
        
    	//palito
        g.setColor(Color.GREEN);
        g.fillRect(x + 8, y + 10, 4, 15);

        //hojas
        g.setColor(Color.PINK);
        g.fillOval(x, y, 10, 10);
        g.fillOval(x + 10, y, 10, 10);
        g.fillOval(x, y + 10, 10, 10);
        g.fillOval(x + 10, y + 10, 10, 10);

        //centro
        g.setColor(Color.YELLOW);
        g.fillOval(x + 5, y + 5, 8, 8);
    }
    
    private void dibujarAve (Graphics g, int x, int y) {
    	
    	//hacerlas mas gordas
    	Graphics2D g2 = (Graphics2D) g; 
    	g2.setStroke(new BasicStroke(2));
    	g.setColor(Color.black);
    	
    	//alas
    	g.drawArc(x, y, 40, 20, 0 ,90);
    	g.drawArc(x+40, y, 40, 20,90 ,90);
    }
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Dibujo de Casa");
        CasaDibujo panel = new CasaDibujo();
        
        ventana.add(panel);
        ventana.setSize(800, 450);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}