package angular.angular.bystatic;

import angular.angular.ByAngularBinding;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class ByStaticBinding extends ByStatic
{
    private String binding;

    public ByStaticBinding(String binding)
    {
        this.binding = binding;
    }

    @Override
    protected By getParentBy(SearchContext context)
    {
        return new ByAngularBinding(getJSE(context), binding);
    }
}
