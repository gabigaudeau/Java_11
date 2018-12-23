import java.util.*;
import java.lang.*;

public class Main {

    static Maze myMap = new Maze();

    public static void main(String[] args) {
        System.out.println("\n\tWelcome to Maze Runner!\n\nHere is your current position: ");
        boolean gameTest = false;
        int nbMoves = 0;

        while ((!gameTest) && (nbMoves <= 100)) {
            System.out.println("\nWhere would you like to move? Right, Left, Up or Down. (R, L, U, D)\n");
            gameTest = userMove(nbMoves);
            nbMoves++;
            System.out.println("Move number : " + nbMoves);
            movesMessage(nbMoves);
        }

        if (gameTest) { System.out.println("\n\t************************************\n\nCongratulations, you made it out alive! And you did it in " + nbMoves + "moves"); }
        else { System.out.println("\n\t************************************\n\nSorry, but you didn't escape in time- you lose!"); }
    }

    public static boolean userMove(int nbMoves) {
        myMap.printMap();
        Scanner input = new Scanner(System.in);
        String move = input.next();
        int moves = nbMoves;

            if ((move.equals("R")) || (move.equals("L")) || (move.equals("U")) || (move.equals("D"))) {
                boolean test = test(move);

                if (!test) {
                    int number = navigatePit(move);

                    if (number == 0) {
                        return myMap.didIWin();
                    } else if (number == 1){
                        return userMove(nbMoves);
                    } else {
                        System.out.println("\nSorry, you hit a wall. Please choose another direction. Right, Left, Up or Down. (R, L, U, D)\n");
                        return myMap.didIWin();
                    }
                }

            } else {
                System.out.println("\nSorry, you have entered a wrong character. Please choose a correct direction. Right, Left, Up or Down. (R, L, U, D)\n");
                return userMove(moves);
            }

        return myMap.didIWin();
    }

    public static boolean test(String move) {
        switch (move) {
            case "R":
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    return true;
                } else {

                    return false;
                }
            case "L":
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    return true;
                } else {
                    return false;
                }
            case "U":
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    return true;
                } else {
                    return false;
                }
            case "D":
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    return true;
                } else {
                    return false;
                }
        }

        return false;
    }

    public static int navigatePit(String  move) {
        Scanner input = new Scanner(System.in);

        if (myMap.isThereAPit(move)) {
            System.out.print("\nWatch out! There's a pit ahead, jump it? ");
            String answer = input.nextLine();
            answer = String.valueOf(answer.charAt(0));

            if (answer.equals("y")) {
                myMap.jumpOverPit(move);
                return 0;
            } else { return 1; }
        } else { return 2; }

    }

    public static void movesMessage(int nbMoves) {
        switch (nbMoves) {
            case 50 :
                System.out.println("\n\tWarning: You have made 50 moves, you have 50 remaining before the maze exit closes.");
                break;
            case 75 :
                System.out.println("\n\tAlert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90 :
                System.out.println("\n\tDANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100 :
                System.out.println("\tOh no! You took too long to escape, and now the maze exit is closed FOREVER! >:[");
                break;
        }
    }

}
