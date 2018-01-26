//Klasa e cila do te permbaje te gjithe objektet qe permban loja
//pra secili objekt do te trashegoje te gjithe funksonet e Game Object
package detyra.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	//protected tregon qe ky tip mund te aksesohet vetem nga objektet qe trashegojne kete klase
	protected float x, y;
	//krijojme variablin ID qw e therret nga klasa enumeration
	protected ID id;
	protected float velX;
	//krijojme variablat e shpejtesive
	protected float velY;
	
	//ndertojme konstruktorin per Game Object
	public GameObject(float x, float y, ID id) {
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
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
}
