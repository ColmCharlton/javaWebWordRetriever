import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;

public class fileRetrieval {


    private File[] files;
    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }


    public File[] fileChecker(String pathname, String fName) {
        // try-catch block to handle exceptions
        try {

            // Create a file object
            File f = new File(pathname);

            // Create a FilenameFilter
            //Using an anonymous method find any instances of name given
            FilenameFilter filter = new FilenameFilter() {

                public boolean accept(File f, String name) {
                    return name.startsWith(fName);
                }
            };


            // Get all the names of the fileRetrievalSortComapre present
            // in the given directory
            // which are text fileRetrievalSortComapre
            File[] files = f.listFiles(filter);
            setFiles(files);

            System.out.println("Files are:");


            //Sort array of fileRetrievalSortComapre in descending order
            Arrays.sort(getFiles(), Collections.reverseOrder());

            // Display the names of the fileRetrievalSortCompare
            for (int i = 0; i < 2; i++) {
                System.out.println(getFiles()[i].getName());
            }
            return getFiles();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
