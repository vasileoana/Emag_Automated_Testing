package pages;

import config.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.WebActions;

import java.util.List;

public class HomePage {

    public static WebElement goToProduct(){
        List<WebElement> products = WebActions.findElemList(".product-title", "css",50);
        return products.get(0);
    }

    public static WebElement searchBox(){
        return WebActions.findElem("searchboxTrigger","id",60);
    }
    public static WebElement search(){
        return WebActions.findElem(".searchbox-submit-button","css",60);
    }


}
