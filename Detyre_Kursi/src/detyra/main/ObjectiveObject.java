package detyra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ObjectiveObject extends GameObject{
	private static final String ObjectiveObject = null;
	Random r = new Random();
	private BufferedImage objectiveObject_image;

	public ObjectiveObject(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		SpriteSheet ss = new SpriteSheet(Loja.sprite_sheet);
		objectiveObject_image = ss.grabImage(3, 1, 18, 18);

	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 18, 18);
	}

	public void tick() {

		
	}

	@Override
	public void render(Graphics g) {

		//g.setColor(Color.green);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(objectiveObject_image, (int) x, (int) y, null);
	}

}
