package chess;

public class Bishop extends Piece {

	public Bishop(int y, int x, char team) {
		
		super(y, x, team);
		if(team == 'W') {
			setSymbol('B');
		}
		else {
			setSymbol('b');
		}
	}
	
	@Override
	public boolean isValidMove(int newY, int newX, Tile[][] tiles) {
		
		
		int a =  getXPos() - newX; //Change in X
		int b = getYPos() - newY; // Change in Y
		
		if(Math.abs(a) == Math.abs(b)) { //is the free movement valid?
			
			//piece interaction
			
			//convert a and b into negative or positive 1 to determine direction
			a = a/Math.abs(a); System.out.print(a);
			b = b/Math.abs(b); System.out.print(b);
			
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
		
		return false;
	}

}
