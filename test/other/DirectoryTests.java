package other;

import org.junit.Test;

import java.io.File;

/**
 * Tests for the primary functionality of the Directory class, as well as the helper functions it supports.
 */
public class DirectoryTests
{
    @Test
    public void test_getHtmlFolder()
    {
        String path = Directory.removeUrlFileExtension(Directory.getHtmlFolder());

        File htmlFolder = new File(path);
        String expectedName = "html";
        String abs_path = Directory.formatPath(htmlFolder.getAbsolutePath()) + "/";

        assert htmlFolder.exists();
        assert htmlFolder.isDirectory();
        assert htmlFolder.getName().equals(expectedName);
        assert abs_path.equals(path);
    }

    //===Helper Function Tests===
    @Test
    public void test_formatPath()
    {
        String input = "\\Sample\\Input/String\\.";

        String expected = "/Sample/Input/String/.";
        String actual = Directory.formatPath(input);

        assert actual.equals(expected);
    }

    @Test
    public void test_removeUrlFileExtension()
    {
        String expected = "Hello World";
        String input = Directory.URL_FILE_EXTENSION + expected;

        String actual = Directory.removeUrlFileExtension(input);
        assert actual.equals(expected);
    }

}
