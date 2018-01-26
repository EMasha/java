package detyra.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferImageLoader {
	BufferedImage image;
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(this.getClass().getResource("/spreed-sheet.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}

}
