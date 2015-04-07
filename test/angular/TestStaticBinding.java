package angular;

import angular.AngularTestPlan;
import angular.ByAngular;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TestStaticBinding extends AngularTestPlan
{
    @Test
    public void test_findByBinding_modelElement()
    {
        WebElement element = driver.findElement(ByAngular.ng_binding("todo.user"));
        assert element.getText().trim().equals("Adam's To Do List 3".trim());
        assert element.getTagName().equals("h1");
    }

    @Test
    public void test_findByBinding_controllerFunction()
    {
        WebElement element = driver.findElement(ByAngular.ng_binding("incompleteCount()"));
        assert element.getText().equals("3");
        assert element.getTagName().equals("span");
    }

    @Test
    public void test_findByBinding_nestedElementByBinding()
    {
        WebElement element = driver.findElement(ByAngular.ng_binding("todo.user"));
        element = element.findElement(ng.binding("incompleteCount()"));
        assert element.getText().equals("3");
        assert element.getTagName().equals("span");
    }

    @Test
    public void test_findByBinding_nestedElementByTag()
    {
        WebElement element = driver.findElement(ByAngular.ng_binding("todo.user"));
        element = element.findElement(By.tagName("span"));
        assert element.getText().equals("3");
        assert element.getTagName().equals("span");
    }

    @Test
    public void test_findByBinding_elementInRepeater()
    {
        WebElement element = driver.findElement(ByAngular.ng_binding("item.action"));
        assert element.getText().equals("Buy Flowers");
        assert element.getTagName().equals("td");
    }

    @Test
    public void test_findAllByBinding_elementsInRepeater()
    {
        List<WebElement> elements = driver.findElements(ByAngular.ng_binding("item.action"));

        assert elements.size() == 3;

        assert elements.get(0).getText().equals("Buy Flowers");
        assert elements.get(0).getTagName().equals("td");

        assert elements.get(1).getText().equals("Call Joe");
        assert elements.get(1).getTagName().equals("td");

        assert elements.get(2).getText().equals("Get Shoes");
        assert elements.get(2).getTagName().equals("td");
    }
}
