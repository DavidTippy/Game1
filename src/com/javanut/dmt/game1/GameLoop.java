package com.javanut.dmt.game1;

import java.awt.Graphics;
import javax.swing.JPanel;

// class for the game loop
public class GameLoop implements Runnable{
	
	private Thread thread;
	private boolean isRunning = false;
	private Graphics g;
	private int FPS = 45;
	private long targetTime = 1_000_000_000/FPS;
	
	public GameLoop() {
		
		
		
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
			
			tick();
			
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
	
	public void tick() {
		
		System.out.println("Running");
		
	}
	


}
