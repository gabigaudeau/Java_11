import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);


       System.out.print("\n\tWelcome to this CaesarCypher application.\n\nWhat is your message? ");
       String a = input.nextLine();

       System.out.print("What shift value do you wish to use? ");
       int shift = input.nextInt();

       System.out.print("What size do you wish your word to be grouped in? ");
       int size = input.nextInt();

       System.out.println("\n***************\n");


       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String cryptoAlphabet = shiftAlphabet(shift);

       String word = encryptString(a, shift, size, alphabet, cryptoAlphabet);
       decryptString(word, alphabet, cryptoAlphabet);

       System.out.println("\tThank you for using the CaesarCypher application! \nSee you again soo!");
       System.out.println("\n***************\n");
   }

    public static String encryptString(String a, int shift, int size, String alphabet, String cryptoAlphabet) {
        a = normalizeText(a);

        char[] ch = a.toCharArray();
        String word = caesar(ch, a,a.length() - 1, cryptoAlphabet, alphabet);
        System.out.println("Your coded word is " + word);
        System.out.println("\n***************\n");

        String groupWord = group(word, size);
        System.out.println("Your grouped word is " + groupWord);
        System.out.println("\n***************\n");

        return groupWord;
    }

   public static String normalizeText(String a) {
       a = a.replaceAll("\\s","");
       a = a.replaceAll("\\W","");
       a = a.toUpperCase();

       return a;
   }

    public static String shiftAlphabet(int shift) {
        int start;

        if (shift < 0) { start = (int) 'Z' + shift + 1; }
        else { start = 'A' + shift; }

        String result = "";
        char currChar = (char) start;

        for(; currChar <= 'Z'; ++currChar) { result = result + currChar; }

        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) { result = result + currChar; }
        }

        return result;
    }

    public static String  caesar(char[] ch, String a, int length, String cryptoAlphabet, String alphabet) {
        if (length == 0) {
            ch[length] = cryptoAlphabet.charAt(alphabet.indexOf(a.charAt(length)));
            String word = String.valueOf(ch);
            return word;

        } else {
            ch[length] = cryptoAlphabet.charAt(alphabet.indexOf(a.charAt(length)));
            return caesar(ch, a,length - 1, cryptoAlphabet, alphabet);
        }
    }

    public static String group(String word, int size) {
       String groupWord = "";

        for (int i = 0 ; i < word.length(); i += size) {

            if (word.length() - 1 < i + size) {
                while (i + size != word.length() - 1){
                    word += "x";
                }

                String part = word.substring(i, i + size);
                groupWord += part;
                break;

            } else {
                String part = word.substring(i, i + size);
                groupWord += part + " ";
            }

        }

       return groupWord;
    }

    public static void decryptString(String a, String alphabet, String cryptoAlphabet) {
        String word = ungroup(a);
        char[] ch = word.toCharArray();

        word = caesar(ch, word, word.length() - 1, alphabet, cryptoAlphabet);
        System.out.println("Your original word was " + word);
        System.out.println("\n***************\n");
    }

    public static String ungroup(String word) {
       word = word.replaceAll(" ", "");
       word = word.replaceAll("x", "");
       return word;
    }
    
}
