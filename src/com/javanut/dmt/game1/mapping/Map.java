package com.javanut.dmt.game1.mapping;

import java.awt.Graphics;
import java.io.*;
import java.util.Arrays;
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
			
			for(int j = 0; j < blocks[i].length; j++) {				
				
				blocks[i][j].draw(g);
				
			}
			
		}
		
	}
	
	public void writeMap() {
		
		try {
			
			int map[][] = new int[6][6];
			Random myRandom = new Random();
			RoomGenerator rg = new RoomGenerator();
			MapGenerator mg = new MapGenerator();
			FileWriter fw = new FileWriter(path, false);
				
			int[][] mapArray = new int[96][96];
			
			StringBuilder[] sb = new StringBuilder[96];
			int f = sb.length;
			while (--f >= 0){
				sb[f]= new StringBuilder();
			}
			
			map = mg.generatePath();
			
			for(int h = 0; h<=5; h++){
				
			int[][] theRoom1 = rg.generateRoom(map[0][h]);
			int[][] theRoom2 = rg.generateRoom(map[1][h]);
			int[][] theRoom3 = rg.generateRoom(map[2][h]);
			int[][] theRoom4 = rg.generateRoom(map[3][h]);
			int[][] theRoom5= rg.generateRoom(map[4][h]);
			int[][] theRoom6 = rg.generateRoom(map[5][h]);
						
				for(int i = 0; i<=15; i++){
					System.err.println("room 1 "+Arrays.toString(theRoom1[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i][j+(h*16)] = theRoom1[i][j];
							
					}
					
				}
				
				for(int i = 0; i<=15; i++){
					System.err.println("room 2 "+Arrays.toString(theRoom2[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i+16][j+(h*16)] = theRoom2[i][j];
							
					}
					
				}
				
				for(int i = 0; i<=15; i++){
					System.err.println("room 3 "+Arrays.toString(theRoom3[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i+32][j+(h*16)] = theRoom3[i][j];
							
					}
					
				}
				
				for(int i = 0; i<=15; i++){
					System.err.println("room 4 "+Arrays.toString(theRoom4[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i+48][j+(h*16)] = theRoom4[i][j];
							
					}
					
				}
				
				for(int i = 0; i<=15; i++){
					System.err.println("room 5 "+Arrays.toString(theRoom5[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i+64][j+(h*16)] = theRoom5[i][j];
							
					}
					
				}
				
				for(int i = 0; i<=15; i++){
					System.err.println("room 6 "+Arrays.toString(theRoom6[i]));
					for(int j = 0; j<= 15; j++){
															
					mapArray[i+80][j+(h*16)] = theRoom6[i][j];
							
					}
					
				}
			
		}
			
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("96\n96\n");
			
			for(int k = 0; k<96; k++){
				
				for(int m = 0; m<96; m++){
				
				pw.print(mapArray[k][m]+" ");
				System.out.print(mapArray[k][m]+" ");
				
				}
				
				pw.println();
				System.out.println();
				
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
