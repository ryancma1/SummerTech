import java.util.Scanner;

public class sortedbinarySearch {
    public static void print(int [] list, int listLength){
        for (int i = 0; i < listLength; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static int check(int [] list, int choice, int a, int b, int listLength){
        int index = 0;
        int splitindex = (b + a)/2;
        if (choice > list[listLength - 2]){
            index = listLength - 1;
        }
        else if (choice > list[splitindex]){
            a = splitindex;
            index = check(list, choice, a, b, listLength);
        }
        else if (choice < list[splitindex]){
            b = splitindex;
            index = check(list, choice, a, b, listLength);
        }
        else if (choice == list[splitindex]){
            index = splitindex;
        }
        return index;
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
        Scanner answer = new Scanner(System.in);
        System.out.println("Welcome to the Binary Searcher!");
        System.out.println("How long would you like to create your list?");
        int listLength = answer.nextInt();
        int a = 0;
        int b = listLength - 1;
        int index = 0;
        int [] list = new int[listLength];
        System.out.println("Please enter " + listLength + " numbers.");
        System.out.println("Add spaces between every number to create the list.");
        for (int i = 0; i < listLength; i++){
            list[i] = answer.nextInt();
        }
        System.out.println("Here is your list: ");
        print(list, listLength);
        list = sort(list);
        System.out.println("Sorted List: ");
        print(list, listLength);
        System.out.println("What number in your list would you like to find the index of?");
        int choice = answer.nextInt();
        index = check(list, choice, a, b, listLength);
        System.out.println("The index of " + choice + " is " + index + ".");
        for (int i = index; i < list.length - 1; i++){
            if (list[i - 1] == list[i] && choice == list[i - 1]){
                System.out.println("The index of " + choice + " is " + (i - 1) + ".");
            }if (list[i + 1] == list[i] && choice == list[i + 1]){
                System.out.println("The index of " + choice + " is " + (i + 1) + ".");
            }
        }
    }
}
