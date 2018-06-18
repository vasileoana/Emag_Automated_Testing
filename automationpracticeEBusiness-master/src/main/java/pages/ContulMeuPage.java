package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebActions;
import config.Config;

import java.util.List;


public class ContulMeuPage {

    public static List<WebElement> elementsDetails = null;

    public static WebElement goToContulMeuPage() throws InterruptedException {
        return WebActions.findElem("[href=\"/user/account?ref=ua_personal_data\"]","css",60);
    }


    public static WebElement goToDateleMelePage() throws InterruptedException{

        return WebActions.findElem("[href=\"/user/account\"]","css",60);
    }

    public static WebElement goToEditeazaDatele() throws InterruptedException{
        List<WebElement> elem =  Config.getDriver().findElements(By.className("edit_details"));
        for(WebElement e : elem){
            //if(e.getClass().)
        }
        return elem.get(0);
    }

    public static WebElement goToSalveaza() throws InterruptedException{
        List<WebElement> elem =  Config.getDriver().findElements(By.className("btn-save-details"));
        if (elem !=null && elem.size() != 0) {
            return elem.get(0);
        }
        else return null;
    }



    public static WebElement editName() {
        return WebActions.findElem("[name=\"name\"]", "css", 60);

    }

    public static WebElement editNickname() {
        return WebActions.findElem("[name=\"nickname\"]", "css", 60);
    }

    public static WebElement name(){
        elementsDetails =  WebActions.findElemList(".details-display", "css",60);;
        return elementsDetails.get(1);
    }

    public static WebElement nickname() {
        elementsDetails =  WebActions.findElemList(".details-display", "css",60);;
        return elementsDetails.get(2);
    }

}
