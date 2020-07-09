package Project2;
import cardgames.*;

/**
 * This class functions to generate 3 random cards from a deck
 * and display them, find a pair, find the highest value
 * and compare their sum to the number 25
 * 
 * @Frederick Sion
 */
public class Project2 {

    /**
     * Add proper JavaDoc comments here
     */
    public static void main( String args[] ) {
	GUI theWindow = new GUI();
	Deck theDeck = new Deck();
	theDeck.shuffleDeck();
	Card card1 = theDeck.dealCard();
	//Card card1 = new Card(31);
	System.out.println( "Card 1 is: " + card1.toString() );
	Card card2 = theDeck.dealCard();
	//Card card2 = new Card(23);
	System.out.println( "Card 2 is: " + card2.toString() );
	Card card3 = theDeck.dealCard();
	//Card card3 = new Card(19);
	System.out.println( "Card 3 is: " + card3.toString() );		
	
	theWindow.showCard( card1 );
	theWindow.showCard( card2 );
	theWindow.showCard( card3 );	
	
	if( card1.getValue() == card2.getValue() ) {
	    System.out.println( "Pair" );
	}
	else if(card1.getValue() == card3.getValue()) {
	    System.out.println( "Pair" );
	}
	else if(card2.getValue() == card3.getValue()) {
	    System.out.println( "Pair" );
	}
	else {
	    System.out.println( "Not a pair" );
    }
    
    int maxVal = card1.getValue();
    int sum =  card1.getValue() + card2.getValue() + card3.getValue();
    
    if(card1.getValue() < card2.getValue()) {
    	maxVal = card2.getValue();
    }
    if(maxVal < card3.getValue()) {
    	maxVal = card3.getValue();
    }
    
    System.out.println("The highest value is " + maxVal);
    System.out.println("The sum is " + sum);
    
    if(sum>=25) {
    	System.out.println("The player wins!");
    }
    else {
    	System.out.println("The computer wins!");
    }
}
}
