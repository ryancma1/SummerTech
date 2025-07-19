package Games;
import java.util.Scanner;
public class Sudoku{
    public static void difficulty(){
        System.out.println("Select a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
    }

    public static void level(){
        System.out.println("Select a level:");
        System.out.println("1. Level 1");
        System.out.println("2. Level 2");
        System.out.println("3. Level 3");
    }

    public static void selection (String [][] board, String [][] boardAnswer){
        Scanner answer = new Scanner(System.in);
        int level = 0;
        int difficulty = 0;
        difficulty();
        System.out.print("Difficulty: ");
        difficulty = answer.nextInt();
        System.out.println("");
        while (difficulty < 1 || difficulty > 3) {
            System.out.println("Invalid choice. Please select a difficulty level:");
            difficulty = answer.nextInt();
        }
        if (difficulty == 1) {
            System.out.println("Easy Difficulty selected.");
            level();
            System.out.print("Level: ");
            level = answer.nextInt();
            while (level < 1 || level > 3) {
                System.out.println("Invalid choice. Please select a level:");
                level = answer.nextInt();
            }
            if (level == 1) {
                System.out.println("Easy Level 1 selected.");
                easylvl1(board, boardAnswer);
            }
            if (level == 2) {
                System.out.println("Easy Level 2 selected.");
                easylvl2(board, boardAnswer);
            }
            if (level == 3) {
                System.out.println("Easy Level 3 selected.");
                easylvl3(board, boardAnswer);
            }
        }
        if (difficulty == 2) {
            System.out.println("Medium Difficulty selected.");
            level();
            System.out.print("Level: ");
            level = answer.nextInt();
            while (level < 1 || level > 3) {
                System.out.println("Invalid choice. Please select a level:");
                level = answer.nextInt();
            }
            if (level == 1) {
                System.out.println("Medium Level 1 selected.");
                mediumlvl1(board, boardAnswer);
            }
            if (level == 2) {
                System.out.println("Medium Level 2 selected.");
                mediumlvl2(board, boardAnswer);
            }
            if (level == 3) {
                System.out.println("Medium Level 3 selected.");
                mediumlvl3(board, boardAnswer);
            }
        }
        if (difficulty == 3) {
            System.out.println("Hard Difficulty selected.");
            level();
            System.out.print("Level: ");
            level = answer.nextInt();
            while (level < 1 || level > 3) {
                System.out.println("Invalid choice. Please select a level:");
                level = answer.nextInt();
            }
            if (level == 1) {
                System.out.println("Hard Level 1 selected.");
                hardlvl1(board, boardAnswer);
            }
            if (level == 2) {
                System.out.println("Hard Level 2 selected.");
                hardlvl2(board, boardAnswer);
            }
            if (level == 3) {
                System.out.println("Hard Level 3 selected.");
                hardlvl3(board, boardAnswer);
            }
        }
        System.out.println("Here is your Sudoku board:");
        print(board);
    }

    public static void rules(){
        System.out.println("Rules: ");
        System.out.println("1. Fill the grid with numbers from 1 to 9.");
        System.out.println("2. Each number must appear only once in each row, column, and 3x3 grid.");
        System.out.println("3. You can select a difficulty level and a level within that difficulty.");
        System.out.println("4. Within each level, you will have 5 lives. If you make a mistake, you lose a life.");
    }

    public static void continuing(String [][] board, String [][] boardAnswer, int lives, String continueGame){
        Scanner answer = new Scanner(System.in);
        System.out.println("Here is the full answer board: ");
        print(boardAnswer);
        System.out.println("Would you like to play another Sudoku? (yes/no)");
        continueGame = answer.next();
        continueGame = continueGame.toUpperCase();
        while (!(continueGame.equals("YES") || continueGame.equals("NO"))) {
            System.out.println("Invalid input. Please enter 'yes' or 'no':");
            continueGame = answer.next();
            continueGame = continueGame.toUpperCase();
        }
        if (continueGame.equals("YES")) {
            System.out.println("Starting a new game...");
            main(new String[0]);
        } else if (continueGame.equals("NO")) {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }

    public static void input(String [][] board, String [][] boardAnswer, int lives, String continueGame){
        Scanner answer = new Scanner(System.in);
        System.out.println("Enter the row (0 - 8), column (0 - 8), and value (1 - 9).");
        System.out.print("Row: ");
        int row = answer.nextInt();
        System.out.print("Column: ");
        int column = answer.nextInt();
        System.out.print("Value: ");
        int value = answer.nextInt();
        while (row < 0 || row > 8 || column < 0 || column > 8 || value < 1 || value > 9) {
            if (!(board[row][column].equals (" _ "))) {
                System.out.println("Invalid input. Please enter valid row (0 - 8), column (0 - 8), and value (1 - 9):");
                System.out.print("Row: ");
                row = answer.nextInt();
                System.out.print("Column: ");
                column = answer.nextInt();
                System.out.print("Value: ");
                value = answer.nextInt();
            }
        }
        board[row][column] = " " + value + " ";
        if (!(board[row][column].equals (boardAnswer[row][column]))) {
            System.out.println("Incorrect! You have lost a life.");
            lives--;
            board[row][column] = " _ ";
            System.out.println("Lives: " + lives);
            if (lives == 0) {
                System.out.println("Game Over! You have no lives left.");
                continuing(board, boardAnswer, lives, continueGame);
            } else {
                System.out.println("Try again.");
            }
            input(board, boardAnswer, lives, continueGame);
        }
        if (check(board, boardAnswer) == 81) {
            System.out.println("Congratulations! You have completed the Sudoku.");
            continuing(board, boardAnswer, lives, continueGame);
        }
        System.out.println("Current board:");
    }

    public static int check(String [][] board, String [][] boardAnswer){
        int correct = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j].equals(boardAnswer[i][j])) {
                    correct++;
                }
            }
        }
        return correct;
    }

    public static void print(String [][] board){
        String horizontalBorder = "+---------+---------+---------+";
        System.out.println("  0  1  2 | 3  4  5 | 6  7  8  ");
        System.out.println(horizontalBorder);
        for (int i = 0; i < 9; i++){
            System.out.print("|");
            for (int j = 0; j < 9; j++){
                System.out.print(board[i][j]);
                if ((j + 1) % 3 == 0) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println(horizontalBorder);
            }
        }
    }

    public static void main(String[] args) {
        String [][] board = new String[9][9];
        String [][] boardAnswer = new String[9][9];
        int lives = 5;
        String continueGame = "YES";
        System.out.println("");
        System.out.println("Welcome to Sudoku!");
        rules();
        System.out.println("");
        selection(board, boardAnswer);
        while (continueGame.equals("YES")) {
            input(board, boardAnswer, lives, continueGame);
            print(board);
        }
    }

    public static void easylvl1(String [][] board, String [][] boardAnswer){
        String[][] easyBoard1 = {
            {" _ ", " _ ", " 3 ", " _ ", " _ ", " _ ", " 2 ", " _ ", " _ "},
            {" _ ", " 6 ", " _ ", " 9 ", " 8 ", " _ ", " _ ", " 4 ", " 3 "},
            {" 4 ", " 9 ", " _ ", " _ ", " 3 ", " 1 ", " _ ", " _ ", " 6 "},
            {" 9 ", " _ ", " 7 ", " _ ", " _ ", " _ ", " 8 ", " 6 ", " _ "},
            {" _ ", " 4 ", " _ ", " _ ", " 9 ", " 8 ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " 5 ", " 4 ", " _ ", " 7 ", " 1 ", " _ ", " 9 "},
            {" 6 ", " _ ", " _ ", " _ ", " _ ", " 3 ", " 9 ", " _ ", " 5 "},
            {" 5 ", " _ ", " 8 ", " 1 ", " _ ", " _ ", " _ ", " 7 ", " 2 "},
            {" 2 ", " _ ", " 9 ", " _ ", " 5 ", " 6 ", " _ ", " 3 ", " 8 "}
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard1[i], 0, board[i], 0, 9);
        }
        easylvl1Answer(board, boardAnswer);
    }

    public static void easylvl1Answer(String [][] board, String[][] boardAnswer) {
        String[][] easyBoard1Answer = {
            {" 8 ", " 5 ", " 3 ", " 6 ", " 7 ", " 4 ", " 2 ", " 9 ", " 1 "},
            {" 7 ", " 6 ", " 1 ", " 9 ", " 8 ", " 2 ", " 5 ", " 4 ", " 3 "},
            {" 4 ", " 9 ", " 2 ", " 5 ", " 3 ", " 1 ", " 7 ", " 8 ", " 6 "},
            {" 9 ", " 2 ", " 7 ", " 3 ", " 1 ", " 5 ", " 8 ", " 6 ", " 4 "},
            {" 1 ", " 4 ", " 6 ", " 2 ", " 9 ", " 8 ", " 3 ", " 5 ", " 7 "},
            {" 3 ", " 8 ", " 5 ", " 4 ", " 6 ", " 7 ", " 1 ", " 2 ", " 9 "},
            {" 6 ", " 7 ", " 4 ", " 8 ", " 2 ", " 3 ", " 9 ", " 1 ", " 5 "},
            {" 5 ", " 3 ", " 8 ", " 1 ", " 4 ", " 9 ", " 6 ", " 7 ", " 2 "},
            {" 2 ", " 1 ", " 9 ", " 7 ", " 5 ", " 6 ", " 4 ", " 3 ", " 8 "}
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard1Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void easylvl2(String [][] board, String [][] boardAnswer){
        String[][] easyBoard2 = {
            {" _ ", " 9 ", " 2 ", " _ ", " 5 ", " 8 ", " _ ", " _ ", " 1 "},
            {" _ ", " _ ", " _ ", " _ ", " 1 ", " _ ", " _ ", " 9 ", " 4 "},
            {" _ ", " 6 ", " 4 ", " _ ", " _ ", " 2 ", " _ ", " 5 ", " _ "},
            {" _ ", " 2 ", " _ ", " 1 ", " _ ", " 5 ", " _ ", " _ ", " 7 "},
            {" 7 ", " 8 ", " _ ", " 2 ", " _ ", " _ ", " _ ", " 1 ", " 3 "},
            {" _ ", " _ ", " 5 ", " 3 ", " 6 ", " _ ", " _ ", " 8 ", " _ "},
            {" _ ", " _ ", " 1 ", " _ ", " 3 ", " 6 ", " 8 ", " _ ", " _ "},
            {" 8 ", " _ ", " 7 ", " _ ", " _ ", " _ ", " 4 ", " _ ", " 6 "},
            {" 6 ", " 3 ", " _ ", " _ ", " 7 ", " 4 ", " _ ", " _ ", " 5 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard2[i], 0, board[i], 0, 9);
        }
        easylvl2Answer(board, boardAnswer);
    }

    public static void easylvl2Answer(String [][] board, String [][] boardAnswer){
        String[][] easyBoard2Answer = {
            {" 3 ", " 9 ", " 2 ", " 4 ", " 5 ", " 8 ", " 7 ", " 6 ", " 1 "},
            {" 5 ", " 7 ", " 8 ", " 6 ", " 1 ", " 3 ", " 2 ", " 9 ", " 4 "},
            {" 1 ", " 6 ", " 4 ", " 7 ", " 9 ", " 2 ", " 3 ", " 5 ", " 8 "},
            {" 9 ", " 2 ", " 3 ", " 1 ", " 8 ", " 5 ", " 6 ", " 4 ", " 7 "},
            {" 7 ", " 8 ", " 6 ", " 2 ", " 4 ", " 9 ", " 5 ", " 1 ", " 3 "},
            {" 4 ", " 1 ", " 5 ", " 3 ", " 6 ", " 7 ", " 9 ", " 8 ", " 2 "},
            {" 2 ", " 4 ", " 1 ", " 5 ", " 3 ", " 6 ", " 8 ", " 7 ", " 9 "},
            {" 8 ", " 5 ", " 7 ", " 9 ", " 2 ", " 1 ", " 4 ", " 3 ", " 6 "},
            {" 6 ", " 3 ", " 9 ", " 8 ", " 7 ", " 4 ", " 1 ", " 2 ", " 5 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard2Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void easylvl3(String [][] board, String [][] boardAnswer){
        String[][] easyBoard3 = {
            {" 2 ", " 1 ", " _ ", " 8 ", " _ ", " 9 ", " 5 ", " _ ", " _ "},
            {" _ ", " 4 ", " 3 ", " _ ", " _ ", " _ ", " 2 ", " _ ", " 8 "},
            {" _ ", " _ ", " _ ", " _ ", " 1 ", " 3 ", " _ ", " _ ", " 9 "},
            {" _ ", " _ ", " 9 ", " _ ", " _ ", " _ ", " 4 ", " 8 ", " _ "},
            {" 3 ", " _ ", " 1 ", " 4 ", " _ ", " 6 ", " _ ", " _ ", " 5 "},
            {" 8 ", " _ ", " _ ", " 9 ", " 7 ", " _ ", " _ ", " 6 ", " 2 "},
            {" _ ", " _ ", " 5 ", " _ ", " _ ", " 4 ", " _ ", " 9 ", " _ "},
            {" 4 ", " 7 ", " _ ", " 6 ", " _ ", " _ ", " _ ", " 5 ", " 3 "},
            {" _ ", " 9 ", " _ ", " _ ", " 5 ", " 7 ", " 6 ", " _ ", " _ "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard3[i], 0, board[i], 0, 9);
        }
        easylvl3Answer(board, boardAnswer);
    }

    public static void easylvl3Answer(String [][] board, String [][] boardAnswer){
        String[][] easyBoard3Answer = {
            {" 2 ", " 1 ", " 7 ", " 8 ", " 4 ", " 9 ", " 5 ", " 3 ", " 6 "},
            {" 9 ", " 4 ", " 3 ", " 7 ", " 6 ", " 5 ", " 2 ", " 1 ", " 8 "},
            {" 5 ", " 8 ", " 6 ", " 2 ", " 1 ", " 3 ", " 7 ", " 4 ", " 9 "},
            {" 7 ", " 6 ", " 9 ", " 5 ", " 3 ", " 2 ", " 4 ", " 8 ", " 1 "},
            {" 3 ", " 2 ", " 1 ", " 4 ", " 8 ", " 6 ", " 9 ", " 7 ", " 5 "},
            {" 8 ", " 5 ", " 4 ", " 9 ", " 7 ", " 1 ", " 3 ", " 6 ", " 2 "},
            {" 6 ", " 3 ", " 5 ", " 1 ", " 2 ", " 4 ", " 8 ", " 9 ", " 7 "},
            {" 4 ", " 7 ", " 2 ", " 6 ", " 9 ", " 8 ", " 1 ", " 5 ", " 3 "},
            {" 1 ", " 9 ", " 8 ", " 3 ", " 5 ", " 7 ", " 6 ", " 2 ", " 4 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(easyBoard3Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void mediumlvl1(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard1 = {
            {" _ ", " _ ", " _ ", " 5 ", " _ ", " 7 ", " _ ", " _ ", " _ "},
            {" _ ", " 4 ", " _ ", " 2 ", " 6 ", " 3 ", " _ ", " _ ", " _ "},
            {" 1 ", " _ ", " 7 ", " 4 ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" 3 ", " 6 ", " _ ", " _ ", " _ ", " _ ", " _ ", " 4 ", " 5 "},
            {" _ ", " _ ", " 2 ", " _ ", " 5 ", " _ ", " 7 ", " _ ", " _ "},
            {" 7 ", " 9 ", " _ ", " _ ", " _ ", " _ ", " _ ", " 6 ", " 2 "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " 9 ", " 4 ", " _ ", " 1 "},
            {" _ ", " _ ", " _ ", " 1 ", " 3 ", " 4 ", " _ ", " 9 ", " _ "},
            {" _ ", " _ ", " _ ", " 6 ", " _ ", " 5 ", " _ ", " _ ", " _ "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard1[i], 0, board[i], 0, 9);
        }
        mediumlvl1Answer(board, boardAnswer);
    }

    public static void mediumlvl1Answer(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard1Answer = {
            {" 8 ", " 3 ", " 6 ", " 5 ", " 1 ", " 7 ", " 9 ", " 2 ", " 4 "},
            {" 5 ", " 4 ", " 9 ", " 2 ", " 6 ", " 3 ", " 1 ", " 7 ", " 8 "},
            {" 1 ", " 2 ", " 7 ", " 4 ", " 9 ", " 8 ", " 6 ", " 5 ", " 3 "},
            {" 3 ", " 6 ", " 1 ", " 9 ", " 7 ", " 2 ", " 8 ", " 4 ", " 5 "},
            {" 4 ", " 8 ", " 2 ", " 3 ", " 5 ", " 6 ", " 7 ", " 1 ", " 9 "},
            {" 7 ", " 9 ", " 5 ", " 8 ", " 4 ", " 1 ", " 3 ", " 6 ", " 2 "},
            {" 6 ", " 5 ", " 3 ", " 7 ", " 2 ", " 9 ", " 4 ", " 8 ", " 1 "},
            {" 2 ", " 7 ", " 8 ", " 1 ", " 3 ", " 4 ", " 5 ", " 9 ", " 6 "},
            {" 9 ", " 1 ", " 4 ", " 6 ", " 8 ", " 5 ", " 2 ", " 3 ", " 7 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard1Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void mediumlvl2(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard2 = {
            {" 3 ", " _ ", " _ ", " _ ", " _ ", " 7 ", " _ ", " 1 ", " _ "},
            {" _ ", " 4 ", " _ ", " 5 ", " 2 ", " _ ", " _ ", " _ ", " _ "},
            {" 7 ", " _ ", " 9 ", " 4 ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" 1 ", " _ ", " 2 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " 7 ", " 9 ", " _ ", " 6 ", " 8 ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " 3 ", " _ ", " 7 "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " 9 ", " 2 ", " _ ", " 6 "},
            {" _ ", " _ ", " _ ", " _ ", " 7 ", " 4 ", " _ ", " 3 ", " _ "},
            {" _ ", " 6 ", " _ ", " 2 ", " _ ", " _ ", " _ ", " _ ", " 4 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard2[i], 0, board[i], 0, 9);
        }
        mediumlvl2Answer(board, boardAnswer);
    }

    public static void mediumlvl2Answer(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard2Answer = {
            {" 3 ", " 5 ", " 6 ", " 8 ", " 9 ", " 7 ", " 4 ", " 1 ", " 2 "},
            {" 8 ", " 4 ", " 1 ", " 5 ", " 2 ", " 3 ", " 7 ", " 6 ", " 9 "},
            {" 7 ", " 2 ", " 9 ", " 4 ", " 6 ", " 1 ", " 5 ", " 8 ", " 3 "},
            {" 1 ", " 9 ", " 2 ", " 7 ", " 3 ", " 8 ", " 6 ", " 4 ", " 5 "},
            {" 5 ", " 3 ", " 7 ", " 9 ", " 4 ", " 6 ", " 8 ", " 2 ", " 1 "},
            {" 6 ", " 8 ", " 4 ", " 1 ", " 5 ", " 2 ", " 3 ", " 9 ", " 7 "},
            {" 4 ", " 7 ", " 8 ", " 3 ", " 1 ", " 9 ", " 2 ", " 5 ", " 6 "},
            {" 2 ", " 1 ", " 5 ", " 6 ", " 7 ", " 4 ", " 9 ", " 3 ", " 8 "},
            {" 9 ", " 6 ", " 3 ", " 2 ", " 8 ", " 5 ", " 1 ", " 7 ", " 4 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard2Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void mediumlvl3(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard3 = {
            {" _ ", " 8 ", " _ ", " 6 ", " _ ", " _ ", " _ ", " 1 ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " 8 ", " 2 ", " 5 ", " 6 "},
            {" _ ", " _ ", " 1 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " 9 ", " _ ", " 4 ", " 6 ", " _ ", " 3 "},
            {" _ ", " _ ", " 9 ", " _ ", " 7 ", " _ ", " 5 ", " _ ", " _ "},
            {" 4 ", " _ ", " 7 ", " 5 ", " _ ", " 2 ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " 8 ", " _ ", " _ "},
            {" 7 ", " 1 ", " 3 ", " 4 ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " 5 ", " _ ", " _ ", " _ ", " 9 ", " _ ", " 3", " _ "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard3[i], 0, board[i], 0, 9);
        }
        mediumlvl3Answer(board, boardAnswer);
    }
    
    public static void mediumlvl3Answer(String [][] board, String [][] boardAnswer){
        String[][] mediumBoard3Answer = {
            {" 2 ", " 8 ", " 5 ", " 6 ", " 4 ", " 7 ", " 3 ", " 1 ", " 9 "},
            {" 3 ", " 7 ", " 4 ", " 1 ", " 9 ", " 8 ", " 2 ", " 5 ", " 6 "},
            {" 6 ", " 9 ", " 1 ", " 2 ", " 3 ", " 5 ", " 7 ", " 8 ", " 4 "},
            {" 5 ", " 2 ", " 8 ", " 9 ", " 1 ", " 4 ", " 6 ", " 7 ", " 3 "},
            {" 1 ", " 6 ", " 9 ", " 8 ", " 7 ", " 3 ", " 5 ", " 4 ", " 2 "},
            {" 4 ", " 3 ", " 7 ", " 5 ", " 6 ", " 2 ", " 1 ", " 9 ", " 8 "},
            {" 9 ", " 4 ", " 2 ", " 3 ", " 5 ", " 1 ", " 8 ", " 6 ", " 7 "},
            {" 7 ", " 1 ", " 3 ", " 4 ", " 8 ", " 6 ", " 9 ", " 2 ", " 5 "},
            {" 8 ", " 5 ", " 6 ", " 7 ", " 2 ", " 9 ", " 4 ", " 3 ", " 1 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(mediumBoard3Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void hardlvl1(String [][] board, String [][] boardAnswer){
        String[][] hardBoard1 = {
            {" 5 ", " _ ", " _ ", " 1 ", " 9 ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " 8 ", " _ ", " _ ", " _ ", " _ ", " 4 "},
            {" _ ", " 3 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " 4 ", " _ ", " _ ", " _ ", " _ ", " 2 ", " 6 ", " _ "},
            {" _ ", " _ ", " _ ", " 3 ", " 4 ", " _ ", " _ ", " _ ", " 8 "},
            {" _ ", " 1 ", " 7 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " 9 ", " _ ", " _ ", " _ ", " 1 ", " 6 ", " 8 ", " _ "},
            {" _ ", " _ ", " 5 ", " 2 ", " _ ", " _ ", " _ ", " _ ", " 9 "},
            {" _ ", " _ ", " 3 ", " _ ", " _ ", " _ ", " 1 ", " _ ", " 7 "}
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard1[i], 0, board[i], 0, 9);
        }
        hardlvl1Answer(board, boardAnswer);
    }

    public static void hardlvl1Answer(String [][] board, String [][] boardAnswer){
        String[][] hardBoard1Answer = {
            {" 5 ", " 8 ", " 2 ", " 1 ", " 9 ", " 4 ", " 3 ", " 7 ", " 6 "},
            {" 6 ", " 7 ", " 1 ", " 8 ", " 2 ", " 3 ", " 5 ", " 9 ", " 4 "},
            {" 4 ", " 3 ", " 9 ", " 7 ", " 5 ", " 6 ", " 8 ", " 2 ", " 1 "},
            {" 3 ", " 4 ", " 8 ", " 9 ", " 1 ", " 7 ", " 2 ", " 6 ", " 5 "},
            {" 9 ", " 5 ", " 6 ", " 3 ", " 4 ", " 2 ", " 7 ", " 1 ", " 8 "},
            {" 2 ", " 1 ", " 7 ", " 6 ", " 8 ", " 5 ", " 9 ", " 4 ", " 3 "},
            {" 7 ", " 9 ", " 4 ", " 5 ", " 3 ", " 1 ", " 6 ", " 8 ", " 2 "},
            {" 1 ", " 6 ", " 5 ", " 2 ", " 7 ", " 8 ", " 4 ", " 3 ", " 9 "},
            {" 8 ", " 2 ", " 3 ", " 4 ", " 6 ", " 9 ", " 1 ", " 5 ", " 7 "}
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard1Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void hardlvl2(String [][] board, String [][] boardAnswer){
        String[][] hardBoard2 = {
            {" _ ", " 9 ", " 2 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " 1 ", " _ ", " _ ", " _ ", " 3 "},
            {" _ ", " _ ", " _ ", " _ ", " 5 ", " _ ", " _ ", " _ ", " 9 "},
            {" 2 ", " _ ", " 3 ", " _ ", " _ ", " _ ", " _ ", " 8 ", " _ "},
            {" 8 ", " _ ", " _ ", " _ ", " 2 ", " _ ", " _ ", " 4 ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " 4 ", " 1 ", " _ ", " 7 ", " _ "},
            {" _ ", " 6 ", " 7 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" 1 ", " _ ", " _ ", " 6 ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " 9 ", " _ ", " _ ", " 4 ", " _ ", " _ "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard2[i], 0, board[i], 0, 9);
        }
        hardlvl2Answer(board, boardAnswer);
    }

    public static void hardlvl2Answer(String [][] board, String [][] boardAnswer){
        String[][] hardBoard2Answer = {
            {" 3 ", " 9 ", " 2 ", " 7 ", " 6 ", " 8 ", " 1 ", " 5 ", " 4 "},
            {" 6 ", " 8 ", " 5 ", " 4 ", " 1 ", " 9 ", " 7 ", " 2 ", " 3 "},
            {" 7 ", " 1 ", " 4 ", " 2 ", " 5 ", " 3 ", " 8 ", " 6 ", " 9 "},
            {" 2 ", " 4 ", " 3 ", " 5 ", " 9 ", " 7 ", " 6 ", " 8 ", " 1 "},
            {" 8 ", " 7 ", " 1 ", " 3 ", " 2 ", " 6 ", " 9 ", " 4 ", " 5 "},
            {" 9 ", " 5 ", " 6 ", " 8 ", " 4 ", " 1 ", " 3 ", " 7 ", " 2 "},
            {" 4 ", " 6 ", " 7 ", " 1 ", " 3 ", " 5 ", " 2 ", " 9 ", " 8 "},
            {" 1 ", " 2 ", " 9 ", " 6 ", " 8 ", " 4 ", " 5 ", " 3 ", " 7 "},
            {" 5 ", " 3 ", " 8 ", " 9 ", " 7 ", " 2 ", " 4 ", " 1 ", " 6 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard2Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }

    public static void hardlvl3(String [][] board, String [][] boardAnswer){
        String[][] hardBoard3 = {
            {" _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " 4 ", " 6 ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " 8 ", " _ ", " _ "},
            {" _ ", " _ ", " 3 ", " _ ", " 7 ", " 9 ", " _ ", " _ ", " 1 "},
            {" 5 ", " _ ", " 1 ", " _ ", " 4 ", " _ ", " 2 ", " _ ", " 6 "},
            {" _ ", " _ ", " 2 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " 8 ", " _ ", " 7 ", " _ "},
            {" 2 ", " 4 ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ ", " _ "},
            {" _ ", " 9 ", " _ ", " 1 ", " 6 ", " 3 ", " _ ", " _ ", " _ "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard3[i], 0, board[i], 0, 9);
        }
        hardlvl3Answer(board, boardAnswer);
    }

    public static void hardlvl3Answer(String [][] board, String [][] boardAnswer){
        String[][] hardBoard3Answer = {
            {" 7 ", " 5 ", " 8 ", " 2 ", " 3 ", " 1 ", " 4 ", " 6 ", " 9 "},
            {" 1 ", " 2 ", " 9 ", " 6 ", " 5 ", " 4 ", " 8 ", " 3 ", " 7 "},
            {" 4 ", " 6 ", " 3 ", " 8 ", " 7 ", " 9 ", " 5 ", " 2 ", " 1 "},
            {" 5 ", " 8 ", " 1 ", " 3 ", " 4 ", " 7 ", " 2 ", " 9 ", " 6 "},
            {" 9 ", " 7 ", " 2 ", " 5 ", " 1 ", " 6 ", " 3 ", " 8 ", " 4 "},
            {" 6 ", " 3 ", " 4 ", " 9 ", " 2 ", " 8 ", " 1 ", " 7 ", " 5 "},
            {" 2 ", " 4 ", " 6 ", " 7 ", " 8 ", " 5 ", " 9 ", " 1 ", " 3 "},
            {" 3 ", " 1 ", " 7 ", " 4 ", " 9 ", " 2 ", " 6 ", " 5 ", " 8 "},
            {" 8 ", " 9 ", " 5 ", " 1 ", " 6 ", " 3 ", " 7 ", " 4 ", " 2 "},
        };
        for (int i = 0; i < 9; i++) {
            System.arraycopy(hardBoard3Answer[i], 0, boardAnswer[i], 0, 9);
        }
    }
}

