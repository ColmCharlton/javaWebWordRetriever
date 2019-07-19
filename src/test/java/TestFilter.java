import org.junit.Assert;
import org.junit.Test;

public class TestFilter {

    public void setUp() {

    }


    @Test
    public void testFilter() {
        //Checks to see if a string is returned from the Filter class

        Filter filter = new Filter("<div class=\"summary\">\n" +
                "        \n" +
                "        \n" +
                "        <h3><a href=\"/questions/56951908/dynamically-counting-objects-in-an-aggregate-django\" class=\"question-hyperlink\">Dynamically counting objects in an aggregate Django</a></h3>\n" +
                "        <div class=\"tags t-python t-django t-python-3ûx t-django-orm\">\n" +
                "            <a href=\"/questions/tagged/python\" class=\"post-tag\" title=\"show questions tagged 'python'\" rel=\"tag\">python</a> <a href=\"/questions/tagged/django\" class=\"post-tag\" title=\"show questions tagged 'django'\" rel=\"tag\">django</a> <a href=\"/questions/tagged/python-3.x\" class=\"post-tag\" title=\"show questions tagged 'python-3.x'\" rel=\"tag\">python-3.x</a> <a href=\"/questions/tagged/django-orm\" class=\"post-tag\" title=\"show questions tagged 'django-orm'\" rel=\"tag\">django-orm</a> \n" +
                "        </div>\n" +
                "        <div class=\"started\">\n" +
                "            <a href=\"/questions/56951908/dynamically-counting-objects-in-an-aggregate-django\" class=\"started-link\">modified <span title=\"2019-07-09 12:55:21Z\" class=\"relativetime\">1 min ago</span></a>\n" +
                "            <a href=\"/users/9571525/talha-murtaza\">Talha Murtaza</a> <span class=\"reputation-score\" title=\"reputation score \" dir=\"ltr\">104</span>\n" +
                "        </div>\n" +
                "    </div>");

        String out = filter.find();
        System.out.println(out);
        Assert.assertFalse(out.isEmpty());
    }

    @Test
    public void testMatcher() {
        //Tests the matcher method, takes in a pattern and content

        Filter filter = new Filter(" \"<body>\\n\" +\n" +
                "                \"    <meta charset=\\\"UTF-8\\\">\\n\" +\n" +
                "                \"    <meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0\\\">\\n\" +\n" +
                "</body>\"");

        String out = filter.matcher( "<h\\d.*?>(.*?)</h\\d>", " <div class=\"summary\">\n" +
                "        \n" +
                "        \n" +
                "        <h3><a href=\"/questions/56951908/dynamically-counting-objects-in-an-aggregate-django\" class=\"question-hyperlink\">Dynamically counting objects in an aggregate Django</a></h3>\n" +
                "        <div class=\"tags t-python t-django t-python-3ûx t-django-orm\">\n" +
                "            <a href=\"/questions/tagged/python\" class=\"post-tag\" title=\"show questions tagged 'python'\" rel=\"tag\">python</a> <a href=\"/questions/tagged/django\" class=\"post-tag\" title=\"show questions tagged 'django'\" rel=\"tag\">django</a> <a href=\"/questions/tagged/python-3.x\" class=\"post-tag\" title=\"show questions tagged 'python-3.x'\" rel=\"tag\">python-3.x</a> <a href=\"/questions/tagged/django-orm\" class=\"post-tag\" title=\"show questions tagged 'django-orm'\" rel=\"tag\">django-orm</a> \n" +
                "        </div>\n" +
                "        <div class=\"started\">\n" +
                "            <a href=\"/questions/56951908/dynamically-counting-objects-in-an-aggregate-django\" class=\"started-link\">modified <span title=\"2019-07-09 12:55:21Z\" class=\"relativetime\">1 min ago</span></a>\n" +
                "            <a href=\"/users/9571525/talha-murtaza\">Talha Murtaza</a> <span class=\"reputation-score\" title=\"reputation score \" dir=\"ltr\">104</span>\n" +
                "        </div>\n" +
                "    </div>" );

        String out2 = filter.matcher( "<h\\d.*?>(.*?)</h\\d>", " t89tgy508934yg9hw8h" );

        System.out.println(out);
        Assert.assertFalse(out.isEmpty());  //Verifies a string is returned

    }
}
