// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;



public class Main {
    static Scanner sc = new Scanner(System.in);

    // automatically defines to even
    // if modulus is not equal to 0, it's uneven
    static boolean checkEven(int length){
        boolean even = true;
        if (length % 2 != 0){
            even = false;
        }
        return  even;
    }

    static void loopThrough(String pali){
        // get length in order to loop through
        int length = pali.length();

        // check what is half of the length
        int half = length/2;

        // this is done to ensure the loops end at the right position
        // i figured this out through guess and cbeck
        boolean even = checkEven(length);
        if (!even){
            half++;
        }


        // to compare halves of the string
        // I was recommended this by intellIJ
        StringBuilder firstHalf = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();



        // source :
        // https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a

        // loop to the halfway point
        for (int i = 0; i < half; i++){
            char c = pali.charAt(i);
            //Store as first half
            firstHalf.append(c);
        }

        // loop reverse
        // It took a lot of guess and check to see where I wanted the loop to stop

        // remove 1 again to get the right place to end
        // this was figured out with guess and check
        if (!even){
            half--;
        }

        // end when "i" is equal to half
        for (int i = (length-1); i >= (half); i--){
            char c = pali.charAt(i);
            //Store as second half
            secondHalf.append(c);
        }


        // Print it out!
        int isPali = firstHalf.compareTo(secondHalf);
        if (isPali == 0){
            System.out.println("Is palidrone!");
        }else{
            System.out.println("Not palidrone!");
        }

        //
        System.out.println(firstHalf);
        System.out.println(secondHalf);

        ask();

    }

    // method to format string correctly
    static String formatString(String format){
        // remove spaces first
        format = format.replaceAll("\\s{2,}"," ");

        // remove special characters
        format = format.replaceAll("[^a-zA-Z]", "");

        // lower case the answer
        format = format.toLowerCase();

        return  format;
    }

    static void ask(){
        System.out.println("Would you like to check a palindrone. (y/n)");
        String answer = sc.nextLine();
        answer = formatString(answer);

        if (answer.compareTo("y") == 0){

            // start asking
            System.out.println("What is your palindrome?");

            // Note : Using next line fixed an error where half the word
            // was deleted trying to remove the spaces
            String pali = sc.nextLine();
            pali = formatString(pali);

            loopThrough(pali);
        }
    }


    public static void main(String[] args) {
        ask();
    }
}