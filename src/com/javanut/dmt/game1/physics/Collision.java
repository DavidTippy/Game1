package com.javanut.dmt.game1.physics;

import java.awt.Point;

import com.javanut.dmt.game1.solids.Block;

public class Collision {
	
	public static boolean playerBlock(Point p, Block b) {
		
		return b.contains(p);
		
	}

}
