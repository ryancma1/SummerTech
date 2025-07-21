package Cards;
public class CardUse {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            System.out.print(deck.getCard(i) + ", ");
        }
    }
}
