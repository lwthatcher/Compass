package other;

/**
 * Support class that contains a reference to the driver executable for the 3rd part web drivers.
 */
public class DriversDirectory
{
    private static final String IE = "IEDriverServer.exe";
    private static final String CHROME = "chromedriver.exe";
    private static final String PHANTOM = "phantomjs.exe";
    private static String drivers = Directory.getDriversFolder();

    public static String IE_DRIVER = drivers + IE;
    public static String CHROME_DRIVER = drivers + CHROME;
    public static String PHANTOM_DRIVER = drivers + PHANTOM;
}
