package TicTacToe;

//imported libraries
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

//make a bot that can go through all the possible outcomes from that given position and make moves based off that
//allow the player to use their arrow keys to move around the board and place their X or O in that spot. Don't allow them to hover over occupied spots.
public class Game implements KeyDefinition {
    
    //variables/attributes
    public char[][] board;
    Player player;
    Bot bot;
    JTextArea Display;
    final char tile = '⬜';
    final char oTile = '⬤';
    final char xTile = '⛝';
    static String turn;
    char turnTile;
    boolean win = false;

    public static void main(String[] args) {
        //main method to start the game
        Random r = new Random();
        int firstTurn = r.nextInt(2);
        if (firstTurn == 0) {
            turn = "Bot";
        }
        else {
            turn = "Player";
        }
        KeyInputs.Start("TicTacToe", new Game());
    }

    public Game() {
        //initial constructor to create everything
        Display = new JTextArea("");
        player = new Player();
        bot = new Bot();
        board = new char[3][3];
        frameActions(turn);
    }

    public void frameActions(String turn) {
        //all the checks and actions that happen every move/frame
        print(Display, turn);
        if (turn.equals ("Bot")) {
            bot.botTurn();
            turnTile = xTile;
        }
        if (turn.equals ("Player")) {
            turnTile = oTile;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == turnTile && board[i][1] == turnTile && board[i][2] == turnTile) || (board[0][i] == turnTile && board[1][i] == turnTile && board[2][i] == turnTile) || (board[0][0] == turnTile && board[1][1] == turnTile && board[2][2] == turnTile) || (board[2][0] == turnTile && board[1][1] == turnTile && board[0][2] == turnTile)) {
                win = true;
            }
        }
        if (!win) {
            Display.setText(turn + " Won!\n");
        }
        turn = "Player";
        //when player presses a key
    }
    
    public void print(JTextArea Display, String turn) {
        //sets the Display to the board
        Display.setText("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Display.append(board[i][j] + "");
            }
            Display.append("\n");
        }
        Display.append("\n" + turn + " turn");
    }

    public void KeyDefine(int KeyCode, JTextArea Display) {
        //allows the player to move aorund the board and choose where they want to put their piece
        //move the character around the board depending on the already existing pieces
        //press enter to confirm placement
        if (KeyCode == 38 || KeyCode == 87) {
            //up
        }
        else if (KeyCode == 40 || KeyCode == 83) {
            //down
        } 
        else if (KeyCode == 37 || KeyCode == 65) {
            //left
        }
        else if (KeyCode == 39 || KeyCode == 68) {
            //right
        }
        else if (KeyCode == 32) {
            //main(null);
            //start a new game
        }
        this.Display = Display;
    }
}