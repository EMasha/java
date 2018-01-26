//kjo eshte klasa e cila do te permbaje piket e jetes
package detyra.main;

import java.awt.Graphics;

import java.awt.Color;

public class HUD {
	
	public static float HEALTH = 100;
	
	private float greenValue = 255;
	public static int piket = 0;
	public static int planeti = 1;
	
	public void tick() {
		
		HEALTH = Loja.clamp(HEALTH, 0, 100);
		greenValue = Loja.clamp(greenValue, 0, 255);
		greenValue = HEALTH*2;
		
	}
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15,(int) HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Piket: " + piket, 15, 64);

		if(planeti == 1) {
			g.drawString("Palneti: Mars", 15, 80);
		}
		else if (planeti == 2) {
			g.drawString("Palneti: Saturn", 15, 80);
		}else if (planeti == 3) {
			g.drawString("Palneti: Jupiter", 15, 80);
		}
		
		
	}
	public void piket(int piket) {
		this.piket = piket;
	}
	
	public int getScore() {
		return piket;
	}
	

	
	public int getPlanet() {
		return planeti;
	}
	
	public void setPlanet(int planeti) {
		this.planeti = planeti;
	}
	

}
