package starter.Pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.service.nsw.gov.au/")
public class HomePage extends PageObject {
    @Managed
    WebDriver driver = getDriver();
    private final By homeSearch = By.xpath("//*[@id=\"homeautosuggestJLXw6HUDAvI\"]/input");
    private final By homeSearchButton = By.xpath("//*[@id=\"block-content\"]/article/section[1]/div/div[1]/header/div[2]/div/form/div[2]/button");
    private final By serviceName = By.linkText("Apply to collect number plates from another service centre");
    private final By findService = By.xpath("//*[@id=\"block-content\"]/div/div/div/a");
    private final By searchLocation = By.id("locatorTextSearch");
    private final By findLocationButton = By.xpath("//*[@id=\"locator\"]/div/form/div/div/div[2]/div/button");
    private final By zoomOut = By.xpath("//*[@id=\"locatorMapView\"]/div/div[1]/div/div/div/div/div[13]/div/div[3]/div/button[2]");
    private final By pageHeader = By.id("page-title");

    public void InputService(String service){
        driver.findElement(homeSearch).clear();
        driver.findElement(homeSearch).sendKeys(service);
    }
    public void clickSearch(){
        driver.findElement(homeSearchButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(serviceName).click();

    }
    public void servicePageButton(){
        driver.findElement(findService).click();
    }
    public void inputFieldLocation(String location){
        driver.findElement(searchLocation).clear();
        driver.findElement(searchLocation).sendKeys(location);
    }
    public void findLocation(){
        driver.findElement(findLocationButton).click();
        driver.findElement(zoomOut).click();
    }
    public void getServiceCenter(String location){
        driver.findElement(By.linkText(location)).click();
    }
    public String getHeaderTittle(){
        return driver.findElement(pageHeader).getText();
    }

}
