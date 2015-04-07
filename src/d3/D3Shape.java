package d3;

import exceptions.UnrecognizedShapeException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lthatch1 on 3/26/2015.
 *
 * @author Lawrence Thatcher
 */
public enum D3Shape
{
    Circle("circle"),
    Ellipse("ellipse"),
    Line("line"),
    PolyLine("polyline"),
    Polygon("polygon"),
    Rectangle("rect");


    private String name;

    private D3Shape(String shape)
    {
        this.name = shape;
    }

    public String getName()
    {
        return name;
    }

    public static D3Shape toShape(String shape)
    {
        for (D3Shape s : values())
        {
            if (s.name.equals(shape))
                return s;
        }
        throw new UnrecognizedShapeException(shape);
    }

    public static List<String> acceptedValues()
    {
        List<String> result = new ArrayList<String>();
        for (D3Shape s : values())
        {
            result.add(s.name);
        }
        return result;
    }
}
