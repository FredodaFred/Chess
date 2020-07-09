package chess;

public class Tile {

	private final int xPos;
	private final int yPos;
	private Piece thePiece;
	
	public Tile(int x, int y) {		
		xPos = x;
		yPos = y;
		
		
	}
	
	public void setPiece(Piece currentPiece) {
		
		thePiece = currentPiece;
	}
	
	public void removePiece() {
		
		thePiece = null;
	}
	
	public Piece getPiece() {
		return thePiece;
	}
	
	@Override
	public String toString() {
		
		return(xPos + ", " + yPos);
	}
}
