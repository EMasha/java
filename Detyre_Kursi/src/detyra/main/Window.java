//funksioni i kesaj klase eshte qe te krijoje dritaren 
package detyra.main;
import java.awt.Canvas;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		
		//Vendos imazh si background
		/*try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(this.getClass().getResource("/mars2.png")))));
			System.out.println("loaded background");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//mbyllja e lojes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(true);
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
