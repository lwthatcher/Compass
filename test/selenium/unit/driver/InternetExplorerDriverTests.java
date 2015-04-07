package selenium.unit.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import other.Directory;
import other.LocalServerDirectory;
import other.SupportedDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lthatch1 on 1/12/2015.
 */
public class InternetExplorerDriverTests extends DriverTestPlan
{
    @Test(expected = WebDriverException.class)
    public void test_IE_CannotLoadLocalFiles()
    {
        //Open the page
        driver.get(Directory.PASS_URL);

        //Confirm the title
        System.out.println(driver.getTitle());

        //Confirm the text of the button
        WebElement button = driver.findElement(By.tagName("button"));
        assert button.getText().equals("Success");
    }

    @Test
    public void test_IE_CanAccessExternalSites()
    {
        driver.get("http://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @Test
    public void test_IE_CanAccessLocalServer()
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
        driver = SupportedDriver.InternetExplorer.getDriver();
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }
}
