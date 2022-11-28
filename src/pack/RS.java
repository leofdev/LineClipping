package pack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RS extends JPanel { //RESULT PANEL

	private static final long serialVersionUID = 1L;
    public static BufferedImage fbuffer;

    public RS(int width, int height) {
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	    Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "");
	    setCursor(blankCursor);

        r();
    }
   
    public void r(){
    	fbuffer = new BufferedImage(M.W, M.H, BufferedImage.TYPE_INT_RGB);
        new Timer().schedule(new TimerTask() {
			public void run() {
				/*while(true) {
					repaint();
				}*/
				repaint();
				pd -= 1;
			}
		}, 99, 99);
        
    }

    int pd = 0;
    
    int middleX = 1200; //M.W / 2;
    int middleY = 600; //M.H / 2;
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Vctr v = new Vctr(0, -100, 0);
        
        
        
        g.setColor(Color.BLACK);
        g.fillRect ( 0, 0, M.W, M.H );
            
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        drawX(x, y, g);
        
        
        int px = (x - (middleX));
        int py = ((middleY +pd) - y);
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 23));
        int xPos = 20;
        int yPos = 20;
        g2d.drawString("X = "+ px +" Y = " + py, xPos, yPos);
        g2d.dispose();

        drawX((int) v.x + (middleX), (int) ((middleY +pd) - v.y), g);
        
        
        
        
        //int clipx = (int) front.x * (inverse.z / (inverse.z - front.z)
        int rx = (int) (px * (v.y / (v.y - py) ));
        drawX(rx + (middleX), (middleY +pd), g);
        
        

        
        
        g.setColor(Color.WHITE);
        g.drawLine(0, middleY +pd, M.W, middleY +pd);
        
        
        g.setColor(Color.WHITE);
        g.drawLine(x, y, (int) v.x + (middleX), (int) ((middleY +pd) - v.y));
        //g.drawLine(x, y, rx + (middleX), (middleY +pd));
        g.dispose();
        
        
        
        g.drawImage(fbuffer, 0, 0, null);
    }
    
    public void drawX(int x, int y, Graphics g) {
        BufferedImage img = null;
		try {
			img = ImageIO.read(new File("x.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        g.drawImage(img, x, y, null, null);
    }
}
