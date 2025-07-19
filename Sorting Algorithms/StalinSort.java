import java.util.Random;
public class StalinSort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }

    public static int [] sort(int [] list){
        int counter = 1;
        int counter1 = 0;
        int track = list[0];
        for (int i = 1; i < list.length; i++){
            if (list[i] < track){
                list[i] = -1;
            }
            if (list[i] >= track){
                track = list[i];
                counter++;
            }
        }
        int [] list1 = new int[counter];
        for (int i = 0; i < list.length; i++){
            if (list[i] != -1){
                list1[counter1] = list[i];
                counter1++;
            }
        }
        return list1;
    }
    public static void main(String[] args) {
        long initialtime = System.currentTimeMillis();
        Random number = new Random();
        int [] list = new int[100000000];
        int range = 100000000;
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(range);
            list[i] = numberGen;
        }
        //System.out.println("Original List: ");
        //print(list);
        list = sort(list);
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        //System.out.println("Sorted List: ");
        //print(list);
        System.out.println("Time: " + time);
    }
}
