import java.util.Random;
import java.util.*;
public class mergesort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static int[] sort(int [] list){
        int [] list1 = split(list, 0, (list.length/2)-1);
        int [] list2 = split(list, list.length/2, list.length - 1);
        if (list1.length > 1){
            list1 = sort(list1);
        }
        if (list2.length > 1){
            list2 = sort(list2);
        }
        return merge(list1, list2);
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
            System.out.println("i " + i);
            System.out.println("1: " + list1track);
            System.out.println("2: " + list2track);
            if (list1track < list1.length && list2track < list2.length && list1[list1track] >= list2[list2track]){
                list4 [i] = list2[list2track];
                list2track += 1;
                for (int j = 0; j < list4.length; j++){
                    System.out.print(list4[j] + ", ");
                }
                System.out.println("");
                System.out.println("list2");  
            }
            else if (list1track < list1.length && list2track < list2.length && list1[list1track] <= list2[list2track]){
                list4 [i] = list1[list1track];
                list1track += 1;
                for (int j = 0; j < list4.length; j++){
                    System.out.print(list4[j] + ", ");
                }
                System.out.println("");
                System.out.println("list1");
            }
            else if (list2track >= list2.length && list1track < list1.length){
                list4 [i] = list1[list1track];
                list1track += 1;
                for (int j = 0; j < list4.length; j++){
                    System.out.print(list4[j] + ", ");
                }
                System.out.println("");
                System.out.println("list1");
            }
            else if (list1track >= list1.length && list2track < list2.length){
                list4 [i] = list2[list2track];
                list2track += 1;
                for (int j = 0; j < list4.length; j++){
                    System.out.print(list4[j] + ", ");
                }
                System.out.println("");
                System.out.println("list2");
            }
            System.out.println("forloop");
        }    
        return list4;
    }
    public static void main(String[] args) {
        int range = 20;
        int counter = 0;
        int holder = 0;
        int [] list = new int[10];
        int [] list1 = new int[list.length/2];
        int [] list2 = new int[list.length/2];
        Random number = new Random();
        for (int i = 0; i < list.length; i++){
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
        }
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
