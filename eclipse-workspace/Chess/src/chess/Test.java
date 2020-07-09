package chess;

public class Test {

	public static void main(String[] args) {
		Board theBoard = new Board(0);
		
		//theBoard.setPieceBoard(new King(7, 4, 'W'));
		//theBoard.setPieceBoard(new Castle(7, 0, 'W'));
		//theBoard.setPieceBoard(new Castle(7, 7, 'W'));
		//theBoard.movePiece(7, 4, 7, 6);
		//theBoard.movePiece(7, 4, 7, 1);
		
		theBoard.setPieceBoard(new King(0, 3, 'B'));
		theBoard.setPieceBoard(new Castle(0, 0, 'B'));
		theBoard.setPieceBoard(new Castle(0, 7, 'B'));
		///theBoard.movePiece(0, 3, 0, 1);
		theBoard.movePiece(0, 3, 0, 6);
		theBoard.printBoard();
		
		
		
	}
}
