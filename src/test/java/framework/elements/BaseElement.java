package framework.elements;

import framework.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement extends BaseEntity {

    private By locator;
    private WebElement element;
    private List<WebElement> list;
    private List<String> listOfContent = new ArrayList<>();
    private List<String> listOfAttribute = new ArrayList<>();


    public BaseElement(By locator) {
        this.locator = locator;
    }

    public BaseElement(WebElement element) {
        this.element = element;
    }

    public By getLocator() {
        return this.locator;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void sendKeys(String sendKeys) {
        if (isEnabled())
            getElement(this.locator).sendKeys(sendKeys);
    }

    public boolean isEnabled(){
        return getElement(this.getLocator()).isEnabled();
    }

    public List<String> getListOfContent() {
        for (WebElement element : getElements(this.getLocator())) {
            listOfContent.add(element.getText());
        }
        return listOfContent;
    }

    public List<String> getListOfAttribute(String attribute) {
        for (WebElement element : getElements(this.getLocator())) {
            listOfAttribute.add(element.getAttribute(attribute));
        }
        return listOfAttribute;
    }

    public String getText() {
        element = getElement(this.getLocator());
        if (element.isDisplayed())
            return element.getText();
        else return "could not return text";
    }

    public String getLink() {
        element = getElement(this.getLocator());
        if (element.isDisplayed())
            return element.getAttribute("href");
        else return "could not return link";
    }

    public void click() {
        element = getElement(this.getLocator());
        if (element.isEnabled())
            element.click();
    }

    public void clickAndWait() {
        element = getElement(this.getLocator());
        if (element.isEnabled())
            element.click();
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(configFile.getConfigProperty("timeOutMax")));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void clickViaAction(){
        if (isEnabled()) {
            Actions action = new Actions(driver);
            action.moveToElement(getElement(this.getLocator())).click().build().perform();
        }
    }

    public void moveToElement() {
        if (assertIsVisible()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(getElement(this.getLocator())).build().perform();
        }
    }

    public boolean assertIsVisible() {
        list = getElements(this.getLocator());
        return list.size() > 0;
    }

    public String getAttribute(String str){
        element = getElement(this.getLocator());
        if (element.isDisplayed())
            return element.getAttribute(str);
        else return "could not return attribute";
    }

    public void waitExplicit(){
        WebDriverWait wait = new WebDriverWait(driver, getTimeForLoadElement());
        wait.until(ExpectedConditions.presenceOfElementLocated(this.getLocator()));
    }

    public void waitBeClickable(){
        WebDriverWait myWaitVar = new WebDriverWait(driver,Long.parseLong(configFile.getConfigProperty("timeout")));
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(this.getLocator()));
    }

    public void waitLoadingPage(){
        try {
            Thread.sleep(Long.parseLong(configFile.getConfigProperty("threadTime")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Long getTimeForLoadElement(){
        return Long.parseLong(configFile.getConfigProperty("timeout"));
    }

}
