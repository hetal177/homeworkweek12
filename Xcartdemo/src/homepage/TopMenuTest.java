package homepage;

import hotdeals.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility{
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {

        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']//span[contains(text(),'Shipping')]"));
        String expectedMessage = "Shipping";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Shippping", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'New!')]"));
        String expectedMessage = "New arrivals";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verifiction failed: Text-New arrivals ", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Coming soon')]"));

        String expectedMessage = "Coming soon";
        String actualMessage = getTextElement(By.id("page-title"));
        Assert.assertEquals("Verifiction failed: Coming soon ", expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        // This one keep failing
        clickOnElement(By.linkText("Contact us"));
        String expectedMessage = "Contact us";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verifiction failed: Contact us ", expectedMessage, actualMessage);

    }
}

