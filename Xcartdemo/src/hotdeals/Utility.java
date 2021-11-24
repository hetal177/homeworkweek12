package hotdeals;

import homepage.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Utility extends BaseTest {

    /*
     this method will click on element
     @param by
      */
    public void selectMenu(By by, String menu) {
        WebElement dropdown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByVisibleText(menu);


    }

    /*
    this method will get text fram element
    @pram by
    @return
     */
    public String getTextElement(By by) {
        return driver.findElement(by).getText();
       /* WebElement message = driver.findElement(by);
        String actualMessage = message.getText();
        return  actualMessage;*/
    }
    /*
    this method will send text on element
    @pram by
    @param text
     */

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //clickable
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void selectbytextfromdroupdown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByValue(text);

    }

    public void selectValueFromdropDown(By by, String value) {
        org.openqa.selenium.support.ui.Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public WebElement pageScrollInView(WebElement e) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", e);
        return e;
    }

    public void mouseHoverToClickElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }


    //header= element
    public void scrollTillElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public int randomNumber() {
// Generating random numbers
        Random random = new Random();
        int num =  random.nextInt(900) + 100;
        // generate a random integer from 0 to 899, then add 10
        return num;
    }

}







