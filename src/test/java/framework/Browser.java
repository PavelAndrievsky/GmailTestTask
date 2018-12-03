package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;

public class Browser extends BaseEntity{

    private static WebDriver driver;
    private static Browser instance;
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static final String chromeDriverPath = "./src/test/resources/chromedriver";
    private static final String geckoDriverPath = "./src/test/resources/geckodriver";

    private Browser(){}

    private static String getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        return value;
    }

    static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    private static String getCanonical(String pathDriver){
        String pathActualDriver = null;
        try {
            pathActualDriver = String.valueOf(new File(pathDriver).getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathActualDriver;
    }

    public static WebDriver getDriver() {
        String pathChrome = getCanonical(chromeDriverPath);
        String pathGecko = getCanonical(geckoDriverPath);
        switch (OS){
            case "windows 10":
                pathChrome = String.format("%s.exe", pathChrome);
                pathGecko = String.format("%s.exe", pathGecko);
                break;
            case "linux":
                break;
        }
        switch (configFile.getConfigProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", pathChrome);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", pathGecko);
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

}
