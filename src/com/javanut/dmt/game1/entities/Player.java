package com.javanut.dmt.game1.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.gamestates.GameState;
import com.javanut.dmt.game1.main.GamePanel;
import com.javanut.dmt.game1.physics.Collision;
import com.javanut.dmt.game1.solids.Block;

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
	
	public void tick( Block[] b) {
		
		int iX = (int)x;
		int iY = (int)y;
		
		for (int i = 0; i < b.length; i++) {
			
			//right
			if (Collision.playerBlock(new Point(iX+width,iY), b[i]) || Collision.playerBlock(new Point(iX+width, iY+height),b[i]));
			
		}
		
		if (right) {
			
			GameState.xOffset += 1;
			
		}
		
		if (left) {
			
			GameState.xOffset -= 1;
			
		}
		
		if(jumping) {
			
			GameState.yOffset -= currentJumpSpeed;
			
			currentJumpSpeed -= .1;
			
			if(currentJumpSpeed <= 0) {
				
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
				
			}
			
			
		}
		
		if(falling) {
			
			GameState.yOffset += currentFallSpeed;
			
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
