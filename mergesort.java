import java.util.Random;
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
    public static int[] split(int [] list){
        int [] list3 = new int[list.length - ];
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
            if (list1track < list1.length && list2track < list2.length){
                if(list1[list1track] > list2[list2track]){
                    list4[i] = list2[list2track];
                    list2track++;
                    System.out.println("List 1: ");
                    print(list1);
                    System.out.println("List 2: ");
                    print(list2);
                    System.out.println("List 4: ");
                    print(list4);
                }
                else if(list1[list1track] < list2[list2track]){
                    list4[i] = list1[list1track];
                    list1track++;
                    System.out.println("List 1: ");
                    print(list1);
                    System.out.println("List 2: ");
                    print(list2);
                    System.out.println("List 4: ");
                    print(list4);
                }
            }
            else if (list1track >= list1.length && list2track < list2.length){
                list4[i] = list2[list2track];
                list2track++;
                System.out.println("List 1: ");
                print(list1);
                System.out.println("List 2: ");
                print(list2);
                System.out.println("List 4: ");
                print(list4);
            }
            else if (list1track < list1.length && list2track >= list2.length){
                list4[i] = list1[list1track];
                list1track++;
                System.out.println("List 1: ");
                print(list1);
                System.out.println("List 2: ");
                print(list2);
                System.out.println("List 4: ");
                print(list4);
            }
        }
        return list4;
    }
    public static void main(String[] args) {
        int range = 10;
        int [] list = new int[8];
        Random number = new Random();
        for (int i = 0; i < list.length; i++){
            int numberGen = number.nextInt(range);
            list[i] = numberGen;
        }
        System.out.println("Unsorted List: ");
        print(list);
        list = sort(list);
        System.out.println("Sorted List: ");
        print(list);
    }
}
