package com.chapter13;

public class Q14 {

	public static void main(String[] args) {
		
	}
	
	/*
	 * Rolling Hash function for chess board.
	 * 
	 * chess board has 64 blocks. can represent it using 6 bits .
	 * 
	 * each chess block can have 13 types . 
	 * Can be blank
	 * Can have pawn, horse, elephant, king , queen, camel - 6
	 * Can be black or white. 
	 * So 1 + 2 *(6) = 13 ways => 4 bits can represent this state
	 * 
	 * 
	 * 10 or 11 bits can represent any block on chess board. (one bit telling current is black or white)
	 * XOR of all the blocks can represent a chessboard.
	 * 
	 * Given a hash, and change.
	 * 
	 * Suppose change is elephant from A0 to A5. with A5 being blank before
	 * 
	 * h1 ^ A5 blank ^ A0 elephant ^ A5 elephant ^ A0 blank will give new hash function
	 * 
	 * 
	 * 
	 * We have 11 bits
	 * 
	 * Let MSB represent if the square is white or black. 1 for white and 0 for black.
	 * 4 bits represent the state. Which coin the square has or if square is empty.
	 * 6 bits to represent the position of the square. (its row and column). first 3 bits for the row and next 3 bits for column
	 * 
	 * 
	 *       0000 => square is empty
	 *       
	 *  
	 *  64 squares. 13 states.
	 *  64 * 13 codes for representing.
	 *  = 832.State of chessboard is XOR of the 64 squares
	 *  
	 * 
	 * 
	 * 
	 */
	
	
	
	
	

}
