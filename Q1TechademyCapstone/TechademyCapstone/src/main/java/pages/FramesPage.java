package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLinkPresent(String linkText) {
        return driver.findElements(By.linkText(linkText)).size() > 0;
    }
}
