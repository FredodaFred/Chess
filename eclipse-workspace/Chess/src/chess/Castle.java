package chess;

public class Castle extends Piece {

	private boolean firstMove;
	public Castle(int x, int y, char team) {
		
		super(x, y, team);
		if(team == 'W') {
			setSymbol('R');
		}
		else {
			setSymbol('r');
		}
		
		firstMove = true;
	}
	
	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {
		

		if((getXPos() == newX)&&(getYPos() != newY)) { //Up and down movement
			
			//interaction with other pieces		
			if(newY - getYPos() < 0) {   //checking up
				
				for(int i = getYPos()-1; i >= 0; i--) {//loop to check pieces above
					
					if(tiles[i][getXPos()].getPiece() != null) { //other piece in path found
						
						Piece otherPiece = tiles[i][getXPos()].getPiece();
						if((i > newY)) { //i represents the yPos of the other piece					
							return false; //can't jump over pieces
						}
						else if((i == newY) && (otherPiece.getTeam() == getTeam())){
							return false; //can't kill your own team member
						}
					}
				}
			}
			
			else { //checking down
				
				for(int i = getYPos()+1; i < 8; i++) { //loop to check pieces below
					
					if(tiles[i][getXPos()].getPiece() != null) { //other piece in path found
						
						Piece otherPiece = tiles[i][getXPos()].getPiece();
						if((i < newY)) { //i represents the yPos of the other piece					
							return false; //can't jump over pieces
						}
						else if((i == newY) && (otherPiece.getTeam() == getTeam())){
							return false; //can't kill your own team member
						}						
					}				
				}
			}

			firstMove = false;
			return true;
		}
		
		else if((getYPos() == newY)&&(getXPos() != newX)) { //Side to side movement
			
			//interaction with other pieces	
			if(newX -getXPos() < 0) {   //checking left side

				for(int i = getXPos()-1; i >= 0; i--) { //loop to check pieces to the left
					
					if(tiles[getYPos()][i].getPiece() != null) { //other piece in path found
									
						Piece otherPiece = tiles[getYPos()][i].getPiece();
						
						if((i > newX)) { //i represents the yPos of the other piece					
							return false; //can't jump over pieces
						}
						else if((i == newX) && (otherPiece.getTeam() == getTeam())){							
							return false; //can't kill your own team member
						}						
					}
				}
			}
			
			else { //checking right side
				
				for(int i = getXPos()+1; i < 8; i++) {//loop to check pieces to the right
					
					if(tiles[getYPos()][i].getPiece() != null) { //other piece in path found
						
						Piece otherPiece = tiles[getYPos()][i].getPiece();
						if((i < newX)) { //i represents the yPos of the other piece					
							return false; //cant jump over pieces
						}
						else if((i == newX) && (otherPiece.getTeam() == getTeam())){
							return false; //cant kill your own team member
						}					
					}				
				}
			}
			
			firstMove = false;
			return true;
		}
				
		return false;
	}
	
	@Override
	public boolean getFirstMove() {
		return firstMove;
	}

}
