import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestUrl {

    @Test
    public void httpRequest() throws IOException {
//Check to see if a 200 response is given
        urlRetrieve url = new urlRetrieve();
        int urlS = url.urlCodeCheck("https://www.rte.ie/news/");
        Assert.assertThat(urlS, CoreMatchers.is(200));
    }

    @Test
    public void httpReturnString() {
        //Checks to see if a string is returned
        urlRetrieve url = new urlRetrieve();
        String urlS = url.callURL("https://www.rte.ie/news/");
        Assert.assertFalse(urlS.isEmpty());
    }
}
