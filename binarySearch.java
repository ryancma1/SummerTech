import java.util.Scanner;
public class binarySearch {
    public static void sigma(int [] numbers, int listLength){
        int index = 0;
        System.out.println("Here is your list: ");
        for (int i = 0; i < listLength; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("");
    }
    public static int check(int [] numbers, int choice, int a, int b, int listLength){
        int index = 0;
        int splitindex = (b + a)/2;
        if (choice > numbers[listLength - 2]){
            index = listLength - 1;
        }
        else if (choice > numbers[splitindex]){
            a = splitindex;
            index = check(numbers, choice, a, b, listLength);
        }
        else if (choice < numbers[splitindex]){
            b = splitindex;
            index = check(numbers, choice, a, b, listLength);
        }
        else if (choice == numbers[splitindex]){
            index = splitindex;
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        System.out.println("Welcome to the Binary Searcher!");
        System.out.println("How long would you like to create your list?");
        int listLength = answer.nextInt();
        int a = 0;
        int b = listLength - 1;
        int index = 0;
        int [] numbers = new int[listLength];
        System.out.println("Please enter " + listLength + " numbers from least to greatest.");
        System.out.println("Add spaces between every number to create the list.");
        for (int i = 0; i < listLength; i++){
            numbers[i] = answer.nextInt();
        }
        sigma(numbers, listLength);
        System.out.println("What number in your list would you like to find the index of?");
        int choice = answer.nextInt();
        index = check(numbers, choice, a, b, listLength);
        System.out.println("The index of " + choice + " is " + index + ".");
        

    }
}
