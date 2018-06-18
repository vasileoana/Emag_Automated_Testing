package smoketests;

import config.Config;
import config.Environment;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FavoritesPage;
import pages.LoginPage;
import utils.WebActions;

public class xDeleteProductFromFavorite {
    @Test
    public void deleteFromFavorites() throws InterruptedException {
        WebActions.clickElem(LoginPage.goToLogin(), 10);
        LoginPage.email().sendKeys("vasileoana22@gmail.com");
        WebActions.clickElem(LoginPage.goContinue(), 10);
        LoginPage.password().click();
        LoginPage.password().sendKeys("iwannago22");
        WebActions.clickElem(LoginPage.goContinue(), 10);

        WebActions.clickElem(FavoritesPage.goToFavorites(), 20);

        int nrProduseInainte = Integer.valueOf(FavoritesPage.getNrProduseFavorite().getText());

        WebActions.clickElem(FavoritesPage.getCheckboxForDelete(0),60);
        WebActions.clickElem(FavoritesPage.goToDelete(),60);

       // Assert.assertTrue(FavoritesPage.produsulEsteSters(titlulDeSters));
        int nrProduseDupa =Integer.valueOf(FavoritesPage.getNrProduseFavorite().getText());

        //DECOMMENT TO SEE THE BUG
        Assert.assertEquals(nrProduseDupa, nrProduseInainte-1);

    }

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        // Set Driver
        new Config("chrome");
        //Set Environment
        Config.loadURL(Environment.env);
    }

    @AfterTest
    public void afterTest(ITestResult result) {


        // Close the driver
        Config.closeDriver();
    }

}
