package selenium.unit.svg;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import other.SupportedDriver;

import static selenium.unit.svg.AccessSvgElements.SCATTERPLOT_URL;

/**
 * Created by Lawrence on 3/12/2015.
 */
public class FindSvgElement
{
    public static final String SVG_SELECTOR = "svg";

    private WebDriver driver;

    @Test
    public void test_Chrome_CanAccessSVG_viaCSS()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(By.cssSelector(SVG_SELECTOR));
        String width = svg.getAttribute("width");
        String height = svg.getAttribute("height");

        assert width.equals("500");
        assert height.equals("300");
    }

    @Test
    public void test_FF_CanAccessSVG_viaCSS()
    {
        driver = SupportedDriver.FireFox.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(By.cssSelector(SVG_SELECTOR));
        String width = svg.getAttribute("width");
        String height = svg.getAttribute("height");

        assert width.equals("500");
        assert height.equals("300");
    }

    @Test
    public void test_Safari_CanAccessSVG_viaCSS()
    {
        driver = SupportedDriver.Safari.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(By.cssSelector(SVG_SELECTOR));
        String width = svg.getAttribute("width");
        String height = svg.getAttribute("height");

        assert width.equals("500");
        assert height.equals("300");
    }

    @Test
    public void test_IE_CanAccessSVG_viaCSS()
    {
        driver = SupportedDriver.InternetExplorer.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(By.cssSelector(SVG_SELECTOR));
        String width = svg.getAttribute("width");
        String height = svg.getAttribute("height");

        assert width.equals("500");
        assert height.equals("300");
    }

    @Test
    public void test_Phantom_CanAccessSVG_viaCSS()
    {
        driver = SupportedDriver.Phantom.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement svg = driver.findElement(By.cssSelector(SVG_SELECTOR));
        String width = svg.getAttribute("width");
        String height = svg.getAttribute("height");

        assert width.equals("500");
        assert height.equals("300");
    }

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
