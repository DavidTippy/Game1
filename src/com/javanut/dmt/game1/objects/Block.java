package com.javanut.dmt.game1.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	
	public static final int blockSize = 32;
	
	public Block(int x, int y) {
		
		setBounds(x,y,blockSize,blockSize);
		
	}
	
	public void draw(Graphics g) {
		
		g.fillRect(x, y, width, height);
		
	}

}
