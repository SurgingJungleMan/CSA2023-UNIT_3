// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.lang.Math;

public class Main {
   static Scanner sc;

   static double ans_1;
   static double ans_2;

   static double a,b,c;

   static double discrim(double a, double b, double c){
      return Math.pow(b, 2)-((double)4*a*c);
   }

   static void answer(double toBeSQR, double ans_1, double ans_2){
       if (toBeSQR < 0){
           System.out.println("No soloution.");
       }else if (toBeSQR == 0){
           ans_1 = (b*-1.0)/(2*a);
       }else{
           ans_2 = ((b*-1.0) - Math.sqrt(toBeSQR))/(2*a);
           ans_1 = ((b*-1.0) + Math.sqrt(toBeSQR))/(2*a);
       }

       if (ans_1 != 0 && ans_2 != 0){
           System.out.println("Two roots.");
           System.out.println(ans_1 + " " + ans_2);
       }else if (ans_1 != 0){
           System.out.println("One real root.");
           System.out.println(ans_1);
       }

       ask();
   }

   static void ask(){
       System.out.println("What is your A?, (the exponent's base)");
       a = sc.nextDouble();
       System.out.println("What is your B?, (the mutiplier for x)");
       b = sc.nextDouble();
       System.out.println("What is your last number");
       c = sc.nextDouble();

       double toBeSQR = discrim(a, b, c);
       answer(toBeSQR, ans_1, ans_2);
   }

   public static void main( String[] args ){
       ask();
   }




   static {
       sc = new Scanner(System.in);
   }
}