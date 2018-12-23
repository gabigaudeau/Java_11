import java.util.Scanner;

public class Main {

    static int length = 0;
    static int a;
    static String longName = null;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
	    name(console, 5);

    }

    public static String name(Scanner console, int names) {

        for(int i = 1; i <= names; i++) {

            String name = console.next();
            return("name #" + i + "? " + name);

            if (name.length() > length) {
                length = name.length();
                longName = name;
                a = 0;
            } else if (name.length() == length) {
                a = 1;
            }

        }

        longName = longName.toLowerCase();
        String[] cases = longName.split("");
        cases[0] = cases[0].toUpperCase();

        StringBuilder builder = new StringBuilder();

        for (String string : cases) {
            builder.append(string);
        }

        String string = builder.toString();

        return(string + "'s name is longest");

        if (a > 0) {
            return("(There was a tie!)");
        }
    }
}

//    public static void longestName(Scanner console, int numOfNames) {
//        System.out.print("name #1? ");
//        String name = console.next();
//        boolean tie = false;
//        int maxLength = name.length();
//        String longestName = name.toLowerCase();
//
//        for (int i = 2; i <= numOfNames; i++) {
//            System.out.printf("name #%d? ", i);
//            name = console.next();
//            if (name.length() > maxLength) {
//                maxLength = name.length();
//                longestName = name.toLowerCase();
//                tie = false;
//            } else if (name.length() == maxLength){
//                tie = true;
//            }
//        }
//
//        longestName = longestName.substring(0,1).toUpperCase() + longestName.substring(1);
//        System.out.println(longestName + "'s name is longest");
//
//        if (tie == true) {
//            System.out.println("(There was a tie!)");
//        }
//    }
