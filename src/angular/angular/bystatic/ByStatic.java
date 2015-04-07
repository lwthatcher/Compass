package angular.angular.bystatic;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * Abstract class that other static accessors should inherit from for common functionality.
 *
 * @author Lawrence Thatcher
 */
public abstract class ByStatic extends By
{
    protected JavascriptExecutor getJSE(SearchContext context)
    {
        //Get the first element in the search context. The element itself doesn't really matter what it is
        WebElement element = context.findElement(By.cssSelector("*"));
        //TODO: add error checking in here to ensure it is a remote element
        WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();
        return (JavascriptExecutor)driver;
    }

    protected abstract By getParentBy(SearchContext context);

    @Override
    public WebElement findElement(SearchContext context)
    {
        By ng = getParentBy(context);
        return ng.findElement(context);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        By ng = getParentBy(context);
        return ng.findElements(context);
    }
}
