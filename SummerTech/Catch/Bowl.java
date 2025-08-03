package Catch;

import java.util.ArrayList;

public class Bowl {
    
    private ArrayList<int []> bowl;

    public Bowl() {
        bowl = new ArrayList<int []>();
        bowl.add(new int[] {22, 10});
        bowl.add(new int[] {23, 10});
        bowl.add(new int[] {23, 11});
        bowl.add(new int[] {23, 12});
        bowl.add(new int[] {23, 13});
        bowl.add(new int[] {22, 13});
    }

    public int size() {
        return bowl.size();
    }

    public int [] getPos(int i) {
        return bowl.get(i);
    }
}
