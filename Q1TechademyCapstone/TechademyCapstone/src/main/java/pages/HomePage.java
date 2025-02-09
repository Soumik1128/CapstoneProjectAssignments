package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickABTesting() {
        driver.findElement(By.linkText("A/B Testing")).click();
    }

    public void clickDropdown() {
        driver.findElement(By.linkText("Dropdown")).click();
    }

    public void clickFrames() {
        driver.findElement(By.linkText("Frames")).click();
    }
}
