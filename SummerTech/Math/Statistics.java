package Math;
import java.util.Random;
import java.util.Scanner;
public class Statistics {
    public static void print (int [] numbers, int length){
        for (int i = 0; i < length; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("");
    }
    public static double numbersMean (int [] numbers, int length){
        int addition = 0;
        double mean = 0;
        for (int i = 0; i < length; i++){
            addition = numbers[i] + addition;
        }
        mean = ((double) addition)/((double) length);
        return mean;
    }
    public static double numbersMedian (int [] numbers, int length){
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
            median = (double) (numbers[leftMedian] + numbers[rightMedian])/(double) 2;
        }
        return median;
    }
    public static int numbersMode (int [] numbers, int length){
        int currentNumber = 0;
        int highestAmount = 0;
        int chosenNumber = 0;
        int checker = 0;
        int mode = 0;
        int modeNumber = 0;
        for (int i = 0; i < length; i++){
            chosenNumber = numbers[i];
            currentNumber += 1;
            checker += 1;
            for (int j = checker; j < length; j++ ){
                if (numbers[j] == chosenNumber){
                    currentNumber += 1;
                }
            }
            if (currentNumber > highestAmount){
                highestAmount = currentNumber;
                currentNumber = 0;
                mode = chosenNumber;
            }
            else {
                currentNumber = 0;
            }

        }

        return mode;
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        String continuing = "YES";
        int length = 5;
        double mean = 0;
        double median = 0;
        int mode = 0;
        int [] numbers = new int[length];
        Random Number = new Random();
        for (int i = 0; i < length; i++){
            int numberGen = Number.nextInt(10);
            numbers[i] = numberGen;
        }
        while (continuing.equals ("YES")){
            System.out.println("Would you like to find the mean, median or mode of this list?");
            print(numbers, length);
            String choice = answer.next();
            choice = choice.toUpperCase();
            mean = numbersMean(numbers, length);
            median = numbersMedian(numbers, length);
            mode = numbersMode(numbers, length);
            if (choice.equals ("MEAN")){
                System.out.println("The mean of this list is " + mean + ".");
            }
            else if (choice.equals ("MEDIAN")){
                System.out.println("The median of this list is " + median + ".");
            }
            else if (choice.equals ("MODE")){
                System.out.println("The mode of this list is " + mode + ".");
            }
            else {
                System.out.println("Please input one of the given options.");
            }
            System.out.println("Would you like to continue?");
            continuing = answer.next();
            continuing = continuing.toUpperCase();
            while ((!(continuing.equals ("YES"))) && (!(continuing.equals ("NO")))){
                System.out.println("Please enter yes or no.");
                continuing = answer.next();
                continuing = continuing.toUpperCase();
            }
            if (continuing.equals ("NO")){
                break;
            } 
        }
    }
}