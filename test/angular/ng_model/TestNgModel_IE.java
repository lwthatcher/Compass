package angular.ng_model;

import angular.TestNgModel;
import org.openqa.selenium.WebDriver;
import other.SupportedDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by lthatch1 on 2/12/2015.
 */
public class TestNgModel_IE extends TestNgModel
{
    @Override
    public WebDriver getDriver()
    {
        WebDriver result = SupportedDriver.InternetExplorer.getDriver();
        //result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return result;
    }
}
