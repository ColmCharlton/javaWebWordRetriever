import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Filter {

    public Filter(String contentOfUrl) { //default constructor
        this.contentOfUrl = contentOfUrl;
    }


    private String contentOfUrl;
    private final String para = "<p>(.*?)</p\\>";
    private final String hTag = "<h\\d>(.*?)</h\\d>";
    private final String hTagClass = "<h\\d.*?>(.*?)</h\\d>";
    private final String span = "<span.*?>(.*?)</span>";
    private final String textInBrackets = "\\>(.*?)\\<";
    private final String whiteSpace = "\\s+";
    private final String NonNumericalAlphbetic = "[^A-Za-z0-9]+";
    private final String removeSingleCharcaters = "\\b\\w{1,1}\\b";
    private final String justWords = "\\d";
    private final String words = "\\W";


    private String text;
    private String wordsFinal;


    public String getContentOfUrl() {
        return contentOfUrl;
    }

    public String getPara() {
        return para;
    }

    public String gethTag() {
        return hTag;
    }

    public String gethTagClass() {
        return hTagClass;
    }

    public String getSpan() {
        return span;
    }

    public String getTextInBrackets() {
        return textInBrackets;
    }

    public String getWhiteSpace() {
        return whiteSpace;
    }

    public String getNonNumericalAlphbetic() {
        return NonNumericalAlphbetic;
    }

    public String getRemoveSingleCharcaters() {
        return removeSingleCharcaters;
    }

    public String getJustWords() {
        return justWords;
    }

    public String getWords() {
        return words;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWordsFinal() {
        return wordsFinal;
    }

    public void setWordsFinal(String wordsFinal) {
        this.wordsFinal = wordsFinal;
    }








    public String find() {
        //Find needed content
        try {
            String contentWithoutSpaces = getContentOfUrl().replaceAll(getWhiteSpace(), " ");


            String paragraphes = matcher(getPara(), contentWithoutSpaces);

            String hTags = matcher(gethTag(), contentWithoutSpaces);

            String hTagsClasses = matcher(gethTagClass(), contentWithoutSpaces);

            String spanTags = matcher(getSpan(), contentWithoutSpaces);

            String combined = paragraphes + hTags + hTagsClasses + spanTags;

            String text = matcher(getTextInBrackets(), combined);

//    }
//
//
//    //Remove unwanted content
//    public void remove() {
            String allNonNumericalAlphbetic = text.replaceAll(getNonNumericalAlphbetic(), " ");

            String onlyWords = allNonNumericalAlphbetic.replaceAll(getJustWords(), " ");

            String minusSingleCharacters = onlyWords.replaceAll(getRemoveSingleCharcaters(), " ");

            String wordsFinal = minusSingleCharacters.replaceAll(getJustWords(), " ");

            setWordsFinal(wordsFinal.toLowerCase());

            if (wordsFinal == null)
            return null;
            else
                return wordsFinal;
        }catch(Exception e){
            System.out.println(" Error in filter step" +  e);
            return null;
        }
    }


    public String matcher(String pattern, String content)
    {

        try {
            // Create a Pattern object
            Pattern p = Pattern.compile(pattern);
            // Now create matcher object.
            Matcher m = p.matcher(content);

            String finds = null;

            while (m.find()) {
                finds += m.group();
            }
            if (finds == null)
            return null;
            else
                return finds;
        }catch (Exception e){
            return content;
        }
    }

}