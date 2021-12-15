/**
 * 
 */
package cs1302.hw09;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.*;
public class TTTSolver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Something about valid characters.");
		
		String board = promptBoard(input);
		
		//printAllBoards(board);
		//)ArrayList<String> list = new ArrayList<>();
		//Creator(list,board);
		System.out.println(countAllWinningBoards(board,'X'));
		
		System.out.println(TTTUtility.isCat(board));
	}
	
	public static String promptBoard(Scanner input) {
		String board = input.nextLine();
		while (!TTTUtility.validGame(board)) {
			System.out.println("Invalid");
			board = input.nextLine();
		}
		return board;
	}
	
	public static void printAllBoards(String board) {
		
		if (TTTUtility.isWinner(board, 'X') == true || TTTUtility.isWinner(board, 'O') == true ||
				TTTUtility.validGame(board) == false){
					System.out.println(board);
				} else {
					int sum = TTTUtility.count(board, 'X') + TTTUtility.count(board, 'O');
					String newBoard2 = "";
					for (int i = 0; i < 9 - sum; i++) {
						Character next  = TTTUtility.whoseTurn(board);
						String nextTurn = next.toString();
						int index = board.indexOf('-');
						for ( int j = 0; j < i; j++) {
							index = board.indexOf('-', index +1);
						}
						if (index == 8) {
							newBoard2 = board.substring(0,8) + nextTurn;
						} else {
							String newBoard1 = board.substring(0, index) + nextTurn;
							newBoard2 = newBoard1+ board.substring(index +1);
						}
						
						System.out.println(newBoard2);
						printAllBoards(newBoard2);

}

}
} //printAllBoards
	
	public static void Creator(ArrayList<String> strings, String board) {
		
		if (TTTUtility.isWinner(board, 'X') == true || TTTUtility.isWinner(board, 'O') == true ||
				TTTUtility.validGame(board) == false){
					System.out.println(board);
				} else {
					int sum = TTTUtility.count(board, 'X') + TTTUtility.count(board, 'O');
					String newBoard2 = "";
					for (int i = 0; i < 9 - sum; i++) {
						Character next  = TTTUtility.whoseTurn(board);
						String nextTurn = next.toString();
						int index = board.indexOf('-');
						for ( int j = 0; j < i; j++) {
							index = board.indexOf('-', index +1);
						}
						if (index == 8) {
							newBoard2 = board.substring(0,8) + nextTurn;
						} else {
							String newBoard1 = board.substring(0, index) + nextTurn;
							newBoard2 = newBoard1+ board.substring(index +1);
						}
						strings.add(newBoard2);
						Creator(strings, newBoard2);
		
	} // for 
				} // else
		//System.out.println(strings);
	} // Creator
	

		


	public static int countAllWinningBoards(String board, char player) {
		
		int total = 0;
		
		ArrayList<String> winningList = new ArrayList<>();
		Creator(winningList, board);
		
		for (int i = 0; i < winningList.size(); i++) {
			String temp = winningList.get(i);
		if (TTTUtility.isWinner(temp, player)) {
			total = total + 1;
			
		}
		}
	return total;	
	}

}

	
