import java.util.Scanner;
public class binarySearch {
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int [] numbers = new int[]{2,5,8,11,23,57,79, 84235};
        System.out.println("What number in this list would you like to find the index of?");
        System.out.println("List: 2, 5, 8, 11, 23, 57, 79, 84235");
        int choice = answer.nextInt();
        int index = 0;
        for (int i = 0; i <= 7; i++){
            if (numbers[i] == choice){
                index = i;
            }
        }
        System.out.println("The index of " + choice + " is " + index + ".");
        

    }
}
