import java.util.Scanner;
public class checklist {
    public static boolean check(int [] list){
        boolean sorted = true;
        for (int i = 0; i < list.length - 1; i++){
            if (list[i] > list[i+1]){
                sorted = false;
            }
        }
        return sorted;
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int [] list = new int[10];
        System.out.println("Please input a list of 10 numbers");
        for (int i = 0; i < list.length; i++){
            list [i] = answer.nextInt();
        }
        System.out.println("List: ");
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
        if (check(list)){
            System.out.println("The list is sorted");
        }
        else {
            System.out.println("The list is not sorted");
        }

    }
}
