package angular.ng_binding;

import angular.TestNgBinding;
import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

/**
 * ng-binding in Safari!
 */
public class TestNgBinding_Safari extends TestNgBinding
{
    @Override
    public WebDriver getDriver()
    {
        return SupportedDriver.Safari.getDriver();
    }
}
