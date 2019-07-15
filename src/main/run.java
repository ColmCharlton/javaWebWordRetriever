import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

public class run {

    public static void main(String[] args) throws IOException {

        String contentOfUrl;
        String contentOfFile;
        final String wordsFinal;


//        String myURL = "https://www.rte.ie/news/" ;
        String myURL = "https://www.bbc.com/news" ;

        contentOfUrl = urlRetrieve.callURL(myURL);     //Url call

        Filter filter = new Filter(contentOfUrl);
        filter.find();
        wordsFinal = filter.getWordsFinal();



        //Opening exclusionLists
        fileManagment fileManagment = new fileManagment();       //Create an instance of filereader
        String ExclusionList = fileManagment.fileIn("ExclusionList.txt");

        fileManagment fileManagment2 = new fileManagment();         //Create an instance of filereader
        String ExclusionList_Keywords = fileManagment2.fileIn("ExclusionList_Keywords.txt");



        // output from text fileRetrievalSortComapre to arraylist

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
        String Nouns = ExclusionList.replaceAll("\\W", " ");
        for(String w : Nouns.split(" ")) {
            exNouns.add(w);
        }

        //Arraylist to store string content from retrieved data file
        ArrayList<String> exKeywords = new ArrayList<String>();
        String bb = ExclusionList_Keywords.replaceAll("\\W", " ");   //Retrieve only text
        for(String w : bb.split(" ")) {
            exKeywords.add(w);
        }

//        public String remove(ArrayList<String> List)
//        {
//        }



        //remove all elements from second list
        ArrayList<String> Keywords = new ArrayList<String>();
        Keywords.addAll(urlList);
        Keywords.removeAll(exKeywords); //Remove an diffences
//        Count the occurrence of ...
        Map<String, Long> countsKeywords = Keywords.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(countsKeywords);





        Set<String> uniqueKeywords = new HashSet<String>(Keywords); //Why am i not using this?
//        System.out.println("\nUnique keys: " + Keywords.size() + " \n"  + uniqueKeywords);

//        System.out.println("Key words are" + Keywords + "Size " + Keywords.size());


        //remove all elements from second list
        ArrayList<String> NounsA = new ArrayList<String>();
        NounsA.addAll(urlList);
        NounsA.removeAll(exNouns);
        Map<String, Long> countsNouns = NounsA.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));



        System.out.println(countsNouns);
        Set<String> uniqueNouns = new HashSet<String>(NounsA); //Why am i not using this?
//        System.out.println("\nUnique nouns count: " + NounsA.size() + " \n"  + NounsA);


//        Final keywords
        Keywords.removeAll(NounsA);
//        System.out.println("\nUnique keywords final " + Keywords.size() + " \n" + Keywords);


//        Convert Nouns to a string, make a method
        String NounsString = String.join(" ", NounsA);
//        System.out.println("\n Nouns are \n " + NounsString);
//        Convert keywords to a string, make a method
        String KeywordsString = String.join(" ", Keywords);
//        System.out.println("\n Keywords are \n " + KeywordsString);




//        save to file
        fileManagment fileWriter1 = new fileManagment();
        fileWriter1.writeFile(NounsString, "nouns" );
        fileWriter1.writeFile(KeywordsString, "keywords" );


//        fileRetrievalSortComapre fileRetrievalSortComapre = new fileRetrievalSortComapre();
//        fileRetrievalSortComapre fileRetrievalSortComapre2 = new fileRetrievalSortComapre();

//        fileRetrievalSortComapre.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "k");
//        System.out.println("\n");
//        fileRetrievalSortComapre2.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "n");


        fileRetrieval fileRetrieval = new fileRetrieval();
        fileRetrieval fileRetrieval2 = new fileRetrieval();
        fileCompare fileCompare1 = new fileCompare();
        fileCompare fileCompare2 = new fileCompare();

        fileCompare1.sortCompare(fileRetrieval.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "n"));
        fileCompare2.sortCompare(fileRetrieval2.fileChecker("C:\\Users\\ccharlton\\IdeaProjects\\cc", "n"));

    }
}
