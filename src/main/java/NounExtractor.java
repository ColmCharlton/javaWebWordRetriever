import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

public class NounExtractor {


    private String contentOfUrl;
    private String contentOfFile;
    private String wordsFinal;
    private String ExclusionList;
    private String ExclusionList_Keywords;
    private ArrayList<String> urlList;
    private ArrayList<String> exNouns;
    private ArrayList<String> exKeywords;
    private ArrayList<String> Keywords;
    private Map<String, Long> countsKeywords;
    private ArrayList<String> NounsA;
    private String NounsString;
    private Set<String> uniqueNouns;
    private String KeywordsString;


    public ArrayList<String> getNounsA() {
        return NounsA;
    }
    public void setNounsA(ArrayList<String> nounsA) {
        NounsA = nounsA;
    }
    public String getKeywordsString() {
        return KeywordsString;
    }
    public void setKeywordsString(String keywordsString) {
        KeywordsString = keywordsString;
    }
    public String getNounsString() {
        return NounsString;
    }
    public void setNounsString(String nounsString) {
        NounsString = nounsString;
    }
    public Set<String> getUniqueNouns() {
        return uniqueNouns;
    }
    public void setUniqueNouns(Set<String> uniqueNouns) {
        this.uniqueNouns = uniqueNouns;
    }
    public Map<String, Long> getCountsKeywords() {
        return countsKeywords;
    }
    public void setCountsKeywords(Map<String, Long> countsKeywords) {
        this.countsKeywords = countsKeywords;
    }
    public ArrayList<String> getKeywords() {
        return Keywords;
    }
    public void setKeywords(ArrayList<String> keywords) {
        Keywords = keywords;
    }
    public ArrayList<String> getExKeywords() {
        return exKeywords;
    }
    public void setExKeywords(ArrayList<String> exKeywords) {
        this.exKeywords = exKeywords;
    }
    public ArrayList<String> getExNouns() {
        return exNouns;
    }
    public void setExNouns(ArrayList<String> exNouns) {
        this.exNouns = exNouns;
    }
    public ArrayList<String> getUrlList() {
        return urlList;
    }
    public void setUrlList(ArrayList<String> urlList) {
        this.urlList = urlList;
    }
    public String getExclusionList_Keywords() {
        return ExclusionList_Keywords;
    }
    public void setExclusionList_Keywords(String exclusionList_Keywords) {
        ExclusionList_Keywords = exclusionList_Keywords;
    }
    public String getExclusionList() {
        return ExclusionList;
    }
    public void setExclusionList(String exclusionList) {
        ExclusionList = exclusionList;
    }
    public String getContentOfUrl() {
        return contentOfUrl;
    }
    public void setContentOfUrl(String contentOfUrl) {
        this.contentOfUrl = contentOfUrl;
    }
    public String getContentOfFile() {
        return contentOfFile;
    }
    public void setContentOfFile(String contentOfFile) {
        this.contentOfFile = contentOfFile;
    }
    public String getWordsFinal() {
        return wordsFinal;
    }
    public void setWordsFinal(String wordsFinal) {
        this.wordsFinal = wordsFinal;
    }




