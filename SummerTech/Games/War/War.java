package War;
import java.util.ArrayList;
import java.util.Scanner;

public class War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        Deck playerHand = new Deck (new ArrayList<Card>());
        Deck botHand = new Deck (new ArrayList<Card>());
        boolean war = true;
        int counter = 4;
        deck.shuffle();
        for (int i = 0; i < 26; i++) {
            playerHand.addCard(deck.getCard(0));
            deck.subtractCard();
            botHand.addCard(deck.getCard(0));
            deck.subtractCard();
        }
        System.out.println("Welcome to War!");
        System.out.println("Press enter each time to draw a card." );
        while (playerHand.size() > 0 && botHand.size() > 0) {
            String draw = scanner.nextLine();
            System.out.println("Player: " + playerHand.getCard(0));
            System.out.println("Bot: " + botHand.getCard(0));
            if (playerHand.getCard(0).getValue() > botHand.getCard(0).getValue()) {
                System.out.println("Player Won!");
                playerHand.addCard(botHand.getCard(0));
                playerHand.addCard(playerHand.getCard(0));
                playerHand.subtractCard();
                botHand.subtractCard();
            }
            else if (playerHand.getCard(0).getValue() < botHand.getCard(0).getValue()) {
                System.out.println("Bot Won.");
                botHand.addCard(playerHand.getCard(0));
                botHand.addCard(botHand.getCard(0));
                botHand.subtractCard();
                playerHand.subtractCard();
            }
            else if (playerHand.getCard(0).getValue() == botHand.getCard(0).getValue() && (playerHand.size() < 5 || botHand.size() < 5)) {
                if (playerHand.size() > botHand.size()) {
                    System.out.println("You won the entire game!");
                }
                else if (playerHand.size() < botHand.size()) {
                    System.out.println("The Bot won the entire game.");
                }
                break;
            }
            else if (playerHand.getCard(0).getValue() == botHand.getCard(0).getValue() && playerHand.size() > 4 && botHand.size() > 4) {
                counter = 4;
                while (war) {
                    System.out.println("There was a War.");
                    System.out.println("Player: ? ? ? " + playerHand.getCard(counter));
                    System.out.println("Bot: ? ? ? " + botHand.getCard(counter));
                    if (playerHand.getCard(counter).getValue() > botHand.getCard(counter).getValue()) {
                        System.out.println("Player Won the War!");
                        System.out.print("Player: "); 
                        for (int i = 0; i < counter + 1; i++) {
                            System.out.print(playerHand.getCard(i) + " ");
                        }
                        System.out.println();
                        System.out.print("Bot: ");
                        for (int i = 0; i < counter + 1; i++) {
                            System.out.print(botHand.getCard(i) + " ");
                        }
                        for (int i = 0; i < counter + 1; i++) {
                            playerHand.addCard(botHand.getCard(0));
                            playerHand.addCard(playerHand.getCard(0));
                            playerHand.subtractCard();
                            botHand.subtractCard();
                        }
                        war = false;
                    }
                    else if (playerHand.getCard(counter).getValue() < botHand.getCard(counter).getValue()) {
                        System.out.println("Bot Won the War.");
                        System.out.print("Player: "); 
                        for (int i = 0; i < counter + 1; i++) {
                            System.out.print(playerHand.getCard(i) + " ");
                        }
                        System.out.println();
                        System.out.print("Bot: ");
                        for (int i = 0; i < counter + 1; i++) {
                            System.out.print(botHand.getCard(i) + " ");
                        }
                        for (int i = 0; i < counter + 1; i++) {
                            botHand.addCard(playerHand.getCard(0));
                            botHand.addCard(botHand.getCard(0));
                            botHand.subtractCard();
                            playerHand.subtractCard();
                        }
                        war = false;
                    }
                    counter += 4;
                }
            }
            System.out.println();
            System.out.println("Player Cards: " + playerHand.size());
            System.out.println("Bot Cards: " + botHand.size());
            war = true;
        }
        if (playerHand.size() == 0) {
            System.out.println("The Bot won the entire game.");
        }
        else if (botHand.size() == 0) {
            System.out.println("You won the entire game!");
        }
    }
}