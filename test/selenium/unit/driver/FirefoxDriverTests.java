package selenium.unit.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import other.Directory;
import other.LocalServerDirectory;
import other.SupportedDriver;

/**
 * Tests whether or not the firefox driver works
 */
public class FirefoxDriverTests extends DriverTestPlan
{
    @Test
    public void test_FF_CanLoadLocalFiles()
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
    public void test_FF_CanAccessExternalSites()
    {
        driver.get("http://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @Test
    public void test_FF_CanAccessLocalServer()
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
        driver = SupportedDriver.FireFox.getDriver();
    }
}
