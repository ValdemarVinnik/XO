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
            if (board.isFull()) {
                System.out.println("Nobody wins...");
                break;
            }
            Thread.sleep(1000);

            board.analysisO();
            board.printField();
            if (board.somebodyWin()) {
                System.out.println("You wOn!!!");
                break;
            }
            if (board.isFull()) {
                System.out.println("Nobody wins...");
                break;
            }
        }
    }

    private void drawX() {
        switch (inquiry()) {
            case 1:
                if (!board.setX(0, 0)) {
                    drawX();
                }
                break;
            case 2:
                if (!board.setX(1, 0)) {
                    drawX();
                }
                break;
            case 3:
                if (!board.setX(2, 0)) {
                    drawX();
                }
                break;
            case 4:
                if (!board.setX(0, 1)) {
                    drawX();
                }
                break;
            case 5:
                if (!board.setX(1, 1)) {
                    drawX();
                }
                break;
            case 6:
                if (!board.setX(2, 1)) {
                    drawX();
                }
                break;
            case 7:
                if (!board.setX(0, 2)) {
                    drawX();
                }
                break;
            case 8:
                if (!board.setX(1, 2)) {
                    drawX();
                }
                break;
            case 9:
                if (!board.setX(2, 2)) {
                    drawX();
                }
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