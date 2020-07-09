package chess;

public class Board {

	private Tile[][] tiles;
	
	public Board() { //default constructor
		
		tiles = new Tile[8][8];
		
		for(int i = 0; i < 8; i++) { //creates tile object
			
			for(int j = 0; j < 8; j++) {
				
				tiles[i][j] = new Tile(i, j);
			}
		}
		
		newBoard(); //initialize a new board and all piece objects
		
	}
	
	public Board(int a) { //intiallizes an empty board
		
		tiles = new Tile[8][8];
		
		for(int i = 0; i < 8; i++) { //creates tile object
			
			for(int j = 0; j < 8; j++) {
				
				tiles[i][j] = new Tile(i, j);
			}
		}
	}

	public void printBoard() {
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				if(tiles[i][j].getPiece() == null) { //Empty tile
					System.out.print("[-]");
				}
				else {
				System.out.print("[" + tiles[i][j].getPiece() + "]" );
				}
			}
			
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public boolean movePiece(int oldY, int oldX, int newY, int newX) {
			
		Piece pieceMoved = tiles[oldY][oldX].getPiece(); //retrieves piece object of chosen tile(based on x, y coordinates)
		
		//confirm if there is an actual piece in that tile
		if(pieceMoved == null) {
			return false;
		}
		
		//is this a valid move? (depends on piece), if so, piece gets moved and returned true.
		if(pieceMoved.isValidMove(newY, newX, tiles)) {
			
			tiles[newY][newX].setPiece(pieceMoved);
			tiles[oldY][oldX].setPiece(null);
			pieceMoved.setXPos(newX);
			pieceMoved.setYPos(newY);
			
			return true;
		}
		
		return false;
	}
	
	public void newBoard() { //creates a new clean board
		
		for(int j = 0; j < 8; j++) { //Pawns
			
			tiles[1][j].setPiece(new Pawn(1, j, 'B'));
			tiles[6][j].setPiece(new Pawn(6, j, 'W'));
			
		}
		
		//Castles
		tiles[0][0].setPiece(new Castle(0, 0, 'B'));
		tiles[0][7].setPiece(new Castle(0, 7, 'B'));
		tiles[7][0].setPiece(new Castle(7, 0, 'W'));
		tiles[7][7].setPiece(new Castle(7, 7, 'W'));
		
		//Bishops
		tiles[0][2].setPiece(new Bishop(0, 2, 'B'));
		tiles[0][5].setPiece(new Bishop(0, 5, 'B'));
		tiles[7][2].setPiece(new Bishop(7, 2, 'W'));
		tiles[7][5].setPiece(new Bishop(7, 5, 'W'));
		
		//Knights
		tiles[0][1].setPiece(new Knight(0, 1, 'B'));
		tiles[0][6].setPiece(new Knight(0, 6, 'B'));
		tiles[7][1].setPiece(new Knight(7, 1, 'W'));
		tiles[7][6].setPiece(new Knight(7, 6, 'W'));
		
		//Kings
		tiles[0][3].setPiece(new King(0, 3, 'B'));
		tiles[7][4].setPiece(new King(7, 4, 'W'));
		
		//Queens
		tiles[0][4].setPiece(new Queen(0, 4, 'B'));
		tiles[7][3].setPiece(new Queen(7, 3, 'W'));
		
		
	}
	
	public char isKingDead() {
		
		boolean whiteKingAlive = false;
		boolean blackKingAlive = false;
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				Piece tempPiece = tiles[j][i].getPiece();
				if(tempPiece != null) {		
					if(tempPiece.getSymbol() == 'K') {					
						whiteKingAlive = true;
					}
					else if(tempPiece.getSymbol() == 'k') {
						blackKingAlive = true;
					}
				}
			}
			
		}
		
		if(whiteKingAlive && blackKingAlive) {
			return 'F';
		}
		else if(whiteKingAlive) {
			return 'B';
		}
		
		return 'W';
	}
	
	public void setPieceBoard(Piece currentPiece) {
		tiles[currentPiece.getYPos()][currentPiece.getXPos()].setPiece(currentPiece);;
	}
	public Tile[][] getTiles(){
		return tiles;
	}
	
}
