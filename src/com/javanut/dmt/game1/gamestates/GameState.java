package com.javanut.dmt.game1.gamestates;

import java.awt.Graphics;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		
		this.gsm = gsm;
		init();
		
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int i);
	public abstract void keyReleased(int i);

}
