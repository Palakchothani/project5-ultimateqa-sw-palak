package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility
{
    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a[1]"));


        ////h1[@class='page__heading']
        String expectMessage= "Welcome Back!";
        //Find the login button and click on it

        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualMessage = actualTextMessageElement.getText();


        //validate actual and expected message
        // Assert.assertEquals("",expectMessage,actualMessage);
        Assert.assertEquals("",expectMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){

        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']/a[1]"));

        //enter invalid username
        sendTextToElement(By.id("user[email]"),"palakchothani11@gmail.com");

        //Enter password
        sendTextToElement(By.id("user[password]"),"Palak1999");

        clickOnElement(By.xpath("//input[@type='submit']"));

        String expectMessage= "Invalid email or password.";

        //Find the login button and click on it

        WebElement actualTextMessageElement = driver.findElement(By.xpath("//li[contains(@class,'__list-item')]"));
        String actualMessage = actualTextMessageElement.getText();


        //validate actual and expected message
        Assert.assertEquals("",expectMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
