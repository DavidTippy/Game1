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
	
	private boolean right = false, left = false, jumping = false, falling = false, topCollision = false;
	
	private double x,y;
	private int width,height;
	
	// jump speed
	private final double jumpSpeed = 8;
	private double currentJumpSpeed = jumpSpeed;
	
	// move speed
	private final double moveSpeed = 2.5;
	
	// fall speed
	private final double maxFallSpeed = 10;
	private double currentFallSpeed = 0.2;
	
	public Player(int width, int height) {
		
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
		this.width = width;
		this.height = height;
		
	}
	
	public void tick( Block[][] b) {
		
		int iX = (int)x;
		int iY = (int)y;
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
			
			if(b[i][j].getID() != 0) {
				
			//right collision
			if (Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset,iY + (int)GameState.yOffset+2), b[i][j]) 
			|| Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset, iY+height+(int)GameState.yOffset-1),b[i][j])) {
			right = false;
			
			}
			
			//left collision
			if (Collision.playerBlock(new Point(iX+(int)GameState.xOffset-1,iY + (int)GameState.yOffset+2), b[i][j]) 
					|| Collision.playerBlock(new Point(iX+(int)GameState.xOffset-1, iY+height+(int)GameState.yOffset-1),b[i][j])) {
			left = false;
			
			}
			
			//top collision
			
			if (Collision.playerBlock(new Point(iX+(int)GameState.xOffset+1,iY + (int)GameState.yOffset), b[i][j]) 
					|| Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset-2, iY+(int)GameState.yOffset),b[i][j])) {
			jumping = false;
			falling = true;
			
			}
			
			//bottom collision

			if (Collision.playerBlock(new Point(iX+(int)GameState.xOffset+2,iY + height + (int)GameState.yOffset+1), b[i][j]) 
					|| Collision.playerBlock(new Point(iX+width+(int)GameState.xOffset-2, iY+height+(int)GameState.yOffset+1),b[i][j])) {
				
			y = b[i][j].getY() - height - GameState.yOffset;
				
			falling = false;
			
			topCollision = true;
			
			} else {
				
				if(!topCollision && !jumping) {
					
					falling = true;
					
				}					
				
			}
			
			}
			
			}
		}
		
		topCollision = false;
		
		if (right) {
			
			GameState.xOffset += moveSpeed;
			
		}
		
		if (left) {
			
			GameState.xOffset -= moveSpeed;
			
		}
		
		if(jumping) {
			
			GameState.yOffset -= currentJumpSpeed;
			
			currentJumpSpeed -= .2;
			
			if(currentJumpSpeed <= 0) {
				
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
				
			}
			
			
		}
		
		if(falling) {
			
			GameState.yOffset += currentFallSpeed;
			
			if(currentFallSpeed < maxFallSpeed) {
				
				currentFallSpeed += .2;
				
			}
			
		}
		
		if(!falling) {
			
			currentFallSpeed = .2;
			
		}
		
	}
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
		
	}
	
	public void keyPressed(int i) {
		
		if(i == KeyEvent.VK_RIGHT) right = true;
		if(i == KeyEvent.VK_LEFT) left = true;
		if(i == KeyEvent.VK_Z && !jumping && !falling) jumping = true;
		
	}
	
	public void keyReleased(int i){
		
		if(i == KeyEvent.VK_RIGHT) right = false;
		if(i == KeyEvent.VK_LEFT) left = false;
		if(i == KeyEvent.VK_Z) {
			
			currentJumpSpeed = jumpSpeed;
			jumping = false;
			falling = true;
			
		}
		
	}
	
}
