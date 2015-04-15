package d3.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

import java.util.Comparator;

/**
 * Sorts nodes by their radius.
 *
 * @author Lawrence Thatcher
 */
public class NodeSizeComparator implements Comparator<WebElement>
{
    @Override
    public int compare(WebElement o1, WebElement o2)
    {
        int r1 = Integer.parseInt(o1.getAttribute("r"));
        int r2 = Integer.parseInt(o2.getAttribute("r"));
        if (r1 < r2)
            return -1;
        else if (r1 == r2)
            return 0;
        else
            return 1;
    }
}
