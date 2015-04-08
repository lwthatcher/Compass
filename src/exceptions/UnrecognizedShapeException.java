package exceptions;

import d3.by.shape.D3Shape;
import org.openqa.selenium.WebDriverException;

/**
 * Created by lthatch1 on 3/25/2015.
 *
 * @author Lawrence Thatcher
 */
public class UnrecognizedShapeException extends WebDriverException
{
    public UnrecognizedShapeException(String shape)
    {
        super("The shape '" + shape + "' is not a recognized svg shape.\n" +
              "Accepted values are: " + D3Shape.acceptedValues().toString());
    }
}
