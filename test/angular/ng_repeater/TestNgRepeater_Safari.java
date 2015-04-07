package angular.ng_repeater;


import angular.TestNgRepeater;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

public class TestNgRepeater_Safari extends TestNgRepeater
{
    @Override
    public WebDriver getDriver()
    {
        return SupportedDriver.Safari.getDriver();
    }
}
