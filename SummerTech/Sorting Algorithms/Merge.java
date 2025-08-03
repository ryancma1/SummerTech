import java.util.Scanner;
public class Merge {
    public static void print(int [] list1, int [] list2){
        System.out.println("List 1:");
        for (int i = 0; i < list1.length; i++){
            System.out.print(list1[i] + ", ");
        }
        System.out.println("");
        System.out.println("List 2:");
        for (int i = 0; i < list2.length; i++){
            System.out.print(list2[i] + ", ");
        }
        System.out.println("");
    }
    public static int [] merge(int [] list1, int [] list2){
        int [] list = new int[list1.length + list2.length];
        int list1track = 0;
        int list2track = 0;
        for (int i = 0; i < list.length; i++){
            if (list1track < list1.length && list2track < list2.length){
                if(list1[list1track] > list2[list2track]){
                    list[i] = list2[list2track];
                    list2track++;
                }
                else if(list1[list1track] < list2[list2track]){
                    list[i] = list1[list1track];
                    list1track++;
                }
            }
            else if (list1track >= list1.length && list2track < list2.length){
                list[i] = list2[list2track];
                list2track++;
            }
            else if (list1track < list1.length && list2track >= list2.length){
                list[i] = list1[list1track];
                list1track++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int [] list1 = new int[5];
        int [] list2 = new int[5];
        Scanner answer = new Scanner(System.in);
        System.out.println("Please input a list of 5 numbers.");
        for (int i = 0; i < list1.length; i++){
            list1 [i] = answer.nextInt();
        }
        System.out.println("Please input another list of 5 numbers.");
        for (int i = 0; i < list2.length; i++){
            list2 [i] = answer.nextInt();
        }
        print(list1, list2);
        int [] list = merge(list1, list2);
        System.out.println("Final List: ");
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
    }
}
