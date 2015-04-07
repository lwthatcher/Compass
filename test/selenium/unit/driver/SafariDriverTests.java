package selenium.unit.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import other.Directory;
import other.LocalServerDirectory;
import other.SupportedDriver;

public class SafariDriverTests extends DriverTestPlan
{
    @Test(expected = WebDriverException.class)
    public void test_Safari_CannotLoadLocalFiles()
    {
        driver.get(Directory.PASS_URL);
    }

    @Test
    public void test_Safari_CanAccessExternalSites()
    {
        driver.get("http://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @Test
    public void test_Safari_CanAccessLocalServer()
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
        driver = SupportedDriver.Safari.getDriver();
    }
}
