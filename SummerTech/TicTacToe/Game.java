package TicTacToe;

import javax.swing.*;

public class Game implements KeyDefinition {
    
    //variables/attributes
    public char[][] board;
    Player player1;
    Player player2;
    JTextArea Display;
    final char tile = '⬜';
    final char oTile = '⬤';
    final char xTile = '⛝';
    static String turn;
    char turnTile;
    boolean win = false;
    boolean enter;
    int xPos = 0;
    int yPos = 0;

    public static void main(String[] args) {
        //main method to start the game
        turn = "Player1";
        KeyInputs.Start("TicTacToe", new Game());
    }

    public Game() {
        //initial constructor to create everything
        Display = new JTextArea("");
        player1 = new Player();
        player2 = new Player();
        board = new char[3][3];
        frameActions(turn);
    }

    public void frameActions(String turn) {
        //all the checks and actions that happen every move/frame
        print(Display, turn);
        if (turn.equals ("Player1")) {
            turnTile = xTile;
        }
        if (turn.equals ("Player2")) {
            turnTile = oTile;
        }
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == turnTile && board[i][1] == turnTile && board[i][2] == turnTile) || (board[0][i] == turnTile && board[1][i] == turnTile && board[2][i] == turnTile) || (board[0][0] == turnTile && board[1][1] == turnTile && board[2][2] == turnTile) || (board[2][0] == turnTile && board[1][1] == turnTile && board[0][2] == turnTile)) {
                win = true;
            }
        }
        if (win) {
            Display.setText(turn + " Won!\n");
        }
        if (turn.equals ("Player1")) {
            turn = "Player2";
        }
        if (turn.equals ("Player2")) {
            turn = "Player1";
        }
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
        //allows the players to move around the board and choose where they want to put their pieces
        enter = false;
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] != xTile || board[i][j] != oTile) {
                        xPos = i;
                        yPos = j;
                        board[i][j] = turnTile;
                        break;
                    }
                }
            }
        while (enter) {
            if (KeyCode == 38 || KeyCode == 87) {
                //up
                if (xPos - 1 > -1 && (board[xPos - 1][yPos] != xTile || board[xPos - 1][yPos] != oTile)) {
                    board[xPos - 1][yPos] = turnTile;
                    xPos = xPos - 1;
                }
                else if (xPos - 2 > -1 && (board[xPos - 2][yPos] != xTile || board[xPos - 2][yPos] != oTile)) {
                    board[xPos - 2][yPos] = turnTile;
                    xPos = xPos - 2;
                }

            }
            else if (KeyCode == 40 || KeyCode == 83) {
                //down
                if (xPos + 1 < 3 && (board[xPos + 1][yPos] != xTile || board[xPos + 1][yPos] != oTile)) {
                    board[xPos + 1][yPos] = turnTile;
                    xPos = xPos + 1;
                }
                else if (xPos + 2 < 3 && (board[xPos + 2][yPos] != xTile || board[xPos + 2][yPos] != oTile)) {
                    board[xPos + 2][yPos] = turnTile;
                    xPos = xPos + 2;
                }
            } 
            else if (KeyCode == 37 || KeyCode == 65) {
                //left
                if (yPos - 1 > -1 && (board[xPos][yPos - 1] != xTile || board[xPos][yPos - 1] != oTile)) {
                    board[xPos][yPos - 1] = turnTile;
                    yPos = yPos - 1;
                }
                else if (yPos - 2 > -1 && (board[xPos][yPos - 2] != xTile || board[xPos][yPos - 2] != oTile)) {
                    board[xPos][yPos - 2] = turnTile;
                    yPos = yPos - 2;
                }
            }
            else if (KeyCode == 39 || KeyCode == 68) {
                //right
                if (yPos + 1 < 3 && (board[xPos][yPos + 1] != xTile || board[xPos][yPos + 1] != oTile)) {
                    board[xPos][yPos + 1] = turnTile;
                    yPos = yPos + 1;
                }
                else if (yPos + 2 < 3 && (board[xPos][yPos + 2] != xTile || board[xPos][yPos + 2] != oTile)) {
                    board[xPos][yPos + 2] = turnTile;
                    yPos = yPos + 2;
                }
            }
            else if (KeyCode == 32) {
                main(null);
                //start a new game
            }
            if (KeyCode == 13) {
                if (turnTile == xTile) {
                    board[xPos][yPos] = xTile;
                    player1.addPiece(xPos, yPos);
                }
                else if (turnTile == oTile) {
                    board[xPos][yPos] = oTile;
                    player2.addPiece(xPos, yPos);
                }
                enter = true;
            }
        }
        this.Display = Display;
    }
}