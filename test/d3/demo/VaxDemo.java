package d3.demo;

import d3.by.ByD3;
import d3.by.BySVG;
import d3.element.ForceLayout;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import other.SupportedDriver;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static d3.demo.DemoConstants.*;

/**
 * Demonstration of using several of the D3 methods by playing the vax game, found at:
 * http://vax.herokuapp.com/game
 *
 * @author Lawrence Thatcher
 */
public class VaxDemo
{
    private WebDriver driver;
    private ForceLayout board;

    @Test
    public void demo() throws Exception
    {
        startGame();
        vaccinationPhase();
    }

    private void startGame()
    {
        driver = SupportedDriver.Chrome.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(VAX_URL);
        WebElement button = driver.findElement(By.cssSelector(EASY_DIFFICULTY));
        button.click();
        WebElement svg = driver.findElement(ByD3.svg());
        board = new ForceLayout(svg);
    }

    private void vaccinationPhase() throws Exception
    {
        int vaccinesLeft = getRemainingVaccines();
        while (vaccinesLeft > 0)
        {
            System.out.println("vaccines remaining: " + Integer.toString(vaccinesLeft));

            D3Element vaccinee = getNextVaccinationTarget();
            vaccinee.click();

            vaccinesLeft = getRemainingVaccines();
        }
    }

    private D3Element getNextVaccinationTarget()
    {
        List<WebElement> nodes = driver.findElements(ByD3.svg().shape("circle").withAttribute("class","node"));
        Collections.sort(nodes,new NodeSizeComparator());

        WebElement largest = nodes.get(0);
        return new D3Element(largest);
    }

    private int getRemainingVaccines() throws Exception
    {
        return getRemainingVaccines(0);
    }

    /**
     * Retrieves the number stored in the specified element.
     * This function uses recursion to keep on trying to retrieve the element in case the text has not yet been updated.
     * @param tries the current number of times it has been queried. If it exceeds the threshold, it throws an exception.
     */
    private int getRemainingVaccines(int tries) throws Exception
    {
        try
        {
            WebElement vaccines = driver.findElement(By.cssSelector(REMAINING_VACCINES));
            String count = vaccines.getText();
            return Integer.parseInt(count);
        }
        catch (NumberFormatException e)
        {
            if (tries > IMPLICIT_RETRIES)
                throw new Exception("unable to find number of remaining vaccines:",e);
            //wait for a bit, and try again
            Thread.sleep(1000);
            return getRemainingVaccines(++tries);
        }
    }
}
