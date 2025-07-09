import java.util.Random;
public class functions {
    public static void print(int [] list){
        for (int i = 0; i < 10; i++){
                System.out.print(list[i] + ", ");
        }      
    }
    public static void main(String[] args) {
        Random number = new Random ();
        int [] list = new int[10];
        int numberGen = 0;
        for (int i = 0; i < 10; i++){
            numberGen = number.nextInt(20);
            list[i] = numberGen;
        }
        System.out.println("Here is your list: ");
        print(list);
        for (int i = 0; i < 10; i++){
            numberGen = number.nextInt(20);
            list[i] = numberGen;
        }
        System.out.println("");
        print(list);
    }
}
