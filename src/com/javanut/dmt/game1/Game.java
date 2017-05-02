package com.javanut.dmt.game1;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

// class that starts the game
public class Game {
	
	public static void doIt() {
		
		JFrame window = new JFrame("Game");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true); 
		
	}

}
