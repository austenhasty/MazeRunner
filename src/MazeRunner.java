import java.util.Scanner;


public class MazeRunner {
    Maze myMap = new Maze();

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
        Scanner input = new Scanner(System.in);
        int userMoves = 0;
        System.out.println("Which direction would you like to move? (R, L, U, D) ");
        String move = input.nextLine().toUpperCase();

        if (move.equals("R")) {
            userMoves++;
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }
        if (move.equals("L")) {
            userMoves++;
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("U")) {
            userMoves++;
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else {
                System.out.println("Sorry, you've hit a wall.");
                System.out.print("Please make another selection: ");
                move = input.nextLine().toUpperCase();
            }
        }

        if (move.equals("D")) {
            userMoves++;
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
