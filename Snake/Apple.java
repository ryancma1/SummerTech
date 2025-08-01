package Snake;
import java.util.Random;

public class Apple {

    static int appleXPos;
    static int appleYPos;

    public Apple() {

    }

    public static void spawnApple(Snake snake, char[][] board, char apple) {
        Random random = new Random();
        boolean appleSpawned = false;
        while (appleSpawned == false) {
            int numberGen1 = random.nextInt(15);
            int numberGen2 = random.nextInt(15);
            for (int i = 0; i < snake.size(); i++) {
                if (numberGen1 != snake.getPos(i)[0] && numberGen2 != snake.getPos(i)[1]) {
                    appleXPos = numberGen1;
                    appleYPos = numberGen2;
                    appleSpawned = true;
                }
            }
        }
    }

    public static int getXPos() {
        return appleXPos;
    }

    public static int getYPos() {
        return appleYPos;
    }
}
