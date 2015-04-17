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
    public static final double DEFAULT_HIGHLIGHT_SIZE = 3.0;
    public static final String HIGHLIGHT_COLOR = "#FFFF00";

    private int index;
    private Double oldSize = null;
    private String oldColor = null;

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

    public void highlightOn()
    {
        oldSize = Double.parseDouble(this.getAttribute("r"));
        oldColor = this.getAttribute("fill");
        double newSize = oldSize + DEFAULT_HIGHLIGHT_SIZE;
        getDriver().executeScript(highlightOnJS(),element,newSize,HIGHLIGHT_COLOR);
    }

    public void highlightOff()
    {
        double newSize = oldSize;
        if (oldSize == null)
        {
            newSize = Double.parseDouble(this.getAttribute("r"));
        }
        String newColor = oldColor;
        if (oldColor == null)
        {
            oldColor = this.getAttribute("fill");
        }
        getDriver().executeScript(highlightOnJS(),element,newSize,newColor);
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

    private String highlightOnJS()
    {
        String result =
                "var node = arguments[0];\n" +
                "var dx = arguments[1];\n" +
                "var color = arguments[2];\n" +
                "d3.select(node)" +
                //".data()[0]" +
                ".transition()" +
                ".duration(1000)" +
                ".attr(\"r\", dx)" +
                ".attr(\"fill\", color);";
        return result;
    }

    private String highlightOffJS()
    {
        String result =
                "var node = arguments[0];\n" +
                "var dx = arguments[1];\n" +
                "d3.select(node)" +
                //".data()[0]" +
                ".transition()" +
                ".duration(1000)" +
                ".attr(\"r\", dx);";
        return result;
    }
}
