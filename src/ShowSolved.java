import javax.swing.*;
import java.awt.*;

public class ShowSolved extends JFrame {

    private JButton[][] buttons;
    private int[][] bgMatrix;
    private int m, n;
    private JFrame gWindow;
    private static JFrame showSolved;

    public ShowSolved() {
        this.bgMatrix = RightSidePanel.getBgMatrix();
        this.m = RightSidePanel.getM();
        this.n = RightSidePanel.getN();
        this.gWindow = GameWindow.getGameWindow();
        this.showSolved = this;

        this.setLocationRelativeTo(gWindow);
        this.setTitle("Solved");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(m,n));
        this.setVisible(true);
        this.setSize(new Dimension(250,250));
        buttons = new JButton[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bgMatrix[i][j] == -1) {
                    buttons[i][j] = new JButton();
                    buttons[i][j].setBackground(Color.black);
                    buttons[i][j].setEnabled(false);
                    this.add(buttons[i][j]);
                }else{
                    buttons[i][j] = new JButton(""+bgMatrix[i][j]);
                    buttons[i][j].setBackground(Color.white);
                    buttons[i][j].setEnabled(false);
                    this.add(buttons[i][j]);
                }
            }
        }
    }


    //pkusaj gasenja windowa
    //geter
    public static JFrame getShowSolved() {
        return showSolved;
    }
}