package angular.ng_binding;

import angular.TestNgBinding;
import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

/**
 * ng-binding in Internet Explorer!
 */
public class TestNgBinding_IE extends TestNgBinding
{
    @Override
    public WebDriver getDriver()
    {
        WebDriver result = SupportedDriver.InternetExplorer.getDriver();
        //result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return result;
    }
}
