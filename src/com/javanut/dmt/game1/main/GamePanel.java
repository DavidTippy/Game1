package com.javanut.dmt.game1.main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.javanut.dmt.game1.gamestates.GameStateManager;

// class for the Game Panel
public class GamePanel extends JPanel implements KeyListener{
	
	//dimensions
	public static final int WIDTH = 768;
	public static final int HEIGHT = 512;
	
	GameStateManager gsm = new GameStateManager();
	
	public GamePanel(GameStateManager gsm) {
		
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		addKeyListener(this);
		
		setFocusable(true);
		requestFocus();	
		this.gsm = gsm;
		
	}
	
	public void tick() {
		
		System.out.println("Running");
		gsm.tick();
	}

	
	public void keyPressed(KeyEvent e) {		
		
		gsm.keyPressed(e.getKeyCode());
		
	}
	
	public void keyReleased(KeyEvent e) {		
		
		gsm.keyReleased(e.getKeyCode());
		
	}
	
	public void keyTyped(KeyEvent e) {}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		gsm.draw(g);
		
	}

}
