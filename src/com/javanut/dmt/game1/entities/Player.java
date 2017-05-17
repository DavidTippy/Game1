package com.javanut.dmt.game1.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.main.GamePanel;

public class Player {
	
	private boolean right = false, left = false, jumping = false, falling = false;
	
	private double x,y;
	private int width,height;
	
	public Player(int width, int height) {
		
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
		this.width = width;
		this.height = height;
		
	}
	
	public void tick() {
		
		if (right) {
			
			x += 3;
			
		}
		
		if (left) {
			
			x -= 3;
			
		}
		
		if(jumping) {
			
		}
		
		if(falling) {
			
		}
		
	}
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
		
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
