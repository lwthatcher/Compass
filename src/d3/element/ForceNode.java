package d3.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

/**
 * Class that represents a node in the D3 force layout.
 *
 * @author Lawrence Thatcher
 */
public class ForceNode extends D3Element
{
    private int index;

    public ForceNode(WebElement e)
    {
        super(e);
        index = getIndex();
    }

    public int getIndex()
    {
        Object result = getDriver().executeScript(getIndexJS(),element);
        long i = (Long)result;
        return (int)i;
    }

    public String toString()
    {
        return "Node: " + Integer.toString(index);
    }

    //Scripts
    private String getIndexJS()
    {
        return
                "var node = arguments[0];\n" +
                "console.log(d3.select(node).data()[0].index);\n" +
                "return d3.select(node).data()[0].index";
    }
}
