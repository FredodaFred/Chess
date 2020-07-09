package chess;

public class Piece {

	private int xPos; //determines x position on board
	private int yPos; //determines y position on board
	private final char color; //W represents white, B represents black
	private char symbol;
	
	public Piece(int y, int x, char team) {
		xPos = x;
		yPos = y;
		color = team;
		symbol = '-';
	}
	
	public boolean isValidMove(int newX, int newY, Tile[][] tiles) {
		//stub method
		return false;
	}
	
	public void setXPos(int newXPos) {
		xPos = newXPos;
	}
	
	public int getXPos() {
		
		return xPos;
	}
	public void setYPos(int newYPos) {
		yPos = newYPos;
	}
	
	public int getYPos() {
		
		return yPos;
	}
	
	public char getTeam() {
		return color;
	}
	
	public void setSymbol(char x) {
		symbol = x;
	}
	public char getSymbol() {
		return symbol;
	}
	
	public boolean getEnPassant() { //for pawn
		return false;
	}
	public boolean getFirstMove() { //for castle
		return false;
	}
	
	public String toString() {
		
			return("" + symbol);
	}
	
}
