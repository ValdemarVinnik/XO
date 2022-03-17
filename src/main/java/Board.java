public class Board {
    private static String[][] fild = new String[][]{{"+", "+", "+"}, {"+", "+", "+"}, {"+", "+", "+"}};
    private boolean full_Line = false;

    public boolean isFull_Line() {
        return full_Line;
    }

    public void printField() {
        for (int i = 0; i < fild.length; i++) {
            for (int j = 0; j < fild.length; j++) {
                System.out.print(fild[j][i]);
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < fild.length; i++) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][i].equals("+")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void analysisO() {
        if (!opportunityForSuccessO() && !repelTheThreatX()) {
            if (fild[1][1].equals("+"))
                fild[1][1] = "O";
            else if (fild[0][0].equals("+"))
                fild[0][0] = "O";
            else if (fild[2][0].equals("+")) fild[2][0] = "O";
            else if (fild[2][2].equals("+"))
                fild[2][2] = "O";
            else if (fild[2][0].equals("+"))
                fild[2][0] = "O";
            else if (fild[0][1].equals("+"))
                fild[0][1] = "O";
            else if (fild[1][2].equals("+"))
                fild[1][2] = "O";
            else if (fild[2][1].equals("+"))
                fild[2][1] = "O";
            else if (fild[1][0].equals("+"))
                fild[1][0] = "O";

        }
    }

    /**
     * дописать проверку столбов
     * создать метод анализа своей позиции
     * @return
     */
    private boolean repelTheThreatX() {
        // 1-й ряд
        int countX = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][0].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][0].equals("+")) {
                    setO(j, 0);
                    return true;
                }
            }
        }

        // 2-й ряд
        countX = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][1].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][1].equals("+")) {
                    setO(j, 1);
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][2].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][2].equals("+")) {
                    setO(j, 2);
                    return true;
                }
            }
        }

        // 1-й столб
        countX = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[0][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[0][i].equals("+")) {
                    setO(0, i);
                    return true;
                }
            }
        }

        // 2-й столб
        countX = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[1][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[1][i].equals("+")) {
                    setO(1, i);
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[2][i].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[2][i].equals("+")) {
                    setO(2, i);
                    return true;
                }
            }
        }

        // главная диагональ
        countX = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][j].equals("+")) {
                    setO(j, j);
                    return true;
                }
            }
        }

        // не главная диагональ
        countX = 0;
        for (int j = fild.length - 1; j > 0; j--) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
        }

        if (countX == 2) {
            for (int j = fild.length - 1; j > 0; j--) {
                if (fild[j][j].equals("+")) {
                    setO(j, j);
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
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][0].equals("X")) {
                countX++;
            }
            if (fild[j][0].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][0].equals("+")) {
                    setO(j, 0);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й ряд
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][1].equals("X")) {
                countX++;
            }
            if (fild[j][1].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][1].equals("+")) {
                    setO(j, 1);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        countPlus = 0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][2].equals("X")) {
                countX++;
            }
            if (fild[j][2].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][2].equals("+")) {
                    setO(j, 2);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 1-й столб
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[0][i].equals("X")) {
                countX++;
            }
            if (fild[0][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[0][i].equals("+")) {
                    setO(0, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 2-й столб
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[1][i].equals("X")) {
                countX++;
            }
            if (fild[1][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[1][i].equals("+")) {
                    setO(1, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // 3-й ряд
        countX = 0;
        countPlus = 0;
        for (int i = 0; i < fild.length; i++) {
            if (fild[2][i].equals("X")) {
                countX++;
            }
            if (fild[2][i].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int i = 0; i < fild.length; i++) {
                if (fild[2][i].equals("+")) {
                    setO(2, i);
                    full_Line = true;
                    return true;
                }
            }
        }

        // главная диагональ
        countX = 0;
        countPlus =0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
            if (fild[j][j].equals("+")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = 0; j < fild.length; j++) {
                if (fild[j][j].equals("+")) {
                    setO(j, j);
                    full_Line = true;
                    return true;
                }
            }
        }

        // не главная диагональ
        countX = 0;
        countPlus = 0;
        for (int j = fild.length - 1; j > 0; j--) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
            if (fild[j][j].equals("O")) {
                countPlus++;
            }
        }

        if (countX == 2 && countPlus == 1) {
            for (int j = fild.length - 1; j > 0; j--) {
                if (fild[j][j].equals("+")) {
                    setO(j, j);
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
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][0].equals("X")) {
                countX++;
            }
            if (fild[j][0].equals("O")) {
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
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][1].equals("X")) {
                countX++;
            }
            if (fild[j][1].equals("O")) {
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
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][2].equals("X")) {
                countX++;
            }
            if (fild[j][2].equals("O")) {
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
        for (int i = 0; i < fild.length; i++) {
            if (fild[0][i].equals("X")) {
                countX++;
            }
            if (fild[0][i].equals("O")) {
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
        for (int i = 0; i < fild.length; i++) {
            if (fild[1][i].equals("X")) {
                countX++;
            }
            if (fild[1][i].equals("O")) {
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
        for (int i = 0; i < fild.length; i++) {
            if (fild[2][i].equals("X")) {
                countX++;
            }
            if (fild[2][i].equals("O")) {
                countO++;
            }
        }

        if (countX == 3 || countO == 3) {
            full_Line = true;
            return true;
        }

        // главная диагональ
        countX = 0;
        countO =0;
        for (int j = 0; j < fild.length; j++) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
            if (fild[j][j].equals("O")) {
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
        for (int j = fild.length - 1; j > 0; j--) {
            if (fild[j][j].equals("X")) {
                countX++;
            }
            if (fild[j][j].equals("O")) {
                countO++;
            }
        }

        if (countX == 3 || countO == 3) {
            full_Line = true;
            return true;
        }
        return false;
    }

    public void setX(int j, int i) {
        fild[j][i] = "X";
    }

    public void setO(int j, int i) {
        fild[j][i] = "O";
    }
}
