package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UpsLanding extends Page{

    public UpsLanding(){
        url = "https://www.ups.com/us/en/Home.page";
        title = "Global Shipping & Logistics Services | UPS - United States";
    }

    @FindBy(id="tabs_0_tab_2")
    private WebElement ship;

    @FindBy(xpath = "//*[@class='close_btn_thick']")
    private WebElement close;

    public void clickShipMenu(){
        ship.click();
    }

    public void closePopUP(){
        close.click();
    }

}
