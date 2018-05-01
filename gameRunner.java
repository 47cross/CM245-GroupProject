
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class gameRunner {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        Player D = new Player("Dealer");
        
        System.out.print("Please enter your name: \n");
        Player P1 = new Player(in.next());
        System.out.printf("Alright %s, are you ready to play? \n",P1.getName());
        
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        
        P1.addCard(deck.deal());
        P1.addCard(deck.deal());
        P1.printHand();
        System.out.println(P1.getHandSum());
        
    }
}
