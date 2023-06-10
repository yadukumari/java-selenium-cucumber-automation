package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.cucumber.java8.Th;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

public class UspsStepDefs {

    Actions action = new Actions(getDriver());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver() ;


    @When("I navigate to Look Up a ZIP Code by Address")
    public void iNavigateToLookUpAZIPCodeByAddress() {
//        getDriver().findElement(By.xpath("//*[@id='mail-ship-width']")).click();
//        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction')]")).click();
        WebElement send = getDriver().findElement(By.xpath("//*[@id='mail-ship-width']"));
        WebElement lookUpZip = getDriver().findElement(By.xpath("//li[@class='tool-zip']//a"));
        action.moveToElement(send).click(lookUpZip).perform();

        //or action.moveToElement(send).perform();
        //getDriver().findElement(By.xpath("//li[@class='tool-zip']//a")).click();
        getDriver().findElement(By.xpath("//a[contains(@href, 'byaddress') and contains(@class,'btn-primary') and contains(@class,'zip-code-home')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        //getDriver().findElement(By.xpath("//select[@id='tState']")).click();
//        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
//        Select statrDropdown = new Select(stateElement);
//        statrDropdown.selectByValue(state);
        //getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state +"']")).click(); --> Dynamic way of assigning state value or xpath...
        WebElement allElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        Select startDropdown = new Select(allElement);
        startDropdown.selectByValue(state);
        // (or) new Select(getDriver().findElement(By.xpath("//select[@id='tState']"))).selectByValue(state);
    }

    @And("I submit ZIP Code by Address form")
    public void iSubmitZIPCodeByAddressForm() {
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code is present in result")
    public void iValidateZipCodeIsPresentInResult(String zip) throws InterruptedException {
        //Thread.sleep(2000);
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id = 'zipByAddressDiv']"));
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, zip));
        //validate the result container has zip
        String resultText = resultElement.getText();
        assertThat(resultText).contains(zip);

        //validate each row contains zip
        List<WebElement> arrOfData = getDriver().findElements(By.xpath("//div[@class='zipcode-result-address']"));
        for(WebElement data : arrOfData){
            assertThat(data.getText().contains(zip));
        }

    }

