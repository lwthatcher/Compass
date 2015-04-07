package angular.angular;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds the option element(s) that have the specified inner-text.
 * Since css selectors don't have a method to do a complete match to inner text,
 * rather than overriding the JavaScript query this class executes the regular query in the browser
 * then filters the result on the server(tester) side.
 *
 * Subclass of ByAngularOptions
 *
 * @author Lawrence Thatcher
 */
public class ByAngularOptionsLabel extends ByAngularOptions
{
    private String label;

    public ByAngularOptionsLabel(JavascriptExecutor jse, String options, String label)
    {
        super(jse, options);
        this.label = label;
    }

    @Override
    public WebElement findElement(SearchContext context)
    {
        return getMatchingElements(context).get(0);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        return getMatchingElements(context);
    }

    private List<WebElement> getMatchingElements(SearchContext context)
    {
        if (context instanceof WebDriver)
        {
            context = null;
        }
        List<WebElement> options = (List<WebElement>) jse.executeScript(makeJsBy(""), context);
        List<WebElement> result = new ArrayList<WebElement>();
        for (WebElement option : options)
        {
            if (option.getText().equals(label))
                result.add(option);
        }
        return result;
    }
}
