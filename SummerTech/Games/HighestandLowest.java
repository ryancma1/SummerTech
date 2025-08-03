package Games;
import java.util.Random;
public class HighestandLowest {
    public static void print (int [] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static void main (String [] args){
        Random listNumbers = new Random();
        int length = 8;
        int currentNumber = 0;
        int highestNumber = 0;
        int lowestNumber = 20;
        int checker = 0;
        int [] list = new int [length];
        for (int i = 0; i < length; i++){
            int numberGen = listNumbers.nextInt(20);
            list[i] = numberGen;
        }
        for (int i = 0; i < length; i++){
            currentNumber = list[i];
            if (currentNumber < lowestNumber){
                lowestNumber = currentNumber;
            }
        }
        for (int i = 0; i < length; i++){
            currentNumber = list[i];
            if (currentNumber > highestNumber){
                highestNumber = currentNumber;
            }
        }
        System.out.println("Here is your list: ");
        print(list, length);
        System.out.println("The highest number in this list is " + highestNumber);
        System.out.println("The lowest number in this list is " + lowestNumber);

    }
}
