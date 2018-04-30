/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import java.util.ArrayList;

/**
 *
 * @author matts
 */
public class Player {
    
    private String name;    //Player name
    private ArrayList<Card> hand = new ArrayList<>();   //Cards in the player's current hand
    private int numCards;   //# of cards in the players hand
    
    
    public Player(String aName) {
        
        this.name = aName;
        this.emptyHand();
    }
    public void emptyHand() {}  //Reset the player's hand to have no cards
        
    public int getHandSum() {   //Get the sum of the cards in the player's hand
        
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        // calculate each card's contribution to the hand sum
        for(int c = 0; c < this.numCards; c++){
            
            //get the number for the current card
            cardNum = hand.getClass(c).getNumber();
            
            if(cardNum == 1) {  //Ace
                numAces++;
                handSum += 11;
            } else if(cardNum > 10) {   //face card
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }
        //if we have aces and our sum is > 21, set some/all of them to value 1
        //instead
        while(handSum > 21 && numAces > 0) {
            handSum -= 10;
            numAces--;
        }
        
        return handSum;
    }
    public void printHand(boolean showFirstCard) {  //Print the cards in the player's hand
        
        System.out.printf("%s's cards: \n", this.name);
        for(int c = 0; c < this.numCards; c++){
            if(c == 0 && !showFirstCard){
                System.out.println("   [hidden]");
            } else {
                System.out.printf("  %s\n", this.hand.getClass(c).toString());
            }
        }
    }
}
