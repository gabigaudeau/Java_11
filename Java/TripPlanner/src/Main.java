import java.util.Scanner;
import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) {
        greet();
        plan();
        time();
        space();
        measure();

        System.out.println("Thank you for using Trip Planner, we hope to see you again soon!");
    }


    public static void greet() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to your Trip Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like an incredible destination.");

        System.out.println("\n****************");
    }

    public static void plan() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nHow many days are you going to spend travelling? ");
        int days = input.nextInt();
        System.out.print("How much money, in GBP, are you planning to spend on your trip? ");
        double money = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currency = input.next();
        System.out.print("How many " + currency + " are there in 1 GBP? ");
        double change = input.nextDouble();

        double hours = (double)(days * 24);
        double minutes = (hours * 60);
        double allowance = round(money / days);
        double currencyMoney = round(money * change);
        double currencyAllowance = round(currencyMoney / days);

        System.out.println("\nIf you are travelling for " + days + " days that is the same as " + hours + " hours or " + minutes + " minutes.");
        System.out.println("If you are going to spend £" + money + " GBP that means per day you can spend up to £" + allowance + " GBP.");
        System.out.println("Your total budget in " + currency + " is " + currencyMoney + " " + currency + ", which per day accounts for " + currencyAllowance + " " + currency + ".");

        System.out.println("\n****************");
    }

    public static void time() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nWhat is the time difference, in hours, between your home and your destination? ");
        int difference = input.nextInt();

        int midnightTime =((24 + difference)% 24);
        int noonTime = (36 + difference)% 24;

        System.out.println("That means that when it is midnight at home, it will be " + midnightTime + ":00 in your travel destination.");
        System.out.println("And when it is noon at home, it will be " + noonTime + ":00.");

        System.out.println("\n****************");
    }

    public static void space() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nWhat is the square area of your destination in km2? ");
        double area = input.nextDouble();

        double areaMiles = round(area * 0.3861);

        System.out.println("In miles2 that is " + areaMiles + ".");

        System.out.println("\n****************");
    }

    public static void measure() {
        Scanner input = new Scanner(System.in);

        System.out.print("\nWhat is the longitude of your home? ");
        double lambdaHome = input.nextDouble();
        lambdaHome = toRadians(lambdaHome);
        System.out.print("What is the latitude of your home? ");
        double phiHome = input.nextDouble();
        phiHome = toRadians(phiHome);
        System.out.print("What is the longitude of your destination? ");
        double lambdaDestination = input.nextDouble();
        lambdaDestination = toRadians(lambdaDestination);
        System.out.print("What is the latitude of your destination? ");
        double phiDestination = input.nextDouble();
        phiDestination = toRadians(phiDestination);

        double distance = round(2 * 6356.752 * asin(sqrt((pow(sin((phiDestination - phiHome)/2),2)) + (cos(phiHome)*cos(phiDestination)*pow(sin((lambdaDestination - lambdaHome)/2),2)))));
        System.out.println("The distance between  your home and your destination is " + distance + "km.");

        System.out.println("\n****************");
    }

}
