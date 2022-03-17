import java.util.Scanner;

public class Game {
    public static Game game = new Game();
    public static boolean aLive = true;

    private Board board;


    public void run() throws InterruptedException {
        board = new Board();
        board.printField();

        while (true) {
            drawX();
            board.printField();

            if (board.somebodyWin()) {
                System.out.println("You win!!!");
                break;
            }
            //Thread.sleep(1000);

            board.analysisO();
            board.printField();
            if (board.somebodyWin()) {
                System.out.println("You wOn!!!");
                break;
            }
        }
    }

    private void step() {

    }

    private void drawX() {
        switch (inquiry()) {
            case 1:
                board.setX(0, 0);
                break;
            case 2:
                board.setX(1, 0);
                break;
            case 3:
                board.setX(2, 0);
                break;
            case 4:
                board.setX(0, 1);
                break;
            case 5:
                board.setX(1, 1);
                break;
            case 6:
                board.setX(2, 1);
                break;
            case 7:
                board.setX(0, 2);
                break;
            case 8:
                board.setX(1, 2);
                break;
            case 9:
                board.setX(2, 2);
                break;
        }
    }

    private int inquiry() {
        System.out.println("введите координату (1-9)");

        int resulte = new Scanner(System.in).nextInt();
        return (resulte >= 1 && resulte <= 9) ? resulte : inquiry();
    }

    public static void main(String[] args) throws InterruptedException {
        new Game().run();
    }
}