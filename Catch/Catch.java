package Catch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Catch implements KeyDefinition, ActionListener {
    
    public char[][] board;
    final char keyTile = '⚿';
    final char tile = '⬜';
    final char bowlTile = '⬛';
    BufferedReader bufferedreader;
    BufferedWriter bufferedwriter;
    boolean die = false;
    Bowl bowl;
    Key key;
    int counter;
    int HighPoints;
    int points;
    int speed;
    int direction;
    JTextArea Display;
    Timer timer;

    public static void main(String[] args) throws IOException, FileNotFoundException{
        KeyInputs.Start("Catch", new Catch());
    }

    public Catch() throws IOException, FileNotFoundException{
        bufferedreader = new BufferedReader(new FileReader("HighPoints.txt"));
        HighPoints = Integer.parseInt(bufferedreader.readLine().trim());
        bufferedwriter = new BufferedWriter(new FileWriter("HighPoints.txt"));
        System.out.println("hi");
        set();
    }
    
    public void set(){
        points = 0;
        counter = 0;
        Display = new JTextArea("");
        board = new char[24][24];
        key = new Key();
        bowl = new Bowl();
        speed = 8;
        timer = new Timer(160, this);
        timer.start();
        frameActions();
    }

    public void frameActions(){
        
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                board[i][j] = tile;
            }
        }
        if (counter % speed == 0) {
            key.spawnKeys();
        }
        if (points == 10) {
            speed = 6;
        }
        else if (points == 25) {
            speed = 4;
        }
        if (key.size() > 0) {
            for (int i = 0; i < key.size(); i++) {
                board[key.getPos(i)[0]][key.getPos(i)[1]] = keyTile;
            }
        }
        bowlCatchItem();
        for (int i = 0; i < bowl.size(); i++) {
            board[bowl.getPos(i)[0]][bowl.getPos(i)[1]] = bowlTile;
        }
        for (int i = 0; i < key.size(); i++) {
            if (key.getPos(i)[0] == 23 && board[key.getPos(i)[0]][key.getPos(i)[1]] != bowlTile) {
                die = true;
            }
        }
        counter++;
        if(points > HighPoints) {
            HighPoints = points;
        }
        
    }

    public void print(JTextArea Display){
        frameActions();
        Display.setText("Score: " + points + "\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                Display.append(board[i][j] + "");
            }
            Display.append("\n");
        }
    }

    public void bowlCatchItem() {
        for (int i = 0; i < 5; i++) {
            if (board[bowl.getPos(i)[0]][bowl.getPos(i)[1]] == keyTile) {
                points++;
                key.remove();
            }
        }
    }

    public void KeyDefine(int KeyCode, JTextArea Display) {
        if (KeyCode == 39 || KeyCode == 68) {
            for (int i = 0; i < bowl.size(); i++) {
                if (bowl.getPos(5)[1] < 23) {
                    bowl.getPos(i)[1] = bowl.getPos(i)[1] + 1;
                }
            }
        }
        else if (KeyCode == 37 || KeyCode == 65) {
            if (bowl.getPos(0)[1] > 0) {
                bowl.getPos(0)[1] = bowl.getPos(0)[1] - 1;
                bowl.getPos(1)[1] = bowl.getPos(1)[1] - 1;
                bowl.getPos(2)[1] = bowl.getPos(2)[1] - 1;
                bowl.getPos(3)[1] = bowl.getPos(3)[1] - 1;
                bowl.getPos(4)[1] = bowl.getPos(4)[1] - 1;
                bowl.getPos(5)[1] = bowl.getPos(5)[1] - 1;
            }
        }
        else if (KeyCode == 32) {
            set();
        }
        this.Display = Display;
    }

    public void actionPerformed(ActionEvent e){
        if (key.size() > 0) {
            for (int i = 0; i < key.size(); i++) {
                key.getPos(i)[0] = key.getPos(i)[0] + 1;
            }
        }
        if (die == false) {
            print(Display);
        }
        else if (die == true) {
            Display.setText("You DIED.\n Score: " + points + "\n Highscore: " + HighPoints);
            try{
                bufferedwriter.write(HighPoints + "");
                bufferedwriter.close();
                bufferedreader.close();
            }
            catch(Exception ex){}
        }
    }
}
