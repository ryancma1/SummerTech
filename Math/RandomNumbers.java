package Math;
import java.util.Scanner;
import java.util.Random;
public class RandomNumbers {
    public static void main(String[] args) {
        Scanner Answer = new Scanner(System.in);
        Random  Number = new Random();
        int numberGen = Number.nextInt(3);
        String computerPick = "";
        if (numberGen == 1){
            computerPick = "Rock";
        }
        if (numberGen == 2){
            computerPick = "Paper";
        }
        if (numberGen == 3){
            computerPick = "Scissors";
        }
        System.out.println("What would you like to play?");
        System.out.println("1) Rock");
        System.out.println("2) Paper");
        System.out.println("3) Scissors");
        int playerAnswer = Answer.nextInt();
        if (playerAnswer == 1){
            String playerPick = "Rock";
            if (numberGen == 1){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("It was a Tie.");
            }
            if (numberGen == 2){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Lost.");
            }
            if (numberGen == 3){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Won!");
            }
        }
        if (playerAnswer == 2){
            String playerPick = "Paper";
            if (numberGen == 1){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Won!");
            }
            if (numberGen == 2){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("It was a Tie.");
            }
            if (numberGen == 3){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Lost!");
            }
        }
        if (playerAnswer == 3){
            String playerPick = "Scissors";
            if (numberGen == 1){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Lost!");
            }
            if (numberGen == 2){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("You Won!");
            }
            if (numberGen == 3){
                System.out.println("You picked " + playerPick + ".");
                System.out.println("The computer picked " + computerPick + ".");
                System.out.println("It was a Tie.");
            }
        }
    }
}
