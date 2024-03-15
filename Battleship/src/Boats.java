// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


public class Boats {
    private int size;
    private String[] row;
    private int spot;

    //
    private final boolean DEBUG = true;

    // randomizer
    static Random Dice = new Random();

    //colors
    String RESET = "\u001B[0m";
    String BOAT_COLOR = "\u001B[32m";
    String BOAT_KEY = BOAT_COLOR + "B" + RESET;



    // scanner
    static Scanner sc = new Scanner(System.in);

    // constructor
    public Boats(int size){
        this.size = size;
    }

    // methods
    private Boolean checkSpot(int chosenPos, String [] currentRow){
        boolean works = true;

        for (int i = chosenPos; i < chosenPos + this.size; i++){
            if (chosenPos + this.size > 10){
                works = false;
                break;
            }
            if (Objects.equals(currentRow[i], BOAT_KEY)){
               works = false;
            }
        }
        return works;
    }

    public boolean Randomize(String[][] rows){
        // choose random row
        int chosenRow = Dice.nextInt(rows.length);
        this.row = rows[chosenRow];

        // choose random spot
        this.spot = Dice.nextInt(this.row.length);

        // check if the x,y coordinate works
        boolean works = checkSpot(this.spot, this.row);
        if (works){
            for (int i = this.spot; i < this.spot + this.size; i++){
                this.row[i] = BOAT_KEY;
            }
        }else{
            // Announce errors
            if (DEBUG){
                System.out.println("Error! Rebuilding this boat!");
                System.out.println(chosenRow + "," + this.spot + " >>> incompatible position");
            }

            return  false;
        }


        return  true;
    }



    public boolean Build(String[][] rows){
        // choose the row
        System.out.println("Which row would you like to place your boat on? Size : " + size);
        int chosenRow = sc.nextInt();
        this.row = rows[chosenRow];


        // display the row
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        System.out.print(chosenRow + " ");
        for (int j = 0; j < this.row.length; j++) {
            System.out.print(this.row[j] + " ");
        }

        // spaces
        System.out.println();
        System.out.println();

        // ask for the position?
        System.out.println("Which position would you like to place your boat on?");
        System.out.println("Note the position you place your boat on is the end of your boat.");
        System.out.println("For example, you place your boat on position 1, the next 5 spots will be your boat as well (if your boat is 5 long)");
        int chosenPos = sc.nextInt();


        //check if boat can be placed there correctly
        boolean works = checkSpot(chosenPos, this.row);
        if (works){
            this.spot = chosenPos;
            // place the boat
            for (int i = chosenPos; i < chosenPos + this.size; i++){
                this.row[i] = BOAT_KEY;
            }

        }else{

            if (DEBUG){
                System.out.println("Error! Rebuilding this boat!");
                System.out.println(chosenRow + "," + chosenPos + " >>> incompatible position");
            }


            return  false;
        }

        return true;
    }



    public int getSize() { return  size; }

    public int getPos(){
        return  this.spot;
    }

    public String[] getRow(){
        return  this.row;
    }


}
