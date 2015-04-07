package selenium.unit.driver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import other.Directory;
import other.LocalServerDirectory;
import other.SupportedDriver;


public class ChromeDriverTests extends DriverTestPlan
{
    @Test
    public void test_Chrome_CanLoadLocalFiles()
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
    public void test_Chrome_CanAccessExternalSites()
    {
        driver.get("http://www.google.com");
        assert driver.getTitle().equals("Google");
    }

    @Test
    public void test_Chrome_CanAccessLocalServer()
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
        driver = SupportedDriver.Chrome.getDriver();
    }
}
