package selenium.external;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by lthatch1 on 1/14/2015.
 */
public class PhantomExample
{
    public static void main(String[] args) {
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
