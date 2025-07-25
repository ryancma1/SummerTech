package Math;
import java.util.Random;
public class random {
    public static void main(String [] args) {
        Random number = new Random();
        int numberGen = 0;
        for (int i = 0; i < 9; i++) {
            numberGen = number.nextInt(9);
            System.out.println(numberGen);
        }
    }
}