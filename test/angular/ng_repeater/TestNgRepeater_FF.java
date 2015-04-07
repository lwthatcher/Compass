package angular.ng_repeater;

import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

public class TestNgRepeater_FF extends TestNgRepeater
{
    @Override
    public WebDriver getDriver()
    {
        return SupportedDriver.FireFox.getDriver();
    }
}
