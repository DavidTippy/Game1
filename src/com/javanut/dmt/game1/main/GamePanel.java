package com.javanut.dmt.game1.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

// class for the Game Panel
public class GamePanel extends JPanel {
	
	//dimensions
	public static final int WIDTH = 512;
	public static final int HEIGHT = 448;	
	
	public GamePanel() {
		
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();			
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawRect(100, 125, 150, 175);
		
	}

}
