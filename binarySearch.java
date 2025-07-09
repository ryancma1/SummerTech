import java.util.Scanner;
public class binarySearch {
    public static void sigma(int [] numbers){
        int index = 0;
        for (int i = 0; i <= 14; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("");
    }
    public static int check(int [] numbers, int choice, int a, int b){
        int splitindex = (b + a)/2;
        if (choice > numbers[splitindex]){
            a = splitindex;
            check(numbers, choice, a, b);
        }
        else if (choice < numbers[splitindex]){
            b = splitindex;
            check(numbers, choice, a, b);
        }
        int index = splitindex;
        return index;
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int a = 0;
        int b = 14;
        int [] numbers = new int[]{1, 2, 4, 5, 12, 26, 38, 68, 174, 245, 309, 351, 440, 678, 999};
        System.out.println("What number in this list would you like to find the index of?");
        sigma(numbers);
        int choice = answer.nextInt();
        int index = 0;
        int splitindex = 0;
        index = check(numbers, choice, a, b);
        System.out.println("The index of " + choice + " is " + index + ".");
        

    }
}
