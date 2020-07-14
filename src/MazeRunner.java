import java.util.Scanner;


public class MazeRunner {
    public static Maze myMap = new Maze();
    public static int moves = 0;

    public static void main(String[] args) {
        intro();
        userMove();
    }

    public static void intro() {
        System.out.println();
        System.out.println("Welcome to Maze Runner! ");
        System.out.println("Here is your current Maze: ");
        myMap.printMap();
        for (int i=0; i<39; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void userMove() {
        System.out.print("Which direction would you like to move? (R, L, U, D) ");
        Scanner input = new Scanner(System.in);
        String move = input.nextLine();
        move = move.toUpperCase();

        if (move.equalsIgnoreCase("R")) {
            moves++;
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        }
        else if (move.equalsIgnoreCase("L")) {
            moves++;
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else {
                System.out.println("Sorry, you've hit a wall.");
            }
        }

        else if (move.equalsIgnoreCase("U")) {
            moves++;
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else {
                System.out.println("Sorry, you've hit a wall.");

            }
        }

        else if (move.equalsIgnoreCase("D")) {
            moves++;
            if (myMap.canIMoveDown()) {
                myMap.moveDown();
            } else {
                System.out.println("Sorry, you've hit a wall.");

            }
        } else {
            System.out.println("Invalid Selection. Please choose from the provided options");
        }
        myMap.printMap();
        movesMessage(moves);
        while (!myMap.didIWin()) {
            navigatePit(move);
            userMove();
        }
    }

    public static void movesMessage(int moveCount) {
        if (moveCount == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moveCount == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moveCount == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moveCount == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.exit(0);
        }
    }

    public static void navigatePit(String m) {
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(m)) {
            System.out.print("Watch out! There's a pit ahead, jump it? (press y to jump the pit) ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("y")) {
                myMap.jumpOverPit(m);
                moves++;
                myMap.printMap();
            }
        }
    }

/*
    public static void endGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("Oh no! It looks like you lost! Would you like to try again? Press y to play again or n to quit");
        String play = input.next();

        if (play.equalsIgnoreCase("y")) {

        }
    }
*/

}