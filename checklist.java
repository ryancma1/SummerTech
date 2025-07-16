import java.util.Scanner;
public class checklist {
    public static void check(int [] list){
        for (int i = 0; i < list.length; i++){
            if (list[i] > list[i+1]){
                
            }
        }
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        int [] list = new int[10];
        System.out.println("Please input a list of 10 numbers");
        for (int i = 0; i < list.length; i++){
            list [i] = answer.nextInt();
        }

    }
}
