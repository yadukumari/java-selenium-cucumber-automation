package definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.getDriver;

public class DestinationStepDefs {
    @Then("I fill out destination Form")
    public void iFillOutDestinationForm() throws InterruptedException {
        getDriver().findElement(By.id("destination-cac_companyOrName")).sendKeys("Client");
        getDriver().findElement(By.id("destination-cac_singleLineAddress")).sendKeys("870 7th Avenue, New York, NY 10019");
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
//        List<WebElement> suggestion = getDriver().findElements(By.cssSelector(".dropdown-menu"));
//        wait.until(ExpectedConditions.visibilityOfAllElements(suggestion));
        Thread.sleep(2000);
//        WebElement topSuggestion = suggestion.get(0);
//        wait.until(ExpectedConditions.elementToBeClickable(topSuggestion));
//        topSuggestion.click();


    }
}
