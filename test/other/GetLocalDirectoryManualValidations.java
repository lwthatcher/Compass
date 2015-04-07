package other;

import org.junit.Test;

import java.io.File;

/**
 * Testing basic methods to get the current file directory.
 * These 'tests' simply print out to the console, so must be verified manually that they are correct.
 */
public class GetLocalDirectoryManualValidations
{
    @Test
    public void verify_PrintsProjectDirectory_NewFile()
    {
        System.out.println(new File("").getAbsolutePath());
    }

    @Test
    public void verify_PrintsProjectDirectory_SystemGetProperty()
    {
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void verify_GetURLProjectDirectory()
    {
        System.out.println(Directory.getUrlDirectoryRoot());
    }
}
