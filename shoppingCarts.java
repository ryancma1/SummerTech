import java.util.Scanner;
public class shoppingCarts {
    public static void main(String[] args) {
        Scanner Answer = new Scanner(System.in);
        System.out.println("Welcome to the supermarket!");
        System.out.println("How long would you like to make your shopping list?");
        int listLength = Answer.nextInt();
        String[] shoppingList = new String[listLength];
        System.out.println("What would you like to add in your shopping list?");
        for (int i = 0; i < listLength; i++){
            shoppingList[i] = Answer.next();
        }
        for (int j = 0; j < listLength; j++){
            System.out.print(shoppingList[j] + ", ");
        }
    }
}
