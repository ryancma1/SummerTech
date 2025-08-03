package Misc;
import java.util.Scanner;
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner Answer = new Scanner(System.in);
        System.out.println("Welcome to the supermarket!");
        System.out.println("How long would you like to make your shopping list?");
        int listLength = Answer.nextInt();
        String[] shoppingList = new String[listLength];
        System.out.println("What would you like to add in your shopping list?");
        for (int i = 0; i < listLength; i++){
            shoppingList[i] = Answer.next();
            shoppingList[i] = shoppingList[i].toUpperCase();
        }
        System.out.println("Here is your list: ");
        for (int j = 0; j < listLength; j++){
            System.out.print(shoppingList[j] + ", ");
        }
        System.out.println("");
        String change = "YES";
        while (change.equals ("YES")){
            System.out.println("");
            System.out.println("Would you like to change any items on your shopping list?");
            change = Answer.next();
            change = change.toUpperCase();
            if (change.equals("YES")){
                System.out.println("Which item on your list would you like to change?");
                String itemChange = Answer.next();
                itemChange = itemChange.toUpperCase();
                for (int k = 0; k < listLength; k++){
                    if (shoppingList[k].equals (itemChange)){
                        System.out.println("What would you like to change this item to?");
                        String itemNew = Answer.next();
                        itemNew = itemNew.toUpperCase();
                        shoppingList[k] = itemNew;
                        System.out.println("Here is your new list:");
                        for (int j = 0; j < listLength; j++){
                            System.out.print(shoppingList[j] + ", ");
                        }

                    }
                }
            }
        }
    }
}
