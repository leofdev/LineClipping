package pack;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;

public class WindowResults extends JFrame {

	private static final long serialVersionUID = 1L;
	public static KeyboardFocusManager MANAGER = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	
	public static RS p;
	public WindowResults(){
		setSize(M.W, M.H);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p = new RS(M.W, M.H);
		setContentPane(p);
		setVisible(true);
	}

}
