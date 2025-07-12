import java.util.Scanner;
public class connect4 {
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        String [][] board = new String[6][7];
         System.out.println("Welcome to Connect 4!");
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                board [i][j] = " _ ";
            }
        }
        System.out.println(" 0  1  2  3  4  5  6");
        for (int i = 0; i < 6; i++){
                for (int j = 0; j < 7; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
        }
        String turn = " X ";
        int playerturn = 1;
        int turncount = 0;
        int column = 0;
        int row = 0;
        while (turncount < 42){
            if (turn.equals (" X ")){
                playerturn = 1;
            }
            else if (turn.equals (" O ")){
                playerturn = 2;
            }
            System.out.println("Player "+  playerturn + ". Which column would you like to drop an" + turn + "in?");
            column = answer.nextInt();
            if (column > 6 || column < 0){
                System.out.println("Please enter an accurate response.");
                continue;
            }
            if (board [0][column].equals (" X ") || board [0][column].equals (" O ")){
                System.out.println("Please enter a column that is isn't full.");
                continue;
            }
            row = 5;
            for (row = 5; row >= 0; row -- ){
                if (board [row][column].equals (" _ ")){
                    break;
                }
            }
            board [row][column] = turn;
            turncount += 1;
            System.out.println(" 0  1  2  3  4  5  6");
            for (int i = 0; i < 6; i++){
                for (int j = 0; j < 7; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
            }
            if (column < 4){
                if (board [row][column].equals (turn) && board [row][column + 1].equals (turn) && board [row][column + 2].equals (turn) && board [row][column + 3].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 5 && column > 0){
                if (board [row][column - 1].equals (turn) && board [row][column].equals (turn) && board [row][column + 1].equals (turn) && board [row][column + 2].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 6 && column > 1){
                if (board [row][column - 2].equals (turn) && board [row][column - 1].equals (turn) && board [row][column].equals (turn) && board [row][column + 1].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 7 && column > 2){
                if (board [row][column - 3].equals (turn) && board [row][column - 2].equals (turn) && board [row][column - 1].equals (turn) && board [row][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (row < 3){
                if (board [row][column].equals (turn) && board [row + 1][column].equals (turn) && board [row + 2][column].equals (turn) && board [row + 3][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (row < 4 && row > 0){
                if (board [row - 1][column].equals (turn) && board [row][column].equals (turn) && board [row + 1][column].equals (turn) && board [row + 2][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (row < 5 && row > 1){
                if (board [row - 2][column].equals (turn) && board [row - 1][column].equals (turn) && board [row][column].equals (turn) && board [row + 1][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (row < 6 && row > 2){
                if (board [row - 3][column].equals (turn) && board [row - 2][column].equals (turn) && board [row - 1][column].equals (turn) && board [row][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 4 && row < 3){
                if (board [row][column].equals (turn) && board [row + 1][column + 1].equals (turn) && board [row + 2][column + 2].equals (turn) && board [row + 3][column + 3].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 7 && column > 2 && row < 3){
                if (board [row][column].equals (turn) && board [row + 1][column - 1].equals (turn) && board [row + 2][column - 2].equals (turn) && board [row + 3][column - 3].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 6 && column > 1 && row < 4 && row > 0){
                if (board [row - 1][column + 1].equals (turn) && board [row][column].equals (turn) && board [row + 1][column - 1].equals (turn) && board [row + 2][column - 2].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 5 && column > 0 && row < 4 && row > 0){
                if (board [row - 1][column - 1].equals (turn) && board [row][column].equals (turn) && board [row + 1][column + 1].equals (turn) && board [row + 2][column + 2].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 5 && column > 0 && row < 5 && row > 1){
                if (board [row - 2][column + 2].equals (turn) && board [row - 1][column + 1].equals (turn) && board [row][column].equals (turn) && board [row + 1][column - 1].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 6 && column > 1 && row < 5 && row > 1){
                if (board [row - 2][column - 2].equals (turn) && board [row - 1][column - 1].equals (turn) && board [row][column].equals (turn) && board [row + 1][column + 1].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column > 2 && row > 2){
                if (board [row - 3][column - 3].equals (turn) && board [row - 2][column - 2].equals (turn) && board [row - 1][column - 1].equals (turn) && board [row][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (column < 4 && row > 2){
                if (board [row - 3][column + 3].equals (turn) && board [row - 2][column + 2].equals (turn) && board [row - 1][column + 1].equals (turn) && board [row][column].equals (turn)){
                    System.out.println("PLAYER " + playerturn + " WON.");
                    break;
                }
            }
            if (turn.equals (" X ")){
                turn = " O ";
            }
            else if (turn.equals (" O ")){
                turn = " X ";
            }

        }

    }
}
