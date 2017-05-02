package com.javanut.dmt.game1;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

// class for the Game Panel
public class GamePanel extends JPanel {
	
	//dimensions
	public static final int WIDTH = 512;
	public static final int HEIGHT = 448;
	
	GameLoop myGameLoop = new GameLoop();
	
	public GamePanel() {
		
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		
		myGameLoop.start();
	}
	

}
