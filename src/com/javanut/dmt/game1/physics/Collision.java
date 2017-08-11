package com.javanut.dmt.game1.physics;

import java.awt.Point;
import java.awt.Rectangle;

import com.javanut.dmt.game1.entities.Player;
import com.javanut.dmt.game1.solids.Block;

public class Collision {
	
	Rectangle playerRect;
	Rectangle blockRect;
	
	public Collision(Player p, Block b) {
	
		playerRect = new Rectangle((int)p.x,(int)p.y,p.width,p.height);
		blockRect = new Rectangle((int)b.x,(int)b.y,b.blockSize,b.blockSize);
	}					

	public boolean isBottomCollision() {
		return blockRect.contains(
				new Point(playerRect.x ,
						  playerRect.y+ playerRect.height))
				|| blockRect.contains(
				new Point(playerRect.x+ playerRect.width ,
						  playerRect.y + playerRect.height));
	}

	public boolean isTopCollision() {
		return blockRect.contains(
				new Point(playerRect.x,
						  playerRect.y))
				|| blockRect.contains(
				new Point(playerRect.x + playerRect.width,
						  playerRect.y ));
	}

	public boolean isLeftCollision() {
		return blockRect.contains(
				new Point(playerRect.x,
						  playerRect.y))
				|| blockRect.contains(
				new Point(playerRect.x,
						  playerRect.y + playerRect.height));
	}

	public boolean isRightCollision() {
		return blockRect.contains(
				new Point(playerRect.x + playerRect.width,
						  playerRect.y)) 
			    || blockRect.contains(
				new Point(playerRect.x + playerRect.width, 
						  playerRect.y  + playerRect.height));
	}

}
