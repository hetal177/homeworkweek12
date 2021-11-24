package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.cssSelector("li[class='leaf has-sub'] li:nth-child(1) a:nth-child(1)"));

        String expectedMessage = "Sale";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Sale", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));

        String expectedFirstDisplayMsg = "Name A - Z";
        String actualFirstDisplayMsg = getTextElement(By.xpath("//span[text()='Name A - Z']"));
        Assert.assertEquals("products are  In Alphabetical Order",expectedFirstDisplayMsg,actualFirstDisplayMsg);

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.cssSelector("li[class='leaf has-sub'] li:nth-child(1) a:nth-child(1)"));

        String expectedMessage = "Sale";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Sale", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Price Low - High']"));

        String expectedSortByMsg = "Price Low - High";
        String actualSortByMsg = getTextElement(By.xpath("//span[text()='Price Low - High']"));
        Assert.assertEquals("Products Are Not Sorted In price Low to High",expectedSortByMsg,actualSortByMsg);

    }

    @Test
    public void vefirySalesProductsArrangedByRates() {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.cssSelector("li[class='leaf has-sub'] li:nth-child(1) a:nth-child(1)"));

        String expectedMessage = "Sale";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Sale", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Rates']"));

        String expectedSortByMsg = "Rates";
        String actualSortByMsg = getTextElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.linkText("Bestsellers"));

        String expectedMessage = "Bestsellers";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name Z - A']"));

        String expectedSortByMsg = "Name Z - A";
        String actualSortByMsg = getTextElement(By.xpath("//span[text()='Name Z - A']"));
        Assert.assertEquals("Products Are Not Sorted In Rates", expectedSortByMsg, actualSortByMsg);

    }
@Test
    public void verifyBestSellerProductsPriceArrangeHighToLow(){
    mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
    clickOnElement(By.linkText("Bestsellers"));

    String expectedMessage = "Bestsellers";
    String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
    Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);
    mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
    clickOnElement(By.xpath("//a[normalize-space()='Price High - Low']"));

    String expectedSortByMsg = "Price High - Low";
    String actualSortByMsg = getTextElement(By.xpath("//span[text()='Price High - Low']"));
    Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);

}
@Test
public void verifyBestSellersProductsArrangeByRates(){
    mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
    clickOnElement(By.linkText("Bestsellers"));
    String expectedMessage = "Bestsellers";
    String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
    Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);
    mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
    clickOnElement(By.xpath("//a[normalize-space()='Rates']"));
    String expectedSortByMsg = "Rates";
    String actualSortByMsg = getTextElement(By.xpath("//span[text()='Rates ']"));
    Assert.assertEquals("Products Are Not Sorted In Rates",expectedSortByMsg,actualSortByMsg);

}
@After
    public void tearDown(){
        closeBrowser();
}
}

