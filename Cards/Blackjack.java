package Cards;
import java.util.ArrayList;
// deal out 2 cards to the player
// deal 2 cards to the dealer but only reveal one card
// calculate the total of the cards to check if it is a blackjack
// ask the player if they would like to hit, stay, split, or double down (depends on their hand)
// if they get a blackjack - 3:2 odds
// have a money counter that starts with 500 dollars
// deal out cards that are different
public class Blackjack {
    
    public static void main(String[] args) {
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
        else if (
    }

}
