package com.javanut.dmt.game1.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.main.GamePanel;

public class MenuState extends GameState{
	
	private String[] options = {"New Game", "Continue", "Quit"};
	private int currentSelection = 0;

	public MenuState(GameStateManager gsm) {
		super(gsm);
		
	}

	
	public void init() {
		
		
	}

	
	public void tick() {
		
		
	}

	
	public void draw(Graphics g) {
		
		for(int i = 0; i < options.length; i++){
			
			g.setColor(getColor(i));
			
			g.drawString(options[i], GamePanel.WIDTH / 2 - 50, 40 + i * 30);
			
		}
		
	}


	
	public void keyPressed(int i) {		
		
		if(i == KeyEvent.VK_DOWN) {
			
			currentSelection++;			
			if(currentSelection >= options.length) {
				currentSelection = 0;	
			}
			
		} else if(i == KeyEvent.VK_UP) {
			
			currentSelection--;
			if(currentSelection < 0) {
				currentSelection = options.length - 1;				
			}
			
		}
		
	}


	
	public void keyReleased(int i) {		
		
	}
	
	private Color getColor(int i) {
		
		if(i == currentSelection) {
			
			return Color.RED;
			
		} else {
			
			return Color.BLACK;
			
		}
		
	}

}
