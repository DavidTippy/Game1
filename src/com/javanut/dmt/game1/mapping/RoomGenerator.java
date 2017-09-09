package com.javanut.dmt.game1.mapping;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.javanut.dmt.game1.solids.Block;

public class RoomGenerator {
	
	Random myRandom = new Random();
	
	
	public int[][] generateRoom(int heightLimit, int roomType) {
		
		int room[][] = new int[15][15];
		
		switch(roomType){
		
		case 1:
			
			room = loadRoom(1);
			
		case 2:
			
		case 3:
			
		case 4:
			
		case 5:
			
		case 6:
		
		}
		
		return room;
		
	}
	
	public int[][] loadRoom(int roomType) {
		
		int counter = 0;
		
		InputStream stream;
		
		int room[][] = new int[15][15];
		
		do {
			
			counter++;
		
		StringBuilder name = new StringBuilder();
		name.append("Room").append(roomType).append(counter).append(".room");
		
		stream = getClass().getResourceAsStream(name.toString());
		
		
		
		} while (stream != null);
		
		Random myRandom = new Random();
		int roomNumber = myRandom.nextInt(counter)+1;
		
		StringBuilder theRoom = new StringBuilder();
		theRoom.append("Room").append(roomType).append(roomNumber).append(".room");
		
		try{
		
		stream = getClass().getResourceAsStream(theRoom.toString());
		
		if(stream != null) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			
			for(int i = 0;i<16;i++){
				
				String line = br.readLine();
				
				String[] tokens = line.split("\\s+");
				
				for(int j = 0;j<16;j++) {
			
					if (Integer.parseInt(tokens[j]) != 2){
						
						room[i][j] = Integer.parseInt(tokens[j]);
						
					} else if (Integer.parseInt(tokens[j]) == 2) {
						
						room [i][j] = myRandom.nextInt(2);
						
					}
			 
				}
			 
			}
			
		} 
		
		}
			
		  catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}		
			return room;		
}
	
}
