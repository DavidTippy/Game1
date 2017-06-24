package com.javanut.dmt.game1.mapping;

import com.javanut.dmt.game1.solids.Block;

public class Map {
	
	private String path;
	private int width,height;
	
	private Block[][] blocks;
	
	public Map(String loadPath, int width, int height) {
		
		path = loadPath;
		
		this.width = width;
		this.height = height;
		
		blocks = new Block[height][width];
		
	}

}
