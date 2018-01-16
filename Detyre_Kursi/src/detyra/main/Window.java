//funksioni i kesaj klase eshte qe te krijoje dritaren 
package detyra.main;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	
	private static final long serialVersionUID = -240840600533728354L;
	
	//ndertojme nje konstruktor me 3 parametra, 2 numra per permasat dhe nje tekst per titullin
	public Window(int width, int height, String title, Loja game) {
		
		//korrniza e dritares
		JFrame frame = new JFrame(title);
		
		//percaktojme permasat e dritares
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//mbyllja e lojes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		// ben qe dritarja te shfaqet ne qender
		frame.setLocationRelativeTo(null);
		//vendosim klasen Loja ne kornizen e lojes
		frame.add(game);
		//e bejme te dukshme
		frame.setVisible(true);
		//therrasim metoden start qe kemi krijuar te clasa Loja
		game.start();
	}

}
