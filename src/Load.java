import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load extends JFileChooser {

    private static int[][] uNumms;
    private static int[][] gNumms;

    public Load() {
        File file;
        Scanner fileIn;
        int response;
        this.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = this.showOpenDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            file = this.getSelectedFile();
            try {
                fileIn = new Scanner(file);
                if (file.isFile()) {

                    String isEndless = fileIn.nextLine();
                    String m = fileIn.nextLine();
                    String n = fileIn.nextLine();
                    String userNums = fileIn.nextLine();
                    String gameNums = fileIn.nextLine();

                    //check za endles mode
                    boolean endlessItIs;
                    if (isEndless == "false") endlessItIs = false;
                    else endlessItIs = true;

                    uNumms = new int[Integer.parseInt(m)][Integer.parseInt(n)];
                    gNumms = new int[Integer.parseInt(m)][Integer.parseInt(n)];

                    int counter = 0;
                    for (int i = 0; i < Integer.parseInt(m); i++) {
                        for (int j = 0; j < Integer.parseInt(n); j++) {
                            switch (userNums.charAt(counter)) {
                                case '-':
                                    uNumms[i][j] = -1;
                                    counter++;
                                    counter++;
                                    break;
                                case '0':
                                    uNumms[i][j] = 0;
                                    counter++;
                                    break;
                                case '1':
                                    uNumms[i][j] = 1;
                                    counter++;
                                    break;
                                case '2':
                                    uNumms[i][j] = 2;
                                    counter++;
                                    break;
                                case '3':
                                    uNumms[i][j] = 3;
                                    counter++;
                                    break;
                            }
                        }
                    }
                    int counter1 = 0;
                    for (int i = 0; i < Integer.parseInt(m); i++) {
                        for (int j = 0; j < Integer.parseInt(n); j++) {
                            switch (gameNums.charAt(counter1)) {
                                case '-':
                                    gNumms[i][j] = -1;
                                    counter1++;
                                    counter1++;
                                    break;
                                case '0':
                                    gNumms[i][j] = 0;
                                    counter1++;
                                    break;
                                case '1':
                                    gNumms[i][j] = 1;
                                    counter1++;
                                    break;
                                case '2':
                                    gNumms[i][j] = 2;
                                    counter1++;
                                    break;
                                case '3':
                                    gNumms[i][j] = 3;
                                    counter1++;
                                    break;
                            }
                        }
                    }


                    new GameWindow(Integer.parseInt(m), Integer.parseInt(n), endlessItIs, true);


                } else {
                    System.out.println("That eas not a file!");
                }

                fileIn.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static int[][] getuNumms() {
        return uNumms;
    }

    public static int[][] getgNumms() {
        return gNumms;
    }
}