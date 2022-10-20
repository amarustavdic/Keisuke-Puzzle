import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JButton nIgra, lGame, cGame, back;
    private static JFrame menu;
    private static boolean isEndless;

    public Menu(boolean isEdless) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300, 300));
        this.setVisible(true);
        this.setTitle("Keisuke Puzzle");
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(255, 255, 102));

        this.menu = this;
        this.isEndless = isEdless;


        //gubici na frame-u
        EventHandler eh = new EventHandler();
        nIgra = new JButton("New Game");
        nIgra.setBackground(Color.white);
        nIgra.addActionListener(eh);
        lGame = new JButton("Load Game");
        lGame.setBackground(Color.white);
        lGame.addActionListener(eh);
        cGame = new JButton("Costume Game");
        cGame.setBackground(Color.white);
        cGame.addActionListener(eh);
        back = new JButton("Back To Main");
        back.setBackground(new Color(255, 204, 204));
        back.addActionListener(eh);


        //makes component strech to fill frame (gbc.fill)
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 5, 10);
        this.add(nIgra, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 10, 5, 10);
        this.add(lGame, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 10, 5, 10);
        this.add(cGame, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 10, 10, 10);
        this.add(back, gbc);

    }


    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //back to main menu
            if (e.getSource().equals(back)) {
                MainMenu menu = new MainMenu();
                menu.setLocationRelativeTo(menu);
                dispose();

                //nova igra
            } else if (e.getSource().equals(nIgra)) {

                GameWindow gw = new GameWindow(5, 5, isEndless, false);
                gw.setLocationRelativeTo(menu);
                dispose();

                //POP UP for costume game user input
            } else if (e.getSource().equals(cGame)) {
                new CostumeGame();

            } else if (e.getSource().equals(lGame)) {
                new Load();
                dispose();
            }
        }
    }

    public static JFrame getMenu() {
        return menu;
    }

    public static boolean isEndless() {
        return isEndless;
    }
}
