
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Player extends Deck {
    
    private String name;
    private ArrayList<Card> hand = new ArrayList<>();
    private int numCards;
    
    public Player(String aName) {
        
        this.name = aName;
        this.emptyHand();
        
    }
    public void emptyHand() {}
    
    public void addCard(Card c) {
        hand.add(c);
        numCards++;
    }
    
    //Mutators
    public String getName() {
        return this.name;
    }
    public int getNumCards() {
        return this.numCards;
    }
    
    
    public int getHandSum() {
        
        int handSum = 0;
        int cardNum;
        int numAces = 0;
        
        for(int c = 0; c < this.numCards; c++) {
            
            cardNum = this.hand.get(c).getValue();
            
            if(cardNum == 1) {
                numAces++;
                handSum = handSum + 11;
            } else if(cardNum > 10) {
                handSum = handSum + 10;
            } else {
                handSum = handSum + cardNum;
            }
        }
      
        while(handSum > 21 && numAces > 0) {
            handSum = handSum - 10;
            numAces--;
        }
        return handSum;
    }
    public void printHand() {
        for(int k = 0;k < hand.size();k++) {
            System.out.println(hand.get(k));

            }
        }
    }

