package construction;

import java.io.*;

public class fileReader {

    // //Reads from file
    public void fileReader(String file) {
        try {
            InputStream stream = new FileInputStream(file);
            Reader reader = new InputStreamReader(stream);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}