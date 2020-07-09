package chess;

public class Knight extends Piece {

	public Knight(int y, int x, char team) {
		
		super(y, x, team);
		if(team == 'W') {
			setSymbol('H');
		}
		else {
			setSymbol('h');
		}
	}
	
	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {
		
		//pieces work the same way for both teams, because piece can move back and forth
		if((newX == getXPos() + 1)||(newX == getXPos() - 1)) { //x position is valid?
			
			if((newY == getYPos() +2)||(newY == getYPos() -2)) { //y position is valid
				
				//piece interactions

				if(tiles[newY][newX].getPiece() != null) {	
					Piece otherPiece = tiles[newY][newX].getPiece();
					if(otherPiece.getTeam() == getTeam()) {
						return false;
					}					
				}
				
				return true;
			}				
		}
		else if((newY == getXPos() +2)||(newY == getXPos() -2)) {
			
		}
			if((newY == getYPos() +1)||(newY == getYPos() -1)) { //y position is valid
				
				//piece interactions

				if(tiles[newY][newX].getPiece() != null) {	
					Piece otherPiece = tiles[newY][newX].getPiece();
					if(otherPiece.getTeam() == getTeam()) {
						return false;
					}					
				}
				
				return true;
			
		}
		return false;	
	}

}
 