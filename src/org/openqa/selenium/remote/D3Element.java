package org.openqa.selenium.remote;

import d3.by.ByNeighborNode;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Wrapper class for RemoteWebElement specifically for representing elements within an SVG element.
 * This class overrides the click() functionality so it can call the javascript methods directly to get around problems with this in certain browsers.
 *
 * @author Lawrence Thatcher
 */
public class D3Element extends RemoteWebElement implements WebElement
{
    private RemoteWebElement element;

    public D3Element(WebElement e)
    {
        this.element = (RemoteWebElement)e;
        this.id = element.getId();
        this.parent = element.parent;
        this.mouse = element.mouse;
        this.fileDetector = element.fileDetector;
    }

    public RemoteWebDriver getDriver()
    {
        return (RemoteWebDriver) getWrappedDriver();
    }

    public List<D3Element> getNeighborNodes()
    {
        ByNeighborNode by = new ByNeighborNode(getDriver(),element);
        List<WebElement> neighbors = (List<WebElement>)by.findElements(null);
        List<D3Element> result = new ArrayList<D3Element>();
        for (WebElement neighbor : neighbors)
        {
            result.add(new D3Element(neighbor));
        }
        return result;
    }

    //Overridden Methods
    @Override
    public void click()
    {
        String script = "var element = arguments[0];" +
                        "var event = element[\"__onclick\"];" +
                        "if (typeof(event) == \"function\") {" +
                        "   event.call(element);" +
                        "}" +
                        "return event;";
        Object o = getDriver().executeScript(script,element);
        if (o == null)
            element.click();    //If it does not have a click functionality try the default click method
    }

    @Override
    public List<WebElement> findElements(By by)
    {
        List<WebElement> elements = element.findElements(by);
        List<WebElement> result = new ArrayList<WebElement>();
        for (WebElement e : elements)
        {
            result.add(new D3Element(e));
        }
        return result;
    }

    @Override
    public D3Element findElement(By by)
    {
        WebElement e = element.findElement(by);
        return new D3Element(e);
    }

    //Delegate Methods
    @Override
    protected void setFoundBy(SearchContext foundFrom, String locator, String term)
    {
        element.setFoundBy(foundFrom, locator, term);
    }

    @Override
    public void setParent(RemoteWebDriver parent)
    {
        element.setParent(parent);
    }

    @Override
    public String getId()
    {
        return element.getId();
    }

    @Override
    public void setId(String id)
    {
        element.setId(id);
    }

    @Override
    public void setFileDetector(FileDetector detector)
    {
        element.setFileDetector(detector);
    }

    @Override
    public void submit()
    {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend)
    {
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear()
    {
        element.clear();
    }

    @Override
    public String getTagName()
    {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name)
    {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected()
    {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled()
    {
        return element.isEnabled();
    }

    @Override
    public String getText()
    {
        return element.getText();
    }

    @Override
    public String getCssValue(String propertyName)
    {
        return element.getCssValue(propertyName);
    }

    @Override
    public WebElement findElementById(String using)
    {
        return element.findElementById(using);
    }

    @Override
    public List<WebElement> findElementsById(String using)
    {
        return element.findElementsById(using);
    }

    @Override
    public WebElement findElementByLinkText(String using)
    {
        return element.findElementByLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByLinkText(String using)
    {
        return element.findElementsByLinkText(using);
    }

    @Override
    public WebElement findElementByName(String using)
    {
        return element.findElementByName(using);
    }

    @Override
    public List<WebElement> findElementsByName(String using)
    {
        return element.findElementsByName(using);
    }

    @Override
    public WebElement findElementByClassName(String using)
    {
        return element.findElementByClassName(using);
    }

    @Override
    public List<WebElement> findElementsByClassName(String using)
    {
        return element.findElementsByClassName(using);
    }

    @Override
    public WebElement findElementByCssSelector(String using)
    {
        return element.findElementByCssSelector(using);
    }

    @Override
    public List<WebElement> findElementsByCssSelector(String using)
    {
        return element.findElementsByCssSelector(using);
    }

    @Override
    public WebElement findElementByXPath(String using)
    {
        return element.findElementByXPath(using);
    }

    @Override
    public List<WebElement> findElementsByXPath(String using)
    {
        return element.findElementsByXPath(using);
    }

    @Override
    public WebElement findElementByPartialLinkText(String using)
    {
        return element.findElementByPartialLinkText(using);
    }

    @Override
    public List<WebElement> findElementsByPartialLinkText(String using)
    {
        return element.findElementsByPartialLinkText(using);
    }

    @Override
    public WebElement findElementByTagName(String using)
    {
        return element.findElementByTagName(using);
    }

    @Override
    public List<WebElement> findElementsByTagName(String using)
    {
        return element.findElementsByTagName(using);
    }

    @Override
    protected Response execute(String command, Map<String, ?> parameters)
    {
        return element.execute(command, parameters);
    }

    @Override
    public boolean equals(Object obj)
    {
            return (obj instanceof RemoteWebElement) && element.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return element.hashCode();
    }

    @Override
    public WebDriver getWrappedDriver()
    {
        return element.getWrappedDriver();
    }

    @Override
    public boolean isDisplayed()
    {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation()
    {
        return element.getLocation();
    }

    @Override
    public Dimension getSize()
    {
        return element.getSize();
    }

    @Override
    public Coordinates getCoordinates()
    {
        return element.getCoordinates();
    }

    @Override
    public String toString()
    {
        return element.toString();
    }
}
