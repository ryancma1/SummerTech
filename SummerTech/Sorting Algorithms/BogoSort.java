import java.util.Random;
public class BogoSort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static boolean check(int [] list){
        boolean sorted = true;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list[i+1]){
                sorted = false;
            }
        }
        return sorted;
    }
    public static int [] shuffle(int[] list){
        Random number = new Random();
        int holder = 0;
        int random1 = number.nextInt(list.length);
        int random2 = number.nextInt(list.length);
        if (random1 != random2){   
            holder = list[random1];
            list[random1] = list[random2];
            list[random2] = holder;
        }
        else{
            shuffle(list);
        }
        return list;
    }
    public static void main(String[] args) {
        long initialtime = System.currentTimeMillis();
        Random number = new Random();
        int counter = 0;
        boolean sorted = false;
        int [] list = new int[100];
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(list.length);
            list[i] = numberGen;
        }
        System.out.println("Original List: ");
        print(list);
        while(sorted == false){
            for (int i = 0; i < list.length; i++){
                list = shuffle(list);
            }
            sorted = check(list);
            counter++;
        }
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        System.out.println("Sorted List: ");
        print(list);
        System.out.println("The list is sorted.");
        System.out.println("It shuffled it " + counter + " times.");
        System.out.println("Time: " + time);
    }
}
