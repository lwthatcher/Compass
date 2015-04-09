package d3.by.shape;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lawrence Thatcher
 */
public class ByShapeWithAttribute extends ByShape
{
    private Map<String,String> attributes;

    public ByShapeWithAttribute(String attr, String value, ByShape by)
    {
        this.prepend = by.prepend;
        this.searchFor = by.searchFor;
        setAttributeMap(by);
        attributes.put(attr,value);
    }

    public ByShapeWithAttribute(Map<String,String> attrs, ByShape by)
    {
        this.prepend = by.prepend;
        this.searchFor = by.searchFor;
        setAttributeMap(by);
        this.attributes.putAll(attrs);
    }

    //Helper Functions
    private void setAttributeMap(ByShape by)
    {
        if (by instanceof ByShapeWithAttribute)
        {
            attributes = ((ByShapeWithAttribute) by).attributes;
        }
        else attributes = new HashMap<>();
    }

    protected String getSearchSelector()
    {
        String selector = "";
        for (int i = 0; i < searchFor.size(); i++)
        {
            selector += searchFor.get(i).getName();

            //specify attributes
            if (attributes.size() > 0)
            {
                for (String attr : attributes.keySet())
                {
                    selector += "[";
                    selector += attr + "";
                    if (attributes.get(attr) != null)
                    {
                        selector += "=\"" + attributes.get(attr) + "\"";
                    }
                    selector += "]";
                }
            }

            //comma to separate between shapes
            if (i+1 < searchFor.size())
                selector += ", ";
        }

        return selector;
    }
}
