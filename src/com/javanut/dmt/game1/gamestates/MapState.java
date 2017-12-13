package com.javanut.dmt.game1.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.javanut.dmt.game1.main.GamePanel;

public class MapState extends GameState{
	
	private final int[][] levels = {{-1,-1, 6,-1},
									{-1,-1, 5,-1},
									{-1, 3, 4,-1},
									{ 1, 2, 3, 4},
									{ 4, 3, 4,-1},
									{-1, 4,-1,-1}};
	
	private int curSelX = 0;
	private int curSelY = 3;
	
	private int[] currentSelection = {curSelY,curSelX};
	
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
				
				g.setColor(getColor(i,j));
				
				g.setFont(new Font("Arial", Font.PLAIN, getFontSize(i,j)));
				g.drawString(levels2[i][j], j * 90 + 115, 30 + i * 75);
				
			}
			
		}
		
	}

	
	public void keyPressed(int i) {
		
		if(i == KeyEvent.VK_DOWN) {
			
			
			if((int)(levels[curSelY+1][curSelX]) == (int)(levels[curSelY][curSelX]+1)
					|| (int)(levels[curSelY+1][curSelX]) == (int)(levels[curSelY][curSelX]-1)){
				
			curSelY++;	
			
				}
			
		} else if(i == KeyEvent.VK_UP) {
			
			
			if((int)(levels[curSelY-1][curSelX]) == (int)(levels[curSelY][curSelX]+1)
					|| (int)(levels[curSelY-1][curSelX]) == (int)(levels[curSelY][curSelX]-1)){				
			
			curSelY--;
			
			}
			
		}else if(i == KeyEvent.VK_RIGHT) {
			
			if((int)(levels[curSelY][curSelX+1]) == (int)(levels[curSelY][curSelX]+1)
					|| (int)(levels[curSelY][curSelX+1]) == (int)(levels[curSelY][curSelX]-1)){	
				
			curSelX++;	
			
			}
		
			
		} else if(i == KeyEvent.VK_LEFT) {
			
		
			if((int)(levels[curSelY][curSelX-1]) == (int)(levels[curSelY][curSelX]+1)
					|| (int)(levels[curSelY][curSelX-1]) == (int)(levels[curSelY][curSelX]-1)){	
				
			curSelX--;
			
		}
			
		} else if(i == KeyEvent.VK_ENTER) {
			
			switch(curSelY) {
			
			case 0:
				break;
			
			case 1:
				break;
				
			case 2:
				break;
				
			case 3:
				
				if(curSelX == 0) {
					
					gsm.states.push(new LevelState(gsm));
					
				}
				
				break;
				
			case 4:
				break;
				
			case 5:
				break;
			
			}
			
		}
		
		
		
	}

	@Override
	public void keyReleased(int i) {
		// TODO Auto-generated method stub
		
	}
	
	private Color getColor(int i,int j) {
		
		if(i == curSelY && j == curSelX) {
			
			return Color.RED;
			
		} else {
			
			return Color.BLACK;
			
		}
		
	}
	
	private int getFontSize(int i,int j) {
		
		if(i == curSelY && j == curSelX) {
			
			return 30;
			
		} else {
			
			return 24;
			
		}
		
	}

}
