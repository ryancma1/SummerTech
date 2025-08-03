package TicTacToe;

import java.util.ArrayList;

public class Player1 {

    private ArrayList<int []> player1; 

    public Player1() {
        player1 = new ArrayList<int []>();
        
    }

    public int [] getPos(int i) {
        return player1.get(i);
    }

    public int size() {
        return player1.size();
    }

    public void addPiece(int a, int b) {
        player1.add(new int[] {a, b});
    }

}