package smoketests;

import config.Config;
import config.Environment;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContulMeuPage;
import pages.LoginPage;
import utils.WebActions;

public class Login {
    @Test
    public void Login() throws InterruptedException {
        WebActions.clickElem(LoginPage.goToLogin(), 10);
        LoginPage.email().sendKeys("vasileoana22@gmail.com");
        WebActions.clickElem(LoginPage.goContinue(), 10);
        LoginPage.password().click();
        LoginPage.password().sendKeys("iwannago22");
        WebActions.clickElem(LoginPage.goContinue(), 10);
        String url = Config.getDriver().getCurrentUrl().toString();
        Assert.assertEquals(url, "https://www.emag.ro/homepage");
    }
    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        // Set Driver
        new Config("chrome");

        //Set Environment
        Config.loadURL(Environment.env);


    }

    @AfterMethod
    public void afterMethod(ITestResult result) {


        // Close the driver
        Config.closeDriver();
    }

}
