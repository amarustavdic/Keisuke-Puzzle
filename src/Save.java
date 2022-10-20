import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Save extends JFileChooser {


    public Save(String s) {

        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt");
        this.setFileFilter(filter);

        int ret = this.showSaveDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save file");
            File file = this.getSelectedFile();
            //print file path
            System.out.println(file.getAbsolutePath());

            try {
                //pisemo na datoteko
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                //string koji treba sejvati
                writer.write(s);
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}