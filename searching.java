import java.util.Scanner;
import java.util.Random;
public class searching {
    public static void main(String[] args) {
        int[] list = new int[5];
        int index = 0;
        Scanner answer = new Scanner(System.in);
        Random number = new Random();
        for (int i = 0; i < 5; i++){
            int numberGen = number.nextInt(10);
            list[i] = numberGen;
        }
        System.out.println("Here is your list:");
        for (int j = 0; j < 5; j++){
            System.out.print(list[j] + ", ");
        }
        System.out.println("");
        System.out.println("What number in your list would you like to find the index of?");
        int choice = answer.nextInt();
        for (int j = 0; j < 5; j++){    
            if (choice == list[j]){
                index = j;
                System.out.println("The index of the number " + choice + " is " + index + ".");
            }
        }
    }   
}
