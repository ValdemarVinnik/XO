public class Board {
    private static String[][] field = new String[][]{{"+", "+", "+"}, {"+", "+", "+"}, {"+", "+", "+"}};
    private boolean full_Line = false;

    public boolean isFull_Line() {
        return full_Line;
    }

    public String[][] getField() {
        return field;
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
        if (!opportunityForSuccessO() && !repelTheThreatX()) {
            if (field[1][1].equals("+"))
                field[1][1] = "O";
            else if (field[0][0].equals("+"))
                field[0][0] = "O";
            else if (field[2][0].equals("+")) field[2][0] = "O";
            else if (field[2][2].equals("+"))
                field[2][2] = "O";
            else if (field[2][0].equals("+"))
                field[2][0] = "O";
            else if (field[0][1].equals("+"))
                field[0][1] = "O";
            else if (field[1][2].equals("+"))
                field[1][2] = "O";
            else if (field[2][1].equals("+"))
                field[2][1] = "O";
            else if (field[1][0].equals("+"))
                field[1][0] = "O";

        }
    }

    /**
     * дописать проверку столбов
     * создать метод анализа своей позиции
     *
     * @return
     */
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

    private boolean opportunityForSuccessO() {
        // 1-й ряд
        int countX = 0;
        int countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][0].equals("X")) {
                countX++;
            }
            if (field[j][0].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][0].equals("+")) {
                    setO(j, 0);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й ряд
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][1].equals("X")) {
                countX++;
            }
            if (field[j][1].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][1].equals("+")) {
                    setO(j, 1);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][2].equals("X")) {
                countX++;
            }
            if (field[j][2].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][2].equals("+")) {
                    setO(j, 2);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 1-й столб
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[0][i].equals("X")) {
                countX++;
            }
            if (field[0][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[0][i].equals("+")) {
                    setO(0, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й столб
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[1][i].equals("X")) {
                countX++;
            }
            if (field[1][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[1][i].equals("+")) {
                    setO(1, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[2][i].equals("X")) {
                countX++;
            }
            if (field[2][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < field.length; i++) {
                if (field[2][i].equals("+")) {
                    setO(2, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // главная диагональ
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][j].equals("X")) {
                countX++;
            }
            if (field[j][j].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < field.length; j++) {
                if (field[j][j].equals("+")) {
                    setO(j, j);
                    full_Line = true;
                    return true;
                }
            }
        }

        // не главная диагональ
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < field.length; j++) {
            if (field[j][field.length - (j + 1)].equals("X")) {
                countX++;
            }
            if (field[j][j].equals("O")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
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

        if (countX == 3 || countO == 3) {
            full_Line = true;
            return true;
        }
        return false;
    }

    public boolean setX(int j, int i) {
        if (field[j][i].equals("+")) {
            field[j][i] = "X";
            return true;
        }
        return false;
    }

    public boolean setO(int j, int i) {
        if (field[j][i].equals("+")) {
            field[j][i] = "O";
            return true;
        }
        return false;
    }
}
