package construction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//
public class fileWriter {




//        Save to a file
public void writeFile(String dataToSave, String file) {

    BufferedWriter writer = null;
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
        Date date = new Date();
//        logWriter = new BufferedWriter(new FileWriter(dateFormat.format(date) + " serverLog.log", true))
        writer = new BufferedWriter(new FileWriter(file + dateFormat.format(date) + ".txt"));
        writer.write(dataToSave);

    } catch (IOException e) {
    } finally {
        try {
            if (writer != null)
                writer.close();
        } catch (IOException e) {
        }
    }


}
}
//
// import time
//         try:
//         timestr = time.strftime("%Y%m%d-%H%M%S")