package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebActions;

public class ProductPage {
    public static WebElement goToFavoritesButton(){
        return WebActions.findElem(".add-to-favorites","css",60).findElement(By.tagName("span"));
    }

    public static boolean isFavortesSymbolActive(){
        try {
            WebElement favoriteHeart = WebActions.findElem(".add-to-favorites-active", "css", 60);
            if(favoriteHeart.isDisplayed()) return true;
            else return false;
        } catch(Exception ex) {
            return false;
        }
    }

    public static String getProductTitle(){

            WebElement productTitle = WebActions.findElem(".page-title", "css", 60);
           return productTitle.getText();
    }

}
