package com.javanut.dmt.game1.solids;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.javanut.dmt.game1.gamestates.GameState;

public class Block extends Rectangle{
	
	public static final int blockSize = 32;
	
	public Block(int x, int y) {
		
		setBounds(x,y,blockSize,blockSize);
		
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g) {
		
		g.fillRect(x-(int)GameState.xOffset, y-(int)GameState.yOffset, width, height);
		
	}

}
