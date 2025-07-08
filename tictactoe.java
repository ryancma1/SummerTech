import java.util.Scanner;
public class tictactoe {
    public static void main(String[] args) {
        Scanner answer = new Scanner(System.in);
        String [][] board = new String[3][3];
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board [i][j] = "-";
            }
        }
        String turn = "X";
        int playerturn = 1;
        while (0<1){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println("");
            }
            if (turn.equals ("X")){
                playerturn = 1;
            }
            else if (turn.equals ("O")){
                playerturn = 2;
            }
            System.out.println("Player " + playerturn + ". Where would you like to play an " + turn + "?");
            System.out.println("Please type the x and the y coordinates of the spot on the board.");
            int xcord = answer.nextInt();
            int ycord = answer.nextInt();
            board [xcord][ycord] = turn;
            if (board [0][0].equals (turn) && board [0][1].equals (turn) && board [0][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
                break;
            }
            if (board [0][0].equals (turn) && board [1][0].equals (turn) && board [2][0].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
            }
            if (board [0][0].equals (turn) && board [1][1].equals (turn) && board [2][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
            }
            if (board [1][0].equals (turn) && board [1][1].equals (turn) && board [1][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
            }
            if (board [2][0].equals (turn) && board [2][1].equals (turn) && board [2][2].equals (turn)){
                System.out.println("PLAYER " + playerturn + " WON.");
            }
            
            if (turn.equals ("X")){
                turn = "O";
            }
            else if (turn.equals ("O")){
                turn = "X";
            }

        }
    }
}
