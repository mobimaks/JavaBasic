import java.util.Scanner;

/**
 * Created by mobimaks on 01.07.2014.
 */
public class Game {

    private final String APP_NUMBER = "6159";
    private int steps = 1;
    private boolean gameOver = false;

   public void startGame() {
        System.out.println("Start game. Set your number:");
        while (!gameOver){
            check(readValue());
            steps++;
        }
    }

    private void check(String v) {
        int[] value = castToArray(v), appValue = castToArray(APP_NUMBER);
        int bulls = 0, cows = 0;

        for (int i = 0; i < appValue.length; i++){
            if (value[i] == appValue[i]){
                bulls++;
            }
            for (int j = 0; j < value.length; j++){
                if (appValue[i] == value[j]){
                    cows++;
                    break;
                }
            }
        }
        cows -= bulls;
        if (bulls == appValue.length){
            System.out.print("Winner! Your number is " + v + "! You made " + steps + " steps");
            gameOver = true;
        } else {
            System.out.println(bulls + " bulls, " + cows + " cows");
            gameOver = false;
        }
    }

    private int[] castToArray(String v) {
        int[] value = new int[v.length()];
        for (int i = 0; i < value.length; i++){
            value[i] = Integer.parseInt(String.valueOf(v.charAt(i)));
        }
        return value;
    }

    private String readValue(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}
