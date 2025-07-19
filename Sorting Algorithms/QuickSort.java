import java.util.Random;
public class QuickSort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }

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
        int counter1 = 0;
        int counter2 = 0;
        double mean = listMean(list);
        for (int i = 0; i < list.length; i++){
            if (list[i] < mean){
                counter1 += 1;
            }
            if (list[i] >= mean){
                counter2 += 1;
            }
        }
        int [] list1 = new int [counter1];
        int [] list2 = new int [counter2];
        int list1track = 0;
        int list2track = 0;
        int i = 0;
        while (i < list.length){
            if (list[i] < mean){
                list1[list1track] = list[i];
                list1track++;
            }
            if (list[i] >= mean){
                list2[list2track] = list[i];
                list2track++;
            }
            i++;
        }
        if (list1.length > 0 && list2.length > 0 ){
            list1 = sort(list1);
            list2 = sort(list2);
            return merge(list1, list2);
        }
        return list;
    }

    public static int [] merge(int [] list1, int [] list2){
        int [] list3 = new int[list1.length + list2.length];
        for (int j = 0; j < list1.length; j++){
            list3 [j] = list1 [j];
        }
        for (int j = 0; j < list2.length; j++){
            list3 [list1.length + j] = list2 [j];
        }
        return list3;
    }

    public static void main (String[] args){
        long initialtime = System.currentTimeMillis();
        Random number = new Random();
        int [] list = new int[100000000];
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(list.length);
            list[i] = numberGen;
        }
        //System.out.println("Unsorted List: ");
        //print(list);
        list = sort(list);
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        //System.out.println("Sorted List: ");
        //print(list);
        System.out.println("Time: " + time);


    
    }
}
