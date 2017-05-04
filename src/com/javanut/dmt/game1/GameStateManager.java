package com.javanut.dmt.game1;

import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {
	
	private Stack<GameState> states;
	
	public GameStateManager() {
		
		states = new Stack<GameState>();
		states.push(new MenuState(this));
		
	}
	
	public void tick() {
		
		states.peek().tick();
		
	}
	
	public void draw(Graphics g) {
		
		states.peek().draw();
		
	}
	
	public void keyPressed(int k) {
		
	}
	
	public void keyReleased(int k) {
		
	}

}
