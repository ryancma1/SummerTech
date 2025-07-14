import java.util.Random;
public class mergesort {
    public static void print(int [] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static int[] split(int [] list, int length){
        int start = 0;
        int end = length - 1;
        int [] list1 = new int[length];
        for (int i = start; i < (end/2) - 1; i++){
            list1 [i] = list[i];
        }
        for (int i = end/2; i < end; i++){
            list1 [i] = list[i];
        }
        
        
    }
    public static void main(String[] args) {
        int length = 8;
        int range = 8;
        int counter = 0;
        int holder = 0;
        int [] list = new int[length];
        Random number = new Random();
        for (int i = 0; i < length; i++){
            int numberGen = number.nextInt(range);
            list[i] = numberGen;
        }
        System.out.println("Start List: ");
        print(list, length);
        System.out.println("End List: ");
        print(list, length);
        System.out.println("The list changed " + counter + " times.");
    }
}
