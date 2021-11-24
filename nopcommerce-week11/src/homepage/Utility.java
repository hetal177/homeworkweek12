package homepage;

import computer.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /*
   this method will click on element
   @param by
    */
    public void selectMenu(By by,String menu) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
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
    public void selectbytextfromdroupdown(By by,String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(text);

    }
    public void selectValueFromdropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
    public void mouseHoverToClickElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }



}