package selenium.unit.driver;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Abstract class that all driver tests should inherit from
 */
public abstract class DriverTestPlan
{
    protected WebDriver driver;

    public abstract void setDriver();

    @Before
    public void init()
    {
        setDriver();
    }

    @After
    public void close()
    {
        driver.quit();
    }
}
