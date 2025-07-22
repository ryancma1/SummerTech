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
        Deck dealerHand = new Deck(new ArrayList<Card>()); 
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
        if (playerHand.getCard(0) == playerHand.getCard(1)) {
            System.out.println("Would you like to hit, stay, double down, or split?");
            System.out.print("Choice: ");
        } 
        else {
            System.out.println("Would you like to hit, stay, or double down?");
            System.out.print("Choice: ");
        }            
        String choice = answer.next();
        while (!(choice.equalsIgnoreCase ("hit") || (choice.equalsIgnoreCase ("stay")) || (choice.equalsIgnoreCase ("double down")) || (choice.equalsIgnoreCase ("split")))) {
            System.err.println("That is not an answer.");
            System.out.print("Choice: ");
            choice = answer.next();
        }
        if (choice.equalsIgnoreCase ("hit")) {
            playerHand.addCard(deck.getCard(0));
            deck.subtractCard    
            //give anotehr card
        }
        else if (choice.equalsIgnoreCase ("stay")) {
            //dealer gets card or stays if they have a 17 or above
        }
        else if (choice.equalsIgnoreCase ("double down")) {
            //give one more card and double the bet
        }
        else if (playerHand.getCard(0) != playerHand.getCard(1) && choice.equalsIgnoreCase ("split")) {
            //make two hands each with one of those cards
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

    public static void check(Deck playerHand, Deck dealerHand) {
        int totalplayerHand = 0;
        int totaldealerHand = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            totalplayerHand += faceCard(playerHand.getCard(i));
        }
        for (int i = 0; i < dealerHand.size(); i++) {
            totaldealerHand += faceCard(dealerHand.getCard(i));
        }
        if (totalplayerHand == 21 && totaldealerHand == 21) {
            //give money back
        }
        else if (totalplayerHand > 21 && totaldealerHand < 21) {
            //player loses whatever they bet
        }
        else if (totalplayerHand < 21 && totaldealerHand > 21) {
            //player wins whatever they bet
        }
        else if (totalplayerHand < 21 && totaldealerHand < 21 && totalplayerHand > totaldealerHand) {
            //give player money bc they win
        }
        else if (totalplayerHand < 21 && totaldealerHand < 21 && totalplayerHand < totaldealerHand) {
            //player loses money
        }
        else if (totalplayerHand < 21 && totaldealerHand < 21 && totalplayerHand == totaldealerHand) {
            //give money back
        }
        else {
            //player loses money
        }
    }

}
