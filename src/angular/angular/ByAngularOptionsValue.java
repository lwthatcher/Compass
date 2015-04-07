package angular.angular;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Finds the option element(s) that have the specified value.
 * Subclass of ByAngularOptions
 *
 * @author Lawrence Thatcher
 */
public class ByAngularOptionsValue extends ByAngularOptions
{
    private String value;

    public ByAngularOptionsValue(JavascriptExecutor jse, String options, String value)
    {
        super(jse, options);
        this.value = value;
    }

    protected String makeJsBy(String oneOrAll)
    {
        return
                "var using = arguments[0] || document;\n" +
                        "var optionsDescriptor = '" + options + "';\n" +
                        "\n" +
                        "  var prefixes = ['ng-', 'ng_', 'data-ng-', 'x-ng-', 'ng\\\\:'];\n" +
                        "  for (var p = 0; p < prefixes.length; ++p) {\n" +
                        "    var selector = '[' + prefixes[p] + 'options=\"' + optionsDescriptor + '\"] option[value=\"" + value + "\"]';\n" +
                        "    var elements = using.querySelectorAll(selector);\n" +
                        "    if (elements.length) {\n" +
                        "      return elements" + oneOrAll +";\n" +
                        "    }\n" +
                        "  }";
    }
}
