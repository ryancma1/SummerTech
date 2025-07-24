package Cards;
import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Deck playerHand = new Deck(new ArrayList<Card>()); 
        Deck dealerHand = new Deck(new ArrayList<Card>());
        Scanner answer = new Scanner(System.in); 
        int totalplayerHand = 0;
        int gameCounter = 0;
        int split = 0;
        String choice = "yes";
        System.out.println("");
        System.out.println("Welcome to Blackjack!");
        while (choice.equalsIgnoreCase("yes")) {
            gameCounter++;
            if (gameCounter > 1) {
                System.out.println();
                System.out.println("Would you like to play another hand?");
                System.out.print("Choice: ");
                choice = answer.next();
            }
            if (choice.equalsIgnoreCase("yes")) {
                startGame(deck, playerHand, dealerHand, totalplayerHand, split);
            }
        }
        while (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))) {
            System.out.println("Invalid Answer.");
            System.out.print("Choice: ");
            choice = answer.next();
        }
        if (choice.equalsIgnoreCase("no")) {
            System.out.println();
            System.out.println("Would you like to restart your money?");
            System.out.print("Choice: ");
            choice = answer.next();
            while (!(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("no"))) {
                System.out.println("Invalid Answer.");
                System.out.print("Choice: ");
                choice = answer.next();
            }
            while (choice.equalsIgnoreCase("yes")) {
                main(args);
            }
        }
    }

    public static void startGame(Deck deck, Deck playerHand, Deck dealerHand, int totalplayerHand, int split) {
        int counter = 0;
        int counter1 = 0;
        int totaldealerHand = 0;
        deck = new Deck();
        playerHand = new Deck(new ArrayList<Card>()); 
        dealerHand = new Deck(new ArrayList<Card>());
        deck.shuffle();
        System.out.println("");
        playerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        dealerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        playerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        dealerHand.addCard(deck.getCard(0));
        deck.subtractCard();
        System.out.println("Player: " + playerHand.getCard(0) + " " + playerHand.getCard(1));
        System.out.println("Dealer: " + dealerHand.getCard(0)); 
        playerGame(playerHand, deck, counter1, dealerHand, split, totaldealerHand);
    }

    public static void dealerGame(Deck deck, Deck dealerHand, int counter, int totalplayerHand) {
        int totaldealerHand = 0;
        int tracker = 0;
        for (int i = 0; i < dealerHand.size(); i++) {
            totaldealerHand += faceCard(dealerHand.getCard(i));
            if (faceCard(dealerHand.getCard(i)) == 1 && (totaldealerHand + 10 < 22)) {
                totaldealerHand += 10;
                tracker++;
            }
            for (int j = 0; j < dealerHand.size(); j++)  {
                if (faceCard(dealerHand.getCard(j)) == 1 && totaldealerHand > 21 && tracker > 0) {
                    totaldealerHand -= 10;
                    tracker--;
                }
            }
        }
        if (totaldealerHand == 21 && counter == 0) {
            System.out.println("Dealer has Blackjack. Dealer: " + dealerHand.getCard(0) + " " + dealerHand.getCard(1));
        }
        else if (totaldealerHand == 21 && counter > 0 && totalplayerHand > 21) {
            System.out.println("");
            System.out.println("Dealer has a total of 21 and you have a total of " + totalplayerHand + " and busted.");
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
        }
        else if (totaldealerHand == 21 && counter > 0 && totalplayerHand < 21) {
            System.out.println("Dealer won.");
            System.out.println("");
            System.out.println("Dealer has a total of 21 and you have a total of " + totalplayerHand + ".");
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
        }
        else if (totalplayerHand == 21 && totaldealerHand == 21) {
            System.out.println("It was a tie.");
            System.out.println("You and the dealer both got 21.");
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
        }
        else if (totalplayerHand == 21 && totaldealerHand < 21 && totaldealerHand > 16) {
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("You won!");
            System.out.println("The dealer had a total of " + totaldealerHand + " and you had a total of 21.");
            System.out.println("Dealer: ");
        }
        else if (totalplayerHand == 21 && totaldealerHand > 21) {
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("You won!");
            System.out.println("The dealer busted with a total of " + totaldealerHand + " and you had a total of 21.");
        }
        else if (totaldealerHand < 21 && totaldealerHand > 16 && totalplayerHand < 21) {
            System.out.println("");
            System.out.println ("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("Total: " + totaldealerHand);
            if (totaldealerHand > totalplayerHand) {
                System.out.println("Dealer won.");
                System.out.println("Dealer had a total of " + totaldealerHand + " and you had a total of " + totalplayerHand + ".");
            } 
            else if (totaldealerHand < totalplayerHand) {
                System.out.println("You won!");
                System.out.println("You had a total of " + totalplayerHand + " and the dealer had a total of " + totaldealerHand + ".");
            } 
            else if (totaldealerHand == totalplayerHand) {
                System.out.println("It was a tie.");
                System.out.println("Both the dealer and you had a total of " + totaldealerHand + ".");
            }
        }
        else if (totaldealerHand < 21 && totaldealerHand > 16 && totalplayerHand > 21) {
            System.out.println("");
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("Total: " + totaldealerHand);
            System.out.println("Dealer won.");
            System.out.println("Dealer had a total of " + totaldealerHand + " and you had a total of " + totalplayerHand + " and busted.");
        }
        else if (totaldealerHand < 17) {
            System.out.println("");
            System.out.print("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("Total: " + totaldealerHand);
            dealerHand.addCard(deck.getCard(0));
            System.out.println("Dealer drew a " + deck.getCard(0) + ".");
            counter++;
            deck.subtractCard();
            dealerGame(deck, dealerHand, counter, totalplayerHand);
        }
        else if (totaldealerHand > 21) {
            System.out.println("");
            System.out.println("Dealer has busted.");
            System.out.println("Dealer: ");
            for (int i = 0; i < dealerHand.size(); i++) {
                System.out.print(dealerHand.getCard(i) + " ");
            }
            System.out.println("");
            System.out.print("Dealer had a total of " + totaldealerHand + ".");
            if (totalplayerHand < 21) {
                System.out.println("");
                System.out.println("You won!");
                System.out.println("Dealer had a total of " + totaldealerHand + " and you had a total of " + totalplayerHand + ".");
            }
            else if (totalplayerHand > 21) {
                System.out.println("");
                System.out.println("It was a tie. Both the dealer and the player busted.");
                System.out.println("Dealer had a total of " + totaldealerHand + " and you had a total of " + totalplayerHand + ".");

            }
        }
    }

    public static void playerGame(Deck playerHand, Deck deck, int counter1, Deck dealerHand, int split, int totaldealerHand) {
        Scanner answer = new Scanner(System.in);
        int totalplayerHand = 0;
        int totalsplitHand = 0;
        int tracker1 = 0;
        for (int i = 0; i < playerHand.size(); i++) {
            totalplayerHand += faceCard(playerHand.getCard(i));
            if (faceCard(playerHand.getCard(i)) == 1 && (totalplayerHand + 10 < 22)) {
                totalplayerHand += 10;
                tracker1++;
            }
            for (int j = 0; j < playerHand.size(); j++)  {
                if (faceCard(playerHand.getCard(j)) == 1 && totalplayerHand > 21 && tracker1 > 0) {
                    totalplayerHand -= 10;
                    tracker1--;
                }
            }
        }
        if (split == 1) {
            totalsplitHand = totalplayerHand;
        }
        if (totalplayerHand == 21 && counter1 == 0) {
            System.out.println("");
            System.out.print("You have BlackJack. Player: ");
            print(counter1, playerHand);
            System.out.println("");
            if (split == 0) {
                dealerGame(deck, dealerHand, counter1, totalplayerHand);
            }
        }
        else if (totalplayerHand == 21 && counter1 > 0) {
            print(counter1, playerHand);
            System.out.println("");
            System.out.println("You got 21.");
            if (split == 0) {
                System.out.println("Now for the dealer's turn.");
                dealerGame(deck, dealerHand, counter1, totalplayerHand);
            }
        }
        else if (totalplayerHand > 21) {
            print(counter1, playerHand);
            System.out.println("");
            System.out.println("You got " + totalplayerHand + " and busted.");
            if (split == 0) {
                dealerGame(deck, dealerHand, counter1, totalplayerHand);
            }
        }
        else {
            if (counter1 > 0) {
                System.out.println("");
                System.out.print("Player: ");
                print(counter1, playerHand);
                System.out.println("Total: " + totalplayerHand);
            }
            if (playerHand.getCard(0) == playerHand.getCard(1)) {
                System.out.println("");
                System.out.println("Would you like to hit, stay, double down, or split?");
                System.out.print("Choice: ");
            } 
            else if (playerHand.size() > 2) {
                System.out.println("");
                System.out.println("Would you like to hit or stay?");
                System.out.print("Choice: ");
            }
            else {
                System.out.println("");
                System.out.println("Would you like to hit, stay, or double down?");
                System.out.print("Choice: ");
            }            
            String choice = answer.nextLine();
            while (!(choice.equalsIgnoreCase ("hit") || (choice.equalsIgnoreCase ("stay")) || (choice.equalsIgnoreCase ("double down")) || (choice.equalsIgnoreCase ("split"))) || (choice.equalsIgnoreCase ("split") && playerHand.getCard(0) != playerHand.getCard(1))) {
                System.out.println("Invalid Answer.");
                System.out.print("Choice: ");
                choice = answer.nextLine();
            }
            if (choice.equalsIgnoreCase ("hit")) {
                playerHand.addCard(deck.getCard(0));
                System.out.println("You drew a " + deck.getCard(0) + ".");
                counter1++;
                deck.subtractCard(); 
                playerGame(playerHand, deck, counter1, dealerHand, split, totaldealerHand);
            }
            else if (choice.equalsIgnoreCase ("stay")) {
                if (split == 0) {
                    dealerGame(deck, dealerHand, counter1, totalplayerHand);
                }
            }
            else if (choice.equalsIgnoreCase ("double down")) {
                playerHand.addCard(deck.getCard(0));
                System.out.println("You drew a " + deck.getCard(0) + ".");
                counter1++;
                deck.subtractCard();    
                totalplayerHand = 0;
                for (int i = 0; i < playerHand.size(); i++) {
                    totalplayerHand += faceCard(playerHand.getCard(i));
                    if (faceCard(playerHand.getCard(i)) == 1 && (totalplayerHand + 10 < 22)) {
                        totalplayerHand += 10;
                        tracker1++;
                    }
                    for (int j = 0; j < playerHand.size(); j++)  {
                        if (faceCard(playerHand.getCard(j)) == 1 && totalplayerHand > 21 && tracker1 > 0) {
                        totalplayerHand -= 10;
                        tracker1--;
                        }
                    }
                }
                if (split == 0) {
                    dealerGame(deck, dealerHand, counter1, totalplayerHand);
                }
            }
            if (playerHand.getCard(0) == playerHand.getCard(1) && choice.equalsIgnoreCase ("split") && playerHand.size() > 1) {
                Deck splitHand = new Deck();
                splitHand.addCard(playerHand.getCard(0));
                playerHand.subtractCard();
                splitHand.addCard(deck.getCard(0));
                deck.subtractCard();
                playerHand.addCard(deck.getCard(0));
                deck.subtractCard();
                playerGame(playerHand, deck, counter1, dealerHand, split, totaldealerHand);
                split = 1;
                playerGame(splitHand, deck, counter1, dealerHand, split, totaldealerHand);
            }
        } 
    }

    public static int faceCard(Card a) {
        if (a.getValue() > 10 & a.getValue() < 14) {
            return 10;
        }
        else if (a.getValue() == 14){
            return 1;
        }
        else {
            return a.getValue();
        }
    }

    public static void print(int counter1, Deck playerHand) {
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.print(playerHand.getCard(i) + " ");
        }  
    }
}
