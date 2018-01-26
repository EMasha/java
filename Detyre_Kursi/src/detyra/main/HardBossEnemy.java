package detyra.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HardBossEnemy extends GameObject{
	private GameObject player;
	public HardBossEnemy(float x, float y, ID id,Handler handler) {
		
		super( x,  y, id);
		
		velX = 5;
		velY = 5;
		
		//kerkon per vendodhjen e objektit tone
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
			
		}

	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}

	public void tick() {
		x += velX;
		y += velY;
		//gjen vendodhjen e lojtarit
		float diffx = x - player.getX();
		float diffy = y - player.getY();
		//gjen distancen nga smart te lojtari
		float distance = (float) Math.sqrt((x - player.getX())*(x - player.getX())+(y - player.getY())*(y - player.getY()));
		//percakton vendin ku do te shkoje smart
		velX = (float) ((-1.0/distance)*diffx);
		velY = (float) ((-1.0/distance)*diffy);
		
		if(y <= 0 || y >= Loja.HEIGHT -48) velY *= -1; 
		if(x <= 0 || x >= Loja.WIDTH - 32) velX *= -1; 
		
	}


	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)x, (int)y, 64, 64);
		
	}
}
