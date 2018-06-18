package pages;

import org.openqa.selenium.WebElement;
import utils.WebActions;

public class LoginPage {

    public static WebElement email() throws InterruptedException {
        return WebActions.findElem("email", "id",  60);
    }

    public static WebElement password() throws InterruptedException {
        return WebActions.findElem("password", "id",  60);
    }


    public static WebElement goContinue() throws InterruptedException {
        return WebActions.findElem(".auth-btn-primary","css",60);
    }

    public static WebElement goToLogin() throws InterruptedException {
        return WebActions.findElem("my_account","id",60);
    }


}
