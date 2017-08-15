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
	
	private boolean right = false, left = false, jumping = false, falling = false, bottomCollision = false;
	private boolean rightHeld = false, leftHeld = false;
	
	public double x,y;
	public int width = 32,height = 64;
	
	// jump speed
	private final double jumpSpeed = 8;
	private double currentJumpSpeed = jumpSpeed;
	
	// move speed
	private final double moveSpeed = 2;
	
	// fall speed
	private final double maxFallSpeed = 10;
	private double currentFallSpeed = 0.2;
	
	public Player() {
		
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
	}
	
	public void tick( Block[][] b) {
		
		if(leftHeld) {
			
			left=true;
			
		}else {left=false;}
		
		if(rightHeld){
			
			right = true;
			
		}else{right = false;}
		
		int iX = (int)x;
		int iY = (int)y;
		
		//TODO: find exact which block player is in
		
		int iLeft = (int)((x+GameState.xOffset)/Block.blockSize);
		int iMiddle = (int)(((x+width/2)+GameState.xOffset)/Block.blockSize);
		int iRight = (int)(((x+width)+GameState.xOffset)/Block.blockSize);
		
		int jTop = (int)((y+GameState.yOffset)/Block.blockSize);
		int jMiddle = (int)((((y + height/2)+GameState.yOffset)/Block.blockSize));
		int jBottom = (int)(((y+height)+GameState.yOffset)/Block.blockSize);
		
		// bottom collision
		if(iMiddle >= 0 && jBottom >= 0 && jBottom < b.length && iMiddle<b[jBottom].length) {
		
		if(b[jBottom][iMiddle].getID() != 0){falling = false; bottomCollision = true;
		System.out.println(iMiddle + " " + jBottom);}
		
		// top collision
		}if(iMiddle >= 0 && jTop >= 0 && jTop < b.length && iMiddle<b[jTop].length) {
		
		if(b[jTop][iMiddle].getID() != 0) {jumping = false; falling = true;}
		
		// left collision
		}if(iLeft >= 0 && jMiddle >= 0 && jMiddle < b.length && iLeft<b[jMiddle].length) {
			
			if(b[jMiddle][iLeft].getID() != 0){left = false;}
			
		// right collision	
		}
		if(iRight >= 0 &&  jMiddle >= 0 && jMiddle < b.length && iRight < b[jMiddle].length) {
			
			if(b[jMiddle][iRight].getID() != 0){right = false;}
			
		}

				if(!bottomCollision && !jumping) {
					
					falling = true;
					

				}					
		
		bottomCollision = false;
		
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
		
		if(i == KeyEvent.VK_RIGHT) {rightHeld = true;}
		if(i == KeyEvent.VK_LEFT) {leftHeld = true;}
		if(i == KeyEvent.VK_Z && !jumping && !falling) jumping = true;
		
	}
	
	public void keyReleased(int i){
		
		if(i == KeyEvent.VK_RIGHT) {rightHeld = false; }
		if(i == KeyEvent.VK_LEFT) {leftHeld = false; }
		if(i == KeyEvent.VK_Z) {
			
			currentJumpSpeed = jumpSpeed;
			jumping = false;
			falling = true;
			
		}
		
	} 
	
}
