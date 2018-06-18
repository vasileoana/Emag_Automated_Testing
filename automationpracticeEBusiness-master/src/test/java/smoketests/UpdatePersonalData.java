package smoketests;

import config.Config;
import config.Environment;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContulMeuPage;
import pages.LoginPage;
import utils.WebActions;


public class UpdatePersonalData {

    String name;
    String nickname;

    @Test
    public void UpdatePersonalData() throws InterruptedException {
        WebActions.clickElem(LoginPage.goToLogin(), 20);
        LoginPage.email().sendKeys("vasileoana22@gmail.com");
        WebActions.clickElem(LoginPage.goContinue(), 20);
        LoginPage.password().click();
        LoginPage.password().sendKeys("iwannago22");
        WebActions.clickElem(LoginPage.goContinue(), 20);
        WebActions.clickElem(ContulMeuPage.goToContulMeuPage(), 60);
        name = ContulMeuPage.name().getText();
        nickname = ContulMeuPage.nickname().getText();
        WebActions.clickElem(ContulMeuPage.goToEditeazaDatele(), 20);
        ContulMeuPage.editName().sendKeys("0");
        ContulMeuPage.editNickname().sendKeys("0");
        WebActions.clickElem(ContulMeuPage.goToSalveaza(), 20);

        Assert.assertEquals(ContulMeuPage.name().getText(),name+"0");
        Assert.assertEquals(ContulMeuPage.nickname().getText(),nickname+"0");
        Assert.assertTrue(ContulMeuPage.goToEditeazaDatele().isDisplayed());
        Assert.assertTrue(ContulMeuPage.goToEditeazaDatele().isEnabled());
        Assert.assertNull(ContulMeuPage.goToSalveaza());
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


        // Close the driver
        Config.closeDriver();
    }

}
