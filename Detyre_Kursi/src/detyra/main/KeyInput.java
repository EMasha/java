package detyra.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import detyra.main.Loja.STATE;

public class KeyInput extends KeyAdapter{
	private boolean[] keyDown = new boolean[4];
	Loja loja ;
	private Handler handler;
	public KeyInput(Handler handler, Loja loja) {
		this.loja = loja;
		this.handler = handler;
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	public void keyPressed(KeyEvent e) {
		//gjenerohet kodi i butonit qe shtypim ne tastjere
		int key = e.getKeyCode();
		//krijon nje cikel i cili kontrollon nese ka ID e player do te beje levizjen e objektit
		System.out.println(key);
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//te gjithe eventet per objketin palyer
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-5); keyDown[0] = true; }
				if(key == KeyEvent.VK_S) {tempObject.setVelY(5); keyDown[1] = true; }
				if(key == KeyEvent.VK_D) {tempObject.setVelX(5); keyDown[2] = true; }
				if(key == KeyEvent.VK_A) {tempObject.setVelX(-5); keyDown[3] = true; }
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		if(key == KeyEvent.VK_P) {
			if(loja.gameState == STATE.Loja) {
				if(Loja.paused) Loja.paused = false;
				else Loja.paused = true;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		//gjenerohet kodi i butonit qe shtypim ne tastjere
		int key = e.getKeyCode();
		//krijon nje cikel i cili kontrollon nese ka ID e player do te beje levizjen e objektit

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//te gjithe eventet per objketin palyer
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				if(key == KeyEvent.VK_D) keyDown[2] = false;
				if(key == KeyEvent.VK_A) keyDown[3] = false;
				// levizja vertikale
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0) ;
				// levizja horizontale
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0) ;
			}
		}
	}

}
