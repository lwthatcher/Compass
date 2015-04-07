package d3;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.D3Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import other.SupportedDriver;

import java.util.List;

/**
 * Created by lthatch1 on 4/1/2015.
 *
 * @author Lawrence Thatcher
 */
public class ByNeighborNodeTests
{
    public static final String CURVED_LINKS_URL = "http://localhost:8000/html/curved-links.html";
    public static final String LINE_LINKS_URL = "http://localhost:8000/html/force.html";

    private WebDriver driver;

    private static final String JEAN_VALJEAN = "Valjean";
    private static final String JONDRETTE = "Jondrette";
    private static final String JONDRETTE_NEIGHBOR = "Mme.Burgon";

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

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
