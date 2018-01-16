package detyra.main;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject{
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//vendodhjes i shtojme parametrat e levizjes
		//kjo ben qe objekti te levizi me 1 px ne te djathe
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if (id == ID.Player)g.setColor(Color.white);
		else if(id == ID.Enemy)g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
	}
}
