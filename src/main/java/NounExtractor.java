import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;



public class NounExtractor {

    public static void main(String[] args) throws IOException {

        String contentOfUrl;
        String contentOfFile;
        final String wordsFinal;


        String myURL = args[0];
//        String myURL = "https://www.rte.ie/news/" ;
//        String myURL = "https://www.bbc.com/news" ;


        //Method call urlretrieve
        contentOfUrl = urlRetrieve.callURL(myURL);     //Url call


        //method call filter
        Filter filter = new Filter(contentOfUrl);
        filter.find();  //Runs the filter/cleaner class method
        wordsFinal = filter.getWordsFinal();    //Retrieves the final result

        //method call open file
        //Opening exclusionLists
        fileManagment fileManagment = new fileManagment();       //Create an instance of filereader
//        String ExclusionList = fileManagment.fileIn("ExclusionList.txt");
        String ExclusionList = fileManagment.fileIn("classes\\ExclusionList.txt");  //need to uncomment this to jar file to NounExtractor


        fileManagment fileManagment2 = new fileManagment();         //Create an instance of filereader
//        String ExclusionList_Keywords = fileManagment2.fileIn("ExclusionList_Keywords.txt");
        String ExclusionList_Keywords = fileManagment2.fileIn("classes\\ExclusionList_Keywords.txt");



        //Add method for this
        //Arraylist to store url word content
        ArrayList<String> urlList = new ArrayList<String>();
        for(String word : wordsFinal.split(" ")) {
            urlList.add(word);
        }
//        List<String> urlDistinct = urlList.stream().distinct().collect(Collectors.toList());
//        System.out.println("\n" + urlDistinct);


        //Add method for this
        //Arraylist to store string content from retrieved data file
        ArrayList<String> exNouns = new ArrayList<String>();
        String Nouns = ExclusionList.replaceAll("\\W", " "); //Retrieve only text
        for(String w : Nouns.split(" ")) {
            exNouns.add(w);
        }

        //Arraylist to store string content from retrieved data file
        ArrayList<String> exKeywords = new ArrayList<String>();
        String Keyword = ExclusionList_Keywords.replaceAll("\\W", " ");   //Retrieve only text
        for(String w : Keyword.split(" ")) {
            exKeywords.add(w);
        }




        //Remove all elements from second list
        ArrayList<String> Keywords = new ArrayList<String>();
        Keywords.addAll(urlList);
        Keywords.removeAll(exKeywords); //Remove any differences
//        Count the occurrence of ...
        Map<String, Long> countsKeywords = Keywords.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(countsKeywords);





//        Set<String> uniqueKeywords = new HashSet<String>(Keywords); //Why am i not using this?
//        System.out.println("\nUnique keys: " + Keywords.size() + " \n"  + uniqueKeywords);
//        System.out.println("Key words are" + Keywords + "Size " + Keywords.size());


//        remove all elements from second list
//        METHOD HERE?
        ArrayList<String> NounsA = new ArrayList<String>();
        NounsA.addAll(urlList);
        NounsA.removeAll(exNouns);
//        Map<String, Long> countsNouns = NounsA.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));  //?
//        System.out.println(countsNouns);

        //Get unique list of nouns
        Set<String> uniqueNouns = new HashSet<String>(NounsA); //GET JUST UNIQUE WORDS
//        System.out.println("\nUnique nouns count: " + NounsA.size() + " \n"  + NounsA);


//        Final keywords
        Keywords.removeAll(NounsA);
//        System.out.println("\nUnique keywords final " + Keywords.size() + " \n" + Keywords);


//        Convert Nouns to a string, MAKE A METHOD!
        String NounsString = String.join(" ", uniqueNouns);
//        System.out.println("\n Nouns are \n " + NounsString);


//        Convert keywords to a string, make a method
//        String KeywordsString = String.join(" ", Keywords);
//        System.out.println("\n Keywords are \n " + KeywordsString);
        Set<String> uniqueKeywords = new HashSet<String>(Keywords); //GET JUST UNIQUE WORDS
        String KeywordsString = String.join(" ", uniqueKeywords);



//        save to file
        fileManagment fileWriter1 = new fileManagment();
        fileWriter1.writeFile(NounsString, "nouns" );
        fileWriter1.writeFile(KeywordsString, "keywords" );



        fileRetrieval fileRetrieval = new fileRetrieval();
        fileRetrieval fileRetrieval2 = new fileRetrieval();
        fileCompare fileCompare1 = new fileCompare();
        fileCompare fileCompare2 = new fileCompare();



        //Gets the current path and uses that to
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();


        // ????? What do i want here
        fileManagment fileWriter2 = new fileManagment();
        fileWriter2.writeFile(fileCompare1.sortCompare(fileRetrieval.fileChecker(absolutePath, "n")), "ResultNouns" );
        fileWriter2.writeFile(fileCompare2.sortCompare(fileRetrieval2.fileChecker(absolutePath, "k")), "ResultKeywords" );

    }
}
