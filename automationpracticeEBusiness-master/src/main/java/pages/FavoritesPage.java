package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebActions;

import java.util.List;

public class FavoritesPage {

      public static WebElement goToFavorites(){

        return WebActions.findElem("my_wishlist","id",60);
    }

    public static WebElement deleteProduct(int index){
          List<WebElement> favoritesDeleteContainers = WebActions.findElemList(".wl-container-btn-delete", "css",60);
          return favoritesDeleteContainers.get(index);
    }

    public static WebElement getSuccesMessageAfterDelete(){

        return WebActions.findElem(".notificationSuccessContainer","css",60);
    }


    public static WebElement getNrProduseListaFavorite(){

        return WebActions.findElem(".wl-prod-no","css",60);
    }


    public static int findNrProduseFavorite(String text){
            return Integer.valueOf(text);
    }
    public static WebElement getNrProduseFavorite(){

        return WebActions.findElem(".emg-fluid-notification","css",60);
    }

    public static String getProdusTitluDeSters(int index){
        List<WebElement> titluriFavorite =   WebActions.findElemList(".product-title", "css",50);
        return titluriFavorite.get(index).getText();
    }

    public static boolean produsulEsteSters(String titlulSters){
        List<WebElement> titluriFavorite =   WebActions.findElemList(".product-title", "css",50);
       for(WebElement titlu : titluriFavorite){
           if(titlu.getText().contains(titlulSters))
               return false;
       }
       return true;
    }

    public static int existaProdusul(String titlulDeVerificat){
        List<WebElement> titluriFavorite =   WebActions.findElemList(".product-title", "css",50);
        for(int i=0; i<titluriFavorite.size(); i++){
            WebElement ancora = titluriFavorite.get(i).findElement(By.tagName("a"));
            String titlu2 = ancora.getAttribute("title");
            if(titlu2.equalsIgnoreCase(titlulDeVerificat))
                return i;
        }
        return -1;
    }
    //inimioara are clasa em-fav daca nu e adaugat si class em-fav-fill daca e adaugat

    public static WebElement goToProductAddedInFavorites(int poz){
        List<WebElement> titluriFavorite =   WebActions.findElemList(".product-title", "css",50);
        return titluriFavorite.get(poz).findElement(By.tagName("a"));

    }

    public static WebElement getCheckboxForDelete(int poz){
        List<WebElement> titluriFavorite =   WebActions.findElemList(".fa", "css",50);
        return titluriFavorite.get(poz).findElement(By.tagName("label"));

    }

    public static WebElement goToDelete(){
       return  WebActions.findElem("removeFromWishlist", "id",50);


    }
}
