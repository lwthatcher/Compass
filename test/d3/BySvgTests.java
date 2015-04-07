package d3;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;
import other.SupportedDriver;

import java.util.List;

/**
 * Created by lthatch1 on 3/16/2015.
 *
 * @author Lawrence Thatcher
 */
public class BySvgTests
{
    public static final String BIGGEST_CIRCLE_SELECTOR = "circle[r=\"5\"]";
    public static final String SCATTERPLOT_URL = "http://localhost:8000/html/scatterplot.html";
    public static final String CURVED_LINKS_URL = "http://localhost:8000/html/curved-links.html";

    private WebDriver driver;

    @Test
    public void test_getDefaultSvg()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(ByD3.svg());
        assert svg instanceof D3Element;
    }

    @Test
    public void test_getCircle_nonSpecialSelectorFromSvg()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        D3Element svg = (D3Element)driver.findElement(ByD3.svg());
        D3Element circle = svg.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        String text = p.getText();
        assert text.equals("600,150");
    }

    @Test
    public void test_getAllCircles_byShape()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        List<WebElement> circles = driver.findElements(ByD3.svg().shape());
        assert circles.size() == 11;

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circles.get(10).click();
        p = driver.findElement(By.tagName("p"));
        String text = p.getText();
        assert text.equals("600,150");
    }

    @Test
    public void test_getAllCircles_byCircle_string()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        List<WebElement> circles = driver.findElements(ByD3.svg().shape("circle"));
        assert circles.size() == 11;

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circles.get(10).click();
        p = driver.findElement(By.tagName("p"));
        String text = p.getText();
        assert text.equals("600,150");
    }

    @Test
    public void test_getAllCircles_byCircle_enum()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        List<WebElement> circles = driver.findElements(ByD3.svg().shape(D3Shape.Circle));
        assert circles.size() == 11;

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circles.get(10).click();
        p = driver.findElement(By.tagName("p"));
        String text = p.getText();
        assert text.equals("600,150");
    }

    @Test
    public void test_getCircleWithTitle()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(CURVED_LINKS_URL);

        WebElement marius = driver.findElement(ByD3.svg().shape().withTitle("Marius"));
        assert marius != null;
        assert marius.getText().equals("Marius");
    }

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
