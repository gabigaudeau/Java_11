import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();

        String name = name();

        game(name);

        System.out.println("\n****************");
    }

    public static void game(String name) {

        String letter = choose();
        int sum = play();
        result(sum, letter, name);
    }


    public static String name() {
        Scanner input = new Scanner(System.in);

        System.out.println("Let’s play a game called “Odds and Evens !");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.println("Hi " + name + ".");

        return name;
    }


    public static String choose() {
        Scanner input = new Scanner(System.in);

        System.out.print("Which do you choose? (O)dds or (E)vens? ");
        String choice = input.next();

        if (choice.equals("O")) {
            System.out.println("You have picked odds! The computer will be evens.");
        } else if (choice.equals("E")) {
            System.out.println("You have picked even! The computer will be odds.");
        } else {
            System.out.println("You have entered a wrong character, please try again.");
            choose();
        }

        System.out.println("\n****************");
        return choice;
    }

    public static int play() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nHow many \"fingers\" do you put out?");
        int playerNumber = input.nextInt();
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);
        System.out.println("The computer plays " + computerNumber + " \"fingers\".");

        System.out.println("\n****************");

        int sum = playerNumber + computerNumber;
        System.out.println("\n" + playerNumber + " + " + computerNumber + " = " + sum);
        boolean oddOrEven = sum % 2 == 0;

        if (oddOrEven) {
            System.out.println(sum + " is ... even!");
        } else {
            System.out.println(sum + " is ... odd!");
        }

        System.out.println("\n****************");
        return sum;
    }

    public static void result(int sum, String letter, String name) {
        Scanner input = new Scanner(System.in);

        if (((sum % 2 == 0) && letter.equals("E")) || ((sum % 2 == 1) && letter.equals("O")))

            { System.out.println("That means " + name + " wins! Congratulations."); }

        else {

            System.out.println("That means the computer wins !");
            System.out.print("\nDo you wish to try again, \"Yes\" or \"No\"? ");
            String answer = input.nextLine();

            if (answer.equals("Yes")) {
                System.out.println("\n****************\n");
                game(name);
            } else {
                System.out.println("\nBetter luck next time !");
            }

        }
    }

}
