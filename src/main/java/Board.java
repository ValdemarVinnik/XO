public class Board {
    private static String[][] fild = new String[][]{{"+", "+", "+"}, {"+", "+", "+"}, {"+", "+", "+"}};


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
        if (!repelTheThreatX()) {
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

    public void setX(int j, int i) {
        fild[j][i] = "X";
    }

    public void setO(int j, int i) {
        fild[j][i] = "O";
    }
}
