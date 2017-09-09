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
	
	public double x,y;
	public int width = 32,height = 64;
	
	// jump speed
	private final double jumpSpeed = 8;
	private double currentJumpSpeed = jumpSpeed;
	
	// move speed
	private final double moveSpeed = 4;
	
	// fall speed
	private final double maxFallSpeed = 10;
	private double currentFallSpeed = 0.2;
	
	public Player() {
		
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		
	}
	
	public void tick( Block[][] b) {
		
		int map[][];
		
		MapGenerator mg = new MapGenerator();
		map = mg.generatePath();
		
		for(int i = 7; i>=0; i--){
			
			for(int j = 7;j>=0;j--){
				
				
				
				System.out.print(map[i][j]);
				
			}
			
			System.out.printf("\n");
			
		}
		
		if(leftHeld) {
			
			left=true;
			
		}else {left=false;}
		
		if(rightHeld){
			
			right = true;
			
		}else{right = false;}
		
		int iX = (int)x;
		int iY = (int)y;
		
		//TODO: find exact which block player is in
		
		int iLeft = (int)((x+GameState.xOffset-1)/Block.blockSize);
		int iMiddleLeft = (int)(((x+width/8)+GameState.xOffset)/Block.blockSize);
		int iMiddle = (int)(((x+width/2)+GameState.xOffset)/Block.blockSize);
		int iMiddleRight = (int)(((x+width/1.1)+GameState.xOffset)/Block.blockSize);
		int iRight = (int)(((x+width)+GameState.xOffset+1)/Block.blockSize);
		
		int jTop = (int)((y+GameState.yOffset)/Block.blockSize);
		int jMiddleTop =(int)(((y+height/7.5)+GameState.yOffset)/Block.blockSize);
		int jMiddle = (int)(((y + height/2)+GameState.yOffset)/Block.blockSize);
		int jMiddleBottom = (int)(((y+height/1.1)+GameState.yOffset)/Block.blockSize);
		int jBottom = (int)(((y+height+2)+GameState.yOffset)/Block.blockSize);
		
		// bottom collision
		if(iMiddle >= 0 && jBottom >= 0 && jBottom < b.length && iMiddle<b[jBottom].length) {
		
			if(b[jBottom][iMiddle].getID() != 0){falling = false; bottomCollision = true;}}
		
		// bottom left collision
		if(iMiddleLeft >= 0 && jBottom >= 0 && jBottom < b.length && iMiddleLeft<b[jBottom].length) {
				
			if(b[jBottom][iMiddleLeft].getID() != 0){falling = false; bottomCollision = true;}}
				
		// bottom right collision
		if(iMiddleRight >= 0 && jBottom >= 0 && jBottom < b.length && iMiddleRight<b[jBottom].length) {
				
			if(b[jBottom][iMiddleRight].getID() != 0){falling = false; bottomCollision = true;}}
		
		// top collision
		if(iMiddle >= 0 && jTop >= 0 && jTop < b.length && iMiddle<b[jTop].length) {
		
			if(b[jTop][iMiddle].getID() != 0) {jumping = false; falling = true;}}
		
		// top left collision
		if(iMiddleLeft >= 0 && jTop >= 0 && jTop < b.length && iMiddleLeft<b[jTop].length) {
		
			if(b[jTop][iMiddleLeft].getID() != 0) {jumping = false; falling = true;}}
		
		// top right collision
		if(iMiddleRight >= 0 && jTop >= 0 && jTop < b.length && iMiddleRight<b[jTop].length) {
		
			if(b[jTop][iMiddleRight].getID() != 0) {jumping = false; falling = true;}}
		
		// left collision
		if(iLeft >= 0 && jMiddle >= 0 && jMiddle < b.length && iLeft<b[jMiddle].length) {
			
			if(b[jMiddle][iLeft].getID() != 0){left = false;}}
		
		// left bottom collision
		
		if(iLeft >= 0 && jMiddleBottom >= 0 && jMiddleBottom < b.length && iLeft<b[jMiddleBottom].length) {
			
			if(b[jMiddleBottom][iLeft].getID() != 0){left = false;}}
		
		// left top collision
		if(iLeft >= 0 && jMiddleTop >= 0 && jMiddleTop < b.length && iLeft<b[jMiddleTop].length) {
					
			if(b[jMiddleTop][iLeft].getID() != 0){left = false;}}
			
		// right collision
		if(iRight >= 0 &&  jMiddle >= 0 && jMiddle < b.length && iRight < b[jMiddle].length) {
			
			if(b[jMiddle][iRight].getID() != 0){right = false;}}	
		
		// right bottom collision
		if(iRight >= 0 &&  jMiddleBottom >= 0 && jMiddleBottom < b.length && iRight < b[jMiddleBottom].length) {
					
			if(b[jMiddleBottom][iRight].getID() != 0){right = false;}}
				
		// right top collision
		if(iRight >= 0 &&  jMiddleTop >= 0 && jMiddleTop < b.length && iRight < b[jMiddleTop].length) {
					
			if(b[jMiddleTop][iRight].getID() != 0){right = false;}}

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
