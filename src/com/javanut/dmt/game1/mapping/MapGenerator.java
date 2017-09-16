package com.javanut.dmt.game1.mapping;

import java.util.Random;

public class MapGenerator {
	
	Random myRandom = new Random();
	
	public int[][] generatePath() {
		
		int[][] path = new int[6][6];
		
		int number1 = myRandom.nextInt(5)+1;
		int number2 = myRandom.nextInt(6);
		int number3 = myRandom.nextInt(6);
		int number4 = myRandom.nextInt(6);
		int number5 = myRandom.nextInt(5);
		
		path[0][number1] = 4;
		path[1][number2] = 1;
		path[2][number3] = 1;
		path[3][number4] = 1;
		path[4][number5] = 1;
		
		for(int i = 4; i >= 0; i--){
			
			for(int j = 5; j>=0; j--){
				
				if(path[i][j] >0){
					path[i+1][j] = 1;
				}
				
			}
			
		}
		
		path[0][0] = 1;
		path[5][5]=8;
		
		//row 1
		for(int i = 0; i<number1;i++) {
			
			path[0][i] = 1;
			
		}
		//row 2
		if(number1 > number2){
			for(int i = number2; i < number1; i++){
				path[1][i] = 1;
			}
		}else if(number2 > number1){
			for(int i = number2;i>number1;i--){
				path[1][i] = 1;
			}
		}
		//row 3
		if(number2 > number3){
			for(int i = number3; i < number2; i++){
				path[2][i] = 1;
			}
		}else if(number3 > number2){
			for(int i = number3;i>number2;i--){
				path[2][i] = 1;
			}
		}
		//row 4
		if(number3 > number4){
			for(int i = number4; i < number3; i++){
				path[3][i] = 1;
			}
		}else if(number4 > number3){
			for(int i = number4;i>number3;i--){
				path[3][i] = 1;
			}
		}
		//row 5
		if(number4 > number5){
			for(int i = number5; i < number4; i++){
				path[4][i] = 1;
			}
		}else if(number5 > number4){
			for(int i = number5;i>number4;i--){
				path[4][i] = 1;
			}
		}
		//row 6
		for(int i = number5;i<5;i++){
			path[5][i]=1;
		}
			
		return path;
		
		}	
	}