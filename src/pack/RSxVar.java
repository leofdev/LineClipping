package pack;

import java.awt.Color;
import java.awt.Cursor;

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

public class RSxVar extends JPanel { //RESULT PANEL

	private static final long serialVersionUID = 1L;
    public static BufferedImage fbuffer;

    public RSxVar(int width, int height) {
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
				pd--;
			}
		}, 99, 99);
        
    }

    int pd = 0;
    
    int middleX = M.W / 2;
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Vctr v = new Vctr(0, -300, 0);
        
        
        
        g.setColor(Color.BLACK);
        g.fillRect ( 0, 0, M.W, M.H );
            
        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;
        drawX(x + 150, y, g);
        
        Graphics2D g2d = (Graphics2D) g.create();
        
        int px = (x - (middleX));
        int py = ((M.H / 2 +pd) - y);
        
        g2d.setColor(Color.WHITE);
        int xPos = 20;
        int yPos = 20;
        g2d.drawString("X = "+ px +" Y = " + py, xPos, yPos);
        g2d.dispose();

        drawX((int) v.x + (middleX) + 150, (int) ((M.H / 2 +pd) - v.y), g);
        
        
        
        int rx = (int) (px * (v.y / (v.y - py) ));
        drawX(rx + (middleX) + 150, (M.H / 2 +pd), g);
        
        

        
        
        g.setColor(Color.WHITE);
        g.drawLine(0, M.H / 2 +pd, M.W, M.H / 2 +pd);
        
        
        g.setColor(Color.WHITE);
        g.drawLine(x + 150, y, (int) v.x + (middleX) + 150, (int) ((M.H / 2 +pd) - v.y));
        //g.drawLine(x, y, rx + (middleX), (M.H / 2 +pd));
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
