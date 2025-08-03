package TicTacToe;

import java.util.ArrayList;

public class Player2 {

    private ArrayList<int []> player2; 

    public Player2() {
        player2 = new ArrayList<int []>();
        
    }

    public int [] getPos(int i) {
        return player2.get(i);
    }

    public int size() {
        return player2.size();
    }

    public void addPiece(int a, int b) {
        player2.add(new int[] {a, b});
    }

}