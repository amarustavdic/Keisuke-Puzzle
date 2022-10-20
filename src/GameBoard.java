import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel {

    private static int[][] bgMatrix;
    private static int[][] userMatrix;
    private JFrame gameWindow;
    private JButton[][] gBtn;
    private boolean isEndless;
    private int m,n;

    public GameBoard(JFrame gameWindow, int[][] matrix, int[][] usermatrix, int m, int n, boolean isEndless, boolean isLoad) {
        this.isEndless = isEndless;
        this.gameWindow = gameWindow;
        this.bgMatrix = matrix;
        this.userMatrix = usermatrix;
        this.m = m;
        this.n = n;
        this.setLayout(new GridLayout(m,n));

        gBtn = new JButton[m][n];

        //pravi svaki button in dodaje ga na igralno polje
        //ako je broj na tome mestu == -1 onda ce biti crn
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bgMatrix[i][j] == -1) {
                    gBtn[i][j] = new JButton();
                    gBtn[i][j].setBackground(Color.black);
                    gBtn[i][j].setEnabled(false);
                    this.add(gBtn[i][j]);
                }else{
                    gBtn[i][j] = new JButton(" ");
                    gBtn[i][j].setBackground(Color.white);
                    gBtn[i][j].addActionListener(new GameAction());
                    this.add(gBtn[i][j]);
                }
            }
        }

        if (isLoad != false) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (userMatrix[i][j] != -1 && userMatrix[i][j] != 0) {
                        gBtn[i][j].setText(Integer.toString(userMatrix[i][j]));
                    }
                }
            }
        }
    }

    class GameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton gumb = (JButton) e.getSource();

            switch (gumb.getText()) {
                case " ": gumb.setText("1");
                    addValueToTmp(gumb,gBtn,userMatrix,1);
                    break;
                case "1": gumb.setText("2");
                    addValueToTmp(gumb,gBtn,userMatrix,2);
                    break;
                case "2": gumb.setText("3");
                    addValueToTmp(gumb,gBtn,userMatrix,3);
                    break;
                case "3": gumb.setText(" ");
                    addValueToTmp(gumb,gBtn,userMatrix,0);
                    break;
            }

            System.out.println();
            for (int i = 0; i < userMatrix.length; i++) {
                for (int j = 0; j < userMatrix[i].length; j++) {
                    System.out.print(userMatrix[i][j]+" ");
                }
                System.out.println();
            }




            //provjera da li su obe matrice iste kada su iste U won!
            int counter = 0;
            for (int i = 0; i < bgMatrix.length; i++) {
                for (int j = 0; j < bgMatrix[i].length; j++) {
                    if (bgMatrix[i][j] == userMatrix[i][j]) {
                        counter++;
                    }
                }
            }
            if (counter == (m*n)) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        gBtn[i][j].setEnabled(false);
                    }
                }

                if (isEndless == true) {
                    GameWindow nGameWin = new GameWindow(m+1,n+1,isEndless,false);
                    nGameWin.setLocationRelativeTo(gameWindow);
                    gameWindow.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Congratulations! You've solved this puzzle!",
                            "Keisuke Puzzle",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }


    public void addValueToTmp (JButton gumb, JButton[][] buttons, int[][] tmp, int num) {
        for (int i = 0; i < gBtn.length; i++) {
            for (int j = 0; j < gBtn[i].length; j++) {
                //premerjamo
                if ( gumb == gBtn[i][j]) {
                    tmp[i][j] = num;
                }
            }
        }
    }


    public static int[][] getBgMatrix() {
        return bgMatrix;
    }

    public static int[][] getUserMatrix() {
        return userMatrix;
    }
}
