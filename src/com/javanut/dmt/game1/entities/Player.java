package com.javanut.dmt.game1.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.javanut.dmt.game1.main.GamePanel;

public class Player extends Rectangle{
	
	public Player(int width, int height) {
		
		setBounds(GamePanel.WIDTH / 2, GamePanel.HEIGHT / 2, width,height);
		
	}
	
	public void tick() {
		
	}
 
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		
	}
	
	public void keyPressed(int i) {
		
	}
	
	public void keyReleased(int i){
		
	}
	
}
