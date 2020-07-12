import java.util.Scanner;


public class MazeRunner {
    public static Maze myMap = new Maze();
    public static int moves = 0;

    public static void main(String[] args) {
        intro();
        userMove();
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner! ");
        System.out.println("Here is your current Maze: ");
        myMap.printMap();
    }

    public static String userMove() {
        System.out.println("Which direction would you like to move? (R, L, U, D) ");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine().toUpperCase();

        if (move.equals("R")) {
            moves++;
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }
        if (move.equals("L")) {
            moves++;
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("U")) {
            moves++;
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("D")) {
            moves++;
            if (myMap.canIMoveDown()) {
                myMap.moveDown();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        else {
            System.out.print("Invalid Selection. Please choose either R, L, U, or D ");
            move = input.nextLine().toUpperCase();
        }
        myMap.printMap();
        return move;
    }

    public static void movesMessage(int moveCount) {
        if (moveCount == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }
        else if (moveCount == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }
        else if (moveCount == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }
        else if (moveCount == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }

}
