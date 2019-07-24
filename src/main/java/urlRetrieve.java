import java.io.*;
import java.net.HttpURLConnection;


import java.net.URL;
        import java.net.URLConnection;
        import java.nio.charset.Charset;


public class urlRetrieve {

    //WROTE SPECIFICALLY FOR TESTS TO ENSURE URL RETURNED 200 RESPONSE
    public int urlCodeCheck(String webSite) throws IOException {
        URL url = new URL(webSite);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int code = connection.getResponseCode();

        System.out.println(code);
        return code;
    }

//CALLS URL APPENDS TO STRING AND RETURNS, ASSUMING THE IF CONDITION ARE MET
    public static String callURL(String myURL) {
        System.out.println("Requeted URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }
    }

}

