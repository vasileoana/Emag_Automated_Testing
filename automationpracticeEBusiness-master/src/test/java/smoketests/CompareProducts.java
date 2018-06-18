package smoketests;

import config.Config;
import config.Environment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ComparaProdusePage;
import pages.HomePage;
import pages.ListareProdusePage;
import utils.WebActions;

//INTREBARE FAC TESTELE TOATE SI APOI INCHID DRIVERUL SAU PT FIECARE TEST DESCHID DRIVERUL FAC TESTUL S APOI INCHID?
public class CompareProducts {

    @Test
    public void CompareProducts() throws InterruptedException {
       HomePage.searchBox().sendKeys("laptop");
        WebActions.clickElem(HomePage.search(),60);
        //check
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(0),60);
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(1),60);
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(2),60);

        //click to compare
        WebActions.clickElem(ListareProdusePage.goToCompara(),60);
        String titlu = ComparaProdusePage.title().getText();
        Assert.assertEquals(titlu, "Compară produse");


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
        //go back
       Config.getDriver().navigate().back();
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(0),60);
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(1),60);
        WebActions.clickElem(ListareProdusePage.checkOrUneckCompare(2),60);
        // Close the driver
        Config.closeDriver();
    }

}
