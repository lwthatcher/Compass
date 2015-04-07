package selenium.unit.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import other.Directory;
import other.LocalServerDirectory;
import other.SupportedDriver;

/**
 * Created by lthatch1 on 1/12/2015.
 */
public class PhantomDriverTests extends DriverTestPlan
{
    @Test
    public void test_Phantom_CanLoadLocalFiles()
    {
        //Open the page
        driver.get(Directory.PASS_URL);

        //Confirm the title
        assert driver.getTitle().equals("Pass");

        //Confirm the text of the button
        WebElement button = driver.findElement(By.tagName("button"));
        assert button.getText().equals("Success");
    }

    @Test
    public void test_Phantom_CanAccessExternalSites()
    {
        driver.get("http://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @Test
    public void test_Phantom_CanAccessLocalServer()
    {
        String url = LocalServerDirectory.getLocalServerURL() + LocalServerDirectory.PASS_PAGE;
        driver.get(url);

        //Confirm the title
        assert driver.getTitle().equals("Pass");

        //Confirm the text of the button
        WebElement button = driver.findElement(By.tagName("button"));
        assert button.getText().equals("Success");
    }

    @Override
    public void setDriver()
    {
        driver = SupportedDriver.Phantom.getDriver();
    }
}
