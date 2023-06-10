package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.TestContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;


public class WeatherStepDefs {
    @When("I click on {string}")
    public void iClickOn(String buttonName) {
        getDriver().findElement(By.xpath("//a[text()='"+ buttonName +"']")).click();

    }

    @And("I set {string} to {string}")
    public void iSetTo(String fromUnit, String toUnit) {
        WebElement selectedFirstList = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        Select select = new Select(selectedFirstList);
        select.selectByVisibleText(fromUnit);

        WebElement selectSecondList = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        select = new Select(selectSecondList);
        select.selectByVisibleText(toUnit);
    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String input, String result) {

        getDriver().findElement(By.xpath("//input[@id='fromVal']")).sendKeys(input);
        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='calResults']"));
        String[] inCelsius = (resultElement.getText()).split(" ");
        String value = "";
        for(int i=1; i<inCelsius.length; i++){
            if(inCelsius[i-1].equals("=")){
                value = inCelsius[i];
            }
        }
        double actualResult = Math.round(Double.parseDouble(value));
       double expectedResult = Math.round(Double.parseDouble(result));
       // double result = Double.parseDouble(value);
        assertThat(actualResult).isEqualTo(expectedResult);

    }
}
