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
	
	// jump speed
	private double jumpSpeed = 5;
	private double currentJumpSpeed = jumpSpeed;
	
	// fall speed
	private double maxFallSpeed = 5;
	private double currentFallSpeed = 0.1;
	
	public Player(int width, int height) {
		
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
		this.width = width;
		this.height = height;
		
	}
	
	public void tick() {
		
		if (right) {
			
			x += 1;
			
		}
		
		if (left) {
			
			x -= 1;
			
		}
		
		if(jumping) {
			
			y -= currentJumpSpeed;
			
			currentJumpSpeed -= .1;
			
			if(currentJumpSpeed <= 0) {
				
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
				
			}
			
			
		}
		
		if(falling) {
			
			y += currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed) {
				
				currentFallSpeed += .1;
				
			}
			
		}
		
		if(!falling) {
			
			currentFallSpeed = .1;
			
		}
		
	}
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
		
	}
	
	public void keyPressed(int i) {
		
		if(i == KeyEvent.VK_RIGHT) right = true;
		if(i == KeyEvent.VK_LEFT) left = true;
		if(i == KeyEvent.VK_Z) jumping = true;
		
	}
	
	public void keyReleased(int i){
		
		if(i == KeyEvent.VK_RIGHT) right = false;
		if(i == KeyEvent.VK_LEFT) left = false;
		if(i == KeyEvent.VK_Z) {
			
			jumping = false;
			falling = true;
			
		}
		
	}
	
}
