import java.util.Scanner;

public class Game extends Handler {

    //private Handler logic = new Handler();


    private final boolean DEBUG = true;

    //
    Player plr;
    AI enemy;



    // scanner
    static Scanner sc = new Scanner(System.in);

    public Game(){
        enemy = new AI();
        plr = new Player();
    }

    // check if one player is winning

    public void Win(boolean player, boolean ai){
        if (ai){
            System.out.println("The AI beat you.");
        }else if (player){
            System.out.println("Good job!");
        }
    }



    public void Start(){
        boolean over = false;
        while (!over){

            // displayhitboard of enemy
            // ask where the player would want to shoot
            plr.Play(enemy);
            if (plr.checkBoard(enemy.getBoard())){
                over = true;
                Win(true, false);
            }
            enemy.display();

            // buffer to take a loot at your thing
            System.out.println("Your board! Print anything to continue!");
            sc.nextLine();

            enemy.Play(plr);
            if (enemy.checkBoard(plr.getBoard())){
                over = true;
                Win(false, true);
            }
            plr.display();

            System.out.println("Your board! Print anything to continue!");
            sc.nextLine();
        }

        System.out.println("Try again? [1] = yes [2] == no");
        if(sc.nextInt() == 1){
            Start();
        }

    }
}
