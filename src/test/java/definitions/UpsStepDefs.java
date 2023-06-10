package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import support.TestContext;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

import java.time.Duration;
import java.util.Map;

public class UpsStepDefs {
    UpsLanding landingPage = new UpsLanding();
    UpsOrigin originPage = new UpsOrigin();

    UpsDestination destinationPage = new UpsDestination();

    UpsPackage packaging = new UpsPackage();

    PickupService service = new PickupService();

    Map<String, String> map = TestContext.getDataFromFile("origin");

    Map<String,String> destinationMap = TestContext.getDataFromFile("destination");

    Map<String, String> packagingMap = TestContext.getDataFromFile("package");

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        landingPage.clickShipMenu();
        landingPage.closePopUP();
//        boolean status = getDriver().findElement(By.xpath("//*[@class='close_btn_thick']")).isDisplayed();
//        if(status){
//            getDriver().findElement(By.xpath("//*[@class='close_btn_thick']")).click();
//        }
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        originPage.selectCountry(map.get("country"));
        originPage.fillName(map.get("name"));
        originPage.fillAddress(map.get("address"));
        originPage.fillEmail(map.get("email"));
        originPage.fillPhone(map.get("phone"));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        originPage.clickContinue();
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String status) {
        switch(status){
            case "Confirm":
                originPage.confirmResidentialAddressStatus();
                break;
            case "Deny":
                originPage.denyResidentialAddressStatus();
                break;
            default:
                System.out.println("Unknown request: " + status );
        }

        originPage.confirmSubmit();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        assertThat(destinationPage.confirmSubmittedOriginFields()).contains(map.get("name"));
        assertThat(destinationPage.confirmSubmittedOriginFields()).contains(map.get("phone"));
        assertThat(destinationPage.confirmSubmittedOriginFields()).contains(map.get("email"));
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {
        destinationPage.fillDestinationCountry(destinationMap.get("country"));
        destinationPage.fillDestinationPersonName(destinationMap.get("name"));
        destinationPage.fillDestinationAddress(destinationMap.get("address"));
        destinationPage.fillDestinationEmail(destinationMap.get("email"));
        destinationPage.fillDestinationPhone(destinationMap.get("phone"));
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        packaging.selectPackagingType("UPS Express Box - Small");
        packaging.fillPackagingWeight(packagingMap.get("packageWeight"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        String price = service.getTotalCharge();
        double totalPrice = Double.parseDouble(price.substring(1));
        assertThat(totalPrice).isGreaterThan(0.0);
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {
        WebElement option = service.listPriceOption();
        System.out.println(option.getText());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        //js.executeScript('option.click()');
        if(option != null) {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(option));
            Thread.sleep(1000);
            option.click();
        }
    }
}
