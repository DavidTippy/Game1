package com.javanut.dmt.game1.gamestates;

import java.awt.Color;
import java.awt.Font;
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
			
			
			g.setFont(new Font("Arial", Font.PLAIN, getFontSize(i)));
			g.drawString(options[i], GamePanel.WIDTH / 2 - 80, 150 + i * 60);
			
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
		
		if(i == KeyEvent.VK_ENTER) {
			if(currentSelection == 0) {
				
				gsm.states.push(new PlayState(gsm));
				
			} else if(currentSelection == 1) {
				
				
				
			} else if(currentSelection == 2) {
				
				System.exit(0);
				
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
	
	private int getFontSize(int i) {
		
		if(i == currentSelection) {
			
			return 48;
			
		} else {
			
			return 36;
			
		}
		
	}

}
