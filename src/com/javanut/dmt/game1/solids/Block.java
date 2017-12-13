package com.javanut.dmt.game1.solids;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.javanut.dmt.game1.gamestates.GameState;

public class Block extends Rectangle{
	
	public static final int blockSize = 36;
	
	private int id;
	
	public Block(int x, int y, int id) {
		
		setBounds(x,y,blockSize,blockSize);
		this.id = id;
		
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		
		if(id != 0) {
		g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
		}
		
	}
	
	public void setID(int id) {
		
		this.id = id;
		
	}
	
	public int getID() {
		
		return id;
		
	}
	
	public int getLocationY(){
		
		return y;
		
	}
	
	public int getLocationX(){
		
		return x;
		
	}

}
