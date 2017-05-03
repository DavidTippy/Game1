package com.javanut.dmt.game1;

import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {
	
	private Stack<GameState> states;
	
	public GameStateManager() {
		
		states = new Stack<GameState>();
		
	}
	
	public void tick() {
		
		states.peek().tick();
		
	}
	
	public void draw(Graphics g) {
		
		states.peek().draw();
		
	}

}
