package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption1() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
    }

    public boolean isOption1Selected() {
        return driver.findElement(By.cssSelector("option[value='1']")).isSelected();
    }
}
