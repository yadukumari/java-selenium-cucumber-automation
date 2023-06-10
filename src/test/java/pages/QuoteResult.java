package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;

public class QuoteResult  extends Page{

    String url;
    String title;

    public QuoteResult(){
        url = ""; // no need to initialize you can keep empty String because we get this url after submitting the form
        title = "Get a Quote";
    }

    @Override
    public void open(){
      throw new Error("Can't navigate to this page via url. Accessible after submission of a Form");
    }

    //fields

    @FindBy (xpath = "//div[@id='quotePageResult']//section")
    private WebElement resultSection;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;


    //methods

    public String getResult(){
        return resultSection.getText();
    }

    public String getPassword(){
        return password.getText();
    }
    public boolean getPrivacyPolicy(){
        return Boolean.parseBoolean(privacyPolicy.getText());
    }

}
