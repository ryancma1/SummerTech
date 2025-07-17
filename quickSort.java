import java.util.Random;
public class quickSort {
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
        int [] list1 = new int [list.length/2];
        int [] list2 = new int [list.length-list1.length];
        int mean = (int)(listMean(list));
        System.out.println("List1: ");
        print(list1);
        System.out.println("List1: ");
        print(list2);
        for (int i = 0; i < list1.length; i++){    
            if (list[i] < mean){
                list1 [i] = list[i];    
            }
            else{
                list2 [i] = list[i];    
            }

        }
        for (int i = list1.length; i < list.length; i++){    
            list2 [i - list.length/2] = list[i];
        }
        for (int i = 0; i < list1.length - 1; i++){
            if (list1[i] != list1[i + 1]){
                list1 = sort(list1);
            }
        }
        for (int i = 0; i < list1.length; i++){
            if (list1.length > 1){
                if (list1[i] < mean){
                    list1 = sort(list1);
                    break;
                }
            }
        }
        for (int i = 0; i < list2.length; i++){
            if (list2.length > 1){
                if (list2[i] >= mean){
                    if (list2[i] == mean){
                        break;
                    }
                    list2 = sort(list2);
                    break;
                }
            }
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
            for (int j = 0; j < list1.length; j++){
                list3 [i] = list1 [j];
            }
            for (int j = list1.length; j < list2.length; j++){
                list3 [i] = list2 [j];
            }
        }
        return list3;

    }

    public static void main (String[] args){
        long initialtime = System.currentTimeMillis();
        Random number = new Random();
        int [] list = new int[8];
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(list.length);
            list[i] = numberGen;
        }
        System.out.println("Unsorted List: ");
        print(list);
        list = sort(list);
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        System.out.println("Sorted List: ");
        print(list);
        System.out.println("Time: " + time);


    
    }
}
