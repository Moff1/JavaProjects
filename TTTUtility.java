/**
 * 
 */
package cs1302.hw09;

/**
 * @author Moffatt
 *
 */
public class TTTUtility {

	private TTTUtility() {
		
	}
	
	public static boolean validGame(String board) {
		int xCount = count(board, 'X');
		int oCount = count (board, 'O');
		int blankCount = count(board, '-');
		
		boolean full = xCount + oCount + blankCount == 9;
		return full && (xCount == oCount || xCount - 1 == oCount);
	}
	
	public static void printSquare(String board) {
		System.out.println(board.substring(0,3));
		System.out.println(board.substring(3,6));
		System.out.println(board.substring(6,9));
	}

	public static int count(String board, char ch) {
		int count  =  0;
		for (int i = 0; i < board.length(); i++) {
			if (board.charAt(i) == ch) {
				count ++;
			}
		}
		return count;
	}
	
	public static char whoseTurn(String board) {
		int xCount = count(board, 'X');
		int oCount =  count(board, 'O');
		
		if (!validGame(board)) {
			return '-';
		}
		if (xCount == oCount) {
			return 'X';
		}
		return 'O';
	}
	public static boolean isCat(String board) {
		if(count(board, 'X') == count(board, 'O')) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isWinner(String board, char ch) {
		for (int i = 0; i < board.length(); i += 3) {
			if (board.charAt(i) == ch && board.charAt(i+1) == ch && board.charAt(i+2) == ch) {
				return true;
			}
		}
		for (int i = 0; i < 3; i += 3) {
			if (board.charAt(i) == ch && board.charAt(i+3) == ch && board.charAt(i+6) == ch) {
				return true;
			}
		}
	
			if (board.charAt(0) == ch && board.charAt(4) == ch && board.charAt(8) == ch) {
				return true;
			}
			return board.charAt(2) == ch && board.charAt(4) == ch && board.charAt(6) == ch;
			
		}
	}


