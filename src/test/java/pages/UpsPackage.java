package pages;

import io.cucumber.java8.Pa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UpsPackage extends Page {

    @FindBy(id = "nbsPackagePackagingTypeDropdown0")
    private WebElement packagingType;

    @FindBy(id="nbsPackagePackageWeightField0")
    private WebElement packagingWeight;


    //methods

    public void selectPackagingType(String type){
        new Select(packagingType).selectByVisibleText(type);
    }

    public void fillPackagingWeight(String weight){
        packagingWeight.sendKeys(weight);
    }
}
