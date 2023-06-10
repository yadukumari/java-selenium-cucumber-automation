package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsShippingControl extends Page{
    @FindBy(css = ".ups-lever_switch_yes")
    private WebElement residentialAddressYes;

    @FindBy(css=".ups-lever_switch_no")
    private WebElement residentialAddressNo;

    @FindBy(id="nbsAddressClassificationContinue")
    private WebElement clickConfirm;


    public void confirmResidentialAddressStatus(){
        if(residentialAddressNo.isDisplayed()){
            residentialAddressNo.click();
        }
    }

    public void denyResidentialAddressStatus(){
        if(residentialAddressYes.isDisplayed()){
            residentialAddressYes.click();
        }
    }

    public void confirmSubmit(){
        clickConfirm.click();
    }
}
