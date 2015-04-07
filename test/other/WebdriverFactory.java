package other;

import exceptions.UnsupportedDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverFactory
{
    public static WebDriver getDriver(SupportedDriver driver)
    {
        switch (driver)
        {
            case InternetExplorer:
                System.setProperty("webdriver.ie.driver", DriversDirectory.IE_DRIVER);
                return new InternetExplorerDriver();
            case Chrome:
                System.setProperty("webdriver.chrome.driver", DriversDirectory.CHROME_DRIVER);
                return new ChromeDriver();
            case FireFox:
                return new FirefoxDriver();
            case Safari:
                return new SafariDriver();
            case HtmlUnit:
                return new HtmlUnitDriver(true);
            case Phantom:
                System.setProperty("phantomjs.binary.path", DriversDirectory.PHANTOM_DRIVER);
                return new PhantomJSDriver();
            default:
                throw new UnsupportedDriverException(driver.toString());

        }
    }

}
