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
			
			Random myRandom = new Random();
			RoomGenerator rg = new RoomGenerator();
			FileWriter fw = new FileWriter(path, false);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("36\n12\n");				
			
			int[][] Room1 = rg.generateRoom(2, 2);
			int[][] Room2 = rg.generateRoom(8, 2);
			int[][] Room3 = rg.generateRoom(9, 2);
			
			for(int i = 1;i<=12;i++) {
				
				for(int j = 1; j<=12;j++){
					
					pw.print(Room1[i][j]+" ");
					pw.print(Room2[i][j]+" ");
					pw.print(Room3[i][j]+" ");
					
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