    //Method call urlretrieve
    public void urlRetrieval(String myURL) {
        // try-catch block to handle exceptions
        try {
            setContentOfUrl(urlRetrieve.callURL(myURL));     //Url call
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void wordsFinalMethod() {
        // try-catch block to handle exceptions
        try {
            Filter filter = new Filter(getContentOfUrl());
            filter.find();  //Runs the filter/cleaner class method
            wordsFinal = filter.getWordsFinal();    //Retrieves the final result
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void retrieveExclusionListMethod() {
        // try-catch block to handle exceptions
        try {

        //method call open file
        //Opening exclusionLists
        fileManagment fileManagment = new fileManagment();       //Create an instance of filereader
//        String ExclusionList = fileManagment.fileIn("ExclusionList.txt");
//        String ExclusionList = fileManagment.fileIn("classes\\ExclusionList.txt");  //need to uncomment this to jar file to NounExtractor
//        setExclusionList(fileManagment.fileIn("ExclusionList.txt"));
        setExclusionList(fileManagment.fileIn("classes\\ExclusionList.txt"));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void retrieveExclusionList_KeywordsMethod() {
        // try-catch block to handle exceptions
        try {

        fileManagment fileManagment2 = new fileManagment();         //Create an instance of filereader
//        String ExclusionList_Keywords = fileManagment2.fileIn("ExclusionList_Keywords.txt");
//        String ExclusionList_Keywords = fileManagment2.fileIn("classes\\ExclusionList_Keywords.txt");
//            setExclusionList_Keywords(fileManagment2.fileIn("ExclusionList_Keywords.txt"));
            setExclusionList_Keywords(fileManagment2.fileIn("classes\\ExclusionList_Keywords.txt"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void urlListMethod() {
        // try-catch block to handle exceptions
        try {

            ;
        //Arraylist to store url word content
            ArrayList<String> urlList = new ArrayList<String>();
//            this.urlList.add(getExclusionList_Keywords());

            for(String word : getWordsFinal().split(" ")) {
                urlList.add(word);
            }
            setUrlList(urlList);
//        ?????????
//        List<String> urlDistinct = urlList.stream().distinct().collect(Collectors.toList());
//        System.out.println("\n" + urlDistinct);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void exNounMethod() {
        // try-catch block to handle exceptions
        try {

    //Add method for this
        //Arraylist to store string content from retrieved data file
        ArrayList<String> exNouns = new ArrayList<String>();
        String Nouns = getExclusionList().replaceAll("\\W", " "); //Retrieve only text
        for(String w : Nouns.split(" ")) {
            exNouns.add(w);
        }
        setExNouns(exNouns);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void exKeywordsMethod() {
        // try-catch block to handle exceptions
        try {
        //Arraylist to store string content from retrieved data file
        ArrayList<String> exKeywords = new ArrayList<String>();
        String Keyword = getExclusionList_Keywords().replaceAll("\\W", " ");   //Retrieve only text
//             String setKeyword(getExclusionList_Keywords().replaceAll("\\W", " "));
            for(String w : Keyword.split(" ")) {
            exKeywords.add(w);
        }
            setExKeywords(exKeywords);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void KeywordMethod() {
        // try-catch block to handle exceptions
        try {

        //Remove all elements from second list
        ArrayList<String> Keywords = new ArrayList<String>();
        Keywords.addAll(getUrlList());
        Keywords.removeAll(getExKeywords()); //Remove any differences
            setKeywords(Keywords);
//        Count the occurrence of ...
//        Map<String, Long> countsKeywords = Keywords.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        setCountsKeywords(Keywords.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting())));
        System.out.println(countsKeywords);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }




//        Set<String> uniqueKeywords = new HashSet<String>(Keywords); //Why am i not using this?
//        System.out.println("\nUnique keys: " + Keywords.size() + " \n"  + uniqueKeywords);
//        System.out.println("Key words are" + Keywords + "Size " + Keywords.size());


//        remove all elements from second list
//        METHOD HERE?
public void KeywordsNounsAMethod() {
    // try-catch block to handle exceptions
    try {
        ArrayList<String> NounsA = new ArrayList<String>();
        NounsA.addAll(getUrlList());
        NounsA.removeAll(getExNouns());
//        Map<String, Long> countsNouns = NounsA.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));  //?
//        System.out.println(countsNouns);

        setNounsA(NounsA);
        //Get unique list of nouns
        Set<String> uniqueNouns = new HashSet<String>(NounsA); //GET JUST UNIQUE WORDS
//        System.out.println("\nUnique nouns count: " + NounsA.size() + " \n"  + NounsA);
        setUniqueNouns(uniqueNouns);

//        Final keywords
//        getKeywords().removeAll(NounsA);    //????
//        System.out.println("\nUnique keywords final " + Keywords.size() + " \n" + Keywords);


//        Convert Nouns to a string, MAKE A METHOD!
//        String NounsString = String.join(" ", uniqueNouns);
        setNounsString(String.join(" ", uniqueNouns));
//        System.out.println("\n Nouns are \n " + NounsString);
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }
}



    public void uniqueKeywordMethod() {
        // try-catch block to handle exceptions
        try {
            //        Final keywords
            getKeywords().removeAll(getNounsA());    //????
//        Convert keywords to a string, make a method
//        String KeywordsString = String.join(" ", Keywords);
//        System.out.println("\n Keywords are \n " + KeywordsString);

        Set<String> uniqueKeywords = new HashSet<String>(getKeywords()); //GET JUST UNIQUE WORD
//        String KeywordsString = String.join(" ", uniqueKeywords);
        setKeywordsString(String.join(" ", uniqueKeywords));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



    public void writeMethod() {
        // try-catch block to handle exceptions
        try {
//        save to file
        fileManagment fileWriter1 = new fileManagment();
        fileWriter1.writeFile(getNounsString(), "nouns" );
        fileWriter1.writeFile(getKeywordsString(), "keywords" );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    public void retrieveMethod() {
        // try-catch block to handle exceptions
        try {
        fileRetrieval fileRetrieval = new fileRetrieval();
        fileRetrieval fileRetrieval2 = new fileRetrieval();
        fileCompare fileCompare1 = new fileCompare();
        fileCompare fileCompare2 = new fileCompare();

         //Gets the current path and uses that to
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();


        // ????? What do i want here
        fileManagment fileWriter = new fileManagment();
        fileWriter.writeFile(fileCompare1.sortCompare(fileRetrieval.fileChecker(absolutePath, "n")), "ResultNouns" );
        fileWriter.writeFile(fileCompare2.sortCompare(fileRetrieval2.fileChecker(absolutePath, "k")), "ResultKeywords" );
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
