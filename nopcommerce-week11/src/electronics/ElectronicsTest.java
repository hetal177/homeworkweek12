package electronics;

import homepage.Utility;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


    public class ElectronicsTest extends Utility {
        String baseUrl = "https://demo.nopcommerce.com/";
        //WebDriver driver;


        @Before
        public void setUp() {
            openBrowser(baseUrl);

        }

        @Test
        public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
            mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
            mouseHoverToClickElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
            String expectedResult = "Cell phones";
            WebElement Actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
            String realMsg = Actualresult.getText();
            Assert.assertEquals("Verify the text is not match", expectedResult, realMsg);
        }

        @Test
        public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
            mouseHoverToElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
            mouseHoverToClickElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
            Thread.sleep(2000);
            String expectedResult = "Cell phones";
            WebElement Actualresult = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
            String realMsg = Actualresult.getText();
            Assert.assertEquals("Verify the text is not match", expectedResult, realMsg);
            clickOnElement(By.xpath("//a[contains(text(),'List')]"));
            Thread.sleep(2000);
            clickOnElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
            String expectedText = "Nokia Lumia 1020";
            WebElement ActualText = driver.findElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
            String RealText = ActualText.getText();
            Assert.assertEquals("Verify the text is not match", expectedText, RealText);
            String expectedPrice = "$349.00";
            WebElement ActualPrice = driver.findElement(By.xpath("//span[@id='price-value-20']"));
            String RealPrice = ActualPrice.getText();
            Assert.assertEquals("Verify the text is not match", expectedPrice, RealPrice);
            driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
            driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
            clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
            //The product has been added to your shopping cart
            String expectedProductAdd = "The product has been added to your shopping cart";
            WebElement ActualProductAdd = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
            String RealProductAdd = ActualProductAdd.getText();
            Assert.assertEquals("Verify the text is not match", expectedProductAdd, RealProductAdd);
            clickOnElement(By.xpath("//span[@class='close']"));
            Thread.sleep(2000);
            mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
            clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
            String expectedShoppingCart = "Shopping cart";
            WebElement ActualshoppingCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            String RealshoppingCart = ActualshoppingCart.getText();
            Assert.assertEquals("Verify the text is not match", expectedShoppingCart, RealshoppingCart);
            String expecteditemQuantity = "(2)";
            WebElement ActualitemQuantity = driver.findElement(By.xpath("//span[@class='cart-qty']"));
            String RealitemQuantity = ActualitemQuantity.getText();
            Assert.assertEquals("Verify the value is not match", expecteditemQuantity, RealitemQuantity);
            String expectedtotal = "$698.00";
            WebElement ActualTotal = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
            String RealTotal = ActualTotal.getText();
            Assert.assertEquals("Verify the value is not match", expectedtotal, RealTotal);
            Thread.sleep(2000);
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            clickOnElement(By.xpath("//button[@id='checkout']"));
            String expectedText1 = "Welcome, Please Sign In!";
            WebElement ActualText1 = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
            String RealText1 = ActualText1.getText();
            Assert.assertEquals("Verify the text is not match", expectedText1, RealText1);
            clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
            String expectedText2 = "Register";
            WebElement ActualText2 = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
            String RealText2 = ActualText2.getText();
            Assert.assertEquals("Verify the value is not match", expectedText2, RealText2);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Sitaben");
            driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("patel");
            // driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Automation_" + Number(1, 1000).ToString() + "_" + driver.RandomString(4) + "@gmail.com"););
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("ravan1234@yahoo.com");
            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abcdef");
            driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("abcdef");
            clickOnElement(By.xpath("//button[@id='register-button']"));
            String expectedRegister = "Your registration completed";
            WebElement ActualRegister = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
            String RealRegister = ActualRegister.getText();
            Assert.assertEquals("Registration is not Completed", expectedRegister, RealRegister);
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
            String expectedShopCart = "Shopping cart";
            WebElement ActualShopCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
            String RealshopCart = ActualShopCart.getText();
            Assert.assertEquals("Registration is not Completed", expectedShopCart, RealshopCart);
            clickOnElement(By.xpath("//input[@id='termsofservice']"));
            clickOnElement(By.xpath("//button[@id='checkout']"));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("RRk");
            selectValueFromdropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "123");
            selectValueFromdropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "0");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Harrow");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("420");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).sendKeys("Rayners Road");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("ha5 5dp");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("07832446565");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']")).sendKeys("0208757577");
            clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
            clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
            clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
            clickOnElement(By.cssSelector("#paymentmethod_1"));
            clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
            Thread.sleep(1000);

            selectValueFromdropDown(By.id("CreditCardType"), "visa");
            sendTextToElement(By.id("CardholderName"), "Mrs.R Sita");
            sendTextToElement(By.id("CardNumber"), "4539926921009583");
            selectValueFromdropDown(By.id("ExpireMonth"), "8");
            selectValueFromdropDown(By.id("ExpireYear"), "2025");
            sendTextToElement(By.id("CardCode"), "449");
            clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
            Thread.sleep(2000);
            String expectedCreditCard = "Credit Card";
            WebElement ActualCreditCard = driver.findElement(By.xpath("//span[normalize-space()='Credit Card']"));
            String RealCreditCard = ActualCreditCard.getText();
            Assert.assertEquals("Verification failed", expectedCreditCard, RealCreditCard);
            String expectDayAir = "(2nd Day Air)";
            WebElement ActualdayAir = driver.findElement(By.xpath("//span[@class='selected-shipping-method']"));
            String RealDayAir = ActualdayAir.getText();
            Assert.assertEquals("Verification failed for 2nd Day Air", expectDayAir, RealDayAir);
            String expectvalue = "$698.00";
            Thread.sleep(2000);
            WebElement Actualvalue = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$698.00')]"));
            String Realvalue = Actualvalue.getText();
            Assert.assertEquals("Verification failed", expectvalue, Realvalue);
            clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
            String expectThank = "Thank you";
            WebElement ActualThank = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']"));
            String RealThank = ActualThank.getText();
            Assert.assertEquals("Verification failed", expectThank, RealThank);
            String expectSuccess = "Your order has been successfully processed!";
            WebElement ActualSuccess = driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
            String RealSuccess = ActualSuccess.getText();
            Assert.assertEquals("Verification failed-", expectSuccess, RealSuccess);
            Thread.sleep(1000);
            clickOnElement(By.xpath("//button[@onclick='setLocation(\"/\")']"));  //last continue click
            String expectedWelcomeMessageShown = "Welcome to our store";
            String actualWelcomeMessageShown = getTextElement(By.xpath("//h2[text()='Welcome to our store']"));
            Assert.assertEquals("User is not on main page", expectedWelcomeMessageShown, actualWelcomeMessageShown);

            clickOnElement(By.xpath("//a[@class='ico-logout']"));
            String url = "https://demo.nopcommerce.com/";
            String realUrl = driver.getCurrentUrl();
            Assert.assertEquals("Wrong Url", url, realUrl);

        }
public void teardown(){
            closeBrowser();
}
    }

