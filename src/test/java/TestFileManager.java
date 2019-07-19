import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class TestFileManager {

    @Test
    public void testFileIn() throws IOException {
        fileManagment fileManagment = new fileManagment();
        String out = fileManagment.fileIn("url.txt");
        Assert.assertFalse(out.isEmpty());
    }


    @Test
    public void testFileWriter() throws IOException {
        fileManagment fileManagment = new fileManagment();

        BufferedWriter output;
        output = fileManagment.writeFile("hello", "testFile.txt");
        Assert.assertNotNull(output);

    }
}
