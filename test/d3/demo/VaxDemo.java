package d3.demo;

import d3.by.ByD3;
import d3.by.BySVG;
import d3.by.shape.AttributeSelectionType;
import d3.element.ForceLayout;
import d3.element.ForceNode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.D3Element;
import org.openqa.selenium.support.ui.ExpectedConditions;
import other.SupportedDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
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
        quarantinePhase();
        System.out.println("Game Complete");
    }

    private void startGame()
    {
        driver = SupportedDriver.Chrome.getDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(VAX_URL);
        WebElement button = driver.findElement(By.cssSelector(EASY_DIFFICULTY));
        button.click();
        WebElement svg = driver.findElement(ByD3.svg());
        board = new ForceLayout(svg);
    }

    private void vaccinationPhase() throws Exception
    {
        System.out.println("-==Entering Vaccination Phase==-");
        int vaccinesLeft = getRemainingVaccines();
        while (vaccinesLeft > 0)
        {
            System.out.println("vaccines remaining: " + Integer.toString(vaccinesLeft));

            D3Element vaccinee = getNextVaccinationTarget();
            vaccinee.click();

            vaccinesLeft = getRemainingVaccines();
        }
    }

    private void quarantinePhase() throws Exception
    {
        System.out.println("-==Entering Quarantine Phase==-");
        Thread.sleep(2000);
        while (!gameOver())
        {
            //Wait for infection to spread
            Thread.sleep(3000);

            //find infected nodes
            List<D3Element> infected = getInfectedNodes();
            System.out.println("Number Infected: " + Integer.toString(infected.size()));

            //Get list of potential targets
            List<D3Element> neighbors = getNeighborsOfInfected(infected);
            if (neighbors.size() == 0)
                System.out.println("Cannot find anyone to quarantine");
            else
            {
               D3Element quarantinee = getNextQuarantineTarget(neighbors);
                System.out.println("clicking on: " + quarantinee.getId());
               Thread.sleep(500);
               quarantinee.click();
               unhighlight(neighbors);
            }
        }
        System.out.println("End Quarantine Phase");
    }

    private void unhighlight(List<D3Element> neighbors)
    {
        for (D3Element neighbor : neighbors)
        {
            ((ForceNode)neighbor).highlightOff();
        }
    }

    private D3Element getNextQuarantineTarget(List<D3Element> neighbors)
    {
        Collections.sort(neighbors,new NodeSizeComparator());
        for (int i = 0; i < neighbors.size(); i++)
        {
            if (!isInfected(neighbors.get(i)))
                return neighbors.get(i);
        }
        throw new NoSuchElementException("There are no 'neighbors' that aren't infected!");
    }

    private List<D3Element> getInfectedNodes()
    {
        List<WebElement> infected = driver.findElements(board.byShape("circle").withAttributes(INFECTED_ATTRIBUTES).setType(AttributeSelectionType.SUBSTRING));
        List<D3Element> result = new ArrayList<>();
        for (WebElement node : infected)
        {
            result.add(new ForceNode(node));
        }
        return result;
    }

    private List<D3Element> getNeighborsOfInfected(List<D3Element> infected)
    {
        List<D3Element> result = ForceLayout.getAllNeighbors(infected);
        for (D3Element neighbor : result)
        {
            ((ForceNode)neighbor).highlightOn();
        }
        return result;
    }

    private boolean isInfected(D3Element node)
    {
        String style = node.getAttribute("style");
        if (style.equals(INFECTED))
            return true;
        return false;
    }

    private D3Element getNextVaccinationTarget()
    {
        List<WebElement> nodes = board.findElements(board.byShape("circle").withAttributes(NODE_ATTRIBUTES));
        Collections.sort(nodes,new NodeSizeComparator());

        WebElement largest = nodes.get(0);
        return new ForceNode(largest);
    }

    private boolean gameOver()
    {
        try
        {
            WebElement submit = driver.findElement(By.cssSelector(SUBMIT_TEXT));
            return submit != null;
        }
        catch (Exception ignore)
        {}
        return false;
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
