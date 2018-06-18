package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {
    private static WebDriver driver;


    public static WebDriver getDriver() {

        return driver;
    }

    private static void setDriver(WebDriver driver) {
        Config.driver = driver;
    }

    public Config(String browser) {
        //This function will open chrome even if you send it ie or firefox
        if ((browser.equals("ie")) || (browser.equals("chrome")) || (browser.equals("firefox"))) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                setDriver(driver);
            } else {
                System.out.println(
                        "Added just Chrome in the config at this point. Your browser:"
                                + browser + "is not supported right now");
            }
        }
    }
    public static void loadURL(String URL) {

        driver.get(URL);
    }

    public static void closeDriver() {

        driver.quit();
    }

}

