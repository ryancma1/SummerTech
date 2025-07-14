import java.util.Random;
public class selectionSort {
    public static void print(int [] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Random number = new Random();
        int length = 10;
        int listRange = 10;
        int lowestNumber = listRange;
        int currentNumber = 0;
        int checker = 0;
        int holder = 0;
        int index = 0;
        int counter = 0;
        int [] list = new int[length];
        for (int i = 0; i < length; i++){
            int numberGen = number.nextInt(listRange);
            list[i] = numberGen;
        }
        System.out.println("Start List: ");
        print(list, length);
        for (int i = 0; i < length; i++){
            currentNumber = list[i];
            if (currentNumber < lowestNumber){
                lowestNumber = currentNumber;
            }
        }
        while (checker < length){
            lowestNumber = listRange;
            for (int i = checker; i < length; i++){
                currentNumber = list[i];
                if (currentNumber < lowestNumber){
                    lowestNumber = currentNumber;
                    for (int j = i; j < length ; j++){    
                        if (lowestNumber == list[j]){
                            index = j;
                        }
                    }
                    holder = lowestNumber;
                    list[index] = holder;
                    list[i] = lowestNumber;
                }
                System.out.println("Changing List: ");
                print(list, length);
            }
            checker += 1;
            counter += 1;
        }
        System.out.println("End List: ");
        print(list, length);
        System.out.println("The list changed " + counter + " times.");



    }
}
