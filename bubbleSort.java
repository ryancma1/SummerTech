import java.util.Random;
public class bubbleSort {
    public static void print(int [] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static void main (String [] args){
        long initialtime = System.currentTimeMillis();
        Random number = new Random();
        int holder = 0;
        int length = 100;
        int checker = 0;
        int changeAmount = 0;
        int counter = 0;
        int [] list = new int[length];
        for (int i = 0; i < length; i++){
            int numberGen = number.nextInt(100);
            list[i] = numberGen;
        }
        System.out.println("Start List: ");
        print(list, length);
        while (counter < length){
            for (int i = 0; i < length - 1; i++){
                if (list[checker] > list[checker + 1]){
                    holder = list [checker];
                    list[checker] = list[checker + 1];
                    list[checker + 1] = holder;
                    System.out.println("Changing List: ");
                    print(list, length);
                    changeAmount += 1;
                }
                checker += 1;
            }
            checker = 0;
            counter += 1;
        }
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        System.out.println("End List: ");
        print(list, length);
        System.out.println("Time: " + time);
        System.out.println("The list changed " + changeAmount + " times.");
    }
}
