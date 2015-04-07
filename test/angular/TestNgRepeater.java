package angular;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import other.SupportedDriver;

import java.util.List;

public class TestNgRepeater extends AngularTestPlan
{
    @Test
    public void test_findByRepeater()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items"));
        assert element.getText().equals("Buy Flowers");
    }

    @Test
    public void test_findAllByRepeater()
    {
        List<WebElement> elements = driver.findElements(ng.repeater("item in todo.items"));
        assert elements.size() == 3;

        assert elements.get(0).getText().equals("Buy Flowers");
        assert elements.get(1).getText().equals("Call Joe");
        assert elements.get(2).getText().equals("Get Shoes");
    }

    @Test
    public void test_findByRepeaterRow()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items").row(2)); //indexes start at 1, not 0

        assert element.getText().equals("Call Joe");
        assert element.getTagName().equals("tr");
    }

    @Test
    public void test_findSubElementsByRepeaterRow()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items").row(2));
        assert element.getText().equals("Call Joe");

        WebElement text = element.findElement(By.tagName("td"));
        assert text.getText().equals("Call Joe");

        WebElement button = element.findElement(By.tagName("input"));
        assert button.getAttribute("type").equals("checkbox");
        button.click();

        element = driver.findElement(ng.repeater("item in todo.items").row(2));
        assert element.getText().equals("Get Shoes");
    }

    @Test
    public void test_findByRepeaterColumn_exceptionOnFindElement_singular()
    {
        try
        {
            driver.findElement(ng.repeater("item in todo.items").column("action"));
            assert false;
        }
        catch (Exception e)
        {
            assert e.getMessage().contains("This locator zooms in on a multiple cells, findElement() is meaningless");
        }
    }

    @Test
    public void test_findAllByRepeaterColumn()
    {
        List<WebElement> elements = driver.findElements(ng.repeater("item in todo.items").column("action"));

        assert elements.get(0).getText().equals("Buy Flowers");
        assert elements.get(0).getTagName().equals("td");

        assert elements.get(1).getText().equals("Call Joe");
        assert elements.get(1).getTagName().equals("td");

        assert elements.get(2).getText().equals("Get Shoes");
        assert elements.get(2).getTagName().equals("td");
    }

    @Test
    public void test_findByRepeaterCell_rowThenCol()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items").row(1).column("action"));
        assert element.getText().equals("Buy Flowers");
    }

    @Test
    public void test_findByRepeaterCell_colThenRow()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items").column("action").row(1));
        assert element.getText().equals("Buy Flowers");
    }

    @Test
    public void test_findByRepeaterCell_colThenRow_secondRow()
    {
        WebElement element = driver.findElement(ng.repeater("item in todo.items").column("action").row(2));
        assert element.getText().equals("Call Joe");
    }

    @Test
    public void test_findByRepeaterCell_exceptionOnFindElements_plural()
    {
        try
        {
            driver.findElements(ng.repeater("item in todo.items").row(1).column("action"));
            assert false;
        }
        catch (Exception e)
        {
            assert e.getMessage().contains("This locator zooms in on a single row, findElements() is meaningless");
        }
    }
}
