//Kjo eshte klasa main e cila therritet nga kompiluesi per te kryer funksionet
package detyra.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Loja extends Canvas implements Runnable{

	private static final long serialVersionUID = -1766921291481447013L;

	//Permasat e dritares ne ratio 12:9
	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	public Thread thread;
	private boolean running = false;
	private Handler handler;

	
	//krijohet dritarja me permasen nje titull dhe varibli this qe ti referohet kesaj
	public Loja() {
		handler = new Handler();
		//merr funksionin nga tastjera
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Loja v.1", this);

		// gjithmone objektet duhet te jene posht hendler i cili therret GameObject
		handler.addObject(new Player(100, 100, ID.Player));//brenda kllapave jane 3 parametrat x, y, ID
		handler.addObject(new Player(200, 100, ID.Enemy));
	}
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// permban funksionet te cilat e bejne lojen te funksionoje
	public void run() {
		//cdo loje ka nevoje per nje loop
		long lastTime = System.nanoTime();// get current time to the nanosecond
		double amountOfTicks = 60.0; // set the number of ticks 
		double ns = 1000000000/amountOfTicks; // this determines how many times we can devide 60 into 1e9 of nano seconds or about 1 second
		double delta = 0;// change in time (delta always means a change like delta v is change in velocity)
		long timer = System.currentTimeMillis();// get current time
		int frames = 0;// set frame variable
		while(running) {
			long now = System.nanoTime();// get current time in nonoseconds durring current loop
			delta += (now - lastTime) / ns;// add the amount of change since the last loop
			lastTime = now;// set lastTime to now to prepare for next loop
			while(delta >= 1) {
				// one tick of time has passed in the game this 
			    //ensures that we have a steady pause in our game loop 
			    //so we don't have a game that runs way too fast 
			    //basically we are waiting for  enough time to pass so we 
			    // have about 60 frames per one second interval determined to the nanosecond (accuracy)
			    // once this pause is done we render the next frame
				tick();
				delta--;// lower our delta back to 0 to start our next frame wait
				
			}
			if(running)
				render();
			frames++;// note that a frame has passed
			
			if(System.currentTimeMillis() - timer > 1000) {// if one second has passed
				timer += 1000;// add a thousand to our timer for next time
				//System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
				frames = 0;// reset the frame count for the next second
			}
		}
		stop();// no longer running stop the thread
	}
	
	//krijojme metoden render dhe metoden tick per loop e mesiperm
	
	private void tick() {
		//therrasim metoden tick nga klasa Handler
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//therrasim clasen loja
		new Loja();

	}

}
