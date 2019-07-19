import org.junit.Assert;
import org.junit.Test;
import java.io.File;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileCompareTest {

    @Test
    public void sortCompare() {


        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);



        fileCompare fileCompare = new fileCompare();
        fileRetrieval fileRetrieval = new fileRetrieval();
        File files [];
//        files = [ExclusionList.txt, ExclusionList_Keywords.txt]
        files = fileRetrieval.fileChecker(s, "k");
        String output = fileCompare.sortCompare(files);
        Assert.assertNotNull(output);

    }
}
