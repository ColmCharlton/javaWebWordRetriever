import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class TestFileManager {

    @Test
    public void testFileIn() throws IOException {
        fileManagment fileManagment = new fileManagment();
        String out = fileManagment.fileIn("ExclusionList.txt");
        Assert.assertFalse(out.isEmpty());
    }


    @Test
    public void testFileWriter() throws IOException {
        fileManagment fileManagment = new fileManagment();

        BufferedWriter output;
        output = fileManagment.writeFile("hello", "testFile");
        Assert.assertNotNull(output);


//        File file = new File("C:\\Users\\Mayank\\Desktop\\1.txt");
//
//        if(file.delete())
//        {
//            System.out.println("File deleted successfully");
//        }
//        else
//        {
//            System.out.println("Failed to delete the file");
//        }

    }
}
