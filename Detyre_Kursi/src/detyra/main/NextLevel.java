package detyra.main;

import java.util.Random;

public class NextLevel {
	
	private static final GameObject basic = null;
	private Handler handler;
	private HUD hud;
	
	private Random r = new Random();
	private int piket = 0;
	public NextLevel(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
	}
	public void tick() {
		if(Loja.veshtiresia == 0) {
			if(hud.piket >= 100) {
				hud.piket = 0;
				hud.setPlanet(hud.getPlanet()+1);
				if(hud.getPlanet() == 2) {
					handler.addObject(new BasicEnemy(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.basicEnemy));
					handler.addObject(new smart(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.smartEnemy, handler));
					
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getId() == ID.objectiveObject) {
							handler.object.get(i).setX(r.nextInt(Loja.WIDTH/2-32));
							handler.object.get(i).setY(r.nextInt(Loja.HEIGHT/2-32));
						}
					}
				}
				else if(hud.getPlanet() == 3) {
					handler.clearEnemys();
					handler.addObject(new EnemyBoss(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.enemyBoss, handler));
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getId() == ID.objectiveObject) {
							handler.object.get(i).setX(r.nextInt(Loja.WIDTH/2-32));
							handler.object.get(i).setY(r.nextInt(Loja.HEIGHT/2-32));
						}
					}
					
				}
				
			}
		}else if(Loja.veshtiresia == 1) {
			 if(hud.piket >= 100) {
				hud.piket = 0;
				hud.setPlanet(hud.getPlanet()+1);
				if(hud.getPlanet() == 2) {
					handler.clearEnemys();
					handler.addObject(new HardBasicEnemy(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.hardBasicEnemy));
					handler.addObject(new HardSmartEnemy(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.hardSmartEnemy, handler));
					for(int i = 0; i<3; i++) 
						handler.addObject(new HardBasicEnemy(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.hardBasicEnemy));
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getId() == ID.objectiveObject) {
							handler.object.get(i).setX(r.nextInt(Loja.WIDTH/2-32));
							handler.object.get(i).setY(r.nextInt(Loja.HEIGHT/2-32));
						}
					}
				}
				else if(hud.getPlanet() == 3) {
					handler.clearEnemys();
					handler.addObject(new HardBossEnemy(r.nextInt(Loja.WIDTH/2-32), r.nextInt(Loja.HEIGHT/2-32), ID.hardBosEnemy, handler));
					for(int i = 0; i < handler.object.size(); i++) {
						if(handler.object.get(i).getId() == ID.objectiveObject) {
							handler.object.get(i).setX(r.nextInt(Loja.WIDTH/2-32));
							handler.object.get(i).setY(r.nextInt(Loja.HEIGHT/2-32));
						}
					}
					
				}
				
			}
			
		}
	}

}
