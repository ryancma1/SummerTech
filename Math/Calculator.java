package Math;
import java.util.Scanner;
public class Calculator {
    public static void main (String args[]){
        Scanner Answer = new Scanner(System.in);
        System.out.println("Welcome to the Calculator!");
        String using = "YES";
        while (using.equals("YES")){    
            System.out.println("Please choose a function.");
            System.out.println("1) Add");
            System.out.println("2) Subtract");
            System.out.println("3) Multiply");
            System.out.println("4) Divide");
            int function = Answer.nextInt();
            while (function != 1 && function != 2 && function != 3 && function != 4){
                System.out.println("Please input an accurate answer choice.");
                function = Answer.nextInt();
            }
            System.out.println("Please enter two numbers.");
            double number1 = Answer.nextDouble();
            double number2 = Answer.nextDouble();
            double total = 0;
            if (function == 1){
                total = number1 + number2;
                System.out.println(number1 +  " + " + number2 + " = " + total);
            }
            else if (function == 2){
                total = number1 - number2;
                System.out.println(number1 +  " - " + number2 + " = " + total);
            }
            else if (function == 3){
                total = number1 * number2;
                System.out.println(number1 +  " * " + number2 + " = " + total);
            }
            else if (function == 4){
                total = number1 / number2;
                System.out.println(number1 +  " / " + number2 + " = " + total);
            }
            System.out.println("Would you like to continue to use the Calculator?");
            using = Answer.next();
            using = using.toUpperCase();
        }
    }   
}

