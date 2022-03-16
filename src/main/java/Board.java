public class Board {
    private static String [][] fild;
    {
        fild = new String [][] {{"+","+","+"}, {"+","+","+"}, {"+","+","+"}};
    }

    public void printField(){
        for(int i = 0; i < fild.length; i++){
            for(int j = 0; j < fild.length; j++){
                System.out.print(fild[j][i]);
            }
            System.out.println();
        }
    }

    public void setX(int j, int i){
        fild[j][i] = "X";
    }

    public void setO(int j, int i){
        fild[j][i] = "O";
    }
}
