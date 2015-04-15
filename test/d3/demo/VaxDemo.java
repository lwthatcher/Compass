package d3.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import other.SupportedDriver;

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
    }

    private void vaccinationPhase() throws Exception
    {
        int vaccinesLeft = getRemainingVaccines();
        while (vaccinesLeft > 0)
        {
            System.out.println("vaccines remaining: " + Integer.toString(vaccinesLeft));

            vaccinesLeft = getRemainingVaccines();
            break;
        }
    }

    private int getRemainingVaccines() throws Exception
    {
        return getRemainingVaccines(0);
    }

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
            Thread.sleep(1000);
            return getRemainingVaccines(++tries);
        }
    }
}
