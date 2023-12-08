import java.util.Scanner;
import java.lang.Math;




// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner sc = new Scanner(System.in);


    public static double getTimeDiff(){
        double timeDiff;
        // time diff with hours and minutes to seconds

        System.out.println("How many hours has it been since the post was sent?");
        timeDiff = sc.nextDouble() * 60 * 60;

        System.out.println("How many minutes (if its just hours enter 0)");
        timeDiff = timeDiff + (sc.nextDouble() * 60);

        return  timeDiff;
    }
    // get difference between up votes and down votes
    public static double getX(){
        double downs;
        double ups;

        System.out.println("How many up votes?");
        ups = sc.nextDouble();

        System.out.println("How many down votes?");
        downs = sc.nextDouble();

        return ups - downs;
    }

    public static void main(String[] args) {
        double y = 0;
        double z = 0;

        double timeDiff = getTimeDiff();
        double x = getX();


        if (x > 0){
            y = 1;
        }else if (x == 0){
            y = 0;
        }else if (x < 0){
            y = -1;
        }

        if (Math.abs(x) >= 1){
            z = Math.abs(x);
        }else if (Math.abs(x)<1){
            z = 1;
        }

        double results = Math.log10(z) + ((y*timeDiff)/45000);
        System.out.println("Hot category rating : " + results);
    }
}