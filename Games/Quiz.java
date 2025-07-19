package Games;
import java.util.Scanner;
public class Quiz {
    public static void main (String args[]){
        Scanner Ryan = new Scanner(System.in);
        System.out.println("How do you craft a diamond pickaxe?");
        System.out.println("1) One stick and two diamonds");
        System.out.println("2) Two sticks and two diamonds");
        System.out.println("3) One stick and three diamonds");
        System.out.println("4) Two sticks and three diamonds");
        int Answer = Ryan.nextInt();
        if (Answer == 4){
            System.out.println("You got it correct!");

        }
        else if (Answer == 1 || Answer == 2 || Answer == 3){
            System.out.println("You got it incorrect.");
        }
        else{
            System.out.println("You are a failure. Please choose an accurate answer choice.");
        }
        System.out.println("Which animal is not in Minecraft?");
        System.out.println("a) A pig");
        System.out.println("b) A cow");
        System.out.println("c) An ant");
        System.out.println("d) A sheep");
        String Answer2 = Ryan.next();
        if (Answer2.equals("c")){
            System.out.println("You got it correct!");
        }
        else if (Answer2.equals("a")||Answer2.equals("b")||Answer2.equals("d")){
            System.out.println("You got it incorrect.");
        }
        else{
            System.out.println("You are a failure. Please choose an accurate answer choice.");
        }
        
    }
}
