import construction.InputStreamReaderEx;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class fileRetrievalSortComapre {

    private File[] files;
    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }


    // Java program to demonstrate the
// use of listFiles() function

//        public static void main(String args[])
//        {


    //method pass in dir and file starting chatacter

    public void runFiles() {


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


                //Sort array of fileRetrievalSortComapre in decending order
                Arrays.sort(getFiles(), Collections.reverseOrder());

                // Display the names of the fileRetrievalSortComapre
                for (int i = 0; i < 2; i++) {
                    System.out.println(getFiles()[i].getName());
                }
                return getFiles();

            } catch (Exception e) {
                System.err.println(e.getMessage());
                return null;
            }
    }


            public String sortCompare() {
                // try-catch block to handle exceptions

                try {

                    InputStreamReaderEx f1 = new InputStreamReaderEx();        //Create an instance of filereader
                    ArrayList<String> a = new ArrayList<String>();

                    //Adds file output to an arraylist
                    for (int i = 0; i < 2; i++) {
                        a.add(f1.fileIn(getFiles()[i].getName()));

                    }
                    for (int i = 0; i < a.size(); i++) {
                        System.out.println(a.get(i));
                    }

                    System.out.println("Are they the same ?   ");
                    System.out.println(a.get(0).contains(a.get(1)));

                    //Comparers the arraylist elements, checks if they are the same, if so returns the difference
                    if (a.get(0).contains(a.get(1)) == false) {
                        ArrayList<String> b = new ArrayList<String>();
                        for (String w : a.get(0).split(" ")) {
                            b.add(w);
                        }
                        ArrayList<String> c = new ArrayList<String>();
                        for (String w : a.get(1).split(" ")) {
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
                    return e.getMessage();
                }
            }
    }
