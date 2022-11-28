package pack;

import java.awt.Dimension;
import java.awt.Toolkit;

public class M {
	
	static int W;
	static int H;
	
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		W = screenSize.width;
		H = screenSize.height;
		
		new WindowResults();
	}

}
