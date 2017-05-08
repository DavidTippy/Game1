package com.javanut.dmt.game1.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.javanut.dmt.game1.gamestates.GameStateManager;

// class that starts the game
public class Game {
	
	public static void doIt() {
		
		GameStateManager gsm = new GameStateManager();
		
		JFrame window = new JFrame("Game");
		GamePanel myGamePanel = new GamePanel(gsm);
		window.setContentPane(myGamePanel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true); 		
		
		GameLoop myGameLoop = new GameLoop(myGamePanel);
		myGameLoop.start();				
		
	}

}
