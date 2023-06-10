package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PickupService extends Page{

    @FindBy(id="total-charges-spinner")
    private WebElement totalCharge;

    @FindBy(css=".serviceCard_footer-price ")
    private List<WebElement> listOfPrices;

    public String getTotalCharge(){
        return totalCharge.getText();
    }

    public WebElement listPriceOption(){
        double optionPrice;
        System.out.println(listOfPrices.size());
        if(listOfPrices.size() >= 1) {
            double cheapestOption = Double.parseDouble((listOfPrices.get(0).getText()).substring(1));
            WebElement cheapestOptionElement = listOfPrices.get(0);
            for (WebElement price : listOfPrices) {
                System.out.println(price);
                optionPrice = Double.parseDouble((price.getText()).substring(1));
                System.out.println(optionPrice);
                if (optionPrice < cheapestOption) {
                    cheapestOptionElement = price;
                }
            }

            return cheapestOptionElement;
        }

        return null;
    }
}
