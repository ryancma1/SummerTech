import java.util.Random;
import java.util.Scanner;
public class statistics {
    public static void print (int [] numbers, int length){
        for (int i = 0; i < length; i++){
            System.out.println(numbers[i] + ", ");
        }
        System.out.println("");
    }
    public static int numbersMean (int [] numbers, int length){
        int addition = 0;
        int mean = 0;
        for (int i = 0; i < length; i++){
            addition = number[i] + addition;
        }
        mean = addition/length;
        return mean;
    }
    public static int numbersMedian (int [] numbers, int length){
        int index = 0;
        double median = 0;
        int leftMedian = 0;
        int rightMedian = 0;
        if (length%2 == 1){
            index = (numbers.length - 1)/2;
            median = numbers[index];
        }
        else {
            rightMedian = (numbers.length)/2;
            leftMedian = (rightMedian - 1);
            median = (numbers[leftMedian] + numbers[rightMedian])/2;
        }
        return median;
    }
    public static int numbersMode (int [] numbers, int length){
        int currentNumber = 0;
        int highestAmount = 0;
        int chosenNumber = 0;
        for (int i = 0; i < length; i++){
            chosenNumber = numbers[i];
            currentNumber += 1;
            for (int j = 0; j < length; j++ ){
                if (chosenNumber )
            }
        }
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int length = 5;
        int [] numbers = new int[length];
        Random Number = new Random();
        for (int i = 0; i < length; i++){
            int numberGen = Number.nextInt(20);
            numbers[i] = numberGen;
        }
        System.out.println("Would you like to find the mean, median or mode of this list?");
        print(numbers, length);
        String choice = answer.next();
        choice = choice.toUpperCase();
        mean = numbersMean(numbers, length);
        median = numbersMedian(numbers, length);
        if (choice.equals ("MEAN")){
            System.out.println("The mean of this list is " + mean + ".");
        }
        else if (choice.equals ("MEDIAN")){
            System.out.println("The mean of this list is " + median + ".");
        }



    }
}