
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matts
 */
public class gameRunner {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Player D = new Player("Dealer");
        
        System.out.print("Please enter your name: ");
        Player P1 = new Player(in.next());
        System.out.printf("\nAlright %s, are you ready to play? \n\n",P1.getName());
        
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        
        D.addCard(deck.deal());
        P1.addCard(deck.deal());
        D.addCard(deck.deal());
        P1.addCard(deck.deal());
        D.printHand();
        System.out.printf("%s's hand value: %d\n\n", D.getName(), D.getHandSum());
        P1.printHand();
        System.out.printf("%s's hand value: %d\n\n", P1.getName(), P1.getHandSum());
        
        if(P1.getHandSum() == 21 && D.getHandSum() < 21)
            System.out.printf("Congratulations %s! You have a blackjack!", P1.getName());
        else
            System.out.printf("Your card value is %d, would you like to hit or stay? (h/s)",P1.getHandSum());
        
        
    }
}
