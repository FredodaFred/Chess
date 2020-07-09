package chess;

public class King extends Piece{

	private boolean firstMove;
	public King(int y, int x, char team) {
		
		super(y, x, team);
		if(team == 'W') {
			setSymbol('K');
		}
		else {
			setSymbol('k');
		}
		
		firstMove = true;
	}
	
	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {
		
		switch(1) {
		
		case 1: //Castle case
			if((getXPos() == newX)&&(getYPos() != newY)) {
				
				if(Math.abs(getYPos() - newY) <= 1) { //make sure it can only move on tile at a time
					
					//piece interaction
					if(tiles[newY][newX].getPiece() != null) {
						
						Piece otherPiece = tiles[newY][newX].getPiece(); 
						if(otherPiece.getTeam() == getTeam()) {
							return false; //can't attack own team
						}
					}
					
					firstMove = false;
					return true;
				} 
				
			}
			else if((getYPos() == newY)&&(getXPos() != newX)) {
				if(Math.abs(getXPos() - newX) <= 1) { //make sure it can only move on tile at a time
					
					//piece interaction
					if(tiles[newY][newX].getPiece() != null) {
						
						Piece otherPiece = tiles[newY][newX].getPiece(); 
						if(otherPiece.getTeam() == getTeam()) {
							return false; //can't attack own team
						}
					}
					
					firstMove = false;
					return true;
				}
			}
		
		case 2: //Bishop case
			int a =  Math.abs(getXPos() - newX);
			int b = Math.abs(getYPos() - newY);
			
			if((a == b)&&( Math.abs(a) == 1)) { //Math.abs(a) == 1 to make sure it only moved one space
				
				//piece interaction
				if(tiles[newY][newX].getPiece() != null) {
					
					Piece otherPiece = tiles[newY][newX].getPiece(); 
					if(otherPiece.getTeam() == getTeam()) {
						return false; //can't attack own team
					}
				}
				
				firstMove = false;
				return true;
			}
			
		case 3: //Castling
			
			if(firstMove) {
				switch(getTeam()) {
				
					case 'W': //castling for white team
						if(newX == 6 && newY == 7) {
							Piece tempCastle = tiles[7][7].getPiece();
							try { //in case tiles[7][7] is null
								if(tempCastle.getSymbol() != 'R') {
									return false;
								}
								if(!tempCastle.getFirstMove()) {
									return false;
								}
								
								for(int i = 5; i < 7; i++) {
									if(tiles[7][i].getPiece() != null) {
										return false;
									}
								}
								
								tiles[7][5].setPiece(tempCastle);
								tiles[7][7].setPiece(null);
							}
							catch(Exception NullPointerException) {
								return false;
							}
						}
						else if(newX == 1 && newY == 7){
							Piece tempCastle = tiles[7][0].getPiece();
							try { //in case tiles[7][0] is null
								if(tempCastle.getSymbol() != 'R') {
									return false;
								}
								if(!tempCastle.getFirstMove()) {
									return false;
								}
								
								for(int i = 3; i > 0; i--) {
									if(tiles[7][i].getPiece() != null) {
										return false;
									}
								}
								
								tiles[7][2].setPiece(tempCastle);
								tiles[7][0].setPiece(null);
							}
							catch(Exception NullPointerException) {
								return false;
							}
						}
						
					break;
					case 'B': //castling for black team
						if(newX == 6 && newY == 0) {
							Piece tempCastle = tiles[0][7].getPiece();
							try { //in case tiles[0][7] is null
								if(tempCastle.getSymbol() != 'r') {
									return false;
								}
								if(!tempCastle.getFirstMove()) {
									return false;
								}
								
								for(int i = 4; i < 7; i++) {
									if(tiles[0][i].getPiece() != null) {
										return false;
									}
								}
								
								tiles[0][5].setPiece(tempCastle);
								tiles[0][7].setPiece(null);
							}
							catch(Exception NullPointerException) {
								return false;
							}
						}
						else if(newX == 1 && newY == 0){
							Piece tempCastle = tiles[0][0].getPiece();
							try { //in case tiles[0][0] is null
								if(tempCastle.getSymbol() != 'r') {
									return false;
								}
								if(!tempCastle.getFirstMove()) {
									return false;
								}
								
								for(int i = 2; i > 0; i--) {
									if(tiles[0][i].getPiece() != null) {
										return false;
									}
								}
								
								tiles[0][2].setPiece(tempCastle);
								tiles[0][0].setPiece(null);
							}
							catch(Exception NullPointerException) {
								return false;
							}
						}					
				}	
				return true;
			}		
		}
		
		return false;
	}

}
