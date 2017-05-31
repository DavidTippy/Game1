package com.javanut.dmt.game1.gamestates;

import java.awt.Graphics;

import com.javanut.dmt.game1.entities.Player;
import com.javanut.dmt.game1.solids.Block;

public class Level1State extends GameState{
	
	private Player player;
	
	private Block[] b;

	public Level1State(GameStateManager gsm) {
		
		super(gsm);
		
	}

	
	public void init() {
		
		player = new Player(16,32);
		
		b = new Block[3];
		
		// create blocks
		b[0] = new Block(100,100);
		b[1] = new Block(200,200);
		b[2] = new Block(400,400);
		
	}

	
	public void tick() {
		
		for(int i = 0; i < b.length; i++) {
			
			b[i].tick();
			
		}
		
		player.tick(b);
		
	}

	
	public void draw(Graphics g) {
		
		player.draw(g);
		
		for(int i = 0; i < b.length; i++) {
			
			b[i].draw(g);
			
		}
		
	}

	
	public void keyPressed(int i) {
		
		player.keyPressed(i);
		
	}

	
	public void keyReleased(int i) {
		
		player.keyReleased(i);
		
	}
	
}
