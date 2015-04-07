package other;

import org.openqa.selenium.WebDriver;

/**
 * Created by lthatch1 on 1/12/2015.
 */
public enum SupportedDriver
{
    FireFox,
    InternetExplorer,
    Chrome,
    Safari,
    HtmlUnit,
    Phantom;

    public WebDriver getDriver()
    {
        return WebdriverFactory.getDriver(this);
    }
}
