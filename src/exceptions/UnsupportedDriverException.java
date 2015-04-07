package exceptions;


import org.openqa.selenium.WebDriverException;

public class UnsupportedDriverException extends WebDriverException
{
    public UnsupportedDriverException(String driver)
    {
        super("The driver: '" + driver + "' is not supported in this context.");
    }
}
