package angular.protractor;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Implementation of the protractor function findByButtonText
 * @author Lawrence Thatcher
 */
public class ByButtonText extends ByButton
{
    public ByButtonText(JavascriptExecutor jse, String text)
    {
        super(jse,text);
    }

    protected String makeJsBy(String oneOrAll)
    {
        return
                "var using = arguments[0] || document;\n" +
                "var searchText = '" + text + "';\n" +
                "var elements = using.querySelectorAll('button, input[type=\"button\"], input[type=\"submit\"]');\n" +
                "var matches = [];\n" +
                "for (var i = 0; i < elements.length; ++i) {\n" +
                "  var element = elements[i];\n" +
                "  var elementText;\n" +
                "  if (element.tagName.toLowerCase() == 'button') {\n" +
                "    elementText = element.innerText || element.textContent;\n" +
                "  } else {\n" +
                "    elementText = element.value;\n" +
                "  }\n" +
                "  if (elementText.trim() === searchText) {\n" +
                "    matches.push(element);\n" +
                "  }\n" +
                "}" +
                "return matches" + oneOrAll + ";";
    }

}
