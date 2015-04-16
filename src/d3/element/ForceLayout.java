package d3.element;

import d3.by.shape.ByShape;
import d3.by.shape.D3Shape;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lawrence Thatcher
 */
public class ForceLayout extends D3Element
{

    public ForceLayout(WebElement e)
    {
        super(e);
    }

    //TODO: extract out into abstract class for layouts or svg elements
    public By byShape(String... shapes)
    {
        D3Shape[] args = new D3Shape[shapes.length];
        int i = 0;
        for (String shape : shapes)
        {
            args[i] = D3Shape.toShape(shape);
            i++;
        }
        return new ByShape(null,args);
    }

    public By byShape(D3Shape... shapes)
    {
        return new ByShape(null,shapes);
    }

    //Static Methods
    public static List<D3Element> getAllNeighbors(List<D3Element> nodes)
    {
        Set<D3Element> totalNeighbors = new HashSet<D3Element>();
        for (D3Element node : nodes)
        {
            List<D3Element> localNeighbors = node.getNeighborNodes();
            for (D3Element potentialNeighbor : localNeighbors)
            {
                if (!nodes.contains(potentialNeighbor))
                {
                    totalNeighbors.add(potentialNeighbor);
                }
            }
        }
        return new ArrayList<>(totalNeighbors);
    }
}
