package com.javanut.dmt.game1.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.gamestates.GameState;
import com.javanut.dmt.game1.main.GamePanel;
import com.javanut.dmt.game1.mapping.MapGenerator;
import com.javanut.dmt.game1.physics.Collision;
import com.javanut.dmt.game1.solids.Block;

public class Player {
	
	private boolean right = false, left = false, jumping = false, falling = false, bottomCollision = false;
	private boolean rightHeld = false, leftHeld = false;
	
	public final double x,y;
	public int width = 32,height = 32;
	
	private double lastX = 0;
	private double lastY = 0;
	
	// jump speed
	private final double jumpSpeed = 8;
	private double currentJumpSpeed = jumpSpeed;
	
	// move speed
	private double moveSpeed = 9;
	
	// fall speed
	private final double maxFallSpeed = 20;
	private double currentFallSpeed = 0;
	
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
		int iLeftLeft = (int)((x+GameState.xOffset-moveSpeed)/Block.blockSize);
		
		int iRight = (int)(((x+width)+GameState.xOffset)/Block.blockSize);
		int iRightRight = (int)((x+width+moveSpeed+GameState.xOffset)/Block.blockSize);
		
		int jTop = (int)((y+GameState.yOffset)/Block.blockSize);
		
		int jBottom = (int)(((y+height)+GameState.yOffset)/Block.blockSize);
		int jBottomBottom = (int)((y+height+currentFallSpeed+GameState.yOffset)/Block.blockSize);
		
		// bottom left collision
		if (iLeft >= 0 && jBottomBottom >= 0 && jBottomBottom < b.length && iLeft < b[jBottomBottom].length) {

			if (b[jBottomBottom][iLeft].getID() != 0) {
				falling = false;
				bottomCollision = true;
				
			}
		
		}

		// bottom right collision
		if (iRight >= 0 && jBottomBottom >= 0 && jBottomBottom < b.length && iRight < b[jBottomBottom].length) {
			
			if (b[jBottomBottom][iRight].getID() != 0) {
				falling = false;
				bottomCollision = true;
				
			}
		}

		//top left collision
		if (iLeft >= 0 && jTop >= 0 && jTop < b.length && iLeft < b[jTop].length) {

			if (b[jTop][iLeft].getID() != 0) {
				jumping = false;
			}
		}

		//top right collision
		if (iRight >= 0 && jTop >= 0 && jTop < b.length && iRight < b[jTop].length) {

			if (b[jTop][iRight].getID() != 0) {
				jumping = false;
			}
		}
		
		//bottom right right collision
		if(iRightRight >= 0 && jBottom >= 0 && jBottom < b.length && iRightRight < b[jBottom].length) {
			
			if(b[jBottom][iRightRight].getID() != 0){
				
				//moveSpeed = 7;
				
				
				
				right = false;
				
			}
			
		}
		
		// top right right collision
		if(iRightRight >= 0 && jTop >= 0 && jTop < b.length && iRightRight < b[jTop].length) {
			
			if(b[jTop][iRightRight].getID() != 0){
				
				//moveSpeed = 7;
				right = false;
				
			}
			
		}
		
		//bottom left left collision
		if(iLeftLeft >= 0 && jBottom >= 0 && jBottom < b.length && iLeftLeft < b[jBottom].length) {
			
			if(b[jBottom][iLeftLeft].getID() != 0){
				
				//moveSpeed = 7;
				left = false;
				
			}
			
		}
		
		// top left left collision
		if(iLeftLeft >= 0 && jTop >= 0 && jTop < b.length && iLeftLeft < b[jTop].length) {
			
			if(b[jTop][iLeftLeft].getID() != 0){				
				
				//moveSpeed = 7;
				left = false;
				
			}
			
		}
		
		if (!bottomCollision && !jumping) {

			falling = true;

		}

		bottomCollision = false;

		if (right) {

			GameState.xOffset += moveSpeed;
			
			}

		

		if (left) {

			GameState.xOffset -= moveSpeed;

		}

		if (jumping) {

			GameState.yOffset -= currentJumpSpeed;

			currentJumpSpeed -= .2;

			if (currentJumpSpeed <= 0) {

				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;

			}

		}

		if (falling) {

			GameState.yOffset += currentFallSpeed;

			if (currentFallSpeed < maxFallSpeed) {

				currentFallSpeed += .5;

			}

		}

		if (!falling) {

			currentFallSpeed = 0;

		}	
		
		lastX = GameState.xOffset;
		lastY = GameState.yOffset;
		
	}
		
	
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
		
	}
	
	public void keyPressed(int i) {
		
		if(i == KeyEvent.VK_RIGHT) {rightHeld = true;}
		if(i == KeyEvent.VK_LEFT) {leftHeld = true;}
		if(i == KeyEvent.VK_Z && !jumping) {jumping = true;}
		
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