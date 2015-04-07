package angular.ng_binding;

import angular.TestNgBinding;
import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

/**
 * ng-binding in Firefox!
 */
public class TestNgBinding_FF extends TestNgBinding
{
    @Override
    public WebDriver getDriver()
    {
        return SupportedDriver.FireFox.getDriver();
    }
}
