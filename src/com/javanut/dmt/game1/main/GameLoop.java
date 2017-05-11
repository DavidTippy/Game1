package com.javanut.dmt.game1.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// class for the game loop
public class GameLoop implements Runnable{
	
	private Thread thread;
	private boolean isRunning = false;
	private Graphics g;
	private int FPS = 45;
	private long targetTime = 1_000_000_000/FPS;
	
	GamePanel gp;	
	
	public GameLoop(GamePanel gp) {
		
		
		this.gp = gp;
		
		
	}
	
	public void start() {
		
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run() {
		
		long start, elapsed, wait;
		
		while(isRunning) {
			
			start = System.nanoTime();
			
			gp.tick();
			gp.repaint();		
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed;
			
			if (wait <= 0) {
				
				wait = 0;
				
			}
			
			try {
				Thread.sleep(wait/1_000_000,(int)wait%1_000_000);
			} catch(InterruptedException e) {
				System.exit(0);
			}
			
		}
		
		
	}
	
	

}