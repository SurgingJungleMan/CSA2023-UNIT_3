/*

Tien Doan
Period 2
AP CSA
12/20/23


*/

import java.util.Scanner;


public class Main {
    public static Scanner sc = new Scanner(System.in);

    // https://stackoverflow.com/questions/24908860/using-return-in-try-block-java
    // https://www.studytonight.com/java-examples/check-if-input-is-integer-in-java
    public static boolean checkFormat(String input){
        boolean works = false;
        try {
            Integer.parseInt(input);
            works = true;
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number.");
        }

        return works;
    }

    public static boolean checkLogic(int wins, int total){
        boolean works = true;

        if (wins > total){
            System.out.println("Total wins more than total games.");
            works = false;
        }

        if (total <= 0){
            System.out.println("Total games played less than 0.");
            works = false;
        }

        if (wins < 0){
            System.out.println("Total wins must be more or equal to 0.");
            works = false;
        }

        return works;
    }

    public static void ask(){
        System.out.println("How many games have you played??");
        String total = sc.nextLine();

        System.out.println("How many wins do you have?");
        String wins = sc.nextLine();

        if (checkFormat(total) && checkFormat(wins)){
            

            checkLogic(Integer.parseInt(wins), Integer.parseInt(total));
        }
    }


    public static void main(String[] args) {
        ask();
    }
}