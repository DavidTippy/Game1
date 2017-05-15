package com.javanut.dmt.game1.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.main.GamePanel;

public class Player extends Rectangle{
	
	private boolean right = false, left = false;
	
	public Player(int width, int height) {
		
		setBounds(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, width,height);
		
	}
	
	public void tick() {
		
		if (right) {
			
			x++;
			
		}
		
		if (left) {
			
			x--;
			
		}
		
	}
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
	}
	
	public void keyPressed(int i) {
		
		if(i == KeyEvent.VK_RIGHT) right = true;
		if(i == KeyEvent.VK_LEFT) left = true;
		
	}
	
	public void keyReleased(int i){
		
		if(i == KeyEvent.VK_RIGHT) right = false;
		if(i == KeyEvent.VK_LEFT) left = false;
		
		
	}
	
}
