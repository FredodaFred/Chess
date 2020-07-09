package chess;
import java.util.Scanner; 

public class ChessApp {

	public static void main(String[] args) {
		
		Board theBoard = new Board();
		System.out.println("Welcome to chess.\nTo play, insert the coordinates of the piece you "+ 
							"to move, in (y, x), and the spot you want to move it to (also (y, x))\n" +
								"NOTE: castling is done by moving the King");
		
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		boolean gameNotWon = true; //Keeps engine running
		char turn = 'W'; //W stands for white team, B stands for black team
		char isKingAlive = 'F'; //F stands for both kings being alive
		theBoard.printBoard();
		
		while(gameNotWon) {
			
				if(turn == 'W') {
					turn = 'B';
					System.out.println("White team's turn");
					
					
					int oldY = userInput.nextInt();
					int oldX = userInput.nextInt();
					int newY = userInput.nextInt();
					int newX = userInput.nextInt();
				
					Tile[][] tempTiles = theBoard.getTiles();
					Piece checkPiece = tempTiles[oldY][oldX].getPiece();
					
					if(checkPiece.getTeam() != 'W') {
						System.out.println("Invalid piece, choose a valid piece");
						turn = 'W';
						
					}
					else if(!theBoard.movePiece(oldY, oldX, newY, newX)) {
						System.out.println("Invalid move, choose a valid move");
						turn = 'W';
					}
					
				}
				else {
					turn = 'W';
					System.out.println("Black team's turn");
					
					int oldY = userInput.nextInt();
					int oldX = userInput.nextInt();
					int newY = userInput.nextInt();
					int newX = userInput.nextInt();
							
					Tile[][] tempTiles = theBoard.getTiles();
					Piece checkPiece = tempTiles[oldY][oldX].getPiece();
					
					if(checkPiece.getTeam() != 'B') {
						System.out.println("Invalid piece, choose a valid piece");
						turn = 'B';
					}
					else if(!theBoard.movePiece(oldY, oldX, newY, newX)) {
						System.out.println("Invalid move, choose a valid move");
						turn = 'B';
					}
				}
				
				isKingAlive = theBoard.isKingDead();
				if(isKingAlive != 'F') {
					
					gameNotWon = false;
				}				
		
		
			theBoard.printBoard();
			
			if(isKingAlive == 'W') {
				System.out.println("Game over! Black team has won");
				break;
			}
			else if (isKingAlive == 'B'){
				System.out.println("Game over! White team has won");
				break;
			}				
		
		}
	}
} 