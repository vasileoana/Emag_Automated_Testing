package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebActions;

import java.util.List;

public class ListareProdusePage {


    public static WebElement checkOrUneckCompare(int index){
        List<WebElement>  compareButtons = WebActions.findElemList(".card-compare-btn", "css", 60);
        return compareButtons.get(index);
    }

    public static WebElement goToProductTitle(int index){
        List<WebElement>  titles = WebActions.findElemList(".card-section-mid", "css", 60);
        return titles.get(index);
    }



    public static WebElement goToCompara(){
       return WebActions.findElem("compare-link", "id", 60);

    }


}
