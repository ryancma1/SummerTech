package War;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
        for (int i = 1; i < 5; i++ ) {
            for (int j = 2; j < 15; j++) {
                deck.add(new Card(j, i));
            }
        }
    }  

    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    public void shuffle() {
        Random number = new Random();
        Card holder = new Card(1, 1);
        int counter = 0;
        while (counter < deck.size()) {
            int random1 = number.nextInt(deck.size());
            int random2 = number.nextInt(deck.size());
            if (random1 != random2){   
                holder = deck.get(random1);
                deck.set(random1, deck.get(random2));
                deck.set(random2, holder);
                counter++;
            }
        }
    }

    public void addCard(Card a) {
        deck.add(a);
    }

    public void subtractCard() {
        deck.remove(0);
    }

    public int size() {
        return deck.size();
    }
}