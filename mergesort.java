import java.util.Random;
import java.util.*;
public class mergesort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static int[] sort(int [] list, int start, int end){
        int [] list1 = split(list, start, (end/2)-1);
        int [] list2 = split(list, end/2, end);
        if (list1.length > 1){
            sort(list, start, end);
        }
        if (list2.length > 1){
            sort(list, start, end);
        }
        return list;
    }
    public static int[] split(int [] list, int start, int end){
        int [] list3 = new int[end-start];
        for (int i = start; i < end; i++){    
            list3 [i-start] = list[i];
        }
        return list3;
    }    
    public static int[] merge(int [] list1, int []list2){
        int [] list4 = new int [list1.length + list2.length];
        int list1track = 0;
        int list2track = 0;
        for (int i = 0; i < list4.length; i++){
            if (list2track < 4 && list1[list1track] > list2[list2track]){
                    list4 [i] = list2[list2track];
                    list2track += 1;
                    System.out.println("list2");
                }
            else if (listlist1[list1track] < list2[list2track]){
                list4 [i] = list1[list1track];
                list1track += 1;
                System.out.println("list1");
            }
            System.out.println("forloop");
        }    
        return list4;
    }
    public static void main(String[] args) {
        int range = 8;
        int counter = 0;
        int holder = 0;
        int [] list = new int[8];
        int [] list1 = new int[]{8,7,2,5};
        int [] list2 = new int[]{4,3,6,1};
        Random number = new Random();
        /*for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(range);
            list[i] = numberGen;
        }
        for (int i = 0; i < list1.length; i++){
            int numberGen = number.nextInt(range);
            list1[i] = numberGen;
        }
        for (int i = 0; i < list2.length; i++){
            int numberGen = number.nextInt(range);
            list2[i] = numberGen;
        }*/
        Arrays.sort(list1);
        Arrays.sort(list2);
        list = merge(list1, list2);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
            /*System.out.println("Start List: ");
            print(list);
            System.out.println("End List: ");
            print(list);
            System.out.println("The list changed " + counter + " times.");*/
    }
}
