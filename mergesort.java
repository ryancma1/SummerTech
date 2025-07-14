import java.util.Random;
public class mergesort {
    public static void print(int [] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
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
        for (int i = 0; i < length; i += 2){
            if (list[i] > list[i + 1]){
                holder = list[i + 1];
                list[i + 1] = list[i];
                list[i] = holder;
                System.out.println("Changing list: ");
                print(list, length);
                counter += 1;
            }
        }
        for (int i = 0; i < 3; i += 1){
            if (list[i] > list[i + 1]){
                holder = list[i + 1];
                list[i + 1] = list[i];
                list[i] = holder;
                System.out.println("Changing list: ");
                print(list, length);
                counter += 1;
            }
        }
        for (int i = 4; i < 7; i += 1){
            if (list[i] > list[i + 1]){
                holder = list[i + 1];
                list[i + 1] = list[i];
                list[i] = holder;
                System.out.println("Changing list: ");
                print(list, length);
                counter += 1;
            }
        }
        System.out.println("End List: ");
        print(list, length);
        System.out.println("The list changed " + counter + " times.");
    }
}
