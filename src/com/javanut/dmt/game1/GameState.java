package com.javanut.dmt.game1;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	protected GameState(GameStateManager gsm) {
		
		this.gsm = gsm;
		init();
		
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw();

}
