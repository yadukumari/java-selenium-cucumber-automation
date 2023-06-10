package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.QuoteForm;
import pages.QuoteResult;
import support.TestContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

import static support.TestContext.getDriver;

public class QuoteStepDefs {

    QuoteForm form =new QuoteForm();
    QuoteResult result = new QuoteResult();

    Map<String, String> user = TestContext.getDataFromFile("user");
    //Map<String, String> user = TestContext.getDataFromCommonMoreDataFile("admin");



    @And("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name = 'username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("password123");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("yaduku@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Yadukumari Shanthigrama Ramesh");
        WebElement countryElement = getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']"));
        Select selectList = new Select(countryElement);
        selectList.selectByValue("India");
        getDriver().findElement(By.xpath("//input[@value='female']")).click();
        WebElement carElement = getDriver().findElement(By.name("carMake"));
        selectList = new Select(carElement);
        selectList.selectByValue("Toyota");
        getDriver().findElement(By.name("allowedToContact")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
       // getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String name) {
        List<WebElement> webElements = getDriver().findElements(By.xpath("//label[@id='"+ name +"-error']"));
        int listSize = webElements.size();
        if(listSize > 0 ) {
            for (WebElement element : webElements) {
                assertThat(element.isDisplayed()).isFalse();
            }
        }else{
            assertThat(listSize).isEqualTo(0);
        }

    }


    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String fieldName, String errorMessage) {
        WebElement element = getDriver().findElement(By.xpath("//label[@id='"+ fieldName +"-error']"));
        assertThat(element.getText()).isEqualTo(errorMessage);
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String fieldName, String text) {
        getDriver().findElement(By.xpath("//input[@name='" + fieldName + "']")).clear();
        getDriver().findElement(By.xpath("//input[@name='" + fieldName + "']")).sendKeys(text);

    }

    @And("I select {string} and {string} from multi-select")
    public void iSelectAndFromMultiSelect(String car1, String car2) throws InterruptedException {
       WebElement selectElement = getDriver().findElement(By.name("carMake"));
       WebElement car1Element = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='" + car1 +"']"));
       WebElement car2Element = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='" + car2 +"']"));
//        Select selectCar = new Select(selectElement);
//        selectCar.selectByVisibleText(car1);
//        selectCar.selectByVisibleText(car2);
//        new Actions(getDriver())
//                .keyDown(Keys.CONTROL)
//                .click(car1Element)
//                 .click(car2Element)
//                 .perform();

        new Actions(getDriver())
                .clickAndHold(car1Element)
                .moveToElement(car2Element)
                .release()
                .perform();

        Thread.sleep(5000);
    }

    @Then("I verify fields saved correctly")
    public void iVerifyFieldsSavedCorrectly() throws InterruptedException {
        Thread.sleep(5000);
        //String windHandler = getDriver().getWindowHandle();
        //getDriver().switchTo().window(windHandler);
        String value = getDriver().findElement(By.xpath("//*[@class='applicationResult']")).getText();
        System.out.println(value);
        System.out.println(getDriver().getTitle());
        String name = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        assertThat(name).isEqualTo("Yadukumari Shanthigrama Ramesh");
        String countryName = getDriver().findElement(By.xpath("//b[@name='countryOfOrigin']")).getText();
        assertThat(countryName).isEqualTo("India");
        String userName = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(userName).isEqualTo("jdoe");
        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        assertThat(email).isEqualTo("yaduku@gmail.com");
        String car = getDriver().findElement(By.xpath("//b[@name='carMake']")).getText();
        assertThat(car).isEqualTo("Toyota");
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).isEqualTo("[entered]");
        String policy = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(policy).isEqualTo("true");


    }

    @And("I fill out required fields oop")
    public void iFillOutRequiredFieldsOop() {
        //Map<String, String> user = TestContext.getDataFromFile("user");
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillPasswordField(user.get("password"));
        form.fillPhoneNumber(user.get("PhoneNumber"));
        form.fillCountryOfOrigin(user.get("countryOfOrigin"));
        form.fillNameField(user.get("firstName"), user.get("lastName"));
        form.fillGenderTag(user.get("gender"));
        form.acceptPrivacyPolicy();
    }


    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify fields saved correctly oop")
    public void iVerifyFieldsSavedCorrectlyOop() {
        assertThat(result.getResult()).contains(user.get("username"));
        assertThat(result.getResult()).contains(user.get("email"));
        assertThat(result.getResult()).contains(user.get("firstName"));
        assertThat(result.getResult()).contains(user.get("PhoneNumber"));
        assertThat(result.getResult()).contains(user.get("countryOfOrigin"));
        assertThat(result.getResult()).contains(user.get("gender"));
        assertThat(result.getPassword()).doesNotContain(user.get("password"));

        assertThat(result.getPrivacyPolicy()).isTrue();

    }

    @And("label {string} has required asterisk")
    public void labelHasRequiredAsterisk(String text) {
        WebElement label = form.getLabelByText(text);
        assertThat(label.getAttribute("class")).contains("required");
    }

    @And("label {string} doesn't have required asterisk")
    public void labelDoesnTHaveRequiredAsterisk(String text) {
        WebElement label = form.getLabelByText(text);
        assertThat(label.getAttribute("class")).doesNotContain("required");
    }

    @When("I fill out contact name {string} and phone {string} oop")
    public void iFillOutContactNameAndPhoneOop(String name, String phoneNumber) {
        form.fillContactInformation(name,phoneNumber);

    }
}
