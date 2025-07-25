import java.util.Random;
public class MergeSort {
    public static void print(int [] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static int[] sort(int [] list){
        int [] list1 = new int [list.length/2];
        int [] list2 = new int [list.length-list1.length];
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
    public static int[] merge(int [] list1, int []list2){
        int [] list4 = new int [list1.length + list2.length];
        int list1track = 0;
        int list2track = 0;
        for (int i = 0; i < list4.length; i++){
            if (list1track < list1.length && list2track < list2.length){
                if(list1[list1track] >= list2[list2track]){
                    list4[i] = list2[list2track];
                    list2track++;
                }
                else if(list1[list1track] < list2[list2track]){
                    list4[i] = list1[list1track];
                    list1track++;
                }
            }
            else if (list1track >= list1.length && list2track < list2.length){
                list4[i] = list2[list2track];
                list2track++;
            }
            else if (list1track < list1.length && list2track >= list2.length){
                list4[i] = list1[list1track];
                list1track++;
            }
        }
        return list4;
    }
    public static void main(String[] args) {
        long initialtime = System.currentTimeMillis();
        int range = 100000000;
        int [] list = new int[100000000];
        Random number = new Random();
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(range);
            list[i] = numberGen;
        }
        /*System.out.println("Unsorted List: ");
        print(list);*/
        list = sort(list);
        long endtime = System.currentTimeMillis();
        long time = endtime - initialtime;
        /*System.out.println("Sorted List: ");
        print(list);*/
        System.out.println("Time: " + time);
        
    }
}
