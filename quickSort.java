import java.util.Random;
public class quickSort {
    public static double listMean (int [] list){
        int addition = 0;
        double mean = 0;
        for (int i = 0; i < list.length; i++){
            addition = list[i] + addition;
        }
        mean = ((double) addition)/((double) list.length);
        return mean;
    }
    public static int[] sort(int [] list){
        int [] list1 = new int [list.length/2];
        int [] list2 = new int [list.length-list1.length];
        int mean = (int)(listMean(list));
        for (int i = 0; i < list.length; i++){
            if (list[i] < mean){
                list1 = sort(list);
            }
            if (list[i] >= mean){
                list2 = sort(list);
            }
        }
        for (int i = 0; i < list.length/2; i++){    
            list1 [i] = list[i];
        }
        for (int i = list.length/2; i < list.length; i++){    
            list2 [i - list.length/2] = list[i];
        }
        if (list1.length > 1){
            list1 = sort(list1);
        }
        if (list2.length > 1){
            list2 = sort(list2);
        }
        return merge(list1, list2);
    }
    public static int [] merge(int [] list1, int [] list2){
        int [] list3 = new int[list1.length + list2.length];
        for (int i = 0; i < list3.length; i++){
            for (int j = 0; j < list1.length; i++){
                list3 [i] = list1 [j];
            }
            for (int j = list1.length; j < list2.length; i++){
                list3 [i] = list2 [j];
            }
        }
        return list3;

    }
    public static void main (String[] args){
        Random number = new Random();
        int [] list = new int[8];
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(list.length);
            list[i] = numberGen;
        }
    
    }
}
