package d3;

import d3.by.ByD3;
import d3.by.shape.D3Shape;
import d3.element.ForceLayout;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import other.SupportedDriver;

import java.util.ArrayList;
import java.util.List;

import static d3.LesMiserablesCharacters.*;

/**
 * @author Lawrence Thatcher
 */
public class ByNeighborNodeTests
{
    public static final String CURVED_LINKS_URL = "http://localhost:8000/html/curved-links.html";
    public static final String LINE_LINKS_URL = "http://localhost:8000/html/force.html";

    private WebDriver driver;

    @Test
    public void test_GetNeighbors_curves()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(CURVED_LINKS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        D3Element circle = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(JONDRETTE)));
        List<D3Element> neighbors = circle.getNeighborNodes();
        assert neighbors.size() == 1;
        assert neighbors.get(0).getText().equals(JONDRETTE_NEIGHBOR);
    }

    @Test
    public void test_GetManyNeighbors_curves()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(CURVED_LINKS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        D3Element circle = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(MYRIEL)));
        List<D3Element> neighbors = circle.getNeighborNodes();
        for (WebElement neighbor : neighbors)
        {
            System.out.println(neighbor.getText());
            assert MyrielNeighbors().contains(neighbor.getText());
        }
        assert neighbors.size() == 10;
    }

    @Test
    public void test_GetNeighbors_lines()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(LINE_LINKS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        D3Element circle = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(JONDRETTE)));
        List<D3Element> neighbors = circle.getNeighborNodes();
        assert neighbors.size() == 1;
        assert neighbors.get(0).getText().equals(JONDRETTE_NEIGHBOR);

    }

    @Test
    public void test_GetNeighborsOfGroup_doesNotDuplicateCommonNeighbors()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(LINE_LINKS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        D3Element baptistine = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(BAPTISTINE)));
        D3Element magloire = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(MAGLOIRE)));

        List<D3Element> group = new ArrayList<>();
        group.add(baptistine);
        group.add(magloire);

        List<D3Element> neighbors = ForceLayout.getAllNeighbors(group);
        for (D3Element neighbor : neighbors)
        {
            String name = neighbor.getText();
            assert name.equals(MYRIEL) || name.equals(JEAN_VALJEAN);
        }
        assert neighbors.size() == 2;
    }

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
