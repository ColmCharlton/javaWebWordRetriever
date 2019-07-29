import java.io.IOException;

public class run {

    public static void main(String[] args) throws IOException {

        String myURL = args[0];
//        String myURL = "https://www.rte.ie/news/" ;
//        String myURL = "https://www.bbc.com/news" ;

        NounExtractor nounExtractor = new NounExtractor();


        nounExtractor.urlRetrieval(myURL);
        nounExtractor.wordsFinalMethod();
        nounExtractor.retrieveExclusionListMethod();
        nounExtractor.retrieveExclusionList_KeywordsMethod();
        nounExtractor.urlListMethod();
        nounExtractor.exNounMethod();
        nounExtractor.exKeywordsMethod();
        nounExtractor.KeywordMethod();
        nounExtractor.KeywordsNounsAMethod();
        nounExtractor.uniqueKeywordMethod();
        nounExtractor.writeMethod();
        nounExtractor.retrieveMethod();

    }
}