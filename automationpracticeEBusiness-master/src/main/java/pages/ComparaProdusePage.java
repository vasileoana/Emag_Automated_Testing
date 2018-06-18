package pages;

import org.openqa.selenium.WebElement;
import utils.WebActions;


public class ComparaProdusePage {


    public static WebElement title() throws InterruptedException {
        return WebActions.findElem(".page-title","css",60);
    }

}
