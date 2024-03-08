public class EnemyBoard {

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
    String[][] Rows = new String[][]{a, b, c, d, e, f, g, h, i, j};

    //
    Boats[] Boats = new Boats[]{new Boats(3), new Boats(2), new Boats(5), new Boats(1), new Boats(1)};

    //
    public EnemyBoard(){
        build();
    }


    //
    private void build(){
        // loop through the boats
        for (int i = 0; i < Boats.length; i++) {
            Boats cur = Boats[i];
            if (cur.getRow() == null){ // check if it has a row

                boolean built = cur.Randomize(Rows);
                while (!built){
                    built = cur.Randomize(Rows);
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
        for (int i = 0; i < Rows.length; i++) {
            System.out.print(i + " ");
            String [] current = Rows[i];
            for (int j = 0; j < current.length; j++) {
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //


}
