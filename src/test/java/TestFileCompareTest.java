import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TestFileCompareTest {

    @Test
    public void sortCompare() {


        fileCompare fileCompare = new fileCompare();
        fileRetrieval fileRetrieval = new fileRetrieval();
        File files [];
//        files = [ExclusionList.txt, ExclusionList_Keywords.txt]
        files = fileRetrieval.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "k");
        String output = fileCompare.sortCompare(files);
        Assert.assertNotNull(output);

    }
}
