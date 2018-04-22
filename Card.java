/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author Super
 */
public class Card {
    public final static int SPADES = 0, HEARTS =1, DIAMONDS = 2, CLUBS = 3;
    
    public final static int ACE = 1, JACK = 11, QUEEN = 12, KING = 13;
    
    private int suit;
    private int value;
    
    public Card(int theValue, int theSuit){
        value = theValue;
        suit = theSuit;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public int getSuit(){
        return this.suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public String getSuitString(){
        switch (suit){
            case SPADES:    return "Spades";
            case HEARTS:    return "Hearts";
            case CLUBS:     return "Clubs";
            case DIAMONDS:  return "Diamonds";
            default:        return "invalid suit";
        }
    }
    
    public String getValueString(){
        switch (value){
            case 1:     return "Ace";
            case 2:     return "2";
            case 3:     return "3";
            case 4:     return "4";
            case 5:     return "5";
            case 6:     return "6";
            case 7:     return "7";
            case 8:     return "8";
            case 9:     return "9";
            case 10:    return "10";
            case 11:    return "Jack";
            case 12:    return "Queen";
            case 13:    return "King";
            default:    return "invalid card value";
        }
    }
    
    public String toString(){
        return getValueString() + "of" + getSuitString();
    }
}