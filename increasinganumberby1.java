import java.util.Scanner;
public class increasinganumberby1 {
    public static int add(int number){
        number += 1;
        return number;
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        System.out.println("What number would you like to increase by 1.");
        int choice = answer.nextInt();
        System.out.println("You chose the number " + choice + ".");
        choice = add(choice);
        System.out.println("Your number is now " + choice + ".");
    }
}