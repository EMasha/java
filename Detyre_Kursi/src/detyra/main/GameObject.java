//Klasa e cila do te permbaje te gjithe objektet qe permban loja
//pra secili objekt do te trashegoje te gjithe funksonet e Game Object
package detyra.main;

import java.awt.Graphics;

public abstract class GameObject {
	//protected tregon qe ky tip mund te aksesohet vetem nga objektet qe trashegojne kete klase
	protected int x, y;
	//krijojme variablin ID qw e therret nga klasa enumeration
	protected ID id;
	//krijojme variablat e shpejtesive
	protected int velX, velY;
	
	//ndertojme konstruktorin per Game Object
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id; 
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}

}
