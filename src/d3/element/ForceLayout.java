package d3.element;

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
