package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
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
    public void iClickOn(){
        homePage = new HomePage(driver);
        homePage.clickABTesting();
    }

    @Then("I verify the text on the page as {string}")
    public void verifyABTestText(String expectedText1) {
        abTestingPage = new ABTestingPage(driver);
        String actualText = abTestingPage.getHeadingText();
        String expectedText2 = "A/B Test Control";
        System.out.println("Actual text is: " + actualText);
        Assert.assertTrue(actualText.equals(expectedText1) || actualText.equals(expectedText2),
                "Actual text does not match expected values. Expected: '" + expectedText1 + "' or '" + expectedText2 + "', but got: '" + actualText + "'");
    }


    @And("I navigate back to home page")
    public void iNavigateBackToHomePage() {
        driver.navigate().back();
    }

    @When("I click on Dropdown")
    public void iClickOnDropdown() {
        homePage = new HomePage(driver);
        homePage.clickDropdown();
    }

    @And("I select {string} from the dropdown")
    public void iSelectOptionFromTheDropdown(String option){
        dropdownPage = new DropdownPage(driver);
        dropdownPage.selectOption1(option);
    }

    @Then("I confirm Option 1 is selected")
    public void iConfirmIsSelected() {
        dropdownPage = new DropdownPage(driver);
        dropdownPage.isOption1Selected();
    }

    @When("I click on Frames")
    public void iClickOnFrames() {
        homePage = new HomePage(driver);
        homePage.clickFrames();
    }

    @Then("I verify {string} hyperlink is present")
    public void iVerifyHyperlinkIsPresent(String linkText) {
        framesPage = new FramesPage(driver);
        boolean isPresent = framesPage.isLinkPresent(linkText);
        Assert.assertTrue(isPresent,linkText+ "is not present on the Frames page.");
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        tearDown();
    }

}
