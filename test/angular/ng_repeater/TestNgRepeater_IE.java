package angular.ng_repeater;


import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

import java.util.concurrent.TimeUnit;

public class TestNgRepeater_IE extends TestNgRepeater
{
    @Override
    public WebDriver getDriver()
    {
        WebDriver result = SupportedDriver.InternetExplorer.getDriver();
        result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return result;
    }
}
