package d3.demo;

import org.openqa.selenium.By;

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

}
