package homepage;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    public void selectMenu(String menu) {
        menu = "Computers";
        openBrowser(baseUrl);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }

    @Test
    public void veryFyPageNavigation() {
        selectMenu("Computers");
        String expectedTab = "Computers";
        WebElement tab = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualTab = tab.getText();
        Assert.assertEquals("user is not on page", expectedTab, actualTab);

    }
}