package com.javanut.dmt.game1.mapping;

import java.awt.Graphics;
import java.io.*;
import java.util.Random;

import com.javanut.dmt.game1.solids.Block;

public class Map {
	
	private String path;
	private int width,height;
	
	private Block[][] blocks;
	
	public Map(String loadPath) {
		
		path = loadPath;
		
		writeMap();
		
		loadMap();
		
	}
	
	public void draw(Graphics g) {
		
		for(int i = 0; i < blocks.length; i++) {
			
			for(int j = 0; j < blocks[0].length; j++) {
				
				blocks[i][j].draw(g);
				
			}
			
		}
		
	}
	
	public void writeMap() {
		
		try {
			
			FileWriter fw = new FileWriter(path, false);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("256\n256\n");
			
			for(int h = 1; h<=256;h++){
			pw.printf("0 ");
			}pw.printf("\n");
			
			
			for(int i = 1; i < 256; i++) {
				
				pw.printf("0 ");
				
				for(int j = 1; j<256;j++) {
				
				pw.printf("1 ");
				
				}
				
				pw.printf("\n");
				
			}
			
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void loadMap() {
		
		//InputStream is = this.getClass().getResourceAsStream(path);
		
		
		
		try {
			
			InputStream is = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());
			
			blocks = new Block[height][width];
			
			for(int y = 0; y < height; y++) {
				
				String line = br.readLine();
				
				String[] tokens = line.split("\\s+");
				
				for(int x = 0; x < width; x++) {
					
					blocks[y][x] = new Block(x*Block.blockSize,y*Block.blockSize,Integer.parseInt(tokens[x]));
					
				}
				
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Block[][] getBlocks() {
		
		return blocks;
		
	}

}
