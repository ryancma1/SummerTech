package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Game implements KeyDefinition, ActionListener {
    
    //variables/attributes
    public char[][] board;
    Player1 player1;
    Player2 player2;
    PlayerHold playerHold;
    JTextArea Display;
    final char tile = '⬜';
    final char oTile = '⬤';
    final char xTile = '⛝';
    static String turn;
    char turnTile;
    boolean win = false;
    int counter;
    int xPos = 0;
    int yPos = 0;
    Timer timer;

    public static void main(String[] args) {
        //main method to start the game
        turn = "Player1";
        KeyInputs.Start("TicTacToe", new Game());
    }

    public Game() {
        //initial constructor to create everything
        Display = new JTextArea("");
        player1 = new Player1();
        player2 = new Player2();
        playerHold = new PlayerHold();
        board = new char[3][3];
        timer = new Timer(200, this);
        timer.start();
        frameActions(turn, board);
    }

    public void frameActions(String turn, char[][] board) {
        //all the checks and actions that happen every move/frame
        System.out.println("Player1 size: " + player1.size());
        System.out.println("Player2 size: " + player2.size());
        if (win == false) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = tile;
                }
            }
            for (int i = 0; i < player1.size(); i++) {
                turnTile = xTile;
                System.out.print("a");
                board[player1.getPos(i)[0]][player1.getPos(i)[1]] = turnTile;
            }
            for (int i = 0; i < player2.size(); i++) {
                turnTile = oTile;
                System.out.print("b");
                board[player2.getPos(i)[0]][player2.getPos(i)[1]] = turnTile;
            }
        }
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
        if (turn.equals ("Player1")) {
            turn = "Player2";
        }
        else if (turn.equals ("Player2")) {
            turn = "Player1";
        }
        counter = 0;
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
        
        if (counter == 0) {
            playerStart(board);
        }
        counter++;
        if (KeyCode == 38 || KeyCode == 87) {
            //up
            if (xPos - 1 > -1 && (board[xPos - 1][yPos] == tile)) {
                System.out.println("up1");
                board[xPos][yPos] = tile;
                board[xPos - 1][yPos] = turnTile;
                xPos = xPos - 1;
                this.Display = Display;
            }
            else if (xPos - 2 > -1 && (board[xPos - 2][yPos] == tile)) {
                System.out.println("up2");
                board[xPos][yPos] = tile;
                board[xPos - 2][yPos] = turnTile;
                xPos = xPos - 2;
                this.Display = Display;
            }

        }
        else if (KeyCode == 40 || KeyCode == 83) {
            //down
            if (xPos + 1 < 3 && (board[xPos + 1][yPos] == tile)) {
                System.out.println("down1");
                board[xPos][yPos] = tile;
                board[xPos + 1][yPos] = turnTile;
                xPos = xPos + 1;
                this.Display = Display;
            }
            else if (xPos + 2 < 3 && (board[xPos + 2][yPos] == tile)) {
                System.out.println("down2");
                board[xPos][yPos] = tile;
                board[xPos + 2][yPos] = turnTile;
                xPos = xPos + 2;
                this.Display = Display;
            }
        } 
        else if (KeyCode == 37 || KeyCode == 65) {
            //left
            if (yPos - 1 > -1 && (board[xPos][yPos - 1] == tile)) {
                System.out.println("left1");
                board[xPos][yPos] = tile;
                board[xPos][yPos - 1] = turnTile;
                yPos = yPos - 1;
                this.Display = Display;
            }
            else if (yPos - 2 > -1 && (board[xPos][yPos - 2] == tile)) {
                System.out.println("left2");
                board[xPos][yPos] = tile;
                board[xPos][yPos - 2] = turnTile;
                yPos = yPos - 2;
                this.Display = Display;
            }
        }
        else if (KeyCode == 39 || KeyCode == 68) {
            //right
            if (yPos + 1 < 3 && (board[xPos][yPos + 1] == tile)) {
                System.out.println("right1");
                board[xPos][yPos] = tile;
                board[xPos][yPos + 1] = turnTile;
                yPos = yPos + 1;
                this.Display = Display;
            }
            else if (yPos + 2 < 3 && (board[xPos][yPos + 2] == tile)) {
                System.out.println("right2");
                board[xPos][yPos] = tile;
                board[xPos][yPos + 2] = turnTile;
                yPos = yPos + 2;
                this.Display = Display;
            }
        }
        else if (KeyCode == 32) {
            main(null);
            //start a new game
        }
        if (KeyCode == 10) {
            if (turnTile == xTile) {
                board[xPos][yPos] = turnTile;
                player1.addPiece(xPos, yPos);
                System.out.println("PLayer1 size: " + player1.size());
                frameActions(turn, board);
            }
            else if (turnTile == oTile) {
                board[xPos][yPos] = turnTile;
                player2.addPiece(xPos, yPos);
                System.out.println("PLayer2 size: " + player2.size());
                frameActions(turn, board);
            }
        }
        this.Display = Display;
    }

    public void actionPerformed(ActionEvent e) {   
        print(Display, turn);
        if (win) {
            Display.setText(turn + " Won!\n");
        }
    }

    public void playerStart(char [][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != turnTile) {
                    xPos = i;
                    yPos = j;
                    playerHold.addPiece(xPos, yPos);
                }
            }
        }
        xPos = playerHold.getPos(0)[0];
        yPos = playerHold.getPos(0)[1];
        System.out.println(xPos + " xpos");
        System.out.println(yPos + " ypos");
        board[xPos][yPos] = turnTile;
    }
}