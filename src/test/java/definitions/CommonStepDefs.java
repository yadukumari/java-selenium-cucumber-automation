package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.bouncycastle.jcajce.provider.symmetric.SCRYPT;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import pages.QuoteForm;
import pages.UpsLanding;
import support.TestContext;
import org.openqa.selenium.Dimension;

import java.awt.*;

import static support.TestContext.getDriver;

public class CommonStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page){
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "usps":
                getDriver().get("https://www.usps.com");
                break;
            case "converter":
                getDriver().get(" https://www.unitconverters.net/");
                break;
            case "ups":
                getDriver().get("https://www.ups.com/us/en/global.page");
                break;
            case "google":
            case "yahoo":
            case "bing":
                getDriver().get("https://"+page+".com");
                break;
            default:
                //System.out.println("Unknown page");
                throw new Error("Unknown page: "+page);
        }
    }

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {

        switch (page){
            case "quote":
                new QuoteForm().open();
                break;
            case "ups":
                new UpsLanding().open();
                break;
            default:
                throw new Error("Unknown page: " + page);
        }
    }



    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        String url = getDriver().getCurrentUrl();
        System.out.println(url);
        Dimension mobile = new Dimension(400,800);
        getDriver().manage().window().setSize(mobile);
        //getDriver().manage().window().setSize(new Dimension(400,800));

    }

    @And("I go back and forward,then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() {
        for(LogEntry entry : getDriver().manage().logs().get("browser")){
            System.out.println(entry.getMessage());
        }
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String arg) throws InterruptedException {
        if(arg.equals("phone")){
            getDriver().manage().window().setSize(new Dimension(400, 768));
            Thread.sleep(3000);
        }else if(arg.equals("desktop")){
            //getDriver().manage().window().fullscreen();
            Dimension desk = new Dimension(1024, 768);
            getDriver().manage().window().setSize(desk);
            Thread.sleep(3000);
        } else{
            System.out.println("Unknown screen resolution");
        }
    }


}
