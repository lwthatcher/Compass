package other;

import java.io.File;

/**
 * Helper class that contains methods to access other files and directories in the project directory.
 */
public class Directory
{
    protected static final String URL_FILE_EXTENSION = "file:///";
    protected static final String HTML_FOLDER_PATH = "/web/html/";
    private static final String DRIVERS_PATH = "/lib/drivers/";

    public static final String PASS_URL = getHtmlFolder() + "pass.html";
    public static final String FAIL_URL = getHtmlFolder() + "fail.html";

    public static String getUrlDirectoryRoot()
    {
        String path = new File("").getAbsolutePath();
        return URL_FILE_EXTENSION + formatPath(path);
    }

    public static String getDirectoryRoot()
    {
        String path = new File("").getAbsolutePath();
        return formatPath(path);
    }

    //Helper Methods
    protected static String getDriversFolder()
    {
        return getDirectoryRoot() + DRIVERS_PATH;
    }

    protected static String getHtmlFolder()
    {
        return getUrlDirectoryRoot() + HTML_FOLDER_PATH;
    }

    protected static String formatPath(String path)
    {
        return path.replace("\\", "/");
    }

    protected static String removeUrlFileExtension(String path)
    {
        CharSequence result = path.subSequence(8,path.length());
        return result.toString();
    }
}
