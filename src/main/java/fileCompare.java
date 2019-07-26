import java.io.File;
import java.util.ArrayList;

public class fileCompare {

    private ArrayList<String> retrievedFiles;

    //This should be two classes sort and compare

    public String sortCompare(File[] files) {
        // try-catch block to handle exceptions

        try {

            fileManagment f1 = new fileManagment();
            ArrayList<String> retrievedFiles = new ArrayList<String>();

            //Adds file output to an arraylist
            for (int i = 0; i < 2; i++) {
                retrievedFiles.add(f1.fileIn(files[i].getName()));

            }
            for (int i = 0; i < retrievedFiles.size(); i++) {
//                System.out.println(a.get(i));
            }



            System.out.println("Are they the same ?   ");
            //Checks to see if the files are similiar
            System.out.println(retrievedFiles.get(0).contains(retrievedFiles.get(1)));
            //Compares the arraylist elements, checks if they are the same, if so returns the difference, if not it breaks the loop and returns
            if (retrievedFiles.get(0).contains(retrievedFiles.get(1)) == false) {
                ArrayList<String> file1 = new ArrayList<String>();
                for (String w : retrievedFiles.get(0).split(" ")) {
                    file1.add(w);
                }
                ArrayList<String> file2 = new ArrayList<String>();
                for (String w : retrievedFiles.get(1).split(" ")) {
                    file2.add(w);
                }

//                remove similiar words
                file1.removeAll(file2);
                System.out.println("Difference between files is " + file2);

                String result = String.join(" ", file1);
//                        System.out.println("\nDifference between fileRetrievalSortComapre is " + result);

                return result;

            } else
                System.out.println("Same as before");
            return "Same as before";


        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }


}
