package angular;

import angular.angular.*;
import angular.angular.bystatic.ByStaticBinding;
import angular.angular.bystatic.ByStaticModel;
import angular.angular.bystatic.ByStaticOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class ByAngular
{
    protected final JavascriptExecutor jse;

    public ByAngular(JavascriptExecutor jse) {
        this.jse = jse;
    }

    public ByAngularRepeater repeater(String repeater) {
        return new ByAngularRepeater(jse, repeater);
    }

    public ByAngularBinding binding(String binding) {
        return new ByAngularBinding(jse, binding);
    }

    public ByAngularModel model(String model)
    {
        return new ByAngularModel(jse, model);
    }

    public ByAngularOptions options(String options)
    {
        return new ByAngularOptions(jse, options);
    }

    public static ByStaticBinding ng_binding(String binding)
    {
        return new ByStaticBinding(binding);
    }

    public static ByStaticModel ng_model(String model)
    {
        return new ByStaticModel(model);
    }

    public static ByStaticOptions ng_options(String options)
    {
        return new ByStaticOptions(options);
    }

    public abstract static class BaseBy extends By
    {
        protected final JavascriptExecutor jse;

        public BaseBy(JavascriptExecutor jse)
        {
            this.jse = jse;
        }

        protected final void errorIfNull(Object o)
        {
            if (o == null || o instanceof List && ((List) o).size() == 0)
            {
                throw new NoSuchElementException(this + " didn't have any matching elements at this place in the DOM");
            }
        }

    }
}
