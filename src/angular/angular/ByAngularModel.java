package angular.angular;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Mimics the Protractor findByModel function by returning the element(s) that match(es) the specified model.
 * @author Lawrence Thatcher
 */
public class ByAngularModel extends By
{
    private final JavascriptExecutor jse;

    private String model;

    public ByAngularModel(JavascriptExecutor jse, String model)
    {
        this.jse = jse;
        this.model = model;
    }

    private String makeJsBy(String oneOrAll)
    {
        return
                "var using = arguments[0] || document;\n" +
                "var model = '" + model + "';\n" +
                "\n" +
                "  var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\n" +
                "  for (var p = 0; p < prefixes.length; ++p) {\n" +
                "    var selector = '[' + prefixes[p] + 'model=\"' + model + '\"]';\n" +
                "    var elements = using.querySelectorAll(selector);\n" +
                "    if (elements.length) {\n" +
                "      return elements" + oneOrAll +";\n" +
                "    }\n" +
                "  }";
    }

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
