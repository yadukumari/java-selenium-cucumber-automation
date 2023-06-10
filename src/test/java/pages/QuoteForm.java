package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;


public class QuoteForm extends Page {

    public QuoteForm(){
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    //fields

    @FindBy(name = "username")   //this is equivalent to getDriver().findElement(By.name("username"))
    private WebElement username;


    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name = "phone")
    private WebElement phoneNumber;

    //name Dialog
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "middleName")
    private WebElement middleName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy (name="countryOfOrigin")
    private WebElement countryOfOrigin;

    @FindBy (xpath="//*[@value='male']")
    private WebElement maleGender;

    @FindBy (xpath = "//*[@value='female']" )
    private WebElement femaleGender;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacyPolicy;

    @FindBy(id = "formSubmit")
    private WebElement submitButton;

    //iframe
    @FindBy(name = "additionalInfo")
    private WebElement additionalInfoFrame;
    @FindBy(id="contactPersonName")
    private WebElement contactPersonName;
    @FindBy(id="contactPersonPhone")
    private WebElement contactPersonPhone;

    //methods

    //Dynamic Xpath case
    public WebElement getLabelByText(String text){
        return getDriver().findElement(By.xpath("//label[text()='" + text + "']"));
    }

    public void fillContactInformation(String name, String phone){ //can be done one by one
        getDriver().switchTo().frame(additionalInfoFrame); //switching to iframe
        contactPersonName.sendKeys(name);
        contactPersonPhone.sendKeys(phone);
        getDriver().switchTo().defaultContent(); // switching back to normal frame or previous one
    }

    public void fillUsername(String name){
        username.sendKeys(name);
    }

    public void fillEmail(String mail){
        email.sendKeys(mail);
    }

    public void fillPasswordField(String password){
        this.password.sendKeys(password);
        confirmPassword.sendKeys(password);
    }

    public void fillGenderTag(String genderType){
        if(genderType.equals("male")){
            maleGender.click();
        }else{
            femaleGender.click();
        }
    }
    public void fillPhoneNumber(String number){
        phoneNumber.sendKeys(number);
    }

    public void fillCountryOfOrigin(String countryName){
        Select selectName = new Select(countryOfOrigin);
        selectName.selectByValue(countryName);

    }
    public void fillName(String name){
        this.name.sendKeys(name);
    }

    public void fillNameField(String firstNameValue, String lastNameValue){
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }

    public void fillNameField(String firstNameValue,String middleNameValue, String lastNameValue){
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
    }


    public void acceptPrivacyPolicy(){
        if(!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void declinePrivacyPolicy(){
        if(privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    public void submit(){
        submitButton.click();
    }

}
