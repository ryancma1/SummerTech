package TicTacToe;

import java.util.ArrayList;
import java.util.Random;

public class Bot {
    
    private ArrayList<int []> bot;
    private ArrayList<int []> botCalculate;
    final char oTile = '⬤';
    final char xTile = '⛝';
    Player player;

    public Bot() {
        bot = new ArrayList<int []>();
        botCalculate = new ArrayList<int []>();
    }

    public void botTurn() {
        Random r = new Random();
        int a = r.nextInt(3) + 1;
        int b = r.nextInt(3) + 1;
        for (int i = 0; i < player.size(); i++) {
            if (player.getPos(i)[0] == a && player.getPos(i)[1] == b) {
                botTurn();
            }
        }
        botCalculate.add(new int[] {a, b});

    }
}
