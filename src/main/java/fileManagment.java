import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileManagment {

    //TWO CLASSES NEEDED HERE, COULD USE AN INTERFACE CALLED FILE MANAGEMENT THAT TAKES TOW METHODS FILEIN AND WRITEFILE


    // //Reads from file
    public String fileIn(String file) throws IOException { // How to read file into String before Java 7
        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
//        System.out.println("Contents (before Java 7) : " + fileAsString);

        return fileAsString;
    }

    //        Save to a file
    public BufferedWriter writeFile(String dataToSave, String file) {
        BufferedWriter writer = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
            Date date = new Date();
//        logWriter = new BufferedWriter(new FileWriter(dateFormat.format(date) + " serverLog.log", true))
            writer = new BufferedWriter(new FileWriter(file + dateFormat.format(date) + ".txt"));

            writer.write(dataToSave);

//            String name = file + dateFormat.format(date) + ".txt";

            return writer;

        } catch (IOException e) {
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }

        return null;
    }



}
