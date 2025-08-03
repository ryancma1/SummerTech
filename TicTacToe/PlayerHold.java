package TicTacToe;

import java.util.ArrayList;

public class PlayerHold {

    private ArrayList<int []> playerHold; 

    public PlayerHold() {
        playerHold = new ArrayList<int []>();
        
    }

    public int [] getPos(int i) {
        return playerHold.get(i);
    }

    public int size() {
        return playerHold.size();
    }

    public void addPiece(int a, int b) {
        playerHold.add(new int[] {a, b});
    }

}