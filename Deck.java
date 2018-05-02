
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Deck {
    
 private ArrayList<Card> cards;

    public void createDeck() {
        cards = new ArrayList<>();
        int theSuit, theValue;
        for (theSuit = 0; theSuit <= 3; theSuit++) {
            for (theValue = 1; theValue <= 13; theValue++) {
                Card c = new Card(theValue, theSuit);
                cards.add(c);
            }
        }
    }
    
    public void printDeck() {
        for(int k = 0;k < cards.size();k++) {
            System.out.println(cards.get(k));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void reset() {
        cards.clear();
        createDeck();
    }

    public Card deal() {
        int size = cards.size();
        if (size == 1) {
            reset();
            shuffle();
        }
        
        return cards.remove(0);
    }
    
}
