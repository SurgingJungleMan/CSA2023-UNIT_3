import java.util.Scanner;

public class Player extends Handler {
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

    // logic handler...
    Handler logic = new Handler();




    // scanner
    static Scanner sc = new Scanner(System.in);


    //



    //
    public Player(){
        build();
    }


    //
    private void build(){
        // loop through the boats
        for (int i = 0; i < Boats.length; i++) {
            display();
            Boats cur = Boats[i];
            if (cur.getRow() == null){ // check if it has a row

                boolean built = cur.Build(Board);
                while (!built){
                    built = cur.Build(Board);
                }


                display();
            }
        }
    }

    //
    public void display(){
        // top row header
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < Board.length; i++) {
            System.out.print(i + " ");
            String [] current = Board[i];
            for (int j = 0; j < current.length; j++) {
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    //
    public void Play(AI enemy){
        logic.displayHitBoard(enemy.getBoard());


        //
        System.out.print("Which row would you like to fire on? (Scroll up to see your board after the enemy fired)");
        int chosenRow = sc.nextInt();

        System.out.print("Which position would you like to fire on?");
        int chosenPos = sc.nextInt();


        //
        String HIT_KEY = logic.checkHit(enemy.getBoard(), chosenRow, chosenPos);

        if (HIT_KEY.equals("2")){
            System.out.println("You have chosen a hit position, please re choose!");
            Play(enemy);
            return;
        }

        // hit!
        /*



         if (HIT_KEY.equals("1")){

            // miss!
        }else  if (HIT_KEY.equals("0")){

        }

         */


    }


    public String[][] getBoard() {
        return Board;
    }
}
