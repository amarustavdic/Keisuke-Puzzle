import java.util.Random;

public class Matrix {

    private static int[][] bgMatrix;
    private static int[][] userMatrix;

    public Matrix(int m, int n) {
        bgMatrix = new int[m][n];
        userMatrix = new int[m][n];

        //generise brojeve u pozadinskoj matrici od 0 - 3
        Random rnd = new Random();
        for (int i = 0; i < bgMatrix.length; i++) {
            for (int j = 0; j < bgMatrix[i].length; j++) {
                int x = rnd.nextInt(4);
                if (x == 0) bgMatrix[i][j] = 1;
                else bgMatrix[i][j] = x;
            }
        }
        //generise crna polja (dodaje -1 v matrici na mesta gde ce posle biti crno polje
        int counter = ((m*n)/5);
        while(counter > 0){
            int x = rnd.nextInt(m);
            int y = rnd.nextInt(n);
            if (ok(x,y) == true) {
                bgMatrix[x][y] = -1;
                counter--;
            }
        }

        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                if (bgMatrix[i][j] == -1) userMatrix[i][j] = -1;
                else userMatrix[i][j] = 0;
            }
        }






        //samo shecking da li su matrice ok generisane
        for (int i = 0; i < bgMatrix.length; i++) {
            for (int j = 0; j < bgMatrix[i].length; j++) {
                System.out.print(bgMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                System.out.print(userMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //metode koje checkiraju da li moze polje da se farba v crno
    //da se ne dogadja da imas jedan broj v across i down
    //zapravo -1 u matrici je crno polje
    private boolean ok(int i, int j) {

        if(bgMatrix[i][j] == -1)return false;
        if (i-1 >= 0 && !check(i-1,j)) return false;
        if (i+1 < bgMatrix.length && !check(i+1,j)) return false;
        if (j-1 >= 0 && !check(i,j-1)) return false;
        if (j+1 < bgMatrix.length && !check(i,j+1)) return false;

        return true;
    }


    private boolean check(int i, int j) {
        if ( bgMatrix[i][j] == -1) return false;

        int counter = 0;
        if (i-1 < 0 || bgMatrix[i-1][j] == -1) counter++;
        if (i+1 > bgMatrix.length-1 || bgMatrix[i+1][j] == -1) counter++;
        if (j-1 < 0 || bgMatrix[i][j-1] == -1) counter++;
        if (j+1 > bgMatrix.length-1 || bgMatrix[i][j+1] == -1) counter++;

        if (counter == 3) return false;
        else return true;
    }









    public static int[][] getBgMatrix() {
        return bgMatrix;
    }
    public static int[][] getUserMatrix() {
        return userMatrix;
    }
}