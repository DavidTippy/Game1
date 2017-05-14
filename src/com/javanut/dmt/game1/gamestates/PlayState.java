package com.javanut.dmt.game1.gamestates;

import java.awt.Graphics;

import com.javanut.dmt.game1.entities.Player;

public class PlayState extends GameState{
	
	private Player player;

	public PlayState(GameStateManager gsm) {
		
		super(gsm);
		
	}

	
	public void init() {
		
		player = new Player(30,50);
		
	}

	
	public void tick() {
		
		player.tick();
		
	}

	
	public void draw(Graphics g) {
		
		player.draw(g);
		
	}

	
	public void keyPressed(int i) {
		
		player.keyPressed(i);
		
	}

	
	public void keyReleased(int i) {
		
		player.keyReleased(i);
		
	}
	
}
