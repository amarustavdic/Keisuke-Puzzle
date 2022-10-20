import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public int m,n;
    public boolean isEndless;
    private boolean isLoad;
    private static JFrame gameWindow;


    public GameWindow(int m, int n, boolean isEndless, boolean isLoad) {
        this.setMinimumSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        if (isEndless != true) this.setTitle("Keisuke Puzzle - CLASSIC");
        else this.setTitle("Keisuke Puzzle - ENDLESS");
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(160,160,160));

        this.gameWindow = this;


        this.m = m;
        this.n = n;
        this.isEndless = isEndless;
        this.isLoad = isLoad;

        //ako nije loadana igrica
        if (isLoad != true) {
            new Matrix(m, n);
            this.add(new GameBoard(this, Matrix.getBgMatrix(), Matrix.getUserMatrix(), m, n, isEndless, false), BorderLayout.CENTER);
            this.add(new RightSidePanel(this, Matrix.getBgMatrix(), m, n, isEndless), BorderLayout.EAST);
            this.add(new GivenNumbers(Matrix.getBgMatrix()), BorderLayout.SOUTH);
        }else{
            this.add(new GameBoard(this, Load.getgNumms(), Load.getuNumms(), m, n, isEndless, true), BorderLayout.CENTER);
            this.add(new RightSidePanel(this, Load.getgNumms(), m, n, isEndless), BorderLayout.EAST);
            this.add(new GivenNumbers(Load.getgNumms()), BorderLayout.SOUTH);
        }
    }


    public static JFrame getGameWindow() {
        return gameWindow;
    }
}
