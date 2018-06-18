package smoketests;

import config.Config;
import config.Environment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utils.WebActions;

public class AddProductToFavorite {

    int pozProdus = -1;
    @Test
    public void AddToFavorites() throws InterruptedException {

        WebActions.clickElem(LoginPage.goToLogin(), 10);
        LoginPage.email().sendKeys("vasileoana22@gmail.com");
        WebActions.clickElem(LoginPage.goContinue(), 10);
        LoginPage.password().click();
        LoginPage.password().sendKeys("iwannago22");
        WebActions.clickElem(LoginPage.goContinue(), 10);

        HomePage.searchBox().sendKeys("laptop");
        WebActions.clickElem(HomePage.search(),60);
        JavascriptExecutor js = (JavascriptExecutor) Config.getDriver();
        js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ListareProdusePage.goToProductTitle(0));

        String title = ProductPage.getProductTitle();

        //like
        Actions action = new Actions(Config.getDriver());
        action.moveToElement(ProductPage.goToFavoritesButton()).build().perform();
       // WebActions.clickElem(ProductPage.goToFavoritesButton(),60);
         js = (JavascriptExecutor) Config.getDriver();
        js.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", ProductPage.goToFavoritesButton());
        Assert.assertTrue(ProductPage.isFavortesSymbolActive());
        WebActions.clickElem(FavoritesPage.goToFavorites(), 60);
        pozProdus = FavoritesPage.existaProdusul(title);
        Assert.assertNotEquals(pozProdus, -1);
    }

    @BeforeMethod
    public void beforeMethod()  {
        // Set Driver
        new Config("chrome");

        //Set Environment
        Config.loadURL(Environment.env);


    }



    @AfterMethod
    public void afterMethod(ITestResult result) {
        //in the list of the products remove the one just added

        WebActions.clickElem(FavoritesPage.getCheckboxForDelete(pozProdus),60);
        WebActions.clickElem(FavoritesPage.goToDelete(),60);

        Config.getDriver().close();
    }
//bug alert adagi produs te intorci la el si nu apare inimioara



}
