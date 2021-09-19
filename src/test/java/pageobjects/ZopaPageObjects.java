package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class ZopaPageObjects extends BasePage{
        public static final String PERSONALISEDBUTTON = "//button[@data-automation='ZA.button-personal-rate']";
        public static final String ACCEPTCOOKIES = "onetrust-close-btn-handler";

    public static void setPersonalisedButton(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        softAssert.assertThat(driver.findElement(By.xpath(PERSONALISEDBUTTON)));
        driver.findElement(By.xpath(PERSONALISEDBUTTON)).click();
    }

    public static void setAcceptcookies(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        softAssert.assertThat(driver.findElement(By.className(ACCEPTCOOKIES)));
        softAssert.assertThat(driver.findElement(By.className(ACCEPTCOOKIES)).isEnabled());
        driver.findElement(By.className(ACCEPTCOOKIES)).click();
    }


}
