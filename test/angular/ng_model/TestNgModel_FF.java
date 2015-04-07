package angular.ng_model;

import angular.TestNgModel;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

/**
 * Created by lthatch1 on 2/12/2015.
 */
public class TestNgModel_FF extends TestNgModel
{
    @Override
    public WebDriver getDriver()
    {
        return SupportedDriver.FireFox.getDriver();
    }
}
