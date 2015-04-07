package angular.protractor;

import org.openqa.selenium.*;

import java.util.List;


public abstract class ByButton extends By
{
    protected final JavascriptExecutor jse;
    protected String text;

    public ByButton(JavascriptExecutor jse, String text)
    {
        this.jse = jse;
        this.text = text;
    }

    protected abstract String makeJsBy(String oneOrAll);

    @Override
    public WebElement findElement(SearchContext context)
    {
        if (context instanceof WebDriver)
        {
            context = null;
        }
        return (WebElement) jse.executeScript(makeJsBy("[0]"), context);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        if (context instanceof WebDriver)
        {
            context = null;
        }
        return (List<WebElement>) jse.executeScript(makeJsBy(""), context);
    }
}
