import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainMenu extends JFrame {

    private JButton clasic, endless;
    private JFrame mainMenu;

    public MainMenu() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,400));
        this.setVisible(true);
        this.setTitle("Keisuke Puzzle");
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(160,160,160));
        this.mainMenu = this;

        //centering JFrem on screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //components
        JLabel naslov = new JLabel("Keisuke Puzzle");
        naslov.setFont(naslov.getFont().deriveFont(Font.BOLD,40));
        naslov.setHorizontalAlignment(SwingConstants.CENTER);
        naslov.setVerticalAlignment(SwingConstants.CENTER);

        //event handler
        EventHandler eh = new EventHandler();
        clasic = new JButton("CLASSIC");
        clasic.setBackground(Color.white);
        clasic.addActionListener(eh);
        endless = new JButton("ENDLESS");
        endless.setBackground(Color.white);
        endless.addActionListener(eh);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        //adding other components
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 8;
        gbc.gridheight = 1;
        gbc.insets = new Insets(50,30,30,30);
        this.add(naslov, gbc);

        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.insets = new Insets(30,30,30,10);
        this.add(clasic, gbc);

        gbc.gridy = 1;
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.insets = new Insets(30,10,30,30);
        this.add(endless, gbc);

    }

    //main metoda
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }

    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(clasic)) {
                Menu menu = new Menu(false);
                menu.setLocationRelativeTo(mainMenu);
                dispose();
            }else if (e.getSource().equals(endless)) {
                Menu menu = new Menu(true);
                menu.setLocationRelativeTo(mainMenu);
                dispose();
            }
        }
    }
}
