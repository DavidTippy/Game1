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
		
		if(number1>number2){
			path[1][number2] = 7;
		} else if(number2>number1){
			path[1][number2] = 4;
		}
		
		if(number2>number3){
			path[2][number3] = 7;
		}else if(number3>number2){
			path[2][number3] = 4;
		}
		
		if(number3>number4){
			path[3][number4] = 7;
		}else if(number4>number3){
			path[3][number4] = 4;
		}
		
		if(number4>number5){
			path[4][number5] = 7;
		}else if(number5>number4){
			path[4][number5] = 4;
		}
		
		path[5][number5] = 6;
		
		if(number4>number5){
			path[4][number4] = 5;
		} else if(number5>number4){
			path[4][number4] = 6;
		}else if(number4 == number5){
			path[4][number4] = 3;
		}
		
		if(number4>number3){
			path[3][number3] = 6;
		} else if(number3>number4){
			path[3][number3] = 5;
		}else if(number4 == number3){
			path[3][number3] = 3;
		}
		
		if(number2>number3){
			path[2][number2] = 5;
		} else if(number3>number2){
			path[2][number2] = 6;
		}else if(number2 == number3){
			path[2][number2] = 3;
		}
		
		if(number1>number2){
			path[1][number1] = 5;
		} else if(number2>number1){
			path[1][number1] = 6;
		}else if(number1 == number2){
			path[1][number1] = 3;
		}
		
		path[0][0] = 1;
		path[5][5]=8;
		
		//row 1
		for(int i = 1; i<number1;i++) {
			
			path[0][i] = 2;
			
		}
		//row 2
		if(number1 > number2){
			for(int i = number2+1; i < number1; i++){
				path[1][i] = 2;
			}
		}else if(number2 > number1){
			for(int i = number2-1;i>number1;i--){
				path[1][i] = 2;
			}
		}else if(number1 == number2){
			path[1][number2] = 3;
		}
		//row 3
		if(number2 > number3){
			for(int i = number3+1; i < number2; i++){
				path[2][i] = 2;
			}
		}else if(number3 > number2){
			for(int i = number3-1;i>number2;i--){
				path[2][i] = 2;
			}
		}else if(number2 == number3){
			path[2][number3] = 3;
		}
		//row 4
		if(number3 > number4){
			for(int i = number4+1; i < number3; i++){
				path[3][i] = 2;
			}
		}else if(number4 > number3){
			for(int i = number4-1;i>number3;i--){
				path[3][i] = 2;
			}
		}else if(number3 == number4){
			path[3][number4] = 3;
		}
		//row 5
		if(number4 > number5){
			for(int i = number5+1; i < number4; i++){
				path[4][i] = 2;
			}
		}else if(number5 > number4){
			for(int i = number5-1;i>number4;i--){
				path[4][i] = 2;
			}
		}else if(number4 == number5){
			path[4][number5] = 3;
		}
		//row 6
		for(int i = number5+1;i<5;i++){
			path[5][i]=2;
		}
			
		return path;
		
		}	
	}