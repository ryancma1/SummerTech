package Snake;
import java.util.ArrayList;
public class Snake {

    private ArrayList<int []> snake; 

    public Snake() {
        snake = new ArrayList<int []>();
        snake.add(new int[] {7, 4});
        snake.add(new int[] {7, 3});
        snake.add(new int[] {7, 2});
        snake.add(new int[] {7, 1});
    }

    public int [] getPos(int i) {
        return snake.get(i);
    }

    public int size() {
        return snake.size();
    }

    public void addBody() {
        snake.add(new int[] {snake.get(snake.size() - 1)[0], snake.get(snake.size() - 1)[1]});
    }

}
