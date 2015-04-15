package d3.by.shape;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Searches for elements by their shape type. If no shape is specified, it searches for all valid shapes.
 * Valid shapes are listed in the D3Shape enum class.
 *
 * @author Lawrence Thatcher
 */
public class ByShape extends By
{
    protected String prepend;
    protected List<D3Shape> searchFor;

    //Constructors
    public ByShape()
    {
        prepend = null;
        setSearchFor(D3Shape.values());
    }

    public ByShape(String prepend)
    {
        this.prepend = prepend;
        setSearchFor(D3Shape.values());
    }

    public ByShape(String prepend, D3Shape... shapes)
    {
        this.prepend = prepend;
        setSearchFor(shapes);
    }
    //Additional Locator Options
    public ByShapeWithTitle withTitle(String title)
    {
        return new ByShapeWithTitle(this, title);
    }

    public ByShapeWithAttribute withAttribute(String attribute, String value)
    {
        return new ByShapeWithAttribute(attribute,value,this);
    }

    public ByShapeWithAttribute withAttributes(Map<String,String> attributes)
    {
        return new ByShapeWithAttribute(attributes,this);
    }

    //Finders
    @Override
    public WebElement findElement(SearchContext context)
    {
        WebElement e = context.findElement(getSelector());
        return new D3Element(e);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        List<WebElement> elements = context.findElements(getSelector());
        List<WebElement> result = new ArrayList<WebElement>();
        for (WebElement element : elements)
        {
            result.add(new D3Element(element));
        }
        return result;
    }

    //Helper Methods
    private By getSelector()
    {
        String selector = getSearchSelector();
        if (prepend == null)
            return By.cssSelector(selector);
        else
        {
            return By.cssSelector(prepend + " " + selector);
        }
    }

    protected String getSearchSelector()
    {
        String selector = "";
        for (int i = 0; i < searchFor.size(); i++)
        {
            selector += searchFor.get(i).getName();
            if (i+1 < searchFor.size())
                selector += ", ";
        }
        return selector;
    }

    private void setSearchFor(D3Shape[] shapes)
    {
        searchFor = new ArrayList<D3Shape>();
        Collections.addAll(searchFor, shapes);
    }
}
