package detyra.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	public KeyInput(Handler handler) {
		this.handler = handler;
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
				if(key == KeyEvent.VK_W) tempObject.setVelY(-1);
				if(key == KeyEvent.VK_S) tempObject.setVelY(1);
				if(key == KeyEvent.VK_D) tempObject.setVelX(1);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-1);
			}
		}
	}
	public void relesePressed(KeyEvent e) {
		//gjenerohet kodi i butonit qe shtypim ne tastjere
		int key = e.getKeyCode();
		//krijon nje cikel i cili kontrollon nese ka ID e player do te beje levizjen e objektit
		System.out.println(key);
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				//te gjithe eventet per objketin palyer
				if(key == KeyEvent.VK_W) tempObject.setVelY(-1);
				if(key == KeyEvent.VK_S) tempObject.setVelY(1);
				if(key == KeyEvent.VK_D) tempObject.setVelX(1);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-1);
			}
		}
	}


}
