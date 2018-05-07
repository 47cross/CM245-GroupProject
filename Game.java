package CardGame;

import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import static javafx.application.Application.launch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class Game extends Application {
    private Button btHit = new Button("Hit");
    private Button btStay = new Button("Stay");
    private Button btNew = new Button("New Game");
    private TextField tfDealer = new TextField();
    private TextField tfPlayer = new TextField();
    private HBox handBox = new HBox(15); 
    private boolean bust;
    private boolean p1Turn;
    Label status = new Label();
    Label PTotal = new Label();
    Label DTotal = new Label();
    
   
     @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a border pane 
    BorderPane pane = new BorderPane();
        
        Scanner in = new Scanner(System.in);
        Player D = new Player("Dealer");
        
        System.out.print("Please enter your name: \n");
        Player P1 = new Player(in.next());
        System.out.printf("Alright %s, are you ready to play? \n",P1.getName());
        p1Turn=true;
        bust=false;
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffle();
        
        P1.addCard(deck.deal());
        P1.printHand();
        System.out.println(P1.getHandSum());
        
            // Place nodes in the pane
        pane.setBottom(getHandBox(P1)); 
        pane.setCenter(getGrid());
        pane.setTop(getDealerBox(D));
        
        newGame(deck,P1,D,pane);
        
        
        
        
        btHit.setOnAction(e -> {
            if(p1Turn == true && bust!=true){
                P1.addCard(deck.deal());
                pane.setBottom(getHandBox(P1));
            }
            if(P1.getHandSum() > 21){
                bust = true;
                p1Turn = false;
                status.setText("Bust!");
            }
        });
        btStay.setOnAction(e -> {
            if(p1Turn == true && bust!=true){
                p1Turn = false;
                while(D.getHandSum()<17){
                    D.addCard(deck.deal());
                pane.setTop(getDealerBox(D));
                if(P1.getHandSum() > D.getHandSum() && D.getHandSum() < 21){
                    status.setText("YOU WIN!");
                } else if(P1.getHandSum() < D.getHandSum() && D.getHandSum() < 21){
                    status.setText("you lose...");
                } else if(P1.getHandSum() == D.getHandSum())
                    status.setText("TIE!");
                }
             }
        });
        btNew.setOnAction(e -> {
            newGame(deck,P1,D,pane);
        });
    
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 450);
        primaryStage.setTitle("BlackJack"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
  }
  public void newDeck(Deck deck){
         
        }
  
  public void newGame(Deck deck, Player P1, Player D, BorderPane pane ) {
      D.emptyHand();
      P1.emptyHand();
      deck.reset();
      deck.shuffle();
      P1.addCard(deck.deal());
      D.addCard(deck.deal());
      pane.setTop(getDealerBox(D));
      pane.setCenter(getGrid());
      pane.setBottom(getHandBox(P1));
      bust = false;
      p1Turn = true;
      status.setText("");
  }
  
  private HBox getDealerBox(Player D) {
    HBox dealerBox = new HBox(15); 
    dealerBox.setPadding(new Insets(15, 15, 15, 15));
    dealerBox.setStyle("-fx-background-color: green");
    for(int k = 0;k <D.getNumCards();k++) {
       ImageView imageView = new ImageView(new Image("BlackJackCards/" + 
                D.getCardName(D.getCard(k)) + ".png"));
        dealerBox.getChildren().add(imageView);
    }
    DTotal.setText("Dealer Total: " + String.valueOf(D.getHandSum()));
    return dealerBox;
  }
  
    public HBox getHandBox(Player P1) {
   // HBox handBox = new HBox(15); 
    handBox.setPadding(new Insets(15, 15, 15, 15));
    handBox.setStyle("-fx-background-color: green");
    handBox.getChildren().clear();
    for(int k = 0;k <P1.getNumCards();k++) {
        ImageView imageView = new ImageView(new Image("BlackJackCards/" + 
                P1.getCardName(P1.getCard(k)) + ".png"));
        handBox.getChildren().add(imageView);
    }
    PTotal.setText("Player Total: " + String.valueOf(P1.getHandSum()));
    return handBox;
    }
  
  private GridPane getGrid() {
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(5);
    grid.setVgap(40);
    grid.add(DTotal,2,0);
    grid.add(btHit,1,1);
    grid.add(btStay,2,1);
    grid.add(btNew,3,1);
    grid.add(PTotal,2,2);
    grid.add(status,4,1);
     return grid;
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
} 


        
    

