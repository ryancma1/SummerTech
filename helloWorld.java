import java.util.Scanner;
public class helloWorld {
    public static void main (String[]args){
        Scanner Martin = new Scanner(System.in);
        System.out.print("How much money do you have?");
        double money = Martin.nextDouble();
        System.out.print("Hello you have $" + money + ".");

    }
}