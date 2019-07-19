package construction;

public class moodAnalyser {
    public String analysisMood(String message) {
        if (message.contains("sad")){
            return "SAD";
        } else{
            return "Happy";
        }
    }
}
