package Games;
import java.util.Scanner;
public class Sudoku{
    public static void printEmpty(String [][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                board [i][j] = " _ ";
            }
        }
        for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
        }
    }
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        String [][] board = new String[9][9];
        printEmpty(board);


    }
}