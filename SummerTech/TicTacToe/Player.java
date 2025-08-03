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

    public void addBody() {
        //snake.add(new int[] {snake.get(snake.size() - 1)[0], snake.get(snake.size() - 1)[1]});
    }

}

