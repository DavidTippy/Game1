package com.javanut.dmt.game1.gamestates;

import java.awt.Graphics;
import java.io.File;

import com.javanut.dmt.game1.entities.Player;
import com.javanut.dmt.game1.mapping.Map;
import com.javanut.dmt.game1.solids.Block;

public class LevelState extends GameState{
	
	private Player player;
	private Map map;


	public LevelState(GameStateManager gsm) {
		
		super(gsm);
		
	}

	
	public void init() {
		
		player = new Player();		
		map = new Map("."+File.separator+"map1.map");
		
		xOffset = -100;
		yOffset = -200;
		
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
