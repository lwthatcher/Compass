package angular;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

public abstract class AngularTestPlan
{
    protected WebDriver driver;
    protected ByAngular ng;

    protected static final String TODO = "http://localhost:8000/html/todo.html";
    protected static final String OPTIONS = "http://localhost:8000/html/options.html";

    @Before
    public void setup()
    {
        driver = getDriver();
        openStartPage();
        setByAngular();
    }

    @After
    public void cleanup()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return SupportedDriver.Phantom.getDriver();
    }

    public void openStartPage()
    {
        assert driver != null;
        driver.get(TODO);
    }

    public void setByAngular()
    {
        assert driver instanceof JavascriptExecutor;
        ng = new ByAngular((JavascriptExecutor)driver);
    }
}
