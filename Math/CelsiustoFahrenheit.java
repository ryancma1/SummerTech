package Math;
import java.util.Scanner;
public class CelsiustoFahrenheit {
    public static double solve(double choice){
        choice = choice * ((double) 9/(double) 5) + 32;
        return choice;
    }
    public static void main (String [] args){
        Scanner answer = new Scanner(System.in);
        System.out.println("What degrees Celsius would you like to convert to Fahrenheit?");
        double choice = answer.nextDouble();
        double response = choice;
        choice = solve(choice);
        System.out.println(response + " Celsius in Fahrenheit is " + choice + " degrees.");

        
    }
}