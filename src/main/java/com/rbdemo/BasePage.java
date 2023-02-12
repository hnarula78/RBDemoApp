package com.rbdemo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait waitDriver = null;
    public int waitTime;

    public void setText(String object, String text, String objectName) {
        try {
            waitForElementToBeVisible(object);
            WebElement elm = driver.findElement(By.xpath(object));
            if (!text.equals("")) {
              //  elm.click();
                sleep(1);
                elm.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
                elm.clear();
                elm.sendKeys(text);
                sleep(2);
            }
            System.out.println("Entered text " + text + " in field " + objectName);
        } catch (Exception e) {
            System.out.println("Exception caught in 'Set Text' method. Exception Message : " + e.getMessage());
        }
    }


    public void verifyElementPresent(String locator) {
        try {
            waitForElementToBeVisible(locator);
            if (driver.findElement(By.xpath(locator)).isDisplayed())
                System.out.println("Element with Locator : " + locator + " is displayed");
            else
                System.out.println("Element with Locator : " + locator + " is not displayed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void waitForElementToBeVisible(String locator) {
        waitDriver = new WebDriverWait(driver, waitTime);
        waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    public void clickElement(String locator) {
        try {
            sleep(1);
            WebElement element = driver.findElement(By.xpath(locator));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }catch(InterruptedException ioex){
            System.out.println("Could not click Element " + ioex.getLocalizedMessage());

        }
    }


    public String getMessage(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        String msg = element.getText();
        return msg;
    }
}