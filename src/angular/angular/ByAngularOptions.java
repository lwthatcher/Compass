package angular.angular;

import org.openqa.selenium.*;

import java.util.List;

/**
 * @author Lawrence Thatcher
 */
public class ByAngularOptions extends By
{
    protected final JavascriptExecutor jse;
    protected String options;

    public ByAngularOptions(JavascriptExecutor jse, String options)
    {
        this.jse = jse;
        this.options = options;
    }

    public ByAngularOptionsValue value(String value)
    {
        return new ByAngularOptionsValue(jse,options,value);
    }

    public ByAngularOptionsLabel label(String label)
    {
        return new ByAngularOptionsLabel(jse,options,label);
    }

    protected String makeJsBy(String oneOrAll)
    {
        return
                "var using = arguments[0] || document;\n" +
                "var optionsDescriptor = '" + options + "';\n" +
                "\n" +
                "  var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\n" +
                "  for (var p = 0; p < prefixes.length; ++p) {\n" +
                "    var selector = '[' + prefixes[p] + 'options=\"' + optionsDescriptor + '\"] option';\n" +
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
