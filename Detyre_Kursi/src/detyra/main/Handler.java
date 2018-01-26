//perditeson te gjithe objektet ne render
//kalon ne loop ne secilin objekt, i perditeson secilin prej tyre dhe i shfaq ne ekran

package detyra.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
	//bejme nje liste met e gjithe objektet qe do te permbaje loja dhe ben FPS
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	private Random r;
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
	public void clearEnemys() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player || tempObject.getId() == ID.objectiveObject) {
				object.clear();
				if(Loja.gameState != Loja.STATE.Niveli) {
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
					addObject(new ObjectiveObject((int)tempObject.getX(), (int)tempObject.getY(), ID.objectiveObject, this));
				}
				
			}
		}
	}
	
	public void clearAll() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player || tempObject.getId() == ID.objectiveObject) {
				object.clear();
				if(Loja.gameState != Loja.STATE.Fund && Loja.gameState != Loja.STATE.Niveli) {
					addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
				}
				
				
			}
		}
	}
	public void clearNiveli() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId() == ID.Player || tempObject.getId() == ID.objectiveObject) {
				object.clear();
						
				
			}
		}
	}
	public void clearFitore() {
		object.clear();
	}
	



}