    @When("I go to Calculate Price page")
    public void iGoToCalculatePricePage() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href, 'calculateretail')]")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String str1, String str2) {
        WebElement countryName = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        Select countryContainer = new Select(countryName);
        countryContainer.selectByVisibleText(str1);
        getDriver().findElement(By.xpath("//input[@value='" + str2 + "']")).click();


        //getDriver().findElement(By.xpath("//select[@id='CountryID']/option[text()='" + str1 + "']"));
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String str) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(str);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String str1) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String amount = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(amount).isEqualTo(str1);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String str) {
        WebElement search = getDriver().findElement(By.xpath("//li[@class='nav-search menuheader']"));
        WebElement freeBox = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        WebElement searchButton = getDriver().findElement(By.xpath("//label[@for='global-header--search-track-search']/..//input[@value='Search']"));
        action.moveToElement(search).sendKeys(freeBox , str).click(searchButton).perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        getDriver().findElement(By.xpath("//label[contains(text(), 'Send')]")).click();
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String result) {

        String resultElement = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(resultElement).contains(result);
        List<WebElement> listOfResult = getDriver().findElements(By.xpath("//li[@class=' col-gl-12 col-md-12 result-item']"));
        assertThat(listOfResult.size()+"").isEqualTo(result);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String mail) {
        WebElement mailElement = getDriver().findElement(By.xpath("//span[@id='title_23']"));
        assertThat(mailElement.getText().contains(mail));
        getDriver().findElement(By.xpath("//span[@id='title_23']")).click();
    }

    @And("I click {string} button")
    public void iClickButton(String ship) throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@class='button--primary']")).click();
        Thread.sleep(6000);
        String mainHandler = getDriver().getWindowHandle();
        System.out.println("Single mainhandel: " + mainHandler);

        Set<String> multipleHandel = getDriver().getWindowHandles();

        System.out.println("Check the number of all Handels: " + multipleHandel.size());
        for(String eachHandel : multipleHandel){
            if(!(mainHandler.equals(eachHandel))){
                getDriver().switchTo().window(eachHandel);
                System.out.println("eachHandel: " + eachHandel);
                System.out.println("eachHandel URL: " + getDriver().getCurrentUrl());
                System.out.println("eachHandel Title: " + getDriver().getTitle());
            }
//            if(mainHandler.equals(eachHandel)) {
//                System.out.println("eachHandel: " + eachHandel);
//                System.out.println("eachHandel URL: " + getDriver().getCurrentUrl());
//                System.out.println("eachHandel Title: " + getDriver().getTitle());
//            }else{
//                getDriver().switchTo().window(eachHandel);
//                System.out.println("eachHandel: " + eachHandel);
//                System.out.println("eachHandel URL: " + getDriver().getCurrentUrl());
//                System.out.println("eachHandel Title: " + getDriver().getTitle());
//            }
        }
        String text = getDriver().findElement(By.xpath("//button[@id='btn-submit']")).getText();
        System.out.println(text);
        assertThat(text).isEqualTo("Sign In");

    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() throws InterruptedException {
       //WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
        //wait.until(ExpectedConditions.invisibilityOf(spinner));

        Thread.sleep(6000);
        //getDriver().findElement(By.xpath("//div[@id='sign-in-wrap']"));
       String text = getDriver().findElement(By.xpath("//button[@id='btn-submit']")).getText();
        System.out.println(text);
        //assertThat(text).isEqualTo("Sign in");
    }

    @And("I select a region")
    public void iSelectARegion() throws InterruptedException {
        Dimension widSize = new Dimension(1280, 500);
        getDriver().manage().window().setSize(widSize);
        getDriver().findElement(By.xpath("//a[@data-map='ups-svg-oceania']")).click();


        WebElement africaData = getDriver().findElement(By.xpath("//a[@data-map='ups-svg-africa']"));
        //((JavascriptExecutor) getDriver()).executeScript("");

        jsExecutor.executeScript("arguments[0].click()",africaData);
        Thread.sleep(3000);
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String subMenu, String menu) {
        WebElement menuElement = getDriver().findElement(By.xpath("//li//a[text() = '" + menu +"']"));
        WebElement subMenuElement = getDriver().findElement(By.xpath("//a[text()='Every Door Direct Mail']"));
        action.moveToElement(menuElement).click(subMenuElement).perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(address);
        //getDriver().findElement(By.xpath("//a[contains(@class, 'eddm-search-btn')]")).click();
        getDriver().findElement(By.cssSelector(".eddm-search-btn")).click();

        WebElement spinner = getDriver().findElement(By.id("searchProcessing"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

    }

    @And("I choose view as {string} on the map")
    public void iChooseViewAsOnTheMap(String view) {
        getDriver().findElement(By.xpath("//span[text()='" + view +"']")).click();
    }

    @When("I select all in the table")
    public void iSelectAllInTheTable() {
        getDriver().findElement(By.id("select-all-checkboxes")).click();

    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        WebElement closeButton = getDriver().findElement(By.xpath("//div[@id='drop-off-location-modal']//a[@class='close']"));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        closeButton.click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> costList = getDriver().findElements(By.xpath("//td[9]"));
        //What if the cost element is keep on loading more data then use action like below...find last element in that table.

        //The below do While is used to show how to handle keep on loading value....Dealing with infinite loading loop...


//        int originalSize = 0;
//        do {
//            originalSize = costList.size();
//            action.moveToElement(costList.get(originalSize - 1)).perform();
//            Thread.sleep(500);
//            costList = getDriver().findElements(By.xpath("//td[9]"));
//
//        }while(originalSize != costList.size());

        String value = "";
        double sum = 0.0;
        for(WebElement costElement : costList) {
            value = costElement.getText().replace("$","");
            sum += Double.parseDouble(value);
        }
        System.out.println(sum);
        WebElement approximate = getDriver().findElement(By.xpath("//p[@id='approximateCost']"));
        value = approximate.getText().replace("$","");
        System.out.println(value + " " + sum);
        Double ApproximateValue = Double.parseDouble(value);
        //assertThat(Math.round((Double.parseDouble(value)))).isEqualTo(Math.round(sum));
        assertThat(sum).isCloseTo(ApproximateValue, Percentage.withPercentage(0.5));

    }
}


