package d3.by.shape;

/**
 * @author Lawrence Thatcher
 */
public enum AttributeSelectionType
{
    EXACT_TEXT("="),
    SUBSTRING("*="),
    STARTS_WITH("|="),
    BEGINS_WITH("^="),
    ENDS_WITH("$="),
    CONTAINS_WORD("~=");

    private String operator;

    private AttributeSelectionType(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
}
