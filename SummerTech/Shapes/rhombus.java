public class rhombus {
    public static void main(String[] args) {
        for (int i = 5; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int k = 6; k > i; k--){
                System.out.print("*");
            }
            for (int j = 5;j > i ; j--){
                    System.out.print("*");
             }
            System.out.println("");
        }
        for (int i = 6; i > 0; i--){
            for (int j = 6; j > i; j--){
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++){
                System.out.print("*");
            }
            for (int j = 1;j < i ; j++){
                    System.out.print("*");
             }
            System.out.println("");
        }

    }
}

