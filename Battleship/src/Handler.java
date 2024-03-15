import java.util.Objects;

public class Handler {

    final private boolean DEBUG = true;

    String RESET = "\u001B[0m";

    String HIT_COLOR = "\u001B[31m";
    String HIT_KEY = HIT_COLOR + "X" + RESET;

    String MISS_COLOR = "\u001B[36m";
    String MISS_KEY = MISS_COLOR + "O" + RESET;

    String BOAT_COLOR = "\u001B[32m";
    String BOAT_KEY = BOAT_COLOR + "B" + RESET;


    // display a censored version of the enemies' board
    public void displayHitBoard(String[][] board){

        // top row header
        System.out.println("  0 1 2 3 4 5 6 7 8 9");


        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");

            String [] row = board[i];

            //
            for (int j = 0; j < row.length; j++) {

                // if it equals the boat key, we censor it!
                if (Objects.equals(row[j], BOAT_KEY)){
                    System.out.print("W" + " ");
                }else{
                    System.out.print(row[j] + " ");
                }

            }

            System.out.println();
        }
        System.out.println();


    }

    public boolean checkBoard(String[][] Board){
        boolean winning = false;

        int hits = 0;
        int spots = 0;

        for (int i = 0; i < Board.length; i++) {
            String [] current = Board[i];


            for (int j = 0; j < current.length; j++) {

                if (Objects.equals(current[j], HIT_KEY) || Objects.equals(current[j], BOAT_KEY)){
                    spots++;

                    // check if its equals the boat key
                    if (Objects.equals(current[j], HIT_KEY)){
                        hits++;
                    }

                }


            }
        }


        if (DEBUG){
            System.out.println("HITS : " + hits + "  SPOTS : " + spots);
            System.out.println();
        }

        if (hits==spots){
            winning = true;
        }

        return winning;
    }



    public String checkHit(String[][] board, int row, int pos) {
        String hit = "0";

        String [] chosenRow = board[row];
        String chosenPos = chosenRow[pos];

        // check if we already chose there first
        if (chosenPos.equals(MISS_KEY) || chosenPos.equals(HIT_KEY)){
            // basically we already shot here so whats the point?
            return "2";
        }

        // make the key miss!
        chosenRow[pos] = MISS_KEY;

        // check if we hit the boat
        if (chosenPos.equals(BOAT_KEY)){
            hit = "1";
            chosenRow[pos] = HIT_KEY;
        }

        return  hit;
    }
}
