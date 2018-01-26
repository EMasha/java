package detyra.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import detyra.main.Loja.STATE;

public class Menu extends MouseAdapter{
	private Loja loja;
	private Handler handler;
	private HUD hud;
	private Random r;
	
	public Menu(Loja loja, Handler handler, HUD hud) {
		this.loja = loja;
		this.hud = hud;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		r = new Random();
		if(loja.gameState == STATE.Menu) {
			//ketu therritet metoda e cila kontrollon mausin ne momentin e klikimit
			//metoda e butonit luaj
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				//loja.gameState = STATE.Loja;
				
				//handler.addObject(new Player(r.nextInt(loja.WIDTH), r.nextInt(loja.HEIGHT), ID.Player, handler));
				//handler.addObject(new ObjectiveObject(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.objectiveObject, handler));//brenda kllapave jane 3 parametrat x, y, ID
		
				//for(int i = 0; i<3; i++) 
				//handler.addObject(new BasicEnemy(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.basicEnemy));
				loja.gameState = STATE.Select;
				return;

			}
			//metoda e butonit dil
			if (mouseOver(mx, my, 210, 350,200, 64)) {
				System.exit(1);
			}
			
			//metoda e butonit ndihme
			if(mouseOver(mx, my, 210, 250,200, 64)) {
				loja.gameState = STATE.Ndihme;
			}
		}

		if(loja.gameState == STATE.Select) {
			
			//metoda e butonit e lehte
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				loja.gameState = STATE.Loja;
				
				handler.addObject(new Player(r.nextInt(loja.WIDTH), r.nextInt(loja.HEIGHT), ID.Player, handler));
				handler.addObject(new ObjectiveObject(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.objectiveObject, handler));//brenda kllapave jane 3 parametrat x, y, ID
		
				for(int i = 0; i<3; i++) 
				handler.addObject(new BasicEnemy(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.basicEnemy));
				loja.veshtiresia = 0;

			}
			//metoda e butonit e veshtire
			if (mouseOver(mx, my, 210, 250,200, 64)) {
				loja.gameState = STATE.Loja;
				
				handler.addObject(new Player(r.nextInt(loja.WIDTH), r.nextInt(loja.HEIGHT), ID.Player, handler));
				handler.addObject(new ObjectiveObject(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.objectiveObject, handler));//brenda kllapave jane 3 parametrat x, y, ID
		
				for(int i = 0; i<3; i++) 
				handler.addObject(new HardBasicEnemy(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.hardBasicEnemy));
				loja.veshtiresia = 1;
			}
			
