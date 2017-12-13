package com.javanut.dmt.game1.gamestates;

import java.awt.Color;
import java.awt.Graphics;

import com.javanut.dmt.game1.main.GamePanel;

public class SplashState extends GameState{
	
	public SplashState(GameStateManager gsm) {
		super(gsm);
	}

	int counter = 0;
	
	public void init() {
	
	

	}


	
	public void tick() {
		
		counter++;
		
		if(counter > 60) {
		
		// push level1State to gameStateManager
		gsm.states.push(new LevelState(gsm));
		
		}
		
	}



	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
		
		g.setColor(Color.BLACK);
		g.drawString("Level 1", 350, 250);
		
	}


	@Override
	public void keyPressed(int i) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
