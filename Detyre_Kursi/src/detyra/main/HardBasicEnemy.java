package detyra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class HardBasicEnemy extends GameObject{
	private BufferedImage hardBasicEnemy_image;

	public HardBasicEnemy(float x, float y, ID id) {
		super(x, y, id);
		velX = 10;
		velY = 10;
		
		SpriteSheet ss = new SpriteSheet(Loja.sprite_sheet);
		hardBasicEnemy_image = ss.grabImage(4, 1, 32, 32);
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Loja.HEIGHT -48) velY *= -1; 
		if(x <= 0 || x >= Loja.WIDTH - 32) velX *= -1; 
		
	}


	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int)x, (int)y, 16, 16);
		g.drawImage(hardBasicEnemy_image, (int) x, (int) y, null);
		
	}

}