			//metoda e butonit kthehu
			if(mouseOver(mx, my, 210, 350,200, 64)) {
				loja.gameState = STATE.Menu;
				return;
			}
		}
		
		
		//butoni kthehu ne menune ndihme
		if(loja.gameState == STATE.Ndihme) {
			if(mouseOver(mx, my, 350, 350,200, 64)) {
				loja.gameState = STATE.Menu;
				return;
			}
		}
		//butoni provo perseri
		if(loja.gameState == STATE.Fund) {
			if(mouseOver(mx, my, 350, 350,200, 64)) {
				loja.gameState = STATE.Loja;
				hud.setPlanet(1);
				hud.piket(0);
				handler.addObject(new Player(r.nextInt(loja.WIDTH), r.nextInt(loja.HEIGHT), ID.Player, handler));
				handler.addObject(new ObjectiveObject(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.objectiveObject, handler));//brenda kllapave jane 3 parametrat x, y, ID
		
				for(int i = 0; i<3; i++) 
				handler.addObject(new BasicEnemy(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.basicEnemy));
			}
		}
		
		
		if(loja.gameState == STATE.Niveli) {
			if(mouseOver(mx, my, 350, 350,200, 64)) {
				loja.paused = false;
				loja.gameState = STATE.Loja;
				handler.addObject(new Player(r.nextInt(loja.WIDTH), r.nextInt(loja.HEIGHT), ID.Player, handler));
				handler.addObject(new ObjectiveObject(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.objectiveObject, handler));//brenda kllapave jane 3 parametrat x, y, ID
		
				for(int i = 0; i<3; i++) 
				handler.addObject(new BasicEnemy(r.nextInt(loja.WIDTH/2-32), r.nextInt(loja.HEIGHT/2-32), ID.basicEnemy));
				if(hud.planeti == 3) {
					if(mouseOver(mx, my, 350, 350,200, 64)) {
						//loja.gameState = STATE.Fitore;
						handler.clearFitore();
						if(mouseOver(mx, my, 350, 350,200, 64)) {
							//loja.gameState = STATE.Fitore;
							loja.paused = false;
							hud.setPlanet(1);
							hud.piket(0);
							if(mouseOver(mx, my, 350, 350,200, 64)) {
								loja.gameState = STATE.Menu;
							}
							
						}
					}
				}
								
			}
			
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	//metoda e cila kontrollon vendodhjen e mausit nese eshte brena butonit return true
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(loja.gameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 240, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Luaj", 280, 190);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Ndihme", 260, 290);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Dil", 295, 390);
			
			
			g.setColor(Color.white);
			g.drawRect(210, 150,200, 64);
			
			g.setColor(Color.white);
			g.drawRect(210, 250,200, 64);
			
			g.setColor(Color.white);
			g.drawRect(210, 350,200, 64);
		}else if(loja.gameState == STATE.Ndihme){
			Font fnt = new Font("arial", 1, 50);
			
			
			g.setFont(fnt);
			Font fnt2 = new Font("arial", 1, 30);
			g.setColor(Color.white);
			g.drawString("NDIHME", 200, 70);
			g.setFont(fnt2);
			g.drawString("Per te levizur perdorni butonat W A S D", 30, 150);
			g.drawString("Qellimi i lojes eshte te mblidhni 1000 pike", 15, 200);
			g.drawString("duke qendruar mbi piken jeshile", 70, 250);
			g.drawString("kujdes nga kundershtaret", 120, 300);
			
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Ktheu", 410, 390);
			g.setColor(Color.white);
			g.drawRect(350, 350,200, 64);
		
		}else if(loja.gameState == STATE.Select) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Zgjidh Veshtriresine", 70, 70);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("E Lehte", 260, 190);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("E Veshtire", 240, 290);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Kthehu", 260, 390);
			
			
			g.setColor(Color.white);
			g.drawRect(210, 150,200, 64);
			
			g.setColor(Color.white);
			g.drawRect(210, 250,200, 64);
			
			g.setColor(Color.white);
			g.drawRect(210, 350,200, 64);
		}else if(loja.gameState == STATE.Fund){
			Font fnt = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 20);
			
			
			g.setFont(fnt);
			Font fnt2 = new Font("arial", 1, 30);
			g.setColor(Color.white);
			g.drawString("Game Over", 150, 70);
			g.setFont(fnt3);
			g.drawString("Ju humbet ne planetin " + hud.getPlanet() +". Piket e tua: " + (hud.getScore() + ((hud.getPlanet()-1)*100)), 30, 150);
			
			
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Provo serisht", 355, 390);
			g.setColor(Color.white);
			g.drawRect(350, 350,200, 64);
		
		}/*else if(loja.gameState == STATE.Fitore){
			Font fnt = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 20);
			
			
			g.setFont(fnt);
			Font fnt2 = new Font("arial", 1, 30);
			g.setColor(Color.white);
			g.drawString("Game Over", 200, 70);
			g.setFont(fnt3);
			g.drawString("Ju Fituat. Piket e tua: " + (hud.getScore() + ((hud.getPlanet()-1)*100)), 30, 150);
			
			
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("Menu", 355, 390);
			g.setColor(Color.white);
			g.drawRect(350, 350,200, 64);
		
		}*/else if(loja.gameState == STATE.Niveli){
			Font fnt = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 20);
			
			if(hud.getPlanet() == 1) {
				g.setFont(fnt);
				Font fnt2 = new Font("arial", 1, 30);
				g.setColor(Color.white);
				g.drawString("Planeti Mars", 150, 70);
				g.setFont(fnt3);
				g.drawString("Distanca: 227,940,000 km (1.52 AU) Nga Dielli", 15, 150);
				g.drawString("Distanca: 58.000.000 Km deri ne 402.000.000 km nga Toka", 15, 200);
				g.drawString("Diametri: 6,794 km", 15, 250);
				g.drawString("Masa: 6.4219e23 kg", 15, 300);
				
			
				g.setFont(fnt2);
				g.setColor(Color.white);
				g.drawString("Planeti tjeter", 360, 390);
				g.setColor(Color.white);
				g.drawRect(350, 350,200, 64);
			} else if(hud.getPlanet() == 2) {
				g.setFont(fnt);
				Font fnt2 = new Font("arial", 1, 30);
				g.setColor(Color.white);
				g.drawString("Planeti Saturn", 150, 70);
				g.setFont(fnt3);
				g.drawString("Numri i hënave: 61", 15, 150);
				g.drawString("Diametri:	120.536 ±8 km (ekuator)", 15, 200);
				g.drawString("Sipërfaqja: 1 / 10,21", 15, 250);
				g.drawString("Masa: 5,685×1026 kg", 15, 300);
				
			
				g.setFont(fnt2);
				g.setColor(Color.white);
				g.drawString("Planeti tjeter", 360, 390);
				g.setColor(Color.white);
				g.drawRect(350, 350,200, 64);
			}else if(hud.getPlanet() == 3) {
				g.setFont(fnt);
				Font fnt2 = new Font("arial", 1, 30);
				g.setColor(Color.white);
				g.drawString("Planeti Jupiter", 150, 70);
				g.setFont(fnt3);
				g.drawString("Numri i hënave: 63", 15, 150);
				g.drawString("Diametri: 142.984 (±8) km (ekuator)", 15, 200);
				g.drawString("Siperfaqja: 1/15,41", 15, 250);
				g.drawString("Masa: 1,899×1027kg", 15, 300);
				
			     
				
				
				
				g.setFont(fnt);
				
				g.setColor(Color.white);
				//g.drawString("Game Over", 300, 300);
				g.setFont(fnt3);
				g.drawString("Ju Fituat. Piket e tua: " + (hud.getScore() + ((hud.getPlanet()-1)*100)), 325, 325);
				
				
				
						
				
				g.setFont(fnt2);
				g.setColor(Color.white);
				g.drawString("Menu", 410, 390);
				g.setColor(Color.white);
				g.drawRect(350, 350,200, 64);
			}
		
		}
		
	}
	
}
