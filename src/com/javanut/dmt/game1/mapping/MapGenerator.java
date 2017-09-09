package com.javanut.dmt.game1.mapping;

import java.util.Random;

public class MapGenerator {
	
	Random myRandom = new Random();
	
	public int[][] generatePath() {
		
		int[][] path = new int[8][8];
		int currentX;
		int currentY;
		int XSegmentLength;
		int YSegmentLength;
		int XTotalLength = 0;
		int YTotalLength = 0;
		
		// create start point
		currentX = 0;
		currentY = 0;
		path[currentX][currentY] = 1;
		
		int counter = 0;
		
		while(XTotalLength<7 && YTotalLength<7) {
			
			counter++;
			
			System.out.println(counter);
			
			XSegmentLength = myRandom.nextInt(8 - XTotalLength);
			
			for(int i = 0+XTotalLength; i<XTotalLength + XSegmentLength; i++){
				
				path[i][currentY] = 1;
				
			}
			
			XTotalLength = XTotalLength + XSegmentLength;
			currentX = currentX+XSegmentLength;
			
			YSegmentLength = myRandom.nextInt(8 - YTotalLength);
			
			for(int i = 0+YTotalLength; i<YTotalLength + YSegmentLength; i++){
				
				path[currentX][i] = 1;
				
				
				
			}
			
			YTotalLength = YTotalLength + YSegmentLength;
			currentY = currentY+YSegmentLength;
			
		} 
		
		if(currentX == 7) {
			
			for(int i = currentY; i<=7; i++) {
				
				path[currentX][i] = 1;
				
			}
			
		}
		
		if(currentY == 7) {
			
			for(int i = currentX; i<=7; i++) {
				
				path[i][currentY] = 1;
				
			}
			
		}
		
		return path;
		
	}
}