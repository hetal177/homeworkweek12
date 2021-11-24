package shopping;

import hotdeals.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.cssSelector("li[class='leaf has-sub'] li:nth-child(1) a:nth-child(1)"));

        String expectedMessage = "Sale";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Sale", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(2000);
        //?add to cart

        mouseHoverToElement(By.xpath("//a[contains(text(),'Avengers: Fabrikations Plush')]/parent::h5/following-sibling::div//button"));
        Thread.sleep(5000);
        clickOnElement(By.xpath("(//span[text()='Add to cart'])[1]"));
        //clickOnElement(By.xpath("//img[@class='photo ls-is-cached lazyloaded']"));
        // clickOnElement(By.xpath("//div[@class='add-button-wrapper widget-fingerprint-product-add-button']//button[@type='submit']"));
        Thread.sleep(2000);


        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextElement(By.xpath("//li[text()='Product has been added to your cart']"));
        System.out.println(actualMsg);
        Assert.assertEquals("Verification failed for Text : Product has been added to your cart", expectedMsg, actualMsg);

//to close pop up
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//div[@class='lc-minicart lc-minicart-horizontal collapsed recently-updated']"));//your cart
        clickOnElement(By.xpath("//span[normalize-space()='View cart']"));// view cart
//verfy message
        String expectedMsgcart = "Your shopping cart - 1 item";
        String actualMsgcart = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 1 item", expectedMsgcart, actualMsgcart);
        clickOnElement(By.cssSelector("#amount16")); //qnty box
        driver.findElement(By.id("amount16")).clear();// clear qty box
        Thread.sleep(2000);
        driver.findElement(By.id("amount16")).sendKeys("2");
        //verfy cart qty2
        String expectedMsgcart2 = "Your shopping cart - 2 items";
        String actualMsgcart2 = getTextElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 2 items", expectedMsgcart2, actualMsgcart2);

//verify subtotal
        String expectedTotal = "Subtotal:\n$29.98";
        String actualTotal = getTextElement(By.xpath("//ul[@class='totals']//li[@class='subtotal']"));
        Assert.assertEquals("Verification failed for Text : Subtotal: $29.98", expectedTotal, actualTotal);

        String totalAmount = "$36.00";                     //verify Total
        String realTotalAmount = getTextElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Is Incorrect", totalAmount, realTotalAmount);


        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));
        String expectedloginmsg = "Log in to your account";
        String actualloginmsg = getTextElement(By.xpath("//h3[normalize-space()='Log in to your account']"));
        Assert.assertEquals("Verification failed for Text : Log in to your account", expectedloginmsg, actualloginmsg);
        String email = "ram" + randomNumber() + "@yahoo.com";
        sendTextToElement(By.xpath("//input[@id='email']"), email);
        clickOnElement(By.xpath("//span[normalize-space()='Continue']"));

        String expectedchkmsg = "Secure Checkout";
        String actualchkmsg = getTextElement(By.xpath("//h1[normalize-space()='Secure Checkout']"));
        Assert.assertEquals("Verification failed for Text :  Secure Checkout", expectedchkmsg, actualchkmsg);

        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "ram");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "ravan");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "402 Mandodri street");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"), "Lanka");
        selectValueFromdropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "FR");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Ramrajya");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "Ha2 8bl");
        clickOnElement(By.xpath("//input[@id='create_profile']")); // checkbox
        sendTextToElement(By.xpath("//input[@id='password']"), "SitaRam1234");
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//h1[text()=' Secure Checkout']"));
        scrollTillElement(header);
        Thread.sleep(5000);
        clickOnElement(By.xpath("//input[@id='method128']"));
        //  mouseHoverToClickElement(By.xpath("//input[@name='methodId'][@value='128']"));


        // mouseHoverToElement(By.xpath("//input[@type='radio' and @id='method128']"));
        //mouseHoverToClickElement(By.xpath("//input[@type='radio' and @id='method128']"));
        //clickOnElement(By.xpath("//input[@type='radio' and @id='method128']"));
        //WebElement checkbox = driver.findElement(By.xpath("//label[@title='Local shipping']/parent::div"));
        //  pageScrollInView(checkbox);
        // clickOnElement(By.xpath("//label[@title='Local shipping']/parent::div"));

        clickOnElement(By.xpath("//span[normalize-space()='Place order: $37.03']"));
        String expectedThkmsg = "Thank you for your order";
        String actualThkmsg = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Thank you for your order", expectedThkmsg, actualThkmsg);
    }


    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        clickOnElement(By.linkText("Bestsellers"));
        String expectedMessage = "Bestsellers";
        String actualMessage = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Bestsellers", expectedMessage, actualMessage);

        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[normalize-space()='Name A - Z']"));

        //add to cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button add2cart submit']"));

        // clickOnElement(By.xpath("//a[contains(@class,'product-thumbnail next-previous-assigned')]//img[contains(@alt,'Vinyl Idolz: Ghostbusters')]"));
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        //green message

        String expectedMsg = "Product has been added to your cart";
        String actualMsg = getTextElement(By.xpath("//li[@class='info']"));
        Assert.assertEquals("Verification failed for Text : Product has been added to your cart", expectedMsg, actualMsg);
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));

        clickOnElement(By.xpath("//a[@class='regular-button cart']"));

        String expectedMsgcart = "Your shopping cart - 1 item";
        String actualMsgcart = getTextElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Verification failed for Text : Your shopping cart - 1 item", expectedMsgcart, actualMsgcart);
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));

        String emptyCartMsg = "Are you sure you want to clear your cart?";
        String realEmptyCartMsg = driver.switchTo().alert().getText();//to get text which we can not inspect
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartMsg, realEmptyCartMsg);
        driver.switchTo().alert().accept();//when ok is also not inspected
        String empryCartMsg = "Item(s) deleted from your cart";
        //checking green bar message
        String actualEmptyCartMsgIs = getTextElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Customer's Cart Is Not Empty", empryCartMsg, actualEmptyCartMsgIs);
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = getTextElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Your  empty cart message is wrong", lastEmptyCartMessage, actualLastEmptyCartMessage);
        closeBrowser();

    }


}

