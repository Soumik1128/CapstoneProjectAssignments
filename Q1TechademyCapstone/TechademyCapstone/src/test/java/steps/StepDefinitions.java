package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.*;

public class StepDefinitions extends BaseClass {
    HomePage homePage;
    ABTestingPage abTestingPage;
    DropdownPage dropdownPage;
    FramesPage framesPage;


    @Given("I launch the URL {string}")
    public void i_launch_the_url(String url) {
        setup();
        driver.get(url);
        homePage = new HomePage(driver);
    }

    @Then("I verify the title of the page as {string}")
    public void verify_title(String title){
        String actualTile=driver.getTitle();
        Assert.assertEquals(title,actualTile);
    }
    @Then("I click on AB Testing link")
    public void iClickOn()
    {
        homePage.clickABTesting();
    }

    @Then("I verify the text on the page as {string}")
    public void verifyABTestText(String expectedText) {
        String actualText = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @And("I navigate back to home page")
    public void iNavigateBackToHomePage() {
        driver.navigate().back();
    }

    @When("I click on Dropdown")
    public void iClickOnDropdown() {
        homePage.clickDropdown();
    }

    @And("I select {string} from the dropdown")
    public void iSelectOptionFromTheDropdown(String option) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        select.selectByVisibleText(option);
    }

    @Then("I confirm {string} is selected")
    public void iConfirmIsSelected(String expectedSelection) {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        String actualSelection=select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,expectedSelection);
    }

    @When("I click on Frames")
    public void iClickOnFrames() {
        homePage.clickFrames();
    }

    @Then("I verify {string} hyperlink is present")
    public void iVerifyHyperlinkIsPresent(String linkText) {
        boolean isPresent= driver.findElement(By.linkText(linkText)).isDisplayed();
        Assert.assertTrue(isPresent,linkText+ "is not present on the Frames page.");
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        tearDown();
    }
}
