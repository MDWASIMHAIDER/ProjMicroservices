package com.nt.ladder;

import java.util.Random;

public class SnakeAndLadder {
	
	public void playGame(int players,int snakes,int ladders) {
		Object[] board=new Object [100];
		int[] snk=new int[snakes];
		int[] lad=new int[ladders];
		Random rad=new Random();
		int snakesCount=0;
		int laddersCount=0;
		for(int i=0;i<board.length;i++) {
			int nextInt = rad.nextInt(99);
			if(i==0) {
				board[i]="start";
			}
			else if(snakes!=snakesCount){
				//int nextInt = rad.nextInt(99);
				//System.out.println(nextInt+"===========sn");
				//board[nextInt]="snake";
				snk[snakesCount]=nextInt;
				snakesCount++;
			}
			else if(ladders!=laddersCount) {
				//int nextInt = rad.nextInt(99);
				//System.out.println(nextInt+"==========ld");
				lad[laddersCount]=nextInt;
				//board[nextInt]="ladders";
				laddersCount++;
			}
			else {
				board[i]=i;
			}
			
		}
		for(int i=0;i<snk.length;i++) {
			//if(board[i]==(Object)snk[i]) {
				board[snk[i]]="snake";
			//}
			//else if(board[i]==(Object)lad[i]) {
				board[lad[i]]="ladder";
			//}
			//System.out.println(board[i]);
		}
		for(int i=0;i<board.length;i++) {
			System.out.println(board[i]);
		}
	}
	public static void main(String[] args) {
		SnakeAndLadder sk=new SnakeAndLadder();
		sk.playGame(1, 7, 8);
	}
}
