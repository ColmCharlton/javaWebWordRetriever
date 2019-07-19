package construction;

import java.io.FileReader;
import java.io.IOException;

public class fileRead {
        public static void main(String args[])throws Exception{
            FileReader fr=new FileReader("url.txt");
            int i;
            while((i=fr.read())!=-1)
                System.out.print((char)i);
            fr.close();
        }




//    public void fileReadeeer(String file) {
//        try {
//            FileReader fr = new FileReader(file);
//            int i;
//            while ((i = fr.read()) != -1)
//                System.out.print((char) i);
//            fr.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }
}