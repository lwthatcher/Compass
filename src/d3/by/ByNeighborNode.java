package d3.by;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lthatch1 on 4/1/2015.
 *
 * @author Lawrence Thatcher
 */
public class ByNeighborNode extends By
{
    private final JavascriptExecutor jse;
    private WebElement element;

    public ByNeighborNode(JavascriptExecutor jse, WebElement element)
    {
        this.jse = jse;
        this.element = element;
    }

    private String getJavaScript()
    {
        String result =
                "var node = arguments[0];\n" +
                "console.log(d3.selectAll(\"line, path\").data());\n" +
                //"console.log(d3.select(node).data()[0].index);\n" +
                "var index = d3.select(node).data()[0].index;\n" +
                "var neighbors = [];\n" +
                "d3.selectAll(\"line, path\").data().forEach( function(d) {\n" +
                "   if (d.hasOwnProperty('source') && d.hasOwnProperty('target')) {\n" +
                "      if (d.source.index === index) {\n" +
                "          neighbors[neighbors.length] = d.target.index;\n" +
                "      }\n" +
                "      else if (d.target.index === index) {\n" +
                "          neighbors[neighbors.length] = d.source.index;\n" +
                "      }\n" +
                "   }\n" +
                "   else {\n" +
                "      if (d[0].index === index) {\n" +
                "          neighbors[neighbors.length] = d[d.length-1].index;\n" +
                "      }\n" +
                "      else if (d[d.length-1].index === index) {\n" +
                "          neighbors[neighbors.length] = d[0].index;\n" +
                "      }\n" +
                "   }\n" +
                "});\n" +
                "console.log(neighbors);\n" +
                "var bros = [];\n" +
                //"console.log(d3.selectAll(\"circle\").length);\n" +
                "d3.selectAll(\"circle\").forEach( function(data) {\n" +
                "   data.forEach( function(d,i) {\n" +
                "       for (j = 0; j < neighbors.length; j++) {\n" +
                "           if (i === neighbors[j]) {\n" +
                "               bros[bros.length] = d;\n" +
                "           }\n" +
                "       }\n" +
                "   });\n" +
                "});" +
                "console.log(bros);\n" +
                "return bros;";

        return result;
    }

    @Override
    public WebElement findElement(SearchContext context)
    {
        ArrayList<WebElement> list = (ArrayList<WebElement>) jse.executeScript(getJavaScript(), element);
        return list.get(0);
    }

    @Override
    public List<WebElement> findElements(SearchContext context)
    {
        ArrayList<WebElement> result = (ArrayList<WebElement>) jse.executeScript(getJavaScript(), element);
        return result;
    }
}
