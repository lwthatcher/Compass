package selenium.unit.svg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import other.SupportedDriver;

/**
 * Created by Lawrence on 3/12/2015.
 */
public class AccessSvgElements
{
    public static final String BIGGEST_CIRCLE_SELECTOR = "circle[r=\"5\"]";
    public static final String SCATTERPLOT_URL = "http://localhost:8000/html/scatterplot.html";

    private WebDriver driver;

    @Test
    public void test_Chrome_CanAccessCircle()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));


        String x = circle.getAttribute("cx");
        String y = circle.getAttribute("cy");

        assert x.equals("460");
        assert y.equals("20");
    }

    @Test(expected = WebDriverException.class)
    public void test_Chrome_CANNOTClickCircle()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("600,150");
    }

    @Test
    public void test_FF_CanAccessCircle()
    {
        driver = SupportedDriver.FireFox.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));


        String x = circle.getAttribute("cx");
        String y = circle.getAttribute("cy");

        assert x.equals("460");
        assert y.equals("20");
    }

    @Test
    public void test_FF_CANClickCircle()
    {
        driver = SupportedDriver.FireFox.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("600,150");
    }

    @Test
    public void test_IE_CanAccessCircle()
    {
        driver = SupportedDriver.InternetExplorer.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));


        String x = circle.getAttribute("cx");
        String y = circle.getAttribute("cy");

        assert x.equals("460");
        assert y.equals("20");
    }

    @Test
    public void test_IE_CANNOTClickCircle()
    {
        driver = SupportedDriver.InternetExplorer.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        assert !p.getText().equals("600,150");
        assert p.getText().equals("nothing selected yet");
    }

    @Test
    public void test_Safari_CanAccessCircle()
    {
        driver = SupportedDriver.Safari.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));


        String x = circle.getAttribute("cx");
        String y = circle.getAttribute("cy");

        assert x.equals("460");
        assert y.equals("20");
    }

    @Test(expected = WebDriverException.class)
    public void test_Safari_CANNOTClickCircle()
    {
        driver = SupportedDriver.Safari.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("600,150");
    }

    @Test
    public void test_Phantom_CanAccessCircle()
    {
        driver = SupportedDriver.Phantom.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));


        String x = circle.getAttribute("cx");
        String y = circle.getAttribute("cy");

        assert x.equals("460");
        assert y.equals("20");
    }

    @Test
    public void test_Phantom_CANClickCircle()
    {
        driver = SupportedDriver.Phantom.getDriver();
        driver.get(SCATTERPLOT_URL);

        WebElement circle = driver.findElement(By.cssSelector(BIGGEST_CIRCLE_SELECTOR));

        WebElement p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("nothing selected yet");

        circle.click();
        p = driver.findElement(By.tagName("p"));
        assert p.getText().equals("600,150");
    }

    @After
    public void close()
    {
        if (driver != null)
            driver.quit();
    }
}
