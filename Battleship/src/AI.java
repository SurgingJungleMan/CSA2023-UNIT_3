import java.util.Objects;
import java.util.Random;

public class AI extends Handler {

    // to print out our debugs!
    private final boolean DEBUG = true;

    //
    String[] a = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] b = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] c = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] d = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] e = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] f = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] g = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] h = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] i = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
    String[] j = new String[]{"W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};


    //
    String[][] Board = new String[][]{a, b, c, d, e, f, g, h, i, j};

    //
    Boats[] Boats = new Boats[]{new Boats(3), new Boats(2), new Boats(1)};

    //
    Handler logic = new Handler();

    //
    static Random Dice = new Random();

    //
    public AI(){
        build();
    }


    //
    private void build(){
        // loop through the boats
        for (int i = 0; i < Boats.length; i++) {
            Boats cur = Boats[i];
            if (cur.getRow() == null){ // check if it has a row

                boolean built = cur.Randomize(Board);
                while (!built){
                    built = cur.Randomize(Board);
                }
                System.out.println(i+1 + " : interation built!");

                display();
            }
        }
    }

    //
    public void display(){

        // to see our enemies board!
        if (!DEBUG){
            return;
        }

        // top row header
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < Board.length; i++) {
            System.out.print(i + " ");
            String [] current = Board[i];
            for (String s : current) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println();
    }






    // part of my ai structure!
    // this returns the row where a hit has previously been on...
    public int chooseRow(String[][]board){
        // loop through the rows
        // if the row has a spot hit not on the edges, we eat away at the nearby spots


        for (String[] chosenRow : Board) {
            for (int j = 0; j < chosenRow.length; j++) {

                // check if its equals the boat key
                if (Objects.equals(chosenRow[j], HIT_KEY)) {
                    return j;
                }

            }
        }


        return Dice.nextInt(board.length);
    }

    // returns a position the enemy chooses
    // based off other hits on the board
    // basically you lose a whole boat if the enemy ai gets his hands on you
    // good luck
    public int choosePos(String[] row){
        int choosenPos = Dice.nextInt(row.length);

        for (int j = 0; j < row.length; j++) {

            // check if its equals the boat key
            if (Objects.equals(row[j], HIT_KEY)){


                int Offset = Dice.nextInt(Math.abs(2));

                // if not at the edge
                // and not hit or miss
                //

                if (Offset == 1 && j < row.length-1 && !row[Offset].equals(logic.MISS_KEY) && !row[Offset].equals(logic.HIT_KEY)){
                    choosenPos = j+1;
                }else if (j <= row.length-1 && j > 0 && !row[Offset].equals(logic.MISS_KEY) && !row[Offset].equals(logic.HIT_KEY)){
                    choosenPos = j-1;
                }

                break;

            }

        }

        return choosenPos;
    }


    public void Play(Player player){
        String[][]board = player.getBoard();

        // choose row
        int row = chooseRow(board);
        String[] chosenRow = board[row];

        // choose position
        int pos = choosePos(chosenRow);

        //
        //
        String HIT_KEY = logic.checkHit(board, row, pos);


        if (HIT_KEY.equals("2")){
            if (DEBUG){
                System.out.println("Chosen already hit position.");
            }
            Play(player);
        }

        // hit!
        /*
        if (HIT_KEY.equals("1")){
            System.out.println(HIT_COLOR + "HIT!" + RESET);

        // miss!
        }else  if (HIT_KEY.equals("0")){}


        */

    }


    //
    public String[][] getBoard() {
        return Board;
    }










}
