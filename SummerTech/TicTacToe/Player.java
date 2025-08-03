package TicTacToe;

import java.util.ArrayList;

public class Player {

    private ArrayList<int []> player; 

    public Player() {
        player = new ArrayList<int []>();
        
    }

    public int [] getPos(int i) {
        return player.get(i);
    }

    public int size() {
        return player.size();
    }

    public void addPiece(int a, int b) {
        player.add(new int[] {a, b});
    }

}

