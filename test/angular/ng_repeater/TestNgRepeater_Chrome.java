package angular.ng_repeater;


import angular.ByAngular;
import angular.TestNgRepeater;
import angular.WaitForAngularRequestsToFinish;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

import java.util.concurrent.TimeUnit;

public class TestNgRepeater_Chrome extends TestNgRepeater
{
    @Override
    public WebDriver getDriver()
    {
        WebDriver result = SupportedDriver.Chrome.getDriver();
        result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
//        WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish((JavascriptExecutor)result);
        return result;
    }

    public void setByAngular()
    {
        assert driver instanceof JavascriptExecutor;
        ng = new ByAngular((JavascriptExecutor)driver);
        WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish((JavascriptExecutor)driver);
    }
}
