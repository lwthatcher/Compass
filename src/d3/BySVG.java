package d3;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lawrence Thatcher
 */
public class BySVG extends By
{
    protected static final String SVG_SELECTOR = "svg";

    public BySVG()
    {}

    public ByShape shape()
    {
        return new ByShape(SVG_SELECTOR);
    }

    public ByShape shape(String... shapes)
    {
        D3Shape[] args = new D3Shape[shapes.length];
        int i = 0;
        for (String shape : shapes)
        {
            args[i] = D3Shape.toShape(shape);
            i++;
        }
        return new ByShape(SVG_SELECTOR,args);
    }

    public ByShape shape(D3Shape... shapes)
    {
        return new ByShape(SVG_SELECTOR,shapes);
    }

    @Override
    public WebElement findElement(SearchContext context)
    {
        WebElement e = context.findElement(By.cssSelector(SVG_SELECTOR));
        return new D3Element(e);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        List<WebElement> elements = context.findElements(By.cssSelector(SVG_SELECTOR));
        List<WebElement> result = new ArrayList<WebElement>();
        for (WebElement element : elements)
        {
            result.add(new D3Element(element));
        }
        return result;
    }
}
