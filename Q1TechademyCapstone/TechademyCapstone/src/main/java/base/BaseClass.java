package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    protected static WebDriver driver;

    public static void setup() {

        System.setProperty("web-driver.chrome.driver","C:/Users/sjith/IdeaProjects/TechademyCapstone/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void tearDown() {

        driver.quit();
    }
}
