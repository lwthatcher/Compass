package angular.angular.bystatic;

import angular.angular.ByAngularOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

/**
 *
 * @author Lawrence Thatcher
 */
public class ByStaticOptions extends ByStatic
{
    private String option;

    public ByStaticOptions(String option)
    {
        this.option = option;
    }

    @Override
    protected By getParentBy(SearchContext context)
    {
        return new ByAngularOptions(getJSE(context), option);
    }
}
