import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GivenNumbers extends JPanel {


    private static int[][] bgMatrix;

    public GivenNumbers(int[][] bgMatrix) {
        this.setLayout(new GridBagLayout());
        this.bgMatrix = bgMatrix;



        //ACROSS number first extraction from matrix
        ArrayList<Integer> allNumbers = new ArrayList<Integer>();
        int counter = -1;
        for (int i = 0; i < bgMatrix.length; i++) {
            for (int j = 0; j < bgMatrix[i].length; j++) {
                if (bgMatrix[i][j] == -1) {
                    counter++;
                    allNumbers.add(counter, 0);
                }else {
                    counter++;
                    allNumbers.add(counter, bgMatrix[i][j]);
                }
            }
            counter++;
            allNumbers.add(counter, 0);
        }
        //string same as arrList up
        String str = "";
        for (int i = 0; i < allNumbers.size(); i++) {
            str += Integer.toString(allNumbers.get(i));
        }
        //counting zerros for arrlength
        int zCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') zCount++;
        }
        //first pass
        int arrInd = 0;
        int[] f1 = new int[zCount];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                f1[arrInd] *= 10;
                f1[arrInd] += Integer.parseInt(String.valueOf(str.charAt(i)));
            }else arrInd++;
        }
        Arrays.sort(f1);

        for (int i = 0; i < f1.length; i++) {
            System.out.println(f1[i]+"");
        }




        //DOWN number first extraction from matrix
        ArrayList<Integer> allNumbers1 = new ArrayList<Integer>();
        int counter1 = -1;
        for (int i = 0; i < bgMatrix.length; i++) {
            for (int j = 0; j < bgMatrix[i].length; j++) {
                if (bgMatrix[j][i] == -1) {
                    counter1++;
                    allNumbers1.add(counter1, 0);
                }else {
                    counter1++;
                    allNumbers1.add(counter1, bgMatrix[j][i]);
                }
            }
            counter1++;
            allNumbers1.add(counter1, 0);
        }
        //string same as arrList up
        String str1 = "";
        for (int i = 0; i < allNumbers1.size(); i++) {
            str1 += Integer.toString(allNumbers1.get(i));
        }
        //counting zerros for arrlength
        int zCount1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '0') zCount1++;
        }
        //first pass
        int arrInd1 = 0;
        int[] f2 = new int[zCount1];
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '0') {
                f2[arrInd1] *= 10;
                f2[arrInd1] += Integer.parseInt(String.valueOf(str1.charAt(i)));
            }else arrInd1++;
        }
        Arrays.sort(f2);

        for (int i = 0; i < f2.length; i++) {
            System.out.println(f2[i]+"");
        }

        //building strings for labels
        StringBuilder accrosText = new StringBuilder("Accross -->  ");
        StringBuilder downText = new StringBuilder("Down -->  ");
        for (int i = 0; i < f1.length; i++) {
            if (f1[i] > 9) accrosText.append(f1[i]).append(", ");
        }
        for (int i = 0; i < f2.length; i++) {
            if (f2[i] > 9) downText.append(f2[i]).append(", ");
        }
        //adding text to labels
        JLabel across = new JLabel(String.valueOf(accrosText));
        JLabel down = new JLabel(String.valueOf(downText));

        //constrains za gridbag layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10,10,5,10);
        this.add(across, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        gbc.insets = new Insets(5,10,10,10);
        this.add(down, gbc);
    }
}