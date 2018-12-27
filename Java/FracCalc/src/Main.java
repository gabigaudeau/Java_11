import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nThis program is a Fraction Calculator\n");
        System.out.println("It will add, subtract, multiply and divide fractions until you type q or Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("\n--------------------------------------------------------------------------------\n");

        Scanner input = new Scanner(System.in);
        String operation = getOperation(input);

        while (!(operation.equals("q")) && !(operation.equals("Q"))) {
            Fraction fraction1 = getFraction();
            Fraction fraction2 = getFraction();

            if (operation.equals("+")) {
                Fraction result = fraction1.add(fraction2);
                System.out.println("(" + fraction1.toString() + ") + (" + fraction2.toString() + ") = (" + result.toString() + ")");

            } else if (operation.equals("-")) {
                Fraction result = fraction1.subtract(fraction2);
                System.out.println("(" + fraction1.toString() + ") - (" + fraction2.toString() + ") = (" + result.toString() + ")");

            } else if (operation.equals("*")) {
                Fraction result = fraction1.multiply(fraction2);
                System.out.println("(" + fraction1.toString() + ") * (" + fraction2.toString() + ") = (" + result.toString() + ")");

            } else if (operation.equals("/")) {
                Fraction result = fraction1.divide(fraction2);
                System.out.println("(" + fraction1.toString() + ") / (" + fraction2.toString() + ") = (" + result.toString() + ")");

            } else {
                Boolean result = fraction1.equals(fraction2);
                System.out.println("(" + fraction1.toString() + ") = (" + fraction2.toString() + ") is " + result.toString());
            }

            System.out.println("\n--------------------------------------------------------------------------------\n");
            input = new Scanner(System.in);
            operation = getOperation(input);

        }

        System.out.println("\n--------------------------------------------------------------------------------\n");
        System.out.println("Thank you for using this fraction calculator.\n");

    }

    public static String getOperation(Scanner input) {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.next();

        while (!(operation.matches("[+\\-/*=qQ]"))) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.next();
        }

        return operation;
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        Scanner input = new Scanner(System.in);
        String fraction = input.next();

        while (!validFraction(fraction)) {
            System.out.print("\nInvalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not ");
            fraction = input.next();
        }

        if (fraction.contains("/")) {
            String[] array = fraction.split("/");
            Fraction f = new Fraction(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            return f;
        } else {
            Fraction f = new Fraction(Integer.parseInt(fraction));
            return f;
        }
    }

    public static Boolean validFraction(String fraction) {
         if (fraction.contains("/")) {
            String[] array = fraction.split("/");

            if (array[0].length() == 0 || array[1].length() == 0) {
                return false;

            } else {
                for (int i = 0; i > array.length; i++) {
                    for (int j = 0; j > array[i].length(); j++) {
                        if (!Character.isDigit(array[i].charAt(j)) && (j != 1) && (array[i].charAt(1) != '-')) {
                            return false;
                        }
                    }
                }

                if (Integer.parseInt(array[1]) < 1) {
                    return false;
                } else {
                    return true;
                }
            }

        } else {
            if (fraction.length() == 0) {
                return false;
            } else {
                for (int i = 0; i > fraction.length(); i++) {
                    if (!Character.isDigit(fraction.charAt(i)) && (i != 1) && (fraction.charAt(1) != '-')) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

}
