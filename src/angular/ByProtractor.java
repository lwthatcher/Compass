package angular;

import angular.protractor.ByButton;
import angular.protractor.ByButtonText;
import angular.protractor.ByPartialButtonText;
import org.openqa.selenium.JavascriptExecutor;

/**
 *  Extension class of ByAngular that also holds additional search functions supported
 *  by Protractor but not necessarily involving Angular elements.
 *  @author Lawrence Thatcher
 */
public class ByProtractor extends ByAngular
{
    public ByProtractor(JavascriptExecutor jse)
    {
        super(jse);
    }

    /**
     * Searches for a button element based off of the internal text of the button.
     * By default this searches for the complete text of the button.
     * @param buttonText the complete text of the button to search for
     */
    public ByButton button (String buttonText)
    {
        return new ByButtonText(jse,buttonText);
    }

    /**
     * Searches for a button element based off of the internal text of the button.
     * This can be set to search for the complete text or a button that contains the text.
     * @param buttonText the text to search for
     * @param partial If true: search for a button containing the text.
     *                If false: search for the complete text.
     */
    public ByButton button(String buttonText, boolean partial)
    {
        if (partial)
            return new ByPartialButtonText(jse,buttonText);
        else
            return new ByButtonText(jse,buttonText);
    }
}
