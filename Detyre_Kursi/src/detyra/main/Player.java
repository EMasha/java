package detyra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	private BufferedImage player_image;



	public Player(float x, float y, ID id, Handler handler ) {
		super(x, y, id);
		this.handler = handler;
		SpriteSheet ss = new SpriteSheet(Loja.sprite_sheet);
		player_image = ss.grabImage(1, 1, 32, 32);
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}


	@Override
	public void tick() {
		//vendodhjes i shtojme parametrat e levizjes
		//kjo ben qe objekti te levizi me 1 px ne te djathe
		x += velX;
		y += velY;
		
		x = Loja.clamp(x, 0, Loja.WIDTH-48);
		y = Loja.clamp(y, 0, Loja.HEIGHT-70);
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.basicEnemy || tempObject.getId() == ID.smartEnemy|| tempObject.getId() == ID.enemyBoss || tempObject.getId() == ID.hardBasicEnemy || tempObject.getId() == ID.hardBosEnemy || tempObject.getId() == ID.hardSmartEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH -= 2;
					}
			}
			else if(tempObject.getId() == ID.objectiveObject) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.piket += 1;
					
				}
			}
		}
	}

	public void render(Graphics g) {
	
		//g.setColor(Color.white);
		//g.fillRect((int)x,(int) y, 32, 32);
		g.drawImage(player_image, (int) x, (int) y, null);
	}
	
}
