package Catch;

import java.util.ArrayList;
import java.util.Random;

public class Key {

    private ArrayList<int []> key;
    static int keyXPos;
    static int keyYPos;

    public Key() {
        key = new ArrayList<int []>();
    }

    public void spawnKeys() {
        Random random = new Random();
        int numberGen = random.nextInt(24);
        keyXPos = 0;
        keyYPos = numberGen;
        key.add(new int[] {0, numberGen});
    }

    public int size() {
        return key.size();
    }

    public int [] getPos(int i) {
        return key.get(i);
    }

    public void remove() {
        key.remove(0);
    }

}
