package d3.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;

/**
 * Represents the bounding SVG box.
 *
 * @author Lawrence Thatcher
 */
public class SvgElement extends D3Element
{
    public SvgElement(WebElement e)
    {
        super(e);
    }

    public ForceLayout forceLayout()
    {
        return new ForceLayout(this.element);
    }
}
