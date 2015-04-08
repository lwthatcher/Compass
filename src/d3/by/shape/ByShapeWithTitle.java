package d3.by.shape;

import d3.by.shape.ByShape;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lawrence Thatcher
 */
public class ByShapeWithTitle extends By
{
    private ByShape byShape;
    private String title = null;

    public ByShapeWithTitle(ByShape byShape,String title)
    {
        this.byShape = byShape;
        this.title = title;
    }

    public WebElement findElement(SearchContext context)
    {
        try
        {
            return findElements(context).get(0);
        }
        catch (IndexOutOfBoundsException ignore)
        {
            return null;
        }
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        List<WebElement> shapes = byShape.findElements(context);
        List<WebElement> result = new ArrayList<WebElement>();

        for(WebElement shape : shapes)
        {
            try
            {
                if (shape.findElement(By.tagName("title")).getText().equals(title))
                {
                    result.add(shape);
                }
            }
            catch (Exception ignore)
            { }
        }
        return result;
    }
}
