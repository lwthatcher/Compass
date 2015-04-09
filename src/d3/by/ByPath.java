package d3.by;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Uses a simple CSS Selector to locate a path element.
 *
 * @author Lawrence Thatcher
 */
public class ByPath extends By
{
    protected static final String PATH_SELECTOR = "path";

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
        return By.cssSelector(PATH_SELECTOR);
    }
}
