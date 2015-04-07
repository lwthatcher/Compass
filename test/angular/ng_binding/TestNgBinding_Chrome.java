package angular.ng_binding;

import angular.ByAngular;
import angular.TestNgBinding;
import angular.TestNgRepeater;
import angular.WaitForAngularRequestsToFinish;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

import java.util.concurrent.TimeUnit;

public class TestNgBinding_Chrome extends TestNgBinding
{
    @Override
    public WebDriver getDriver()
    {
        WebDriver result = SupportedDriver.Chrome.getDriver();
        result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return result;
    }

    public void setByAngular()
    {
        assert driver instanceof JavascriptExecutor;
        ng = new ByAngular((JavascriptExecutor)driver);
        WaitForAngularRequestsToFinish.waitForAngularRequestsToFinish((JavascriptExecutor)driver);
    }
}
