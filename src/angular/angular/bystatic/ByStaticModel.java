package angular.angular.bystatic;

import angular.angular.ByAngularModel;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

/**
 * Static accessor for finding elements based off of the angular model
 *
 * @author Lawrence Thatcher
 */
public class ByStaticModel extends ByStatic
{
    private String model;

    public ByStaticModel(String model)
    {
        this.model = model;
    }

    @Override
    protected By getParentBy(SearchContext context)
    {
        return new ByAngularModel(getJSE(context),model);
    }
}
