// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

import java.util.Objects;
import java.util.Scanner;


public class Boats {
    private int size;
    private String row;
    private int[] positions;

    // Colors
    String RESET = "\u001B[0m";
    String BOAT_COLOR = "\u001B[32m";
    String BOAT_KEY = BOAT_COLOR + "B" + RESET;

    static Scanner sc = new Scanner(System.in);

    public Boats(int size){
        this.size = size;
    }

    private static boolean validSpace(String [][] rows){
        return false;
    }


    private Boolean checkSpot(int chosenPos, String [] currentRow){
        boolean works = true;
        for (int i = chosenPos; i < chosenPos + this.size; i++){
            if (Objects.equals(currentRow[i], BOAT_KEY)){
               works = false;
            }
        }
        return works;
    }

    public void Build(String[][] rows){
        // choose the row
        System.out.println("Which row would you like to place your boat on?");
        int chosenRow = sc.nextInt();
        String [] currentRow = rows[chosenRow];


        // display the row
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        System.out.print(chosenRow + " ");
        for (int j = 0; j < currentRow.length; j++) {
            System.out.print(currentRow[j] + " ");
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
        boolean works = checkSpot(chosenPos, currentRow);
        if (works){

            // place the boat
            for (int i = chosenPos; i < chosenPos + this.size; i++){
                currentRow[i] = BOAT_KEY;
            }


        }else{
            System.out.println("ERROR, BOAT ALREADY IN THAT POSITION!");
            Build(rows);
        }


    }

    public int getSize() { return  size; }

    public int[] getPos(){
        return  positions;
    }

    public String getRow(){
        return  row;
    }


}
