public class Board {
    private static String[][] field = new String[][]{{"+", "+", "+"}, {"+", "+", "+"}, {"+", "+", "+"}};
    private boolean full_Line = false;
    public boolean is_step_possible;
    private boolean is_X_win = false;
    private boolean is_O_win = false;
    private int line_winner = 0;

    public int getLine_winner() {
        return line_winner;
    }

    public boolean getIs_X_win() {
        return is_X_win;
    }

    public boolean getIs_O_win() {
        return is_O_win;
    }

    public boolean isFull_Line() {
        return full_Line;
    }

    public String[][] getField() {
        return this.field;
    }

    public void restart(){
        field = new String[][]{{"+", "+", "+"}, {"+", "+", "+"}, {"+", "+", "+"}};
        is_step_possible = false;
        full_Line = false;
        is_O_win = false;
        is_X_win = false;
        line_winner = 0;
    }

    public void printField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][i].equals("+")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void analysisO() {
        if (!is_step_possible) return;
        if (!opportunityForSuccessO() & !repelTheThreatX() & !mainStrategy()) {

            if (field[0][0].equals("+"))
                setO(0, 0);
            else if (field[2][2].equals("+"))
                setO(2, 2);
            else if (field[2][0].equals("+"))
                setO(2, 0);
            else if (field[0][1].equals("+"))
                setO(0, 1);
            else if (field[1][2].equals("+"))
                setO(1,2);
            else if (field[2][1].equals("+"))
                setO(2,1);
            else if (field[1][0].equals("+"))
                setO(1, 0);
            else if (field[1][1].equals("+"))
                setO(1, 1);

        }
    }


    private boolean repelTheThreatX() {
        // 1-й ряд
        int countX = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][0].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][0].equals("+")) {
                    setO(j, 0);
                    return true;
                }
            }
        }

        // 2-й ряд
        countX = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][1].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][1].equals("+")) {
                    setO(j, 1);
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][2].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][2].equals("+")) {
                    setO(j, 2);
                    return true;
                }
            }
        }

        // 1-й столб
        countX = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[0][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < field.length; i++) {
                if (field[0][i].equals("+")) {
                    setO(0, i);
                    return true;
                }
            }
        }

        // 2-й столб
        countX = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[1][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < field.length; i++) {
                if (field[1][i].equals("+")) {
                    setO(1, i);
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[2][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < field.length; i++) {
                if (field[2][i].equals("+")) {
                    setO(2, i);
                    return true;
                }
            }
        }

        // главная диагональ
        countX = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][j].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][j].equals("+")) {
                    setO(j, j);
                    return true;
                }
            }
        }

        // не главная диагональ
        countX = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][field.length - (j + 1)].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][field.length - (j + 1)].equals("+")) {
                    setO(j, field.length - (j + 1));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean mainStrategy() {
        if (field[0][0].equals("X") && field[2][2].equals("+")) {
            if (field[1][2].equals("+")) {
                return setO(1, 2);
            }
            if (field[2][1].equals("+")) {
                return setO(2, 1);
            }
        }

        if (field[0][2].equals("X") && field[2][0].equals("+")) {
            if (field[1][0].equals("+")) {
                return setO(1, 0);
            }
            if (field[1][2].equals("+")) {
                return setO(2, 1);
            }
        }

        if (field[2][2].equals("X") && field[0][0].equals("+")) {
            if (field[0][1].equals("+")) {
                return setO(0, 1);
            }
            if (field[1][0].equals("+")) {
                return setO(1, 0);
            }
        }

        if (field[2][0].equals("X") && field[0][2].equals("+")) {
            if (field[0][1].equals("+")) {
                return setO(0, 1);
            }
            if (field[1][2].equals("+")) {
                return setO(1, 2);
            }
        }
        return false;
    }

    private boolean opportunityForSuccessO() {
        // 1-й ряд
        int countO = 0;
        int countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][0].equals("O")) {
                countO++;
            }
            if (field[j][0].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][0].equals("+")) {
                    setO(j, 0);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й ряд
        countO = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][1].equals("O")) {
                countO++;
            }
            if (field[j][1].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][1].equals("+")) {
                    setO(j, 1);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countO = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][2].equals("O")) {
                countO++;
            }
            if (field[j][2].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][2].equals("+")) {
                    setO(j, 2);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 1-й столб
        countO = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[0][i].equals("O")) {
                countO++;
            }
            if (field[0][i].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[0][i].equals("+")) {
                    setO(0, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й столб
        countO = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[1][i].equals("O")) {
                countO++;
            }
            if (field[1][i].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[1][i].equals("+")) {
                    setO(1, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countO = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[2][i].equals("O")) {
                countO++;
            }
            if (field[2][i].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[2][i].equals("+")) {
                    setO(2, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // главная диагональ
        countO = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][j].equals("O")) {
                countO++;
            }
            if (field[j][j].equals("+")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][j].equals("+")) {
                    setO(j, j);
                    full_Line = true;
                    return true;
                }
            }
        }

        // не главная диагональ
        countO = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][field.length - (j + 1)].equals("O")) {
                countO++;
            }
            if (field[j][j].equals("O")) {
                countPlus++;
            }
        }

        if (countO == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][field.length - (j + 1)].equals("+")) {
                    setO(j, field.length - (j + 1));
                    full_Line = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean somebodyWin() {
        // 1-й ряд
        int countX = 0;
        int countO = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][0].equals("X")) {
                countX++;
            }
            if (field[j][0].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 1;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 1;
            return true;
        }

        // 2-й ряд
        countX = 0;
        countO = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][1].equals("X")) {
                countX++;
            }
            if (field[j][1].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 2;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 2;
            return true;
        }

        // 3-й ряд
        countX = 0;
        countO = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][2].equals("X")) {
                countX++;
            }
            if (field[j][2].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 3;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 3;
            return true;
        }

        // 1-й столб
        countX = 0;
        countO = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[0][i].equals("X")) {
                countX++;
            }
            if (field[0][i].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 4;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 4;
            return true;
        }

        // 2-й столб
        countX = 0;
        countO = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[1][i].equals("X")) {
                countX++;
            }
            if (field[1][i].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 5;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 5;
            return true;
        }

        // 3-й ряд
        countX = 0;
        countO = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[2][i].equals("X")) {
                countX++;
            }
            if (field[2][i].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 6;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 6;
            return true;
        }

        // главная диагональ
        countX = 0;
        countO = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][j].equals("X")) {
                countX++;
            }
            if (field[j][j].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 7;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 7;
            return true;
        }

        // не главная диагональ
        countX = 0;
        countO = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][field.length - (j + 1)].equals("X")) {
                countX++;
            }
            if (field[j][field.length - (j + 1)].equals("O")) {
                countO++;
            }
        }

        if (countX == 3) {
            is_X_win = true;
            full_Line = true;
            line_winner = 8;
            return true;
        }

        if (countO == 3) {
            is_O_win = true;
            full_Line = true;
            line_winner = 8;
            return true;
        }
        return false;
    }

    public boolean setX(int j, int i) {
        if (field[j][i].equals("+") && !full_Line) {
            field[j][i] = "X";
            is_step_possible = true;
            return true;
        }
        return false;
    }

    public boolean setO(int j, int i) {
        if (field[j][i].equals("+") && !full_Line && is_step_possible) {
            field[j][i] = "O";
            is_step_possible = false;
            return true;
        }
        return false;
    }
}
