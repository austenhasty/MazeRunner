import java.util.Scanner;


public class MazeRunner {
    public static void main(String[] args) {
        intro();
    }

    public static void intro() {

        Maze myMap = new Maze();
        System.out.println("Welcome to Maze Runner! ");
        System.out.println("Here is your current Maze: ");
        myMap.printMap();
    }

    public static String userMove() {
        Scanner input = new Scanner(System.in);
        int moveCount = 0;
        System.out.println("Which direction would you like to move? (R, L, U, D) ");
        String move = input.nextLine().toUpperCase();

        if (move.equals("R")) {
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }
        if (move.equals("L")) {
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("U")) {
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("D")) {
            if (myMap.canIMoveDown()) {
                myMap.MoveDown();
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

}
