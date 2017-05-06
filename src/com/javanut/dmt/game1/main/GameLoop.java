package com.javanut.dmt.game1.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.javanut.dmt.game1.gamestates.GameStateManager;

// class for the game loop
public class GameLoop implements Runnable, KeyListener{
	
	private Thread thread;
	private boolean isRunning = false;
	private Graphics g;
	private int FPS = 45;
	private long targetTime = 1_000_000_000/FPS;
	
	GamePanel gp = new GamePanel();
	GameStateManager gsm = new GameStateManager();
	
	public GameLoop(GamePanel gp, GameStateManager gsm) {
		
		this.gp = gp;
		this.gsm = gsm;
		
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
	
	public void tick() {
		
		System.out.println("Running");
		gsm.tick();
	}
	
	public void draw(Graphics g) {
		
		g.clearRect(0, 0, gp.WIDTH, gp.HEIGHT);
		gsm.draw(g);
		
	}
	
	public void keyPressed(KeyEvent e) {		
		
		gsm.keyPressed(e.getKeyCode());
		
	}
	
	public void keyReleased(KeyEvent e) {		
		
		gsm.keyReleased(e.getKeyCode());
		
	}
	
	public void keyTyped(KeyEvent e) {		
		
	}

}