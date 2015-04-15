package d3.demo;

import java.util.Map;
import java.util.TreeMap;

/**
 * Stores constants useful for the Vax Demo
 *
 * @author Lawrence Thatcher
 */
public abstract class DemoConstants
{
    public static final String VAX_URL = "http://vax.herokuapp.com/game";

    public static final int IMPLICIT_RETRIES = 5;

    public static final String EASY_DIFFICULTY = "#difficultyEasy";
    public static final String REMAINING_VACCINES = "text[class='vaccineCounterText']";
    public static final String SUBMIT_TEXT = "svg > text[class='endGameSUBMIT']";

    public static final Map<String,String> NODE_ATTRIBUTES = getNodeAttributes();
    public static final Map<String,String> INFECTED_ATTRIBUTES = getInfectedAttributes();

    public static final String INFECTED = "fill: rgb(239, 85, 85); cursor: pointer;";
    private static final String NODE = "node";

    private static Map<String,String> getNodeAttributes()
    {
        Map<String,String> result = new TreeMap<>();
        result.put("class",NODE);
        return result;
    }

    private static Map<String,String> getInfectedAttributes()
    {
        Map<String,String> result = new TreeMap<>();
        result.put("class",NODE);
        result.put("style",INFECTED);
        return result;
    }
}
