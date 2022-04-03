
public class Game {
    public static Game game;
    public Status status = Status.BEGIN;
    public Board board;
    public Coin coin;
    public boolean isEnd = false;

    public static Game getInstance() {
        return game == null ? game = new Game() : game;
    }

    public boolean getAlive() {

        return !this.board.isFull_Line();
    }

    private Game() {
        this.board = new Board();
    }

    public void restartGame() {
        board.restart();
        status = Status.BEGIN;
        coin = null;
    }

    public void drawX(int i) {
        if (status == Status.BEGIN && status == Status.ATTACK && status == Status.DEFINE_A_QUEUE) return;

        switch (i) {
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

    public void analysisProtection() {

        if (!board.is_step_possible) return;

        if (!board.opportunityForSuccessO() & !board.repelTheThreatX() & !board.mainStrategy()) {
            board.simpleMove();
        }

    }

    public void analysisAttack() {

        if (board.getField()[2][0].equals("+")) {

            board.setO(2, 0);
            return;
        }

        if (status == Status.ATTACK){
            determineAttackStatus();
        }

            if (!board.is_step_possible) return;

        if (!board.opportunityForSuccessO() & !board.repelTheThreatX()) {
            switch (status) {
                case FIRST_ATTACK_WAY:
                    board.firstAttackWay();
                    break;
                case SECOND_ATTACK_WAY:
                    board.secondAttackWay();
                    break;
                case THIRD_ATTACK_WAY:
                    board.thirdAttackWay();
                    break;
                case FOURTH_ATTACK_WAY:
                    board.fourthAttackWay();
                    break;
                case FIFTH_ATTACK_WAY:
                    board.fifthAttackWay();
            }
        }

    }

    public void determineAttackStatus() {

        String[][] field = board.getField();

        if (field[1][0].equals("X") || field[2][1].equals("X")) {
            status = Status.FIRST_ATTACK_WAY;
            return;
        }

        if (field[0][1].equals("X") || field[1][2].equals("X")) {
            status = Status.SECOND_ATTACK_WAY;
            return;
        }

        if (field[0][0].equals("X") || field[2][2].equals("X")) {
            status = Status.THIRD_ATTACK_WAY;
            return;
        }

        if (field[0][2].equals("X")) {
            status = Status.FOURTH_ATTACK_WAY;
            return;
        }

        if (field[1][1].equals("X")) {
            status = Status.FIFTH_ATTACK_WAY;
        }
    }
}