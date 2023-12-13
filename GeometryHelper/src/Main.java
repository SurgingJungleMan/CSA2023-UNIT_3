// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.lang.Math;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void polygon(){
        System.out.println("What is [the length] one side of the polygon?");
        double L = sc.nextDouble();

        System.out.println("What is the number of sides?");
        double N = sc.nextDouble();

        // I had no idea what the fomrula was, I found this on quora
        // https://www.quora.com/What-is-the-formula-to-find-the-area-of-polygon-having-n-sides

        double area = Math.pow((N * L), 2)/(4 * Math.tan(Math.PI/N));
        System.out.println("This is your area = " + area);
    }

    static void circle(){
        System.out.println("What is the radius (diameter/2)?");
        double r = sc.nextDouble();

        double area = Math.PI * Math.pow(r, 2);
        System.out.println("This is your area = " + area);
    }

    static void heron(){
        System.out.println("Base and Length unknown, herons formula is now used.");

        System.out.println("What is the top length?");
        double a = sc.nextDouble();

        System.out.println("What is the right length?");
        double b = sc.nextDouble();

        System.out.println("What is the left length?");
        double c = sc.nextDouble();

        double s = (a+b+c)/2;
        double area = Math.sqrt(s*(s  -a)*(s - b)*(s -c ));

        System.out.println("This is your area with heron's formula = " + area);
    };

    static  void triangle(){
        System.out.println("What is the base of your triangle? [0] if you don't know");
        double b = sc.nextDouble();

        System.out.println("What is the length? [0] if you don't know");
        double l = sc.nextDouble();

        if (b == 0 || l == 0){
         heron();
        }else{
            double area = (b*l)/2;
            System.out.println("The area is = " + area);
        }
    }

    static void rectangle(){
        System.out.println("What is the width.");
        double w = sc.nextDouble();

        System.out.println("What is the length.");
        double l = sc.nextDouble();

        double area = l*w;
        System.out.println("Area is = " + area);
    }


    static void ask(){
        System.out.println("Which shape would you like to get the area of?");
        System.out.println("Rectangle [1]");
        System.out.println("Circle [2]");
        System.out.println("Triangle [3]");
        System.out.println("N-Polygons [4]");

        int choi = sc.nextInt();

        if (choi == 1){
            rectangle();
        }else if (choi == 2){
            circle();
        }else if (choi == 3){
            triangle();
        }else if (choi == 4){
            polygon();
        }


        ask();
    }


    public static void main(String[] args) {
        ask();
    }
}