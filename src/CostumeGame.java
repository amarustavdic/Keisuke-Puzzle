import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CostumeGame extends JFrame {

    private JFrame costumeGame;

    public CostumeGame() {
        this.costumeGame = this;

        this.setVisible(true);
        this.setSize(new Dimension(250,150));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Costume Game Maker");
        this.setLocationRelativeTo(Menu.getMenu());
        this.setLayout(new GridBagLayout());

        JLabel m = new JLabel("Input Width", SwingConstants.CENTER);
        JLabel n = new JLabel("Input Height", SwingConstants.CENTER);
        JTextField mInput = new JTextField();
        mInput.setHorizontalAlignment(JTextField.CENTER);
        JTextField nInput = new JTextField();
        nInput.setHorizontalAlignment(JTextField.CENTER);
        JButton create = new JButton("Create");
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GameWindow nGameWin = new GameWindow(Integer.parseInt(mInput.getText()),Integer.parseInt(nInput.getText()), Menu.isEndless(),false);
                nGameWin.setLocationRelativeTo(costumeGame);
                Menu.getMenu().dispose();
                dispose();
            }
        });



        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10,10,5,5);
        this.add(m,gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10,5,5,10);
        this.add(n,gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,10,0,5);
        this.add(mInput,gbc);

        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0,5,0,10);
        this.add(nInput,gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,10,10,10);
        this.add(create,gbc);

    }
}