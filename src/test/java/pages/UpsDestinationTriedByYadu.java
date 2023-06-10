package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.getDriver;



public class UpsDestinationTriedByYadu {

        //fields

        //OriginFields Verification
        @FindBy(id = "origin_showSummaryAddress")
        private WebElement submittedOriginFields;

        //Required Field to fill for destination

        @FindBy(id="destination-cac_country")
        private WebElement destinationCountry;

        @FindBy(css =".dropdown-item")
        private List<WebElement> addressSuggestions;

        @FindBy(id="destination-cac_companyOrName")
        private WebElement destinationName;

        @FindBy(id="destination-cac_singleLineAddress")
        private WebElement destinationAddress;

        @FindBy(id="destination-cac_email")
        private WebElement destinationEmail;

        @FindBy(id="destination-cac_phone")
        private WebElement destinationPhoneNumber;




        //mathods

        public String confirmSubmittedOriginFields(){
            return submittedOriginFields.getText();
        }

        public void fillDestinationCountry(String country){
            new Select(destinationCountry).selectByVisibleText(country);
        }

        public void fillDestinationPersonName(String name){
            destinationName.sendKeys(name);
        }


        public void fillDestinationAddress(String fullAddress) throws InterruptedException {
            destinationAddress.click();
            destinationAddress.sendKeys(fullAddress);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
            destinationAddress.click();
            Thread.sleep(500);
//        System.out.println(addressSuggestions.size());
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(addressSuggestions));
            WebElement topSuggestion = addressSuggestions.get(0);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(topSuggestion));
            topSuggestion.click();
        }

        public void fillDestinationEmail(String email){
            destinationEmail.sendKeys(email);
        }

        public void fillDestinationPhone(String phone){
            destinationPhoneNumber.sendKeys(phone);
        }



}
