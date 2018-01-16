//perditeson te gjithe objektet ne render
//kalon ne loop ne secilin objekt, i perditeson secilin prej tyre dhe i shfaq ne ekran

package detyra.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	//bejme nje liste met e gjithe objektet qe do te permbaje loja dhe ben FPS
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		//cikli i cili kalon neper te gjithe objektet 
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	public void render(Graphics g) {
		//cikli qe kalon per te gjithe objektet dhe ben renderimin
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	//ky funksion shton objektet ne liste 
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	//ky funksion heq objektet nga liste 
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}
