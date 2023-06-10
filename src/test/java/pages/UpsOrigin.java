package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static support.TestContext.getDriver;

public class UpsOrigin extends UpsShippingControl{

    public UpsOrigin(){
        url = "https://www.ups.com/ship/guided/origin";
    }

    @FindBy(id="origin-cac_country")
    private WebElement country;

    @FindBy(id="origin-cac_companyOrName")
    private WebElement name;

    @FindBy(id="origin-cac_singleLineAddress")
    private WebElement address;

    @FindBy(css=".dropdown-item")
    private List<WebElement> addressSuggestions;

    @FindBy(id="origin-cac_email")
    private WebElement email;

    @FindBy(id="origin-cac_phone")
    private WebElement phone;

    @FindBy(id="nbsBackForwardNavigationContinueButton")
    private WebElement submit;

    public void selectCountry(String countryName){
        //Select select = new Select(country); --> no need
        new Select(country).selectByVisibleText(countryName);
    }

    public void fillName(String name){
        this.name.sendKeys(name);
    }

    public void fillAddress(String fullAddress){
        address.sendKeys(fullAddress);
        WebElement topSuggestion = addressSuggestions.get(0);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(topSuggestion));
        topSuggestion.click();
    }

    public void fillEmail(String emailAddress){
        email.sendKeys(emailAddress);
    }

    public void fillPhone(String phoneNumber){
        phone.sendKeys(phoneNumber);
    }

    public void clickContinue(){
        submit.click();
    }



}

