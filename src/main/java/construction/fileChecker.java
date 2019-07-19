package construction;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class fileChecker {


//    public File[] listFiles("C:\\Users\\ccharlton\\IdeaProjects\\cc")
//

//
//    private final static File[] fileRetrievalSortComapre = {
//            new File("keywords11-07-19 15-12-00.txt"),
//            new File("keywords11-07-19 15-12-06.txt"),
//            new File("keywords11-07-19 15-12-11.txt"),
//            new File("keywords11-07-19 15-12-16.txt"),
//    };
//
//    public void sortByNumber() {
//        Arrays.sort(fileRetrievalSortComapre, new Comparator<File>() {
//            @Override
//            public int compare(File o1, File o2) {
//                int n1 = extractNumber(o1.getName());
//                int n2 = extractNumber(o2.getName());
//                return n1 - n2;
//            }
//
//            private int extractNumber(String name) {
//                int i = 0;
//                try {
//                    int s = name.indexOf('_')+1;
//                    int e = name.lastIndexOf('.');
//                    String number = name.substring(s, e);
//                    i = Integer.parseInt(number);
//                } catch(Exception e) {
//                    i = 0; // if filename does not match the format
//                    // then default to 0
//                }
//                return i;
//            }
//        });
//
//        for(File f : fileRetrievalSortComapre) {
//            System.out.println(f.getName());
//        }
//    }
//
//
//        File[] fileRetrievalSortComapre = directory.listFiles();
//
//        Arrays.sort(fileRetrievalSortComapre, new Comparator<File>(){
//        public int compare(File f1, File f2)
//        {
//            return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
//        } });
}
