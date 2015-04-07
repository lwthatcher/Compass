package angular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Lawrence Thatcher
 */
public class TestStaticModel extends AngularTestPlan
{
    @Test
    public void test_findByModel_entryTextBox()
    {
        WebElement element = driver.findElement(ByAngular.ng_model("actionText"));
        assert element.getTagName().equals("input");
        assert element.getAttribute("class").contains("form-control");
    }

    @Test
    public void test_findByModel_checkbox()
    {
        WebElement element = driver.findElement(ByAngular.ng_model("showComplete"));
        assert element.getTagName().equals("input");
        assert element.getAttribute("type").equals("checkbox");
    }

    @Test
    public void test_addElementUsingNgModel()
    {
        WebElement textbox = driver.findElement(ByAngular.ng_model("actionText"));

        WebElement element = driver.findElement(ng.repeater("item in todo.items"));
        assert element.getText().equals("Buy Flowers");

        textbox.sendKeys("Ask for donations");
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        element = driver.findElement(ng.repeater("item in todo.items"));
        assert element.getText().equals("Ask for donations");
    }

    @Test
    public void test_findByModel_elementInRepeater()
    {
        WebElement checkbox = driver.findElement(ByAngular.ng_model("item.done"));
        assert checkbox.getTagName().equals("input");

        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        assert rows.size() == 3;

        checkbox.click();

        table = driver.findElement(By.tagName("tbody"));
        rows = table.findElements(By.tagName("tr"));
        assert rows.size() == 2;
    }

    @Test
    public void test_findAllByModel_elementsInRepeater()
    {
        List<WebElement> checkboxes = driver.findElements(ByAngular.ng_model("item.done"));
        assert checkboxes.size() == 3;


        checkboxes.get(0).click();

        //must get list again after each click since the WebElement object might change in Java
        checkboxes = driver.findElements(ByAngular.ng_model("item.done"));
        assert checkboxes.size() == 2;

        checkboxes.get(0).click();

        checkboxes = driver.findElements(ByAngular.ng_model("item.done"));
        assert checkboxes.size() == 1;

        checkboxes.get(0).click();

        checkboxes = driver.findElements(ByAngular.ng_model("item.done"));
        assert checkboxes == null || checkboxes.size() == 0;
    }
}
