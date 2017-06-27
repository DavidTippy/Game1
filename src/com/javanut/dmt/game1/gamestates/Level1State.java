package com.javanut.dmt.game1.gamestates;

import java.awt.Graphics;

import com.javanut.dmt.game1.entities.Player;
import com.javanut.dmt.game1.mapping.Map;
import com.javanut.dmt.game1.solids.Block;

public class Level1State extends GameState{
	
	private Player player;
	private Map map;


	public Level1State(GameStateManager gsm) {
		
		super(gsm);
		
	}

	
	public void init() {
		
		player = new Player(16,32);		
		map = new Map("",4,4);
		
		xOffset = -200;
		yOffset = -400;
		
	}

	
	public void tick() {
				
		player.tick(map.getBlocks());
		
	}

	
	public void draw(Graphics g) {
		
		player.draw(g);
		map.draw(g);
		
	}

	
	public void keyPressed(int i) {
		
		player.keyPressed(i);
		
	}

	
	public void keyReleased(int i) {
		
		player.keyReleased(i);
		
	}
	
}
