package angular;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by lthatch1 on 3/3/2015.
 *
 * @author Lawrence Thatcher
 */
public class TestNgOptions extends AngularTestPlan
{
    private static final String animals = "animal as animal.name for animal in btn.animals track by animal.id";
    private static final String ids = "id as id.name for id in btn.ids track by id.id";

    public void openStartPage()
    {
        assert driver != null;
        driver.get(OPTIONS);
    }

    @Test
    public void test_findByOptions_initialSelection()
    {
        WebElement element = driver.findElement(ng.options(animals));
        assert element.getTagName().equals("option");
        assert element.getAttribute("value").equals("?");
    }

    @Test
    public void test_findAllByOptions()
    {
        List<WebElement> elements = driver.findElements(ng.options(animals));
        assert elements.get(0).getTagName().equals("option");
        assert elements.get(0).getAttribute("value").equals("?");

        assert elements.get(1).getTagName().equals("option");
        assert elements.get(1).getAttribute("value").equals("0");
        assert elements.get(1).getText().equals("Turtle");

        assert elements.get(21).getTagName().equals("option");
        assert elements.get(21).getAttribute("value").equals("20");
        assert elements.get(21).getText().equals("Snail");

        assert elements.size() == 24;
    }

    @Test
    public void test_clickOnOption_viaFindAll()
    {
        WebElement price = driver.findElement(ng.binding("selectedItem.price | currency"));
        WebElement exists = driver.findElement(ng.binding("selectedItem.exists"));

        assert price.getText().equals("");
        assert exists.getText().equals("");

        List<WebElement> elements = driver.findElements(ng.options(animals));
        assert elements.get(0).getTagName().equals("option");
        assert elements.get(0).getAttribute("value").equals("?");
        assert elements.size() == 24;

        elements.get(16).click();

        elements = driver.findElements(ng.options(animals));
        assert elements.get(0).getTagName().equals("option");
        assert elements.get(0).getAttribute("value").equals("0");
        assert elements.get(0).getText().equals("Turtle");
        assert elements.size() == 23;

        price = driver.findElement(ng.binding("selectedItem.price | currency"));
        exists = driver.findElement(ng.binding("selectedItem.exists"));

        assert price.getText().equals("$15.00");
        assert exists.getText().equals("true");
    }

    @Test
    public void test_clickOnOption_viaValue()
    {
        WebElement price = driver.findElement(ng.binding("selectedItem.price | currency"));
        WebElement exists = driver.findElement(ng.binding("selectedItem.exists"));

        assert price.getText().equals("");
        assert exists.getText().equals("");

        WebElement element = driver.findElement(ng.options(animals).value("10"));
        element.click();

        price = driver.findElement(ng.binding("selectedItem.price | currency"));
        exists = driver.findElement(ng.binding("selectedItem.exists"));

        assert price.getText().equals("$100,000.00");
        assert exists.getText().equals("false");
    }

    @Test
    public void test_findByOptions_withValue()
    {
        WebElement element = driver.findElement(ng.options(animals).value("10"));
        assert element.getTagName().equals("option");
        assert element.getAttribute("value").equals("10");
        assert element.getText().equals("Nine-Tails");
    }

    @Test
    public void test_findAllByOptions_withValue()
    {   //You can find multiple elements with the same value, but hopefully this doesn't normally occur
        List<WebElement> elements = driver.findElements(ng.options(ids).value("0"));
        assert elements.size() == 3;
        assert elements.get(0).getTagName().equals("option");
        assert elements.get(1).getTagName().equals("option");
        assert elements.get(2).getTagName().equals("option");
    }

    @Test
    public void test_findByOptions_withLabel()
    {
        WebElement element = driver.findElement(ng.options(animals).label("cat"));
        assert element.getTagName().equals("option");
        assert element.getAttribute("value").equals("8");
        assert element.getText().equals("cat");
    }

    @Test
    public void test_findByOptions_withLabel_matchesExactText()
    {
        WebElement element = driver.findElement(ng.options(animals).label("Big Bird"));
        assert element.getTagName().equals("option");
        assert element.getAttribute("value").equals("17");
        assert element.getText().equals("Big Bird");
    }

    @Test
    public void test_findAllByOptions_withLabel_matchesExactText()
    {
        List<WebElement> elements = driver.findElements(ng.options(animals).label("Dragon"));
        assert elements.size() == 1;
        assert elements.get(0).getTagName().equals("option");
        assert elements.get(0).getAttribute("value").equals("3");
        assert elements.get(0).getText().equals("Dragon");
    }
}
