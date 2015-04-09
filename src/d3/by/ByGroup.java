package d3.by;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Simple selector for finding a group element within an svg.
 * @author Lawrence Thatcher
 */
public class ByGroup extends By
{
    protected static final String GROUP_SELECTOR = "g";

    @Override
    public WebElement findElement(SearchContext context)
    {
        return context.findElement(getSelector());
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        return context.findElements(getSelector());
    }

    private By getSelector()
    {
        return By.cssSelector(GROUP_SELECTOR);
    }
}
