package construction;

import java.io.*;
import java.util.Scanner;
//
public class InputStreamReaderEx {


    public String fileIn(String file) throws IOException { // How to read file into String before Java 7
        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
//        System.out.println("Contents (before Java 7) : " + fileAsString);

        return fileAsString;
    }

}
//    public static void main(String[] args) {
//        try  {
////            Scanner s = new Scanner();
//            InputStream stream = new FileInputStream("ExclusionList.txt");
//            Reader reader = new InputStreamReader(stream);
//            int data = reader.read();
//            while (data != -1) {
//                System.out.print((char) data);
//                String a =  s.next();
//                data = reader.read();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
////
