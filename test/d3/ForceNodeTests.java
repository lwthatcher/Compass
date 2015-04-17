package d3;

import d3.by.ByD3;
import d3.by.shape.D3Shape;
import d3.element.ForceNode;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.D3Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import other.SupportedDriver;

import java.util.List;

import static d3.LesMiserablesCharacters.JONDRETTE;
import static d3.LesMiserablesCharacters.JONDRETTE_NEIGHBOR;

/**
 *
 * @author Lawrence Thatcher
 */
public class ForceNodeTests
{
    public static final String CURVED_LINKS_URL = "http://localhost:8000/html/curved-links.html";
    public static final String LINE_LINKS_URL = "http://localhost:8000/html/force.html";

    private WebDriver driver;

    @Test
    public void test_highlightOn() throws Exception
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(CURVED_LINKS_URL);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        D3Element circle = (D3Element) wait.until(ExpectedConditions.presenceOfElementLocated(ByD3.svg().shape(D3Shape.Circle).withTitle(JONDRETTE)));
        ForceNode jondrette = new ForceNode(circle);

        assert jondrette.getAttribute("r").equals("5");

        jondrette.highlightOn();

        Thread.sleep(1100);
        assert jondrette.getAttribute("r").equals("8");
    }

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
