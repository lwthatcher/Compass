package d3.by;

/**
 *
 * @author Lawrence Thatcher
 */
public class ByD3
{
    public static BySVG svg()
    {
        return new BySVG();
    }

    public static ByPath path()
    {
        return new ByPath();
    }

    public static ByGroup group()
    {
        return new ByGroup();
    }
}
