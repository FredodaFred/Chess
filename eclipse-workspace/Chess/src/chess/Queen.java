package chess;

public class Queen extends Piece{

	public Queen(int y, int x, char team) {
		super(y, x, team);
		if(team == 'W') {
			setSymbol('Q');
		}
		else {
			setSymbol('q');
		}
	}

	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {

		switch(1) {
		
		case 1: //Castle case
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
				return true;
			}
		
		case 2: //Bishop case
			
			int a =  getXPos() - newX; //Change in X
			int b = getYPos() - newY; // Change in Y

			if(Math.abs(a) == Math.abs(b)) { //is the free movement valid?
				
				//piece interaction
				
				//convert a and b into negative or positive 1 to determine direction
				a = a/Math.abs(a); 
				b = b/Math.abs(b); 
				
				if((a == -1) && (b == -1)) { //case 1: down & right
					
					for(int i = getXPos() + 1; (i < newX); i++) { //x axis going left
						
						for(int j = getYPos() + 1; j < newY; j++) { //y axis going up
													
							if(tiles[j][i].getPiece() != null) {
								Piece otherPiece = tiles[j][i].getPiece();													
								if(( i > newX) && (j > newY) ) {
									return false; //can't skip over pieces
								}
								else if( (i == newX) && (j == newY)) {
									
									if(otherPiece.getTeam() == getTeam()){
										return false; //can't kill your own team
									}
								}
									
							}						
						}				
					}
					
				}
				else if ((a == -1) && (b == 1)) { //case 2: up and right 
					
					for(int i = getXPos() + 1; i < newX; i++) { //x axis going right
						
						for(int j = getYPos() -1 ; j >= newY; j--) { //y axis going up
							
							if(tiles[j][i].getPiece() != null) {	
								
								Piece otherPiece = tiles[j][i].getPiece();						
								if(( i > newX) && (j < newY)) {
									
									return false; //can't skip over pieces
								}
								else if( (i == newX) && (j == newY)) {
									if(otherPiece.getTeam() == getTeam()){
										return false; //can't kill your own team
									}
								}
							}						
						}				
					}
				}
				else if ((a == 1) && (b == 1)) { //case 3: up & left

					for(int i = getXPos() - 1; i  >= newX; i--) { //x axis going right
						
						for(int j = getYPos() - 1; j >= newY; j--) { //y axis going down
							
							if(tiles[j][i].getPiece() != null) {
								
								Piece otherPiece = tiles[j][i].getPiece();						
								if(( i < newX) && (j < newY) ) {
									return false; //can't skip over pieces
								}
								else if( (i == newX) && (j == newY)) {
									
									if(otherPiece.getTeam() == getTeam()){
										return false; //can't kill your own team
									}
								}
							}						
						}				
					}
				}
				else { //case 4: down and left (a == 1) && (b == -1)
					
					for(int i = getXPos() - 1; i >= newX; i--) { //x axis going left
						
						for(int j = getYPos() + 1; j < newY; j++) { //y axis going down
							
							if(tiles[j][i].getPiece() != null) {
								
								Piece otherPiece = tiles[j][i].getPiece();	
								
								if(( i > newX) && (j < newY) ) {
									return false; //can't skip over pieces
								}
								else if( (i == newX) && (j == newY)) {
									
									if(otherPiece.getTeam() == getTeam()){
										return false; //can't kill your own team
									}
								}
							}						
						}				
					}
				}
				
				return true;
			}
		}
		return false;
	}
}
