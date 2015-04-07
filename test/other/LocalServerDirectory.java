package other;


public class LocalServerDirectory
{
    public static final String PASS_PAGE =  "pass.html";
    public static final String FAIL_PAGE =  "fail.html";

    public static String getLocalServerURL()
    {
        return getLocalServerURL(8000);
    }

    public static String getLocalServerURL(int p)
    {
        String port = Integer.toString(p);
        return "http://localhost:" + port + "/html/";
    }
}
