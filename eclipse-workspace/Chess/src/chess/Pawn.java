package chess;

public class Pawn extends Piece{

	private boolean firstMove;
	private boolean enPassant;

	
	public Pawn(int y, int x, char team) {
		
		super(y, x, team);
		if(team == 'W') {
			setSymbol('P');
		}
		else {
			setSymbol('p');
		}
		firstMove = true;
		enPassant = false;
	}
	
	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {
		
		enPassant = false;
		
		switch(getTeam()) {
		
			case 'W': //Valid moves for white team (pawn only goes one direction, resulting in the split)
				//normal movement
				if(newX == getXPos()&&(newY == (getYPos()-1))){ //x position stays the same, and y position changes by 1
					
					//piece interaction
					if(tiles[newY][newX].getPiece() != null) {
						return false;
						
					}
					return true;
				}
				
				//attack interaction
				else if((newY == getYPos() - 1) && ((newX == getXPos() +1)||(newX == getXPos() -1))){ //x + 1/-1, y -1
					Piece otherPiece = tiles[newY][newX].getPiece();
									
					//en passant
					if(otherPiece == null) {
						Piece tempPawn1; //pawn being attacked
						//two branches(like mirror images)
						try {
							if(tiles[getYPos()][getXPos() + 1].getPiece() != null) { //right side branch
								tempPawn1 = tiles[getYPos()][getXPos() + 1].getPiece();
								
								if(tempPawn1.getSymbol() != 'p'||!tempPawn1.getEnPassant())  { //checks if it is a black pawn and it can be attack w/ en passant
									return false;
								}
								
								Piece tempPawn2 = tiles[getYPos() -2][getXPos()].getPiece(); //enemy pawn 2 ahead
								if(tempPawn2.getSymbol() != 'p') {
									return false;
								}
								Piece tempPawn3 = tiles[getYPos() + 1][getXPos() + 1].getPiece(); //ally pawn behind and to right
								if(tempPawn3.getSymbol() != 'P') {
									return false;
								}
								tiles[getYPos()][getXPos() + 1].setPiece(null);
								
							}
							else if(tiles[getYPos()][getXPos() - 1].getPiece() != null) {//left branch
								tempPawn1 = tiles[getYPos()][getXPos() - 1].getPiece();
								
								if(tempPawn1.getSymbol() != 'p'||!tempPawn1.getEnPassant())  { //checks if it is a black pawn and it can be attack w/ en passant
									return false;
								}
								
								Piece tempPawn2 = tiles[getYPos() -2][getXPos()].getPiece(); //enemy pawn 2 ahead
								if(tempPawn2.getSymbol() != 'p') {
									return false;
								}
								Piece tempPawn3 = tiles[getYPos() + 1][getXPos() - 1].getPiece(); //ally pawn behind and to right
								if(tempPawn3.getSymbol() != 'P') {
									return false;
								}
								tiles[getYPos()][getXPos() - 1].setPiece(null);
							}	
						}
						catch(Exception NullPointerException) { //return false if a pawn is null/Does not exist
							return false;
						}
					}
					
					//regular attack
					else if(otherPiece.getTeam() == getTeam()) {
						return false; //can't attack your own team
					}
					
					return true;
				}
				
				else if(firstMove) {	//if it is the first move, a pawn can move two spaces forward instead of one.			
					if(newX == getXPos()&&(newY == (getYPos()-2))){
						
						if( (tiles[newY][newX].getPiece() != null) && (tiles[newY+1][newX].getPiece() != null)) {
							return false; //can't skip over pieces
							
						}
						firstMove = false;
						enPassant = true;
						return true;
					}
				
				}
				break;
									
			case 'B': //valid moves for black team (pawn only goes one direction, resulting in the split)
				if(newX == getXPos()&&(newY == (getYPos()+1))){
					
					//piece interaction
					if(tiles[newY][newX].getPiece() != null) {
						return false;
						
					}
					return true;
				}
				
				//attack interaction
				else if((newY == getYPos() + 1) && ((newX == getXPos() +1)||(newX == getXPos() -1))){ // x + 1/-1, y +1
					Piece otherPiece = tiles[newY][newX].getPiece();
					
					//en passant
					if(otherPiece == null) {
						Piece tempPawn1; //pawn being attacked
						//two branches(like mirror images)
						try {
							if(tiles[getYPos()][getXPos() + 1].getPiece() != null) { //right side branch
								tempPawn1 = tiles[getYPos()][getXPos() + 1].getPiece();
								
								if(tempPawn1.getSymbol() != 'P'||!tempPawn1.getEnPassant())  { //checks if it is a white pawn and it can be attack w/ en passant
									return false;
								}
								
								Piece tempPawn2 = tiles[getYPos() +2][getXPos()].getPiece(); //enemy pawn 2 ahead
								if(tempPawn2.getSymbol() != 'P') {
									return false;
								}
								Piece tempPawn3 = tiles[getYPos() - 1][getXPos() + 1].getPiece(); //ally pawn behind and to right
								if(tempPawn3.getSymbol() != 'p') {
									return false;
								}
								tiles[getYPos()][getXPos() + 1].setPiece(null);
								
							}
							else if(tiles[getYPos()][getXPos() - 1].getPiece() != null) {//left branch
								tempPawn1 = tiles[getYPos()][getXPos() - 1].getPiece();
								
								if(tempPawn1.getSymbol() != 'P'||!tempPawn1.getEnPassant())  { //checks if it is a black pawn and it can be attack w/ en passant
									return false;
								}
								
								Piece tempPawn2 = tiles[getYPos() + 2][getXPos()].getPiece(); //enemy pawn 2 ahead
								if(tempPawn2.getSymbol() != 'P') {
									return false;
								}
								Piece tempPawn3 = tiles[getYPos() - 1][getXPos() - 1].getPiece(); //ally pawn behind and to right
								if(tempPawn3.getSymbol() != 'p') {
									return false;
								}
								tiles[getYPos()][getXPos() - 1].setPiece(null);
							}					
						}
						catch(Exception NullPointerException) {
							return false;
						}
					}
					
					//regular attack
					else if(otherPiece.getTeam() == getTeam()) {
						return false; //can't attack your own team
					}
					
					return true;
				}
				
				else if(firstMove) {		
					if(newX == getXPos() && (newY == (getYPos()+2))){
						
						if( (tiles[newY][newX].getPiece() != null) && (tiles[newY-1][newX].getPiece() != null)) {
							return false; //can't skip over pieces
							
						}
						
						firstMove = false;
						enPassant = true;
						return true;
					}										
				}			
			
		}
		
		return false;
	}
	
	@Override
	public boolean getEnPassant() {
		return enPassant;
	}
}
