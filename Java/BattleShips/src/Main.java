import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\n\t**** Welcome to Battle Ships game ****\n");

        System.out.println("Right now, the sea is empty...\n");
        char[][] map = new char[12][16];
        oceanMap(map);

        int shipCounter = 1;
        System.out.println("\nDeploy your ships: \n");
        userDeploy(map, shipCounter);
        System.out.println("Computer is deploying ships: \n");
        computerDeploy(map, shipCounter);

        int[] score = {5, 5};
        while ((score[0] != 0) && (score[1] != 0)) {
            System.out.println(score[1]);
            battle(map, score);
        }
        if (score[0] == 0) {
            System.out.println("\n\t - GAME OVER - \nThe computer has destroyed all your ships.");
        } else {
            System.out.println("\t - YOU WIN - \nHooray! You win the battle.");
        }
    }


    public static void oceanMap(char[][] map) {
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 16; col++) {

                if ((row == 0) || (row == 11)) {
                    if (!((col > 2) && (col < 13))) {
                        map[row][col] = ' ';
                    } else {
                        map[row][col] = Character.forDigit(col - 3, 10);
                    }
                }

                else if ((col == 2) || (col == 13)) { map[row][col] = '|'; }
                else if ((col == 0) || (col == 15)) { map[row][col] = Character.forDigit(row - 1, 10); }
                else {  map[row][col] = ' '; }

                System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }

    public static void printMap(char[][] map) {
        System.out.println("\n");
        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 16; col++) {
                if (map[row][col] != '*') {
                    System.out.print(map[row][col]);
                }
            }
            System.out.println();
        }
    }

    public static char[][] userDeploy(char[][] map, int shipCounter) {
        Scanner input = new Scanner(System.in);

        try {
            if (shipCounter < 6) {
                System.out.print("Enter X coordinate for your " + shipCounter + ". ship: ");
                int x = input.nextInt();
                System.out.print("Enter Y coordinate for your " + shipCounter + ". ship: ");
                int y = input.nextInt();

                if ((map[x + 1][y + 3] == ' ') && (x >= 0) && (x <= 9) && (y >= 0) && (y <= 9)) {
                    map[x + 1][y + 3] = '@';
                    return userDeploy(map, shipCounter + 1);
                } else {
                    System.out.println("\nYou cannot place two ships on the same location. Please choose again.\n");
                    return userDeploy(map, shipCounter);
                }
            } else {
                printMap(map);
                System.out.println("\n----------------------------------------\n");
                return map;
            }
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("\nYou can only place ships inside the 10 by 10 grid. Please choose again.\n");
            return userDeploy(map, shipCounter);
        }

    }

    public static char[][] computerDeploy(char[][] map, int shipCounter) {
        Random rand = new Random();

        if (shipCounter < 6) {
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);

            if ((map[row + 1][col + 3] == ' ') && (row >= 0) && (row <= 9) && (col >= 0) && (col <= 9)) {
                map[row + 1][col + 3] = '*';
                System.out.println(shipCounter + ". ship DEPLOYED");
                return computerDeploy(map, shipCounter + 1);
            } else {
                return computerDeploy(map, shipCounter);
            }
        }

        printMap(map);
        System.out.println("\n----------------------------------------\n");
        return map;
    }

    public static int[] battle(char[][] map, int[] score) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\t - YOUR TURN - \nTry guessing where the computer's ships are hiding.\n");
        System.out.print("Enter X coordinate: ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate: ");
        int y = input.nextInt();

        try {
            if (map[x + 1][y + 3] == '*') {
                System.out.println("Boom! You sunk one of computer's ships!\n");
                map[x + 1][y + 3] = '!';
                score[1]--;
            } else if (map[x + 1][y + 3] == '@') {
                System.out.println("Oh no, you sunk your own ship... :(\n");
                map[x + 1][y + 3] = 'x';
                score[0]--;
            } else if ((x >= 0) && (x <= 9) && (y >= 0) && (y <= 9)) {
                System.out.println("Sorry, you missed.\n");
                map[x + 1][y + 3] = '-';
            }
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("\nYou can only place ships inside the 10 by 10 grid. Please choose again.\n");
            return battle(map, score);
        }

        System.out.println("\t - COMPUTER'S TURN - ");
        int state = 0;
        while (state == 0) {
            int row = rand.nextInt(10);
            int col = rand.nextInt(10);

            if (map[row + 1][col + 3] == '@') {
                System.out.println("The Computer sunk one of your ships!\n");
                map[row + 1][col + 3] = 'x';
                score[0]--;
                state++;
            } else if (map[row + 1][col + 3] == '*') {
                System.out.println("The Computer sunk one of its own ships\n");
                map[row + 1][col + 3] = '!';
                score[1]--;
                state++;
            } else if ((row >= 0) && (row <= 9) && (col >= 0) && (col <= 9)) {
                System.out.println("Computer missed.\n");
                map[row + 1][col + 3] = '-';
                state++;
            }
        }

        printMap(map);
        System.out.println("\nYour ships: " + score[0] + " | Computer ships: " + score[1]);
        System.out.println("\n----------------------------------------\n");
        return score;
    }

}




