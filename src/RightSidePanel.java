import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightSidePanel extends JPanel {

    private JButton nGame, nCostume, lGame, save, back, check, showSolved;

    //parametri za hint
    private static int[][] bgMatrix;
    private static int m, n;
    private static boolean isEndless;

    public RightSidePanel(JFrame gWindow, int[][] bgMatrix, int m, int n, boolean isEndless) {
        this.setLayout(new GridBagLayout());
        this.bgMatrix = bgMatrix;
        this.m = m;
        this.n = n;
        this.isEndless = isEndless;

        EventHandler eh = new EventHandler();
        nGame = new JButton("New 5x5");
        nGame.setBackground(Color.white);
        nGame.addActionListener(eh);
        nCostume = new JButton("New Costume");
        nCostume.setBackground(Color.white);
        nCostume.addActionListener(eh);

        check = new JButton("Check");
        check.setBackground(Color.white);
        check.addActionListener(eh);
        showSolved = new JButton("Show Solved");
        showSolved.setBackground(Color.white);
        showSolved.addActionListener(eh);

        lGame = new JButton("Load Game");
        lGame.setBackground(Color.white);
        lGame.addActionListener(eh);
        save = new JButton("Save");
        save.setBackground(Color.white);
        save.addActionListener(eh);
        back = new JButton("Back");
        back.setBackground(new Color(255,204,204));
        back.addActionListener(eh);



        //adding components on panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20,20,5,20);
        this.add(nGame, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,20,10,20);
        this.add(nCostume, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30,20,5,20);
        this.add(check, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,20,5,20);
        this.add(showSolved, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30,20,5,20);
        this.add(lGame, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,20,10,20);
        this.add(save, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30,20,5,20);
        this.add(back, gbc);
    }


    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //new game
            if (e.getSource().equals(nGame)) {
                GameWindow gw = new GameWindow(5, 5, isEndless,false);
                gw.setLocationRelativeTo(GameWindow.getGameWindow());
                GameWindow.getGameWindow().dispose();


                //costume game
            }else if (e.getSource().equals(nCostume)) {
                new CostumeGame();
                GameWindow.getGameWindow().dispose();

                //check for specific button
            }else if (e.getSource().equals(check)) {







                //show solved
            }else if (e.getSource().equals(showSolved)) {
                new ShowSolved();

                //load game button on rigth side panel
            }else if (e.getSource().equals(lGame)) {
                new Load();
                GameWindow.getGameWindow().dispose();
                //showSolvedWindow.dispose();

                //save button on right side panel
            }else if (e.getSource().equals(save)) {
                String saver;
                if (isEndless == true) saver = "true\n";
                else saver = "false\n";
                saver +=m+"\n";
                saver += n+"\n";
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        saver += Integer.toString(GameBoard.getUserMatrix()[i][j]);
                    }
                }
                saver += "\n";
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        saver += Integer.toString(GameBoard.getBgMatrix()[i][j]);
                    }
                }
                new Save(saver);

                //back button on right side panel
            }else if (e.getSource().equals(back)) {
                Menu classicMenu = new Menu(isEndless);
                classicMenu.setLocationRelativeTo(GameWindow.getGameWindow());
                GameWindow.getGameWindow().dispose();
                //showSolvedWindow.dispose();
            }
        }
    }


    //geteri i setteri

    public static int[][] getBgMatrix() {
        return bgMatrix;
    }

    public static int getM() {
        return m;
    }

    public static int getN() {
        return n;
    }
}
