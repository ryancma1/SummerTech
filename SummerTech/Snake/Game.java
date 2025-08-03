package Snake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game implements KeyDefinition, ActionListener {
    
    public char[][] board;
    Snake snake;
    int direction;
    JTextArea Display;
    boolean die = false;
    boolean win = false;
    int counter = 0;
    final char tile = '⬜';
    final char snakeTile = '⬛';
    final char apple = '⚿';
    Timer timer;
    public static void main(String[] args) {
        KeyInputs.Start("Snake", new Game());
    }

    public Game() {
        Display = new JTextArea("");
        snake = new Snake();
        board = new char[15][15];
        timer = new Timer(200, this);
        timer.start();
        frameActions();
        direction = 1; 
    }

    public void frameActions() {
        counter = 0;
        if (die == false && win == false) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    board[i][j] = tile;
                }
            }
            board[Apple.getXPos()][Apple.getYPos()] = apple;
            snakeEatApple();
            for (int i = 0; i < snake.size(); i++) {
                board[snake.getPos(i)[0]][snake.getPos(i)[1]] = snakeTile;
            }
            for (int i = 3; i < snake.size() - 1; i++) {
                if (snake.getPos(0)[0] == snake.getPos(i)[0] && snake.getPos(0)[1] == snake.getPos(i)[1]) {
                    die = true;
                }
            }
        }
    }


    public void snakeEatApple() {
        if (board[snake.getPos(0)[0]][snake.getPos(0)[1]] == apple) {
            board[snake.getPos(0)[0]][snake.getPos(0)[1]] = tile;
            snake.addBody();
            if (snake.size() == 225) {
                win = true;
            }
            Apple.spawnApple(snake, board, apple);
        }
    }

    public void print(JTextArea Display) {
        frameActions();
        Display.setText("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Display.append(board[i][j] + "");
            }
            Display.append("\n");
        }
    }

    public void KeyDefine(int KeyCode, JTextArea Display) {
        if (KeyCode == 39 || KeyCode == 68) {
            if (direction != 3 && counter == 0) {
                direction = 1;
                counter++;
            }
        }
        else if (KeyCode == 38 || KeyCode == 87) {
            if (direction != 4 && counter == 0) {
                direction = 2;
                counter++;
            }
        }
        else if (KeyCode == 37 || KeyCode == 65) {
            if (direction != 1 && counter == 0) {
                direction = 3;
                counter++;
            }
        }
        else if (KeyCode == 40 || KeyCode == 83) {
            if (direction != 2 && counter == 0) {
                direction = 4;
                counter++;
            }
        } 
        else if (KeyCode == 32) {
            main(null);
        }
        this.Display = Display;
    }

    public void actionPerformed(ActionEvent e) {    
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.getPos(i)[0] = snake.getPos(i - 1)[0];
            snake.getPos(i)[1] = snake.getPos(i - 1)[1];
        }  
        if (direction == 1) {
            if (snake.getPos(0)[1] + 1 < 15) {
                snake.getPos(0)[1] = snake.getPos(0)[1] + 1;
                //Right
            }
            else {
                die = true;
            }
        }
        else if (direction == 2) {
            if (snake.getPos(0)[0] - 1 > -1) {
                snake.getPos(0)[0] = snake.getPos(0)[0] - 1;
                //Up
            }
            else {
                die = true;
            }
        }
        else if (direction == 3) {
            if (snake.getPos(0)[1] - 1 > -1) {
                snake.getPos(0)[1] = snake.getPos(0)[1] - 1;
                //Left
            }
            else {
                die = true;
            }
        }
        else if (direction == 4) {
            if (snake.getPos(0)[0] + 1 < 15) {
                snake.getPos(0)[0] = snake.getPos(0)[0] + 1;
                //Down
            }
            else {
                die = true;
            }
        }
        if (die == false && win == false) {
            print(Display);
        }
        else if (win == false) {
            Display.setText("You DIED.\n Snake Size: " + snake.size());
        }
        else {
            Display.setText("You WIN!\n Snake Size: " + snake.size());
        }
    }
}