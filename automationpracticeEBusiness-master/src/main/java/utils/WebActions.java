package utils;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class WebActions {
    public static WebElement findElem(String locator, String type, int timeout) {
        WebElement locate = null;
        try {
            switch (type) {
                case "name":
                    locate = waitForElement(By.name(locator), timeout);
                    break;
                case "linkText":
                    locate = waitForElement(By.linkText(locator), timeout);
                    break;
                case "tagName":
                    locate = waitForElement(By.tagName(locator), timeout);
                    break;
                case "id":
                    locate = waitForElement(By.id(locator), timeout);
                    break;
                case "xpath":
                    locate = waitForElement(By.xpath(locator), timeout);
                    break;
                case "css":
                    locate = waitForElement(By.cssSelector(locator), timeout);
                    break;
                default:
                    locate = null;
                    System.out.println("Couldn't find element with locator: " + locator + " by " + type
                            + ". Enter a valid selector type");
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return locate;
    }


    public static List<WebElement> findElemList(String locator, String type, int waitTime) {
        By locate;
        List<WebElement>validate;
        switch (type) {
            case "name":
                locate = By.name(locator);
                break;
            case "tagName":
                locate = By.tagName(locator);
                break;
            case "linkText":
                locate = By.linkText(locator);
                break;
            case "id":
                locate = By.id(locator);
                break;
            case "xpath":
                locate =By.xpath(locator);
                break;
            case "css":
                locate = By.cssSelector(locator);
                break;
            default:
                locate = null;
                System.out.println("Couldn't find list of elements with locator: " + locator + "by" + type
                        + ". Enter a valid selector type");
        }
        // Wait for all elements to be visible
        WebDriverWait wait = new WebDriverWait(Config.getDriver(),waitTime);
        validate = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locate));

        return validate;
    }

    public static void clickElem(WebElement element,int timeout) throws NoSuchElementException {
        System.out.println("Waiting for max: " + timeout + " seconds for element " + element.toString() + " to be clickable");
        WebDriverWait wait = new WebDriverWait(Config.getDriver(), timeout);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("Element is clickable: " + element.toString());
        element.click();
        //element.sendKeys(Keys.RETURN);
        System.out.println("Element clicked!");
    }

    // Wait Method getting a locator and a max time before failing a test
    public static WebElement waitForElement(By locator, int timeout) {
        WebElement element = null;
        try {
            System.out.println("Waiting for max:: " + timeout + " seconds for element to be available");
            WebDriverWait wait = new WebDriverWait(Config.getDriver(), timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element found on the page");
        } catch (Exception e) {

            System.out.println("Element not found on the page :)" + locator);
        }
        return element;
    }

}
