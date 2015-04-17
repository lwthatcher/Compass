package d3.by.shape;

import java.util.HashMap;
import java.util.Map;

/**
 * Extension of ByShape class.
 * In addition to looking for the specified shapes, this class allows you to search for certain attributes that the specified shape must have.
 * These attributes can be added one at a time as an Attribute/Value pair, or inserted in as a group of attributes using a Map.
 * If the value for a given attribute is null, then it simply looks to see if that attribute is present.
 * @author Lawrence Thatcher
 */
public class ByShapeWithAttribute extends ByShape
{
    private Map<String,String> attributes;
    private AttributeSelectionType selectionType = AttributeSelectionType.EXACT_TEXT;

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

    public ByShapeWithAttribute setType(AttributeSelectionType type)
    {
        this.selectionType = type;
        return this;
    }

    //Helper Functions
    private void setAttributeMap(ByShape by)
    {
        if (by instanceof ByShapeWithAttribute)
        {
            attributes = ((ByShapeWithAttribute) by).attributes;
            selectionType = ((ByShapeWithAttribute) by).selectionType;
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
                        selector += selectionType.getOperator() + "\"" + attributes.get(attr) + "\"";
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
