import java.io.File;
import java.util.ArrayList;

public class fileCompare {



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
            System.out.println(retrievedFiles.get(0).contains(retrievedFiles.get(1)));

            //Compares the arraylist elements, checks if they are the same, if so returns the difference
            if (retrievedFiles.get(0).contains(retrievedFiles.get(1)) == false) {
                ArrayList<String> b = new ArrayList<String>();
                for (String w : retrievedFiles.get(0).split(" ")) {
                    b.add(w);
                }
                ArrayList<String> c = new ArrayList<String>();
                for (String w : retrievedFiles.get(1).split(" ")) {
                    c.add(w);
                }

                b.removeAll(c);
                System.out.println("\nDifference between files is " + b);

                String result = String.join(" ", b);
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
