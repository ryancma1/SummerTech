package Cards;

public class Card {
    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public String suitToString(){
        if (suit == 1){
            return "♦";
        }
        else if (suit == 2){
            return "♣";
        }
        else if (suit == 3){
            return "♥";
        }
        else if (suit == 4){
            return "♠";
        }
        return "No Card";
    }

    public String valueToString(){
        if (value > 1 && value < 11){
            return "" + value;
        }
        else if (value == 11){
            return "J";
        }
        else if (value == 12){
            return "Q";
        }
        else if (value == 13){
            return "K";
        }
        else if (value == 14){
            return "A";
        }
        return "No Card";
    }

    public String toString(){
        return valueToString() + suitToString();
    }
}
    