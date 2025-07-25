package Games;
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        String [][] board = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board [i][j] = " - ";
            }
        }
        for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
            }
        String turn = " X ";
        int playerturn = 1;
        int turncount = 0;
        while (turncount < 9){
            if (turn.equals (" X ")){
                playerturn = 1;
            }
            else if (turn.equals (" O ")){
                playerturn = 2;
            }
            System.out.println("Player " + playerturn + ". Where would you like to play an " + turn + "?");
            System.out.println("Please type the x and the y coordinates of the spot on the board.");
            int xcord = answer.nextInt();
            int ycord = answer.nextInt();
            if (xcord > 2 || ycord > 2 || xcord < 0 || ycord < 0){
                System.out.println("Please input an accurate response.");
                continue;
            }
            if (board [xcord][ycord].equals (" X ")||board [xcord][ycord].equals (" O ")){
                System.out.println("Please enter a spot that isn't occupied.");
                continue;
            }
            turncount += 1;
            board [xcord][ycord] = turn;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
            }
            if (board [0][0].equals (turn) && board [0][1].equals (turn) && board [0][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [0][0].equals (turn) && board [1][0].equals (turn) && board [2][0].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [0][0].equals (turn) && board [1][1].equals (turn) && board [2][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [1][0].equals (turn) && board [1][1].equals (turn) && board [1][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [2][0].equals (turn) && board [2][1].equals (turn) && board [2][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [0][1].equals (turn) && board [1][1].equals (turn) && board [2][1].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [0][2].equals (turn) && board [1][2].equals (turn) && board [2][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [2][0].equals (turn) && board [1][1].equals (turn) && board [0][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
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
