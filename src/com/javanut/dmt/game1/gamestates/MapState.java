package com.javanut.dmt.game1.gamestates;

import java.awt.Font;
import java.awt.Graphics;

import com.javanut.dmt.game1.main.GamePanel;

public class MapState extends GameState{
	
	private final int[][] levels = {{0,0,6,0},
									{0,0,5,0},
									{0,3,4,0},
									{1,2,3,4},
									{4,3,4,0},
									{0,4,0,0}};
	
	private int[] currentSelection = {3,0};
	
	private String[][] levels2 = {{" "," ","12"," "},
								  {" "," ","11"," "},
								  {" ","9","10"," "},
								  {"1","2","7","8"},
								  {"4","3","6"," "},
								  {" ","5"," "," "}};

	public MapState(GameStateManager gsm) {				
		
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	
	public void draw(Graphics g) {
		
		for(int i = 0; i < 6; i++) {
			
			for(int j = 0; j < 4; j++) {
				
				g.setFont(new Font("Arial", Font.PLAIN, 24));
				g.drawString(levels2[i][j], j * 90 + 115, 30 + i * 75);
				
			}
			
		}
		
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
