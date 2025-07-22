package Cards;
import java.util.ArrayList;
import java.util.Scanner;
// deal out 2 cards to the player
// deal 2 cards to the dealer but only reveal one card
// calculate the total of the cards to check if it is a blackjack
// ask the player if they would like to hit, stay, split, or double down (depends on their hand)
// if they get a blackjack - 3:2 odds
// have a money counter that starts with 500 dollars
// deal out cards that are different
//make a thing so you can continue after one hand or be able to restart entirely
public class Blackjack {
    
    public static void main(String[] args, int totalplayerHand) {
        Scanner answer = new Scanner(System.in);
        Deck deck = new Deck();
        Deck playerHand = new Deck(new ArrayList<Card>()); 
        Deck splitHand1 = new Deck(new ArrayList<Card>());
        Deck splitHand2 = new Deck(new ArrayList<Card>());
        Deck splitHand3 = new Deck(new ArrayList<Card>());
        Deck dealerHand = new Deck(new ArrayList<Card>()); 
        int counter = 0;
        int counter1 = 0;
        deck.shuffle();
        playerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        dealerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        playerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        dealerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        System.out.println("Welcome to Blackjack!");
        System.out.println("You have 500 dollars.");
        System.err.println("How much would you like to bet?");
        System.out.println("Your cards are: " + playerHand.getCard(0) + " " + playerHand.getCard(1));
        System.out.println("Total: " + totalplayerHand);
        System.out.println("The dealer has a " + dealerHand.getCard(0)); 
        
    }

    public static void dealerGame(Deck deck, Deck dealerHand, int counter) {
        int totaldealerHand = 0;
        for (int i = 0; i < dealerHand.size(); i++) {
            totaldealerHand += faceCard(dealerHand.getCard(i));
        }
        if (totaldealerHand == 21 && counter == 0) {
            System.out.println("The dealer has Blackjack. Their cards were " + dealerHand.getCard(0) + " " + dealerHand.getCard(1));
            //Player loses money
        }
        else if (totaldealerHand == 21 && counter > 0) {
            System.out.println("The dealer has 21. Their cards were ");
            for (int i = 0; i < counter; i++) {
                System.out.print(dealerHand.getCard(i) + " ");
                //Player loses money
            }
        }
        else if (totaldealerHand < 17) {
            System.out.println("The dealer has ");
            for (int i = 0; i < counter; i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            dealerHand.addCard(deck.getCard(0));
            deck.subtractCard();
            dealerGame(deck, dealerHand, counter);
        }
        else if (totaldealerHand > 21) {
            System.out.println("The dealer has busted. Their cards were ");
            for (int i = 0; i < counter; i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("There total was " + totaldealerHand + ".");
        }
        else {
            //dealer stays and compare their hand against players'
        }
    }

    public static void playerGame(Deck playerHand, Deck deck, Deck splitHand1, int counter1) {
        Scanner answer = new Scanner(System.in);
        int totalplayerHand = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            totalplayerHand += faceCard(playerHand.getCard(i));
        }
        if (totalplayerHand == 21 && counter1 == 0) {
            System.out.println("You have BlackJack. Your cards were ");
            for (int i = 0; i < counter1; i++) {
                System.out.print(playerHand.getCard(i) + " ");
            }
            //Player gains money
        }
        else if (totalplayerHand == 21 && counter1 > 0) {
            //player stays then dealer goes
            dealerGame(playerHand, playerHand, counter1);
        }
        else {
            if (playerHand.getCard(0) == playerHand.getCard(1)) {
                System.out.println("Would you like to hit, stay, double down, or split?");
                System.out.print("Choice: ");
            } 
            else {
                System.out.println("Would you like to hit, stay, or double down?");
                System.out.print("Choice: ");
            }            
            String choice = answer.next();
            while (!(choice.equalsIgnoreCase ("hit") || (choice.equalsIgnoreCase ("stay")) || (choice.equalsIgnoreCase ("double down")) || (choice.equalsIgnoreCase ("split"))) || (choice.equalsIgnoreCase ("split") && playerHand.getCard(0) != playerHand.getCard(1))) {
                System.err.println("That is not an answer.");
                System.out.print("Choice: ");
                choice = answer.next();
            }
            if (choice.equalsIgnoreCase ("hit")) {
                playerHand.addCard(deck.getCard(0));
                deck.subtractCard();    
                //give anotehr card
            }
            else if (choice.equalsIgnoreCase ("stay")) {
                //dealer gets card or stays if they have a 17 or above
            }
            else if (choice.equalsIgnoreCase ("double down")) {
                playerHand.addCard(deck.getCard(0));
                deck.subtractCard();    
                //give one more card and double the bet
            }
            if (playerHand.getCard(0) == playerHand.getCard(1) && choice.equalsIgnoreCase ("split")) {
                splitHand1.addCard(playerHand.getCard(0));
                playerHand.subtractCard();
                playerHand.addCard(deck.getCard(0));
                deck.subtractCard();
                splitHand1.addCard(playerHand.getCard(0));
                deck.subtractCard();
                //make two hands each with one of those cards
                //could split multiple times
            }
        } 
    }

    public static int faceCard(Card a) {
        if (a.getValue() > 10 & a.getValue() < 14) {
            return 10;
        }
        else if (a.getValue() == 14){
            //either 1 or 11
        }
        else {
            return a.getValue();
        }
    }

    

}
