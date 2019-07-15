import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class testFileRetrieval {

    @Test
    public void testRetrieve() {

        fileRetrieval fileRetrievalSort = new fileRetrieval();
        File files[];
        files = fileRetrievalSort.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "k");
        Assert.assertNotNull(files);

    }
}
